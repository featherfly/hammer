
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
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
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.operator.SortOperator;
import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.config.cache.QueryPageResult;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQueryLimitExecutor;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression2;
import cn.featherfly.hammer.expression.entity.query.sort.EntitySetSortPropertyExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.AbstractMulitiEntitySqlConditionsGroupExpression2;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryConditionGroupQuery;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.query.sort.EntitySetSqlSortPropertyExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * sql query condition group expression2. 查询条件逻辑组表达式2.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <RS> result type
 * @param <C> condition expression
 * @param <L> logic expression
 */
public abstract class AbstractMulitiEntitySqlQueryConditionsGroupExpression2<E1, E2, RS,
    C extends EntityQueryConditionGroupExpression2<E1, E2, C, L, EntityQuerySortExpression2<E1, E2, RS>, RS>,
    L extends EntityQueryConditionGroupLogicExpression2<E1, E2, C, L, EntityQuerySortExpression2<E1, E2, RS>, RS>>
    extends
    AbstractMulitiEntitySqlConditionsGroupExpression2<E1, E2, C, L, QueryConditionConfig, EntitySqlQueryRelation,
        SqlSelectBasicBuilder>
    implements EntityQueryConditionGroupExpression2<E1, E2, C, L, EntityQuerySortExpression2<E1, E2, RS>, RS>,
    EntityQueryConditionGroupLogicExpression2<E1, E2, C, L, EntityQuerySortExpression2<E1, E2, RS>, RS>,
    EntityQuerySortExpression2<E1, E2, RS>, EntityQuerySortedExpression2<E1, E2, RS> {

    private SqlSortBuilder sortBuilder;

    /** The sql page factory. */
    protected final SqlPageFactory sqlPageFactory;

    private EntitySqlQueryConditionGroupQuery<RS> entitySqlQueryConditionGroupQuery;

    /** The hammer config. */
    protected final HammerConfig hammerConfig;

    /**
     * Instantiates a new abstract entity sql condition group expression 2.
     *
     * @param parent the parent
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation the query relation
     */
    protected AbstractMulitiEntitySqlQueryConditionsGroupExpression2(L parent, HammerConfig hammerConfig,
        JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        super(parent, factory, queryRelation);
        sortBuilder = new SqlSortBuilder(dialect, queryRelation.getEntityRelation(0).getTableAlias());
        this.sqlPageFactory = sqlPageFactory;
        entitySqlQueryConditionGroupQuery = new EntitySqlQueryConditionGroupQuery<>(this, sqlPageFactory,
            entityRelation, hammerConfig.getCacheConfig().getQueryPageResultCache());
        this.hammerConfig = hammerConfig;
    }

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
    public long count() {
        entityRelation.getBuilder().clearColumns().addColumn(AggregateFunction.COUNT, Chars.STAR);
        return entityRelation.getJdbc().queryLong(getRoot().expression(), getRoot().getParamsArray());
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

    // ****************************************************************************************************************
    //	sort
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression2<E1, E2, RS> sort() {
        return this;
    }

    // ****************************************************************************************************************

    /**
     * Asc.
     *
     * @param names the names
     * @return the entity query sorted expression 2
     */
    public EntityQuerySortedExpression2<E1, E2, RS> asc(String... names) {
        getRootSortBuilder().asc(tableAlias, () -> ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * Asc 2.
     *
     * @param names the names
     * @return the entity query sorted expression 2
     */
    public EntityQuerySortedExpression2<E1, E2, RS> asc2(String... names) {
        getRootSortBuilder().asc(tableAlias2, () -> ClassMappingUtils.getColumnNames(classMapping2, names));

        return this;
    }

    /**
     * Desc.
     *
     * @param names the names
     * @return the entity query sorted expression 2
     */
    public EntityQuerySortedExpression2<E1, E2, RS> desc(String... names) {
        getRootSortBuilder().desc(tableAlias, () -> ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * Desc 2.
     *
     * @param names the names
     * @return the entity query sorted expression 2
     */
    public EntityQuerySortedExpression2<E1, E2, RS> desc2(String... names) {
        getRootSortBuilder().desc(tableAlias2, () -> ClassMappingUtils.getColumnNames(classMapping2, names));

        return this;
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <P> EntityQuerySortedExpression2<E1, E2, RS> asc(SerializableFunction<E1, P> name) {
        return asc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression2<E1, E2, RS> asc(
        @SuppressWarnings("unchecked") SerializableFunction<E1, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return asc(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <P> EntityQuerySortedExpression2<E1, E2, RS> desc(SerializableFunction<E1, P> name) {
        return desc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression2<E1, E2, RS> desc(
        @SuppressWarnings("unchecked") SerializableFunction<E1, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return desc(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression2<E1, E2, RS> asc(
        BiConsumer<EntitySetSortPropertyExpression<E1>, EntitySetSortPropertyExpression<E2>> sortEntityExpressions) {
        sortEntityExpressions.accept(
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), tableAlias, SortOperator.ASC, classMapping),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), tableAlias2, SortOperator.ASC,
                classMapping2));

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression2<E1, E2, RS> desc(
        BiConsumer<EntitySetSortPropertyExpression<E1>, EntitySetSortPropertyExpression<E2>> sortEntityExpressions) {
        sortEntityExpressions.accept(
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), tableAlias, SortOperator.DESC, classMapping),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), tableAlias2, SortOperator.DESC,
                classMapping2));

        return this;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R> EntityQuerySortedExpression2<E, E2, RS> asc(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction1<E, R> name) {
    //        int index = entities.apply(Tuples.of(new QueryEntityRepository<>(0, classMapping.getType()),
    //                new QueryEntityRepository<>(1, classMapping2.getType()))).getIndex();
    //        if (index == 0) {
    //            return asc(name);
    //        }
    //        throw new SqldbHammerException("调试错误");
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public EntityQuerySortedExpression2<E, E2, RS> asc(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction1<E, ?>... names) {
    //        int index = entities.apply(Tuples.of(new QueryEntityRepository<>(0, classMapping.getType()),
    //                new QueryEntityRepository<>(1, classMapping2.getType()))).getIndex();
    //        if (index == 1) {
    //            return asc(names);
    //        }
    //        throw new SqldbHammerException("调试错误");
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R> EntityQuerySortedExpression2<E, E2, RS> asc(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> name) {
    //        int index = entities.apply(Tuples.of(new QueryEntityRepository<>(0, classMapping.getType()),
    //                new QueryEntityRepository<>(1, classMapping2.getType()))).getIndex();
    //        if (index == 1) {
    //            return asc2(name);
    //        }
    //        throw new SqldbHammerException("调试错误");
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public EntityQuerySortedExpression2<E, E2, RS> asc(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction2<E2, ?>... names) {
    //        int index = entities.apply(Tuples.of(new QueryEntityRepository<>(0, classMapping.getType()),
    //                new QueryEntityRepository<>(1, classMapping2.getType()))).getIndex();
    //        if (index == 1) {
    //            return asc2(names);
    //        }
    //        throw new SqldbHammerException("调试错误");
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R> EntityQuerySortedExpression2<E, E2, RS> desc(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction1<E, R> name) {
    //        int index = entities.apply(Tuples.of(new QueryEntityRepository<>(0, classMapping.getType()),
    //                new QueryEntityRepository<>(1, classMapping2.getType()))).getIndex();
    //        if (index == 0) {
    //            return desc(name);
    //        }
    //        throw new SqldbHammerException("调试错误");
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public EntityQuerySortedExpression2<E, E2, RS> desc(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction1<E, ?>... names) {
    //        int index = entities.apply(Tuples.of(new QueryEntityRepository<>(0, classMapping.getType()),
    //                new QueryEntityRepository<>(1, classMapping2.getType()))).getIndex();
    //        if (index == 0) {
    //            return desc(names);
    //        }
    //        throw new SqldbHammerException("调试错误");
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R> EntityQuerySortedExpression2<E, E2, RS> desc(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> name) {
    //        int index = entities.apply(Tuples.of(new QueryEntityRepository<>(0, classMapping.getType()),
    //                new QueryEntityRepository<>(1, classMapping2.getType()))).getIndex();
    //        if (index == 1) {
    //            return desc2(name);
    //        }
    //        throw new SqldbHammerException("调试错误");
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public EntityQuerySortedExpression2<E, E2, RS> desc(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction2<E2, ?>... names) {
    //        int index = entities.apply(Tuples.of(new QueryEntityRepository<>(0, classMapping.getType()),
    //                new QueryEntityRepository<>(1, classMapping2.getType()))).getIndex();
    //        if (index == 1) {
    //            return desc2(names);
    //        }
    //        throw new SqldbHammerException("调试错误");
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression2<E1, E2, RS> asc2(SerializableFunction<E2, R> name) {
        return asc2(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression2<E1, E2, RS> asc2(
        @SuppressWarnings("unchecked") SerializableFunction<E2, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return asc2(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression2<E1, E2, RS> desc2(SerializableFunction<E2, R> name) {
        return desc2(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression2<E1, E2, RS> desc2(
        @SuppressWarnings("unchecked") SerializableFunction<E2, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return desc2(nameArray);
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
        return ((AbstractMulitiEntitySqlQueryConditionsGroupExpression2<E1, E2, RS, C, L>) getRoot()).sortBuilder;
    }
}
