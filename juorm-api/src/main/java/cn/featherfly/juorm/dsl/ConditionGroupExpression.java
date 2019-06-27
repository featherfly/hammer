
package cn.featherfly.juorm.dsl;

/**
 * <p>
 * ConditionGroupExpression
 * </p>
 *
 * @author zhongj
 */
public interface ConditionGroupExpression<C extends ConditionGroupExpression<C, L>, L extends ConditionGroupLogicExpression<C, L>>
        extends cn.featherfly.juorm.expression.ConditionGroupExpression<C, L> {

}
