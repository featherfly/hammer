
package cn.featherfly.hammer.expression.entity.condition.lk;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLikeExpression6.
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
public interface EntityLikeExpression6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityLikeExpressionBase6<E, E2, E3, E4, E5, E6, C, L> {

    /**
     * like value.
     *
     * @param likeEntityExpressions the like entity expressions
     * @return the LogicExpression
     */
    L lk(Consumer<Tuple6<LikeEntityExpression<E>, LikeEntityExpression<E2>, LikeEntityExpression<E3>,
            LikeEntityExpression<E4>, LikeEntityExpression<E5>, LikeEntityExpression<E6>>> likeEntityExpressions);

    /**
     * like value.
     *
     * @param likeEntityExpressions the like entity expressions
     * @return the LogicExpression
     */
    L lk(SixArgusConsumer<LikeEntityExpression<E>, LikeEntityExpression<E2>, LikeEntityExpression<E3>,
            LikeEntityExpression<E4>, LikeEntityExpression<E5>, LikeEntityExpression<E6>> likeEntityExpressions);

    //    /**
    //     * like value.
    //     *
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @param value    参数值
    //     * @return LogicExpression
    //     */
    //    default L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E>> entities, SerializableFunction<E, String> name, String value) {
    //        return lk(entities, name, value, QueryPolicy.AUTO);
    //    }
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities     the entities
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L lk(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
    //        return lk(entities, name, value, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities    the entities
    //     * @param name        the name
    //     * @param value       the value
    //     * @param queryPolicy the query policy
    //     * @return the l
    //     */
    //    L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E>> entities, SerializableFunction<E, String> name, String value,
    //            QueryPolicy queryPolicy);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities     the entities
    //     * @param name         the name
    //     * @param value        the value
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E>> entities, SerializableFunction<E, String> name, String value,
    //            QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities the entities
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    default L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E>> entities, SerializableStringSupplier property) {
    //        return lk(entities, property, QueryPolicy.AUTO);
    //    }
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities     the entities
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E>> entities, SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
    //        return lk(entities, property, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities    the entities
    //     * @param property    the property
    //     * @param queryPolicy the query policy
    //     * @return the l
    //     */
    //    L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E>> entities, SerializableStringSupplier property, QueryPolicy queryPolicy);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities     the entities
    //     * @param property     the property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E>> entities, SerializableStringSupplier property, QueryPolicy queryPolicy,
    //            Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               参数值
    //     * @return LogicExpression
    //     */
    //    <R> L lk(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty, String value);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <R> L lk(
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
    //     * like value.
    //     *
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @param value    参数值
    //     * @return LogicExpression
    //     */
    //    default L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E2>> entities, SerializableFunction2<E2, String> name, String value) {
    //        return lk(entities, name, value, QueryPolicy.AUTO);
    //    }
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities     the entities
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L lk(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, String> name, String value, Predicate<String> ignoreStrategy) {
    //        return lk(entities, name, value, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities    the entities
    //     * @param name        the name
    //     * @param value       the value
    //     * @param queryPolicy the query policy
    //     * @return the l
    //     */
    //    L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E2>> entities, SerializableFunction2<E2, String> name, String value,
    //            QueryPolicy queryPolicy);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities     the entities
    //     * @param name         the name
    //     * @param value        the value
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E2>> entities, SerializableFunction2<E2, String> name, String value,
    //            QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities the entities
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    default L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E2>> entities, SerializableSupplier2<String> property) {
    //        return lk(entities, property, QueryPolicy.AUTO);
    //    }
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities     the entities
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L lk(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<String> property, Predicate<String> ignoreStrategy) {
    //        return lk(entities, property, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities    the entities
    //     * @param property    the property
    //     * @param queryPolicy the query policy
    //     * @return the l
    //     */
    //    L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E2>> entities, SerializableSupplier2<String> property, QueryPolicy queryPolicy);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities     the entities
    //     * @param property     the property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E2>> entities, SerializableSupplier2<String> property, QueryPolicy queryPolicy,
    //            Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               参数值
    //     * @return LogicExpression
    //     */
    //    <R> L lk(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty,
    //            String value);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <R> L lk(
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
    //     * like value.
    //     *
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @param value    参数值
    //     * @return LogicExpression
    //     */
    //    default L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E3>> entities, SerializableFunction3<E3, String> name, String value) {
    //        return lk(entities, name, value, QueryPolicy.AUTO);
    //    }
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities     the entities
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L lk(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E3>> entities,
    //            SerializableFunction3<E3, String> name, String value, Predicate<String> ignoreStrategy) {
    //        return lk(entities, name, value, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities    the entities
    //     * @param name        the name
    //     * @param value       the value
    //     * @param queryPolicy the query policy
    //     * @return the l
    //     */
    //    L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E3>> entities, SerializableFunction3<E3, String> name, String value,
    //            QueryPolicy queryPolicy);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities     the entities
    //     * @param name         the name
    //     * @param value        the value
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E3>> entities, SerializableFunction3<E3, String> name, String value,
    //            QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities the entities
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    default L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E3>> entities, SerializableSupplier3<String> property) {
    //        return lk(entities, property, QueryPolicy.AUTO);
    //    }
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities     the entities
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L lk(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E3>> entities,
    //            SerializableSupplier3<String> property, Predicate<String> ignoreStrategy) {
    //        return lk(entities, property, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities    the entities
    //     * @param property    the property
    //     * @param queryPolicy the query policy
    //     * @return the l
    //     */
    //    L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E3>> entities, SerializableSupplier3<String> property, QueryPolicy queryPolicy);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities     the entities
    //     * @param property     the property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E3>> entities, SerializableSupplier3<String> property, QueryPolicy queryPolicy,
    //            Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               参数值
    //     * @return LogicExpression
    //     */
    //    <R> L lk(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E3>> entities,
    //            SerializableFunction3<E3, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty,
    //            String value);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <R> L lk(
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
    //     * like value.
    //     *
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @param value    参数值
    //     * @return LogicExpression
    //     */
    //    default L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E4>> entities, SerializableFunction4<E4, String> name, String value) {
    //        return lk(entities, name, value, QueryPolicy.AUTO);
    //    }
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities     the entities
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L lk(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E4>> entities,
    //            SerializableFunction4<E4, String> name, String value, Predicate<String> ignoreStrategy) {
    //        return lk(entities, name, value, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities    the entities
    //     * @param name        the name
    //     * @param value       the value
    //     * @param queryPolicy the query policy
    //     * @return the l
    //     */
    //    L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E4>> entities, SerializableFunction4<E4, String> name, String value,
    //            QueryPolicy queryPolicy);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities     the entities
    //     * @param name         the name
    //     * @param value        the value
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E4>> entities, SerializableFunction4<E4, String> name, String value,
    //            QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities the entities
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    default L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E4>> entities, SerializableSupplier4<String> property) {
    //        return lk(entities, property, QueryPolicy.AUTO);
    //    }
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities     the entities
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L lk(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E4>> entities,
    //            SerializableSupplier4<String> property, Predicate<String> ignoreStrategy) {
    //        return lk(entities, property, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities    the entities
    //     * @param property    the property
    //     * @param queryPolicy the query policy
    //     * @return the l
    //     */
    //    L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E4>> entities, SerializableSupplier4<String> property, QueryPolicy queryPolicy);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities     the entities
    //     * @param property     the property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E4>> entities, SerializableSupplier4<String> property, QueryPolicy queryPolicy,
    //            Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               参数值
    //     * @return LogicExpression
    //     */
    //    <R> L lk(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E4>> entities,
    //            SerializableFunction4<E4, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty,
    //            String value);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <R> L lk(
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
    //     * like value.
    //     *
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @param value    参数值
    //     * @return LogicExpression
    //     */
    //    default L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E5>> entities, SerializableFunction5<E5, String> name, String value) {
    //        return lk(entities, name, value, QueryPolicy.AUTO);
    //    }
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities     the entities
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L lk(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E5>> entities,
    //            SerializableFunction5<E5, String> name, String value, Predicate<String> ignoreStrategy) {
    //        return lk(entities, name, value, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities    the entities
    //     * @param name        the name
    //     * @param value       the value
    //     * @param queryPolicy the query policy
    //     * @return the l
    //     */
    //    L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E5>> entities, SerializableFunction5<E5, String> name, String value,
    //            QueryPolicy queryPolicy);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities     the entities
    //     * @param name         the name
    //     * @param value        the value
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E5>> entities, SerializableFunction5<E5, String> name, String value,
    //            QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities the entities
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    default L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E5>> entities, SerializableSupplier5<String> property) {
    //        return lk(entities, property, QueryPolicy.AUTO);
    //    }
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities     the entities
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L lk(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E5>> entities,
    //            SerializableSupplier5<String> property, Predicate<String> ignoreStrategy) {
    //        return lk(entities, property, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities    the entities
    //     * @param property    the property
    //     * @param queryPolicy the query policy
    //     * @return the l
    //     */
    //    L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E5>> entities, SerializableSupplier5<String> property, QueryPolicy queryPolicy);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities     the entities
    //     * @param property     the property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E5>> entities, SerializableSupplier5<String> property, QueryPolicy queryPolicy,
    //            Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               参数值
    //     * @return LogicExpression
    //     */
    //    <R> L lk(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E5>> entities,
    //            SerializableFunction5<E5, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty,
    //            String value);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <R> L lk(
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
    //     * like value.
    //     *
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @param value    参数值
    //     * @return LogicExpression
    //     */
    //    default L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E6>> entities, SerializableFunction6<E6, String> name, String value) {
    //        return lk(entities, name, value, QueryPolicy.AUTO);
    //    }
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities     the entities
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L lk(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E6>> entities,
    //            SerializableFunction6<E6, String> name, String value, Predicate<String> ignoreStrategy) {
    //        return lk(entities, name, value, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities    the entities
    //     * @param name        the name
    //     * @param value       the value
    //     * @param queryPolicy the query policy
    //     * @return the l
    //     */
    //    L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E6>> entities, SerializableFunction6<E6, String> name, String value,
    //            QueryPolicy queryPolicy);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities     the entities
    //     * @param name         the name
    //     * @param value        the value
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E6>> entities, SerializableFunction6<E6, String> name, String value,
    //            QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities the entities
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    default L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E6>> entities, SerializableSupplier6<String> property) {
    //        return lk(entities, property, QueryPolicy.AUTO);
    //    }
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities     the entities
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L lk(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E6>> entities,
    //            SerializableSupplier6<String> property, Predicate<String> ignoreStrategy) {
    //        return lk(entities, property, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities    the entities
    //     * @param property    the property
    //     * @param queryPolicy the query policy
    //     * @return the l
    //     */
    //    L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E6>> entities, SerializableSupplier6<String> property, QueryPolicy queryPolicy);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param entities     the entities
    //     * @param property     the property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L lk(Function<
    //            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //            QueryEntityRepository<E6>> entities, SerializableSupplier6<String> property, QueryPolicy queryPolicy,
    //            Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               参数值
    //     * @return LogicExpression
    //     */
    //    <R> L lk(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E6>> entities,
    //            SerializableFunction6<E6, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty,
    //            String value);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <R> L lk(
    //            Function<
    //                    Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                            QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
    //                    QueryEntityRepository<E6>> entities,
    //            SerializableSupplier6<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);
}