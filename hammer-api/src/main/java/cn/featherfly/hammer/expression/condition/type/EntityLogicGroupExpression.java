
package cn.featherfly.hammer.expression.condition.type;

import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLogicGroupExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityLogicGroupExpression<E, C extends EntityConditionsGroupExpression<E, C, L>,
        L extends EntityLogicGroupExpression<E, C, L>> extends LogicExpression<C, L> {

    /**
     * 结束当前条件逻辑组并返回上一级逻辑组.
     *
     * @return parent LogicBuilder
     */
    L endGroup();
}
