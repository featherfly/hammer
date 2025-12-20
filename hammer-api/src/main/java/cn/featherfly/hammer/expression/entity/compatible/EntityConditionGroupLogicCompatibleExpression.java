
package cn.featherfly.hammer.expression.entity.compatible;

/**
 * The Interface EntityConditionGroupLogicCompatibleExpression.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <C> condition expression
 * @param <L> logic expression
 */
//ENHANCE 这一层次接口是否需要删除
public interface EntityConditionGroupLogicCompatibleExpression<E1,
    C extends EntityConditionGroupCompatibleExpression<E1, C, L>,
    L extends EntityConditionGroupLogicCompatibleExpression<E1, C, L>>
    extends EntityConditionsGroupLogicCompatibleExpression<E1, C, L> {
}
