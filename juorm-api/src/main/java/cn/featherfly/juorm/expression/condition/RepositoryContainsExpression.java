
package cn.featherfly.juorm.expression.condition;

/**
 * <p>
 * ContainsExpression
 * </p>
 *
 * @author zhongj
 */
public interface RepositoryContainsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ContainsExpression<C, L> {

    /**
     * 包含value
     *
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    L co(String repository, String name, String value);

    /**
     * 包含value
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L co(int repositoryIndex, String name, String value);

}