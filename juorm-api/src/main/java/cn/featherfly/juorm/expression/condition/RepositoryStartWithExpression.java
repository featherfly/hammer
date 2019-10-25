
package cn.featherfly.juorm.expression.condition;

/**
 * <p>
 * StartWithExpression
 * </p>
 *
 * @author zhongj
 */
public interface RepositoryStartWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends StartWithExpression<C, L> {

    /**
     * 以value开始
     *
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    L sw(String repository, String name, String value);

    /**
     * 以value开始
     *
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    <T> L sw(Class<T> repository, String name, String value);

    /**
     * 以value开始
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L sw(int repositoryIndex, String name, String value);

}