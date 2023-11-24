
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.SqlUtils;
import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePaginationResults;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortedExpression;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory.SqlPageQuery;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.AbstractRepositorySqlConditionsGroupExpression;

/**
 * sql query condition group expression. sql查询条件组表达式.
 *
 * @author zhongj
 */
public abstract class AbstractRepositorySqlQueryConditionsGroupExpression extends
        AbstractRepositorySqlConditionsGroupExpression<RepositoryQueryConditionsGroup,
                RepositoryQueryConditionsGroupLogic, QueryConditionConfig>
        implements RepositoryQueryConditionsGroup, RepositoryQueryConditionsGroupLogic, RepositoryQuerySortExpression,
        RepositoryQuerySortedExpression {

    /** The sort builder. */
    private SqlSortBuilder sortBuilder;

    /** The limit. */
    private Limit limit;

    /** The sql page factory. */
    protected SqlPageFactory sqlPageFactory;

    /** The jdbc. */
    protected Jdbc jdbc;

    /** The query relation. */
    protected RepositorySqlQueryRelation queryRelation;

    /**
     * Instantiates a new sql query condition group expression.
     *
     * @param jdbc                 jdbc
     * @param sqlPageFactory       the sql page factory
     * @param queryConditionConfig the query condition config
     */
    protected AbstractRepositorySqlQueryConditionsGroupExpression(Jdbc jdbc, SqlPageFactory sqlPageFactory,
            QueryConditionConfig queryConditionConfig) {
        this(jdbc, sqlPageFactory, null, queryConditionConfig);
    }

    /**
     * Instantiates a new sql query condition group expression.
     *
     * @param jdbc                 jdbc
     * @param sqlPageFactory       the sql page factory
     * @param queryAlias           queryAlias
     * @param queryConditionConfig the query condition config
     */
    protected AbstractRepositorySqlQueryConditionsGroupExpression(Jdbc jdbc, SqlPageFactory sqlPageFactory,
            String queryAlias, QueryConditionConfig queryConditionConfig) {
        this(null, jdbc, sqlPageFactory, queryAlias, queryConditionConfig);
    }

    /**
     * Instantiates a new sql query condition group expression.
     *
     * @param parent               parent group
     * @param jdbc                 jdbc
     * @param sqlPageFactory       the sql page factory
     * @param queryAlias           queryAlias
     * @param queryConditionConfig the query condition config
     */
    AbstractRepositorySqlQueryConditionsGroupExpression(RepositoryQueryConditionsGroupLogic parent, Jdbc jdbc,
            SqlPageFactory sqlPageFactory, String queryAlias, QueryConditionConfig queryConditionConfig) {
        this(parent, jdbc, sqlPageFactory, new AliasManager(), queryAlias, queryConditionConfig);
    }

    private AbstractRepositorySqlQueryConditionsGroupExpression(RepositoryQueryConditionsGroupLogic parent, Jdbc jdbc,
            SqlPageFactory sqlPageFactory, AliasManager aliasManager, String queryAlias,
            QueryConditionConfig queryConditionConfig) {
        super(parent, jdbc.getDialect(), aliasManager, queryAlias, queryConditionConfig);
        this.sqlPageFactory = sqlPageFactory;
        this.jdbc = jdbc;
        sortBuilder = new SqlSortBuilder(dialect);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        String condition = super.expression();
        if (parent == null) {
            if (Lang.isNotEmpty(condition)) {
                return dialect.getKeywords().where() + Chars.SPACE + super.expression() + Chars.SPACE
                        + sortBuilder.build();
            } else {
                return super.expression() + Chars.SPACE + sortBuilder.build();
            }
        } else {
            return super.expression();
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
    public QueryLimitExecutor limit(Limit limit) {
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
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
                    params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
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
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
                    params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        return jdbc.query(sql, type, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(RowMapper<E> rowMapper) {
        String sql = getRoot().expression();
        Object[] params = getRoot().getParams().toArray();
        if (limit != null) {
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
                    params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        return jdbc.query(sql, rowMapper, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination() {
        String sql = getRoot().expression();
        String countSql = SqlUtils.convertSelectToCount(sql);
        Object[] params = getRoot().getParams().toArray();
        SimplePaginationResults<Map<String, Object>> pagination = new SimplePaginationResults<>(limit);
        if (limit != null) {
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
                    params);
            List<Map<String, Object>> list = jdbc.query(pageQuery.getSql(), pageQuery.getParams());
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
        SimplePaginationResults<E> pagination = new SimplePaginationResults<>(limit);
        if (limit != null) {
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
                    params);
            List<E> list = jdbc.query(pageQuery.getSql(), type, pageQuery.getParams());
            pagination.setPageResults(list);
            int total = jdbc.queryInt(countSql, params);
            pagination.setTotal(total);
        } else {
            List<E> list = jdbc.query(sql, type, params);
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
        SimplePaginationResults<E> pagination = new SimplePaginationResults<>(limit);
        if (limit != null) {
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
                    params);
            List<E> list = jdbc.query(pageQuery.getSql(), rowMapper, pageQuery.getParams());
            pagination.setPageResults(list);
            int total = jdbc.queryInt(countSql, params);
            pagination.setTotal(total);
        } else {
            List<E> list = jdbc.query(sql, rowMapper, params);
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
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
                    params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        return jdbc.querySingle(sql, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> unique() {
        String sql = getRoot().expression();
        Object[] params = getRoot().getParams().toArray();
        if (limit != null) {
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
                    params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        return jdbc.queryUnique(sql, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(Class<E> type) {
        String sql = getRoot().expression();
        Object[] params = getRoot().getParams().toArray();
        if (limit != null) {
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
                    params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        return jdbc.querySingle(sql, type, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E unique(Class<E> type) {
        String sql = getRoot().expression();
        Object[] params = getRoot().getParams().toArray();
        if (limit != null) {
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
                    params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        return jdbc.queryUnique(sql, type, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(RowMapper<E> rowMapper) {
        String sql = getRoot().expression();
        Object[] params = getRoot().getParams().toArray();
        if (limit != null) {
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
                    params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        return jdbc.querySingle(sql, rowMapper, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E unique(RowMapper<E> rowMapper) {
        String sql = getRoot().expression();
        Object[] params = getRoot().getParams().toArray();
        if (limit != null) {
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
                    params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        return jdbc.queryUnique(sql, rowMapper, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression sort() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression asc(String... names) {
        ((AbstractRepositorySqlQueryConditionsGroupExpression) getRoot()).sortBuilder.asc(names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression asc(List<String> names) {
        ((AbstractRepositorySqlQueryConditionsGroupExpression) getRoot()).sortBuilder.asc(names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryQuerySortedExpression asc(SerializableFunction<T, R> name) {
        return asc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
            R> RepositoryQuerySortedExpression asc(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return asc(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression desc(String... names) {
        ((AbstractRepositorySqlQueryConditionsGroupExpression) getRoot()).sortBuilder.desc(names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortedExpression desc(List<String> names) {
        ((AbstractRepositorySqlQueryConditionsGroupExpression) getRoot()).sortBuilder.desc(names);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryQuerySortedExpression desc(SerializableFunction<T, R> name) {
        return desc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositoryQuerySortedExpression desc(
            @SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return desc(nameArray);
    }

    // ********************************************************************************************************************************
    //	property
    // ********************************************************************************************************************************

    /**
     * Gets the query alias.
     *
     * @return the query alias
     */
    public String getQueryAlias() {
        return getRepositoryAlias();
    }

    /**
     * Gets the limit.
     *
     * @return the limit
     */
    protected Limit getLimit() {
        return limit;
    }
}
