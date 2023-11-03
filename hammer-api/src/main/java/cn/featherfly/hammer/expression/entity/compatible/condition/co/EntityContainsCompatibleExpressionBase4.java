
package cn.featherfly.hammer.expression.entity.compatible.condition.co;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.co.ContainsExpression4;
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpressionBase4;

/**
 * The Interface EntityContainsCompatibleExpressionBase4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityContainsCompatibleExpressionBase4<E, E2, E3, E4, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends EntityContainsExpressionBase4<E, E2, E3, E4, C, L>, ContainsExpression4<C, L> {

}