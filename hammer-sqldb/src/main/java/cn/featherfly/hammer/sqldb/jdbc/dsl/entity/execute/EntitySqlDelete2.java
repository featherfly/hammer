
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import java.util.function.BiFunction;
import java.util.function.Consumer;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression2;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete2;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete3;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup2;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic2;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityDeleteExpression2;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlConditionsGroupExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlDeleteRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlOn2;

/**
 * entity sql delete2 .
 *
 * @author zhongj
 * @param <E> the element type
 */
public class EntitySqlDelete2<E1, E2> implements EntityDelete2<E1, E2> {

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
    public EntitySqlDelete2(JdbcMappingFactory factory, EntitySqlDeleteRelation relation) {
        this.factory = factory;
        this.relation = relation;
    }

    // ----------------------------------------------------------------------------------------------------------------

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R> EntityOnExpression1<E, R, EntityDelete2<E, R>> join(Class<R> joinType) {
    //        EntityDelete2<E, R> delete2 = null;
    //        return new EntitySqlOn1<>(joinType, delete2, factory, relation);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <J> EntityOnExpression2<E1, E2, J, EntityDelete3<E1, E2, J>> join(Class<J> joinType) {
        return new EntitySqlOn2<>(joinType, new EntitySqlDelete3<>(factory, relation), factory, relation);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroup2<E1, E2, DeleteConditionConfig> where() {
        return createSqlDeleteExpression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroupLogic2<E1, E2, DeleteConditionConfig> where(
        BiFunction<EntityConditionsGroupExpression<E1, ?, ?>, EntityConditionsGroupExpression<E2, ?, ?>,
            LogicExpression<?, ?>> function) {
        EntitySqlDeleteConditions2<E1, E2> sqlDeleteExpression = createSqlDeleteExpression();
        if (function != null) {
            sqlDeleteExpression
                .addCondition(function.apply(new EntitySqlConditionsGroupExpression<>(0, factory, relation),
                    new EntitySqlConditionsGroupExpression<>(1, factory, relation)));
        }
        return sqlDeleteExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityDeleteExpression2<E1, E2, EntityExecutableConditionGroup2<E1, E2, DeleteConditionConfig>,
        EntityExecutableConditionGroupLogic2<E1, E2, DeleteConditionConfig>> configure(
            Consumer<DeleteConfig> configure) {
        if (configure != null) {
            configure.accept(relation.getConfig());
        }
        return this;
    }

    // ****************************************************************************************************************
    //
    // ****************************************************************************************************************

    private EntitySqlDeleteConditions2<E1, E2> createSqlDeleteExpression() {
        return new EntitySqlDeleteConditions2<>(factory, relation);
    }
}
