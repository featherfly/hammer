
package cn.featherfly.juorm.expression.condition;

/**
 * <p>
 * RepositoryIsNullExpression
 * </p>
 * .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryIsNullExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends IsNullExpression<C, L> {

    /**
     * is null.
     *
     * @param repository repository
     * @param name       参数名称
     * @return LogicExpression
     */
    L isn(String repository, String name);

    /**
     * is null.
     *
     * @param <T>        the generic type
     * @param repository repository
     * @param name       参数名称
     * @return LogicExpression
     */
    <T> L isn(Class<T> repository, String name);

    /**
     * is null.
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @return LogicExpression
     */
    L isn(int repositoryIndex, String name);
}