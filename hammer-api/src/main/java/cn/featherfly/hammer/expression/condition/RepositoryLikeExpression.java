
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.operator.QueryOperator.QueryPolicy;

/**
 * RepositoryLikeExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryLikeExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends LikeExpression<C, L> {

    /**
     * like value.
     *
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    default L lk(String repository, String name, String value) {
        return lk(repository, name, value, QueryPolicy.AUTO);
    }

    /**
     * like value.
     *
     * @param repository  repository
     * @param name        参数名称
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L lk(String repository, String name, String value, QueryPolicy queryPolicy);

    /**
     * like value.
     *
     * @param <T>        the generic type
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    default <T> L lk(Class<T> repository, String name, String value) {
        return lk(repository, name, value, QueryPolicy.AUTO);
    }

    /**
     * like value.
     *
     * @param <T>         the generic type
     * @param repository  repository
     * @param name        参数名称
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <T> L lk(Class<T> repository, String name, String value, QueryPolicy queryPolicy);

    /**
     * like value.
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    default L lk(int repositoryIndex, String name, String value) {
        return lk(repositoryIndex, name, value, QueryPolicy.AUTO);
    }

    /**
     * like value.
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @param queryPolicy     the query policy
     * @return LogicExpression
     */
    L lk(int repositoryIndex, String name, String value, QueryPolicy queryPolicy);

}