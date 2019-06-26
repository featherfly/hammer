
package cn.featherfly.juorm.sql.dml.builder;

import cn.featherfly.juorm.dml.builder.ConditionBuilder;

/**
 * <p>
 * SqlConditoinBuilder
 * </p>
 * 
 * @author zhongj
 */
public interface SqlConditionBuilder extends ConditionBuilder{
    /**
     * <p>
     * 进入条件表达式
     * </p>
     * 
     * @return ConditionBuilder
     */
    ConditionBuilder where();

    // TODO 后续加入join 实现
    // JoinGroup join();
}
