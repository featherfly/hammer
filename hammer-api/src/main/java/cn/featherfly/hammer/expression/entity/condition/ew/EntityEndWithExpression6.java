
package cn.featherfly.hammer.expression.entity.condition.ew;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityEndWithExpression6.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityEndWithExpression6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityEndWithExpressionBase6<E, E2, E3, E4, E5, E6, C, L> {

    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities the entities
    //     * @param name the name
    //     * @param value the value
    //     * @return LogicExpression
    //     */
    //    default L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E>> entities, SerializableFunction<E, String> name, String value) {
    //        return ew(entities, name, value, MatchStrategy.AUTO);
    //    }
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities     the entities
    //     * @param name the name
    //     * @param value the value
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L ew(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
    //        return ew(entities, name, value, MatchStrategy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities    the entities
    //     * @param name        the name
    //     * @param value       the value
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E>> entities, SerializableFunction<E, String> name, String value,
    //            MatchStrategy matchStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities     the entities
    //     * @param name         the name
    //     * @param value        the value
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E>> entities, SerializableFunction<E, String> name, String value,
    //            MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities the entities
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    default L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E>> entities, SerializableStringSupplier property) {
    //        return ew(entities, property, MatchStrategy.AUTO);
    //    }
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities     the entities
    //     * @param property  bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E>> entities, SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
    //        return ew(entities, property, MatchStrategy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities    the entities
    //     * @param property    the property
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E>> entities, SerializableStringSupplier property, MatchStrategy matchStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities     the entities
    //     * @param property     the property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E>> entities, SerializableStringSupplier property, MatchStrategy matchStrategy,
    //            Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value the value
    //     * @return LogicExpression
    //     */
    //    <R> L ew(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty, String value);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <R> L ew(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E>> entities,
    //            SerializableSupplier<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);
    //
    //    // ********************************************************************
    //    //	E2
    //    // ********************************************************************
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities the entities
    //     * @param name the name
    //     * @param value the value
    //     * @return LogicExpression
    //     */
    //    default L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E2>> entities, SerializableFunction2<E2, String> name, String value) {
    //        return ew(entities, name, value, MatchStrategy.AUTO);
    //    }
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities     the entities
    //     * @param name the name
    //     * @param value the value
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L ew(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, String> name, String value, Predicate<String> ignoreStrategy) {
    //        return ew(entities, name, value, MatchStrategy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities    the entities
    //     * @param name        the name
    //     * @param value       the value
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E2>> entities, SerializableFunction2<E2, String> name, String value,
    //            MatchStrategy matchStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities     the entities
    //     * @param name         the name
    //     * @param value        the value
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E2>> entities, SerializableFunction2<E2, String> name, String value,
    //            MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities the entities
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    default L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E2>> entities, SerializableSupplier2<String> property) {
    //        return ew(entities, property, MatchStrategy.AUTO);
    //    }
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities     the entities
    //     * @param property  bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L ew(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<String> property, Predicate<String> ignoreStrategy) {
    //        return ew(entities, property, MatchStrategy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities    the entities
    //     * @param property    the property
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E2>> entities, SerializableSupplier2<String> property, MatchStrategy matchStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities     the entities
    //     * @param property     the property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E2>> entities, SerializableSupplier2<String> property, MatchStrategy matchStrategy,
    //            Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value the value
    //     * @return LogicExpression
    //     */
    //    <R> L ew(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty,
    //            String value);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <R> L ew(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);
    //
    //    // ********************************************************************
    //    //  E3
    //    // ********************************************************************
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities the entities
    //     * @param name the name
    //     * @param value the value
    //     * @return LogicExpression
    //     */
    //    default L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E3>> entities, SerializableFunction3<E3, String> name, String value) {
    //        return ew(entities, name, value, MatchStrategy.AUTO);
    //    }
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities     the entities
    //     * @param name the name
    //     * @param value the value
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L ew(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E3>> entities,
    //            SerializableFunction3<E3, String> name, String value, Predicate<String> ignoreStrategy) {
    //        return ew(entities, name, value, MatchStrategy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities    the entities
    //     * @param name        the name
    //     * @param value       the value
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E3>> entities, SerializableFunction3<E3, String> name, String value,
    //            MatchStrategy matchStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities     the entities
    //     * @param name         the name
    //     * @param value        the value
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E3>> entities, SerializableFunction3<E3, String> name, String value,
    //            MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities the entities
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    default L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E3>> entities, SerializableSupplier3<String> property) {
    //        return ew(entities, property, MatchStrategy.AUTO);
    //    }
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities     the entities
    //     * @param property  bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L ew(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E3>> entities,
    //            SerializableSupplier3<String> property, Predicate<String> ignoreStrategy) {
    //        return ew(entities, property, MatchStrategy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities    the entities
    //     * @param property    the property
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E3>> entities, SerializableSupplier3<String> property, MatchStrategy matchStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities     the entities
    //     * @param property     the property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E3>> entities, SerializableSupplier3<String> property, MatchStrategy matchStrategy,
    //            Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value the value
    //     * @return LogicExpression
    //     */
    //    <R> L ew(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E3>> entities,
    //            SerializableFunction3<E3, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty,
    //            String value);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <R> L ew(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E3>> entities,
    //            SerializableSupplier3<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);
    //
    //    // ********************************************************************
    //    //	E4
    //    // ********************************************************************
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities the entities
    //     * @param name the name
    //     * @param value the value
    //     * @return LogicExpression
    //     */
    //    default L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E4>> entities, SerializableFunction4<E4, String> name, String value) {
    //        return ew(entities, name, value, MatchStrategy.AUTO);
    //    }
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities     the entities
    //     * @param name the name
    //     * @param value the value
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L ew(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E4>> entities,
    //            SerializableFunction4<E4, String> name, String value, Predicate<String> ignoreStrategy) {
    //        return ew(entities, name, value, MatchStrategy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities    the entities
    //     * @param name        the name
    //     * @param value       the value
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E4>> entities, SerializableFunction4<E4, String> name, String value,
    //            MatchStrategy matchStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities     the entities
    //     * @param name         the name
    //     * @param value        the value
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E4>> entities, SerializableFunction4<E4, String> name, String value,
    //            MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities the entities
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    default L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E4>> entities, SerializableSupplier4<String> property) {
    //        return ew(entities, property, MatchStrategy.AUTO);
    //    }
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities     the entities
    //     * @param property  bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L ew(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E4>> entities,
    //            SerializableSupplier4<String> property, Predicate<String> ignoreStrategy) {
    //        return ew(entities, property, MatchStrategy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities    the entities
    //     * @param property    the property
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E4>> entities, SerializableSupplier4<String> property, MatchStrategy matchStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities     the entities
    //     * @param property     the property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E4>> entities, SerializableSupplier4<String> property, MatchStrategy matchStrategy,
    //            Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value the value
    //     * @return LogicExpression
    //     */
    //    <R> L ew(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E4>> entities,
    //            SerializableFunction4<E4, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty,
    //            String value);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <R> L ew(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E4>> entities,
    //            SerializableSupplier4<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);
    //
    //    // ********************************************************************
    //    //  E5
    //    // ********************************************************************
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities the entities
    //     * @param name the name
    //     * @param value the value
    //     * @return LogicExpression
    //     */
    //    default L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E5>> entities, SerializableFunction5<E5, String> name, String value) {
    //        return ew(entities, name, value, MatchStrategy.AUTO);
    //    }
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities     the entities
    //     * @param name the name
    //     * @param value the value
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L ew(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E5>> entities,
    //            SerializableFunction5<E5, String> name, String value, Predicate<String> ignoreStrategy) {
    //        return ew(entities, name, value, MatchStrategy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities    the entities
    //     * @param name        the name
    //     * @param value       the value
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E5>> entities, SerializableFunction5<E5, String> name, String value,
    //            MatchStrategy matchStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities     the entities
    //     * @param name         the name
    //     * @param value        the value
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E5>> entities, SerializableFunction5<E5, String> name, String value,
    //            MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities the entities
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    default L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E5>> entities, SerializableSupplier5<String> property) {
    //        return ew(entities, property, MatchStrategy.AUTO);
    //    }
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities     the entities
    //     * @param property  bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L ew(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E5>> entities,
    //            SerializableSupplier5<String> property, Predicate<String> ignoreStrategy) {
    //        return ew(entities, property, MatchStrategy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities    the entities
    //     * @param property    the property
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E5>> entities, SerializableSupplier5<String> property, MatchStrategy matchStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities     the entities
    //     * @param property     the property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E5>> entities, SerializableSupplier5<String> property, MatchStrategy matchStrategy,
    //            Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value the value
    //     * @return LogicExpression
    //     */
    //    <R> L ew(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E5>> entities,
    //            SerializableFunction5<E5, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty,
    //            String value);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <R> L ew(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E5>> entities,
    //            SerializableSupplier5<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);
    //
    //    // ********************************************************************
    //    //  E6
    //    // ********************************************************************
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities the entities
    //     * @param name the name
    //     * @param value the value
    //     * @return LogicExpression
    //     */
    //    default L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E6>> entities, SerializableFunction6<E6, String> name, String value) {
    //        return ew(entities, name, value, MatchStrategy.AUTO);
    //    }
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities     the entities
    //     * @param name the name
    //     * @param value the value
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L ew(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E6>> entities,
    //            SerializableFunction6<E6, String> name, String value, Predicate<String> ignoreStrategy) {
    //        return ew(entities, name, value, MatchStrategy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities    the entities
    //     * @param name        the name
    //     * @param value       the value
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E6>> entities, SerializableFunction6<E6, String> name, String value,
    //            MatchStrategy matchStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities     the entities
    //     * @param name         the name
    //     * @param value        the value
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E6>> entities, SerializableFunction6<E6, String> name, String value,
    //            MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities the entities
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    default L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E6>> entities, SerializableSupplier6<String> property) {
    //        return ew(entities, property, MatchStrategy.AUTO);
    //    }
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities     the entities
    //     * @param property  bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L ew(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E6>> entities,
    //            SerializableSupplier6<String> property, Predicate<String> ignoreStrategy) {
    //        return ew(entities, property, MatchStrategy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities    the entities
    //     * @param property    the property
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E6>> entities, SerializableSupplier6<String> property, MatchStrategy matchStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities     the entities
    //     * @param property     the property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L ew(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E6>> entities, SerializableSupplier6<String> property, MatchStrategy matchStrategy,
    //            Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value the value
    //     * @return LogicExpression
    //     */
    //    <R> L ew(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E6>> entities,
    //            SerializableFunction6<E6, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty,
    //            String value);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <R> L ew(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E6>> entities,
    //            SerializableSupplier6<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);

    /**
     * end with value. 以value结尾.
     *
     * @param endWithEntityExpressions the end with entity expressions
     * @return the LogicExpression
     */
    L ew(Consumer<Tuple6<EndWithEntityExpression<E>, EndWithEntityExpression<E2>, EndWithEntityExpression<E3>, EndWithEntityExpression<E4>, EndWithEntityExpression<E5>, EndWithEntityExpression<E6>>> endWithEntityExpressions);

    /**
     * end with value. 以value结尾.
     *
     * @param endWithEntityExpressions the end with entity expressions
     * @return the LogicExpression
     */
    L ew(SixArgusConsumer<EndWithEntityExpression<E>, EndWithEntityExpression<E2>, EndWithEntityExpression<E3>, EndWithEntityExpression<E4>, EndWithEntityExpression<E5>, EndWithEntityExpression<E6>> endWithEntityExpressions);
}