
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import cn.featherfly.juorm.rdb.jdbc.dsl.type.TypeQueryConditionGroupExpression;
import cn.featherfly.juorm.rdb.jdbc.dsl.type.TypeStringExpression;
import cn.featherfly.juorm.rdb.jdbc.vo.User;

/**
 * <p>
 * UserQueryConditionGroupExpression
 * </p>
 *
 * @author zhongj
 */
public class UserSqlQueryConditionGroupExpression extends
        TypeQueryConditionGroupExpression<User, UserSqlQueryConditionGroupExpression> {

    /**
     * @param queryConditionGroupExpression
     */
    public UserSqlQueryConditionGroupExpression(
            SqlQueryConditionGroupExpression queryConditionGroupExpression) {
        this(queryConditionGroupExpression, null);
    }

    /**
     * @param queryConditionGroupExpression
     */
    public UserSqlQueryConditionGroupExpression(
            SqlQueryConditionGroupExpression queryConditionGroupExpression,
            UserSqlQueryConditionGroupExpression parent) {
        super(queryConditionGroupExpression, parent);
    }

    public TypeStringExpression<User, UserSqlQueryConditionGroupExpression> username() {
        return new TypeStringExpression<>(
                queryConditionGroupExpression.propertyString("username"), this);

    }

    // public NumberExpression<QueryConditionGroupExpression,
    // QueryConditionGroupLogicExpression> age() {
    // return queryConditionGroupExpression.propertyNumber("age");
    // }

    public TypeStringExpression<User, UserSqlQueryConditionGroupExpression> pwd() {
        return new TypeStringExpression<>(
                queryConditionGroupExpression.propertyString("password"), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected UserSqlQueryConditionGroupExpression createChild(
            SqlQueryConditionGroupExpression queryConditionGroupExpression,
            UserSqlQueryConditionGroupExpression parent) {
        return new UserSqlQueryConditionGroupExpression(
                queryConditionGroupExpression, this);
    }

}
