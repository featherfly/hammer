
package cn.featherfly.juorm.expression.query;

import java.util.Collection;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.juorm.expression.ConditionGroupExpression;
import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.WhereExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface QueryWithEntityExpression<QW extends QueryWithExpression<QW, QWO, QWE, C, L>,
        QWO extends QueryWithOnExpression<QW, QWO, QWE, C, L>,
        QWE extends QueryWithEntityExpression<QW, QWO, QWE, C, L>, C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>>
        extends WhereExpression<C, L>, QueryWithExpression<QW, QWO, QWE, C, L> {

    /**
     * <p>
     * 添加查询出来的属性
     * </p>
     *
     * @param propertyName propertyName
     * @return QueryWithEntityExpression
     */
    QWE fetch(String propertyName);

    /**
     * <p>
     * 添加查询出来的属性
     * </p>
     *
     * @param propertyNames propertyNames
     * @return QueryWithEntityExpression
     */
    QWE fetch(String... propertyNames);

    /**
     * <p>
     * 添加查询出来的属性
     * </p>
     *
     * @param propertyName propertyName
     * @return QueryWithEntityExpression
     */
    <T, R> QWE fetch(SerializableFunction<T, R> propertyName);

    /**
     * <p>
     * 添加查询出来的属性
     * </p>
     *
     * @param propertyNames propertyNames
     * @return QueryWithEntityExpression
     */
    <T, R> QWE fetch(@SuppressWarnings("unchecked") SerializableFunction<T, R>... propertyNames);

    /**
     * <p>
     * 添加查询出来的属性
     * </p>
     *
     * @param propertyNames propertyNames
     * @return QueryWithEntityExpression
     */
    QWE fetch(Collection<String> propertyNames);

    /**
     * 添加查询出来的所有属性
     *
     * @return QueryWithExpression
     */
    QW fetch();
}
