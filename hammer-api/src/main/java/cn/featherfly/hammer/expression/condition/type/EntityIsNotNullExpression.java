
package cn.featherfly.hammer.expression.condition.type;

import java.util.function.Consumer;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityIsNotNullExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityIsNotNullExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * is not null.
     *
     * @param consumer the consumer
     * @return LogicExpression
     */
    L inn(Consumer<EntityIsNotNullExpression<E, C, L>> consumer);

    /**
     * is not null.
     *
     * @param <R>  the generic type
     * @param name 参数名称
     * @return LogicExpression
     */
    default <R> L inn(SerializableFunction<E, R> name) {
        return inn(name, true);
    }

    /**
     * is not null.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value if true, is not null; if false, is null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    <R> L inn(SerializableFunction<E, R> name, Boolean value);

    /**
     * is not null.
     *
     * @param <R>        the generic type
     * @param <V>        the value type
     * @param repository the repository
     * @param property   the property
     * @return LogicExpression
     */
    default <R, V> L inn(SerializableFunction<E, R> repository, SerializableFunction<R, V> property) {
        return inn(repository, property);
    }

    /**
     * is not null.
     *
     * @param <R>        the generic type
     * @param <V>        the value type
     * @param repository the repository
     * @param property   the property
     * @param value      if true, is not null; if false, is null; if null,
     *                   ignore this operate
     * @return LogicExpression
     */
    <R, V> L inn(SerializableFunction<E, R> repository, SerializableFunction<R, V> property, Boolean value);
}