
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
 * The Interface EntityContainsExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityContainsExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * contains value. 包含value.
     *
     * @param consumer the consumer
     * @return LogicExpression
     */
    L co(Consumer<EntityContainsExpression<E, C, L>> consumer);

    /**
     * contains value. 包含value.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L co(SerializableFunction<E, String> name, String value) {
        return co(name, value, QueryPolicy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    default L co(SerializableFunction<E, String> name, String value, Predicate<String> ignorePolicy) {
        return co(name, value, QueryPolicy.AUTO, ignorePolicy);
    }

    /**
     * contains value. 包含value.
     *
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    L co(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy);

    /**
     * contains value. 包含value.
     *
     * @param name         the name
     * @param value        the value
     * @param queryPolicy  the query policy
     * @param ignorePolicy the ignore policy
     * @return the l
     */
    L co(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy, Predicate<String> ignorePolicy);

    /**
     * contains value. 包含value.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    default L co(StringSupplier property) {
        return co(property, QueryPolicy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param property     对象属性
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    default L co(StringSupplier property, Predicate<String> ignorePolicy) {
        return co(property, QueryPolicy.AUTO, ignorePolicy);
    }

    /**
     * contains value. 包含value.
     *
     * @param property    the property
     * @param queryPolicy the query policy
     * @return the l
     */
    L co(StringSupplier property, QueryPolicy queryPolicy);

    /**
     * contains value. 包含value.
     *
     * @param property     the property
     * @param queryPolicy  the query policy
     * @param ignorePolicy the ignore policy
     * @return the l
     */
    L co(StringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignorePolicy);

    /**
     * contains value. 包含value.
     *
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R> L co(SerializableFunction<E, R> repository, SerializableFunction<R, String> property, String value);

    /**
     * contains value. 包含value.
     *
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R> L co(SerializableSupplier<R> repository, SerializableFunction<R, String> property);
}