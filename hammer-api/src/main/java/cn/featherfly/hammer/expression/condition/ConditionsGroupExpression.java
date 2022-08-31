
package cn.featherfly.hammer.expression.condition;

/**
 * condition expression.
 *
 * @author zhongj
 */
public interface ConditionsGroupExpression<C extends ConditionsGroupExpression<C, L>, L extends LogicExpression<C, L>>
        extends ConditionsExpression<C, L>, GroupExpression<C, L> {

}
