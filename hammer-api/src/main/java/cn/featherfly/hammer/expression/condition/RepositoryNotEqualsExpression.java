
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * RepositoryNotEqualsExpression
 * </p>
 * .
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
    L ne(String repository, String name, Object value);

    /**
     * not equals.不等于
     *
     * @param <T>        the generic type
     * @param repository 存储库
     * @param name       参数名称
     * @param value      参数值
     * @return LogicExpression
     */
    <T> L ne(Class<T> repository, String name, Object value);

    /**
     * not equals.不等于
     *
     * @param repositoryIndex repository index
     * @param name            参数名称
     * @param value           参数值
     * @return LogicExpression
     */
    L ne(int repositoryIndex, String name, Object value);

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
    <T, R> L ne(SerializableFunction<T, R> repository, SerializableFunction<T, R> property, R value);

    /**
     * not equals.不等于.
     *
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T, R> L ne(SerializableSupplier<T> repository, SerializableFunction<T, R> property);

}