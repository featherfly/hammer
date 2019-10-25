
package cn.featherfly.juorm.expression.condition;

/**
 * <p>
 * InExpression
 * </p>
 *
 * @author zhongj
 */
public interface RepositoryInExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends InExpression<C, L> {

    /**
     * 包含指定，sql中的in
     *
     * @param repository 存储库
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    L in(String repository, String name, Object value);

    /**
     * 包含指定，sql中的in
     *
     * @param repository 存储库
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    <T> L in(Class<T> repository, String name, Object value);

    /**
     * 包含指定，sql中的in
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L in(int repositoryIndex, String name, Object value);
}