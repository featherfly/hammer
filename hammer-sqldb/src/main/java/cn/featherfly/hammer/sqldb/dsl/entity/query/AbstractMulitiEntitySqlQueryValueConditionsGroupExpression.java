
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.speedment.common.tuple.Tuple7;
import com.speedment.common.tuple.Tuple8;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.config.cache.QueryPageResult;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueConditionGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueLimitExecutor;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueSortExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueSortedExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.AbstractMulitiEntitySqlConditionsGroupExpressionBase;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryConditionGroupQuery;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * sql condition group expression. 条件逻辑组构造器.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <V> the value type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractMulitiEntitySqlQueryValueConditionsGroupExpression<E, V,
    C extends EntityQueryValueConditionGroupExpression<E, V, C, L, EntityQueryValueSortExpression<E, V>>,
    L extends EntityQueryValueConditionGroupLogicExpression<E, V, C, L, EntityQueryValueSortExpression<E, V>>> extends
    AbstractMulitiEntitySqlConditionsGroupExpressionBase<E, C, L, QueryConditionConfig, EntitySqlQueryRelation,
        SqlSelectBasicBuilder>
    implements EntityQueryValueConditionGroupExpression<E, V, C, L, EntityQueryValueSortExpression<E, V>>,
    EntityQueryValueConditionGroupLogicExpression<E, V, C, L, EntityQueryValueSortExpression<E, V>>,
    EntityQueryValueSortExpression<E, V>, EntityQueryValueSortedExpression<E, V> {

    private SqlSortBuilder sortBuilder;

    /** The sql page factory. */
    protected SqlPageFactory sqlPageFactory;

    /** The query type. */
    protected final Class<E> queryType;

    /** The value type. */
    protected final Class<V> valueType;

    /** The hammer config. */
    protected final HammerConfig hammerConfig;

    private final EntitySqlQueryConditionGroupQuery<E> entitySqlQueryConditionGroupQuery;

    /**
     * Instantiates a new abstract entity sql condition group expression.
     *
     * @param parent the parent
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation the query relation
     * @param valueType the value type
     */
    @SuppressWarnings("unchecked")
    protected AbstractMulitiEntitySqlQueryValueConditionsGroupExpression(L parent, HammerConfig hammerConfig,
        JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation,
        Class<V> valueType) {
        super(parent, factory, queryRelation);
        this.sqlPageFactory = sqlPageFactory;
        this.valueType = valueType;
        queryType = (Class<E>) queryRelation.getEntityRelation(0).getClassMapping().getType();
        sortBuilder = new SqlSortBuilder(dialect, queryRelation.getEntityRelation(0).getTableAlias());
        this.hammerConfig = hammerConfig;
        entitySqlQueryConditionGroupQuery = new EntitySqlQueryConditionGroupQuery<>(this, sqlPageFactory,
            entityRelation, hammerConfig.getCacheConfig().getQueryPageResultCache());
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    protected AbstractMulitiEntitySqlQueryValueConditionsGroupExpression<E, V, C, L> getRoot() {
        L p = endGroup();
        while (p != p.endGroup()) {
            p = p.endGroup();
        }
        return (AbstractMulitiEntitySqlQueryValueConditionsGroupExpression<E, V, C, L>) p;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        StringBuilder result = new StringBuilder(super.expression());
        String sort = sortBuilder.build();
        if (result.length() > 0) {
            if (Lang.isNotEmpty(sort)) {
                return result.append(Chars.SPACE).append(sort).toString();
            } else {
                return result.toString();
            }
        } else {
            return sort;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryValueLimitExecutor<E, V> limit(Limit limit) {
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
    public List<E> list() {
        return entitySqlQueryConditionGroupQuery.list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<E> pagination() {
        return entitySqlQueryConditionGroupQuery.pagination();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E single() {
        return entitySqlQueryConditionGroupQuery.single();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E unique() {
        return entitySqlQueryConditionGroupQuery.unique();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V value() {
        return entitySqlQueryConditionGroupQuery.value(valueType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<V> valueList() {
        return entitySqlQueryConditionGroupQuery.list(valueType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<V> valuePagination() {
        return entitySqlQueryConditionGroupQuery.pagination(valueType);
    }

    // ****************************************************************************************************************
    // sort
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryValueSortExpression<E, V> sort() {
        return this;
    }

    /**
     * Asc.
     *
     * @param names the names
     * @return the entity query sorted expression
     */
    //        @Override
    public EntityQueryValueSortedExpression<E, V> asc(String... names) {
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
    public EntityQueryValueSortedExpression<E, V> asc(List<String> names) {
        getRootSortBuilder().asc(ClassMappingUtils.getColumnNames(classMapping, names));

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryValueSortedExpression<E, V> asc(SerializableFunction<E, R> name) {
        return asc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryValueSortedExpression<E, V> asc(
        @SuppressWarnings("unchecked") SerializableFunction<E, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return asc(nameArray);
    }

    /**
     * Desc.
     *
     * @param names the names
     * @return the entity query sorted expression
     */
    //    @Override
    public EntityQueryValueSortedExpression<E, V> desc(String... names) {
        getRootSortBuilder().desc(ClassMappingUtils.getColumnNames(classMapping, names));

        return this;
    }

    /**
     * Desc.
     *
     * @param names the names
     * @return the entity query sorted expression
     */
    //    @Override
    public EntityQueryValueSortedExpression<E, V> desc(List<String> names) {
        getRootSortBuilder().desc(ClassMappingUtils.getColumnNames(classMapping, names));

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryValueSortedExpression<E, V> desc(SerializableFunction<E, R> name) {
        return desc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryValueSortedExpression<E, V> desc(
        @SuppressWarnings("unchecked") SerializableFunction<E, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return desc(nameArray);
    }

    // ****************************************************************************************************************
    //	protected method
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
     *         <li>Function&lt;Object, Object&gt; getId value
     *         <li>Optional&lt;Boolean&gt; query page number gt max page number
     *         </ol>
     */
    public abstract Tuple7<String, List<Serializable>, Optional<Limit>, Optional<QueryPageResult>, String,
        Function<Object, Serializable>, Optional<Boolean>> prepareList(Limit limit);

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
     *         <li>Function&lt;Object, Object&gt; getId value
     *         <li>Optional&lt;Boolean&gt; query page number gt max page number
     *         </ol>
     */
    public abstract Tuple8<String, String, List<Serializable>, Optional<Limit>, Optional<QueryPageResult>, String,
        Function<Object, Serializable>, Optional<Boolean>> preparePagination(Limit limit);

    /**
     * Gets the root sort builder.
     *
     * @return the root sort builder
     */
    protected SortBuilder getRootSortBuilder() {
        return getRoot().sortBuilder;
    }

    // ****************************************************************************************************************
    //  private method
    // ****************************************************************************************************************
}
