
package cn.featherfly.hammer.expression.entity.condition;

/**
 * entity conditions group logic expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityConditionsGroupLogicExpression<E, C extends EntityConditionsGroupExpression<E, C, L>,
        L extends EntityConditionsGroupLogicExpression<E, C, L>> extends EntityConditionsLogicExpression<E, C, L> {
}
