
package cn.featherfly.juorm.expression.condition;

/**
 * <p>
 * NotEqualsExpressoin
 * </p>
 *
 * @author zhongj
 */
public interface RepositoryNotEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NotEqualsExpression<C, L> {

    /**
     * not equals.不等于
     *
     * @param repository 存储库
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    L ne(String repository, String name, Object value);

    /**
     * not equals.不等于
     *
     * @param repository 存储库
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    <T> L ne(Class<T> repository, String name, Object value);

    /**
     * not equals.不等于
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L ne(int repositoryIndex, String name, Object value);

}