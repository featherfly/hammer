
package cn.featherfly.hammer.expression.condition;

/**
 * condition expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface GroupEndExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends LogicExpression<C, L> {

    /**
     * 结束当前条件逻辑组并返回上一级逻辑组.
     *
     * @return parent LogicBuilder
     */
    L endGroup();
}
