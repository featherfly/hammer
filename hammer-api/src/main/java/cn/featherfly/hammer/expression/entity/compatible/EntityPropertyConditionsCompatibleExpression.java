
package cn.featherfly.hammer.expression.entity.compatible;

import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression;

/**
 * The Interface EntityPropertyConditionsExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
// YUFEI_TODO 这个接口层次也许可以去掉
public interface EntityPropertyConditionsCompatibleExpression<E,
    C extends EntityConditionsCompatibleExpression<E, C, L>,
    L extends EntityConditionsLogicCompatibleExpression<E, C, L>> extends EntityPropertyExpression<E, C, L> {

}
