
package cn.featherfly.hammer.expression.condition;

/**
 * condition expression2.
 *
 * @author zhongj
 */
public interface ConditionsGroupExpression2<C extends ConditionsGroupExpression2<C, L>,
        L extends ConditionsGroupLogicExpression2<C, L>> extends ConditionsExpression2<C, L>, GroupExpression<C, L> {

}
