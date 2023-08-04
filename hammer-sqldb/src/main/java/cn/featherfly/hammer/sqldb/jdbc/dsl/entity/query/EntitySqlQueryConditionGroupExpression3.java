//
//package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;
//
//import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
//import cn.featherfly.common.db.mapping.JdbcMappingFactory;
//import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroup3;
//import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupLogic3;
//import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
//import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression3;
//import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
//import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
//import cn.featherfly.hammer.sqldb.sql.dml.AbstractEntitySqlQueryConditionGroupExpression3;
//import cn.featherfly.hammer.sqldb.sql.dml.EntitySqlQueryConditionGroupQuery;
//
///**
// * entity sql query condition group expression.实体sql查询条件逻辑组表达式.
// *
// * @author zhongj
// * @param <E>  the element type
// * @param <E2> the generic type
// * @param <RS> the query result type
// */
//public abstract class EntitySqlQueryConditionGroupExpression3<E, E2, E3, RS> extends
//        AbstractEntitySqlQueryConditionGroupExpression3<E, E2, E3, RS, EntityQueryConditionGroup3<E, E2, E3, RS>,
//                EntityQueryConditionGroupLogic3<E, E2, E3, RS>>
//        implements EntityQueryConditionGroup3<E, E2, E3, RS>, EntityQueryConditionGroupLogic3<E, E2, E3, RS>,
//        EntityQuerySortExpression3<E, E2, E3, RS>, EntityQuerySortedExpression3<E, E2, E3, RS> {
//    /** The sort builder. */
//    private SqlSortBuilder sortBuilder = new SqlSortBuilder(dialect);
//
//    private EntitySqlQueryConditionGroupQuery<RS> entitySqlQueryConditionGroupQuery;
//
//    /**
//     * Instantiates a new type sql query condition group expression.
//     *
//     * @param factory        the factory
//     * @param sqlPageFactory the sql page factory
//     * @param queryRelation  the query relation
//     */
//    public EntitySqlQueryConditionGroupExpression3(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
//            EntitySqlQueryRelation queryRelation) {
//        this(null, factory, sqlPageFactory, queryRelation);
//        sortBuilder = new SqlSortBuilder(dialect);
//        entitySqlQueryConditionGroupQuery = new EntitySqlQueryConditionGroupQuery<>(this, queryRelation);
//    }
//
//    /**
//     * Instantiates a new entity sql query condition group expression 2.
//     *
//     * @param parent         the parent
//     * @param sqlPageFactory the sql page factory
//     * @param factory        the factory
//     * @param queryRelation  the query relation
//     */
//    EntitySqlQueryConditionGroupExpression3(EntityQueryConditionGroupLogic3<E, E2, E3, RS> parent,
//            JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
//        super(parent, factory, sqlPageFactory, queryRelation);
//    }
//
//    // ********************************************************************
//    // property
//    // ********************************************************************
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //    @Override
//    //    protected EntitySqlQueryConditionGroupExpression<E> createGroup(EntityQueryConditionGroupLogicExpression<E> parent,
//    //            String queryAlias, EntitySqlQuery<E> entityQueryEntity) {
//    //        return new EntitySqlQueryConditionGroupExpression<>(parent, jdbc, queryAlias, classMapping, factory,
//    //                sqlPageFactory, aliasManager, entityQueryEntity, ignoreStrategy);
//    //    }
//
//}
