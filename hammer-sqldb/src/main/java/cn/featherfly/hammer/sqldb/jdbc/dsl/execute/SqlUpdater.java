
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.execute.Updater;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * SqlUpdater .
 *
 * @author zhongj
 */
public class SqlUpdater implements Updater {

    private Jdbc jdbc;

    private JdbcMappingFactory mappingFactory;

    /**
     * Instantiates a new sql updater.
     *
     * @param jdbc the jdbc
     */
    public SqlUpdater(Jdbc jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * Instantiates a new sql updater.
     *
     * @param jdbc           the jdbc
     * @param mappingFactory the mapping factory
     */
    public SqlUpdater(Jdbc jdbc, JdbcMappingFactory mappingFactory) {
        super();
        this.jdbc = jdbc;
        this.mappingFactory = mappingFactory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlUpdate update(Repository repository) {
        return new SqlExecutableUpdate(repository, jdbc);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlUpdate update(String repository) {
        return new SqlExecutableUpdate(repository, jdbc);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> SqlEntityUpdate<E> update(Class<E> repositType) {
        if (mappingFactory == null) {
            throw new SqldbHammerException("mappingFactory is null");
        }
        // ENHANCE 删除暂时没有支持别名
        return new SqlEntityExecutableUpdate<>(jdbc, mappingFactory.getClassMapping(repositType), mappingFactory);
    }
}
