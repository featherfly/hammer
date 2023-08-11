
package cn.featherfly.hammer.expression.entity.condition.co;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityContainsExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityContainsExpression2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityContainsExpressionBase2<E, E2, C, L> {

    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @param value    参数值
    //     * @return LogicExpression
    //     */
    //    default L co(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, String> name, String value) {
    //        return co(entities, name, value, QueryPolicy.AUTO);
    //    }
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities     the entities
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L co(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
    //        return co(entities, name, value, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities    the entities
    //     * @param name        the name
    //     * @param value       the value
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    L co(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy);
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities     the entities
    //     * @param name         the name
    //     * @param value        the value
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L co(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy,
    //            Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities the entities
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    default L co(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableStringSupplier property) {
    //        return co(entities, property, QueryPolicy.AUTO);
    //    }
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities     the entities
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L co(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
    //        return co(entities, property, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities    the entities
    //     * @param property    the property
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    L co(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableStringSupplier property, QueryPolicy queryPolicy);
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities     the entities
    //     * @param property     the property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L co(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableStringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               参数值
    //     * @return LogicExpression
    //     */
    //    <R> L co(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty, String value);
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <R> L co(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableSupplier<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);
    //
    //    // ********************************************************************
    //    //	E2
    //    // ********************************************************************
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @param value    参数值
    //     * @return LogicExpression
    //     */
    //    default L co(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, String> name, String value) {
    //        return co(entities, name, value, QueryPolicy.AUTO);
    //    }
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities     the entities
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L co(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, String> name, String value, Predicate<String> ignoreStrategy) {
    //        return co(entities, name, value, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities    the entities
    //     * @param name        the name
    //     * @param value       the value
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    L co(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, String> name, String value, QueryPolicy queryPolicy);
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities     the entities
    //     * @param name         the name
    //     * @param value        the value
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L co(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, String> name, String value, QueryPolicy queryPolicy,
    //            Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities the entities
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    default L co(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<String> property) {
    //        return co(entities, property, QueryPolicy.AUTO);
    //    }
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities     the entities
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L co(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<String> property, Predicate<String> ignoreStrategy) {
    //        return co(entities, property, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities    the entities
    //     * @param property    the property
    //     * @param queryPolicy the query policy
    //     * @return LogicExpression
    //     */
    //    L co(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<String> property, QueryPolicy queryPolicy);
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities     the entities
    //     * @param property     the property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    L co(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<String> property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               参数值
    //     * @return LogicExpression
    //     */
    //    <R> L co(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty,
    //            String value);
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <R> L co(Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);

    /**
     * contains value. 包含value.
     *
     * @param containsEntityExpressions the contains entity expressions
     * @return the LogicExpression
     */
    L co(Consumer<Tuple2<ContainsEntityExpression<E>, ContainsEntityExpression<E2>>> containsEntityExpressions);

    /**
     * contains value. 包含value.
     *
     * @param containsEntityExpressions the contains entity expressions
     * @return the LogicExpression
     */
    L co(BiConsumer<ContainsEntityExpression<E>, ContainsEntityExpression<E2>> containsEntityExpressions);
}