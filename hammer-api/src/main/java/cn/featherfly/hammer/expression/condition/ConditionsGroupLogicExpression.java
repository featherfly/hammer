
package cn.featherfly.hammer.expression.condition;

/**
 * repository conditions group logic expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ConditionsGroupLogicExpression<C extends ConditionsGroupExpression<C, L>,
        L extends ConditionsGroupLogicExpression<C, L>>
        extends GroupEndExpression<C, L>, ConditionsLogicExpression<C, L> {

}
