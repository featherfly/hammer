
package cn.featherfly.hammer.expression.entity.condition.ew;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityEndWithExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityEndWithExpression2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityEndWithExpressionBase2<E, E2, C, L> {

    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities the entities
    //     * @param name the name
    //     * @param value the value
    //     * @return LogicExpression
    //     */
    //    default L ew(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, String> name, String value) {
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
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
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
    //    L ew(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy);
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
    //    L ew(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
    //            Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities the entities
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    default L ew(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableStringSupplier property) {
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
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
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
    //    L ew(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableStringSupplier property, MatchStrategy matchStrategy);
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
    //    L ew(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
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
    //    <R> L ew(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
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
    //    <R> L ew(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
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
    //    default L ew(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, String> name, String value) {
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
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
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
    //    L ew(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, String> name, String value, MatchStrategy matchStrategy);
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
    //    L ew(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, String> name, String value, MatchStrategy matchStrategy,
    //            Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param entities the entities
    //     * @param property  bean property
    //     * @return LogicExpression
    //     */
    //    default L ew(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<String> property) {
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
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
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
    //    L ew(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<String> property, MatchStrategy matchStrategy);
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
    //    L ew(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<String> property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
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
    //    <R> L ew(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
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
    //    <R> L ew(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);

    /**
     * end with value. 以value结尾.
     *
     * @param endWithEntityExpressions the end with entity expressions
     * @return the LogicExpression
     */
    L ew(Consumer<Tuple2<EndWithEntityExpression<E>, EndWithEntityExpression<E2>>> endWithEntityExpressions);

    /**
     * end with value. 以value结尾.
     *
     * @param endWithEntityExpressions the end with entity expressions
     * @return the LogicExpression
     */
    L ew(BiConsumer<EndWithEntityExpression<E>, EndWithEntityExpression<E2>> endWithEntityExpressions);
}