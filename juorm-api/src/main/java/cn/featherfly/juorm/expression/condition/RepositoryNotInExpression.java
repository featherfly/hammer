
package cn.featherfly.juorm.expression.condition;

/**
 * <p>
 * NotInExpression
 * </p>
 *
 * @author zhongj
 */
public interface RepositoryNotInExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NotInExpression<C, L> {

    /**
     * 不包含指定，sql中的not in
     *
     * @param repository 存储库
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    L nin(String repository, String name, Object value);

    /**
     * 不包含指定，sql中的not in
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L nin(int repositoryIndex, String name, Object value);

}