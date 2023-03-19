
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
 * The Interface EntityEndWithExpression.
 *
 * @author zhongj
 * @param <E> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityEndWithExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {
    /**
     * end with value. 以value结尾.
     *
     * @param consumer the consumer
     * @return LogicExpression
     */
    L ew(Consumer<EntityEndWithExpression<E, C, L>> consumer);

    /**
     * end with value. 以value结尾.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L ew(SerializableFunction<E, String> name, String value) {
        return ew(name, value, QueryPolicy.AUTO);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    default L ew(SerializableFunction<E, String> name, String value, Predicate<String> ignorePolicy) {
        return ew(name, value, QueryPolicy.AUTO, ignorePolicy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L ew(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy);

    /**
     * end with value. 以value结尾.
     *
     * @param name         the name
     * @param value        the value
     * @param queryPolicy  the query policy
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    L ew(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy, Predicate<String> ignorePolicy);

    /**
     * end with value. 以value结尾.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    default L ew(StringSupplier property) {
        return ew(property, QueryPolicy.AUTO);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param property     对象属性
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    default L ew(StringSupplier property, Predicate<String> ignorePolicy) {
        return ew(property, QueryPolicy.AUTO, ignorePolicy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param property    the property
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L ew(StringSupplier property, QueryPolicy queryPolicy);

    /**
     * end with value. 以value结尾.
     *
     * @param property     the property
     * @param queryPolicy  the query policy
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    L ew(StringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignorePolicy);

    /**
     * end with value. 以value结尾.
     *
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R> L ew(SerializableFunction<E, R> repository, SerializableFunction<R, String> property, String value);

    /**
     * end with value. 以value结尾.
     *
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R> L ew(SerializableSupplier<R> repository, SerializableFunction<R, String> property);
}