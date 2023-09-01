
package cn.featherfly.hammer.expression.entity.condition.in;

import java.util.Collection;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToIntFunction2;
import cn.featherfly.common.function.serializable.SerializableToLongFunction2;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityInExpressionBase2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityInExpressionBase2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityInExpression<E, C, L> {

    //    /**
    //     * equals. 包含指定，sql中的in.
    //     *
    //     * @param consumer the consumer
    //     * @return LogicExpression
    //     */
    //    L in2(Consumer<EntityInExpressionBase2<E, C, L>> consumer);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <R> L in2(SerializableFunction<E2, R> name, R value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in2(SerializableFunction<E2, R> name, R value, Predicate<R> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L in2(SerializableToIntFunction2<E2> name, int value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in2(SerializableToIntFunction2<E2> name, int value, Predicate<Integer> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L in2(SerializableToLongFunction2<E2> name, long value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in2(SerializableToLongFunction2<E2> name, long value, Predicate<Long> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <R> L in2(SerializableFunction<E2, R> name, @SuppressWarnings("unchecked") R... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L in2(SerializableToIntFunction2<E2> name, int... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L in2(SerializableToLongFunction2<E2> name, long... value);

    //    /**
    //     * values in. 包含指定，sql中的in.
    //     *
    //     * @param <R>   the generic type
    //     * @param name  参数名称
    //     * @param value 参数值
    //     * @return LogicExpression
    //     */
    //    <R> L in2(SerializableFunction3<E2, R> name, R[] value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in2(SerializableFunction<E2, R> name, R[] value, Predicate<R[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in2(SerializableToIntFunction2<E2> name, int[] value, Predicate<int[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in2(SerializableToLongFunction2<E2> name, long[] value, Predicate<long[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <R> L in2(SerializableFunction<E2, R> name, Collection<R> value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in2(SerializableFunction<E2, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R> L in2(SerializableSupplier<R> property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in2(SerializableSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R> L in2(SerializableIntSupplier property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in2(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R> L in2(SerializableLongSupplier property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in2(SerializableLongSupplier property, Predicate<Long> ignoreStrategy);

    //    /**
    //     * values in. 包含指定，sql中的in.
    //     *
    //     * @param <R>      the generic type
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    <R> L in2(ArraySupplier<R> property);
    //
    //    /**
    //     * values in. 包含指定，sql中的in.
    //     *
    //     * @param <R>          the generic type
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <R> L in2(ArraySupplier<R> property, Predicate<R[]> ignoreStrategy);
    //
    //    /**
    //     * values in. 包含指定，sql中的in.
    //     *
    //     * @param <R>      the generic type
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    <R> L in2(CollectionSupplier<R> property);
    //
    //    /**
    //     * values in. 包含指定，sql中的in.
    //     *
    //     * @param <R>          the generic type
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <R> L in2(CollectionSupplier<R> property, Predicate<Collection<R>> ignoreStrategy);
    //
    //    /**
    //     * values in. 包含指定，sql中的in.
    //     *
    //     * @param <R>      the generic type
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    <R> L in2(ListSupplier<R> property);
    //
    //    /**
    //     * values in. 包含指定，sql中的in.
    //     *
    //     * @param <R>          the generic type
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <R> L in2(ListSupplier<R> property, Predicate<List<R>> ignoreStrategy);
    //
    //    /**
    //     * values in. 包含指定，sql中的in.
    //     *
    //     * @param <R>      the generic type
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    <R> L in2(SetSupplier<R> property);
    //
    //    /**
    //     * values in. 包含指定，sql中的in.
    //     *
    //     * @param <R>          the generic type
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <R> L in2(SetSupplier<R> property, Predicate<Set<R>> ignoreStrategy);

    // 嵌套属性使用property(U1::getU2).property(U2:getV).in(v)来设置
    //    /**
    //     * values in. 包含指定，sql中的in.
    //     *
    //     * @param <R>        the generic type
    //     * @param <V>        the value type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R, V> L in2(SerializableFunction<E2, R> repository, SerializableFunction<R, V> property, V value);
    //
    //    /**
    //     * values in. 包含指定，sql中的in.
    //     *
    //     * @param <R>        the generic type
    //     * @param <V>        the value type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <R, V> L in2(SerializableSupplier<R> repository, SerializableFunction<R, V> property);
}