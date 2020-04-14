
package cn.featherfly.hammer.dml.builder;

import java.util.Collection;

/**
 * <p>
 * find target builder 查找目标构造器
 * </p>
 *
 * @author zhongj
 */
public interface FindBuilder extends Builder {

    /**
     * <p>
     * 添加select的列
     * </p>
     *
     * @param propertyName propertyName
     * @return FindBuilder
     */
    FindBuilder property(String propertyName);

    /**
     * <p>
     * 批量添加select的列
     * </p>
     *
     * @param propertyNames propertyNames
     * @return FindBuilder
     */
    FindBuilder property(String... propertyNames);

    /**
     * <p>
     * 批量添加select的列
     * </p>
     *
     * @param propertyNames propertyNames
     * @return FindBuilder
     */
    FindBuilder property(Collection<String> propertyNames);

    /**
     * <p>
     * 进入条件表达式
     * </p>
     *
     * @return ConditionBuilder
     */
    ConditionBuilder where();
}