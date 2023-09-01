
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;

/**
 * The Interface RepositoryEndWithExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryEndWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EndWithExpression<C, L> {

    /**
     * end with value. 以value结尾.
     *
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    default L ew(String repository, String name, String value) {
        return ew(repository, name, value, MatchStrategy.AUTO);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param repository  repository
     * @param name        参数名称
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L ew(String repository, String name, String value, MatchStrategy queryPolicy);

    /**
     * end with value. 以value结尾.
     *
     * @param <T>        the generic type
     * @param repository repository
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    //    default <T> L ew(Class<T> repository, String name, String value) {
    //        return ew(repository, name, value, MatchStrategy.AUTO);
    //    }

    /**
     * end with value. 以value结尾.
     *
     * @param <T>         the generic type
     * @param repository  repository
     * @param name        参数名称
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    //    <T> L ew(Class<T> repository, String name, String value, MatchStrategy queryPolicy);

    /**
     * end with value. 以value结尾.
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    default L ew(int repositoryIndex, String name, String value) {
        return ew(repositoryIndex, name, value, MatchStrategy.AUTO);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @param queryPolicy     the query policy
     * @return LogicExpression
     */
    L ew(int repositoryIndex, String name, String value, MatchStrategy queryPolicy);
}