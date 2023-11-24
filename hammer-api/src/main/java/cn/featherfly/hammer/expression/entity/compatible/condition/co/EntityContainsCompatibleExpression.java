
package cn.featherfly.hammer.expression.entity.compatible.condition.co;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.co.ContainsExpression;
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpression;

/**
 * entity contains compatible expression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityContainsCompatibleExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityContainsExpression<E, C, L>, ContainsExpression<C, L> {

}