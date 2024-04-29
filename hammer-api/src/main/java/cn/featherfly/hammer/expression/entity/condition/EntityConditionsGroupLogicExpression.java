
package cn.featherfly.hammer.expression.entity.condition;

/**
 * entity conditions group logic expression.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityConditionsGroupLogicExpression<E1, C extends EntityConditionsGroupExpression<E1, C, L>,
    L extends EntityConditionsGroupLogicExpression<E1, C, L>> extends EntityConditionsLogicExpression<E1, C, L> {
}
