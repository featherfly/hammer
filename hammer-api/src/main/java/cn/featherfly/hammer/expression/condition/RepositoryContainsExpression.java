
package cn.featherfly.hammer.expression.condition;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * RepositoryContainsExpression
 * </p>
 * .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryContainsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ContainsExpression<C, L> {

    /**
     * 包含value.
     *
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    L co(String repository, String name, String value);

    /**
     * 包含value.
     *
     * @param <T>        the generic type
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    <T> L co(Class<T> repository, String name, String value);

    /**
     * 包含value.
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L co(int repositoryIndex, String name, String value);

}