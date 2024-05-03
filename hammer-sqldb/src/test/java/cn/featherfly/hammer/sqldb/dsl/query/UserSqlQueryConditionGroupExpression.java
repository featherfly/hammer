//
//package cn.featherfly.hammer.sqldb.jdbc.dsl.query;
//
//import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQueryConditionsGroupExpression;
//import cn.featherfly.hammer.sqldb.jdbc.dsl.type.StaticTypeQueryConditionGroupExpression;
//import cn.featherfly.hammer.sqldb.jdbc.dsl.type.StaticTypeStringExpression;
//import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
//
///**
// * <p>
// * UserQueryConditionGroupExpression
// * </p>
// *
// * @author zhongj
// */
//public class UserSqlQueryConditionGroupExpression
//        extends StaticTypeQueryConditionGroupExpression<User, UserSqlQueryConditionGroupExpression> {
// FIXME 后续来处理，先注释
//    /**
//     * @param queryConditionGroupExpression
//     */
//    public UserSqlQueryConditionGroupExpression(AbstractRepositorySqlQueryConditionsGroupExpression queryConditionGroupExpression) {
//        this(queryConditionGroupExpression, null);
//    }
//
//    /**
//     * @param queryConditionGroupExpression
//     */
//    public UserSqlQueryConditionGroupExpression(AbstractRepositorySqlQueryConditionsGroupExpression queryConditionGroupExpression,
//            UserSqlQueryConditionGroupExpression parent) {
//        super(queryConditionGroupExpression, parent);
//    }
//
//    public StaticTypeStringExpression<User, UserSqlQueryConditionGroupExpression> username() {
//        return new StaticTypeStringExpression<>(queryConditionGroupExpression.propertyString("username"), this);
//
//    }
//
//    // public NumberExpression<QueryConditionGroupExpression,
//    // QueryConditionGroupLogicExpression> age() {
//    // return queryConditionGroupExpression.propertyNumber("age");
//    // }
//
//    public StaticTypeStringExpression<User, UserSqlQueryConditionGroupExpression> pwd() {
//        return new StaticTypeStringExpression<>(queryConditionGroupExpression.propertyString("password"), this);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    protected UserSqlQueryConditionGroupExpression createChild(
//            AbstractRepositorySqlQueryConditionsGroupExpression queryConditionGroupExpression,
//            UserSqlQueryConditionGroupExpression parent) {
//        return new UserSqlQueryConditionGroupExpression(queryConditionGroupExpression, this);
//    }
//
//}