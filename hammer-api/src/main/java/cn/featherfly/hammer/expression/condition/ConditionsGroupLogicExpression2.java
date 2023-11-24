
package cn.featherfly.hammer.expression.condition;

/**
 * repository conditions group logic expression2.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ConditionsGroupLogicExpression2<C extends ConditionsGroupExpression2<C, L>,
        L extends ConditionsGroupLogicExpression2<C, L>>
        extends GroupEndExpression<C, L>, ConditionsLogicExpression2<C, L> {

}
