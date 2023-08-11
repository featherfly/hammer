
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.lang.function.SerializableToStringFunction;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;

/**
 * TypeLikeExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface TypeLikeExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends LikeExpression<C, L> {

    /**
     * like value.
     *
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R> L lk(SerializableFunction<T, R> repository, SerializableToStringFunction<R> property, Object value);

    /**
     * like value.
     *
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T, R> L lk(SerializableSupplier<T> repository, SerializableToStringFunction<T> property);
}