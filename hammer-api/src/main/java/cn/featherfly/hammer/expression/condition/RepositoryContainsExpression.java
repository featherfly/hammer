
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;

/**
 * The Interface RepositoryContainsExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryContainsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ContainsExpression<C, L> {

    /**
     * contains value .包含value.
     *
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    default L co(String repository, String name, String value) {
        return co(repository, name, value, MatchStrategy.AUTO);
    }

    /**
     * contains value .包含value.
     *
     * @param repository  repository
     * @param name        参数名称
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L co(String repository, String name, String value, MatchStrategy queryPolicy);

    /**
     * contains value .包含value.
     *
     * @param <T>        the generic type
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    //    default <T> L co(Class<T> repository, String name, String value) {
    //        return co(repository, name, value, MatchStrategy.AUTO);
    //    }

    /**
     * contains value .包含value.
     *
     * @param <T>         the generic type
     * @param repository  repository
     * @param name        参数名称
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    //    <T> L co(Class<T> repository, String name, String value, MatchStrategy queryPolicy);

    /**
     * contains value .包含value.
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    default L co(int repositoryIndex, String name, String value) {
        return co(repositoryIndex, name, value, MatchStrategy.AUTO);
    }

    /**
     * contains value .包含value.
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @param queryPolicy     the query policy
     * @return LogicExpression
     */
    L co(int repositoryIndex, String name, String value, MatchStrategy queryPolicy);

}