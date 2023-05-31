
package cn.featherfly.hammer.expression;

import cn.featherfly.hammer.expression.api.Where;

/**
 * WhereExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface WhereExpression<C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>> extends Where<C> {

}
