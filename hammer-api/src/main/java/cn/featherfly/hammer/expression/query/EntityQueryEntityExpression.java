
package cn.featherfly.hammer.expression.query;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.hammer.expression.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.EntityConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.EntityWhereExpression;

/**
 * EntityQueryEntityExpression .
 *
 * @author zhongj
 * @param <E>   the query type
 * @param <Q>   the generic type
 * @param <QW>  the generic type
 * @param <QWE> the generic type
 * @param <C>   the generic type
 * @param <L>   the generic type
 */
public interface EntityQueryEntityExpression<E, Q extends EntityQueryEntityPropertiesExpression<E, Q, QW, QWE, C, L>,
        QW extends EntityQueryWithExpression<E, QW, QWE, C, L>,
        QWE extends EntityQueryWithEntityExpression<E, QW, QWE, C, L>,
        C extends EntityConditionGroupExpression<E, C, L>, L extends EntityConditionGroupLogicExpression<E, C, L>>
        extends EntityWhereExpression<E, C, L>, EntityQueryListExecutor<E>, QueryCountExecutor,
        EntityQueryConditionLimit<E> {

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
     * 添加select的列 .
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    <T, R> Q property(SerializableFunction<T, R> propertyName);

    /**
     * 批量添加select的列 .
     *
     * @param <T>           the generic type
     * @param <R>           the generic type
     * @param propertyNames propertyNames
     * @return QueryEntityPropertiesExpression
     */
    <T, R> Q property(@SuppressWarnings("unchecked") SerializableFunction<T, R>... propertyNames);

    /**
     * with.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName find type object property name
     * @return EntityQueryWithOnExpression
     */
    <R> QWE with(SerializableFunction<E, R> propertyName);

    /**
     * with.
     *
     * @param <R>          the generic type
     * @param propertyName find type object property name
     * @return EntityQueryWithOnExpression
     */
    <R> QWE with(SerializableSupplier<R> propertyName);

    /**
     * with.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName with type object property name
     * @param index        with index, the first is 1
     * @return EntityQueryWithOnExpression
     */
    <R> QWE with(SerializableFunction<E, R> propertyName, int index);
}
