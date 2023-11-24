
package cn.featherfly.hammer.expression.repository.condition;

/**
 * PropertyConditionExpression.
 *
 * @author zhongj
 */
public interface PropertyConditionsExpression<C extends RepositoryConditionsExpression<C, L>,
        L extends RepositoryConditionsLogicExpression<C, L>> extends RepositoryFieldExpression<C, L> {

}
