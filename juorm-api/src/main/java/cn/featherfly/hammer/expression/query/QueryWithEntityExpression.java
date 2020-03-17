
package cn.featherfly.hammer.expression.query;

import java.util.Collection;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.hammer.expression.RepositoryConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.RepositoryWhereExpression;
import cn.featherfly.hammer.expression.condition.RepositoryConditionsGroupExpression;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * QueryWithEntityExpression
 * </p>
 * .
 *
 * @author zhongj
 * @param <QW>  the generic type
 * @param <QWO> the generic type
 * @param <QWE> the generic type
 * @param <C>   the generic type
 * @param <L>   the generic type
 */
public interface QueryWithEntityExpression<QW extends QueryWithExpression<QW, QWO, QWE, C, L>,
        QWO extends QueryWithOnExpression<QW, QWO, QWE, C, L>,
        QWE extends QueryWithEntityExpression<QW, QWO, QWE, C, L>, C extends RepositoryConditionsGroupExpression<C, L>,
        L extends RepositoryConditionGroupLogicExpression<C, L>>
        extends RepositoryWhereExpression<C, L>, QueryWithExpression<QW, QWO, QWE, C, L> {

    /**
     * <p>
     * 添加查询出来的属性
     * </p>
     * .
     *
     * @param propertyName propertyName
     * @return QueryWithEntityExpression
     */
    QWE fetch(String propertyName);

    /**
     * <p>
     * 添加查询出来的属性
     * </p>
     * .
     *
     * @param propertyNames propertyNames
     * @return QueryWithEntityExpression
     */
    QWE fetch(String... propertyNames);

    /**
     * <p>
     * 添加查询出来的属性
     * </p>
     * .
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName propertyName
     * @return QueryWithEntityExpression
     */
    <T, R> QWE fetch(SerializableFunction<T, R> propertyName);

    /**
     * <p>
     * 添加查询出来的属性
     * </p>
     * .
     *
     * @param <T>           the generic type
     * @param <R>           the generic type
     * @param propertyNames propertyNames
     * @return QueryWithEntityExpression
     */
    <T, R> QWE fetch(@SuppressWarnings("unchecked") SerializableFunction<T, R>... propertyNames);

    /**
     * <p>
     * 添加查询出来的属性
     * </p>
     * .
     *
     * @param propertyNames propertyNames
     * @return QueryWithEntityExpression
     */
    QWE fetch(Collection<String> propertyNames);

    /**
     * 添加查询出来的所有属性.
     *
     * @return QueryWithExpression
     */
    QW fetch();
}
