
package cn.featherfly.hammer.dml.builder.sql.update;

import cn.featherfly.hammer.dml.builder.sql.query.UserQueryConditionGroupExpression;
import cn.featherfly.hammer.expression.execute.PropertyExecutableUpdateExpression;

/**
 * <p>
 * UserUpdate
 * </p>
 *
 * @author zhongj
 */
public interface UserPropertiesUpdate extends
        PropertyExecutableUpdateExpression<UserPropertiesUpdate, UserQueryConditionGroupExpression, UserQueryConditionGroupExpression, UserUpdateValue, UserUpdateNumberValue> {

    UserUpdateValue name();

    UserUpdateValue pwd();

    UserUpdateNumberValue age();
}
