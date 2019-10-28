
package cn.featherfly.juorm.expression.condition;

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
        L extends RepositoryLogicGroupExpression<C, L>> extends LogicExpression<C, L> {

    /**
     * 结束当前条件逻辑组并返回上一级逻辑组.
     *
     * @return parent LogicBuilder
     */
    L endGroup();
}
