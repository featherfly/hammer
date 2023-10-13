//
//package cn.featherfly.hammer.sqldb.jdbc.dsl.query;
//
//import java.util.function.Predicate;
//
//import cn.featherfly.common.constant.Chars;
//import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
//import cn.featherfly.common.db.mapping.JdbcClassMapping;
//import cn.featherfly.common.db.mapping.JdbcMappingFactory;
//import cn.featherfly.common.lang.Lang;
//import cn.featherfly.common.repository.builder.AliasManager;
//import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupLogic;
//import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
//import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
//
///**
// * EntitySqlQueryExpression .
// *
// * @author zhongj
// */
//public class EntitySqlQueryExpression<E> extends EntitySqlQueryConditionGroupExpression<E> {
//
//    /** The select builder. */
//    private SqlSelectBasicBuilder selectBuilder;
//
//    /**
//     * Instantiates a new sql query expression.
//     *
//     * @param jdbc              the jdbc
//     * @param classMapping      the class mapping
//     * @param entityQueryEntity the entity query entity
//     * @param factory           the factory
//     * @param sqlPageFactory    the sql page factory
//     * @param aliasManager      the alias manager
//     * @param selectBuilder     the select builder
//     * @param ignoreStrategy      the ignore strategy
//     */
//    public EntitySqlQueryExpression(Jdbc jdbc, JdbcClassMapping<E> classMapping, EntitySqlQuery<E> entityQueryEntity,
//            JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, AliasManager aliasManager,
//            SqlSelectBasicBuilder selectBuilder, Predicate<?> ignoreStrategy) {
//        //        super(jdbc, selectBuilder.getTableAlias(), classMapping, factory, sqlPageFactory, aliasManager,
//        //                entityQueryEntity, ignoreStrategy);
//        //      IMPLSOON 后续来实现，先让编译通过
//        super(jdbc, aliasManager.getAlias(0), classMapping, factory, sqlPageFactory, aliasManager, entityQueryEntity,
//                ignoreStrategy);
//        this.selectBuilder = selectBuilder;
//    }
//
//    /**
//     * Instantiates a new type sql query expression.
//     *
//     * @param parent            the parent
//     * @param jdbc              the jdbc
//     * @param queryAlias        the query alias
//     * @param classMapping      the class mapping
//     * @param factory           the factory
//     * @param sqlPageFactory    the sql page factory
//     * @param aliasManager      the alias manager
//     * @param entityQueryEntity the entity query entity
//     * @param ignoreStrategy      the ignore strategy
//     */
//    EntitySqlQueryExpression(EntityQueryConditionGroupLogic<E> parent, Jdbc jdbc, String queryAlias,
//            JdbcClassMapping<E> classMapping, JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
//            AliasManager aliasManager, EntitySqlQuery<E> entityQueryEntity, Predicate<?> ignoreStrategy) {
//        super(parent, jdbc, queryAlias, classMapping, factory, sqlPageFactory, aliasManager, entityQueryEntity,
//                ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    protected EntitySqlQueryConditionGroupExpression<E> createGroup(EntityQueryConditionGroupLogic<E> parent,
//            String queryAlias, EntitySqlQuery<E> entityQueryEntity) {
//        if (selectBuilder != null) {
//            //      IMPLSOON 后续来实现，先让编译通过
//            //            selectBuilder.setTableAlias(queryAlias);
//        }
//        return new EntitySqlQueryExpression<>(parent, jdbc, queryAlias, classMapping, factory, sqlPageFactory,
//                aliasManager, entityQueryEntity, ignoreStrategy);
//    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //    @Override
//    //    public long count() {
//    //        selectBuilder.addColumn(AggregateFunction.COUNT, Chars.STAR);
//    //        return jdbc.queryLong(getRoot().expression(), getRoot().getParams().toArray());
//    //    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public String build() {
//        String result = "";
//        if (selectBuilder != null) {
//            result = selectBuilder
//                    .build((tableName, tableAlias) -> selectBuilder.getDefaultTableAlias().equals(tableAlias));
//        }
//        String condition = super.build();
//        if (Lang.isNotEmpty(condition)) {
//            result = result + Chars.SPACE + condition;
//        }
//        return result;
//    }
//}