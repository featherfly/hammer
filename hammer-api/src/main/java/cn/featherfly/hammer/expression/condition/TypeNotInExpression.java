
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;

/**
 * <p>
 * NotInExpression
 * </p>
 * .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface TypeNotInExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NotInExpression<C, L> {

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <O>        the generic type
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <O, T, R> L nin(SerializableFunction<O, T> repository, SerializableFunction<T, R> property, Object value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T, R> L nin(SerializableSupplier<T> repository, SerializableFunction<T, R> property);
}