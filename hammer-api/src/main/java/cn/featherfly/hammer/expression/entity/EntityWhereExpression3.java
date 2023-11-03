
package cn.featherfly.hammer.expression.entity;

import cn.featherfly.common.function.ThreeArgusFunction;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.query.WhereExpression;

/**
 * The Interface EntityWhereExpression3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityWhereExpression3<E, E2, E3, C extends EntityConditionGroupExpression3<E, E2, E3, C, L>,
    L extends EntityConditionGroupLogicExpression3<E, E2, E3, C, L>> extends WhereExpression<C> {

    /**
     * gets the filter expression. 获取筛选条件表达式.
     *
     * @param consumer the condition expression consumer
     * @return filter expression
     */
    default L filter(
        ThreeArgusFunction<EntityConditionsGroupExpression<E, ?, ?>, EntityConditionsGroupExpression<E2, ?, ?>,
            EntityConditionsGroupExpression<E3, ?, ?>, LogicExpression<?, ?>> entitiesCondtionFuntion) {
        return where(entitiesCondtionFuntion);
    }

    /**
     * filter alias. More user-friendly for users familiar with sql.
     *
     * @param entitiesCondtionFuntion the entities condtion funtion
     * @return QueryCondition
     */
    L where(ThreeArgusFunction<EntityConditionsGroupExpression<E, ?, ?>, EntityConditionsGroupExpression<E2, ?, ?>,
        EntityConditionsGroupExpression<E3, ?, ?>, LogicExpression<?, ?>> entitiesCondtionFuntion);
}
