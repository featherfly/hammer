
package cn.featherfly.juorm.expression.condition;

/**
 * <p>
 * 逻辑条件
 * </p>
 *
 * @author zhongj
 */
public interface LogicGroupExpression<C extends ConditionsGroupExpression<C, L>, L extends LogicGroupExpression<C, L>>
        extends LogicExpression<C, L> {

    /**
     * 结束当前条件逻辑组并返回上一级逻辑组
     *
     * @return parent LogicBuilder
     */
    L endGroup();
}
