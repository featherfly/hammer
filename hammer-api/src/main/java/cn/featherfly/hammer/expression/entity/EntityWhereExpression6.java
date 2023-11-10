
package cn.featherfly.hammer.expression.entity;

import cn.featherfly.common.function.SixArgusFunction;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.query.WhereExpression;

/**
 * The Interface EntityWhereExpression6.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityWhereExpression6<E, E2, E3, E4, E5, E6,
    C extends EntityConditionGroupExpression6<E, E2, E3, E4, E5, E6, C, L>,
    L extends EntityConditionGroupLogicExpression6<E, E2, E3, E4, E5, E6, C, L>> extends WhereExpression<C> {
    /**
     * gets the filter expression. 获取筛选条件表达式.
     *
     * @param consumer the condition expression consumer
     * @return filter expression
     */
    default L filter(SixArgusFunction<EntityConditionsGroupExpression<E, ?, ?>,
        EntityConditionsGroupExpression<E2, ?, ?>, EntityConditionsGroupExpression<E3, ?, ?>,
        EntityConditionsGroupExpression<E4, ?, ?>, EntityConditionsGroupExpression<E5, ?, ?>,
        EntityConditionsGroupExpression<E6, ?, ?>, LogicExpression<?, ?>> entitiesCondtionFuntion) {
        return where(entitiesCondtionFuntion);
    }

    /**
     * filter alias. More user-friendly for users familiar with sql.
     *
     * @param entitiesCondtionFuntion the entities condtion funtion
     * @return QueryCondition
     */
    L where(SixArgusFunction<EntityConditionsGroupExpression<E, ?, ?>, EntityConditionsGroupExpression<E2, ?, ?>,
        EntityConditionsGroupExpression<E3, ?, ?>, EntityConditionsGroupExpression<E4, ?, ?>,
        EntityConditionsGroupExpression<E5, ?, ?>, EntityConditionsGroupExpression<E6, ?, ?>,
        LogicExpression<?, ?>> entitiesCondtionFuntion);
}
