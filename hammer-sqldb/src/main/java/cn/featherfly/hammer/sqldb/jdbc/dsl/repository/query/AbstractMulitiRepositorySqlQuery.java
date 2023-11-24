//
//package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;
//
//import java.util.List;
//import java.util.Map;
//
//import cn.featherfly.common.db.metadata.DatabaseMetadata;
//import cn.featherfly.common.repository.builder.AliasManager;
//import cn.featherfly.common.repository.mapping.RowMapper;
//import cn.featherfly.common.structure.page.PaginationResults;
//import cn.featherfly.hammer.config.dsl.QueryConfig;
//import cn.featherfly.hammer.expression.query.QueryConditionLimit;
//import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
//import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
//import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
//import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;
//
///**
// * abstract muliti repository sql query.
// *
// * @author zhongj
// * @param <Q> the element type
// */
//public abstract class AbstractMulitiRepositorySqlQuery<Q> extends AbstractRepositorySqlQuery<Q>
//        implements QueryConditionLimit<Q>, QueryLimitExecutor {
//
//    /** The query relation. */
//    protected RepositorySqlQueryRelation queryRelation;
//
//    /**
//     * Instantiates a new abstract sql query entity properties.
//     *
//     * @param jdbc             jdbc
//     * @param databaseMetadata databaseMetadata
//     * @param sqlPageFactory   the sql page factory
//     * @param aliasManager     aliasManager
//     * @param queryRelation    the query relation
//     * @param tableName        tableName
//     * @param tableAlias       tableAlias
//     * @param queryConfig      the query config
//     */
//    protected AbstractMulitiRepositorySqlQuery(Jdbc jdbc, DatabaseMetadata databaseMetadata,
//            SqlPageFactory sqlPageFactory, AliasManager aliasManager, RepositorySqlQueryRelation queryRelation,
//            String tableName, String tableAlias, QueryConfig queryConfig) {
//        super(jdbc, databaseMetadata, sqlPageFactory, aliasManager, tableName, tableAlias, queryConfig);
//        this.queryRelation = queryRelation;
//    }
//
//    /**
//     * Instantiates a new abstract sql query entity properties.
//     *
//     * @param mulitiRepositorySqlQueryFetch the muliti repository sql query
//     *                                      fetch
//     */
//    protected AbstractMulitiRepositorySqlQuery(AbstractMulitiRepositorySqlQuery<Q> mulitiRepositorySqlQueryFetch) {
//        super(mulitiRepositorySqlQueryFetch);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public List<Map<String, Object>> list() {
//        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).list();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <E> List<E> list(RowMapper<E> rowMapper) {
//        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).list(rowMapper);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <E> List<E> list(Class<E> type) {
//        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).list(type);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Map<String, Object> single() {
//        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).single();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Map<String, Object> unique() {
//        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).unique();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <E> E single(Class<E> type) {
//        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).single(type);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <E> E unique(Class<E> type) {
//        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).unique(type);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <E> E single(RowMapper<E> rowMapper) {
//        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).single(rowMapper);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <E> E unique(RowMapper<E> rowMapper) {
//        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).unique(rowMapper);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public PaginationResults<Map<String, Object>> pagination() {
//        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).pagination();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <E> PaginationResults<E> pagination(Class<E> type) {
//        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).pagination(type);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <E> PaginationResults<E> pagination(RowMapper<E> rowMapper) {
//        return new RepositorySqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).pagination(rowMapper);
//    }
//}
