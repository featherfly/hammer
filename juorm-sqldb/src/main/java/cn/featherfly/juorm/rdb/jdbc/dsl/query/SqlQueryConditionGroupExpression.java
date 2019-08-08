
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import java.math.BigDecimal;
import java.util.List;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.juorm.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.juorm.dsl.query.QueryConditionGroupLogicExpression;
import cn.featherfly.juorm.dsl.query.QuerySortExpression;
import cn.featherfly.juorm.expression.query.QueryExecutor;
import cn.featherfly.juorm.mapping.RowMapper;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMapping;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMappingUtils;
import cn.featherfly.juorm.rdb.sql.dml.AbstractSqlConditionGroupExpression;
import cn.featherfly.juorm.rdb.sql.dml.builder.SqlSortBuilder;

/**
 * <p>
 * sql condition group builder sql条件逻辑组构造器
 * </p>
 *
 * @author zhongj
 */
public class SqlQueryConditionGroupExpression
        extends AbstractSqlConditionGroupExpression<QueryConditionGroupExpression, QueryConditionGroupLogicExpression>
        implements QueryConditionGroupExpression, QueryConditionGroupLogicExpression, QuerySortExpression {

    private SqlSortBuilder sortBuilder = new SqlSortBuilder(dialect);

    private Limit limit;

    /**
     * @param dialect dialect
     */
    public SqlQueryConditionGroupExpression(Jdbc jdbc) {
        this(jdbc, null);
    }

    /**
     * @param dialect    dialect
     * @param queryAlias queryAlias
     */
    public SqlQueryConditionGroupExpression(Jdbc jdbc, String queryAlias) {
        this(jdbc, queryAlias, null);
    }

    /**
     * @param dialect    dialect
     * @param queryAlias queryAlias
     */
    public SqlQueryConditionGroupExpression(Jdbc jdbc, String queryAlias, ClassMapping<?> classMapping) {
        this(jdbc, null, queryAlias, classMapping);
    }

    /**
     * @param dialect      dialect
     * @param parent       parent group
     * @param queryAlias   queryAlias
     * @param classMapping classMapping
     */
    SqlQueryConditionGroupExpression(Jdbc jdbc, QueryConditionGroupLogicExpression parent, String queryAlias,
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
    protected QueryConditionGroupExpression createGroup(QueryConditionGroupLogicExpression parent, String queryAlias) {
        return new SqlQueryConditionGroupExpression(jdbc, parent, queryAlias, classMapping);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        String condition = super.build();
        if (parent == null) {
            if (LangUtils.isNotEmpty(condition)) {
                return dialect.getKeywords().where() + Chars.SPACE + super.build() + Chars.SPACE + sortBuilder.build();
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
    public QueryExecutor limit(Integer limit) {
        return limit(0, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryExecutor limit(Integer offset, Integer limit) {
        return limit(new Limit(offset, limit));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryExecutor limit(Page page) {
        return limit(new Limit(page));
    }

    private QueryExecutor limit(Limit limit) {
        this.limit = limit;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(Class<E> type) {
        String sql = getRoot().expression();
        Object[] params = getRoot().getParams().toArray();
        if (limit != null) {
            sql = dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit());
            params = dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit());
        }
        return jdbc.queryList(sql, params, type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(RowMapper<E> rowMapper) {
        String sql = getRoot().expression();
        Object[] params = getRoot().getParams().toArray();
        if (limit != null) {
            sql = dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit());
            params = dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit());
        }
        return jdbc.query(sql, params, rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(Class<E> type) {
        String sql = getRoot().expression();
        Object[] params = getRoot().getParams().toArray();
        if (limit != null) {
            sql = dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit());
            params = dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit());
        }
        return jdbc.querySingle(sql, params, type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(RowMapper<E> rowMapper) {
        return jdbc.querySingle(getRoot().expression(), getRoot().getParams().toArray(), rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String string() {
        return jdbc.queryString(getRoot().expression(), getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer integer() {
        return jdbc.queryInt(getRoot().expression(), getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long longInt() {
        return jdbc.queryLong(getRoot().expression(), getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal decimal() {
        return jdbc.queryBigDecimal(getRoot().expression(), getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> N number(Class<N> type) {
        return jdbc.queryValue(getRoot().expression(), getRoot().getParams().toArray(), type);
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
    public QuerySortExpression desc(String... names) {
        ((SqlQueryConditionGroupExpression) getRoot()).sortBuilder
                .desc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }
}
