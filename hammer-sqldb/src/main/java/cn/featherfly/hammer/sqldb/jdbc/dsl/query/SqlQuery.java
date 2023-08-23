
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.dsl.query.Query;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryFetchExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryFetchedPropertyExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueConditionGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueConditionGroupLogicExpression;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.EntitySqlQueryFetch;

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

    /**
     * Instantiates a new sql query.
     *
     * @param jdbc             jdbc
     * @param databaseMetadata databaseMetadata
     * @param sqlPageFactory   the sql page factory
     */
    public SqlQuery(Jdbc jdbc, DatabaseMetadata databaseMetadata, SqlPageFactory sqlPageFactory) {
        super();
        this.jdbc = jdbc;
        this.databaseMetadata = databaseMetadata;
        this.sqlPageFactory = sqlPageFactory;
    }

    /**
     * Instantiates a new sql query.
     *
     * @param jdbc           jdbc
     * @param mappingFactory mappingFactory
     * @param sqlPageFactory the sql page factory
     */
    public SqlQuery(Jdbc jdbc, JdbcMappingFactory mappingFactory, SqlPageFactory sqlPageFactory) {
        super();
        this.jdbc = jdbc;
        this.mappingFactory = mappingFactory;
        databaseMetadata = mappingFactory.getMetadata();
        this.sqlPageFactory = sqlPageFactory;
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
    public SqlQueryEntity find(Repository repository) {
        if (repository instanceof AliasRepository) {
            return find((AliasRepository) repository);
        } else {
            AssertIllegalArgument.isNotNull(repository, "repository");
            return find(repository.name());
        }
    }

    public SqlQueryEntity find(AliasRepository repository) {
        AssertIllegalArgument.isNotNull(repository, "repository");
        return find(repository.name(), repository.alias());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    //    public SqlQueryEntityProperties find(String tableName) {
    public SqlQueryEntity find(String tableName) {
        return find(tableName, null);
    }

    public SqlQueryEntity find(String tableName, String tableAlias) {
        AssertIllegalArgument.isNotNull(tableName, "tableName");
        AliasManager aliasManager = new AliasManager();
        String alias = tableAlias;
        if (Lang.isNotEmpty(alias)) {
            aliasManager.put(tableName, alias);
        } else {
            alias = aliasManager.put(tableName);
        }
        return new SqlQueryEntityProperties(jdbc, databaseMetadata, tableName, alias, sqlPageFactory, aliasManager,
                IgnoreStrategy.EMPTY);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <E> EntityQueryFetch<E> find(Class<E> entityType) {
    //        if (mappingFactory == null) {
    //            throw new SqldbHammerException("mappingFactory is null");
    //        }
    //        JdbcClassMapping<E> mapping = mappingFactory.getClassMapping(entityType);
    //        if (mapping == null) {
    //            throw new SqldbHammerException(Strings.format("type {0} is not a entity"));
    //        }
    //
    //        EntitySqlQueryRelation queryRelation = new EntitySqlQueryRelation(jdbc, new AliasManager(),
    //                IgnoreStrategy.EMPTY);
    //        return new EntitySqlQueryFetch<>(mappingFactory, sqlPageFactory, queryRelation, mapping);
    //
    //        //        return new EntitySqlQueryEntityProperties<>(jdbc, mapping, mappingFactory, sqlPageFactory, new AliasManager(),
    //        //                IgnoreStrategy.EMPTY);
    //    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <EQF extends EntityQueryFetchExpression<E, EQC, EQL, EQFP, EQVC, EQVL, RS>, E,
            EQC extends EntityQueryConditionGroupExpression<E, EQC, EQL, RS>,
            EQL extends EntityQueryConditionGroupLogicExpression<E, EQC, EQL, RS>,
            EQFP extends EntityQueryFetchedPropertyExpression<E, EQVC, EQVL, EQFP, RS>,
            EQVC extends EntityQueryValueConditionGroupExpression<E, EQVC, EQVL, RS>,
            EQVL extends EntityQueryValueConditionGroupLogicExpression<E, EQVC, EQVL, RS>,
            RS extends EntityQuerySortExpression<E>> EQF find(Class<E> entityType) {
        if (mappingFactory == null) {
            throw new SqldbHammerException("mappingFactory is null");
        }
        JdbcClassMapping<E> mapping = mappingFactory.getClassMapping(entityType);
        //        if (mapping == null) { // 不存在的映射类型在mappingFactory就抛出异常了
        //            throw new SqldbHammerException(Strings.format("type {0} is not a entity"));
        //        }

        EntitySqlQueryRelation queryRelation = new EntitySqlQueryRelation(jdbc, new AliasManager(),
                IgnoreStrategy.EMPTY);
        return (EQF) new EntitySqlQueryFetch<>(mappingFactory, sqlPageFactory, queryRelation, mapping);
    }

    // IMPLSOON 后续来实现select xxx from yy 模式的方法链
    //    public SqlSelectQuery select() {
    //    }
}
