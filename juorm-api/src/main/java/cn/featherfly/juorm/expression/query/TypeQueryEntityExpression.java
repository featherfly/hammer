
package cn.featherfly.juorm.expression.query;

import java.util.Collection;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.juorm.expression.ConditionGroupExpression;
import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.RepositoryConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.WhereExpression;
import cn.featherfly.juorm.expression.condition.RepositoryConditionsGroupExpression;

/**
 * <p>
 * TypeQueryEntityExpression
 * </p>
 * .
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
        C extends ConditionGroupExpression<C, L>, L extends ConditionGroupLogicExpression<C, L>,
        RC extends RepositoryConditionsGroupExpression<RC, RL>,
        RL extends RepositoryConditionGroupLogicExpression<RC, RL>>
        extends WhereExpression<C, L>, TypeQueryListExecutor, TypeQueryConditionLimit {

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
     * <p>
     * 添加select的列
     * </p>
     * .
     *
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    Q property(String propertyName);

    /**
     * <p>
     * 批量添加select的列
     * </p>
     * .
     *
     * @param propertyNames propertyNames
     * @return QueryEntityPropertiesExpression
     */
    Q property(String... propertyNames);

    /**
     * <p>
     * 添加select的列
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
     * 批量添加select的列
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
     * 批量添加select的列
     * </p>
     * .
     *
     * @param propertyNames propertyNames
     * @return QueryEntityPropertiesExpression
     */
    Q property(Collection<String> propertyNames);

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
     * @param <R>          the generic type
     * @param propertyName with type object property name
     * @param index        with index
     * @return TypeQueryWithOnExpression
     */
    <T, R> QWE with(SerializableFunction<T, R> propertyName, int index);
}
