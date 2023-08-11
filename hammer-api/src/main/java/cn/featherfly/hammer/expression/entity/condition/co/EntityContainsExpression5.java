
package cn.featherfly.hammer.expression.entity.condition.co;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityContainsExpression5.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityContainsExpression5<E, E2, E3, E4, E5, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityContainsExpressionBase5<E, E2, E3, E4, E5, C, L> {

    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @param value    参数值
    //     * @return LogicExpression
    //     */
    //    default L co(
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E>> entities,
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
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E>> entities,
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
    //     * @return the l
    //     */
    //    L co(Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E>> entities,
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
    //     * @return the l
    //     */
    //    L co(Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E>> entities,
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
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E>> entities,
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
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E>> entities,
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
    //     * @return the l
    //     */
    //    L co(Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E>> entities,
    //            SerializableStringSupplier property, QueryPolicy queryPolicy);
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities     the entities
    //     * @param property     the property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L co(Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E>> entities,
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
    //    <R> L co(
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E>> entities,
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
    //    <R> L co(
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E>> entities,
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
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E2>> entities,
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
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E2>> entities,
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
    //     * @return the l
    //     */
    //    L co(Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E2>> entities,
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
    //     * @return the l
    //     */
    //    L co(Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E2>> entities,
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
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E2>> entities,
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
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E2>> entities,
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
    //     * @return the l
    //     */
    //    L co(Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<String> property, QueryPolicy queryPolicy);
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities     the entities
    //     * @param property     the property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L co(Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E2>> entities,
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
    //    <R> L co(
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E2>> entities,
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
    //    <R> L co(
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);
    //
    //    // ********************************************************************
    //    //  E3
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
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E3>> entities,
    //            SerializableFunction3<E3, String> name, String value) {
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
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E3>> entities,
    //            SerializableFunction3<E3, String> name, String value, Predicate<String> ignoreStrategy) {
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
    //     * @return the l
    //     */
    //    L co(Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E3>> entities,
    //            SerializableFunction3<E3, String> name, String value, QueryPolicy queryPolicy);
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities     the entities
    //     * @param name         the name
    //     * @param value        the value
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L co(Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E3>> entities,
    //            SerializableFunction3<E3, String> name, String value, QueryPolicy queryPolicy,
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
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E3>> entities,
    //            SerializableSupplier3<String> property) {
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
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E3>> entities,
    //            SerializableSupplier3<String> property, Predicate<String> ignoreStrategy) {
    //        return co(entities, property, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities    the entities
    //     * @param property    the property
    //     * @param queryPolicy the query policy
    //     * @return the l
    //     */
    //    L co(Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E3>> entities,
    //            SerializableSupplier3<String> property, QueryPolicy queryPolicy);
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities     the entities
    //     * @param property     the property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L co(Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E3>> entities,
    //            SerializableSupplier3<String> property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);
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
    //    <R> L co(
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E3>> entities,
    //            SerializableFunction3<E3, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty,
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
    //    <R> L co(
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E3>> entities,
    //            SerializableSupplier3<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);
    //
    //    // ********************************************************************
    //    //	E4
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
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E4>> entities,
    //            SerializableFunction4<E4, String> name, String value) {
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
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E4>> entities,
    //            SerializableFunction4<E4, String> name, String value, Predicate<String> ignoreStrategy) {
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
    //     * @return the l
    //     */
    //    L co(Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E4>> entities,
    //            SerializableFunction4<E4, String> name, String value, QueryPolicy queryPolicy);
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities     the entities
    //     * @param name         the name
    //     * @param value        the value
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L co(Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E4>> entities,
    //            SerializableFunction4<E4, String> name, String value, QueryPolicy queryPolicy,
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
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E4>> entities,
    //            SerializableSupplier4<String> property) {
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
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E4>> entities,
    //            SerializableSupplier4<String> property, Predicate<String> ignoreStrategy) {
    //        return co(entities, property, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities    the entities
    //     * @param property    the property
    //     * @param queryPolicy the query policy
    //     * @return the l
    //     */
    //    L co(Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E4>> entities,
    //            SerializableSupplier4<String> property, QueryPolicy queryPolicy);
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities     the entities
    //     * @param property     the property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L co(Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E4>> entities,
    //            SerializableSupplier4<String> property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);
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
    //    <R> L co(
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E4>> entities,
    //            SerializableFunction4<E4, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty,
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
    //    <R> L co(
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E4>> entities,
    //            SerializableSupplier4<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);
    //
    //    // ********************************************************************
    //    //  E5
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
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E5>> entities,
    //            SerializableFunction5<E5, String> name, String value) {
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
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E5>> entities,
    //            SerializableFunction5<E5, String> name, String value, Predicate<String> ignoreStrategy) {
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
    //     * @return the l
    //     */
    //    L co(Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E5>> entities,
    //            SerializableFunction5<E5, String> name, String value, QueryPolicy queryPolicy);
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities     the entities
    //     * @param name         the name
    //     * @param value        the value
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L co(Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E5>> entities,
    //            SerializableFunction5<E5, String> name, String value, QueryPolicy queryPolicy,
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
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E5>> entities,
    //            SerializableSupplier5<String> property) {
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
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E5>> entities,
    //            SerializableSupplier5<String> property, Predicate<String> ignoreStrategy) {
    //        return co(entities, property, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities    the entities
    //     * @param property    the property
    //     * @param queryPolicy the query policy
    //     * @return the l
    //     */
    //    L co(Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E5>> entities,
    //            SerializableSupplier5<String> property, QueryPolicy queryPolicy);
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param entities     the entities
    //     * @param property     the property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L co(Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E5>> entities,
    //            SerializableSupplier5<String> property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);
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
    //    <R> L co(
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E5>> entities,
    //            SerializableFunction5<E5, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty,
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
    //    <R> L co(
    //            Function<Tuple5<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>>, QueryEntityRepository<E5>> entities,
    //            SerializableSupplier5<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);

    /**
     * contains value. 包含value.
     *
     * @param containsEntityExpressions the contains entity expressions
     * @return the LogicExpression
     */
    L co(Consumer<Tuple5<ContainsEntityExpression<E>, ContainsEntityExpression<E2>, ContainsEntityExpression<E3>,
            ContainsEntityExpression<E4>, ContainsEntityExpression<E5>>> containsEntityExpressions);

    /**
     * contains value. 包含value.
     *
     * @param containsEntityExpressions the contains entity expressions
     * @return the LogicExpression
     */
    L co(FiveArgusConsumer<ContainsEntityExpression<E>, ContainsEntityExpression<E2>, ContainsEntityExpression<E3>,
            ContainsEntityExpression<E4>, ContainsEntityExpression<E5>> containsEntityExpressions);
}