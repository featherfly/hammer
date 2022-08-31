
package cn.featherfly.hammer.expression.query;

import java.util.Collection;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.hammer.dsl.query.QuerySortExpression;
import cn.featherfly.hammer.expression.ConditionGroupExpression;
import cn.featherfly.hammer.expression.ConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.RepositoryConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.WhereExpression;
import cn.featherfly.hammer.expression.condition.RepositoryConditionsGroupExpression;

/**
 * <p>
 * QueryEntityExpression
 * </p>
 * .
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
        QW extends QueryWithExpression<QW, QWO, QWE, RC, RL>, QWO extends QueryWithOnExpression<QW, QWO, QWE, RC, RL>,
        QWE extends QueryWithEntityExpression<QW, QWO, QWE, RC, RL>, C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>, RC extends RepositoryConditionsGroupExpression<RC, RL>,
        RL extends RepositoryConditionGroupLogicExpression<RC, RL>>
        extends WhereExpression<C, L>, QueryListExecutor, QueryConditionLimit, QueryCountExecutor {

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
     * Count.
     *
     * @param propertyName the property name
     * @return the q
     */
    Q count(String propertyName);

    /**
     * Count.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the q
     */
    <T, R> Q count(SerializableFunction<T, R> propertyName);

    /**
     * Sum.
     *
     * @param propertyName the property name
     * @return the q
     */
    Q sum(String propertyName);

    /**
     * Sum.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the q
     */
    <T, R> Q sum(SerializableFunction<T, R> propertyName);

    /**
     * Max.
     *
     * @param propertyName the property name
     * @return the q
     */
    Q max(String propertyName);

    /**
     * Max.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the q
     */
    <T, R> Q max(SerializableFunction<T, R> propertyName);

    /**
     * Min.
     *
     * @param propertyName the property name
     * @return the q
     */
    Q min(String propertyName);

    /**
     * Min.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the q
     */
    <T, R> Q min(SerializableFunction<T, R> propertyName);

    /**
     * Avg.
     *
     * @param propertyName the property name
     * @return the q
     */
    Q avg(String propertyName);

    /**
     * Avg.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the q
     */
    <T, R> Q avg(SerializableFunction<T, R> propertyName);

    /**
     * Distinct.
     *
     * @param propertyName the property name
     * @return the q
     */
    Q distinct(String propertyName);

    /**
     * Distinct.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the q
     */
    <T, R> Q distinct(SerializableFunction<T, R> propertyName);

    /**
     * <p>
     * 添加查询出来的属性
     * </p>
     * .
     *
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    Q property(String propertyName);

    /**
     * <p>
     * 添加查询出来的属性
     * </p>
     * .
     *
     * @param propertyName      propertyName
     * @param aggregateFunction aggregateFunction
     * @return QueryEntityPropertiesExpression
     */
    Q property(String propertyName, AggregateFunction aggregateFunction);

    /**
     * <p>
     * 添加查询出来的属性
     * </p>
     * .
     *
     * @param propertyNames propertyNames
     * @return QueryEntityPropertiesExpression
     */
    Q property(String... propertyNames);

    /**
     * <p>
     * 添加查询出来的属性
     * </p>
     * .
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    <T, R> Q property(SerializableFunction<T, R> propertyName);

    /**
     * <p>
     * 添加查询出来的属性
     * </p>
     * .
     *
     * @param <T>               the generic type
     * @param <R>               the generic type
     * @param propertyName      propertyName
     * @param aggregateFunction aggregateFunction
     * @return QueryEntityPropertiesExpression
     */
    <T, R> Q property(SerializableFunction<T, R> propertyName, AggregateFunction aggregateFunction);

    /**
     * <p>
     * 添加查询出来的属性
     * </p>
     * .
     *
     * @param <T>           the generic type
     * @param <R>           the generic type
     * @param propertyNames propertyNames
     * @return QueryEntityPropertiesExpression
     */
    <T, R> Q property(@SuppressWarnings("unchecked") SerializableFunction<T, R>... propertyNames);

    /**
     * <p>
     * 添加查询出来的属性
     * </p>
     * .
     *
     * @param propertyNames propertyNames
     * @return QueryEntityPropertiesExpression
     */
    Q property(Collection<String> propertyNames);

    /**
     * Cast.
     *
     * @param <QI>                      the generic type
     * @param queryEntityExpressionType the query entity expression type
     * @return the qi
     */
    @SuppressWarnings("unchecked")
    default <QI> QI cast(Class<QI> queryEntityExpressionType) {
        return (QI) this;
    }

    /**
     * with.
     *
     * @param repositoryName with repository name
     * @return QueryWithExpression
     */
    QWO with(String repositoryName);

    /**
     * with.
     *
     * @param <T>            the generic type
     * @param repositoryType with repository type
     * @return QueryWithExpression
     */
    <T> QWO with(Class<T> repositoryType);

    /**
     * 结束当前条件并进入排序器.
     *
     * @return SortBuilder
     */
    QuerySortExpression sort();
}
