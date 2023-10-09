
package cn.featherfly.hammer.expression.condition;

/**
 * all condition expression.
 *
 * @author zhongj
 */
public interface ConditionsExpression<C extends ConditionsExpression<C, L>, L extends LogicExpression<C, L>>
        extends BetweenExpression<C, L>, NotBetweenExpression<C, L> //
        , ContainsExpression<C, L>, NotContainsExpression<C, L> //
        , EndWithExpression<C, L>, NotEndWithExpression<C, L> //
        , EqualsExpression<C, L>, NotEqualsExpression<C, L> // 
        , GreatEqualsExpression<C, L>, GreatThanExpression<C, L> //
        , InExpression<C, L>, NotInExpression<C, L> //
        , IsNotNullExpression<C, L>, IsNullExpression<C, L> //
        , LessEqualsExpression<C, L>, LessThanExpression<C, L>//
        , StartWithExpression<C, L>, NotStartWithExpression<C, L>//
        , LikeExpression<C, L>, NotLikeExpression<C, L> //
        , PropertyConditionsExpression<C, L>, NativeStringConditionExpression<C, L> {
}
