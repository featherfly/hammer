
package cn.featherfly.db.dsl.builder;

import java.util.Collection;

/**
 * <p>
 * find target builder
 * 查找目标构造器
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
     * @param propertyName
     *            propertyName
     * @return FindBuilder
     */
    FindBuilder with(String propertyName);

    /**
     * <p>
     * 批量添加select的列
     * </p>
     * 
     * @param propertyNames
     *            propertyNames
     * @return FindBuilder
     */
    FindBuilder with(String... propertyNames);

    /**
     * <p>
     * 批量添加select的列
     * </p>
     * 
     * @param propertyNames
     *            propertyNames
     * @return FindBuilder
     */
    FindBuilder with(Collection<String> propertyNames);

    /**
     * <p>
     * 进入条件表达式
     * </p>
     * 
     * @return ConditionBuilder
     */
    ConditionBuilder where();
}
