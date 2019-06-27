
package cn.featherfly.juorm.dsl.query;

import java.util.Collection;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface QueryData extends QueryListExecutor, ConditionLimit {
    /**
     * <p>
     * 添加select的列
     * </p>
     *
     * @param propertyName
     *            propertyName
     * @return FindBuilder
     */
    QueryPropertiesData property(String propertyName);

    /**
     * <p>
     * 批量添加select的列
     * </p>
     *
     * @param propertyNames
     *            propertyNames
     * @return FindBuilder
     */
    QueryPropertiesData property(String... propertyNames);

    /**
     * <p>
     * 批量添加select的列
     * </p>
     *
     * @param propertyNames
     *            propertyNames
     * @return FindBuilder
     */
    QueryPropertiesData property(Collection<String> propertyNames);

    /**
     * <p>
     * 进入条件表达式
     * </p>
     *
     * @return QueryCondition
     */
    ConditionGroupExpression where();
}
