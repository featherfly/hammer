
package cn.featherfly.juorm.expression.query;

import java.util.Collection;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.juorm.expression.ConditionGroupExpression;
import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface QueryEntityExpression<Q extends QueryEntityPropertiesExpression<Q, C, L>,
        C extends ConditionGroupExpression<C, L>, L extends ConditionGroupLogicExpression<C, L>>
        extends QueryListExecutor, QueryConditionLimit {
    /**
     * <p>
     * 添加select的列
     * </p>
     *
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    Q property(String propertyName);

    /**
     * <p>
     * 批量添加select的列
     * </p>
     *
     * @param propertyNames propertyNames
     * @return QueryEntityPropertiesExpression
     */
    Q property(String... propertyNames);

    /**
     * <p>
     * 添加select的列
     * </p>
     *
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    <T, R> Q property(SerializableFunction<T, R> propertyName);

    /**
     * <p>
     * 批量添加select的列
     * </p>
     *
     * @param propertyNames propertyNames
     * @return QueryEntityPropertiesExpression
     */
    <T, R> Q property(@SuppressWarnings("unchecked") SerializableFunction<T, R>... propertyNames);

    /**
     * <p>
     * 批量添加select的列
     * </p>
     *
     * @param propertyNames propertyNames
     * @return QueryEntityPropertiesExpression
     */
    Q property(Collection<String> propertyNames);

    /**
     * <p>
     * 进入条件表达式
     * </p>
     *
     * @return QueryCondition
     */
    C where();
}
