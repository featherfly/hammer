
package cn.featherfly.juorm.rdb.jdbc.dsl.execute;

import cn.featherfly.juorm.dsl.execute.Deleter;
import cn.featherfly.juorm.expression.Repository;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;

/**
 * <p>
 * SqlDeleter
 * </p>
 *
 * @author zhongj
 */
public class SqlDeleter implements Deleter {

    private Jdbc jdbc;

    /**
     */
    public SqlDeleter(Jdbc jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlDelete delete(Repository repository) {
        return new SqlDelete(repository, jdbc);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlDelete delete(String repository) {
        return new SqlDelete(repository, jdbc);
    }
}
