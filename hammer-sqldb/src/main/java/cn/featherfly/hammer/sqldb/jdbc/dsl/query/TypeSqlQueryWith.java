//
//package cn.featherfly.hammer.sqldb.jdbc.dsl.query;
//
//import java.util.List;
//import java.util.function.Consumer;
//import java.util.function.Predicate;
//
//import cn.featherfly.common.db.builder.dml.basic.SqlSelectJoinOnBasicBuilder;
//import cn.featherfly.common.lang.AssertIllegalArgument;
//import cn.featherfly.common.lang.Lang;
//import cn.featherfly.common.function.serializable.SerializableFunction;
//import cn.featherfly.common.repository.builder.AliasManager;
//import cn.featherfly.common.repository.mapping.ClassMapping;
//import cn.featherfly.common.repository.mapping.MappingFactory;
//import cn.featherfly.common.structure.page.Page;
//import cn.featherfly.hammer.dsl.query.RepositoryTypeQueryConditionGroupExpression;
//import cn.featherfly.hammer.dsl.query.TypeQueryWith;
//import cn.featherfly.hammer.dsl.query.TypeQueryWithEntity;
//import cn.featherfly.hammer.expression.query.TypeQueryLimitExecutor;
//import cn.featherfly.hammer.sqldb.SqldbHammerException;
//import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
//
///**
// * <p>
// * SqlQueryWith
// * </p>
// * .
// *
// * @author zhongj
// */
//public class TypeSqlQueryWith implements TypeQueryWith, TypeQueryWithEntity {
//
//    /** The sql query entity properties. */
//    protected TypeSqlQueryEntityProperties sqlQueryEntityProperties;
//
//    /** The condition table alias. */
//    protected String conditionTableAlias;
//
//    /** The condition table column. */
//    protected String conditionTableColumn;
//
//    /** The join table alias. */
//    protected String joinTableAlias;
//
//    /** The join table column. */
//    protected String joinTableColumn;
//
//    /** The select join on basic builder. */
//    protected SqlSelectJoinOnBasicBuilder selectJoinOnBasicBuilder;
//
//    /** The factory. */
//    protected JdbcMappingFactory factory;
//
//    /** The sql page factory. */
//    protected SqlPageFactory sqlPageFactory;
//
//    /** The condition type class mapping. */
//    protected JdbcClassMapping<?> conditionTypeClassMapping;
//
//    /** The join type class mapping. */
//    protected JdbcClassMapping<?> joinTypeClassMapping;
//
//    /** The fetch property. */
//    protected String fetchProperty;
//
//    /** The fetch property alias. */
//    protected String fetchPropertyAlias;
//
//    /** The ignore policy. */
//    protected Predicate<?> ignoreStrategy;
//
//    /**
//     * Instantiates a new type sql query with.
//     *
//     * @param sqlQueryEntityProperties  the sql query entity properties
//     * @param aliasManager              the alias manager
//     * @param factory                   the factory
//     * @param sqlPageFactory            the sql page factory
//     * @param conditionTypeClassMapping the condition type class mapping
//     * @param conditionTableAlias       the condition table alias
//     * @param conditionTableColumn      the condition table column
//     * @param joinTypeClassMapping      the join type class mapping
//     * @param joinTableColumn           the join table column
//     * @param ignoreStrategy              the ignore strategy
//     */
//    public TypeSqlQueryWith(TypeSqlQueryEntityProperties sqlQueryEntityProperties, AliasManager aliasManager,
//            JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, JdbcClassMapping<?> conditionTypeClassMapping,
//            String conditionTableAlias, String conditionTableColumn, JdbcClassMapping<?> joinTypeClassMapping,
//            String joinTableColumn, Predicate<?> ignoreStrategy) {
//        this(sqlQueryEntityProperties, aliasManager, factory, sqlPageFactory, conditionTypeClassMapping,
//                conditionTableAlias, conditionTableColumn, joinTypeClassMapping, joinTableColumn, null, ignoreStrategy);
//    }
//
//    /**
//     * Instantiates a new type sql query with.
//     *
//     * @param sqlQueryEntityProperties  the sql query entity properties
//     * @param aliasManager              the alias manager
//     * @param factory                   the factory
//     * @param sqlPageFactory            the sql page factory
//     * @param conditionTypeClassMapping the condition type class mapping
//     * @param conditionTableAlias       the condition table alias
//     * @param conditionTableColumn      the condition table column
//     * @param joinTypeClassMapping      the join type class mapping
//     * @param joinTableColumn           the join table column
//     * @param fetchProperty             the fetch property
//     * @param ignoreStrategy              the ignore strategy
//     */
//    public TypeSqlQueryWith(TypeSqlQueryEntityProperties sqlQueryEntityProperties, AliasManager aliasManager,
//            JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, JdbcClassMapping<?> conditionTypeClassMapping,
//            String conditionTableAlias, String conditionTableColumn, JdbcClassMapping<?> joinTypeClassMapping,
//            String joinTableColumn, String fetchProperty, Predicate<?> ignoreStrategy) {
//        super();
//        this.sqlQueryEntityProperties = sqlQueryEntityProperties;
//        this.factory = factory;
//        this.sqlPageFactory = sqlPageFactory;
//        this.conditionTypeClassMapping = conditionTypeClassMapping;
//        this.conditionTableAlias = conditionTableAlias;
//        this.conditionTableColumn = conditionTableColumn;
//        joinTableAlias = aliasManager.put(joinTypeClassMapping.getRepositoryName());
//        this.joinTableColumn = joinTableColumn;
//        this.joinTypeClassMapping = joinTypeClassMapping;
//        this.fetchProperty = fetchProperty;
//        fetchPropertyAlias = joinTableAlias;
//        AssertIllegalArgument.isNotNull(ignoreStrategy, "ignoreStrategy");
//        this.ignoreStrategy = ignoreStrategy;
//        on();
//    }
//
//    private TypeQueryWithEntity on() {
//        selectJoinOnBasicBuilder = sqlQueryEntityProperties.getSelectBuilder().join(conditionTableAlias,
//                conditionTableColumn, joinTypeClassMapping, joinTableAlias, joinTableColumn);
//        return this;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T, R> TypeQueryWithEntity with(SerializableFunction<T, R> propertyName) {
//        return sqlQueryEntityProperties.with(propertyName);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T, R> TypeQueryWithEntity with(SerializableFunction<T, R> propertyName, int index) {
//        return sqlQueryEntityProperties.with(propertyName, index);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public TypeQueryWith fetch() {
//        if (Lang.isEmpty(fetchProperty)) {
//            // ENHANCE 后续细化描述
//            throw new SqldbHammerException("can not fetch because there is no relation for find type");
//        }
//        selectJoinOnBasicBuilder.fetch(fetchProperty, fetchPropertyAlias);
//        return this;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public RepositoryTypeQueryConditionGroupExpression where() {
//        return new RepositoryTypeSqlQueryExpression(sqlQueryEntityProperties.jdbc, factory, sqlPageFactory,
//                sqlQueryEntityProperties.aliasManager, sqlQueryEntityProperties.classMapping,
//                sqlQueryEntityProperties.selectBuilder, ignoreStrategy);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public RepositoryTypeQueryConditionGroupExpression where(
//            Consumer<RepositoryTypeQueryConditionGroupExpression> consumer) {
//        RepositoryTypeSqlQueryExpression repositorySqlQueryExpression = new RepositoryTypeSqlQueryExpression(
//                sqlQueryEntityProperties.jdbc, factory, sqlPageFactory, sqlQueryEntityProperties.aliasManager,
//                sqlQueryEntityProperties.classMapping, sqlQueryEntityProperties.selectBuilder, ignoreStrategy);
//        if (consumer != null) {
//            consumer.accept(repositorySqlQueryExpression);
//        }
//        return repositorySqlQueryExpression;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <E> List<E> list() {
//        return sqlQueryEntityProperties.list();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public TypeQueryLimitExecutor limit(Integer limit) {
//        return sqlQueryEntityProperties.limit(limit);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public TypeQueryLimitExecutor limit(Integer offset, Integer limit) {
//        return sqlQueryEntityProperties.limit(offset, limit);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public TypeQueryLimitExecutor limit(Page page) {
//        return sqlQueryEntityProperties.limit(page);
//    }
//}
