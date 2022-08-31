
package cn.featherfly.hammer.expression.condition;

/**
 * <p>
 * repository condition expression
 * </p>
 *
 * @author zhongj
 */
public interface RepositoryConditionsGroupExpression<C extends RepositoryConditionsGroupExpression<C, L>,
        L extends LogicExpression<C, L>> extends RepositoryConditionsExpression<C, L>, GroupExpression<C, L> {
}
