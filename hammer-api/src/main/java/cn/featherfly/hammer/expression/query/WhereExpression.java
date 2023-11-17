
package cn.featherfly.hammer.expression.query;

import cn.featherfly.hammer.expression.api.Where;

/**
 * WhereExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface WhereExpression<C extends cn.featherfly.hammer.expression.condition.ConditionExpression>
        extends Where<C> {

}
