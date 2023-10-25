
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;

/**
 * ExecutableUpdateExpression.
 *
 * @author zhongj
 */
public interface ExecutableUpdateExpression<U extends ExecutableUpdateExpression<U, C, L, V, VN>,
        C extends ExecutableConditionGroupExpression<C, L, UpdateConditionConfig>,
        L extends ExecutableConditionGroupLogicExpression<C, L, UpdateConditionConfig>,
        V extends UpdateValueExpression<U, C, L, Object, V, VN>,
        VN extends UpdateNumberValueExpression<U, C, L, Number, V, VN>> extends UpdateExpression<U, C, L, V, VN>,
        PropertyExecutableUpdateExpression<U, C, L, V, VN>, ExecutableUpdateSetExpression<U, C, L> {

}
