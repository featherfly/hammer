
package cn.featherfly.juorm.dml.builder.sql.update;

import cn.featherfly.juorm.dml.builder.sql.query.UserQueryConditionGroupExpression;
import cn.featherfly.juorm.expression.execute.SetExecutableUpdateExpression;
import cn.featherfly.juorm.expression.execute.UpdateNumberValueExpression;
import cn.featherfly.juorm.expression.execute.UpdateValueExpression;

/**
 * <p>
 * UserUpdate
 * </p>
 *
 * @author zhongj
 */
public class UserUpdate implements UserPropertiesUpdate,
        SetExecutableUpdateExpression<UserUpdate, UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> {

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression where() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserUpdateValue property(String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserUpdateNumberValue propertyNumber(String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        // YUFEI_TODO Auto-generated method stub
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserUpdate set(String name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserUpdate increase(String name, N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserUpdateValue name() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserUpdateValue pwd() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserUpdateNumberValue age() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

  

}
