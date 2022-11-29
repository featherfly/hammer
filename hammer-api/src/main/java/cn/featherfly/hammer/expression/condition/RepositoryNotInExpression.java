
package cn.featherfly.hammer.expression.condition;

/**
 * <p>
 * RepositoryNotInExpression
 * </p>
 * .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotInExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NotInExpression<C, L> {

    /**
     * 不包含指定，sql中的not in.
     *
     * @param repository 存储库
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    L nin(String repository, String name, Object value);

    /**
     * 不包含指定，sql中的not in.
     *
     * @param <T>        the generic type
     * @param repository 存储库
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    //    <T> L nin(Class<T> repository, String name, Object value);

    /**
     * 不包含指定，sql中的not in.
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L nin(int repositoryIndex, String name, Object value);

}