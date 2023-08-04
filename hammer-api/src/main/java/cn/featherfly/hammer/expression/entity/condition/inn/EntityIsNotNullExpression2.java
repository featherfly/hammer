
package cn.featherfly.hammer.expression.entity.condition.inn;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityIsNotNullExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityIsNotNullExpression2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityIsNotNullExpressionBase2<E, E2, C, L> {

    /**
     * is not null.
     *
     * @param isNotNullEntityExpressions the is not null entity expressions
     * @return the LogicExpression
     */
    L inn(Consumer<Tuple2<IsNotNullEntityExpression<E>, IsNotNullEntityExpression<E2>>> isNotNullEntityExpressions);

    /**
     * is not null.
     *
     * @param isNotNullEntityExpressions the is not null entity expressions
     * @return the LogicExpression
     */
    L inn(BiConsumer<IsNotNullEntityExpression<E>, IsNotNullEntityExpression<E2>> isNotNullEntityExpressions);

    //    /**
    //     * is not null.
    //     *
    //     * @param <R>  the generic type
    //     * @param name 参数名称
    //     * @return LogicExpression
    //     */
    //    default <R> L inn(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, R> name) {
    //        return inn(entities, name, true);
    //    }
    //
    //    /**
    //     * is not null.
    //     *
    //     * @param <R>   the generic type
    //     * @param name  参数名称
    //     * @param value if true, is null; if false, is not null; if null, ignore
    //     *              this operate
    //     * @return LogicExpression
    //     */
    //    <R> L inn(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, R> name, Boolean value);
    //
    //    /**
    //     * is not null.
    //     *
    //     * @param <R>                 the generic type
    //     * @param <V>                 the value type
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    default <R, V> L inn(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, R> fetchEntity, SerializableFunction<R, V> fetchEntityProperty) {
    //        return inn(entities, fetchEntity, fetchEntityProperty, true);
    //    }
    //
    //    /**
    //     * is not null.
    //     *
    //     * @param <R>                 the generic type
    //     * @param <V>                 the value type
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               if true, is null; if false, is not null; if
    //     *                            null, ignore this operate
    //     * @return LogicExpression
    //     */
    //    <R, V> L inn(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, R> fetchEntityValue, SerializableFunction<R, V> fetchEntityProperty, Boolean value);
    //
    //    // ********************************************************************
    //    //	E2
    //    // ********************************************************************
    //
    //    /**
    //     * is not null.
    //     *
    //     * @param <R>  the generic type
    //     * @param name 参数名称
    //     * @return LogicExpression
    //     */
    //    default <R> L inn(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> name) {
    //        return inn(entities, name, true);
    //    }
    //
    //    /**
    //     * is not null.
    //     *
    //     * @param <R>   the generic type
    //     * @param name  参数名称
    //     * @param value if true, is null; if false, is not null; if null, ignore
    //     *              this operate
    //     * @return LogicExpression
    //     */
    //    <R> L inn(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> name, Boolean value);
    //
    //    /**
    //     * is not null.
    //     *
    //     * @param <R>                 the generic type
    //     * @param <V>                 the value type
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    default <R, V> L inn(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> fetchEntity, SerializableFunction<R, V> fetchEntityProperty) {
    //        return inn(entities, fetchEntity, fetchEntityProperty, true);
    //    }
    //
    //    /**
    //     * is not null.
    //     *
    //     * @param <R>                 the generic type
    //     * @param <V>                 the value type
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               if true, is null; if false, is not null; if
    //     *                            null, ignore this operate
    //     * @return LogicExpression
    //     */
    //    <R, V> L inn(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> fetchEntityValue, SerializableFunction<R, V> fetchEntityProperty,
    //            Boolean value);
}