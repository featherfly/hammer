
package cn.featherfly.hammer.expression.query;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.hammer.expression.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.EntityConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.EntityWhereExpression;

/**
 * The Interface TypeQueryWithExpression.
 *
 * @author zhongj
 * @param <E>   the query type
 * @param <QW>  the generic type
 * @param <QWE> the generic type
 * @param <C>   the generic type
 * @param <L>   the generic type
 */
public interface EntityQueryWithExpression<E, QW extends EntityQueryWithExpression<E, QW, QWE, C, L>,
        QWE extends EntityQueryWithEntityExpression<E, QW, QWE, C, L>,
        C extends EntityConditionGroupExpression<E, C, L>, L extends EntityConditionGroupLogicExpression<E, C, L>>
        extends EntityWhereExpression<E, C, L>, EntityQueryListExecutor<E>, EntityQueryConditionLimit<E> {

    /**
     * with.
     *
     * @param <R>          the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <R> QWE with(SerializableFunction<E, R> propertyName);

    /**
     * with.
     *
     * @param <R>          the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <R> QWE with(SerializableFunction2<R, E> propertyName);

    /**
     * with.
     *
     * @param <R>          the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    QWE with(SerializableFunction3<E, E> propertyName);

    /**
     * with.
     *
     * @param <R>          the generic type
     * @param propertyName with type object property name
     * @param index        with index
     * @return TypeQueryWithOnExpression
     */
    <R> QWE with(SerializableFunction<E, R> propertyName, int index);

}
