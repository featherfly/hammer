//
//package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;
//
//import java.util.function.Predicate;
//
//import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
//import cn.featherfly.common.db.mapping.JdbcClassMapping;
//import cn.featherfly.common.db.mapping.JdbcMappingFactory;
//import cn.featherfly.common.lang.AssertIllegalArgument;
//import cn.featherfly.common.repository.builder.AliasManager;
//import cn.featherfly.common.structure.page.Limit;
//import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
//import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
//
///**
// * abstract entity sql query entity properties.
// *
// * @author zhongj
// * @param <E> the element type
// * @param <P> the generic type
// */
//public abstract class AbstractSqlQueryRelate<E> {
//
//    /** The jdbc. */
//    protected Jdbc jdbc;
//
//    /** The select builder. */
//    protected SqlSelectBasicBuilder selectBuilder;
//
//    /** The factory. */
//    protected JdbcMappingFactory factory;
//
//    /** The sql page factory. */
//    protected SqlPageFactory sqlPageFactory;
//
//    /** The alias manager. */
//    protected AliasManager aliasManager;
//
//    /** The ignore policy. */
//    protected Predicate<Object> ignoreStrategy;
//
//    /** The limit. */
//    protected Limit limit;
//
//    /** The class mapping. */
//    protected JdbcClassMapping<E> classMapping;
//
//    /** The table alias. */
//    protected String tableAlias;
//
//    /** The id name. */
//    protected String idName;
//
//    /**
//     * Instantiates a new abstract sql query entity properties.
//     *
//     * @param jdbc           jdbc
//     * @param classMapping   classMapping
//     * @param factory        MappingFactory
//     * @param sqlPageFactory the sql page factory
//     * @param aliasManager   aliasManager
//     * @param ignoreStrategy   the ignore strategy
//     */
//    public AbstractSqlQueryRelate(Jdbc jdbc, JdbcClassMapping<E> classMapping, JdbcMappingFactory factory,
//            SqlPageFactory sqlPageFactory, AliasManager aliasManager, Predicate<Object> ignoreStrategy) {
//        AssertIllegalArgument.isNotNull(ignoreStrategy, "ignoreStrategy");
//        this.ignoreStrategy = ignoreStrategy;
//        this.jdbc = jdbc;
//        this.classMapping = classMapping;
//        this.factory = factory;
//        this.sqlPageFactory = sqlPageFactory;
//        this.aliasManager = aliasManager;
//        String tableAlias = aliasManager.getAlias(classMapping.getRepositoryName());
//        if (tableAlias == null) {
//            tableAlias = aliasManager.put(classMapping.getRepositoryName());
//        }
//        if (classMapping.getPrivaryKeyPropertyMappings().size() == 1) {
//            idName = classMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName();
//        }
//        selectBuilder = new SqlSelectBasicBuilder(jdbc.getDialect(), classMapping, tableAlias);
//
//        this.tableAlias = tableAlias;
//    }
//
//    /**
//     * 返回selectBuilder.
//     *
//     * @return selectBuilder
//     */
//    SqlSelectBasicBuilder getSelectBuilder() {
//        return selectBuilder;
//    }
//}
