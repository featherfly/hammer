
package cn.featherfly.hammer.expression.entity.condition.sw;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityStartWithExpression4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityStartWithExpression4<E, E2, E3, E4, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityStartWithExpressionBase4<E, E2, E3, E4, C, L> {

    //
    //     * start with value. 以value开始.
    //     *
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @param value    参数值
    //     * @return LogicExpression
    //     */
    //    default L sw(
    //            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, String> name, String value) {
    //        return sw(entities, name, value, QueryPolicy.AUTO);
    //    }
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities     the entities
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L sw(
    //            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
    //        return sw(entities, name, value, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities    the entities
    //     * @param name        the name
    //     * @param value       the value
    //     * @param queryPolicy the query policy
    //     * @return the l
    //     */
    //    L sw(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>>, QueryEntityRepository<E>> entities, SerializableFunction<E, String> name,
    //            String value, QueryPolicy queryPolicy);
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities     the entities
    //     * @param name         the name
    //     * @param value        the value
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L sw(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>>, QueryEntityRepository<E>> entities, SerializableFunction<E, String> name,
    //            String value, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities the entities
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    default L sw(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>>, QueryEntityRepository<E>> entities, SerializableStringSupplier property) {
    //        return sw(entities, property, QueryPolicy.AUTO);
    //    }
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities     the entities
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L sw(
    //            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>>, QueryEntityRepository<E>> entities,
    //            SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
    //        return sw(entities, property, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities    the entities
    //     * @param property    the property
    //     * @param queryPolicy the query policy
    //     * @return the l
    //     */
    //    L sw(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>>, QueryEntityRepository<E>> entities, SerializableStringSupplier property,
    //            QueryPolicy queryPolicy);
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities     the entities
    //     * @param property     the property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L sw(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>>, QueryEntityRepository<E>> entities, SerializableStringSupplier property,
    //            QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               参数值
    //     * @return LogicExpression
    //     */
    //    <R> L sw(
    //            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction<E, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty, String value);
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <R> L sw(
    //            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>>, QueryEntityRepository<E>> entities,
    //            SerializableSupplier<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);
    //
    //    // ********************************************************************
    //    //	E2
    //    // ********************************************************************
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @param value    参数值
    //     * @return LogicExpression
    //     */
    //    default L sw(
    //            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, String> name, String value) {
    //        return sw(entities, name, value, QueryPolicy.AUTO);
    //    }
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities     the entities
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L sw(
    //            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, String> name, String value, Predicate<String> ignoreStrategy) {
    //        return sw(entities, name, value, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities    the entities
    //     * @param name        the name
    //     * @param value       the value
    //     * @param queryPolicy the query policy
    //     * @return the l
    //     */
    //    L sw(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>>, QueryEntityRepository<E2>> entities, SerializableFunction2<E2, String> name,
    //            String value, QueryPolicy queryPolicy);
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities     the entities
    //     * @param name         the name
    //     * @param value        the value
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L sw(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>>, QueryEntityRepository<E2>> entities, SerializableFunction2<E2, String> name,
    //            String value, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities the entities
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    default L sw(
    //            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>>, QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<String> property) {
    //        return sw(entities, property, QueryPolicy.AUTO);
    //    }
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities     the entities
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L sw(
    //            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>>, QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<String> property, Predicate<String> ignoreStrategy) {
    //        return sw(entities, property, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities    the entities
    //     * @param property    the property
    //     * @param queryPolicy the query policy
    //     * @return the l
    //     */
    //    L sw(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>>, QueryEntityRepository<E2>> entities, SerializableSupplier2<String> property,
    //            QueryPolicy queryPolicy);
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities     the entities
    //     * @param property     the property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L sw(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>>, QueryEntityRepository<E2>> entities, SerializableSupplier2<String> property,
    //            QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               参数值
    //     * @return LogicExpression
    //     */
    //    <R> L sw(
    //            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty,
    //            String value);
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <R> L sw(
    //            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>>, QueryEntityRepository<E2>> entities,
    //            SerializableSupplier2<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);
    //
    //    // ********************************************************************
    //    //  E3
    //    // ********************************************************************
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @param value    参数值
    //     * @return LogicExpression
    //     */
    //    default L sw(
    //            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>>, QueryEntityRepository<E3>> entities,
    //            SerializableFunction3<E3, String> name, String value) {
    //        return sw(entities, name, value, QueryPolicy.AUTO);
    //    }
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities     the entities
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L sw(
    //            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>>, QueryEntityRepository<E3>> entities,
    //            SerializableFunction3<E3, String> name, String value, Predicate<String> ignoreStrategy) {
    //        return sw(entities, name, value, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities    the entities
    //     * @param name        the name
    //     * @param value       the value
    //     * @param queryPolicy the query policy
    //     * @return the l
    //     */
    //    L sw(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>>, QueryEntityRepository<E3>> entities, SerializableFunction3<E3, String> name,
    //            String value, QueryPolicy queryPolicy);
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities     the entities
    //     * @param name         the name
    //     * @param value        the value
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L sw(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>>, QueryEntityRepository<E3>> entities, SerializableFunction3<E3, String> name,
    //            String value, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities the entities
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    default L sw(
    //            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>>, QueryEntityRepository<E3>> entities,
    //            SerializableSupplier3<String> property) {
    //        return sw(entities, property, QueryPolicy.AUTO);
    //    }
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities     the entities
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L sw(
    //            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>>, QueryEntityRepository<E3>> entities,
    //            SerializableSupplier3<String> property, Predicate<String> ignoreStrategy) {
    //        return sw(entities, property, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities    the entities
    //     * @param property    the property
    //     * @param queryPolicy the query policy
    //     * @return the l
    //     */
    //    L sw(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>>, QueryEntityRepository<E3>> entities, SerializableSupplier3<String> property,
    //            QueryPolicy queryPolicy);
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities     the entities
    //     * @param property     the property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L sw(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>>, QueryEntityRepository<E3>> entities, SerializableSupplier3<String> property,
    //            QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               参数值
    //     * @return LogicExpression
    //     */
    //    <R> L sw(
    //            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>>, QueryEntityRepository<E3>> entities,
    //            SerializableFunction3<E3, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty,
    //            String value);
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <R> L sw(
    //            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>>, QueryEntityRepository<E3>> entities,
    //            SerializableSupplier3<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);
    //
    //    // ********************************************************************
    //    //	E4
    //    // ********************************************************************
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities the entities
    //     * @param name     参数名称
    //     * @param value    参数值
    //     * @return LogicExpression
    //     */
    //    default L sw(
    //            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>>, QueryEntityRepository<E4>> entities,
    //            SerializableFunction4<E4, String> name, String value) {
    //        return sw(entities, name, value, QueryPolicy.AUTO);
    //    }
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities     the entities
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L sw(
    //            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>>, QueryEntityRepository<E4>> entities,
    //            SerializableFunction4<E4, String> name, String value, Predicate<String> ignoreStrategy) {
    //        return sw(entities, name, value, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities    the entities
    //     * @param name        the name
    //     * @param value       the value
    //     * @param queryPolicy the query policy
    //     * @return the l
    //     */
    //    L sw(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>>, QueryEntityRepository<E4>> entities, SerializableFunction4<E4, String> name,
    //            String value, QueryPolicy queryPolicy);
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities     the entities
    //     * @param name         the name
    //     * @param value        the value
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L sw(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>>, QueryEntityRepository<E4>> entities, SerializableFunction4<E4, String> name,
    //            String value, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities the entities
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    default L sw(
    //            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>>, QueryEntityRepository<E4>> entities,
    //            SerializableSupplier4<String> property) {
    //        return sw(entities, property, QueryPolicy.AUTO);
    //    }
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities     the entities
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    default L sw(
    //            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>>, QueryEntityRepository<E4>> entities,
    //            SerializableSupplier4<String> property, Predicate<String> ignoreStrategy) {
    //        return sw(entities, property, QueryPolicy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities    the entities
    //     * @param property    the property
    //     * @param queryPolicy the query policy
    //     * @return the l
    //     */
    //    L sw(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>>, QueryEntityRepository<E4>> entities, SerializableSupplier4<String> property,
    //            QueryPolicy queryPolicy);
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param entities     the entities
    //     * @param property     the property
    //     * @param queryPolicy  the query policy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return the l
    //     */
    //    L sw(Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //            QueryEntityRepository<E4>>, QueryEntityRepository<E4>> entities, SerializableSupplier4<String> property,
    //            QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               参数值
    //     * @return LogicExpression
    //     */
    //    <R> L sw(
    //            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>>, QueryEntityRepository<E4>> entities,
    //            SerializableFunction4<E4, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty,
    //            String value);
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param <R>                 the generic type
    //     * @param entities            the entities
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <R> L sw(
    //            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
    //                    QueryEntityRepository<E4>>, QueryEntityRepository<E4>> entities,
    //            SerializableSupplier4<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);

    /**
     * start with value. 以value开始.
     *
     * @param startWithEntityExpressions the start with entity expressions
     * @return the LogicExpression
     */
    L sw(Consumer<Tuple4<StartWithEntityExpression<E>, StartWithEntityExpression<E2>, StartWithEntityExpression<E3>,
            StartWithEntityExpression<E4>>> startWithEntityExpressions);

    /**
     * start with value. 以value开始.
     *
     * @param startWithEntityExpressions the start with entity expressions
     * @return the LogicExpression
     */
    L sw(FourArgusConsumer<StartWithEntityExpression<E>, StartWithEntityExpression<E2>, StartWithEntityExpression<E3>,
            StartWithEntityExpression<E4>> startWithEntityExpressions);
}