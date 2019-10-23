
package cn.featherfly.juorm.expression.condition;

/**
 * <p>
 * condition expression
 * </p>
 *
 * @author zhongj
 */
public interface RepositoryConditionsGroupExpression<C extends RepositoryConditionsGroupExpression<C, L>,
        L extends LogicExpression<C, L>> extends RepositoryConditionsExpression<C, L> {

    /**
     * <p>
     * 在当前内部开启一个新的条件逻辑组
     * </p>
     *
     * @return 新条件逻辑组
     */
    C group();
}
