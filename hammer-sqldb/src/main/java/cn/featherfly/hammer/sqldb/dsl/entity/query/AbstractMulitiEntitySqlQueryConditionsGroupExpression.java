
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.speedment.common.tuple.Tuple6;
import com.speedment.common.tuple.Tuple7;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.config.cache.QueryPageResult;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryLimitExecutor;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.AbstractMulitiEntitySqlConditionsGroupExpressionBase;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryConditionGroupQuery;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * sql query condition group expression. 查询条件逻辑组表达式.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <C> condition expression
 * @param <L> logic expression
 */
public abstract class AbstractMulitiEntitySqlQueryConditionsGroupExpression<E1,
    C extends EntityQueryConditionGroupExpression<E1, C, L, EntityQuerySortExpression<E1>>,
    L extends EntityQueryConditionGroupLogicExpression<E1, C, L, EntityQuerySortExpression<E1>>> extends
    AbstractMulitiEntitySqlConditionsGroupExpressionBase<E1, C, L, QueryConditionConfig, EntitySqlQueryRelation,
        SqlSelectBasicBuilder>
    implements EntityQueryConditionGroupExpression<E1, C, L, EntityQuerySortExpression<E1>>,
    EntityQueryConditionGroupLogicExpression<E1, C, L, EntityQuerySortExpression<E1>>, EntityQuerySortExpression<E1>,
    EntityQuerySortedExpression<E1> {

    //    private Limit limit;

    private SqlSortBuilder sortBuilder;

    /** The sql page factory. */
    protected final SqlPageFactory sqlPageFactory;

    private EntitySqlQueryConditionGroupQuery<E1> entitySqlQueryConditionGroupQuery;

    /** The hammer config. */
    protected final HammerConfig hammerConfig;

    /**
     * Instantiates a new abstract entity sql condition group expression.
     *
     * @param parent the parent
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation the query relation
     */
    protected AbstractMulitiEntitySqlQueryConditionsGroupExpression(L parent, HammerConfig hammerConfig,
        JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        super(parent, factory, queryRelation);
        this.sqlPageFactory = sqlPageFactory;
        sortBuilder = new SqlSortBuilder(dialect, queryRelation.getEntityRelation(0).getTableAlias());
        entitySqlQueryConditionGroupQuery = new EntitySqlQueryConditionGroupQuery<>(this, sqlPageFactory,
            entityRelation, hammerConfig.getCacheConfig().getQueryPageResultCache());
        this.hammerConfig = hammerConfig;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected AbstractMulitiEntitySqlQueryConditionsGroupExpression<E1, C, L> getRoot() {
        L p = endGroup();
        while (p != p.endGroup()) {
            p = p.endGroup();
        }
        return (AbstractMulitiEntitySqlQueryConditionsGroupExpression<E1, C, L>) p;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public String build() {
    //        StringBuilder result = new StringBuilder(super.build());
    //        String sort = sortBuilder.build();
    //        if (result.length() > 0) {
    //            if (Lang.isNotEmpty(sort)) {
    //                return result.append(Chars.SPACE).append(sort).toString();
    //            } else {
    //                return result.toString();
    //            }
    //        } else {
    //            return sort;
    //        }
    //    }

    @Override
    public EntityQueryLimitExecutor<E1> limit(Limit limit) {
        //        this.limit = limit;
        entitySqlQueryConditionGroupQuery.setLimit(limit);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long count() {
        entityRelation.getBuilder().clearColumns().addColumn(AggregateFunction.COUNT, Chars.STAR);
        return entityRelation.getJdbc().queryLong(getRoot().expression(), getRoot().getParamsArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<E1> list() {
        return entitySqlQueryConditionGroupQuery.list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<E1> pagination() {
        return entitySqlQueryConditionGroupQuery.pagination();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E1 single() {
        return entitySqlQueryConditionGroupQuery.single();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E1 unique() {
        return entitySqlQueryConditionGroupQuery.unique();
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<E> list() {
    //        String sql = getRoot().expression();
    //        Object[] params = getRoot().getParamsArray();
    //        if (limit != null) {
    //            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
    //                    params);
    //            sql = pageQuery.getSql();
    //            params = pageQuery.getParams();
    //        }
    //        return entityRelation.getJdbc().query(sql, classMapping.getType(), params);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<E> pagination() {
    //        String sql = getRoot().expression();
    //        String countSql = SqlUtils.convertSelectToCount(sql);
    //        Object[] params = getRoot().getParamsArray();
    //        SimplePaginationResults<E> pagination = new SimplePaginationResults<>(limit);
    //        if (limit != null) {
    //            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
    //                    params);
    //            List<E> list = entityRelation.getJdbc().query(pageQuery.getSql(), classMapping.getType(),
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
    //    @Override
    //    public E single() {
    //        String sql = getRoot().expression();
    //        Object[] params = getRoot().getParamsArray();
    //        if (limit != null) {
    //            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
    //                    params);
    //            sql = pageQuery.getSql();
    //            params = pageQuery.getParams();
    //            //            sql = dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit());
    //            //            params = dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit());
    //        }
    //        return entityRelation.getJdbc().querySingle(sql, classMapping.getType(), params);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public E unique() {
    //        String sql = getRoot().expression();
    //        Object[] params = getRoot().getParamsArray();
    //        if (limit != null) {
    //            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(dialect, sql, limit.getOffset(), limit.getLimit(),
    //                    params);
    //            sql = pageQuery.getSql();
    //            params = pageQuery.getParams();
    //            //            sql = dialect.getPaginationSql(sql, limit.getOffset(), limit.getLimit());
    //            //            params = dialect.getPaginationSqlParameter(params, limit.getOffset(), limit.getLimit());
    //        }
    //        return entityRelation.getJdbc().queryUnique(sql, classMapping.getType(), params);
    //    }

    // ****************************************************************************************************************
    //	sort
    // ****************************************************************************************************************

    @Override
    public EntityQuerySortExpression<E1> sort() {
        return this;
    }

    /**
     * Asc.
     *
     * @param names the names
     * @return the entity query sorted expression
     */
    //        @Override
    public EntityQuerySortedExpression<E1> asc(String... names) {
        // ENHANCE 后续来把ClassMappingUtils.getColumnName去掉，这里已经是确定的了
        getRootSortBuilder().asc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * Asc.
     *
     * @param names the names
     * @return the entity query sorted expression
     */
    //        @Override
    public EntityQuerySortedExpression<E1> asc(List<String> names) {
        getRootSortBuilder().asc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression<E1> asc(SerializableFunction<E1, R> name) {
        return asc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression<E1> asc(@SuppressWarnings("unchecked") SerializableFunction<E1, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return asc(nameArray);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    /**
     * Desc.
     *
     * @param names the names
     * @return the entity query sorted expression
     */
    //    @Override
    public EntityQuerySortedExpression<E1> desc(String... names) {
        getRootSortBuilder().desc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    /**
     * Desc.
     *
     * @param names the names
     * @return the entity query sorted expression
     */
    //    @Override
    public EntityQuerySortedExpression<E1> desc(List<String> names) {
        getRootSortBuilder().desc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression<E1> desc(SerializableFunction<E1, R> name) {
        return desc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression<E1> desc(@SuppressWarnings("unchecked") SerializableFunction<E1, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return desc(nameArray);
    }

    // ****************************************************************************************************************

    /**
     * Prepare list.
     *
     * @param limit the limit
     * @return the tuple 6
     *         <ol>
     *         <li>query sql
     *         <li>query params
     *         <li>changed Limit if necessary
     *         <li>QueryPageResult may be null
     *         <li>orginal query sql
     *         <li>Function<Object, Object> getId value
     *         </ol>
     */
    public abstract Tuple6<String, List<Serializable>, Optional<Limit>, Optional<QueryPageResult>, String,
        Function<Object, Serializable>> prepareList(Limit limit);

    /**
     * Prepare pagination.
     *
     * @param limit the limit
     * @return the tuple 7
     *         <ol>
     *         <li>query sql
     *         <li>count sql
     *         <li>query params
     *         <li>changed Limit if necessary
     *         <li>QueryPageResult may be null
     *         <li>orginal query sql
     *         <li>Function<Object, Object> getId value
     *         </ol>
     */
    public abstract Tuple7<String, String, List<Serializable>, Optional<Limit>, Optional<QueryPageResult>, String,
        Function<Object, Serializable>> preparePagination(Limit limit);

    // ****************************************************************************************************************
    //	protected method
    // ****************************************************************************************************************

    /**
     * Gets the root sort builder.
     *
     * @return the root sort builder
     */
    protected SortBuilder getRootSortBuilder() {
        return getRoot().sortBuilder;
    }
}
