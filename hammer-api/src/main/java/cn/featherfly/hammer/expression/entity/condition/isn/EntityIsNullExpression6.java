
package cn.featherfly.hammer.expression.entity.condition.isn;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityIsNullExpression6.
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
public interface EntityIsNullExpression6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityIsNullExpressionBase6<E, E2, E3, E4, E5, E6, C, L> {

    //    /**
    //     * is null.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @return LogicExpression
    //     */
    //    default <R> L isn(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E>> entities, SerializableFunction<E, R> name) {
    //        return isn(entities, name, true);
    //    }
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @param value    if true, is null; if false, is not null; if null, ignore
    //     *                 this operate
    //     * @return LogicExpression
    //     */
    //    <R> L isn(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E>> entities, SerializableFunction<E, R> name, Boolean value);
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>                 the generic type
    //     * @param <V>                 the value type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    default <R, V> L isn(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, R> fetchEntity, SerializableFunction<R, V> fetchEntityProperty) {
    //        return isn(entities, fetchEntity, fetchEntityProperty, true);
    //    }
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>                 the generic type
    //     * @param <V>                 the value type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               if true, is null; if false, is not null; if
    //     *                            null, ignore this operate
    //     * @return LogicExpression
    //     */
    //    <R, V> L isn(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, R> fetchEntityValue, SerializableFunction<R, V> fetchEntityProperty, Boolean value);
    //
    //    // ********************************************************************
    //    //  E2
    //    // ********************************************************************
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @return LogicExpression
    //     */
    //    default <R> L isn(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E2>> entities, SerializableFunction2<E2, R> name) {
    //        return isn(entities, name, true);
    //    }
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @param value    if true, is null; if false, is not null; if null, ignore
    //     *                 this operate
    //     * @return LogicExpression
    //     */
    //    <R> L isn(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E2>> entities, SerializableFunction2<E2, R> name, Boolean value);
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>                 the generic type
    //     * @param <V>                 the value type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    default <R, V> L isn(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> fetchEntity, SerializableFunction<R, V> fetchEntityProperty) {
    //        return isn(entities, fetchEntity, fetchEntityProperty, true);
    //    }
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>                 the generic type
    //     * @param <V>                 the value type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               if true, is null; if false, is not null; if
    //     *                            null, ignore this operate
    //     * @return LogicExpression
    //     */
    //    <R, V> L isn(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> fetchEntityValue, SerializableFunction<R, V> fetchEntityProperty,
    //            Boolean value);
    //
    //    // ********************************************************************
    //    //  E3
    //    // ********************************************************************
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @return LogicExpression
    //     */
    //    default <R> L isn(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E3>> entities, SerializableFunction3<E3, R> name) {
    //        return isn(entities, name, true);
    //    }
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @param value    if true, is null; if false, is not null; if null, ignore
    //     *                 this operate
    //     * @return LogicExpression
    //     */
    //    <R> L isn(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E3>> entities, SerializableFunction3<E3, R> name, Boolean value);
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>                 the generic type
    //     * @param <V>                 the value type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    default <R, V> L isn(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E3>> entities,
    //            SerializableFunction3<E3, R> fetchEntity, SerializableFunction<R, V> fetchEntityProperty) {
    //        return isn(entities, fetchEntity, fetchEntityProperty, true);
    //    }
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>                 the generic type
    //     * @param <V>                 the value type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               if true, is null; if false, is not null; if
    //     *                            null, ignore this operate
    //     * @return LogicExpression
    //     */
    //    <R, V> L isn(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E3>> entities,
    //            SerializableFunction3<E3, R> fetchEntityValue, SerializableFunction<R, V> fetchEntityProperty,
    //            Boolean value);
    //
    //    // ********************************************************************
    //    //  E4
    //    // ********************************************************************
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @return LogicExpression
    //     */
    //    default <R> L isn(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E4>> entities, SerializableFunction4<E4, R> name) {
    //        return isn(entities, name, true);
    //    }
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @param value    if true, is null; if false, is not null; if null, ignore
    //     *                 this operate
    //     * @return LogicExpression
    //     */
    //    <R> L isn(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E4>> entities, SerializableFunction4<E4, R> name, Boolean value);
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>                 the generic type
    //     * @param <V>                 the value type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    default <R, V> L isn(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E4>> entities,
    //            SerializableFunction4<E4, R> fetchEntity, SerializableFunction<R, V> fetchEntityProperty) {
    //        return isn(entities, fetchEntity, fetchEntityProperty, true);
    //    }
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>                 the generic type
    //     * @param <V>                 the value type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               if true, is null; if false, is not null; if
    //     *                            null, ignore this operate
    //     * @return LogicExpression
    //     */
    //    <R, V> L isn(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E4>> entities,
    //            SerializableFunction4<E4, R> fetchEntityValue, SerializableFunction<R, V> fetchEntityProperty,
    //            Boolean value);
    //
    //    // ********************************************************************
    //    //  E5
    //    // ********************************************************************
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @return LogicExpression
    //     */
    //    default <R> L isn(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E5>> entities, SerializableFunction5<E5, R> name) {
    //        return isn(entities, name, true);
    //    }
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @param value    if true, is null; if false, is not null; if null, ignore
    //     *                 this operate
    //     * @return LogicExpression
    //     */
    //    <R> L isn(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E5>> entities, SerializableFunction5<E5, R> name, Boolean value);
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>                 the generic type
    //     * @param <V>                 the value type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    default <R, V> L isn(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E5>> entities,
    //            SerializableFunction5<E5, R> fetchEntity, SerializableFunction<R, V> fetchEntityProperty) {
    //        return isn(entities, fetchEntity, fetchEntityProperty, true);
    //    }
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>                 the generic type
    //     * @param <V>                 the value type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               if true, is null; if false, is not null; if
    //     *                            null, ignore this operate
    //     * @return LogicExpression
    //     */
    //    <R, V> L isn(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E5>> entities,
    //            SerializableFunction5<E5, R> fetchEntityValue, SerializableFunction<R, V> fetchEntityProperty,
    //            Boolean value);
    //
    //    // ********************************************************************
    //    //  E6
    //    // ********************************************************************
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @return LogicExpression
    //     */
    //    default <R> L isn(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E6>> entities, SerializableFunction6<E6, R> name) {
    //        return isn(entities, name, true);
    //    }
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>      the generic type
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @param value    if true, is null; if false, is not null; if null, ignore
    //     *                 this operate
    //     * @return LogicExpression
    //     */
    //    <R> L isn(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E6>> entities, SerializableFunction6<E6, R> name, Boolean value);
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>                 the generic type
    //     * @param <V>                 the value type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    default <R, V> L isn(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E6>> entities,
    //            SerializableFunction6<E6, R> fetchEntity, SerializableFunction<R, V> fetchEntityProperty) {
    //        return isn(entities, fetchEntity, fetchEntityProperty, true);
    //    }
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>                 the generic type
    //     * @param <V>                 the value type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               if true, is null; if false, is not null; if
    //     *                            null, ignore this operate
    //     * @return LogicExpression
    //     */
    //    <R, V> L isn(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E6>> entities,
    //            SerializableFunction6<E6, R> fetchEntityValue, SerializableFunction<R, V> fetchEntityProperty,
    //            Boolean value);

    /**
     * is null.
     *
     * @param isNullEntityExpressions the is null entity expressions
     * @return the LogicExpression
     */
    L isn(Consumer<Tuple6<IsNullEntityExpression<E>, IsNullEntityExpression<E2>, IsNullEntityExpression<E3>,
            IsNullEntityExpression<E4>, IsNullEntityExpression<E5>,
            IsNullEntityExpression<E6>>> isNullEntityExpressions);

    /**
     * is null.
     *
     * @param isNullEntityExpressions the is null entity expressions
     * @return the LogicExpression
     */
    L isn(SixArgusConsumer<IsNullEntityExpression<E>, IsNullEntityExpression<E2>, IsNullEntityExpression<E3>,
            IsNullEntityExpression<E4>, IsNullEntityExpression<E5>,
            IsNullEntityExpression<E6>> isNullEntityExpressions);
}