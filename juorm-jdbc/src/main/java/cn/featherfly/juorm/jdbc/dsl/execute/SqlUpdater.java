
package cn.featherfly.juorm.jdbc.dsl.execute;

import cn.featherfly.juorm.dsl.Repository;
import cn.featherfly.juorm.dsl.execute.Updater;
import cn.featherfly.juorm.jdbc.Jdbc;

/**
 * <p>
 * SqlUpdater
 * </p>
 *
 * @author zhongj
 */
public class SqlUpdater implements Updater<SqlUpdate> {
    private Jdbc jdbc;

    /**
     */
    public SqlUpdater(Jdbc jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlUpdate update(Repository repository) {
        return new SqlExecutableUpdate(repository, jdbc);
    }
}
