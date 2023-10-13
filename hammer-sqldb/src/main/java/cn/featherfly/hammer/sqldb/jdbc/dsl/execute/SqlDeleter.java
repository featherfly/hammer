
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import cn.featherfly.common.db.Table;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.dsl.execute.Deleter;
import cn.featherfly.hammer.expression.entity.execute.EntityDeleteExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupLogicExpression;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute.SqlEntityDelete;

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
     * @param jdbc jdbc
     */
    public SqlDeleter(Jdbc jdbc, DeleteConfig deleteConfig) {
        this.jdbc = jdbc;
        this.deleteConfig = deleteConfig;
    }

    /**
     * @param jdbc           jdbc
     * @param mappingFactory mappingFactory
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
    public SqlDelete delete(Table table) {
        return new SqlDelete(jdbc, table.getName(), deleteConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlDelete delete(Repository repository) {
        if (repository instanceof AliasRepository) {
            return new SqlDelete(jdbc, (AliasRepository) repository, deleteConfig);
        } else {
            return new SqlDelete(jdbc, repository, deleteConfig);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlDelete delete(String repository) {
        return new SqlDelete(jdbc, repository, deleteConfig);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <EDR extends EntityDeleteExpression<E, DC, DL>,
            DC extends EntityExecutableConditionGroupExpression<E, DC, DL, DeleteConditionConfig>,
            DL extends EntityExecutableConditionGroupLogicExpression<E, DC, DL, DeleteConditionConfig>,
            E> EDR delete(Class<E> entityType) {
        if (mappingFactory == null) {
            throw new SqldbHammerException("mappingFactory is null");
        }
        // ENHANCE 删除暂时没有支持别名
        return (EDR) new SqlEntityDelete<>(jdbc, mappingFactory, mappingFactory.getClassMapping(entityType),
                deleteConfig);
    }
}
