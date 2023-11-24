
package cn.featherfly.hammer.expression.condition;

/**
 * conditions logic expression2.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ConditionsLogicExpression2<C extends ConditionsExpression2<C, L>,
        L extends ConditionsLogicExpression2<C, L>> extends LogicExpression<C, L> {

}
