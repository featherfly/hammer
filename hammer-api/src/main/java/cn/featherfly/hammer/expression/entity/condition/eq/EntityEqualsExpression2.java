
package cn.featherfly.hammer.expression.entity.condition.eq;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

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
        extends EntityEqualsExpressionBase2<E, E2, C, L> {

    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @param value    参数值
    //     * @return LogicExpression
    //     */
    //    default <R> L eq(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, R> name, R value) {
    //        return eq(entities, name, value, MatchStrategy.AUTO);
    //    }
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>          the generic type
    //     * @param entities     the entities
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default <R> L eq(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, R> name, R value, Predicate<R> ignoreStrategy) {
    //        return eq(entities, name, value, MatchStrategy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>         the generic type
    //     * @param entities    the entities
    //     * @param name        参数名称
    //     * @param value       参数值
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    <R> L eq(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, R> name, R value, MatchStrategy queryPolicy);
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>          the generic type
    //     * @param entities     the entities
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <R> L eq(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, R> name, R value, MatchStrategy queryPolicy, Predicate<R> ignoreStrategy);
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    default <R> L eq(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableSupplier<R> property) {
    //        return eq(entities, property, MatchStrategy.AUTO);
    //    }
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>          the generic type
    //     * @param entities     the entities
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default <R> L eq(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
    //        return eq(entities, property, MatchStrategy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>         the generic type
    //     * @param entities    the entities
    //     * @param property    对象属性
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    <R> L eq(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableSupplier<R> property, MatchStrategy queryPolicy);
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>          the generic type
    //     * @param entities     the entities
    //     * @param property     对象属性
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <R> L eq(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableSupplier<R> property, MatchStrategy queryPolicy, Predicate<R> ignoreStrategy);
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <T>                 the generic type
    //     * @param <V>                 the value type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               参数值
    //     * @return LogicExpression
    //     */
    //    <T, V> L eq(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, T> fetchEntity, SerializableFunction<T, V> fetchEntityProperty, V value);
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <T>                 the generic type
    //     * @param <V>                 the value type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <T, V> L eq(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableSupplier<T> fetchEntityValue, SerializableFunction<T, V> fetchEntityProperty);
    //
    //    // ********************************************************************
    //    //  E2
    //    // ********************************************************************
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @param value    参数值
    //     * @return LogicExpression
    //     */
    //    default <R> L eq(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> name, R value) {
    //        return eq(entities, name, value, MatchStrategy.AUTO);
    //    }
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>          the generic type
    //     * @param entities     the entities
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default <R> L eq(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> name, R value, Predicate<R> ignoreStrategy) {
    //        return eq(entities, name, value, MatchStrategy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>         the generic type
    //     * @param entities    the entities
    //     * @param name        参数名称
    //     * @param value       参数值
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    <R> L eq(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> name, R value, MatchStrategy queryPolicy);
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>          the generic type
    //     * @param entities     the entities
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <R> L eq(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> name, R value, MatchStrategy queryPolicy, Predicate<R> ignoreStrategy);
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    default <R> L eq(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<R> property) {
    //        return eq(entities, property, MatchStrategy.AUTO);
    //    }
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>          the generic type
    //     * @param entities     the entities
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default <R> L eq(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<R> property, Predicate<R> ignoreStrategy) {
    //        return eq(entities, property, MatchStrategy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>         the generic type
    //     * @param entities    the entities
    //     * @param property    对象属性
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    <R> L eq(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<R> property, MatchStrategy queryPolicy);
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>          the generic type
    //     * @param entities     the entities
    //     * @param property     对象属性
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <R> L eq(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<R> property, MatchStrategy queryPolicy, Predicate<R> ignoreStrategy);
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <T>                 the generic type
    //     * @param <V>                 the value type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               参数值
    //     * @return LogicExpression
    //     */
    //    <T, V> L eq(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, T> fetchEntity, SerializableFunction<T, V> fetchEntityProperty, V value);
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <T>                 the generic type
    //     * @param <V>                 the value type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <T, V> L eq(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<T> fetchEntityValue, SerializableFunction<T, V> fetchEntityProperty);

    //    /**
    //     * equals. 等于.
    //     *
    //     * @param consumer the consumer
    //     * @return the l
    //     */
    //    L eq(Function<EntityEqualsExpression2<E, E2, C, L>, L> consumer);
    //
    //    static void main(String[] args) {
    //        int i = 1;
    //        EntityEqualsExpression2<String, Integer, ?, ?> exp = null;
    //        exp.eq(e -> {
    //            if (i == 1) {
    //                return e.eq(String::getClass, String.class);
    //            } else {
    //                return e.eq();
    //            }
    //        });
    //    }

    /**
     * equals. 等于.
     *
     * @param equalsEntityExpressions the equals entity expressions
     * @return the LogicExpression
     */
    L eq(Consumer<Tuple2<EqualsEntityExpression<E>, EqualsEntityExpression<E2>>> equalsEntityExpressions);

    /**
     * equals. 等于.
     *
     * @param equalsEntityExpressions the equals entity expressions
     * @return the LogicExpression
     */
    L eq(BiConsumer<EqualsEntityExpression<E>, EqualsEntityExpression<E2>> equalsEntityExpressions);
}