
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import java.util.function.Consumer;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.FiveArgusFunction;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression5;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete5;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete6;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup5;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic5;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityDeleteExpression5;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlConditionsGroupExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlDeleteRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlOn5;

/**
 * entity sql delete2 .
 *
 * @author zhongj
 * @param <E> the element type
 */
public class EntitySqlDelete5<E1, E2, E3, E4, E5> implements EntityDelete5<E1, E2, E3, E4, E5> {

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
    public EntitySqlDelete5(JdbcMappingFactory factory, EntitySqlDeleteRelation relation) {
        this.factory = factory;
        this.relation = relation;
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <
        R> EntityOnExpression5<E1, E2, E3, E4, E5, R, EntityDelete6<E1, E2, E3, E4, E5, R>> join(Class<R> joinType) {
        return new EntitySqlOn5<>(joinType, new EntitySqlDelete6<>(factory, relation), factory, relation);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroup5<E1, E2, E3, E4, E5, DeleteConditionConfig> where() {
        return createSqlDeleteExpression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroupLogic5<E1, E2, E3, E4, E5, DeleteConditionConfig> where(
        FiveArgusFunction<EntityConditionsGroupExpression<E1, ?, ?>, EntityConditionsGroupExpression<E2, ?, ?>,
            EntityConditionsGroupExpression<E3, ?, ?>, EntityConditionsGroupExpression<E4, ?, ?>,
            EntityConditionsGroupExpression<E5, ?, ?>, LogicExpression<?, ?>> function) {
        EntitySqlDeleteConditions5<E1, E2, E3, E4, E5> sqlDeleteExpression = createSqlDeleteExpression();
        if (function != null) {
            sqlDeleteExpression
                .addCondition(function.apply(new EntitySqlConditionsGroupExpression<>(0, factory, relation),
                    new EntitySqlConditionsGroupExpression<>(1, factory, relation),
                    new EntitySqlConditionsGroupExpression<>(2, factory, relation),
                    new EntitySqlConditionsGroupExpression<>(3, factory, relation),
                    new EntitySqlConditionsGroupExpression<>(4, factory, relation)));
        }
        return sqlDeleteExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityDeleteExpression5<E1, E2, E3, E4, E5,
        EntityExecutableConditionGroup5<E1, E2, E3, E4, E5, DeleteConditionConfig>,
        EntityExecutableConditionGroupLogic5<E1, E2, E3, E4, E5, DeleteConditionConfig>> configure(
            Consumer<DeleteConfig> configure) {
        if (configure != null) {
            configure.accept(relation.getConfig());
        }
        return this;
    }

    // ****************************************************************************************************************
    //
    // ****************************************************************************************************************

    private EntitySqlDeleteConditions5<E1, E2, E3, E4, E5> createSqlDeleteExpression() {
        return new EntitySqlDeleteConditions5<>(factory, relation);
    }
}
