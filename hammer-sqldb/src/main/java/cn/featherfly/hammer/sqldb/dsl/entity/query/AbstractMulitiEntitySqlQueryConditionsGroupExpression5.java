
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
import cn.featherfly.common.function.FiveArgusConsumer;
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
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQueryLimitExecutor;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression5;
import cn.featherfly.hammer.expression.entity.query.sort.EntitySetSortPropertyExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.AbstractMulitiEntitySqlConditionsGroupExpression5;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryConditionGroupQuery;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.query.sort.EntitySetSqlSortPropertyExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * sql query condition group expression5. 查询条件逻辑组表达式5.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <E4> fouth filterable entity type
 * @param <E5> fifth filterable entity type
 * @param <RS> result type
 * @param <C> condition expression
 * @param <L> logic expression
 */
public abstract class AbstractMulitiEntitySqlQueryConditionsGroupExpression5<E1, E2, E3, E4, E5, RS,
    C extends EntityQueryConditionGroupExpression5<E1, E2, E3, E4, E5, C, L,
        EntityQuerySortExpression5<E1, E2, E3, E4, E5, RS>, RS>,
    L extends EntityQueryConditionGroupLogicExpression5<E1, E2, E3, E4, E5, C, L,
        EntityQuerySortExpression5<E1, E2, E3, E4, E5, RS>, RS>>
    extends
    AbstractMulitiEntitySqlConditionsGroupExpression5<E1, E2, E3, E4, E5, C, L, QueryConditionConfig,
        EntitySqlQueryRelation, SqlSelectBasicBuilder>
    implements
    EntityQueryConditionGroupExpression5<E1, E2, E3, E4, E5, C, L, EntityQuerySortExpression5<E1, E2, E3, E4, E5, RS>,
        RS>,
    EntityQueryConditionGroupLogicExpression5<E1, E2, E3, E4, E5, C, L,
        EntityQuerySortExpression5<E1, E2, E3, E4, E5, RS>, RS>,
    EntityQuerySortExpression5<E1, E2, E3, E4, E5, RS>, EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> {

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
    protected AbstractMulitiEntitySqlQueryConditionsGroupExpression5(L parent, HammerConfig hammerConfig,
        JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        super(parent, factory, queryRelation);
        sortBuilder = new SqlSortBuilder(dialect, queryRelation.getEntityRelation(0).getTableAlias());
        this.sqlPageFactory = sqlPageFactory;
        entitySqlQueryConditionGroupQuery = new EntitySqlQueryConditionGroupQuery<>(this, sqlPageFactory,
            entityRelation, hammerConfig.getCacheConfig().getQueryPageResultCache());
        this.hammerConfig = hammerConfig;
    }

    // ****************************************************************************************************************

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
    public EntityQuerySortExpression5<E1, E2, E3, E4, E5, RS> sort() {

        return this;
    }

    // ****************************************************************************************************************

    /**
     * Asc.
     *
     * @param names the names
     * @return the entity query sorted expression 5
     */
    public EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> asc(String... names) {
        getRootSortBuilder().asc(ClassMappingUtils.getColumnNames(classMapping, names));

        return this;
    }

    /**
     * Asc 2.
     *
     * @param names the names
     * @return the entity query sorted expression 5
     */
    public EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> asc2(String... names) {
        getRootSortBuilder().asc(queryAlias2, () -> ClassMappingUtils.getColumnNames(classMapping2, names));

        return this;
    }

    /**
     * Asc 3.
     *
     * @param names the names
     * @return the entity query sorted expression 5
     */
    public EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> asc3(String... names) {
        getRootSortBuilder().asc(queryAlias3, () -> ClassMappingUtils.getColumnNames(classMapping3, names));

        return this;
    }

    /**
     * Asc 4.
     *
     * @param names the names
     * @return the entity query sorted expression 5
     */
    public EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> asc4(String... names) {
        getRootSortBuilder().asc(queryAlias4, () -> ClassMappingUtils.getColumnNames(classMapping4, names));

        return this;
    }

    /**
     * Asc 5.
     *
     * @param names the names
     * @return the entity query sorted expression 5
     */
    public EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> asc5(String... names) {
        getRootSortBuilder().asc(queryAlias5, () -> ClassMappingUtils.getColumnNames(classMapping5, names));

        return this;
    }

    /**
     * Desc.
     *
     * @param names the names
     * @return the entity query sorted expression 5
     */
    public EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> desc(String... names) {
        getRootSortBuilder().desc(ClassMappingUtils.getColumnNames(classMapping, names));

        return this;
    }

    /**
     * Desc 2.
     *
     * @param names the names
     * @return the entity query sorted expression 5
     */
    public EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> desc2(String... names) {
        getRootSortBuilder().desc(queryAlias2, () -> ClassMappingUtils.getColumnNames(classMapping2, names));

        return this;
    }

    /**
     * Desc 3.
     *
     * @param names the names
     * @return the entity query sorted expression 5
     */
    public EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> desc3(String... names) {
        getRootSortBuilder().desc(queryAlias3, () -> ClassMappingUtils.getColumnNames(classMapping3, names));

        return this;
    }

    /**
     * Desc 4.
     *
     * @param names the names
     * @return the entity query sorted expression 5
     */
    public EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> desc4(String... names) {
        getRootSortBuilder().desc(queryAlias4, () -> ClassMappingUtils.getColumnNames(classMapping4, names));

        return this;
    }

    /**
     * Desc 5.
     *
     * @param names the names
     * @return the entity query sorted expression 5
     */
    public EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> desc5(String... names) {
        getRootSortBuilder().desc(queryAlias5, () -> ClassMappingUtils.getColumnNames(classMapping5, names));

        return this;
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> asc(FiveArgusConsumer<
        EntitySetSortPropertyExpression<E1>, EntitySetSortPropertyExpression<E2>, EntitySetSortPropertyExpression<E3>,
        EntitySetSortPropertyExpression<E4>, EntitySetSortPropertyExpression<E5>> sortEntityExpressions) {
        sortEntityExpressions.accept(
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), tableAlias, SortOperator.ASC, classMapping),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), queryAlias2, SortOperator.ASC,
                classMapping2),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), queryAlias3, SortOperator.ASC,
                classMapping3),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), queryAlias4, SortOperator.ASC,
                classMapping4),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), queryAlias5, SortOperator.ASC,
                classMapping5));

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> desc(FiveArgusConsumer<
        EntitySetSortPropertyExpression<E1>, EntitySetSortPropertyExpression<E2>, EntitySetSortPropertyExpression<E3>,
        EntitySetSortPropertyExpression<E4>, EntitySetSortPropertyExpression<E5>> sortEntityExpressions) {
        sortEntityExpressions.accept(
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), tableAlias, SortOperator.DESC, classMapping),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), queryAlias2, SortOperator.DESC,
                classMapping2),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), queryAlias3, SortOperator.DESC,
                classMapping3),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), queryAlias4, SortOperator.DESC,
                classMapping4),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), queryAlias5, SortOperator.DESC,
                classMapping5));

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> asc5(SerializableFunction<E5, R> name) {
        return asc5(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> asc5(
        @SuppressWarnings("unchecked") SerializableFunction<E5, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return asc5(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> desc5(SerializableFunction<E5, R> name) {
        return desc5(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> desc5(
        @SuppressWarnings("unchecked") SerializableFunction<E5, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return desc5(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> asc4(SerializableFunction<E4, R> name) {
        return asc4(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> asc4(
        @SuppressWarnings("unchecked") SerializableFunction<E4, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return asc4(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> desc4(SerializableFunction<E4, R> name) {
        return desc4(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> desc4(
        @SuppressWarnings("unchecked") SerializableFunction<E4, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return desc4(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> asc3(SerializableFunction<E3, R> name) {
        return asc3(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> asc3(
        @SuppressWarnings("unchecked") SerializableFunction<E3, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return asc3(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> desc3(SerializableFunction<E3, R> name) {
        return desc3(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> desc3(
        @SuppressWarnings("unchecked") SerializableFunction<E3, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return desc3(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> asc2(SerializableFunction<E2, R> name) {
        return asc2(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> asc2(
        @SuppressWarnings("unchecked") SerializableFunction<E2, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return asc2(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> desc2(SerializableFunction<E2, R> name) {
        return desc2(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> desc2(
        @SuppressWarnings("unchecked") SerializableFunction<E2, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return desc2(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> asc(SerializableFunction<E1, R> name) {
        return asc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> asc(
        @SuppressWarnings("unchecked") SerializableFunction<E1, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return asc(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> desc(SerializableFunction<E1, R> name) {
        return desc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression5<E1, E2, E3, E4, E5, RS> desc(
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
    //  protected method
    // ****************************************************************************************************************

    /**
     * Gets the root sort builder.
     *
     * @return the root sort builder
     */
    @SuppressWarnings("unchecked")
    protected SortBuilder getRootSortBuilder() {
        return ((AbstractMulitiEntitySqlQueryConditionsGroupExpression5<E1, E2, E3, E4, E5, RS, C,
            L>) getRoot()).sortBuilder;
    }
}
