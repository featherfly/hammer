
package cn.featherfly.hammer.expression.condition.type;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.lang.function.SerializableSupplier1;
import cn.featherfly.common.lang.function.SerializableSupplier2;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityInExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityInExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * equals. 包含指定，sql中的in.
     *
     * @param consumer the consumer
     * @return LogicExpression
     */
    L in(Consumer<EntityInExpression<E, C, L>> consumer);

    /**
     * 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <R> L in(SerializableFunction<E, R> name, Object value);

    /**
     * 包含指定，sql中的in.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    <R> L in(SerializableFunction<E, R> name, Object value, Predicate<Object> ignorePolicy);

    /**
     * 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <R> L in(SerializableFunction1<E, R> name, @SuppressWarnings("unchecked") R... value);

    /**
     * 包含指定，sql中的in.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    <R> L in(SerializableFunction1<E, R> name, R[] value, Predicate<R[]> ignorePolicy);

    /**
     * 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <R> L in(SerializableFunction2<E, R> name, Collection<R> value);

    /**
     * 包含指定，sql中的in.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    <R> L in(SerializableFunction2<E, R> name, Collection<R> value, Predicate<Collection<R>> ignorePolicy);

    /**
     * 包含指定，sql中的in.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R> L in(SerializableSupplier<R> property);

    /**
     * 包含指定，sql中的in.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    <R> L in(SerializableSupplier<R> property, Predicate<R> ignorePolicy);

    /**
     * 包含指定，sql中的in.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R> L in(SerializableSupplier1<R[]> property);

    /**
     * 包含指定，sql中的in.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    <R> L in(SerializableSupplier1<R[]> property, Predicate<R[]> ignorePolicy);

    /**
     * 包含指定，sql中的in.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R> L in(SerializableSupplier2<Collection<R>> property);

    /**
     * 包含指定，sql中的in.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    <R> L in(SerializableSupplier2<Collection<R>> property, Predicate<Collection<R>> ignorePolicy);

    /**
     * 包含指定，sql中的in.
     *
     * @param <R>        the generic type
     * @param <V>        the value type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R, V> L in(SerializableFunction<E, R> repository, SerializableFunction<R, V> property, V value);

    /**
     * 包含指定，sql中的in.
     *
     * @param <R>        the generic type
     * @param <V>        the value type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R, V> L in(SerializableSupplier<R> repository, SerializableFunction<R, V> property);
}