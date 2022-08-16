
package cn.featherfly.hammer.expression;

/**
 * TypeConditionGroupLogicExpression.
 *
 * @author zhongj
 */
public interface TypeConditionGroupLogicExpression<C extends TypeConditionGroupExpression<C, L>,
        L extends TypeConditionGroupLogicExpression<C, L>> extends ConditionGroupLogicExpression<C, L> {

}
