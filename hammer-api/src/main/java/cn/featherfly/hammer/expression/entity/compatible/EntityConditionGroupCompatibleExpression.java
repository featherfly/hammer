
package cn.featherfly.hammer.expression.entity.compatible;

/**
 * The Interface EntityConditionGroupCompatibleExpression.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <C> condition expression
 * @param <L> logic expression
 */
// ENHANCE 这一层次接口是否需要删除
public interface EntityConditionGroupCompatibleExpression<E1,
    C extends EntityConditionGroupCompatibleExpression<E1, C, L>,
    L extends EntityConditionGroupLogicCompatibleExpression<E1, C, L>>
    extends EntityConditionsGroupCompatibleExpression<E1, C, L> {
}
