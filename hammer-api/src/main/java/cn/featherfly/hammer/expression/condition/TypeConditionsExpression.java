
package cn.featherfly.hammer.expression.condition;

/**
 * type condition expression.
 *
 * @author zhongj
 */
public interface TypeConditionsExpression<C extends TypeConditionsExpression<C, L>, L extends LogicExpression<C, L>>
        extends TypeContainsExpression<C, L>, TypeEndWithExpression<C, L>, TypeEqualsExpression<C, L>,
        TypeGreatEqualsExpression<C, L>, TypeGreatThanExpression<C, L>, TypeInExpression<C, L>,
        TypeIsNotNullExpression<C, L>, TypeIsNullExpression<C, L>, TypeLessEqualsExpression<C, L>,
        TypeLessThanExpression<C, L>, TypeNotEqualsExpression<C, L>, TypeNotInExpression<C, L>,
        TypeStartWithExpression<C, L>, TypeLikeExpression<C, L>, TypePropertyConditionsExpression<C, L> {
}
