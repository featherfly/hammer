
package cn.featherfly.hammer.expression.condition.type;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityIsNullExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityIsNullExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * is null.
     *
     * @param <R>  the generic type
     * @param name 参数名称
     * @return LogicExpression
     */
    <R> L isn(SerializableFunction<E, R> name);

    /**
     * is null.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    <R> L isn(SerializableFunction<E, R> name, Boolean value);

    /**
     * is null.
     *
     * @param <R>        the generic type
     * @param <V>        the value type
     * @param repository the repository
     * @param property   the property
     * @return LogicExpression
     */
    <R, V> L isn(SerializableFunction<E, R> repository, SerializableFunction<R, V> property);

    /**
     * is null.
     *
     * @param <R>        the generic type
     * @param <V>        the value type
     * @param repository the repository
     * @param property   the property
     * @param value      if true, is null; if false, is not null; if null,
     *                   ignore this operate
     * @return LogicExpression
     */
    <R, V> L isn(SerializableFunction<E, R> repository, SerializableFunction<R, V> property, Boolean value);
}