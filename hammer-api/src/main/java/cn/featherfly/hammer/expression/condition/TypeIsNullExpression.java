
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.lang.function.SerializableFunction;

/**
 * TypeIsNullExpression. .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface TypeIsNullExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends IsNullExpression<C, L> {

    /**
     * is null.
     *
     * @param <O>        the generic type
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   the property
     * @return LogicExpression
     */
    <O, T, R> L isn(SerializableFunction<O, T> repository, SerializableFunction<T, R> property);

    /**
     * is null.
     *
     * @param <O>        the generic type
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   the property
     * @param value      if true, is null; if false, is not null; if null,
     *                   ignore this operate
     * @return LogicExpression
     */
    <O, T, R> L isn(SerializableFunction<O, T> repository, SerializableFunction<T, R> property, Boolean value);
}