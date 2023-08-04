//
//package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;
//
//import cn.featherfly.common.db.mapping.JdbcMappingFactory;
//import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroup2;
//import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupLogic2;
//import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;
//import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression2;
//import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
//import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
//import cn.featherfly.hammer.sqldb.sql.dml.AbstractEntitySqlQueryConditionGroupExpression2;
//
///**
// * entity sql query condition group expression.实体sql查询条件逻辑组表达式.
// *
// * @author zhongj
// * @param <E>  the element type
// * @param <E2> the generic type
// * @param <RS> the query result type
// */
//public abstract class EntitySqlQueryConditionGroupExpression2<E, E2, RS> extends
//        AbstractEntitySqlQueryConditionGroupExpression2<E, E2, RS, EntityQueryConditionGroup2<E, E2, RS>,
//                EntityQueryConditionGroupLogic2<E, E2, RS>>
//        implements EntityQueryConditionGroup2<E, E2, RS>, EntityQueryConditionGroupLogic2<E, E2, RS>,
//        EntityQuerySortExpression2<E, E2, RS>, EntityQuerySortedExpression2<E, E2, RS> {
//
//    /**
//     * Instantiates a new type sql query condition group expression.
//     *
//     * @param jdbc           jdbc
//     * @param factory        the factory
//     * @param sqlPageFactory the sql page factory
//     * @param relation       the relation
//     */
//    public EntitySqlQueryConditionGroupExpression2(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
//            EntitySqlQueryRelation relation) {
//        this(null, factory, sqlPageFactory, relation);
//    }
//
//    /**
//     * Instantiates a new entity sql query condition group expression 2.
//     *
//     * @param parent         the parent
//     * @param jdbc           the jdbc
//     * @param sqlPageFactory the sql page factory
//     * @param factory        the factory
//     * @param queryRelation  the relation
//     */
//    EntitySqlQueryConditionGroupExpression2(EntityQueryConditionGroupLogic2<E, E2, RS> parent,
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
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //    @Override
//    //    public Long count() {
//    //        throw new UnsupportedException();
//    //    }
//}
