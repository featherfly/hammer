
package cn.featherfly.hammer.expression.condition;

/**
 * all condition expression.
 *
 * @author zhongj
 */
public interface ConditionsExpression<C extends ConditionsExpression<C, L>, L extends LogicExpression<C, L>>
        extends ContainsExpression<C, L>, EndWithExpression<C, L>, EqualsExpression<C, L>, GreatEqualsExpression<C, L>,
        GreatThanExpression<C, L>, InExpression<C, L>, IsNotNullExpression<C, L>, IsNullExpression<C, L>,
        LessEqualsExpression<C, L>, LessThanExpression<C, L>, NotEqualsExpression<C, L>, NotInExpression<C, L>,
        StartWithExpression<C, L>, LikeExpression<C, L>, PropertyConditionsExpression<C, L>,
        StringConditionExpression<C, L> {
}
