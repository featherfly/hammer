
package cn.featherfly.hammer.expression.condition;

import java.util.function.Consumer;

import cn.featherfly.common.repository.operate.LogicOperator;

/**
 * 逻辑条件.
 *
 * @author zhongj
 */
public interface LogicExpression<C extends ConditionExpression, L extends LogicExpression<C, L>> extends Expression {

    /**
     * 根据传入参数进行逻辑运算.
     *
     * @param operator the operator
     * @return ExpressionBuilder
     */
    C logic(LogicOperator operator);

    /**
     * 逻辑与.
     *
     * @return ExpressionBuilder
     */
    C and();

    /**
     * 逻辑与，后跟分组条件即需要把逻辑放在一个分组内的条件.
     *
     * @param group group
     * @return ExpressionBuilder
     */
    L and(Consumer<C> group);

    /**
     * 逻辑或.
     *
     * @return ExpressionBuilder
     */
    C or();

    /**
     * 逻辑或，后跟分组条件即需要把逻辑放在一个分组内的条件.
     *
     * @param group group
     * @return ExpressionBuilder
     */
    L or(Consumer<C> group);

    // /**
    // * 结束当前条件逻辑组并返回上一级逻辑组 {@link ExpressionBuilder#group()}
    // *
    // * @return parent LogicBuilder
    // */
    // L parent();
}
