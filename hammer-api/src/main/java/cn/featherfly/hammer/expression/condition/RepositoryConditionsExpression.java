
package cn.featherfly.hammer.expression.condition;

/**
 * <p>
 * repository condition expression
 * </p>
 *
 * @author zhongj
 */
public interface RepositoryConditionsExpression<C extends RepositoryConditionsExpression<C, L>,
        L extends LogicExpression<C, L>>
        extends RepositoryContainsExpression<C, L>, RepositoryEndWithExpression<C, L>, RepositoryEqualsExpression<C, L>,
        RepositoryGreatEqualsExpressoin<C, L>, RepositoryGreatThanExpressoin<C, L>, RepositoryInExpression<C, L>,
        RepositoryIsNotNullExpression<C, L>, RepositoryIsNullExpression<C, L>, RepositoryLessEqualsExpressoin<C, L>,
        RepositoryLessThanExpressoin<C, L>, RepositoryNotEqualsExpression<C, L>, RepositoryNotInExpression<C, L>,
        RepositoryStartWithExpression<C, L>, RepositoryPropertyConditionsExpression<C, L>, ConditionsExpression<C, L> {
}
