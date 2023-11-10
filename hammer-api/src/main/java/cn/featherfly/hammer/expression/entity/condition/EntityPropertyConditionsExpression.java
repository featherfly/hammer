
package cn.featherfly.hammer.expression.entity.condition;

/**
 * The Interface EntityPropertyConditionsExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
// YUFEI_TODO 这个接口层次也许可以去掉
public interface EntityPropertyConditionsExpression<E, C extends EntityConditionsExpression<E, C, L>,
        L extends EntityConditionsLogicExpression<E, C, L>> extends EntityPropertyExpression<E, C, L> {

}
