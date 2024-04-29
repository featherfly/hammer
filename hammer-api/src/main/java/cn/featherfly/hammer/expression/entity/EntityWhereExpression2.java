
package cn.featherfly.hammer.expression.entity;

import java.util.function.BiFunction;

import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.query.WhereExpression;

/**
 * The Interface EntityWhereExpression2.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityWhereExpression2<E1, E2, C extends EntityConditionGroupExpression2<E1, E2, C, L>,
    L extends EntityConditionGroupLogicExpression2<E1, E2, C, L>> extends WhereExpression<C> {

    /**
     * gets the filter expression. 获取筛选条件表达式.
     *
     * @param entitiesCondtionFuntion the entities condtion funtion
     * @return filter expression
     */
    default L filter(BiFunction<EntityConditionsGroupExpression<E1, ?, ?>, EntityConditionsGroupExpression<E2, ?, ?>,
        LogicExpression<?, ?>> entitiesCondtionFuntion) {
        return where(entitiesCondtionFuntion);
    }

    /**
     * filter alias. More user-friendly for users familiar with sql.
     *
     * @param entitiesCondtionFuntion the entities condtion funtion
     * @return QueryCondition
     */
    L where(BiFunction<EntityConditionsGroupExpression<E1, ?, ?>, EntityConditionsGroupExpression<E2, ?, ?>,
        LogicExpression<?, ?>> entitiesCondtionFuntion);
}
