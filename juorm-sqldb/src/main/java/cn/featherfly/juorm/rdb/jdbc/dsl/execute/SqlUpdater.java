
package cn.featherfly.juorm.rdb.jdbc.dsl.execute;

import cn.featherfly.juorm.dsl.execute.Update;
import cn.featherfly.juorm.dsl.execute.Updater;
import cn.featherfly.juorm.expression.Repository;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.jdbc.JuormJdbcException;
import cn.featherfly.juorm.rdb.jdbc.mapping.JdbcMappingFactory;

/**
 * <p>
 * SqlUpdater
 * </p>
 * .
 *
 * @author zhongj
 */
public class SqlUpdater implements Updater {

    private Jdbc jdbc;

    private JdbcMappingFactory mappingFactory;

    /**
     * Instantiates a new sql updater.
     *
     * @param jdbc
     *            the jdbc
     */
    public SqlUpdater(Jdbc jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * Instantiates a new sql updater.
     *
     * @param jdbc
     *            the jdbc
     * @param mappingFactory
     *            the mapping factory
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
    public Update update(Class<?> repositType) {
        if (mappingFactory == null) {
            throw new JuormJdbcException("mappingFactory is null");
        }
        return new SqlExecutableUpdate(
                mappingFactory.getClassMapping(repositType), jdbc);
    }
}
