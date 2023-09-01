
package cn.featherfly.hammer.expression.entity.condition.eq;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.MulitiEntityConditionExpression;

/**
 * The Interface MulitiEntityEqualsExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiEntityEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpression {

    /**
     * equals. 等于.
     *
     * @param <E>   the element type
     * @param <R>   the generic type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <E, R> L eq(int index, SerializableFunction<E, R> name, R value) {
        return eq(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param <E>            the element type
     * @param <R>            the generic type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E, R> L eq(int index, SerializableFunction<E, R> name, R value, Predicate<R> ignoreStrategy) {
        return eq(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <E>         the element type
     * @param <R>         the generic type
     * @param index       the index
     * @param name        参数名称
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <E, R> L eq(int index, SerializableFunction<E, R> name, R value, MatchStrategy queryPolicy);

    /**
     * equals. 等于.
     *
     * @param <E>            the element type
     * @param <R>            the generic type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, R> L eq(int index, SerializableFunction<E, R> name, R value, MatchStrategy queryPolicy,
            Predicate<R> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <E>      the element type
     * @param <R>      the generic type
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    default <E, R> L eq(int index, SerializableSupplier<R> property) {
        return eq(index, property, MatchStrategy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L eq(int index, SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return eq(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>         the generic type
     * @param index       the index
     * @param property    对象属性
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <R> L eq(int index, SerializableSupplier<R> property, MatchStrategy queryPolicy);

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       对象属性
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq(int index, SerializableSupplier<R> property, MatchStrategy queryPolicy, Predicate<R> ignoreStrategy);
}