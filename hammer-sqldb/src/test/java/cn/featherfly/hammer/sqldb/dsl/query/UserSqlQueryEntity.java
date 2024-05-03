//
//package cn.featherfly.hammer.sqldb.jdbc.dsl.query;
//
//import cn.featherfly.common.db.mapping.JdbcMappingFactory;
//import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQueryConditionsGroupExpression;
//import cn.featherfly.hammer.sqldb.jdbc.dsl.type.StaticTypeQueryEntity;
//import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
//
///**
// * <p>
// * UserUpdate
// * </p>
// *
// * @author zhongj
// */
//public class UserSqlQueryEntity
//        extends StaticTypeQueryEntity<User, UserSqlQueryConditionGroupExpression, UserSqlQueryEntity> {
// FIXME 后续来处理，先注释
//    private JdbcMappingFactory mappingFactory;
//
//    SqlQueryEntity queryEntity;
//
//    /**
//     * @param queryEntity
//     */
//    public UserSqlQueryEntity(SqlQueryEntity queryEntity, JdbcMappingFactory mappingFactory) {
//        super(queryEntity, mappingFactory);
//        this.mappingFactory = mappingFactory;
//        this.queryEntity = queryEntity;
//    }
//
//    public UserSqlQueryProperties properties() {
//        return new UserSqlQueryProperties(queryEntity, mappingFactory);
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