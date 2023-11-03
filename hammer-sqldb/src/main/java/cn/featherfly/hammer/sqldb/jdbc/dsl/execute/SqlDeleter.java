
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import cn.featherfly.common.db.Table;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete;
import cn.featherfly.hammer.dsl.execute.Deleter;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryDelete;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute.SqlEntityDelete;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.execute.SqlRepositoryDelete;

/**
 * SqlDeleter.
 *
 * @author zhongj
 */
public class SqlDeleter implements Deleter {

    private Jdbc jdbc;

    private JdbcMappingFactory mappingFactory;

    private DeleteConfig deleteConfig;

    /**
     * Instantiates a new sql deleter.
     *
     * @param jdbc           jdbc
     * @param mappingFactory mappingFactory
     * @param deleteConfig   the delete config
     */
    public SqlDeleter(Jdbc jdbc, JdbcMappingFactory mappingFactory, DeleteConfig deleteConfig) {
        this.jdbc = jdbc;
        this.mappingFactory = mappingFactory;
        this.deleteConfig = deleteConfig;
    }

    /**
     * start delete dsl for table.
     *
     * @param table the table
     * @return SqlDelete
     */
    public RepositoryDelete delete(Table table) {
        return delete(table.getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryDelete delete(Repository repository) {
        if (repository instanceof AliasRepository) {
            return new SqlRepositoryDelete(jdbc, (AliasRepository) repository, mappingFactory.getMetadata(),
                    deleteConfig);
        } else {
            return new SqlRepositoryDelete(jdbc, repository, mappingFactory.getMetadata(), deleteConfig);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryDelete delete(String repository) {
        return new SqlRepositoryDelete(jdbc, repository, mappingFactory.getMetadata(), deleteConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> EntityDelete<E> delete(Class<E> entityType) {
        if (mappingFactory == null) {
            throw new SqldbHammerException("mappingFactory is null");
        }
        // ENHANCE 删除暂时没有支持别名
        return new SqlEntityDelete<>(jdbc, mappingFactory, mappingFactory.getClassMapping(entityType), deleteConfig);
    }
}
