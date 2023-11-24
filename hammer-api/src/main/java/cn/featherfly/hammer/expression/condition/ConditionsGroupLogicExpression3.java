
package cn.featherfly.hammer.expression.condition;

/**
 * repository conditions group logic expression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ConditionsGroupLogicExpression3<C extends ConditionsGroupExpression3<C, L>,
        L extends ConditionsGroupLogicExpression3<C, L>>
        extends GroupEndExpression<C, L>, ConditionsLogicExpression3<C, L> {

}
