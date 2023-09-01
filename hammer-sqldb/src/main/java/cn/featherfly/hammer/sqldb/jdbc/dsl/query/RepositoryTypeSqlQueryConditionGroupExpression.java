//
//package cn.featherfly.hammer.sqldb.jdbc.dsl.query;
//
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
//import cn.featherfly.common.structure.page.Page;
//import cn.featherfly.common.structure.page.PaginationResults;
//import cn.featherfly.common.structure.page.SimplePaginationResults;
//import cn.featherfly.hammer.dsl.query.RepositoryTypeQueryConditionGroupExpression;
//import cn.featherfly.hammer.dsl.query.RepositoryTypeQueryConditionGroupLogicExpression;
//import cn.featherfly.hammer.dsl.query.TypeQuerySortExpression;
//import cn.featherfly.hammer.expression.query.TypeQueryLimitExecutor;
//import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
//import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
//import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory.SqlPageQuery;
//import cn.featherfly.hammer.sqldb.sql.dml.AbstractRepositorySqlConditionGroupExpression;
//
///**
// * repository type sql condition group builder sql条件逻辑组构造器 .
// *
// * @author zhongj
// */
//public class RepositoryTypeSqlQueryConditionGroupExpression extends
//        AbstractRepositorySqlConditionGroupExpression<RepositoryTypeQueryConditionGroupExpression, RepositoryTypeQueryConditionGroupLogicExpression>
//        implements RepositoryTypeQueryConditionGroupExpression, RepositoryTypeQueryConditionGroupLogicExpression,
//        TypeQuerySortExpression {
//
//    /** The sort builder. */
//    private SqlSortBuilder sortBuilder = new SqlSortBuilder(dialect);
//
//    /** The limit. */
//    private Limit limit;
//
//    /**
//     * Instantiates a new repository type sql query condition group expression.
//     *
//     * @param jdbc           jdbc
//     * @param factory        MappingFactory
//     * @param aliasManager   aliasManager
//     * @param sqlPageFactory the sql page factory
//     * @param classMapping   classMapping
//     * @param ignoreStrategy   the ignore strategy
//     */
//    public RepositoryTypeSqlQueryConditionGroupExpression(Jdbc jdbc, JdbcMappingFactory factory,
//            AliasManager aliasManager, SqlPageFactory sqlPageFactory, JdbcClassMapping<?> classMapping,
//            Predicate<Object> ignoreStrategy) {
//        this(jdbc, factory, aliasManager, null, sqlPageFactory, classMapping, ignoreStrategy);
//    }
//
//    /**
//     * Instantiates a new repository type sql query condition group expression.
//     *
//     * @param jdbc           jdbc
//     * @param factory        MappingFactory
//     * @param aliasManager   aliasManager
//     * @param queryAlias     queryAlias
//     * @param sqlPageFactory the sql page factory
//     * @param classMapping   classMapping
//     * @param ignoreStrategy   the ignore strategy
//     */
//    public RepositoryTypeSqlQueryConditionGroupExpression(Jdbc jdbc, JdbcMappingFactory factory,
//            AliasManager aliasManager, String queryAlias, SqlPageFactory sqlPageFactory,
//            JdbcClassMapping<?> classMapping, Predicate<Object> ignoreStrategy) {
//        this(null, jdbc, factory, aliasManager, queryAlias, sqlPageFactory, classMapping, ignoreStrategy);
//    }
//
//    /**
//     * Instantiates a new repository type sql query condition group expression.
//     *
//     * @param parent         parent group
//     * @param jdbc           the jdbc
//     * @param factory        MappingFactory
//     * @param aliasManager   aliasManager
//     * @param queryAlias     queryAlias
//     * @param sqlPageFactory the sql page factory
//     * @param classMapping   classMapping
//     * @param ignoreStrategy   the ignore strategy
//     */
//    RepositoryTypeSqlQueryConditionGroupExpression(RepositoryTypeQueryConditionGroupLogicExpression parent, Jdbc jdbc,
//            JdbcMappingFactory factory, AliasManager aliasManager, String queryAlias, SqlPageFactory sqlPageFactory,
//            JdbcClassMapping<?> classMapping, Predicate<Object> ignoreStrategy) {
//        super(parent, jdbc.getDialect(), factory, aliasManager, queryAlias, sqlPageFactory, classMapping, ignoreStrategy);
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
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    protected RepositoryTypeQueryConditionGroupExpression createGroup(
//            RepositoryTypeQueryConditionGroupLogicExpression parent, String queryAlias) {
//        return new RepositoryTypeSqlQueryConditionGroupExpression(parent, jdbc, factory, aliasManager, queryAlias,
//                sqlPageFactory, classMapping, ignoreStrategy);
//    }
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
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public TypeQueryLimitExecutor limit(Integer limit) {
//        return limit(0, limit);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public TypeQueryLimitExecutor limit(Integer offset, Integer limit) {
//        return limit(new Limit(offset, limit));
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public TypeQueryLimitExecutor limit(Page page) {
//        return limit(new Limit(page));
//    }
//
//    /**
//     * Limit.
//     *
//     * @param limit the limit
//     * @return the type query limit executor
//     */
//    private TypeQueryLimitExecutor limit(Limit limit) {
//        this.limit = limit;
//        return this;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @SuppressWarnings("unchecked")
//    @Override
//    public <E> List<E> list() {
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
//        return (List<E>) jdbc.query(sql, classMapping.getType(), params);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <E> PaginationResults<E> pagination() {
//        String sql = getRoot().expression();
//        String countSql = SqlUtils.convertSelectToCount(sql);
//        Object[] params = getRoot().getParams().toArray();
//        SimplePaginationResults<E> pagination = new SimplePaginationResults<>(limit);
//        if (limit != null) {
//            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
//                    params);
//            @SuppressWarnings("unchecked")
//            List<E> list = (List<E>) jdbc.query(pageQuery.getSql(), classMapping.getType(), pageQuery.getParams());
//            //@SuppressWarnings("unchecked")
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
//    public <E> E single() {
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
//    public <E> E unique() {
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
//    public TypeQuerySortExpression sort() {
//        return this;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public TypeQuerySortExpression asc(String... names) {
//        ((RepositoryTypeSqlQueryConditionGroupExpression) getRoot()).sortBuilder
//                .asc(ClassMappingUtils.getColumnNames(classMapping, names));
//        return this;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public TypeQuerySortExpression asc(List<String> names) {
//        ((RepositoryTypeSqlQueryConditionGroupExpression) getRoot()).sortBuilder
//                .asc(ClassMappingUtils.getColumnNames(classMapping, names));
//        return this;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T, R> TypeQuerySortExpression asc(SerializableFunction<T, R> name) {
//        return asc(getPropertyName(name));
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T, R> TypeQuerySortExpression asc(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
//        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
//                .toArray(value -> new String[value]);
//        return asc(nameArray);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public TypeQuerySortExpression desc(String... names) {
//        ((RepositoryTypeSqlQueryConditionGroupExpression) getRoot()).sortBuilder
//                .desc(ClassMappingUtils.getColumnNames(classMapping, names));
//        return this;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public TypeQuerySortExpression desc(List<String> names) {
//        ((RepositoryTypeSqlQueryConditionGroupExpression) getRoot()).sortBuilder
//                .desc(ClassMappingUtils.getColumnNames(classMapping, names));
//        return this;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T, R> TypeQuerySortExpression desc(SerializableFunction<T, R> name) {
//        return desc(getPropertyName(name));
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T, R> TypeQuerySortExpression desc(@SuppressWarnings("unchecked") SerializableFunction<T, R>... names) {
//        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
//                .toArray(value -> new String[value]);
//        return desc(nameArray);
//    }
//}
