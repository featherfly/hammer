
package cn.featherfly.juorm.jdbc.dsl.execute;

import cn.featherfly.juorm.dsl.Repository;
import cn.featherfly.juorm.expression.execute.Deleter;
import cn.featherfly.juorm.jdbc.Jdbc;

/**
 * <p>
 * SqlDeleter
 * </p>
 *
 * @author zhongj
 */
public class SqlDeleter implements Deleter<SqlDelete> {

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
