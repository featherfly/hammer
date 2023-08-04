
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityPropertyConditionsExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
// YUFEI_TODO 这个接口层次也许可以去掉
public interface EntityPropertyConditionsExpression<E, C extends EntityConditionsExpression<E, C, L>,
        L extends LogicExpression<C, L>> extends EntityPropertyExpression<E, C, L> {

}
