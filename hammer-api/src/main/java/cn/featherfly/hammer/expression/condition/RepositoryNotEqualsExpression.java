
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.repository.operate.QueryOperator.QueryPolicy;

/**
 * The Interface RepositoryNotEqualsExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NotEqualsExpression<C, L> {

    /**
     * not equals.不等于
     *
     * @param repository 存储库
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    default L ne(String repository, String name, Object value) {
        return ne(repository, name, value, QueryPolicy.AUTO);
    }

    /**
     * not equals.不等于
     *
     * @param repository  存储库
     * @param name        参数名称
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L ne(String repository, String name, Object value, QueryPolicy queryPolicy);

    /**
     * not equals.不等于
     *
     * @param <T>        the generic type
     * @param repository 存储库
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    default <T> L ne(Class<T> repository, String name, Object value) {
        return ne(repository, name, value, QueryPolicy.AUTO);
    }

    /**
     * not equals.不等于
     *
     * @param <T>         the generic type
     * @param repository  存储库
     * @param name        参数名称
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <T> L ne(Class<T> repository, String name, Object value, QueryPolicy queryPolicy);

    /**
     * not equals.不等于
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    default L ne(int repositoryIndex, String name, Object value) {
        return ne(repositoryIndex, name, value, QueryPolicy.AUTO);
    }

    /**
     * not equals.不等于
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @param queryPolicy     the query policy
     * @return LogicExpression
     */
    L ne(int repositoryIndex, String name, Object value, QueryPolicy queryPolicy);

    /**
     * not equals.不等于.
     *
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    default <T, R> L ne(SerializableFunction<T, R> repository, SerializableFunction<T, R> property, R value) {
        return ne(repository, property, value, QueryPolicy.AUTO);
    }

    /**
     * not equals.不等于.
     *
     * @param <T>         the generic type
     * @param <R>         the generic type
     * @param repository  the repository
     * @param property    the property
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <T, R> L ne(SerializableFunction<T, R> repository, SerializableFunction<T, R> property, R value,
            QueryPolicy queryPolicy);

    /**
     * not equals.不等于.
     *
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    default <T, R> L ne(SerializableSupplier<T> repository, SerializableFunction<T, R> property) {
        return ne(repository, property, QueryPolicy.AUTO);
    }

    /**
     * not equals.不等于.
     *
     * @param <T>         the generic type
     * @param <R>         the generic type
     * @param repository  the repository
     * @param property    对象属性
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <T, R> L ne(SerializableSupplier<T> repository, SerializableFunction<T, R> property, QueryPolicy queryPolicy);

}