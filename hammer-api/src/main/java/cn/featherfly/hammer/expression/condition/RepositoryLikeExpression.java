
package cn.featherfly.hammer.expression.condition;

/**
 * RepositoryLikeExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryLikeExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends LikeExpression<C, L> {

    /**
     * like value.
     *
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    L lk(String repository, String name, String value);

    /**
     * like value.
     *
     * @param <T>        the generic type
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    <T> L lk(Class<T> repository, String name, String value);

    /**
     * like value.
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L lk(int repositoryIndex, String name, String value);

}