
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import cn.featherfly.juorm.rdb.jdbc.dsl.type.StaticTypeQueryConditionGroupExpression;
import cn.featherfly.juorm.rdb.jdbc.dsl.type.StaticTypeStringExpression;
import cn.featherfly.juorm.rdb.jdbc.vo.User;

/**
 * <p>
 * UserQueryConditionGroupExpression
 * </p>
 *
 * @author zhongj
 */
public class UserSqlQueryConditionGroupExpression extends
        StaticTypeQueryConditionGroupExpression<User, UserSqlQueryConditionGroupExpression> {

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

    public StaticTypeStringExpression<User, UserSqlQueryConditionGroupExpression> username() {
        return new StaticTypeStringExpression<>(
                queryConditionGroupExpression.propertyString("username"), this);

    }

    // public NumberExpression<QueryConditionGroupExpression,
    // QueryConditionGroupLogicExpression> age() {
    // return queryConditionGroupExpression.propertyNumber("age");
    // }

    public StaticTypeStringExpression<User, UserSqlQueryConditionGroupExpression> pwd() {
        return new StaticTypeStringExpression<>(
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
