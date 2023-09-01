
package cn.featherfly.hammer.expression.entity.condition.ne;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotEqualsExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityNotEqualsExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    //    /**
    //     * not equals. 不等于.
    //     *
    //     * @param <R>      the generic type
    //     * @param consumer the consumer
    //     * @return LogicExpression
    //     */
    //    L ne(Consumer<EntityEqualsExpression<E, C, L>> consumer);

    /**
     * not equals. 不等于.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <R> L ne(SerializableFunction<E, R> name, R value) {
        return ne(name, value, MatchStrategy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(SerializableFunction<E, R> name, R value, Predicate<R> ignoreStrategy) {
        return ne(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>         the generic type
     * @param name        参数名称
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <R> L ne(SerializableFunction<E, R> name, R value, MatchStrategy queryPolicy);

    /**
     * not equals. 不等于.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(SerializableFunction<E, R> name, R value, MatchStrategy queryPolicy, Predicate<R> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    default <R> L ne(SerializableSupplier<R> property) {
        return ne(property, MatchStrategy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ne(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>         the generic type
     * @param property    对象属性
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <R> L ne(SerializableSupplier<R> property, MatchStrategy queryPolicy);

    /**
     * not equals. 不等于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(SerializableSupplier<R> property, MatchStrategy queryPolicy, Predicate<R> ignoreStrategy);

    //    嵌套属性使用property(U1::getU2).property(U2:getV).ne(v)来设置
    //    /**
    //     * not equals.不等于.
    //     *
    //     * @param <T>        the generic type
    //     * @param <R>        the generic type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <T, R> L ne(SerializableFunction<E, T> repository, SerializableFunction<T, R> property, R value);
    //
    //    /**
    //     * not equals.不等于.
    //     *
    //     * @param <R>        the generic type
    //     * @param <V>        the value type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <R, V> L ne(SerializableSupplier<R> repository, SerializableFunction<R, V> property);
}