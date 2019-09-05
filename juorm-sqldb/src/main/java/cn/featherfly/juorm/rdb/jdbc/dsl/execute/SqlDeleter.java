
package cn.featherfly.juorm.rdb.jdbc.dsl.execute;

import cn.featherfly.juorm.JuormException;
import cn.featherfly.juorm.dsl.execute.Deleter;
import cn.featherfly.juorm.expression.Repository;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.jdbc.mapping.JdbcMappingFactory;

/**
 * <p>
 * SqlDeleter
 * </p>
 *
 * @author zhongj
 */
public class SqlDeleter implements Deleter {

    private Jdbc jdbc;

    private JdbcMappingFactory mappingFactory;

    /**
     * @param jdbc jdbc
     */
    public SqlDeleter(Jdbc jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * @param jdbc           jdbc
     * @param mappingFactory mappingFactory
     */
    public SqlDeleter(Jdbc jdbc, JdbcMappingFactory mappingFactory) {
        this.jdbc = jdbc;
        this.mappingFactory = mappingFactory;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlDelete delete(Class<?> repositType) {
        if (mappingFactory == null) {
            throw new JuormException("mappingFactory is null");
        }
        return new SqlDelete(mappingFactory.getClassMapping(repositType), jdbc);
    }
}
