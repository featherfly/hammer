
package cn.featherfly.db.dsl.builder.sql;

import cn.featherfly.db.dsl.builder.ConditionBuilder;

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
}
