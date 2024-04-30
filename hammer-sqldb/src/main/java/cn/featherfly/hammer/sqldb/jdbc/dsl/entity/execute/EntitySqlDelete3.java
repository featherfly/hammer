
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import java.util.function.Consumer;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.ThreeArgusFunction;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression3;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete3;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete4;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup3;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic3;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityDeleteExpression3;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlConditionsGroupExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlDeleteRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlOn3;

/**
 * entity sql delete2 .
 *
 * @author zhongj
 * @param <E> the element type
 */
public class EntitySqlDelete3<E1, E2, E3> implements EntityDelete3<E1, E2, E3> {

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
    public EntitySqlDelete3(JdbcMappingFactory factory, EntitySqlDeleteRelation relation) {
        this.factory = factory;
        this.relation = relation;
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityOnExpression3<E1, E2, E3, R, EntityDelete4<E1, E2, E3, R>> join(Class<R> joinType) {
        return new EntitySqlOn3<>(joinType, new EntitySqlDelete4<>(factory, relation), factory, relation);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroup3<E1, E2, E3, DeleteConditionConfig> where() {
        return createSqlDeleteExpression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroupLogic3<E1, E2, E3, DeleteConditionConfig> where(
        ThreeArgusFunction<EntityConditionsGroupExpression<E1, ?, ?>, EntityConditionsGroupExpression<E2, ?, ?>,
            EntityConditionsGroupExpression<E3, ?, ?>, LogicExpression<?, ?>> function) {
        EntitySqlDeleteConditions3<E1, E2, E3> sqlDeleteExpression = createSqlDeleteExpression();
        if (function != null) {
            sqlDeleteExpression
                .addCondition(function.apply(new EntitySqlConditionsGroupExpression<>(0, factory, relation),
                    new EntitySqlConditionsGroupExpression<>(1, factory, relation),
                    new EntitySqlConditionsGroupExpression<>(2, factory, relation)));
        }
        return sqlDeleteExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityDeleteExpression3<E1, E2, E3, EntityExecutableConditionGroup3<E1, E2, E3, DeleteConditionConfig>,
        EntityExecutableConditionGroupLogic3<E1, E2, E3, DeleteConditionConfig>> configure(
            Consumer<DeleteConfig> configure) {
        if (configure != null) {
            configure.accept(relation.getConfig());
        }
        return this;
    }

    // ****************************************************************************************************************
    //
    // ****************************************************************************************************************

    private EntitySqlDeleteConditions3<E1, E2, E3> createSqlDeleteExpression() {
        return new EntitySqlDeleteConditions3<>(factory, relation);
    }
}
