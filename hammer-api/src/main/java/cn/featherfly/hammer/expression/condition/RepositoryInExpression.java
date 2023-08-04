
package cn.featherfly.hammer.expression.condition;

/**
 * <p>
 * RepositoryInExpression
 * </p>
 * .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryInExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends InExpression<C, L> {

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param repository 存储库
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    L in(String repository, String name, Object value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>        the generic type
     * @param repository 存储库
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    //    <T> L in(Class<T> repository, String name, Object value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L in(int repositoryIndex, String name, Object value);
}