
package cn.featherfly.hammer.expression.entity.condition.nin;

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
 * The Interface EntityNotInExpressionBase2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotInExpressionBase2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityNotInExpression<E, C, L> {

    //    /**
    //     * equals. 不包含指定，sql中的not in.
    //     *
    //     * @param consumer the consumer
    //     * @return LogicExpression
    //     */
    //    L nin2(Consumer<EntityNotInExpressionBase2<E, C, L>> consumer);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <R> L nin2(SerializableFunction<E2, R> name, R value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L nin2(SerializableFunction<E2, R> name, R value, Predicate<R> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L nin2(SerializableToIntFunction2<E2> name, int value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nin2(SerializableToIntFunction2<E2> name, int value, Predicate<Integer> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L nin2(SerializableToLongFunction2<E2> name, long value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nin2(SerializableToLongFunction2<E2> name, long value, Predicate<Long> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <R> L nin2(SerializableFunction<E2, R> name, @SuppressWarnings("unchecked") R... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L nin2(SerializableToIntFunction2<E2> name, int... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L nin2(SerializableToLongFunction2<E2> name, long... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L nin2(SerializableFunction<E2, R> name, R[] value, Predicate<R[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nin2(SerializableToIntFunction2<E2> name, int[] value, Predicate<int[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nin2(SerializableToLongFunction2<E2> name, long[] value, Predicate<long[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <R> L nin2(SerializableFunction<E2, R> name, Collection<R> value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L nin2(SerializableFunction<E2, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R> L nin2(SerializableSupplier<R> property);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L nin2(SerializableSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R> L nin2(SerializableIntSupplier property);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L nin2(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R> L nin2(SerializableLongSupplier property);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L nin2(SerializableLongSupplier property, Predicate<Long> ignoreStrategy);

    //    /**
    //     * values not in. 不包含指定，sql中的not in.
    //     *
    //     * @param <R>      the generic type
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    <R> L nin2(SerializableSupplier1<R[]> property);
    //
    //    /**
    //     * values not in. 不包含指定，sql中的not in.
    //     *
    //     * @param <R>          the generic type
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <R> L nin2(SerializableSupplier1<R[]> property, Predicate<R[]> ignoreStrategy);
    //
    //    /**
    //     * values not in. 不包含指定，sql中的not in.
    //     *
    //     * @param <R>      the generic type
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    <R> L nin2(SerializableSupplier2<Collection<R>> property);
    //
    //    /**
    //     * values not in. 不包含指定，sql中的not in.
    //     *
    //     * @param <R>          the generic type
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <R> L nin2(SerializableSupplier2<Collection<R>> property, Predicate<Collection<R>> ignoreStrategy);

    // 嵌套属性使用property(U1::getU2).property(U2:getV).nin(v)来设置
    //    /**
    //     * values not in. 不包含指定，sql中的not in.
    //     *
    //     * @param <R>        the generic type
    //     * @param <V>        the value type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R, V> L nin2(SerializableFunction<E2, R> repository, SerializableFunction<R, V> property, V value);
    //
    //    /**
    //     * values not in. 不包含指定，sql中的not in.
    //     *
    //     * @param <R>        the generic type
    //     * @param <V>        the value type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <R, V> L nin2(SerializableSupplier<R> repository, SerializableFunction<R, V> property);
}