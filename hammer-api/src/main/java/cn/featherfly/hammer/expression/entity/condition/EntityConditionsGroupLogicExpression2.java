
package cn.featherfly.hammer.expression.entity.condition;

/**
 * The Interface EntityLogicGroupExpression2.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityConditionsGroupLogicExpression2<E1, E2, C extends EntityConditionsGroupExpression2<E1, E2, C, L>,
    L extends EntityConditionsGroupLogicExpression2<E1, E2, C, L>>
    extends EntityConditionsLogicExpression2<E1, E2, C, L> {
}
