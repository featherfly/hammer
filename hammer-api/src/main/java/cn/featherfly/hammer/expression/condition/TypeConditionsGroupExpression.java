
package cn.featherfly.hammer.expression.condition;

/**
 * <p>
 * condition expression
 * </p>
 *
 * @author zhongj
 */
public interface TypeConditionsGroupExpression<C extends TypeConditionsGroupExpression<C, L>,
        L extends LogicExpression<C, L>> extends ConditionsGroupExpression<C, L>, TypeConditionsExpression<C, L> {
}
