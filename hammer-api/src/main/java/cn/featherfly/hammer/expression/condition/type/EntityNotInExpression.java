
package cn.featherfly.hammer.expression.condition.type;

import java.util.Collection;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.lang.function.SerializableSupplier1;
import cn.featherfly.common.lang.function.SerializableSupplier2;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotInExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityNotInExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * 不包含指定，sql中的not in.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L nin(SerializableFunction<E, ?> name, Object value);

    /**
     * 不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <R> L nin(SerializableFunction<E, R> name, R[] value);

    /**
     * 不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <R> L nin(SerializableFunction<E, R> name, Collection<R> value);

    /**
     * 不包含指定，sql中的not in.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R> L nin(SerializableSupplier<R> property);

    /**
     * 不包含指定，sql中的not in.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R> L nin(SerializableSupplier1<R[]> property);

    /**
     * 不包含指定，sql中的not in.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R> L nin(SerializableSupplier2<Collection<R>> property);

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
    <R, V> L nin(SerializableFunction<E, R> repository, SerializableFunction<R, V> property, V value);

    /**
     * 包含指定，sql中的in.
     *
     * @param <R>        the generic type
     * @param <V>        the value type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R, V> L nin(SerializableSupplier<R> repository, SerializableFunction<R, V> property);
}