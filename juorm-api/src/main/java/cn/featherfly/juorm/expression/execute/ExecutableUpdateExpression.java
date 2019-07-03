
package cn.featherfly.juorm.expression.execute;

import cn.featherfly.juorm.expression.ConditionGroupExpression;
import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;

/**
 * <p>
 * ExecutableUpdateExpression
 * </p>
 *
 * @author zhongj
 */
public interface ExecutableUpdateExpression<U extends ExecutableUpdateExpression<U, C, L, V, VN>,
        C extends ConditionGroupExpression<C, L>, L extends ConditionGroupLogicExpression<C, L>,
        V extends UpdateValueExpression<U, C, L, Object, V, VN>,
        VN extends UpdateNumberValueExpression<U, C, L, Number, V, VN>> extends UpdateExpression<U, C, L, V, VN>,
        PropertyExecutableUpdateExpression<U, C, L, V, VN>, SetExecutableUpdateExpression<U, C, L> {

}
