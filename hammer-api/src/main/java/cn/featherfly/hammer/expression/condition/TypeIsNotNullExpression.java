
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.lang.function.SerializableFunction;

/**
 * TypeIsNotNullExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface TypeIsNotNullExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends IsNotNullExpression<C, L> {

    /**
     * is not null.
     *
     * @param <O>        the generic type
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   the property
     * @return LogicExpression
     */
    <O, T, R> L inn(SerializableFunction<O, T> repository, SerializableFunction<T, R> property);

    /**
     * is not null.
     *
     * @param <O>        the generic type
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   the property
     * @param value      if true, is not null; if false, is null; if null,
     *                   ignore this operate
     * @return LogicExpression
     */
    <O, T, R> L inn(SerializableFunction<O, T> repository, SerializableFunction<T, R> property, Boolean value);
}