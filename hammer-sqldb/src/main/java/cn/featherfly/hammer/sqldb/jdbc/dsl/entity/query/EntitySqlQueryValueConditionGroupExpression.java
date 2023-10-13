//
//package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;
//
//import java.util.Arrays;
//import java.util.List;
//
//import cn.featherfly.common.constant.Chars;
//import cn.featherfly.common.db.SqlUtils;
//import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
//import cn.featherfly.common.db.mapping.ClassMappingUtils;
//import cn.featherfly.common.db.mapping.JdbcMappingFactory;
//import cn.featherfly.common.lang.LambdaUtils;
//import cn.featherfly.common.function.serializable.SerializableFunction;
//import cn.featherfly.common.structure.page.Limit;
//import cn.featherfly.common.structure.page.PaginationResults;
//import cn.featherfly.common.structure.page.SimplePaginationResults;
//import cn.featherfly.hammer.dsl.query.type.EntityQueryValueConditionGroup;
//import cn.featherfly.hammer.dsl.query.type.EntityQueryValueConditionGroupLogic;
//import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;
//import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression;
//import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;
//import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
//import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory.SqlPageQuery;
//import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
//import cn.featherfly.hammer.sqldb.sql.dml.AbstractEntitySqlQueryValueConditionGroupExpression;
//
///**
// * entity sql query condition group expression.实体sql查询条件逻辑组表达式.
// *
// * @author zhongj
// * @param <E> the element type
// */
//public abstract class EntitySqlQueryValueConditionGroupExpression<E> extends
//        AbstractEntitySqlQueryValueConditionGroupExpression<E, EntityQueryValueConditionGroup<E>,
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
//     * @param factory        the factory
//     * @param sqlPageFactory the sql page factory
//     * @param queryRelation  the query relation
//     */
//    public EntitySqlQueryValueConditionGroupExpression(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
//            EntitySqlQueryRelation queryRelation) {
//        this(null, factory, sqlPageFactory, queryRelation);
//    }
//
//    /**
//     * Instantiates a new entity sql query condition group expression.
//     *
//     * @param parent         the parent
//     * @param factory        the factory
//     * @param sqlPageFactory the sql page factory
//     * @param queryRelation  the query relation
//     */
//    EntitySqlQueryValueConditionGroupExpression(EntityQueryValueConditionGroupLogic<E> parent,
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
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public String build() {
//        return super.build() + Chars.SPACE + sortBuilder.build();
//    }
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
//        return (List<E>) entityRelation.getJdbc().query(sql, classMapping.getType(), params);
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
//            List<E> list = (List<E>) entityRelation.getJdbc().query(pageQuery.getSql(), classMapping.getType(),
//                    pageQuery.getParams());
//            //            @SuppressWarnings("unchecked")
//            //            List<E> list = (List<E>) entitySqlRelation.getJdbc().query(dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit()),
//            //                    classMapping.getType(),
//            //                    dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit()));
//            pagination.setPageResults(list);
//            int total = entityRelation.getJdbc().queryInt(countSql, params);
//            pagination.setTotal(total);
//        } else {
//            @SuppressWarnings("unchecked")
//            List<E> list = (List<E>) entityRelation.getJdbc().query(sql, params, classMapping.getType());
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
//        return (E) entityRelation.getJdbc().querySingle(sql, classMapping.getType(), params);
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
//        return (E) entityRelation.getJdbc().queryUnique(sql, classMapping.getType(), params);
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
//        return entityRelation.getJdbc().queryString(sql, params);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public int intValue() {
//        String sql = getRoot().expression();
//        Object[] params = getRoot().getParams().toArray();
//        if (limit != null) {
//            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
//                    params);
//            sql = pageQuery.getSql();
//            params = pageQuery.getParams();
//        }
//        return entityRelation.getJdbc().queryInt(sql, params);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public long longValue() {
//        String sql = getRoot().expression();
//        Object[] params = getRoot().getParams().toArray();
//        if (limit != null) {
//            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
//                    params);
//            sql = pageQuery.getSql();
//            params = pageQuery.getParams();
//        }
//        return entityRelation.getJdbc().queryLong(sql, params);
//    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //    @Override
//    //    public Integer integer() {
//    //        String sql = getRoot().expression();
//    //        Object[] params = getRoot().getParams().toArray();
//    //        if (limit != null) {
//    //            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
//    //                    params);
//    //            sql = pageQuery.getSql();
//    //            params = pageQuery.getParams();
//    //        }
//    //        return entityRelation.getJdbc().queryInteger(sql, params);
//    //    }
//    //
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //    @Override
//    //    public Long longInt() {
//    //        String sql = getRoot().expression();
//    //        Object[] params = getRoot().getParams().toArray();
//    //        if (limit != null) {
//    //            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
//    //                    params);
//    //            sql = pageQuery.getSql();
//    //            params = pageQuery.getParams();
//    //        }
//    //        return entityRelation.getJdbc().queryLongWrapper(sql, params);
//    //    }
//    //
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    //    @Override
//    //    public BigDecimal decimal() {
//    //        String sql = getRoot().expression();
//    //        Object[] params = getRoot().getParams().toArray();
//    //        if (limit != null) {
//    //            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
//    //                    params);
//    //            sql = pageQuery.getSql();
//    //            params = pageQuery.getParams();
//    //        }
//    //        return entityRelation.getJdbc().queryBigDecimal(sql, params);
//    //    }
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
//        return entityRelation.getJdbc().queryValue(sql, type, params);
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
//    /**
//     * Asc.
//     *
//     * @param names the names
//     * @return the entity query sorted expression
//     */
//    //        @Override
//    public EntityQuerySortedExpression<E> asc(String... names) {
//        ((EntitySqlQueryValueConditionGroupExpression<E>) getRoot()).sortBuilder
//                .asc(ClassMappingUtils.getColumnNames(classMapping, names));
//        return this;
//    }
//
//    //        /**
//    //         * {@inheritDoc}
//    //         */
//    /**
//     * Asc.
//     *
//     * @param names the names
//     * @return the entity query sorted expression
//     */
//    //        @Override
//    public EntityQuerySortedExpression<E> asc(List<String> names) {
//        // YUFEI_TODO asc desc 需要和强类型绑定
//        ((EntitySqlQueryValueConditionGroupExpression<E>) getRoot()).sortBuilder
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
//    /**
//     * Desc.
//     *
//     * @param names the names
//     * @return the entity query sorted expression
//     */
//    //    @Override
//    public EntityQuerySortedExpression<E> desc(String... names) {
//        ((EntitySqlQueryValueConditionGroupExpression<E>) getRoot()).sortBuilder
//                .desc(ClassMappingUtils.getColumnNames(classMapping, names));
//        return this;
//    }
//
//    //    /**
//    //     * {@inheritDoc}
//    //     */
//    /**
//     * Desc.
//     *
//     * @param names the names
//     * @return the entity query sorted expression
//     */
//    //    @Override
//    public EntityQuerySortedExpression<E> desc(List<String> names) {
//        ((EntitySqlQueryValueConditionGroupExpression<E>) getRoot()).sortBuilder
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
