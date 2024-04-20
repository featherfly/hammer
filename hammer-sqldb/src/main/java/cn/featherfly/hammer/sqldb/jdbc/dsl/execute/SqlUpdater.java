
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import cn.featherfly.common.db.Table;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.config.dsl.UpdateConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdate;
import cn.featherfly.hammer.dsl.execute.Updater;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute.SqlEntityExecutableUpdate;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.execute.SqlExecutableUpdate;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.execute.SqlUpdate;

/**
 * SqlUpdater .
 *
 * @author zhongj
 */
public class SqlUpdater implements Updater {

    private Jdbc jdbc;

    private JdbcMappingFactory mappingFactory;

    private UpdateConfig updateConfig;

    /**
     * Instantiates a new sql updater.
     *
     * @param jdbc           the jdbc
     * @param mappingFactory the mapping factory
     */
    public SqlUpdater(Jdbc jdbc, JdbcMappingFactory mappingFactory, UpdateConfig updateConfig) {
        super();
        this.jdbc = jdbc;
        this.mappingFactory = mappingFactory;
        this.updateConfig = updateConfig;
    }

    /**
     * start update dsl for the table.
     *
     * @param table the table
     * @return Delete
     */
    public SqlUpdate update(Table table) {
        return update(table.name());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlUpdate update(Repository repository) {
        AliasManager aliasManager = new AliasManager();
        if (repository instanceof AliasRepository) {
            return new SqlExecutableUpdate((AliasRepository) repository, jdbc, aliasManager,
                    mappingFactory.getMetadata(), updateConfig);
        } else {
            return new SqlExecutableUpdate(repository, jdbc, aliasManager, mappingFactory.getMetadata(), updateConfig);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlUpdate update(String repository) {
        AliasManager aliasManager = new AliasManager();
        return new SqlExecutableUpdate(repository, jdbc, aliasManager, mappingFactory.getMetadata(), updateConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> EntityUpdate<E> update(Class<E> entityType) {
        if (mappingFactory == null) {
            throw new SqldbHammerException("mappingFactory is null");
        }
        return new SqlEntityExecutableUpdate<>(jdbc, mappingFactory.getClassMapping(entityType), mappingFactory,
                updateConfig);
    }
}
