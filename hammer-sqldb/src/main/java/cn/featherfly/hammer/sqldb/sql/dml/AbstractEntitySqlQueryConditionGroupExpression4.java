
package cn.featherfly.hammer.sqldb.sql.dml;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.common.function.FourArgusFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.dsl.QueryEntityRepository;
import cn.featherfly.hammer.expression.condition.ParamedExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression4;
import cn.featherfly.hammer.expression.entity.condition.co.ContainsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpression4;
import cn.featherfly.hammer.expression.entity.condition.eq.EntityEqualsExpression4;
import cn.featherfly.hammer.expression.entity.condition.eq.EqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.EndWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.EntityEndWithExpression4;
import cn.featherfly.hammer.expression.entity.condition.ge.EntityGreatEqualsExpression4;
import cn.featherfly.hammer.expression.entity.condition.ge.GreatEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.gt.EntityGreatThanExpression4;
import cn.featherfly.hammer.expression.entity.condition.gt.GreatThanEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.in.EntityInExpression4;
import cn.featherfly.hammer.expression.entity.condition.in.InEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.inn.EntityIsNotNullExpression4;
import cn.featherfly.hammer.expression.entity.condition.inn.IsNotNullEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.isn.EntityIsNullExpression4;
import cn.featherfly.hammer.expression.entity.condition.isn.IsNullEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.le.EntityLessEqualsExpression4;
import cn.featherfly.hammer.expression.entity.condition.le.LessEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.lk.EntityLikeExpression4;
import cn.featherfly.hammer.expression.entity.condition.lk.LikeEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.lt.EntityLessThanExpression4;
import cn.featherfly.hammer.expression.entity.condition.lt.LessThanEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpression4;
import cn.featherfly.hammer.expression.entity.condition.ne.NotEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nin.EntityNotInExpression4;
import cn.featherfly.hammer.expression.entity.condition.nin.NotInEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyFunction;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpression4;
import cn.featherfly.hammer.expression.entity.condition.sw.StartWithEntityExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression4;
import cn.featherfly.hammer.expression.entity.query.sort.SortEntityExpression;
import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * sql condition group expression4. 条件逻辑组构造器4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <RS> the query result type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public abstract class AbstractEntitySqlQueryConditionGroupExpression4<E, E2, E3, E4, RS,
        C extends EntityQueryConditionGroupExpression4<E, E2, E3, E4, C, L,
                EntityQuerySortExpression4<E, E2, E3, E4, RS>, RS>,
        L extends EntityQueryConditionGroupLogicExpression4<E, E2, E3, E4, C, L,
                EntityQuerySortExpression4<E, E2, E3, E4, RS>, RS>>
        extends
        AbstractEntitySqlConditionGroupExpressionBase4<E, E2, E3, E4, EntitySqlQueryRelation, SqlSelectBasicBuilder, C,
                L>
        implements
        EntityQueryConditionGroupExpression4<E, E2, E3, E4, C, L, EntityQuerySortExpression4<E, E2, E3, E4, RS>, RS>,
        EntityQueryConditionGroupLogicExpression4<E, E2, E3, E4, C, L, EntityQuerySortExpression4<E, E2, E3, E4, RS>,
                RS>,
        SqlBuilder, ParamedExpression, EntityContainsExpression4<E, E2, E3, E4, C, L>,
        EntityEndWithExpression4<E, E2, E3, E4, C, L>, EntityEqualsExpression4<E, E2, E3, E4, C, L>,
        EntityGreatEqualsExpression4<E, E2, E3, E4, C, L>, EntityGreatThanExpression4<E, E2, E3, E4, C, L>,
        EntityInExpression4<E, E2, E3, E4, C, L>, EntityIsNotNullExpression4<E, E2, E3, E4, C, L>,
        EntityIsNullExpression4<E, E2, E3, E4, C, L>, EntityLessEqualsExpression4<E, E2, E3, E4, C, L>,
        EntityLessThanExpression4<E, E2, E3, E4, C, L>, EntityNotEqualsExpression4<E, E2, E3, E4, C, L>,
        EntityNotInExpression4<E, E2, E3, E4, C, L>, EntityStartWithExpression4<E, E2, E3, E4, C, L>,
        EntityLikeExpression4<E, E2, E3, E4, C, L>, EntityPropertyExpression4<E, E2, E3, E4, C, L>,
        EntityQuerySortExpression4<E, E2, E3, E4, RS>, EntityQuerySortedExpression4<E, E2, E3, E4, RS> {

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
    protected AbstractEntitySqlQueryConditionGroupExpression4(L parent, JdbcMappingFactory factory,
            SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        super(parent, factory, queryRelation);
        sortBuilder = new SqlSortBuilder(dialect, queryRelation.getEntityRelationMapping(0).getTableAlias());
        this.sqlPageFactory = sqlPageFactory;
        entitySqlQueryConditionGroupQuery = new EntitySqlQueryConditionGroupQuery<>(this, sqlPageFactory,
                entityRelation);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        StringBuilder result = new StringBuilder(super.build());
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

    @Override
    public long count() {
        entityRelation.getBuilder().addColumn(AggregateFunction.COUNT, Chars.STAR);
        return entityRelation.getJdbc().queryLong(getRoot().expression(), getRoot().getParams().toArray());
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(Consumer<Tuple4<ContainsEntityExpression<E>, ContainsEntityExpression<E2>, ContainsEntityExpression<E3>,
            ContainsEntityExpression<E4>>> containsEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(FourArgusConsumer<ContainsEntityExpression<E>, ContainsEntityExpression<E2>,
            ContainsEntityExpression<E3>, ContainsEntityExpression<E4>> containsEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(Consumer<Tuple4<EndWithEntityExpression<E>, EndWithEntityExpression<E2>, EndWithEntityExpression<E3>,
            EndWithEntityExpression<E4>>> endWithEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(FourArgusConsumer<EndWithEntityExpression<E>, EndWithEntityExpression<E2>, EndWithEntityExpression<E3>,
            EndWithEntityExpression<E4>> endWithEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Consumer<Tuple4<EqualsEntityExpression<E>, EqualsEntityExpression<E2>, EqualsEntityExpression<E3>,
            EqualsEntityExpression<E4>>> equalsEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(FourArgusConsumer<EqualsEntityExpression<E>, EqualsEntityExpression<E2>, EqualsEntityExpression<E3>,
            EqualsEntityExpression<E4>> equalsEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(Consumer<Tuple4<GreatEqualsEntityExpression<E>, GreatEqualsEntityExpression<E2>,
            GreatEqualsEntityExpression<E3>, GreatEqualsEntityExpression<E4>>> greatEqualsEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(FourArgusConsumer<GreatEqualsEntityExpression<E>, GreatEqualsEntityExpression<E2>,
            GreatEqualsEntityExpression<E3>, GreatEqualsEntityExpression<E4>> greatEqualsEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(Consumer<Tuple4<GreatThanEntityExpression<E>, GreatThanEntityExpression<E2>,
            GreatThanEntityExpression<E3>, GreatThanEntityExpression<E4>>> greatThanEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(FourArgusConsumer<GreatThanEntityExpression<E>, GreatThanEntityExpression<E2>,
            GreatThanEntityExpression<E3>, GreatThanEntityExpression<E4>> greatThanEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Consumer<Tuple4<InEntityExpression<E>, InEntityExpression<E2>, InEntityExpression<E3>,
            InEntityExpression<E4>>> inEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(FourArgusConsumer<InEntityExpression<E>, InEntityExpression<E2>, InEntityExpression<E3>,
            InEntityExpression<E4>> inEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(Consumer<Tuple4<IsNotNullEntityExpression<E>, IsNotNullEntityExpression<E2>,
            IsNotNullEntityExpression<E3>, IsNotNullEntityExpression<E4>>> isNotNullEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(FourArgusConsumer<IsNotNullEntityExpression<E>, IsNotNullEntityExpression<E2>,
            IsNotNullEntityExpression<E3>, IsNotNullEntityExpression<E4>> isNotNullEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(Consumer<Tuple4<IsNullEntityExpression<E>, IsNullEntityExpression<E2>, IsNullEntityExpression<E3>,
            IsNullEntityExpression<E4>>> isNullEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(FourArgusConsumer<IsNullEntityExpression<E>, IsNullEntityExpression<E2>, IsNullEntityExpression<E3>,
            IsNullEntityExpression<E4>> isNullEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(Consumer<Tuple4<LessEqualsEntityExpression<E>, LessEqualsEntityExpression<E2>,
            LessEqualsEntityExpression<E3>, LessEqualsEntityExpression<E4>>> lessEqualsEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(FourArgusConsumer<LessEqualsEntityExpression<E>, LessEqualsEntityExpression<E2>,
            LessEqualsEntityExpression<E3>, LessEqualsEntityExpression<E4>> lessEqualsEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(Consumer<Tuple4<LessThanEntityExpression<E>, LessThanEntityExpression<E2>, LessThanEntityExpression<E3>,
            LessThanEntityExpression<E4>>> lessThanEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(FourArgusConsumer<LessThanEntityExpression<E>, LessThanEntityExpression<E2>,
            LessThanEntityExpression<E3>, LessThanEntityExpression<E4>> lessThanEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Consumer<Tuple4<NotEqualsEntityExpression<E>, NotEqualsEntityExpression<E2>,
            NotEqualsEntityExpression<E3>, NotEqualsEntityExpression<E4>>> notEqualsEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(FourArgusConsumer<NotEqualsEntityExpression<E>, NotEqualsEntityExpression<E2>,
            NotEqualsEntityExpression<E3>, NotEqualsEntityExpression<E4>> notEqualsEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(Consumer<Tuple4<NotInEntityExpression<E>, NotInEntityExpression<E2>, NotInEntityExpression<E3>,
            NotInEntityExpression<E4>>> notInEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(FourArgusConsumer<NotInEntityExpression<E>, NotInEntityExpression<E2>, NotInEntityExpression<E3>,
            NotInEntityExpression<E4>> notInEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(Consumer<Tuple4<StartWithEntityExpression<E>, StartWithEntityExpression<E2>,
            StartWithEntityExpression<E3>, StartWithEntityExpression<E4>>> startWithEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(FourArgusConsumer<StartWithEntityExpression<E>, StartWithEntityExpression<E2>,
            StartWithEntityExpression<E3>, StartWithEntityExpression<E4>> startWithEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(Consumer<Tuple4<LikeEntityExpression<E>, LikeEntityExpression<E2>, LikeEntityExpression<E3>,
            LikeEntityExpression<E4>>> likeEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(FourArgusConsumer<LikeEntityExpression<E>, LikeEntityExpression<E2>, LikeEntityExpression<E3>,
            LikeEntityExpression<E4>> likeEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L property(FourArgusFunction<EntityPropertyFunction<E, C, L>, EntityPropertyFunction<E2, C, L>,
            EntityPropertyFunction<E3, C, L>, EntityPropertyFunction<E4, C, L>, L> entitiesPropertyFunction) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    // ****************************************************************************************************************
    //	sort
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression4<E, E2, E3, E4, RS> sort() {
        return this;
    }

    //        /**
    //         * {@inheritDoc}
    //         */
    /**
     * Asc.
     *
     * @param names the names
     * @return the entity query sorted expression
     */
    //        @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(String... names) {
        getRootSortBuilder().asc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    //        /**
    //         * {@inheritDoc}
    //         */
    /**
     * Asc.
     *
     * @param names the names
     * @return the entity query sorted expression
     */
    //        @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(List<String> names) {
        // YUFEI_TODO asc desc 需要和强类型绑定
        getRootSortBuilder().asc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <P> EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(SerializableFunction<E, P> name) {
        // YUFEI_TODO asc desc 需要和强类型绑定
        return asc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(
            @SuppressWarnings("unchecked") SerializableFunction<E, ?>... names) {
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
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(String... names) {
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
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(List<String> names) {
        getRootSortBuilder().desc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <P> EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(SerializableFunction<E, P> name) {
        return desc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(
            @SuppressWarnings("unchecked") SerializableFunction<E, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return desc(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(FourArgusConsumer<SortEntityExpression<E>,
            SortEntityExpression<E2>, SortEntityExpression<E3>, SortEntityExpression<E4>> sortEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(FourArgusConsumer<SortEntityExpression<E>,
            SortEntityExpression<E2>, SortEntityExpression<E3>, SortEntityExpression<E4>> sortEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(
            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>>, QueryEntityRepository<E>> entities,
            SerializableFunction<E, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(
            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>>, QueryEntityRepository<E>> entities,
            SerializableFunction<E, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(
            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>>, QueryEntityRepository<E2>> entities,
            SerializableFunction1<E2, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(
            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>>, QueryEntityRepository<E2>> entities,
            SerializableFunction1<E2, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(
            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>>, QueryEntityRepository<E3>> entities,
            SerializableFunction2<E3, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(
            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>>, QueryEntityRepository<E3>> entities,
            SerializableFunction2<E3, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(
            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>>, QueryEntityRepository<E4>> entities,
            SerializableFunction3<E4, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(
            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>>, QueryEntityRepository<E4>> entities,
            SerializableFunction3<E4, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(
            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>>, QueryEntityRepository<E>> entities,
            SerializableFunction<E, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(
            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>>, QueryEntityRepository<E>> entities,
            SerializableFunction<E, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(
            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>>, QueryEntityRepository<E2>> entities,
            SerializableFunction1<E2, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(
            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>>, QueryEntityRepository<E2>> entities,
            SerializableFunction1<E2, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(
            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>>, QueryEntityRepository<E3>> entities,
            SerializableFunction2<E3, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(
            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>>, QueryEntityRepository<E3>> entities,
            SerializableFunction2<E3, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(
            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>>, QueryEntityRepository<E4>> entities,
            SerializableFunction3<E4, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(
            Function<Tuple4<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>>, QueryEntityRepository<E4>> entities,
            SerializableFunction3<E4, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc4(SerializableFunction<E4, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc4(SerializableFunction<E4, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc4(SerializableFunction<E4, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc4(SerializableFunction<E4, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc3(SerializableFunction<E3, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc3(SerializableFunction<E3, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc3(SerializableFunction<E3, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc3(SerializableFunction<E3, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc2(SerializableFunction<E2, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc2(SerializableFunction<E2, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc2(SerializableFunction<E2, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc2(SerializableFunction<E2, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    // ****************************************************************************************************************
    //  private method
    // ****************************************************************************************************************

    @SuppressWarnings("unchecked")
    private SortBuilder getRootSortBuilder() {
        return ((AbstractEntitySqlQueryConditionGroupExpression4<E, E2, E3, E4, RS, C, L>) getRoot()).sortBuilder;
    }
}
