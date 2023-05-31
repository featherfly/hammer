
package cn.featherfly.hammer.expression.condition;

/**
 * <p>
 * 逻辑条件
 * </p>
 * .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryLogicGroupExpression<C extends RepositoryConditionsGroupExpression<C, L>,
        L extends RepositoryLogicGroupExpression<C, L>> extends LogicExpression<C, L>, GroupEndExpression<L> {

}
