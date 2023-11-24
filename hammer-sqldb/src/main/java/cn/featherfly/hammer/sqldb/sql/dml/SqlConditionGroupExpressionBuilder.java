///*
// * All rights Reserved, Designed By zhongj
// * @Title: SqlConditionGroupExpressionBuilder.java
// * @Package cn.featherfly.hammer.sqldb.sql.dml
// * @Description: todo (用一句话描述该文件做什么)
// * @author: zhongj
// * @date: 2022年11月29日 下午5:03:42
// * @version V1.0
// * @Copyright: 2022 www.featherfly.cn Inc. All rights reserved.
// */
//
//package cn.featherfly.hammer.sqldb.sql.dml;
//
//import cn.featherfly.common.db.builder.SqlBuilder;
//import cn.featherfly.common.db.dialect.Dialect;
//import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
//import cn.featherfly.hammer.dml.BuildableConditionGroupExpression;
//import cn.featherfly.hammer.dml.BuildableConditionGroupLogicExpression;
//import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.AbstractSqlConditionsGroupExpression;
//
///**
// * sql condition group builder. sql条件逻辑组构造器.
// *
// * @author zhongj
// */
// FIXME 后续来处理
//public class SqlConditionGroupExpressionBuilder extends
//        AbstractSqlConditionsGroupExpression<BuildableConditionGroupExpression, BuildableConditionGroupLogicExpression,
//                QueryConditionConfig>
//        implements BuildableConditionGroupExpression, BuildableConditionGroupLogicExpression, SqlBuilder {
//
//    /**
//     * Instantiates a new sql condition group expression builder.
//     *
//     * @param dialect              dialect
//     * @param queryConditionConfig the query condition config
//     */
//    public SqlConditionGroupExpressionBuilder(Dialect dialect, QueryConditionConfig queryConditionConfig) {
//        this(dialect, null, queryConditionConfig);
//    }
//
//    /**
//     * Instantiates a new sql condition group expression builder.
//     *
//     * @param dialect              dialect
//     * @param queryAlias           queryAlias
//     * @param queryConditionConfig the query condition config
//     */
//    public SqlConditionGroupExpressionBuilder(Dialect dialect, String queryAlias,
//            QueryConditionConfig queryConditionConfig) {
//        this(null, dialect, queryAlias, queryConditionConfig);
//    }
//
//    /**
//     * Instantiates a new sql condition group expression builder.
//     *
//     * @param parent               parent group
//     * @param dialect              dialect
//     * @param queryAlias           queryAlias
//     * @param queryConditionConfig the query condition config
//     */
//    SqlConditionGroupExpressionBuilder(BuildableConditionGroupLogicExpression parent, Dialect dialect,
//            String queryAlias, QueryConditionConfig queryConditionConfig) {
//        super(parent, dialect, queryAlias, queryConditionConfig);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    protected BuildableConditionGroupExpression createGroup(BuildableConditionGroupLogicExpression parent,
//            String queryAlias) {
//        return new SqlConditionGroupExpressionBuilder(parent, dialect, queryAlias,
//                (QueryConditionConfig) conditionConfig);
//    }
//}
