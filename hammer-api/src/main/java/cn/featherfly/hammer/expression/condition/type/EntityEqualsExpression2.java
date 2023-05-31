
package cn.featherfly.hammer.expression.condition.type;

import java.util.function.Function;
import java.util.function.Predicate;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.dsl.QueryEntityRepository;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityEqualsExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityEqualsExpression2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityEqualsExpression<E, C, L> {

    /**
     * equals. 等于.
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     参数名称
     * @param value    参数值
     * @return LogicExpression
     */
    default <R> L eq(
            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
            SerializableFunction<E, R> name, R value) {
        return eq(entities, name, value, QueryPolicy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param <R>          the generic type
     * @param entities     the entities
     * @param name         参数名称
     * @param value        参数值
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    default <R> L eq(
            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
            SerializableFunction<E, R> name, R value, Predicate<Object> ignorePolicy) {
        return eq(entities, name, value, QueryPolicy.AUTO, ignorePolicy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>         the generic type
     * @param entities    the entities
     * @param name        参数名称
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <R> L eq(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
            SerializableFunction<E, R> name, R value, QueryPolicy queryPolicy);

    /**
     * equals. 等于.
     *
     * @param <R>          the generic type
     * @param entities     the entities
     * @param name         参数名称
     * @param value        参数值
     * @param queryPolicy  the query policy
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    <R> L eq(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
            SerializableFunction<E, R> name, R value, QueryPolicy queryPolicy, Predicate<Object> ignorePolicy);

    /**
     * equals. 等于.
     *
     * @param <R>      the generic type
     * @param entities the entities
     * @param name     参数名称
     * @param value    参数值
     * @return LogicExpression
     */
    default <R> L eq(
            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
            SerializableFunction2<E2, R> name, R value) {
        return eq(entities, name, value, QueryPolicy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param <R>          the generic type
     * @param entities     the entities
     * @param name         参数名称
     * @param value        参数值
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    default <R> L eq(
            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
            SerializableFunction2<E2, R> name, R value, Predicate<Object> ignorePolicy) {
        return eq(entities, name, value, QueryPolicy.AUTO, ignorePolicy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>         the generic type
     * @param entities    the entities
     * @param name        参数名称
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <R> L eq(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
            SerializableFunction2<E2, R> name, R value, QueryPolicy queryPolicy);

    /**
     * equals. 等于.
     *
     * @param <R>          the generic type
     * @param entities     the entities
     * @param name         参数名称
     * @param value        参数值
     * @param queryPolicy  the query policy
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    <R> L eq(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
            SerializableFunction2<E2, R> name, R value, QueryPolicy queryPolicy, Predicate<Object> ignorePolicy);

    /**
     * equals. 等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    default <R> L eq(
            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
            SerializableSupplier<R> property) {
        return eq(property, QueryPolicy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    default <R> L eq(
            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
            SerializableSupplier<R> property, Predicate<Object> ignorePolicy) {
        return eq(property, QueryPolicy.AUTO, ignorePolicy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>         the generic type
     * @param property    对象属性
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <R> L eq(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
            SerializableSupplier<R> property, QueryPolicy queryPolicy);

    /**
     * equals. 等于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param queryPolicy  the query policy
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    <R> L eq(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
            SerializableSupplier<R> property, QueryPolicy queryPolicy, Predicate<Object> ignorePolicy);

    /**
     * equals. 等于.
     *
     * @param <T>        the generic type
     * @param <V>        the value type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, V> L eq(
            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
            SerializableFunction<E, T> repository, SerializableFunction<T, V> property, V value);
    
    /**
     * equals. 等于.
     *
     * @param <T>        the generic type
     * @param <V>        the value type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, V> L eq(
            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
            SerializableFunction2<E2, T> repository, SerializableFunction<T, V> property, V value);

    /**
     * equals. 等于.
     *
     * @param <T>        the generic type
     * @param <V>        the value type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T, V> L eq(
            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
            SerializableSupplier<T> repository, SerializableFunction<T, V> property);
}