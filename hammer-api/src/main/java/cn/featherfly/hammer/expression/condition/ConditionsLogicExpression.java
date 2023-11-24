
package cn.featherfly.hammer.expression.condition;

/**
 * conditions logic expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ConditionsLogicExpression<C extends ConditionsExpression<C, L>,
        L extends ConditionsLogicExpression<C, L>> extends LogicExpression<C, L> {

}
