
package cn.featherfly.hammer.expression.condition;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;

/**
 * NotLikeExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotLikeExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends StringNotLikeExpression<C, L> {

    /**
     * not like value.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L nl(Field name, String value) {
        return nl(name.name(), value);
    }

    /**
     * not like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl(Field name, String value, IgnoreStrategy ignoreStrategy) {
        return nl(name.name(), value, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl(Field name, String value, Predicate<String> ignoreStrategy) {
        return nl(name.name(), value, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param name          参数名称
     * @param value         参数值
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L nl(Field name, String value, MatchStrategy matchStrategy) {
        return nl(name.name(), value, matchStrategy);
    }

    /**
     * not like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl(Field name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return nl(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl(Field name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nl(name.name(), value, matchStrategy, ignoreStrategy);
    }

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