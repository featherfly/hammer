
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.SqlUtils;
import cn.featherfly.common.exception.UnsupportedException;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePaginationResults;
import cn.featherfly.hammer.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.QueryConditionGroupLogicExpression;
import cn.featherfly.hammer.dsl.query.QuerySortExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.mapping.ClassMapping;
import cn.featherfly.hammer.mapping.RowMapper;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.mapping.ClassMappingUtils;
import cn.featherfly.hammer.sqldb.sql.dml.AbstractSqlConditionGroupExpression;
import cn.featherfly.hammer.sqldb.sql.dml.builder.SqlSortBuilder;

/**
 * <p>
 * sql condition group builder sql条件逻辑组构造器
 * </p>
 *
 * @author zhongj
 */
public class SqlQueryConditionGroupExpression extends
        AbstractSqlConditionGroupExpression<QueryConditionGroupExpression, QueryConditionGroupLogicExpression>
        implements QueryConditionGroupExpression,
        QueryConditionGroupLogicExpression, QuerySortExpression {

    private SqlSortBuilder sortBuilder = new SqlSortBuilder(dialect);

    private Limit limit;

    /**
     * @param jdbc
     *            jdbc
     */
    public SqlQueryConditionGroupExpression(Jdbc jdbc) {
        this(jdbc, null);
    }

    /**
     * @param jdbc
     *            jdbc
     * @param queryAlias
     *            queryAlias
     */
    public SqlQueryConditionGroupExpression(Jdbc jdbc, String queryAlias) {
        this(jdbc, queryAlias, null);
    }

    /**
     * @param jdbc
     *            jdbc
     * @param queryAlias
     *            queryAlias
     * @param classMapping
     *            classMapping
     */
    public SqlQueryConditionGroupExpression(Jdbc jdbc, String queryAlias,
            ClassMapping<?> classMapping) {
        this(jdbc, null, queryAlias, classMapping);
    }

    /**
     * @param jdbc
     *            jdbc
     * @param parent
     *            parent group
     * @param queryAlias
     *            queryAlias
     * @param classMapping
     *            classMapping
     */
    SqlQueryConditionGroupExpression(Jdbc jdbc,
            QueryConditionGroupLogicExpression parent, String queryAlias,
            ClassMapping<?> classMapping) {
        super(jdbc.getDialect(), parent, queryAlias, classMapping);
        this.jdbc = jdbc;
    }

    // ********************************************************************
    // property
    // ********************************************************************

    protected Jdbc jdbc;

    /**
     * {@inheritDoc}
     */
    @Override
    protected QueryConditionGroupExpression createGroup(
            QueryConditionGroupLogicExpression parent, String queryAlias) {
        return new SqlQueryConditionGroupExpression(jdbc, parent, queryAlias,
                classMapping);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        String condition = super.build();
        if (parent == null) {
            if (LangUtils.isNotEmpty(condition)) {
                return dialect.getKeywords().where() + Chars.SPACE
                        + super.build() + Chars.SPACE + sortBuilder.build();
            } else {
                return super.build() + Chars.SPACE + sortBuilder.build();
            }
        } else {
            return super.build();
        }
    }
    //
    // /**
    // * {@inheritDoc}
    // */
    // @Override
    // public List<Object> getParams() {
    // return ArrayUtils.toList(
    // dialect.getPaginationSqlParameter(super.getParams().toArray(),
    // limit.getOffset(), limit.getLimit()));
    // }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Integer limit) {
        return limit(0, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Integer offset, Integer limit) {
        return limit(new Limit(offset, limit));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Page page) {
        return limit(new Limit(page));
    }

    private QueryLimitExecutor limit(Limit limit) {
        this.limit = limit;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list() {
        String sql = getRoot().expression();
        Object[] params = getRoot().getParams().toArray();
        if (limit != null) {
            sql = dialect.getPaginationSql(sql, limit.getOffset(),
                    limit.getLimit());
            params = dialect.getPaginationSqlParameter(params,
                    limit.getOffset(), limit.getLimit());
        }
        return jdbc.query(sql, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(Class<E> type) {
        String sql = getRoot().expression();
        Object[] params = getRoot().getParams().toArray();
        if (limit != null) {
            sql = dialect.getPaginationSql(sql, limit.getOffset(),
                    limit.getLimit());
            params = dialect.getPaginationSqlParameter(params,
                    limit.getOffset(), limit.getLimit());
        }
        return jdbc.query(sql, params, type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(RowMapper<E> rowMapper) {
        String sql = getRoot().expression();
        Object[] params = getRoot().getParams().toArray();
        if (limit != null) {
            sql = dialect.getPaginationSql(sql, limit.getOffset(),
                    limit.getLimit());
            params = dialect.getPaginationSqlParameter(params,
                    limit.getOffset(), limit.getLimit());
        }
        return jdbc.query(sql, params, rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination() {
        String sql = getRoot().expression();
        String countSql = SqlUtils.convertSelectToCount(sql);
        Object[] params = getRoot().getParams().toArray();
        SimplePaginationResults<Map<String, Object>> pagination = new SimplePaginationResults<>(
                limit);
        if (limit != null) {
            List<Map<String, Object>> list = jdbc.query(
                    dialect.getPaginationSql(sql, limit.getOffset(),
                            limit.getLimit()),
                    dialect.getPaginationSqlParameter(params, limit.getOffset(),
                            limit.getLimit()));
            pagination.setPageResults(list);
            int total = jdbc.queryInt(countSql, params);
            pagination.setTotal(total);
        } else {
            List<Map<String, Object>> list = jdbc.query(sql, params);
            pagination.setPageResults(list);
            pagination.setTotal(list.size());
        }
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(Class<E> type) {
        String sql = getRoot().expression();
        String countSql = SqlUtils.convertSelectToCount(sql);
        Object[] params = getRoot().getParams().toArray();
        SimplePaginationResults<E> pagination = new SimplePaginationResults<>(
                limit);
        if (limit != null) {
            List<E> list = jdbc.query(
                    dialect.getPaginationSql(sql, limit.getOffset(),
                            limit.getLimit()),
                    dialect.getPaginationSqlParameter(params, limit.getOffset(),
                            limit.getLimit()),
                    type);
            pagination.setPageResults(list);
            int total = jdbc.queryInt(countSql, params);
            pagination.setTotal(total);
        } else {
            List<E> list = jdbc.query(sql, params, type);
            pagination.setPageResults(list);
            pagination.setTotal(list.size());
        }
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(RowMapper<E> rowMapper) {
        String sql = getRoot().expression();
        String countSql = SqlUtils.convertSelectToCount(sql);
        Object[] params = getRoot().getParams().toArray();
        SimplePaginationResults<E> pagination = new SimplePaginationResults<>(
                limit);
        if (limit != null) {
            List<E> list = jdbc.query(
                    dialect.getPaginationSql(sql, limit.getOffset(),
                            limit.getLimit()),
                    dialect.getPaginationSqlParameter(params, limit.getOffset(),
                            limit.getLimit()),
                    rowMapper);
            pagination.setPageResults(list);
            int total = jdbc.queryInt(countSql, params);
            pagination.setTotal(total);
        } else {
            List<E> list = jdbc.query(sql, params, rowMapper);
            pagination.setPageResults(list);
            pagination.setTotal(list.size());
        }
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> single() {
        String sql = getRoot().expression();
        Object[] params = getRoot().getParams().toArray();
        if (limit != null) {
            sql = dialect.getPaginationSql(sql, limit.getOffset(),
                    limit.getLimit());
            params = dialect.getPaginationSqlParameter(params,
                    limit.getOffset(), limit.getLimit());
        }
        return jdbc.querySingle(sql, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(Class<E> type) {
        String sql = getRoot().expression();
        Object[] params = getRoot().getParams().toArray();
        if (limit != null) {
            sql = dialect.getPaginationSql(sql, limit.getOffset(),
                    limit.getLimit());
            params = dialect.getPaginationSqlParameter(params,
                    limit.getOffset(), limit.getLimit());
        }
        return jdbc.querySingle(sql, params, type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(RowMapper<E> rowMapper) {
        return jdbc.querySingle(getRoot().expression(),
                getRoot().getParams().toArray(), rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String string() {
        return jdbc.queryString(getRoot().expression(),
                getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer integer() {
        return jdbc.queryInt(getRoot().expression(),
                getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long longInt() {
        return jdbc.queryLong(getRoot().expression(),
                getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal decimal() {
        return jdbc.queryBigDecimal(getRoot().expression(),
                getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> N number(Class<N> type) {
        return jdbc.queryValue(getRoot().expression(),
                getRoot().getParams().toArray(), type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long count() {
        throw new UnsupportedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuerySortExpression sort() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuerySortExpression asc(String... names) {
        ((SqlQueryConditionGroupExpression) getRoot()).sortBuilder
                .asc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuerySortExpression asc(List<String> names) {
        ((SqlQueryConditionGroupExpression) getRoot()).sortBuilder
                .asc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> QuerySortExpression asc(SerializableFunction<T, R> name) {
        return asc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> QuerySortExpression asc(
            @SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
        String[] nameArray = Arrays.stream(names)
                .map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return asc(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuerySortExpression desc(String... names) {
        ((SqlQueryConditionGroupExpression) getRoot()).sortBuilder
                .desc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuerySortExpression desc(List<String> names) {
        ((SqlQueryConditionGroupExpression) getRoot()).sortBuilder
                .desc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> QuerySortExpression desc(SerializableFunction<T, R> name) {
        return desc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> QuerySortExpression desc(
            @SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
        String[] nameArray = Arrays.stream(names)
                .map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return desc(nameArray);
    }
}
