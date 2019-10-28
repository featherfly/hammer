
package cn.featherfly.juorm.expression.condition;

/**
 * <p>
 * RepositoryIsNotNullExpression
 * </p>
 * .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryIsNotNullExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends IsNotNullExpression<C, L> {

    /**
     * is not null.
     *
     * @param repository repository
     * @param name       参数名称
     * @return LogicExpression
     */
    L inn(String repository, String name);

    /**
     * is not null.
     *
     * @param <T>        the generic type
     * @param repository repository
     * @param name       参数名称
     * @return LogicExpression
     */
    <T> L inn(Class<T> repository, String name);

    /**
     * is not null.
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @return LogicExpression
     */
    L inn(int repositoryIndex, String name);
}