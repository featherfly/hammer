
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import java.util.function.Consumer;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.SixArgusFunction;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete6;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup6;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic6;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityDeleteExpression6;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlConditionsGroupExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlDeleteRelation;

/**
 * entity sql delete2 .
 *
 * @author zhongj
 * @param <E> the element type
 */
public class EntitySqlDelete6<E1, E2, E3, E4, E5, E6> implements EntityDelete6<E1, E2, E3, E4, E5, E6> {

    private JdbcMappingFactory factory;

    private EntitySqlDeleteRelation relation;

    /**
     * Instantiates a new sql delete.
     *
     * @param jdbc         the jdbc
     * @param factory      the factory
     * @param classMapping the class mapping
     * @param deleteConfig the delete config
     */
    public EntitySqlDelete6(JdbcMappingFactory factory, EntitySqlDeleteRelation relation) {
        this.factory = factory;
        this.relation = relation;
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroup6<E1, E2, E3, E4, E5, E6, DeleteConditionConfig> where() {
        return createSqlDeleteExpression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroupLogic6<E1, E2, E3, E4, E5, E6, DeleteConditionConfig> where(
        SixArgusFunction<EntityConditionsGroupExpression<E1, ?, ?>, EntityConditionsGroupExpression<E2, ?, ?>,
            EntityConditionsGroupExpression<E3, ?, ?>, EntityConditionsGroupExpression<E4, ?, ?>,
            EntityConditionsGroupExpression<E5, ?, ?>, EntityConditionsGroupExpression<E6, ?, ?>,
            LogicExpression<?, ?>> function) {
        EntitySqlDeleteConditions6<E1, E2, E3, E4, E5, E6> sqlDeleteExpression = createSqlDeleteExpression();
        if (function != null) {
            sqlDeleteExpression
                .addCondition(function.apply(new EntitySqlConditionsGroupExpression<>(0, factory, relation),
                    new EntitySqlConditionsGroupExpression<>(1, factory, relation),
                    new EntitySqlConditionsGroupExpression<>(2, factory, relation),
                    new EntitySqlConditionsGroupExpression<>(3, factory, relation),
                    new EntitySqlConditionsGroupExpression<>(4, factory, relation),
                    new EntitySqlConditionsGroupExpression<>(5, factory, relation)));
        }
        return sqlDeleteExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityDeleteExpression6<E1, E2, E3, E4, E5, E6,
        EntityExecutableConditionGroup6<E1, E2, E3, E4, E5, E6, DeleteConditionConfig>,
        EntityExecutableConditionGroupLogic6<E1, E2, E3, E4, E5, E6, DeleteConditionConfig>> configure(
            Consumer<DeleteConfig> configure) {
        if (configure != null) {
            configure.accept(relation.getConfig());
        }
        return this;
    }

    // ****************************************************************************************************************
    //
    // ****************************************************************************************************************

    private EntitySqlDeleteConditions6<E1, E2, E3, E4, E5, E6> createSqlDeleteExpression() {
        return new EntitySqlDeleteConditions6<>(factory, relation);
    }
}
