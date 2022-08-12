
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.repository.operate.QueryOperator.QueryPolicy;

/**
 * The Interface RepositoryStartWithExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryStartWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends StartWithExpression<C, L> {

    /**
     * start with value. 以value开始.
     *
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    default L sw(String repository, String name, String value) {
        return sw(repository, name, value, QueryPolicy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param repository  repository
     * @param name        参数名称
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L sw(String repository, String name, String value, QueryPolicy queryPolicy);

    /**
     * start with value. 以value开始.
     *
     * @param <T>        the generic type
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    default <T> L sw(Class<T> repository, String name, String value) {
        return sw(repository, name, value, QueryPolicy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param <T>         the generic type
     * @param repository  repository
     * @param name        参数名称
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <T> L sw(Class<T> repository, String name, String value, QueryPolicy queryPolicy);

    /**
     * start with value. 以value开始.
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    default L sw(int repositoryIndex, String name, String value) {
        return sw(repositoryIndex, name, value, QueryPolicy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @param queryPolicy     the query policy
     * @return LogicExpression
     */
    L sw(int repositoryIndex, String name, String value, QueryPolicy queryPolicy);

}