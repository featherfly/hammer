
package cn.featherfly.hammer.expression.entity.condition.ne;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotEqualsExpression3.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityNotEqualsExpression3<E, E2, E3, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityNotEqualsExpressionBase3<E, E2, E3, C, L> {

    /**
     * equals. 等于.
     *
     * @param notEqualsEntityExpressions the not equals entity expressions
     * @return the LogicExpression
     */
    L ne(Consumer<Tuple3<NotEqualsEntityExpression<E>, NotEqualsEntityExpression<E2>,
        NotEqualsEntityExpression<E3>>> notEqualsEntityExpressions);

    /**
     * equals. 等于.
     *
     * @param notEqualsEntityExpressions the not equals entity expressions
     * @return the LogicExpression
     */
    L ne(ThreeArgusConsumer<NotEqualsEntityExpression<E>, NotEqualsEntityExpression<E2>,
        NotEqualsEntityExpression<E3>> notEqualsEntityExpressions);

    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name the name
    //     * @param value the value
    //     * @return LogicExpression
    //     */
    //    default <R extends Serializable> L ne(Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //            QueryEntityRepository<E>> entities, SerializableFunction<E, R> name, R value) {
    //        return ne(entities, name, value, MatchStrategy.AUTO);
    //    }
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>          the generic type
    //     * @param entities     the entities
    //     * @param name the name
    //     * @param value the value
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default <R extends Serializable> L ne(
    //            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //                    QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, R> name, R value, Predicate<?> ignoreStrategy) {
    //        return ne(entities, name, value, MatchStrategy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>         the generic type
    //     * @param entities    the entities
    //     * @param name the name
    //     * @param value the value
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    <R extends Serializable> L ne(
    //            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //                    QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, R> name, R value, MatchStrategy matchStrategy);
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>          the generic type
    //     * @param entities     the entities
    //     * @param name the name
    //     * @param value the value
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <R extends Serializable> L ne(
    //            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //                    QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, R> name, R value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    default <R extends Serializable> L ne(Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //            QueryEntityRepository<E>> entities, SerializableSupplier<R> property) {
    //        return ne(entities, property, MatchStrategy.AUTO);
    //    }
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>          the generic type
    //     * @param entities     the entities
    //     * @param property  bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default <R extends Serializable> L ne(
    //            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //                    QueryEntityRepository<E>> entities,
    //            SerializableSupplier<R> property, Predicate<?> ignoreStrategy) {
    //        return ne(entities, property, MatchStrategy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>         the generic type
    //     * @param entities    the entities
    //     * @param property  bean property
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    <R extends Serializable> L ne(Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //            QueryEntityRepository<E>> entities, SerializableSupplier<R> property, MatchStrategy matchStrategy);
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>          the generic type
    //     * @param entities     the entities
    //     * @param property  bean property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <R extends Serializable> L ne(
    //            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //                    QueryEntityRepository<E>> entities,
    //            SerializableSupplier<R> property, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <T>                 the generic type
    //     * @param <V>                 the value type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value the value
    //     * @return LogicExpression
    //     */
    //    <T, V> L ne(
    //            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //                    QueryEntityRepository<E>> entities,
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
    //    <T, V> L ne(
    //            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //                    QueryEntityRepository<E>> entities,
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
    //     * @param name the name
    //     * @param value the value
    //     * @return LogicExpression
    //     */
    //    default <R extends Serializable> L ne(Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //            QueryEntityRepository<E2>> entities, SerializableFunction2<E2, R> name, R value) {
    //        return ne(entities, name, value, MatchStrategy.AUTO);
    //    }
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>          the generic type
    //     * @param entities     the entities
    //     * @param name the name
    //     * @param value the value
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default <R extends Serializable> L ne(
    //            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //                    QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> name, R value, Predicate<?> ignoreStrategy) {
    //        return ne(entities, name, value, MatchStrategy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>         the generic type
    //     * @param entities    the entities
    //     * @param name the name
    //     * @param value the value
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    <R extends Serializable> L ne(
    //            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //                    QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> name, R value, MatchStrategy matchStrategy);
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>          the generic type
    //     * @param entities     the entities
    //     * @param name the name
    //     * @param value the value
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <R extends Serializable> L ne(
    //            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //                    QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> name, R value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    default <R extends Serializable> L ne(Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //            QueryEntityRepository<E2>> entities, SerializableSupplier2<R> property) {
    //        return ne(entities, property, MatchStrategy.AUTO);
    //    }
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>          the generic type
    //     * @param entities     the entities
    //     * @param property  bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default <R extends Serializable> L ne(
    //            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //                    QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<R> property, Predicate<?> ignoreStrategy) {
    //        return ne(entities, property, MatchStrategy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>         the generic type
    //     * @param entities    the entities
    //     * @param property  bean property
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    <R extends Serializable> L ne(Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //            QueryEntityRepository<E2>> entities, SerializableSupplier2<R> property, MatchStrategy matchStrategy);
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>          the generic type
    //     * @param entities     the entities
    //     * @param property  bean property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <R extends Serializable> L ne(
    //            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //                    QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<R> property, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <T>                 the generic type
    //     * @param <V>                 the value type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value the value
    //     * @return LogicExpression
    //     */
    //    <T, V> L ne(
    //            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //                    QueryEntityRepository<E2>> entities,
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
    //    <T, V> L ne(
    //            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //                    QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<T> fetchEntityValue, SerializableFunction<T, V> fetchEntityProperty);
    //
    //    // ********************************************************************
    //    //	E3
    //    // ********************************************************************
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name the name
    //     * @param value the value
    //     * @return LogicExpression
    //     */
    //    default <R extends Serializable> L ne(Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //            QueryEntityRepository<E3>> entities, SerializableFunction3<E3, R> name, R value) {
    //        return ne(entities, name, value, MatchStrategy.AUTO);
    //    }
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>          the generic type
    //     * @param entities     the entities
    //     * @param name the name
    //     * @param value the value
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default <R extends Serializable> L ne(
    //            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //                    QueryEntityRepository<E3>> entities,
    //            SerializableFunction3<E3, R> name, R value, Predicate<?> ignoreStrategy) {
    //        return ne(entities, name, value, MatchStrategy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>         the generic type
    //     * @param entities    the entities
    //     * @param name the name
    //     * @param value the value
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    <R extends Serializable> L ne(
    //            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //                    QueryEntityRepository<E3>> entities,
    //            SerializableFunction3<E3, R> name, R value, MatchStrategy matchStrategy);
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>          the generic type
    //     * @param entities     the entities
    //     * @param name the name
    //     * @param value the value
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <R extends Serializable> L ne(
    //            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //                    QueryEntityRepository<E3>> entities,
    //            SerializableFunction3<E3, R> name, R value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    default <R extends Serializable> L ne(Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //            QueryEntityRepository<E3>> entities, SerializableSupplier3<R> property) {
    //        return ne(entities, property, MatchStrategy.AUTO);
    //    }
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>          the generic type
    //     * @param entities     the entities
    //     * @param property  bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default <R extends Serializable> L ne(
    //            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //                    QueryEntityRepository<E3>> entities,
    //            SerializableSupplier3<R> property, Predicate<?> ignoreStrategy) {
    //        return ne(entities, property, MatchStrategy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>         the generic type
    //     * @param entities    the entities
    //     * @param property  bean property
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    <R extends Serializable> L ne(Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //            QueryEntityRepository<E3>> entities, SerializableSupplier3<R> property, MatchStrategy matchStrategy);
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <R>          the generic type
    //     * @param entities     the entities
    //     * @param property  bean property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <R extends Serializable> L ne(
    //            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //                    QueryEntityRepository<E3>> entities,
    //            SerializableSupplier3<R> property, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <T>                 the generic type
    //     * @param <V>                 the value type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value the value
    //     * @return LogicExpression
    //     */
    //    <T, V> L ne(
    //            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //                    QueryEntityRepository<E3>> entities,
    //            SerializableFunction3<E3, T> fetchEntity, SerializableFunction<T, V> fetchEntityProperty, V value);
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
    //    <T, V> L ne(
    //            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
    //                    QueryEntityRepository<E3>> entities,
    //            SerializableSupplier3<T> fetchEntityValue, SerializableFunction<T, V> fetchEntityProperty);
}