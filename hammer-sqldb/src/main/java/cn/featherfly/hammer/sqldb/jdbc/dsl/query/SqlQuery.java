
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.hammer.dml.AliasManager;
import cn.featherfly.hammer.dsl.query.Query;
import cn.featherfly.hammer.expression.Repository;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.mapping.JdbcMappingFactory;

/**
 * <p>
 * SqlQuery
 * </p>
 *
 * @author zhongj
 */
public class SqlQuery implements Query {

    private Jdbc jdbc;

    private DatabaseMetadata databaseMetadata;

    private JdbcMappingFactory mappingFactory;

    /**
     * @param jdbc             jdbc
     * @param databaseMetadata databaseMetadata
     */
    public SqlQuery(Jdbc jdbc, DatabaseMetadata databaseMetadata) {
        super();
        this.jdbc = jdbc;
        this.databaseMetadata = databaseMetadata;
    }

    /**
     * @param jdbc           jdbc
     * @param mappingFactory mappingFactory
     */
    public SqlQuery(Jdbc jdbc, JdbcMappingFactory mappingFactory) {
        super();
        this.jdbc = jdbc;
        this.mappingFactory = mappingFactory;
        databaseMetadata = mappingFactory.getMetadata();
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
        if (LangUtils.isNotEmpty(alias)) {
            aliasManager.put(repository.name(), alias);
        } else {
            alias = aliasManager.put(repository.name());
        }
        return new SqlQueryEntityProperties(jdbc, databaseMetadata, repository.name(), alias, mappingFactory,
                aliasManager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlQueryEntityProperties find(String tableName) {
        return new SqlQueryEntityProperties(jdbc, databaseMetadata, tableName, mappingFactory, new AliasManager());
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
                new AliasManager());
    }
}
