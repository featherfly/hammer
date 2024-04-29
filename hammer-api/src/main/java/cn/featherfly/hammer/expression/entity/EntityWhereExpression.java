
package cn.featherfly.hammer.expression.entity;

import java.util.function.Function;

import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityConditionsGroupExpression;
import cn.featherfly.hammer.expression.query.WhereExpression;

/**
 * The Interface EntityWhereExpression.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityWhereExpression<E1, C extends EntityConditionGroupExpression<E1, C, L>,
    L extends EntityConditionGroupLogicExpression<E1, C, L>> extends WhereExpression<C> {
    /**
     * gets the filter expression. 获取筛选条件表达式.
     *
     * @param function the condition expression function
     * @return filter expression
     */
    default L filter(Function<EntityConditionsGroupExpression<E1, ?, ?>, LogicExpression<?, ?>> function) {
        return where(function);
    }

    /**
     * filter alias. More user-friendly for users familiar with sql.
     *
     * @param function the condition expression function
     * @return filter expression
     */
    L where(Function<EntityConditionsGroupExpression<E1, ?, ?>, LogicExpression<?, ?>> function);
}
