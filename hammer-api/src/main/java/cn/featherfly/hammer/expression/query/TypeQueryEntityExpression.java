
package cn.featherfly.hammer.expression.query;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import cn.featherfly.common.exception.UnsupportedException;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.operator.Function;
import cn.featherfly.hammer.expression.RepositoryConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.TypeConditionGroupExpression;
import cn.featherfly.hammer.expression.TypeConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.WhereExpression;
import cn.featherfly.hammer.expression.condition.RepositoryConditionsGroupExpression;

/**
 * TypeQueryEntityExpression.
 *
 * @author zhongj
 * @param <Q>   the generic type
 * @param <QW>  the generic type
 * @param <QWE> the generic type
 * @param <C>   the generic type
 * @param <L>   the generic type
 * @param <RC>  the generic type
 * @param <RL>  the generic type
 */
public interface TypeQueryEntityExpression<Q extends TypeQueryEntityPropertiesExpression<Q, QW, QWE, C, L, RC, RL>,
        QW extends TypeQueryWithExpression<QW, QWE, RC, RL>, QWE extends TypeQueryWithEntityExpression<QW, QWE, RC, RL>,
        C extends TypeConditionGroupExpression<C, L>, L extends TypeConditionGroupLogicExpression<C, L>,
        RC extends RepositoryConditionsGroupExpression<RC, RL>,
        RL extends RepositoryConditionGroupLogicExpression<RC, RL>>
        extends WhereExpression<C, L>, TypeQueryListExecutor, QueryCountExecutor, TypeQueryConditionLimit {

    /**
     * 设置id.
     *
     * @param propertyName the property name
     * @return the q
     */
    Q id(String propertyName);

    /**
     * 设置id.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the q
     */
    <T, R> Q id(SerializableFunction<T, R> propertyName);

    /**
     * 添加查询出来的属性.
     *
     * @param function     the function
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default Q property(Function function, String propertyName) {
        if (function instanceof AggregateFunction) {
            return property((AggregateFunction) function, propertyName);
        } else {
            // TODO 后续实现了相关Function再来修改
            throw new UnsupportedException();
        }
    }

    /**
     * 添加查询出来的属性.
     *
     * @param aggregateFunction aggregateFunction
     * @param propertyName      propertyName
     * @return QueryEntityPropertiesExpression
     */
    default Q property(AggregateFunction aggregateFunction, String propertyName) {
        return property(aggregateFunction, false, propertyName);
    }

    /**
     * 添加查询出来的属性.
     *
     * @param aggregateFunction aggregateFunction
     * @param distinct          the distinct
     * @param propertyName      propertyName
     * @return QueryEntityPropertiesExpression
     */
    Q property(AggregateFunction aggregateFunction, boolean distinct, String propertyName);

    /**
     * 添加查询出来的属性 .
     *
     * @param propertyNames propertyNames
     * @return QueryEntityPropertiesExpression
     */
    @SuppressWarnings("unchecked")
    default Q property(String... propertyNames) {
        for (String propertyName : propertyNames) {
            property(propertyName);
        }
        return (Q) this;
    }

    /**
     * 添加查询出来的属性.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q property(SerializableFunction<T, R> propertyName) {
        return property(false, propertyName);
    }

    /**
     * 添加查询出来的属性 .
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    <T, R> Q property(boolean distinct, SerializableFunction<T, R> propertyName);

    /**
     * 添加查询出来的属性.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param function     the function
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q property(Function function, SerializableFunction<T, R> propertyName) {
        if (function instanceof AggregateFunction) {
            return property((AggregateFunction) function, propertyName);
        } else {
            // TODO 后续实现了相关Function再来修改
            throw new UnsupportedException();
        }
    }

    /**
     * 添加查询出来的属性.
     *
     * @param <T>               the generic type
     * @param <R>               the generic type
     * @param aggregateFunction aggregateFunction
     * @param propertyName      propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q property(AggregateFunction aggregateFunction, SerializableFunction<T, R> propertyName) {
        return property(aggregateFunction, false, propertyName);
    }

    /**
     * 添加查询出来的属性.
     *
     * @param <T>               the generic type
     * @param <R>               the generic type
     * @param aggregateFunction aggregateFunction
     * @param distinct          the distinct
     * @param propertyName      propertyName
     * @return QueryEntityPropertiesExpression
     */
    <T, R> Q property(AggregateFunction aggregateFunction, boolean distinct, SerializableFunction<T, R> propertyName);

    /**
     * 添加查询出来的属性 .
     *
     * @param <T>           the generic type
     * @param <R>           the generic type
     * @param propertyNames propertyNames
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q property(@SuppressWarnings("unchecked") SerializableFunction<T, R>... propertyNames) {
        return property(
                Arrays.stream(propertyNames).map(LambdaUtils::getLambdaPropertyName).collect(Collectors.toList()));
    }

    /**
     * 添加查询出来的属性 .
     *
     * @param propertyNames propertyNames
     * @return QueryEntityPropertiesExpression
     */
    @SuppressWarnings("unchecked")
    default Q property(Collection<String> propertyNames) {
        for (String propertyName : propertyNames) {
            property(propertyName);
        }
        return (Q) this;
    }

    /**
     * with.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <T, R> QWE with(SerializableFunction<T, R> propertyName);

    /**
     * with.
     *
     * @param <T>          the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <T> QWE with(SerializableSupplier<T> propertyName);

    /**
     * with.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName with type object property name
     * @param index        with index, the first is 1
     * @return TypeQueryWithOnExpression
     */
    <T, R> QWE with(SerializableFunction<T, R> propertyName, int index);
}
