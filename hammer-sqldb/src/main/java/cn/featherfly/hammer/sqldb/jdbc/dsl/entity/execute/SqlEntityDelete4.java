
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import java.util.function.Consumer;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.FourArgusFunction;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression4;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete4;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete5;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroup4;
import cn.featherfly.hammer.dsl.entity.execute.EntityExecutableConditionGroupLogic4;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityDeleteExpression4;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlConditionsGroupExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlDeleteRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlOn4;

/**
 * entity sql delete2 .
 *
 * @author zhongj
 * @param <E> the element type
 */
public class SqlEntityDelete4<E1, E2, E3, E4> implements EntityDelete4<E1, E2, E3, E4> {

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
    public SqlEntityDelete4(JdbcMappingFactory factory, EntitySqlDeleteRelation relation) {
        this.factory = factory;
        this.relation = relation;
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityOnExpression4<E1, E2, E3, E4, R, EntityDelete5<E1, E2, E3, E4, R>> join(Class<R> joinType) {
        return new EntitySqlOn4<>(joinType, new SqlEntityDelete5<>(factory, relation), factory, relation);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroup4<E1, E2, E3, E4, DeleteConditionConfig> where() {
        return createSqlDeleteExpression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableConditionGroupLogic4<E1, E2, E3, E4, DeleteConditionConfig> where(
        FourArgusFunction<EntityConditionsGroupExpression<E1, ?, ?>, EntityConditionsGroupExpression<E2, ?, ?>,
            EntityConditionsGroupExpression<E3, ?, ?>, EntityConditionsGroupExpression<E4, ?, ?>,
            LogicExpression<?, ?>> function) {
        SqlEntityDeleteExpression4<E1, E2, E3, E4> sqlDeleteExpression = createSqlDeleteExpression();
        if (function != null) {
            sqlDeleteExpression
                .addCondition(function.apply(new EntitySqlConditionsGroupExpression<>(0, factory, relation),
                    new EntitySqlConditionsGroupExpression<>(1, factory, relation),
                    new EntitySqlConditionsGroupExpression<>(2, factory, relation),
                    new EntitySqlConditionsGroupExpression<>(3, factory, relation)));
        }
        return sqlDeleteExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityDeleteExpression4<E1, E2, E3, E4,
        EntityExecutableConditionGroup4<E1, E2, E3, E4, DeleteConditionConfig>,
        EntityExecutableConditionGroupLogic4<E1, E2, E3, E4, DeleteConditionConfig>> configure(
            Consumer<DeleteConfig> configure) {
        if (configure != null) {
            configure.accept(relation.getConfig());
        }
        return this;
    }

    // ****************************************************************************************************************
    //
    // ****************************************************************************************************************

    private SqlEntityDeleteExpression4<E1, E2, E3, E4> createSqlDeleteExpression() {
        return new SqlEntityDeleteExpression4<>(factory, relation);
    }
}
