
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import cn.featherfly.common.db.Table;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.execute.Updater;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableUpdateExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityUpdateExpression;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute.SqlEntityExecutableUpdate;

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
     * start update dsl for the table.
     *
     * @param table the table
     * @return Delete
     */
    public SqlUpdate update(Table table) {
        return new SqlExecutableUpdate(table.getName(), jdbc);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlUpdate update(Repository repository) {
        if (repository instanceof AliasRepository) {
            return new SqlExecutableUpdate((AliasRepository) repository, jdbc);
        } else {
            return new SqlExecutableUpdate(repository, jdbc);
        }
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
    @SuppressWarnings("unchecked")
    @Override
    public <EUR extends EntityUpdateExpression<E, UU, UC, UL>,
            UU extends EntityExecutableUpdateExpression<E, UU, UC, UL>,
            UC extends EntityExecutableConditionGroupExpression<E, UC, UL>,
            UL extends EntityExecutableConditionGroupLogicExpression<E, UC, UL>, E> EUR update(Class<E> entityType) {
        if (mappingFactory == null) {
            throw new SqldbHammerException("mappingFactory is null");
        }
        return (EUR) new SqlEntityExecutableUpdate<>(jdbc, mappingFactory.getClassMapping(entityType), mappingFactory);
    }
}
