
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import cn.featherfly.common.tuple.Tuple7;
import cn.featherfly.common.tuple.Tuple8;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.operator.SortOperator;
import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.config.cache.QueryPageResult;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQueryLimitExecutor;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression6;
import cn.featherfly.hammer.expression.entity.query.sort.EntitySetSortPropertyExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.AbstractMulitiEntitySqlConditionsGroupExpression6;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryConditionGroupQuery;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.query.sort.EntitySetSqlSortPropertyExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * sql query condition group expression6. 查询条件逻辑组表达式6.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <E4> fouth filterable entity type
 * @param <E5> fifth filterable entity type
 * @param <E6> sixth filterable entity type
 * @param <RS> result type
 * @param <C> condition expression
 * @param <L> logic expression
 */
public abstract class AbstractMulitiEntitySqlQueryConditionsGroupExpression6<E1, E2, E3, E4, E5, E6, RS,
    C extends EntityQueryConditionGroupExpression6<E1, E2, E3, E4, E5, E6, C, L,
        EntityQuerySortExpression6<E1, E2, E3, E4, E5, E6, RS>, RS>,
    L extends EntityQueryConditionGroupLogicExpression6<E1, E2, E3, E4, E5, E6, C, L,
        EntityQuerySortExpression6<E1, E2, E3, E4, E5, E6, RS>, RS>>
    extends
    AbstractMulitiEntitySqlConditionsGroupExpression6<E1, E2, E3, E4, E5, E6, C, L, QueryConditionConfig,
        EntitySqlQueryRelation, SqlSelectBasicBuilder>
    implements
    EntityQueryConditionGroupExpression6<E1, E2, E3, E4, E5, E6, C, L,
        EntityQuerySortExpression6<E1, E2, E3, E4, E5, E6, RS>, RS>,
    EntityQueryConditionGroupLogicExpression6<E1, E2, E3, E4, E5, E6, C, L,
        EntityQuerySortExpression6<E1, E2, E3, E4, E5, E6, RS>, RS>,
    EntityQuerySortExpression6<E1, E2, E3, E4, E5, E6, RS>, EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> {

    private SqlSortBuilder sortBuilder;

    private EntitySqlQueryConditionGroupQuery<RS> entitySqlQueryConditionGroupQuery;

    /** The sql page factory. */
    protected final SqlPageFactory sqlPageFactory;

    /** The hammer config. */
    protected final HammerConfig hammerConfig;

    /**
     * Instantiates a new abstract entity sql condition group expression 2.
     *
     * @param parent the parent
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation the relation
     */
    protected AbstractMulitiEntitySqlQueryConditionsGroupExpression6(L parent, HammerConfig hammerConfig,
        JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        super(parent, factory, queryRelation);
        sortBuilder = new SqlSortBuilder(dialect, queryRelation.getEntityRelation(0).getTableAlias());
        this.sqlPageFactory = sqlPageFactory;
        entitySqlQueryConditionGroupQuery = new EntitySqlQueryConditionGroupQuery<>(this, sqlPageFactory,
            entityRelation, hammerConfig.getCacheConfig().getQueryPageResultCache());
        this.hammerConfig = hammerConfig;
    }

    // ****************************************************************************************************************

    /**
     * Limit.
     *
     * @param limit the limit
     * @return the type query limit executor
     */
    @Override
    public EntityQueryLimitExecutor<RS> limit(Limit limit) {
        entitySqlQueryConditionGroupQuery.setLimit(limit);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<RS> list() {
        return entitySqlQueryConditionGroupQuery.list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<RS> pagination() {
        return entitySqlQueryConditionGroupQuery.pagination();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RS single() {
        return entitySqlQueryConditionGroupQuery.single();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RS unique() {
        return entitySqlQueryConditionGroupQuery.unique();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long count() {
        entityRelation.getBuilder().clearColumns().addColumn(AggregateFunction.COUNT, Chars.STAR);
        return entityRelation.getJdbc().queryLong(getRoot().expression(), getRoot().getParamsArray());
    }

    // ****************************************************************************************************************
    //	sort
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression6<E1, E2, E3, E4, E5, E6, RS> sort() {

        return this;
    }

    // ****************************************************************************************************************

    /**
     * Asc.
     *
     * @param names the names
     * @return the entity query sorted expression 6
     */
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> asc(String... names) {
        getRootSortBuilder().asc(tableAlias, () -> names);
        return this;
    }

    /**
     * Asc 2.
     *
     * @param names the names
     * @return the entity query sorted expression 6
     */
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> asc2(String... names) {
        getRootSortBuilder().asc(tableAlias2, () -> names);

        return this;
    }

    /**
     * Asc 3.
     *
     * @param names the names
     * @return the entity query sorted expression 6
     */
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> asc3(String... names) {
        getRootSortBuilder().asc(tableAlias3, () -> names);

        return this;
    }

    /**
     * Asc 4.
     *
     * @param names the names
     * @return the entity query sorted expression 6
     */
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> asc4(String... names) {
        getRootSortBuilder().asc(tableAlias4, () -> names);

        return this;
    }

    /**
     * Asc 5.
     *
     * @param names the names
     * @return the entity query sorted expression 6
     */
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> asc5(String... names) {
        getRootSortBuilder().asc(tableAlias5, () -> names);

        return this;
    }

    /**
     * Asc 6.
     *
     * @param names the names
     * @return the entity query sorted expression 6
     */
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> asc6(String... names) {
        getRootSortBuilder().asc(tableAlias6, () -> names);

        return this;
    }

    /**
     * Desc.
     *
     * @param names the names
     * @return the entity query sorted expression 6
     */
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> desc(String... names) {
        getRootSortBuilder().desc(tableAlias, () -> names);
        return this;
    }

    /**
     * Desc 2.
     *
     * @param names the names
     * @return the entity query sorted expression 6
     */
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> desc2(String... names) {
        getRootSortBuilder().desc(tableAlias2, () -> names);

        return this;
    }

    /**
     * Desc 3.
     *
     * @param names the names
     * @return the entity query sorted expression 6
     */
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> desc3(String... names) {
        getRootSortBuilder().desc(tableAlias3, () -> names);

        return this;
    }

    /**
     * Desc 4.
     *
     * @param names the names
     * @return the entity query sorted expression 6
     */
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> desc4(String... names) {
        getRootSortBuilder().desc(tableAlias4, () -> names);

        return this;
    }

    /**
     * Desc 5.
     *
     * @param names the names
     * @return the entity query sorted expression 6
     */
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> desc5(String... names) {
        getRootSortBuilder().desc(tableAlias5, () -> names);

        return this;
    }

    /**
     * Desc 6.
     *
     * @param names the names
     * @return the entity query sorted expression 6
     */
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> desc6(String... names) {
        getRootSortBuilder().desc(tableAlias6, () -> names);

        return this;
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> asc(
        SixArgusConsumer<EntitySetSortPropertyExpression<E1>, EntitySetSortPropertyExpression<E2>,
            EntitySetSortPropertyExpression<E3>, EntitySetSortPropertyExpression<E4>,
            EntitySetSortPropertyExpression<E5>, EntitySetSortPropertyExpression<E6>> sortEntityExpressions) {
        sortEntityExpressions.accept(
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), tableAlias, SortOperator.ASC, classMapping),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), tableAlias2, SortOperator.ASC,
                classMapping2),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), tableAlias3, SortOperator.ASC,
                classMapping3),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), tableAlias4, SortOperator.ASC,
                classMapping4),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), tableAlias5, SortOperator.ASC,
                classMapping5),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), tableAlias6, SortOperator.ASC,
                classMapping6));

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> desc(
        SixArgusConsumer<EntitySetSortPropertyExpression<E1>, EntitySetSortPropertyExpression<E2>,
            EntitySetSortPropertyExpression<E3>, EntitySetSortPropertyExpression<E4>,
            EntitySetSortPropertyExpression<E5>, EntitySetSortPropertyExpression<E6>> sortEntityExpressions) {
        sortEntityExpressions.accept(
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), tableAlias, SortOperator.DESC, classMapping),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), tableAlias2, SortOperator.DESC,
                classMapping2),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), tableAlias3, SortOperator.DESC,
                classMapping3),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), tableAlias4, SortOperator.DESC,
                classMapping4),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), tableAlias5, SortOperator.DESC,
                classMapping5),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), tableAlias6, SortOperator.DESC,
                classMapping6));

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> asc6(SerializableFunction<E6, R> name) {
        return asc6(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> asc6(
        @SuppressWarnings("unchecked") SerializableFunction<E6, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return asc6(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> desc6(SerializableFunction<E6, R> name) {
        return desc6(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> desc6(
        @SuppressWarnings("unchecked") SerializableFunction<E6, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return desc6(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> asc5(SerializableFunction<E5, R> name) {
        return asc5(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> asc5(
        @SuppressWarnings("unchecked") SerializableFunction<E5, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return asc5(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> desc5(SerializableFunction<E5, R> name) {
        return desc5(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> desc5(
        @SuppressWarnings("unchecked") SerializableFunction<E5, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return desc5(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> asc4(SerializableFunction<E4, R> name) {
        return asc4(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> asc4(
        @SuppressWarnings("unchecked") SerializableFunction<E4, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return asc4(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> desc4(SerializableFunction<E4, R> name) {
        return desc4(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> desc4(
        @SuppressWarnings("unchecked") SerializableFunction<E4, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return desc4(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> asc3(SerializableFunction<E3, R> name) {
        return asc3(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> asc3(
        @SuppressWarnings("unchecked") SerializableFunction<E3, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return asc3(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> desc3(SerializableFunction<E3, R> name) {
        return desc3(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> desc3(
        @SuppressWarnings("unchecked") SerializableFunction<E3, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return desc3(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> asc2(SerializableFunction<E2, R> name) {
        return asc2(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> asc2(
        @SuppressWarnings("unchecked") SerializableFunction<E2, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return asc2(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> desc2(SerializableFunction<E2, R> name) {
        return desc2(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> desc2(
        @SuppressWarnings("unchecked") SerializableFunction<E2, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return desc2(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> asc(SerializableFunction<E1, R> name) {
        return asc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> asc(
        @SuppressWarnings("unchecked") SerializableFunction<E1, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return asc(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> desc(SerializableFunction<E1, R> name) {
        return desc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E1, E2, E3, E4, E5, E6, RS> desc(
        @SuppressWarnings("unchecked") SerializableFunction<E1, ?>... names) {
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

    // ****************************************************************************************************************
    //  protected method
    // ****************************************************************************************************************

    /**
     * Gets the root sort builder.
     *
     * @return the root sort builder
     */
    @SuppressWarnings("unchecked")
    protected SortBuilder getRootSortBuilder() {
        return ((AbstractMulitiEntitySqlQueryConditionsGroupExpression6<E1, E2, E3, E4, E5, E6, RS, C,
            L>) getRoot()).sortBuilder;
    }
}
