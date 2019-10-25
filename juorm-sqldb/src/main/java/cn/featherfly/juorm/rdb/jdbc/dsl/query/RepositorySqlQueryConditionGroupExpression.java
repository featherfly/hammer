
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.juorm.dml.AliasManager;
import cn.featherfly.juorm.dsl.query.QuerySortExpression;
import cn.featherfly.juorm.dsl.query.RepositoryQueryConditionGroupExpression;
import cn.featherfly.juorm.dsl.query.RepositoryQueryConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.query.QueryExecutor;
import cn.featherfly.juorm.mapping.ClassMapping;
import cn.featherfly.juorm.mapping.RowMapper;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMappingUtils;
import cn.featherfly.juorm.rdb.sql.dml.AbstractRepositorySqlConditionGroupExpression;
import cn.featherfly.juorm.rdb.sql.dml.builder.SqlSortBuilder;

/**
 * <p>
 * sql condition group builder sql条件逻辑组构造器
 * </p>
 *
 * @author zhongj
 */
public class RepositorySqlQueryConditionGroupExpression extends
        AbstractRepositorySqlConditionGroupExpression<RepositoryQueryConditionGroupExpression, RepositoryQueryConditionGroupLogicExpression>
        implements RepositoryQueryConditionGroupExpression, RepositoryQueryConditionGroupLogicExpression,
        QuerySortExpression {

    private SqlSortBuilder sortBuilder = new SqlSortBuilder(dialect);

    private Limit limit;

    /**
     * @param jdbc         jdbc
     * @param aliasManager aliasManager
     */
    public RepositorySqlQueryConditionGroupExpression(Jdbc jdbc, AliasManager aliasManager) {
        this(jdbc, aliasManager, null);
    }

    /**
     * @param jdbc         jdbc
     * @param aliasManager aliasManager
     * @param aliasManager aliasManager
     * @param queryAlias   queryAlias
     */
    public RepositorySqlQueryConditionGroupExpression(Jdbc jdbc, AliasManager aliasManager, String queryAlias) {
        this(jdbc, aliasManager, queryAlias, null);
    }

    /**
     * @param jdbc         jdbc
     * @param aliasManager aliasManager
     * @param queryAlias   queryAlias
     * @param classMapping classMapping
     */
    public RepositorySqlQueryConditionGroupExpression(Jdbc jdbc, AliasManager aliasManager, String queryAlias,
            ClassMapping<?> classMapping) {
        this(jdbc, aliasManager, null, queryAlias, classMapping);
    }

    /**
     * @param jdbc         jdbc
     * @param aliasManager aliasManager
     * @param parent       parent group
     * @param queryAlias   queryAlias
     * @param classMapping classMapping
     */
    RepositorySqlQueryConditionGroupExpression(Jdbc jdbc, AliasManager aliasManager,
            RepositoryQueryConditionGroupLogicExpression parent, String queryAlias, ClassMapping<?> classMapping) {
        super(jdbc.getDialect(), aliasManager, parent, queryAlias, classMapping);
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
    protected RepositoryQueryConditionGroupExpression createGroup(RepositoryQueryConditionGroupLogicExpression parent,
            String queryAlias) {
        return new RepositorySqlQueryConditionGroupExpression(jdbc, aliasManager, parent, queryAlias, classMapping);
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
    public List<Map<String, Object>> list() {
        String sql = getRoot().expression();
        Object[] params = getRoot().getParams().toArray();
        if (limit != null) {
            sql = dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit());
            params = dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit());
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
            sql = dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit());
            params = dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit());
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
            sql = dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit());
            params = dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit());
        }
        return jdbc.query(sql, params, rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> single() {
        String sql = getRoot().expression();
        Object[] params = getRoot().getParams().toArray();
        if (limit != null) {
            sql = dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit());
            params = dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit());
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
        ((RepositorySqlQueryConditionGroupExpression) getRoot()).sortBuilder
                .asc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuerySortExpression asc(List<String> names) {
        ((RepositorySqlQueryConditionGroupExpression) getRoot()).sortBuilder
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
    public <T, R> QuerySortExpression asc(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return asc(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuerySortExpression desc(String... names) {
        ((RepositorySqlQueryConditionGroupExpression) getRoot()).sortBuilder
                .desc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuerySortExpression desc(List<String> names) {
        ((RepositorySqlQueryConditionGroupExpression) getRoot()).sortBuilder
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
    public <T, R> QuerySortExpression desc(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return desc(nameArray);
    }
}