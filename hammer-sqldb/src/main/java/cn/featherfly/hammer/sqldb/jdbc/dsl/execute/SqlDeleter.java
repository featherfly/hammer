
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.execute.Deleter;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * SqlDeleter.
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
        if (repository instanceof AliasRepository) {
            return new SqlDelete(jdbc, (AliasRepository) repository);
        } else {
            return new SqlDelete(jdbc, repository);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlDelete delete(String repository) {
        return new SqlDelete(jdbc, repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> SqlEntityDelete<E> delete(Class<E> repositType) {
        if (mappingFactory == null) {
            throw new SqldbHammerException("mappingFactory is null");
        }
        // ENHANCE 删除暂时没有支持别名
        return new SqlEntityDelete<>(jdbc, mappingFactory, mappingFactory.getClassMapping(repositType));
    }
}
