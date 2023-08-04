
package cn.featherfly.hammer.expression.query;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import cn.featherfly.common.exception.UnsupportedException;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.operator.Function;
import cn.featherfly.hammer.dsl.query.QuerySortExpression;
import cn.featherfly.hammer.expression.ConditionGroupExpression;
import cn.featherfly.hammer.expression.ConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.RepositoryConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.WhereExpression;
import cn.featherfly.hammer.expression.condition.RepositoryConditionsGroupExpression;

/**
 * QueryEntityExpression .
 *
 * @author zhongj
 * @param <Q>   the generic type
 * @param <QW>  the generic type
 * @param <QWO> the generic type
 * @param <QWE> the generic type
 * @param <C>   the generic type
 * @param <L>   the generic type
 * @param <RC>  the generic type
 * @param <RL>  the generic type
 */
public interface QueryEntityExpression<Q extends QueryEntityPropertiesExpression<Q, QW, QWO, QWE, C, L, RC, RL>,
        QW extends QueryRelateExpression<QW, QWO, QWE, RC, RL>,
        QWO extends QueryRelateOnExpression<QW, QWO, QWE, RC, RL>,
        QWE extends QueryRelateEntityExpression<QW, QWO, QWE, RC, RL>, C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>, RC extends RepositoryConditionsGroupExpression<RC, RL>,
        RL extends RepositoryConditionGroupLogicExpression<RC, RL>>
        extends WhereExpression<C, L>, QueryListExecutor, QueryConditionLimit, QueryCountExecutor {

    /**
     * 设置id.
     *
     * @param propertyName the property name
     * @return the query fetched expression
     */
    Q id(String propertyName);

    /**
     * 设置id.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the query fetched expression
     */
    <T, R> Q id(SerializableFunction<T, R> propertyName);

    //    @Override
    //    default long count() {
    //        return count(Chars.STAR);
    //    }

    /**
     * Count.
     *
     * @param propertyName the property name
     * @return the query fetched expression
     */
    default Q count(String propertyName) {
        return count(false, propertyName);
    }

    /**
     * Count.
     *
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the query fetched expression
     */
    default Q count(boolean distinct, String propertyName) {
        return property(AggregateFunction.COUNT, distinct, propertyName);
    }

    /**
     * Count.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the query fetched expression
     */
    default <T, R> Q count(SerializableFunction<T, R> propertyName) {
        return count(false, propertyName);
    }

    /**
     * Count.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the query fetched expression
     */
    default <T, R> Q count(boolean distinct, SerializableFunction<T, R> propertyName) {
        return property(AggregateFunction.COUNT, distinct, propertyName);
    }

    /**
     * Sum.
     *
     * @param propertyName the property name
     * @return the query fetched expression
     */
    default Q sum(String propertyName) {
        return sum(false, propertyName);
    }

    /**
     * Sum.
     *
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the query fetched expression
     */
    default Q sum(boolean distinct, String propertyName) {
        return property(AggregateFunction.SUM, distinct, propertyName);
    }

    /**
     * Sum.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the query fetched expression
     */
    default <T, R> Q sum(SerializableFunction<T, R> propertyName) {
        return sum(false, propertyName);
    }

    /**
     * Sum.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the query fetched expression
     */
    default <T, R> Q sum(boolean distinct, SerializableFunction<T, R> propertyName) {
        return property(AggregateFunction.SUM, distinct, propertyName);
    }

    /**
     * Max.
     *
     * @param propertyName the property name
     * @return the query fetched expression
     */
    default Q max(String propertyName) {
        return max(false, propertyName);
    }

    /**
     * Max.
     *
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the query fetched expression
     */
    default Q max(boolean distinct, String propertyName) {
        return property(AggregateFunction.MAX, distinct, propertyName);
    }

    /**
     * Max.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the query fetched expression
     */
    default <T, R> Q max(SerializableFunction<T, R> propertyName) {
        return max(false, propertyName);
    }

    /**
     * Max.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the query fetched expression
     */
    default <T, R> Q max(boolean distinct, SerializableFunction<T, R> propertyName) {
        return property(AggregateFunction.MAX, distinct, propertyName);
    }

    /**
     * Min.
     *
     * @param propertyName the property name
     * @return the query fetched expression
     */
    default Q min(String propertyName) {
        return min(false, propertyName);
    }

    /**
     * Min.
     *
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the query fetched expression
     */
    default Q min(boolean distinct, String propertyName) {
        return property(AggregateFunction.MIN, distinct, propertyName);
    }

    /**
     * Min.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the query fetched expression
     */
    default <T, R> Q min(SerializableFunction<T, R> propertyName) {
        return min(false, propertyName);
    }

    /**
     * Min.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the query fetched expression
     */
    default <T, R> Q min(boolean distinct, SerializableFunction<T, R> propertyName) {
        return property(AggregateFunction.MIN, distinct, propertyName);
    }

    /**
     * Avg.
     *
     * @param propertyName the property name
     * @return the query fetched expression
     */
    default Q avg(String propertyName) {
        return avg(false, propertyName);
    }

    /**
     * Avg.
     *
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the query fetched expression
     */
    default Q avg(boolean distinct, String propertyName) {
        return property(AggregateFunction.AVG, distinct, propertyName);
    }

    /**
     * Avg.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the query fetched expression
     */
    default <T, R> Q avg(SerializableFunction<T, R> propertyName) {
        return avg(false, propertyName);
    }

    /**
     * Avg.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the query fetched expression
     */
    default <T, R> Q avg(boolean distinct, SerializableFunction<T, R> propertyName) {
        return property(AggregateFunction.AVG, distinct, propertyName);
    }

    /**
     * Distinct.
     *
     * @param propertyName the property name
     * @return the query fetched expression
     */
    default Q distinct(String propertyName) {
        return property(true, propertyName);
    }

    /**
     * Distinct.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the query fetched expression
     */
    default <T, R> Q distinct(SerializableFunction<T, R> propertyName) {
        return property(true, propertyName);
    }

    /**
     * 添加查询出来的属性.
     *
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default Q property(String propertyName) {
        return property(false, propertyName);
    }

    /**
     * 添加查询出来的属性.
     *
     * @param distinct     the distinct
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    Q property(boolean distinct, String propertyName);

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
     * 添加查询出来的属性.
     *
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default Q fetch(String propertyName) {
        return property(propertyName);
    }

    /**
     * 添加查询出来的属性.
     *
     * @param distinct     the distinct
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default Q fetch(boolean distinct, String propertyName) {
        return property(distinct, propertyName);
    }

    /**
     * 添加查询出来的属性.
     *
     * @param function     the function
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default Q fetch(Function function, String propertyName) {
        return property(function, propertyName);
    }

    /**
     * 添加查询出来的属性.
     *
     * @param aggregateFunction aggregateFunction
     * @param propertyName      propertyName
     * @return QueryEntityPropertiesExpression
     */
    default Q fetch(AggregateFunction aggregateFunction, String propertyName) {
        return property(aggregateFunction, propertyName);
    }

    /**
     * 添加查询出来的属性.
     *
     * @param aggregateFunction aggregateFunction
     * @param distinct          the distinct
     * @param propertyName      propertyName
     * @return QueryEntityPropertiesExpression
     */
    default Q fetch(AggregateFunction aggregateFunction, boolean distinct, String propertyName) {
        return property(aggregateFunction, distinct, propertyName);
    }

    /**
     * 添加查询出来的属性 .
     *
     * @param propertyNames propertyNames
     * @return QueryEntityPropertiesExpression
     */
    default Q fetch(String... propertyNames) {
        return property(propertyNames);
    }

    /**
     * 添加查询出来的属性.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q fetch(SerializableFunction<T, R> propertyName) {
        return property(propertyName);
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
    default <T, R> Q fetch(boolean distinct, SerializableFunction<T, R> propertyName) {
        return property(distinct, propertyName);
    }

    /**
     * 添加查询出来的属性.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param function     the function
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q fetch(Function function, SerializableFunction<T, R> propertyName) {
        return property(function, propertyName);
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
    default <T, R> Q fetch(AggregateFunction aggregateFunction, SerializableFunction<T, R> propertyName) {
        return property(aggregateFunction, propertyName);
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
    default <T, R> Q fetch(AggregateFunction aggregateFunction, boolean distinct,
            SerializableFunction<T, R> propertyName) {
        return property(aggregateFunction, distinct, propertyName);
    }

    /**
     * 添加查询出来的属性 .
     *
     * @param <T>           the generic type
     * @param <R>           the generic type
     * @param propertyNames propertyNames
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q fetch(@SuppressWarnings("unchecked") SerializableFunction<T, R>... propertyNames) {
        return property(propertyNames);
    }

    /**
     * 添加查询出来的属性 .
     *
     * @param propertyNames propertyNames
     * @return QueryEntityPropertiesExpression
     */
    default Q fetch(Collection<String> propertyNames) {
        return property(propertyNames);
    }

    /**
     * Cast.
     *
     * @param <QI>                      the generic type
     * @param queryEntityExpressionType the query entity expression type
     * @return the query fetched expression
     */
    @SuppressWarnings("unchecked")
    default <QI> QI cast(Class<QI> queryEntityExpressionType) {
        return (QI) this;
    }

    /**
     * relate to.
     *
     * @param repositoryName with repository name
     * @return QueryWithExpression
     */
    default QWO relate(String repositoryName) {
        return join(repositoryName);
    }

    /**
     * join on.
     *
     * @param repositoryName with repository name
     * @return QueryWithExpression
     */
    QWO join(String repositoryName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <T>            the generic type
    //     * @param repositoryType with repository type
    //     * @return QueryWithExpression
    //     */
    //    default <T> QWO relate(Class<T> repositoryType) {
    //        return join(repositoryType);
    //    }
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <T>            the generic type
    //     * @param repositoryType with repository type
    //     * @return QueryWithExpression
    //     */
    //    <T> QWO join(Class<T> repositoryType);

    /**
     * 结束当前条件并进入排序器.
     *
     * @return SortBuilder
     */
    QuerySortExpression sort();
}
