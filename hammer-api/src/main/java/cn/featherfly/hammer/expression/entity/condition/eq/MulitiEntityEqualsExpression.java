
package cn.featherfly.hammer.expression.entity.condition.eq;

import java.util.function.Predicate;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
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
        return eq(index, name, value, QueryPolicy.AUTO);
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
        return eq(index, name, value, QueryPolicy.AUTO, ignoreStrategy);
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
    <E, R> L eq(int index, SerializableFunction<E, R> name, R value, QueryPolicy queryPolicy);

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
    <E, R> L eq(int index, SerializableFunction<E, R> name, R value, QueryPolicy queryPolicy,
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
        return eq(index, property, QueryPolicy.AUTO);
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
        return eq(index, property, QueryPolicy.AUTO, ignoreStrategy);
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
    <R> L eq(int index, SerializableSupplier<R> property, QueryPolicy queryPolicy);

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
    <R> L eq(int index, SerializableSupplier<R> property, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy);
}