
package cn.featherfly.hammer.expression.entity.condition;

/**
 * The Interface EntityLogicGroupExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityLogicGroupExpression<E, C extends EntityConditionsGroupExpression<E, C, L>,
        L extends EntityLogicGroupExpression<E, C, L>> extends EntityConditionsLogicExpression<E, C, L> {
}
