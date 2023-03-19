
package cn.featherfly.hammer.expression.condition.type;

import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.lang.function.StringSupplier;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLikeExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityLikeExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {
    /**
     * like value.
     *
     * @param consumer the consumer
     * @return LogicExpression
     */
    L lk(Consumer<EntityLikeExpression<E, C, L>> consumer);

    /**
     * like value.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L lk(SerializableFunction<E, String> name, String value) {
        return lk(name, value, QueryPolicy.AUTO);
    }

    /**
     * like value.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    default L lk(SerializableFunction<E, String> name, String value, Predicate<String> ignorePolicy) {
        return lk(name, value, QueryPolicy.AUTO, ignorePolicy);
    }

    /**
     * like value.
     *
     * @param name        the name 参数名称
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    L lk(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy);

    /**
     * like value.
     *
     * @param name         the name 参数名称
     * @param value        the value
     * @param queryPolicy  the query policy
     * @param ignorePolicy the ignore policy
     * @return the l
     */
    L lk(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy, Predicate<String> ignorePolicy);

    /**
     * like value.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    default L lk(StringSupplier property) {
        return lk(property, QueryPolicy.AUTO);
    }

    /**
     * like value.
     *
     * @param property     对象属性
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    default L lk(StringSupplier property, Predicate<String> ignorePolicy) {
        return lk(property, QueryPolicy.AUTO, ignorePolicy);
    }

    /**
     * like value.
     *
     * @param property    the property 对象属性
     * @param queryPolicy the query policy
     * @return the l
     */
    L lk(StringSupplier property, QueryPolicy queryPolicy);

    /**
     * like value.
     *
     * @param property     the property 对象属性
     * @param queryPolicy  the query policy
     * @param ignorePolicy the ignore policy
     * @return the l
     */
    L lk(StringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignorePolicy);

    /**
     * like value.
     *
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R> L lk(SerializableFunction<E, R> repository, SerializableFunction<R, String> property, String value);

    /**
     * like value.
     *
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R> L lk(SerializableSupplier<R> repository, SerializableFunction<R, String> property);
}