
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup4;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic4;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlDeleteRelation;

/**
 * SqlDeleteExpression .
 *
 * @author zhongj
 * @param <E> the element type
 */
public class SqlEntityDeleteExpression4<E1, E2, E3, E4> extends AbstractSqlEntityExecutableConditionGroupExpression4<E1,
    E2, E3, E4, DeleteConditionConfig, EntitySqlDeleteRelation, SqlDeleteFromBasicBuilder> {

    /**
     * Instantiates a new entity sql delete expression.
     *
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    public SqlEntityDeleteExpression4(JdbcMappingFactory factory, EntitySqlDeleteRelation entityRelation) {
        this(null, factory, entityRelation);
    }

    /**
     * Instantiates a new sql entity delete expression.
     *
     * @param parent         the parent
     * @param factory        the factory
     * @param entityRelation the entity relation
     */
    SqlEntityDeleteExpression4(EntityExecutableConditionGroupLogic4<E1, E2, E3, E4, DeleteConditionConfig> parent,
        JdbcMappingFactory factory, EntitySqlDeleteRelation entityRelation) {
        super(parent, factory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return SqlEntityDeleteExpression.expression(super.expression(), parent, entityRelation, conditionConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntityExecutableConditionGroup4<E1, E2, E3, E4, DeleteConditionConfig> createGroup(
        EntityExecutableConditionGroupLogic4<E1, E2, E3, E4, DeleteConditionConfig> parent) {
        return new SqlEntityDeleteExpression4<>(parent, factory, entityRelation);
    }
}
