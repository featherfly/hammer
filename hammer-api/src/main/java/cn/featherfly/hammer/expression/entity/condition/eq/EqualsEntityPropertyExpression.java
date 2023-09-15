
package cn.featherfly.hammer.expression.entity.condition.eq;

import java.util.Collection;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;

/**
 * The Interface EqualsEntityPropertyExpression.
 *
 * @author zhongj
 * @param <V> the value type
 */
public interface EqualsEntityPropertyExpression<V> {

    /**
     * entity equals function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity equals function property expression.
     */
    <R> EqualsEntityPropertyExpression<R> property(SerializableFunction<V, R> name);

    /**
     * entity equals function property expression.
     *
     * @param <R>  the generic type
     * @param <RE> the generic type
     * @param name the name
     * @return entity equals function property expression.
     */
    <R extends Collection<RE>,
            RE> EqualsEntityPropertyExpression<RE> property(SerializableToCollectionFunction<V, R, RE> name);

    /**
     * Value.
     *
     * @param value 参数值
     * @return LogicExpression
     */
    void value(V value);

    /**
     * Value.
     *
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    void value(V value, MatchStrategy matchStrategy);

    /**
     * Value.
     *
     * @param value        the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void value(V value, Predicate<V> ignoreStrategy);

    /**
     * Value.
     *
     * @param value        the value
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void value(V value, MatchStrategy matchStrategy, Predicate<V> ignoreStrategy);
}
