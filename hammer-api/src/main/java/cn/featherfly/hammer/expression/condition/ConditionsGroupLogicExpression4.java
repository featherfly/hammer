
package cn.featherfly.hammer.expression.condition;

/**
 * repository conditions group logic expression4.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ConditionsGroupLogicExpression4<C extends ConditionsGroupExpression4<C, L>,
        L extends ConditionsGroupLogicExpression4<C, L>>
        extends GroupEndExpression<C, L>, ConditionsLogicExpression4<C, L> {

}
