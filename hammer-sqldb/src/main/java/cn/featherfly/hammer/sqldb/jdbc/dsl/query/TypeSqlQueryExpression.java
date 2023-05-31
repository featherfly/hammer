//
//package cn.featherfly.hammer.sqldb.jdbc.dsl.query;
//
//import java.util.function.Predicate;
//
//import cn.featherfly.common.constant.Chars;
//import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
//import cn.featherfly.common.lang.Lang;
//import cn.featherfly.common.operator.AggregateFunction;
//import cn.featherfly.common.repository.builder.AliasManager;
//import cn.featherfly.common.repository.mapping.ClassMapping;
//import cn.featherfly.common.repository.mapping.MappingFactory;
//import cn.featherfly.hammer.dsl.query.TypeQueryConditionGroupLogicExpression;
//import cn.featherfly.hammer.dsl.query.TypeQueryEntity;
//import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
//import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
//
///**
// * SqlDeleteExpression .
// *
// * @author zhongj
// */
//public class TypeSqlQueryExpression extends TypeSqlQueryConditionGroupExpression {
//
//    /** The select builder. */
//    private SqlSelectBasicBuilder selectBuilder;
//
//    /**
//     * Instantiates a new sql query expression.
//     *
//     * @param jdbc            the jdbc
//     * @param classMapping    the class mapping
//     * @param typeQueryEntity the type query entity
//     * @param factory         the factory
//     * @param sqlPageFactory  the sql page factory
//     * @param aliasManager    the alias manager
//     * @param selectBuilder   the select builder
//     * @param ignoreStrategy    the ignore strategy
//     */
//    public TypeSqlQueryExpression(Jdbc jdbc, JdbcClassMapping<?> classMapping, TypeQueryEntity typeQueryEntity,
//            JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, AliasManager aliasManager,
//            SqlSelectBasicBuilder selectBuilder, Predicate<Object> ignoreStrategy) {
//        super(jdbc, selectBuilder.getTableAlias(), classMapping, factory, sqlPageFactory, aliasManager, typeQueryEntity,
//                ignoreStrategy);
//        this.selectBuilder = selectBuilder;
//    }
//
//    /**
//     * Instantiates a new type sql query expression.
//     *
//     * @param parent          the parent
//     * @param jdbc            the jdbc
//     * @param queryAlias      the query alias
//     * @param classMapping    the class mapping
//     * @param factory         the factory
//     * @param sqlPageFactory  the sql page factory
//     * @param aliasManager    the alias manager
//     * @param typeQueryEntity the type query entity
//     * @param ignoreStrategy    the ignore strategy
//     */
//    TypeSqlQueryExpression(TypeQueryConditionGroupLogicExpression parent, Jdbc jdbc, String queryAlias,
//            JdbcClassMapping<?> classMapping, JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
//            AliasManager aliasManager, TypeQueryEntity typeQueryEntity, Predicate<Object> ignoreStrategy) {
//        super(parent, jdbc, queryAlias, classMapping, factory, sqlPageFactory, aliasManager, typeQueryEntity,
//                ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    protected TypeSqlQueryConditionGroupExpression createGroup(TypeQueryConditionGroupLogicExpression parent,
//            String queryAlias, TypeQueryEntity typeQueryEntity) {
//        if (selectBuilder != null) {
//            selectBuilder.setTableAlias(queryAlias);
//        }
//        return new TypeSqlQueryExpression(parent, jdbc, queryAlias, classMapping, factory, sqlPageFactory, aliasManager,
//                typeQueryEntity, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Long count() {
//        selectBuilder.addColumn(AggregateFunction.COUNT, Chars.STAR);
//        return jdbc.queryLong(getRoot().expression(), getRoot().getParams().toArray());
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public String build() {
//        String result = "";
//        if (selectBuilder != null) {
//            result = selectBuilder.build();
//        }
//        String condition = super.build();
//        if (Lang.isNotEmpty(condition)) {
//            result = result + Chars.SPACE + condition;
//        }
//        return result;
//    }
//}
