
package cn.featherfly.juorm.expression.condition;

/**
 * <p>
 * RepositoryEndWithExpression
 * </p>
 * .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryEndWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EndWithExpression<C, L> {

    /**
     * 以value结尾.
     *
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    L ew(String repository, String name, String value);

    /**
     * 以value结尾.
     *
     * @param <T>        the generic type
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    <T> L ew(Class<T> repository, String name, String value);

    /**
     * 以value结尾.
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L ew(int repositoryIndex, String name, String value);
}