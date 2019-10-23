
package cn.featherfly.juorm.expression.condition;

/**
 * <p>
 * EqualsExpressoin
 * </p>
 *
 * @author zhongj
 */
public interface RepositoryEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EqualsExpression<C, L> {

    /**
     * 等于
     *
     * @param repository 存储库
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    L eq(String repository, String name, Object value);

    /**
     * 等于
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L eq(int repositoryIndex, String name, Object value);
}