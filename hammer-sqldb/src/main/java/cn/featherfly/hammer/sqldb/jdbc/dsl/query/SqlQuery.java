
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.dsl.query.Query;
import cn.featherfly.hammer.expression.Repository;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * <p>
 * SqlQuery
 * </p>
 * .
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

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlQueryEntityProperties find(Repository repository) {
        if (repository == null) {
            return null;
        }
        AliasManager aliasManager = new AliasManager();
        String alias = repository.alias();
        if (Lang.isNotEmpty(alias)) {
            aliasManager.put(repository.name(), alias);
        } else {
            alias = aliasManager.put(repository.name());
        }
        return new SqlQueryEntityProperties(jdbc, databaseMetadata, repository.name(), alias, mappingFactory,
                sqlPageFactory, aliasManager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlQueryEntityProperties find(String tableName) {
        return new SqlQueryEntityProperties(jdbc, databaseMetadata, tableName, mappingFactory, sqlPageFactory,
                new AliasManager());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeSqlQueryEntityProperties find(Class<?> repositType) {
        if (mappingFactory == null) {
            throw new SqldbHammerException("mappingFactory is null");
        }
        return new TypeSqlQueryEntityProperties(jdbc, mappingFactory.getClassMapping(repositType), mappingFactory,
                sqlPageFactory, new AliasManager());
    }
}
