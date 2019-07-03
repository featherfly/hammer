
package cn.featherfly.juorm.dsl.execute;

/**
 * <p>
 * Updator
 * </p>
 *
 * @author zhongj
 */
public interface ExecutableUpdate<U extends ExecutableUpdate<U>>
        extends Update<U>,
        cn.featherfly.juorm.expression.execute.ExecutableUpdate<U, ExecutableConditionGroupExpression, ExecutableConditionGroupLogicExpression> {
}
