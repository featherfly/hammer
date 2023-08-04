
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;

/**
 * <p>
 * NotEqualsExpression
 * </p>
 * .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface TypeNotEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NotEqualsExpression<C, L> {

    /**
     * not equals.不等于.
     *
     * @param <O>        the generic type
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <O, T, R> L ne(SerializableFunction<O, T> repository, SerializableFunction<T, R> property, R value);

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