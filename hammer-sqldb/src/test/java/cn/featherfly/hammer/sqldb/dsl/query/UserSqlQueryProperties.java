//
//package cn.featherfly.hammer.sqldb.jdbc.dsl.query;
//
//import cn.featherfly.common.db.mapping.JdbcMappingFactory;
//import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQueryConditionsGroupExpression;
//import cn.featherfly.hammer.sqldb.jdbc.dsl.type.StaticTypeQueryProperties;
//import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
//
///**
// * <p>
// * UserUpdate
// * </p>
// *
// * @author zhongj
// */
//public class UserSqlQueryProperties
//        extends StaticTypeQueryProperties<User, UserSqlQueryConditionGroupExpression, UserSqlQueryProperties> {
//FIXME 后续来处理，先注释
//    /**
//     * @param queryEntityProperties
//     * @param mappingFactory
//     */
//    public UserSqlQueryProperties(SqlQueryEntity queryEntityProperties, JdbcMappingFactory mappingFactory) {
//        super(queryEntityProperties, mappingFactory);
//    }
//
//    public UserSqlQueryProperties username() {
//        property("username");
//        return this;
//    }
//
//    public UserSqlQueryProperties pwd() {
//        property("password", "pwd");
//        return this;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    protected UserSqlQueryConditionGroupExpression createCondition(
//            AbstractRepositorySqlQueryConditionsGroupExpression queryConditionGroupExpression) {
//        return new UserSqlQueryConditionGroupExpression(queryConditionGroupExpression);
//    }
//}