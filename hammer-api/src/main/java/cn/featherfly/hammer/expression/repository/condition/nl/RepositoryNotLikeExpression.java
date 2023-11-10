
package cn.featherfly.hammer.expression.repository.condition.nl;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nl.NotLikeExpression;

/**
 * repository not like expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotLikeExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NotLikeExpression<C, L> {

    /**
     * not like value.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <T> L nl(SerializableToStringFunction<T> name, String value) {
        return nl(name, value, MatchStrategy.AUTO);
    }

    /**
     * not like value.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nl(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return nl(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nl(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return nl(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * Lk.
     *
     * @param <T>           the generic type
     * @param name          the name 参数名称
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    <T> L nl(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy);

    /**
     * Lk.
     *
     * @param <T>            the generic type
     * @param name           the name 参数名称
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    <T> L nl(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy);

    /**
     * Lk.
     *
     * @param <T>            the generic type
     * @param name           the name 参数名称
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    <T> L nl(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * not like value.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    default L nl(SerializableStringSupplier property) {
        return nl(property, MatchStrategy.AUTO);
    }

    /**
     * not like value.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        return nl(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return nl(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * Lk.
     *
     * @param property      the property 对象属性
     * @param matchStrategy the match strategy
     * @return the l
     */
    L nl(SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * Lk.
     *
     * @param property       the property 对象属性
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    L nl(SerializableStringSupplier property, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy);

    /**
     * Lk.
     *
     * @param property       the property 对象属性
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    L nl(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}