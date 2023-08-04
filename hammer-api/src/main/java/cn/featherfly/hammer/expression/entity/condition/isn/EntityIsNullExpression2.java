
package cn.featherfly.hammer.expression.entity.condition.isn;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityIsNullExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityIsNullExpression2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityIsNullExpressionBase2<E, E2, C, L> {

    //    /**
    //     * is null.
    //     *
    //     * @param <R>  the generic type
    //     * @param name 参数名称
    //     * @return LogicExpression
    //     */
    //    default <R> L isn(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, R> name) {
    //        return isn(entities, name, true);
    //    }
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>   the generic type
    //     * @param name  参数名称
    //     * @param value if true, is null; if false, is not null; if null, ignore
    //     *              this operate
    //     * @return LogicExpression
    //     */
    //    <R> L isn(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, R> name, Boolean value);
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>                 the generic type
    //     * @param <V>                 the value type
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    default <R, V> L isn(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, R> fetchEntity, SerializableFunction<R, V> fetchEntityProperty) {
    //        return isn(entities, fetchEntity, fetchEntityProperty, true);
    //    }
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>                 the generic type
    //     * @param <V>                 the value type
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               if true, is null; if false, is not null; if
    //     *                            null, ignore this operate
    //     * @return LogicExpression
    //     */
    //    <R, V> L isn(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, R> fetchEntityValue, SerializableFunction<R, V> fetchEntityProperty, Boolean value);
    //
    //    // ********************************************************************
    //    //	E2
    //    // ********************************************************************
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>  the generic type
    //     * @param name 参数名称
    //     * @return LogicExpression
    //     */
    //    default <R> L isn(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> name) {
    //        return isn(entities, name, true);
    //    }
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>   the generic type
    //     * @param name  参数名称
    //     * @param value if true, is null; if false, is not null; if null, ignore
    //     *              this operate
    //     * @return LogicExpression
    //     */
    //    <R> L isn(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> name, Boolean value);
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>                 the generic type
    //     * @param <V>                 the value type
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    default <R, V> L isn(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> fetchEntity, SerializableFunction<R, V> fetchEntityProperty) {
    //        return isn(entities, fetchEntity, fetchEntityProperty, true);
    //    }
    //
    //    /**
    //     * is null.
    //     *
    //     * @param <R>                 the generic type
    //     * @param <V>                 the value type
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               if true, is null; if false, is not null; if
    //     *                            null, ignore this operate
    //     * @return LogicExpression
    //     */
    //    <R, V> L isn(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> fetchEntityValue, SerializableFunction<R, V> fetchEntityProperty,
    //            Boolean value);

    /**
     * is null.
     *
     * @param isNullEntityExpressions the is null entity expressions
     * @return the LogicExpression
     */
    L isn(Consumer<Tuple2<IsNullEntityExpression<E>, IsNullEntityExpression<E2>>> isNullEntityExpressions);

    /**
     * is null.
     *
     * @param isNullEntityExpressions the is null entity expressions
     * @return the LogicExpression
     */
    L isn(BiConsumer<IsNullEntityExpression<E>, IsNullEntityExpression<E2>> isNullEntityExpressions);
}