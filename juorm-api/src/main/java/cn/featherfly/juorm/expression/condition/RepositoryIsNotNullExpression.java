
package cn.featherfly.juorm.expression.condition;

/**
 * <p>
 * IsNotNullExpression
 * </p>
 *
 * @author zhongj
 */
public interface RepositoryIsNotNullExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends IsNotNullExpression<C, L> {

    /**
     * is not null
     *
     * @param repository repository
     * @param name       参数名称
     * @return LogicExpression
     */
    L inn(String repository, String name);

    /**
     * is not null
     * 
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @return LogicExpression
     */
    L inn(int repositoryIndex, String name);
}