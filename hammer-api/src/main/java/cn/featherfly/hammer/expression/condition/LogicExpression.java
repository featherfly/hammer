
package cn.featherfly.hammer.expression.condition;

/**
 * <p>
 * 逻辑条件
 * </p>
 *
 * @author zhongj
 */
public interface LogicExpression<C extends ConditionExpression, L extends LogicExpression<C, L>> extends Expression {
    /**
     * <p>
     * 逻辑与
     * </p>
     *
     * @return ExpressionBuilder
     */
    C and();

    /**
     * <p>
     * 逻辑或
     * </p>
     *
     * @return ExpressionBuilder
     */
    C or();

    // /**
    // * 结束当前条件逻辑组并返回上一级逻辑组 {@link ExpressionBuilder#group()}
    // *
    // * @return parent LogicBuilder
    // */
    // L parent();
}
