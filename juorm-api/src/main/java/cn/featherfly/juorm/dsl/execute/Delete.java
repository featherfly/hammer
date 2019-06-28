
package cn.featherfly.juorm.dsl.execute;

/**
 * <p>
 * Delete
 * </p>
 *
 * @author zhongj
 */
public interface Delete {

    /**
     * <p>
     * 进入条件表达式
     * </p>
     *
     * @return QueryCondition
     */
    ConditionGroupExpression where();
}
