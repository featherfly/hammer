
package cn.featherfly.hammer.expression.query;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
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
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the q
     */
    <R> Q id(SerializableFunction<E, R> propertyName);

    /**
     * 添加select的列 .
     *
     * @param <R>          the generic type
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    <R> Q property(SerializableFunction<E, R> propertyName);

    /**
     * 批量添加select的列 .
     *
     * @param <R>           the generic type
     * @param propertyNames propertyNames
     * @return QueryEntityPropertiesExpression
     */
    <R> Q property(@SuppressWarnings("unchecked") SerializableFunction<E, R>... propertyNames);

    /**
     * with.
     *
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
    <R> QWE with(SerializableFunction2<R, E> propertyName);

    /**
     * with.
     *
     * @param <R>          the generic type
     * @param propertyName find type object property name
     * @return EntityQueryWithOnExpression
     */
    QWE with(SerializableFunction3<E, E> propertyName);

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
     * @param <R>          the generic type
     * @param propertyName with type object property name
     * @param index        with index, the first is 1
     * @return EntityQueryWithOnExpression
     */
    <R> QWE with(SerializableFunction<E, R> propertyName, int index);
}
