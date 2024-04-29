
package cn.featherfly.hammer.expression.entity;

import cn.featherfly.common.function.FourArgusFunction;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.query.WhereExpression;

/**
 * The Interface EntityWhereExpression4.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <E4> fouth filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityWhereExpression4<E1, E2, E3, E4, C extends EntityConditionGroupExpression4<E1, E2, E3, E4, C, L>,
    L extends EntityConditionGroupLogicExpression4<E1, E2, E3, E4, C, L>> extends WhereExpression<C> {

    /**
     * gets the filter expression. 获取筛选条件表达式.
     *
     * @param entitiesCondtionFuntion the entities condtion funtion
     * @return filter expression
     */
    default L filter(FourArgusFunction<EntityConditionsGroupExpression<E1, ?, ?>,
        EntityConditionsGroupExpression<E2, ?, ?>, EntityConditionsGroupExpression<E3, ?, ?>,
        EntityConditionsGroupExpression<E4, ?, ?>, LogicExpression<?, ?>> entitiesCondtionFuntion) {
        return where(entitiesCondtionFuntion);
    }

    /**
     * filter alias. More user-friendly for users familiar with sql.
     *
     * @param entitiesCondtionFuntion the entities condtion funtion
     * @return QueryCondition
     */
    L where(FourArgusFunction<EntityConditionsGroupExpression<E1, ?, ?>, EntityConditionsGroupExpression<E2, ?, ?>,
        EntityConditionsGroupExpression<E3, ?, ?>, EntityConditionsGroupExpression<E4, ?, ?>,
        LogicExpression<?, ?>> entitiesCondtionFuntion);
}
