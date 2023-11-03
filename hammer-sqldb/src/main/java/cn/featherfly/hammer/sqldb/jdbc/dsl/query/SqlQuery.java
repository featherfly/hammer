
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.config.dsl.QueryConfig;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetch;
import cn.featherfly.hammer.dsl.query.Query;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.EntitySqlQueryFetch;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.RepositorySqlQueryFetch;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.RepositorySqlQueryFetchImpl;

/**
 * SqlQuery .
 *
 * @author zhongj
 */
public class SqlQuery implements Query {

    /** The jdbc. */
    private Jdbc jdbc;

    /** The database metadata. */
    private DatabaseMetadata databaseMetadata;

    /** The mapping factory. */
    private JdbcMappingFactory mappingFactory;

    /** The sql page factory. */
    private SqlPageFactory sqlPageFactory;

    private QueryConfig queryConfig;

    /**
     * Instantiates a new sql query.
     *
     * @param jdbc             jdbc
     * @param databaseMetadata databaseMetadata
     * @param sqlPageFactory   the sql page factory
     * @param queryConfig      the query config
     */
    public SqlQuery(Jdbc jdbc, DatabaseMetadata databaseMetadata, SqlPageFactory sqlPageFactory,
            QueryConfig queryConfig) {
        super();
        this.jdbc = jdbc;
        this.databaseMetadata = databaseMetadata;
        this.sqlPageFactory = sqlPageFactory;
        this.queryConfig = queryConfig;
    }

    /**
     * Instantiates a new sql query.
     *
     * @param jdbc           jdbc
     * @param mappingFactory mappingFactory
     * @param sqlPageFactory the sql page factory
     */
    public SqlQuery(Jdbc jdbc, JdbcMappingFactory mappingFactory, SqlPageFactory sqlPageFactory,
            QueryConfig queryConfig) {
        super();
        this.jdbc = jdbc;
        this.mappingFactory = mappingFactory;
        databaseMetadata = mappingFactory.getMetadata();
        this.sqlPageFactory = sqlPageFactory;
        this.queryConfig = queryConfig;
    }

    //    /**
    //     * find table.
    //     *
    //     * @param table the table
    //     * @return SqlQueryEntity
    //     */
    //    public SqlQueryEntity find(Table table) {
    //        AssertIllegalArgument.isNotNull(table, "table");
    //        return find(table.getName());
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    //    public SqlQueryEntityProperties find(Repository repository) {
    public RepositorySqlQueryFetch find(Repository repository) {
        if (repository instanceof AliasRepository) {
            return find((AliasRepository) repository);
        } else {
            AssertIllegalArgument.isNotNull(repository, "repository");
            return find(repository.name());
        }
    }

    public RepositorySqlQueryFetch find(AliasRepository repository) {
        AssertIllegalArgument.isNotNull(repository, "repository");
        return find(repository.name(), repository.alias());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    //    public SqlQueryEntityProperties find(String tableName) {
    public RepositorySqlQueryFetch find(String tableName) {
        return find(tableName, null);
    }

    public RepositorySqlQueryFetch find(String tableName, String tableAlias) {
        AssertIllegalArgument.isNotNull(tableName, "tableName");
        AliasManager aliasManager = new AliasManager();
        if (Lang.isNotEmpty(tableAlias)) {
            aliasManager.put(tableName, tableAlias);
        } else {
            tableAlias = aliasManager.put(tableName);
        }
        return new RepositorySqlQueryFetchImpl(
                new RepositorySqlQueryRelation(jdbc, aliasManager, databaseMetadata, queryConfig.clone())
                        .query(tableName, tableAlias).fetch(0),
                sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> EntityQueryFetch<E> find(Class<E> entity) {
        if (mappingFactory == null) {
            throw new SqldbHammerException("mappingFactory is null");
        }
        JdbcClassMapping<E> mapping = mappingFactory.getClassMapping(entity);
        //        if (mapping == null) { // 不存在的映射类型在mappingFactory就抛出异常了
        //            throw new SqldbHammerException(Strings.format("type {0} is not a entity"));
        //        }

        EntitySqlQueryRelation queryRelation = new EntitySqlQueryRelation(jdbc, new AliasManager(),
                queryConfig.clone());
        return new EntitySqlQueryFetch<>(mappingFactory, sqlPageFactory, queryRelation, mapping);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @SuppressWarnings("unchecked")
    //    @Override
    //    public <EQF extends EntityQueryFetchExpression<E, EQC, EQL, EQFP, EQVC, EQVL, RS>, E,
    //            EQC extends EntityQueryConditionGroupExpression<E, EQC, EQL, RS>,
    //            EQL extends EntityQueryConditionGroupLogicExpression<E, EQC, EQL, RS>,
    //            EQFP extends EntityQueryFetchedPropertyExpression<E, EQVC, EQVL, EQFP, RS>,
    //            EQVC extends EntityQueryValueConditionGroupExpression<E, EQVC, EQVL, RS>,
    //            EQVL extends EntityQueryValueConditionGroupLogicExpression<E, EQVC, EQVL, RS>,
    //            RS extends EntityQuerySortExpression<E>> EQF find(Class<E> entityType) {
    //        if (mappingFactory == null) {
    //            throw new SqldbHammerException("mappingFactory is null");
    //        }
    //        JdbcClassMapping<E> mapping = mappingFactory.getClassMapping(entityType);
    //        //        if (mapping == null) { // 不存在的映射类型在mappingFactory就抛出异常了
    //        //            throw new SqldbHammerException(Strings.format("type {0} is not a entity"));
    //        //        }
    //
    //        EntitySqlQueryRelation queryRelation = new EntitySqlQueryRelation(jdbc, new AliasManager(),
    //                IgnoreStrategy.EMPTY);
    //        return (EQF) new EntitySqlQueryFetch<>(mappingFactory, sqlPageFactory, queryRelation, mapping);
    //    }

    // IMPLSOON 后续来实现select xxx from yy 模式的方法链
    //    public SqlSelectQuery select() {
    //    }
}
