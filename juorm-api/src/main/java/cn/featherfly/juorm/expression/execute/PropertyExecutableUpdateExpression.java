
package cn.featherfly.juorm.expression.execute;

import cn.featherfly.juorm.expression.ConditionGroupExpression;
import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.WhereExpression;

/**
 * <p>
 * Updator
 * </p>
 *
 * @author zhongj
 */
public interface PropertyExecutableUpdateExpression<U extends PropertyExecutableUpdateExpression<U, C, L, V, VN>,
        C extends ConditionGroupExpression<C, L>, L extends ConditionGroupLogicExpression<C, L>,
        V extends UpdateValueExpression<U, C, L, Object, V, VN>,
        VN extends UpdateNumberValueExpression<U, C, L, Number, V, VN>>
        extends WhereExpression<C, L>, PropertyUpdateExpression<U, C, L, V, VN>, Executor {

}
