
package cn.featherfly.juorm.dml.builder.sql.vo;

import cn.featherfly.juorm.dsl.execute.ExecutableConditionGroupExpression;
import cn.featherfly.juorm.expression.execute.property.PropertyExecutableUpdate;
import cn.featherfly.juorm.expression.execute.property.UpdateNumberValue;
import cn.featherfly.juorm.expression.execute.property.UpdateValue;

/**
 * <p>
 * UserUpdate
 * </p>
 * 
 * @author zhongj
 */
public interface UserPropertyUpdate extends
        PropertyExecutableUpdate<UserPropertyUpdate, UserQueryConditionGroupExpression> {

    UpdateValue<UserQueryConditionGroupExpression, ExecutableConditionGroupExpression, String> name();

    UpdateValue<UserQueryConditionGroupExpression, ExecutableConditionGroupExpression, String> pwd();

    UpdateNumberValue<UserQueryConditionGroupExpression, ExecutableConditionGroupExpression, Integer> age();
}
