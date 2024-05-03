
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import java.util.Arrays;
import java.util.List;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.operator.SortOperator;
import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryLimitExecutor;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression3;
import cn.featherfly.hammer.expression.entity.query.sort.EntitySetSortPropertyExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.AbstractMulitiEntitySqlConditionsGroupExpression3;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryConditionGroupQuery;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.query.sort.EntitySetSqlSortPropertyExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * sql query condition group expression3. 查询条件逻辑组表达式3.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <RS> result type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public abstract class AbstractMulitiEntitySqlQueryConditionsGroupExpression3<E1, E2, E3, RS,
    C extends EntityQueryConditionGroupExpression3<E1, E2, E3, C, L, EntityQuerySortExpression3<E1, E2, E3, RS>, RS>,
    L extends EntityQueryConditionGroupLogicExpression3<E1, E2, E3, C, L, EntityQuerySortExpression3<E1, E2, E3, RS>,
        RS>>
    extends
    AbstractMulitiEntitySqlConditionsGroupExpression3<E1, E2, E3, C, L, QueryConditionConfig, EntitySqlQueryRelation,
        SqlSelectBasicBuilder>
    implements EntityQueryConditionGroupExpression3<E1, E2, E3, C, L, EntityQuerySortExpression3<E1, E2, E3, RS>, RS>,
    EntityQueryConditionGroupLogicExpression3<E1, E2, E3, C, L, EntityQuerySortExpression3<E1, E2, E3, RS>, RS>,
    EntityQuerySortExpression3<E1, E2, E3, RS>, EntityQuerySortedExpression3<E1, E2, E3, RS> {

    private SqlSortBuilder sortBuilder;

    private EntitySqlQueryConditionGroupQuery<RS> entitySqlQueryConditionGroupQuery;

    /** The sql page factory. */
    protected SqlPageFactory sqlPageFactory;

    /**
     * Instantiates a new abstract entity sql condition group expression 2.
     *
     * @param parent         the parent
     * @param factory        the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation  the relation
     */
    protected AbstractMulitiEntitySqlQueryConditionsGroupExpression3(L parent, JdbcMappingFactory factory,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        super(parent, factory, queryRelation);
        sortBuilder = new SqlSortBuilder(dialect, queryRelation.getEntityRelation(0).getTableAlias());
        this.sqlPageFactory = sqlPageFactory;
        entitySqlQueryConditionGroupQuery = new EntitySqlQueryConditionGroupQuery<>(this, sqlPageFactory,
            entityRelation);
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
        return entityRelation.getJdbc().queryLong(getRoot().expression(), getRoot().getParams().toArray());
    }

    // ****************************************************************************************************************
    //	sort
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression3<E1, E2, E3, RS> sort() {
        return this;
    }

    // ****************************************************************************************************************

    /**
     * Asc.
     *
     * @param names the names
     * @return the entity query sorted expression 3
     */
    public EntityQuerySortedExpression3<E1, E2, E3, RS> asc(String... names) {
        getRootSortBuilder().asc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * Asc 2.
     *
     * @param names the names
     * @return the entity query sorted expression 3
     */
    public EntityQuerySortedExpression3<E1, E2, E3, RS> asc2(String... names) {
        getRootSortBuilder().asc(queryAlias2, () -> ClassMappingUtils.getColumnNames(classMapping2, names));
        return this;
    }

    /**
     * Asc 3.
     *
     * @param names the names
     * @return the entity query sorted expression 3
     */
    public EntityQuerySortedExpression3<E1, E2, E3, RS> asc3(String... names) {
        getRootSortBuilder().asc(queryAlias3, () -> ClassMappingUtils.getColumnNames(classMapping3, names));
        return this;
    }

    /**
     * Desc.
     *
     * @param names the names
     * @return the entity query sorted expression 3
     */
    public EntityQuerySortedExpression3<E1, E2, E3, RS> desc(String... names) {
        getRootSortBuilder().desc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * Desc 2.
     *
     * @param names the names
     * @return the entity query sorted expression 3
     */
    public EntityQuerySortedExpression3<E1, E2, E3, RS> desc2(String... names) {
        getRootSortBuilder().desc(queryAlias2, () -> ClassMappingUtils.getColumnNames(classMapping2, names));
        return this;
    }

    /**
     * Desc 3.
     *
     * @param names the names
     * @return the entity query sorted expression 3
     */
    public EntityQuerySortedExpression3<E1, E2, E3, RS> desc3(String... names) {
        getRootSortBuilder().desc(queryAlias3, () -> ClassMappingUtils.getColumnNames(classMapping3, names));
        return this;
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <P> EntityQuerySortedExpression3<E1, E2, E3, RS> asc(SerializableFunction<E1, P> name) {
        return asc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E1, E2, E3, RS> asc(
        @SuppressWarnings("unchecked") SerializableFunction<E1, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return asc(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <P> EntityQuerySortedExpression3<E1, E2, E3, RS> desc(SerializableFunction<E1, P> name) {
        return desc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E1, E2, E3, RS> desc(
        @SuppressWarnings("unchecked") SerializableFunction<E1, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return desc(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E1, E2, E3, RS> asc(ThreeArgusConsumer<EntitySetSortPropertyExpression<E1>,
        EntitySetSortPropertyExpression<E2>, EntitySetSortPropertyExpression<E3>> sortEntityExpressions) {
        sortEntityExpressions.accept(
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), tableAlias, SortOperator.ASC, classMapping),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), queryAlias2, SortOperator.ASC,
                classMapping2),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), queryAlias3, SortOperator.ASC,
                classMapping3));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E1, E2, E3, RS> desc(ThreeArgusConsumer<EntitySetSortPropertyExpression<E1>,
        EntitySetSortPropertyExpression<E2>, EntitySetSortPropertyExpression<E3>> sortEntityExpressions) {
        sortEntityExpressions.accept(
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), tableAlias, SortOperator.DESC, classMapping),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), queryAlias2, SortOperator.DESC,
                classMapping2),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), queryAlias3, SortOperator.DESC,
                classMapping3));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression3<E1, E2, E3, RS> asc3(SerializableFunction<E3, R> name) {
        return asc3(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E1, E2, E3, RS> asc3(
        @SuppressWarnings("unchecked") SerializableFunction<E3, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return asc3(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression3<E1, E2, E3, RS> desc3(SerializableFunction<E3, R> name) {
        return desc3(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E1, E2, E3, RS> desc3(
        @SuppressWarnings("unchecked") SerializableFunction<E3, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return desc3(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression3<E1, E2, E3, RS> asc2(SerializableFunction<E2, R> name) {
        return asc2(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E1, E2, E3, RS> asc2(
        @SuppressWarnings("unchecked") SerializableFunction<E2, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return asc2(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression3<E1, E2, E3, RS> desc2(SerializableFunction<E2, R> name) {
        return desc2(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E1, E2, E3, RS> desc2(
        @SuppressWarnings("unchecked") SerializableFunction<E2, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return desc2(nameArray);
    }

    // ****************************************************************************************************************
    //  private method
    // ****************************************************************************************************************

    /**
     * Gets the root sort builder.
     *
     * @return the root sort builder
     */
    @SuppressWarnings("unchecked")
    protected SortBuilder getRootSortBuilder() {
        return ((AbstractMulitiEntitySqlQueryConditionsGroupExpression3<E1, E2, E3, RS, C, L>) getRoot()).sortBuilder;
    }
}
