
package cn.featherfly.hammer.expression.condition.type;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
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
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R> L in(SerializableSupplier<R> property);

    /**
     * 包含指定，sql中的in.
     *
     * @param <O>        the generic type
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R, V> L in(SerializableFunction<E, R> repository, SerializableFunction<R, V> property, Object value);

    /**
     * 包含指定，sql中的in.
     *
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R, V> L in(SerializableSupplier<R> repository, SerializableFunction<R, V> property);
}