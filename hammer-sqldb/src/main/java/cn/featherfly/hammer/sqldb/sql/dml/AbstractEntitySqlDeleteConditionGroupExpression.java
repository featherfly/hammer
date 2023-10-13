//
///*
// * All rights Reserved, Designed By zhongj
// * @Title: AbstractEntitySqlExecutionConditionGroupExpression.java
// * @Package cn.featherfly.hammer.sqldb.sql.dml
// * @Description: AbstractEntitySqlExecutionConditionGroupExpression
// * @author: zhongj
// * @date: 2023-07-31 18:29:31
// * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
// */
//package cn.featherfly.hammer.sqldb.sql.dml;
//
//import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
//import cn.featherfly.common.db.mapping.JdbcMappingFactory;
//import cn.featherfly.hammer.dsl.execute.EntityExecutableConditionGroupExpression;
//import cn.featherfly.hammer.dsl.execute.EntityExecutableConditionGroupLogicExpression;
//import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlDeleteRelation;
//
///**
// * The Class AbstractEntitySqlDeleteConditionGroupExpression.
// *
// * @author zhongj
// * @param <E> the element type
// * @param <C> the generic type
// * @param <L> the generic type
// */
//public abstract class AbstractEntitySqlDeleteConditionGroupExpression<E,
//        C extends EntityExecutableConditionGroupExpression<E>,
//        L extends EntityExecutableConditionGroupLogicExpression<E>> extends
//        AbstractEntitySqlExecutableConditionGroupExpression<E, EntitySqlDeleteRelation, SqlDeleteFromBasicBuilder,
//                EntityExecutableConditionGroupExpression<E>, EntityExecutableConditionGroupLogicExpression<E>>
//        implements EntityExecutableConditionGroupExpression<E>, EntityExecutableConditionGroupLogicExpression<E> {
//
//    /**
//     * Instantiates a new abstract entity sql update condition group expression.
//     *
//     * @param parent            the parent
//     * @param factory           the factory
//     * @param entitySqlRelation the entity sql relation
//     */
//    protected AbstractEntitySqlDeleteConditionGroupExpression(L parent, JdbcMappingFactory factory,
//            EntitySqlDeleteRelation entitySqlRelation) {
//        super(parent, factory, entitySqlRelation);
//    }
//
//}
