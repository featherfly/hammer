
package cn.featherfly.hammer.expression;

/**
 * <p>
 * *ConditionGroupLogicExpression
 * </p>
 *
 * @author zhongj
 */
public interface TypeConditionGroupLogicExpression<C extends TypeConditionGroupExpression<C, L>,
        L extends TypeConditionGroupLogicExpression<C, L>> extends ConditionGroupLogicExpression<C, L> {

}
