
package cn.featherfly.juorm.expression.query;

import java.util.Collection;

import cn.featherfly.juorm.expression.condition.ConditionGroupExpression;
import cn.featherfly.juorm.expression.condition.LogicGroupExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface QueryEntity<Q extends QueryEntityProperties<Q, C, L>,
        C extends ConditionGroupExpression<C, L>,
        L extends LogicGroupExpression<C, L>>
        extends QueryListExecutor, QueryConditionLimit {
    /**
     * <p>
     * 添加select的列
     * </p>
     *
     * @param propertyName
     *            propertyName
     * @return FindBuilder
     */
    Q property(String propertyName);

    /**
     * <p>
     * 批量添加select的列
     * </p>
     *
     * @param propertyNames
     *            propertyNames
     * @return FindBuilder
     */
    Q property(String... propertyNames);

    /**
     * <p>
     * 批量添加select的列
     * </p>
     *
     * @param propertyNames
     *            propertyNames
     * @return FindBuilder
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
