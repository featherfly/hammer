
package cn.featherfly.hammer.expression.entity.compatible;

/**
 * entity conditions group logic expression.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityConditionsGroupLogicCompatibleExpression<E1, C extends EntityConditionsGroupCompatibleExpression<E1, C, L>,
    L extends EntityConditionsGroupLogicCompatibleExpression<E1, C, L>> extends EntityConditionsLogicCompatibleExpression<E1, C, L> {
}
