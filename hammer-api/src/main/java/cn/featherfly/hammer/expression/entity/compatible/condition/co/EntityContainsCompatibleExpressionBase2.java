
package cn.featherfly.hammer.expression.entity.compatible.condition.co;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.co.ContainsExpression2;
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpressionBase2;

/**
 * The Interface EntityContainsCompatibleExpressionBase2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityContainsCompatibleExpressionBase2<E, E2, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityContainsExpressionBase2<E, E2, C, L>, ContainsExpression2<C, L> {

}