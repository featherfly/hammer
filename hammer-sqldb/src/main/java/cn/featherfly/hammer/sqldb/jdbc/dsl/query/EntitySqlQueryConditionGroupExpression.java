//
//package cn.featherfly.hammer.sqldb.jdbc.dsl.query;
//
//import java.math.BigDecimal;
//import java.util.Arrays;
//import java.util.List;
//import java.util.function.Predicate;
//
//import cn.featherfly.common.constant.Chars;
//import cn.featherfly.common.db.SqlUtils;
//import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
//import cn.featherfly.common.db.mapping.ClassMappingUtils;
//import cn.featherfly.common.db.mapping.JdbcClassMapping;
//import cn.featherfly.common.db.mapping.JdbcMappingFactory;
//import cn.featherfly.common.lang.LambdaUtils;
//import cn.featherfly.common.lang.Lang;
//import cn.featherfly.common.function.serializable.SerializableFunction;
//import cn.featherfly.common.repository.builder.AliasManager;
//import cn.featherfly.common.structure.page.Limit;
//import cn.featherfly.common.structure.page.PaginationResults;
//import cn.featherfly.common.structure.page.SimplePaginationResults;
//import cn.featherfly.hammer.dsl.query.type.EntityQueryValueConditionGroup;
//import cn.featherfly.hammer.dsl.query.type.EntityQueryValueConditionGroupLogic;
//import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;
//import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression;
//import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;
//import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
//import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
//import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory.SqlPageQuery;
//import cn.featherfly.hammer.sqldb.sql.dml.AbstractEntitySqlQueryConditionGroupExpression;
//
///**
// * entity sql query condition group expression.实体sql查询条件逻辑组表达式.
// *
// * @author zhongj
// */
//public abstract class EntitySqlQueryConditionGroupExpression<E> extends
//        AbstractEntitySqlQueryConditionGroupExpression<E, EntityQueryValueConditionGroup<E>,
//                EntityQueryValueConditionGroupLogic<E>>
//        implements EntityQueryValueConditionGroup<E>, EntityQueryValueConditionGroupLogic<E>,
//        EntityQuerySortExpression<E>, EntityQuerySortedExpression<E> {
//
//    /** The sort builder. */
//    private SqlSortBuilder sortBuilder = new SqlSortBuilder(dialect);
//
//    /** The limit. */
//    private Limit limit;
//
//    /**
//     * Instantiates a new type sql query condition group expression.
//     *
//     * @param jdbc              jdbc
//     * @param classMapping      classMapping
//     * @param factory           the factory
//     * @param sqlPageFactory    the sql page factory
//     * @param aliasManager      the alias manager
//     * @param entityQueryEntity the entity query entity
//     * @param ignoreStrategy      the ignore strategy
//     */
//    public EntitySqlQueryConditionGroupExpression(Jdbc jdbc, JdbcClassMapping<E> classMapping,
//            JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, AliasManager aliasManager,
//            EntitySqlQuery<E> entityQueryEntity, Predicate<?> ignoreStrategy) {
//        this(jdbc, null, classMapping, factory, sqlPageFactory, aliasManager, entityQueryEntity, ignoreStrategy);
//    }
//
//    /**
//     * Instantiates a new type sql query condition group expression.
//     *
//     * @param jdbc              jdbc
//     * @param queryAlias        queryAlias
//     * @param classMapping      classMapping
//     * @param factory           the factory
//     * @param sqlPageFactory    the sql page factory
//     * @param aliasManager      the alias manager
//     * @param entityQueryEntity the entity query entity
//     * @param ignoreStrategy      the ignore strategy
//     */
//    public EntitySqlQueryConditionGroupExpression(Jdbc jdbc, String queryAlias, JdbcClassMapping<E> classMapping,
//            JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, AliasManager aliasManager,
//            EntitySqlQuery<E> entityQueryEntity, Predicate<?> ignoreStrategy) {
//        this(null, jdbc, queryAlias, classMapping, factory, sqlPageFactory, aliasManager, entityQueryEntity,
//                ignoreStrategy);
//    }
//
//    /**
//     * Instantiates a new type sql query condition group expression.
//     *
//     * @param parent            parent group
//     * @param jdbc              the jdbc
//     * @param queryAlias        queryAlias
//     * @param classMapping      classMapping
//     * @param factory           the factory
//     * @param sqlPageFactory    the sql page factory
//     * @param aliasManager      the alias manager
//     * @param entityQueryEntity the entity query entity
//     * @param ignoreStrategy      the ignore strategy
//     */
//    EntitySqlQueryConditionGroupExpression(EntityQueryValueConditionGroupLogic<E> parent, Jdbc jdbc, String queryAlias,
//            JdbcClassMapping<E> classMapping, JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
//            AliasManager aliasManager, EntitySqlQuery<E> entityQueryEntity, Predicate<?> ignoreStrategy) {
//        super(parent, jdbc.getDialect(), sqlPageFactory, queryAlias, classMapping, factory, aliasManager,
//                entityQueryEntity, ignoreStrategy);
//        this.jdbc = jdbc;
//    }
//
//    // ********************************************************************
//    // property
//    // ********************************************************************
//
//    /** The jdbc. */
//    protected Jdbc jdbc;
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
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public String build() {
//        String condition = super.build();
//        if (parent == null) {
//            if (Lang.isNotEmpty(condition)) {
//                return dialect.getKeywords().where() + Chars.SPACE + super.build() + Chars.SPACE + sortBuilder.build();
//            } else {
//                return super.build() + Chars.SPACE + sortBuilder.build();
//            }
//        } else {
//            return super.build();
//        }
//    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //    @Override
//    //    public EntityQueryLimitExecutor<E> limit(Integer limit) {
//    //        return limit(0, limit);
//    //    }
//    //
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //    @Override
//    //    public EntityQueryLimitExecutor<E> limit(Integer offset, Integer limit) {
//    //        return limit(new Limit(offset, limit));
//    //    }
//    //
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //    @Override
//    //    public EntityQueryLimitExecutor<E> limit(Page page) {
//    //        return limit(new Limit(page));
//    //    }
//
//    /**
//     * Limit.
//     *
//     * @param limit the limit
//     * @return the type query limit executor
//     */
//    @Override
//    public EntityQueryLimitExecutor<E> limit(Limit limit) {
//        this.limit = limit;
//        return this;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @SuppressWarnings("unchecked")
//    @Override
//    public List<E> list() {
//        String sql = getRoot().expression();
//        Object[] params = getRoot().getParams().toArray();
//        if (limit != null) {
//            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
//                    params);
//            sql = pageQuery.getSql();
//            params = pageQuery.getParams();
//        }
//        return (List<E>) jdbc.query(sql, classMapping.getType(), params);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public PaginationResults<E> pagination() {
//        String sql = getRoot().expression();
//        String countSql = SqlUtils.convertSelectToCount(sql);
//        Object[] params = getRoot().getParams().toArray();
//        SimplePaginationResults<E> pagination = new SimplePaginationResults<>(limit);
//        if (limit != null) {
//            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
//                    params);
//            @SuppressWarnings("unchecked")
//            List<E> list = (List<E>) jdbc.query(pageQuery.getSql(), classMapping.getType(), pageQuery.getParams());
//            //            @SuppressWarnings("unchecked")
//            //            List<E> list = (List<E>) jdbc.query(dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit()),
//            //                    classMapping.getType(),
//            //                    dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit()));
//            pagination.setPageResults(list);
//            int total = jdbc.queryInt(countSql, params);
//            pagination.setTotal(total);
//        } else {
//            @SuppressWarnings("unchecked")
//            List<E> list = (List<E>) jdbc.query(sql, params, classMapping.getType());
//            pagination.setPageResults(list);
//            pagination.setTotal(list.size());
//        }
//        return pagination;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @SuppressWarnings("unchecked")
//    @Override
//    public E single() {
//        String sql = getRoot().expression();
//        Object[] params = getRoot().getParams().toArray();
//        if (limit != null) {
//            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
//                    params);
//            sql = pageQuery.getSql();
//            params = pageQuery.getParams();
//            //            sql = dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit());
//            //            params = dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit());
//        }
//        return (E) jdbc.querySingle(sql, classMapping.getType(), params);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @SuppressWarnings("unchecked")
//    @Override
//    public E unique() {
//        String sql = getRoot().expression();
//        Object[] params = getRoot().getParams().toArray();
//        if (limit != null) {
//            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
//                    params);
//            sql = pageQuery.getSql();
//            params = pageQuery.getParams();
//            //            sql = dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit());
//            //            params = dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit());
//        }
//        return (E) jdbc.queryUnique(sql, classMapping.getType(), params);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public String string() {
//        String sql = getRoot().expression();
//        Object[] params = getRoot().getParams().toArray();
//        if (limit != null) {
//            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
//                    params);
//            sql = pageQuery.getSql();
//            params = pageQuery.getParams();
//        }
//        return jdbc.queryString(sql, params);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Integer integer() {
//        String sql = getRoot().expression();
//        Object[] params = getRoot().getParams().toArray();
//        if (limit != null) {
//            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
//                    params);
//            sql = pageQuery.getSql();
//            params = pageQuery.getParams();
//        }
//        return jdbc.queryInt(sql, params);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Long longInt() {
//        String sql = getRoot().expression();
//        Object[] params = getRoot().getParams().toArray();
//        if (limit != null) {
//            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
//                    params);
//            sql = pageQuery.getSql();
//            params = pageQuery.getParams();
//        }
//        return jdbc.queryLong(sql, params);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public BigDecimal decimal() {
//        String sql = getRoot().expression();
//        Object[] params = getRoot().getParams().toArray();
//        if (limit != null) {
//            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
//                    params);
//            sql = pageQuery.getSql();
//            params = pageQuery.getParams();
//        }
//        return jdbc.queryBigDecimal(sql, params);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> N number(Class<N> type) {
//        String sql = getRoot().expression();
//        Object[] params = getRoot().getParams().toArray();
//        if (limit != null) {
//            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
//                    params);
//            sql = pageQuery.getSql();
//            params = pageQuery.getParams();
//        }
//        return jdbc.queryValue(sql, type, params);
//    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //    @Override
//    //    public Long count() {
//    //        throw new UnsupportedException();
//    //    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQuerySortExpression<E> sort() {
//        return this;
//    }
//
//    //        /**
//    //         * {@inheritDoc}
//    //         */
//    //        @Override
//    public EntityQuerySortedExpression<E> asc(String... names) {
//        ((EntitySqlQueryConditionGroupExpression<E>) getRoot()).sortBuilder
//                .asc(ClassMappingUtils.getColumnNames(classMapping, names));
//        return this;
//    }
//
//    //        /**
//    //         * {@inheritDoc}
//    //         */
//    //        @Override
//    public EntityQuerySortedExpression<E> asc(List<String> names) {
//        // YUFEI_TODO asc desc 需要和强类型绑定
//        ((EntitySqlQueryConditionGroupExpression<E>) getRoot()).sortBuilder
//                .asc(ClassMappingUtils.getColumnNames(classMapping, names));
//        return this;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> EntityQuerySortedExpression<E> asc(SerializableFunction<E, R> name) {
//        // YUFEI_TODO asc desc 需要和强类型绑定
//        return asc(getPropertyName(name));
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQuerySortedExpression<E> asc(@SuppressWarnings("unchecked") SerializableFunction<E, ?>... names) {
//        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
//                .toArray(value -> new String[value]);
//        return asc(nameArray);
//    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //    @Override
//    public EntityQuerySortedExpression<E> desc(String... names) {
//        ((EntitySqlQueryConditionGroupExpression<E>) getRoot()).sortBuilder
//                .desc(ClassMappingUtils.getColumnNames(classMapping, names));
//        return this;
//    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //    @Override
//    public EntityQuerySortedExpression<E> desc(List<String> names) {
//        ((EntitySqlQueryConditionGroupExpression<E>) getRoot()).sortBuilder
//                .desc(ClassMappingUtils.getColumnNames(classMapping, names));
//        return this;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> EntityQuerySortedExpression<E> desc(SerializableFunction<E, R> name) {
//        return desc(getPropertyName(name));
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EntityQuerySortedExpression<E> desc(@SuppressWarnings("unchecked") SerializableFunction<E, ?>... names) {
//        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
//                .toArray(value -> new String[value]);
//        return desc(nameArray);
//    }
//}
