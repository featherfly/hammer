
package cn.featherfly.hammer.expression.entity.condition.ne;

import java.util.function.Predicate;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.MulitiEntityConditionExpression;

/**
 * The Interface MulitiEntityNotEqualsExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiEntityNotEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpression {

    /**
     * not equals. 不等于.
     *
     * @param <E>   the element type
     * @param <R>   the generic type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <E, R> L ne(int index, SerializableFunction<E, R> name, R value) {
        return ne(index, name, value, QueryPolicy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param <E>            the element type
     * @param <R>            the generic type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E, R> L ne(int index, SerializableFunction<E, R> name, R value, Predicate<R> ignoreStrategy) {
        return ne(index, name, value, QueryPolicy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <E>         the element type
     * @param <R>         the generic type
     * @param index       the index
     * @param name        参数名称
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <E, R> L ne(int index, SerializableFunction<E, R> name, R value, QueryPolicy queryPolicy);

    /**
     * not equals. 不等于.
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
    <E, R> L ne(int index, SerializableFunction<E, R> name, R value, QueryPolicy queryPolicy,
            Predicate<R> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <E>      the element type
     * @param <R>      the generic type
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    default <E, R> L ne(int index, SerializableSupplier<R> property) {
        return ne(index, property, QueryPolicy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(int index, SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ne(index, property, QueryPolicy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>         the generic type
     * @param index       the index
     * @param property    对象属性
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <R> L ne(int index, SerializableSupplier<R> property, QueryPolicy queryPolicy);

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       对象属性
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(int index, SerializableSupplier<R> property, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy);
}