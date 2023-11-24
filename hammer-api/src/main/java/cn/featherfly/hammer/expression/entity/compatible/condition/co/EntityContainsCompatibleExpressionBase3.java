
package cn.featherfly.hammer.expression.entity.compatible.condition.co;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.co.ContainsExpression3;
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpressionBase3;

/**
 * The Interface EntityContainsCompatibleExpressionBase3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityContainsCompatibleExpressionBase3<E, E2, E3, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends EntityContainsExpressionBase3<E, E2, E3, C, L>, ContainsExpression3<C, L> {

}