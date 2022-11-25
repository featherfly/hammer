
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.IgnorePolicy;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.dsl.query.Query;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlQueryEntityProperties find(Repository repository) {
        if (repository == null) {
            return null;
        }
        AliasManager aliasManager = new AliasManager();
        String alias = null;
        if (repository instanceof AliasRepository) {
            alias = ((AliasRepository) repository).alias();
        }
        if (Lang.isNotEmpty(alias)) {
            aliasManager.put(repository.name(), alias);
        } else {
            alias = aliasManager.put(repository.name());
        }
        return new SqlQueryEntityProperties(jdbc, databaseMetadata, repository.name(), alias, mappingFactory,
                sqlPageFactory, aliasManager, IgnorePolicy.EMPTY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlQueryEntityProperties find(String tableName) {
        return new SqlQueryEntityProperties(jdbc, databaseMetadata, tableName, mappingFactory, sqlPageFactory,
                new AliasManager(), IgnorePolicy.EMPTY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> EntitySqlQueryEntityProperties<E> find(Class<E> repositoryType) {
        if (mappingFactory == null) {
            throw new SqldbHammerException("mappingFactory is null");
        }
        JdbcClassMapping<E> mapping = mappingFactory.getClassMapping(repositoryType);
        if (mapping == null) {
            throw new SqldbHammerException(Strings.format("type {0} is not a entity"));
        }
        return new EntitySqlQueryEntityProperties<>(jdbc, mapping, mappingFactory, sqlPageFactory, new AliasManager(),
                IgnorePolicy.EMPTY);
    }
    //   public TypeSqlQueryEntityProperties find(Class<?> repositoryType) {
    //        if (mappingFactory == null) {
    //            throw new SqldbHammerException("mappingFactory is null");
    //        }
    //        return new TypeSqlQueryEntityProperties(jdbc, mappingFactory.getClassMapping(repositoryType), mappingFactory,
    //                sqlPageFactory, new AliasManager(), IgnorePolicy.EMPTY);
    //    }
}
