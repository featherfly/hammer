
package cn.featherfly.hammer.sqldb.sql.dml;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.dsl.QueryEntityRepository;
import cn.featherfly.hammer.expression.condition.ParamedExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.co.ContainsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.co.ContainsEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpression2;
import cn.featherfly.hammer.expression.entity.condition.co.MulitiEntityContainsExpression;
import cn.featherfly.hammer.expression.entity.condition.eq.EntityEqualsExpression2;
import cn.featherfly.hammer.expression.entity.condition.eq.EqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.EndWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.EntityEndWithExpression2;
import cn.featherfly.hammer.expression.entity.condition.ge.EntityGreatEqualsExpression2;
import cn.featherfly.hammer.expression.entity.condition.ge.GreatEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.gt.EntityGreatThanExpression2;
import cn.featherfly.hammer.expression.entity.condition.gt.GreatThanEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.in.EntityInExpression2;
import cn.featherfly.hammer.expression.entity.condition.in.InEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.inn.EntityIsNotNullExpression2;
import cn.featherfly.hammer.expression.entity.condition.inn.IsNotNullEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.isn.EntityIsNullExpression2;
import cn.featherfly.hammer.expression.entity.condition.isn.IsNullEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.le.EntityLessEqualsExpression2;
import cn.featherfly.hammer.expression.entity.condition.le.LessEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.lk.EntityLikeExpression2;
import cn.featherfly.hammer.expression.entity.condition.lk.LikeEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.lt.EntityLessThanExpression2;
import cn.featherfly.hammer.expression.entity.condition.lt.LessThanEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpression2;
import cn.featherfly.hammer.expression.entity.condition.ne.NotEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nin.EntityNotInExpression2;
import cn.featherfly.hammer.expression.entity.condition.nin.NotInEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyFunction;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpression2;
import cn.featherfly.hammer.expression.entity.condition.sw.MulitiEntityStartWithExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.StartWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.StartWithEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression2;
import cn.featherfly.hammer.expression.entity.query.sort.SortEntityExpression;
import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityContainsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityStartWithExpressionImpl;

/**
 * sql condition group expression2. 条件逻辑组构造器2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <RS> the query result type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public abstract class AbstractEntitySqlQueryConditionGroupExpression2<E, E2, RS,
        C extends EntityQueryConditionGroupExpression2<E, E2, C, L, EntityQuerySortExpression2<E, E2, RS>, RS>,
        L extends EntityQueryConditionGroupLogicExpression2<E, E2, C, L, EntityQuerySortExpression2<E, E2, RS>, RS>>
        extends
        AbstractEntitySqlConditionGroupExpressionBase2<E, E2, EntitySqlQueryRelation, SqlSelectBasicBuilder, C, L>
        implements EntityQueryConditionGroupExpression2<E, E2, C, L, EntityQuerySortExpression2<E, E2, RS>, RS>,
        EntityQueryConditionGroupLogicExpression2<E, E2, C, L, EntityQuerySortExpression2<E, E2, RS>, RS>, SqlBuilder,
        ParamedExpression, EntityContainsExpression2<E, E2, C, L>, EntityEndWithExpression2<E, E2, C, L>,
        EntityEqualsExpression2<E, E2, C, L>, EntityGreatEqualsExpression2<E, E2, C, L>,
        EntityGreatThanExpression2<E, E2, C, L>, EntityInExpression2<E, E2, C, L>,
        EntityIsNotNullExpression2<E, E2, C, L>, EntityIsNullExpression2<E, E2, C, L>,
        EntityLessEqualsExpression2<E, E2, C, L>, EntityLessThanExpression2<E, E2, C, L>,
        EntityNotEqualsExpression2<E, E2, C, L>, EntityNotInExpression2<E, E2, C, L>,
        EntityStartWithExpression2<E, E2, C, L>, EntityLikeExpression2<E, E2, C, L>,
        EntityPropertyExpression2<E, E2, C, L>, EntityQuerySortExpression2<E, E2, RS>,
        EntityQuerySortedExpression2<E, E2, RS> {

    private SqlSortBuilder sortBuilder;

    /** The sql page factory. */
    protected SqlPageFactory sqlPageFactory;

    private EntitySqlQueryConditionGroupQuery<RS> entitySqlQueryConditionGroupQuery;

    /**
     * Instantiates a new abstract entity sql condition group expression 2.
     *
     * @param parent         the parent
     * @param factory        the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation  the query relation
     */
    protected AbstractEntitySqlQueryConditionGroupExpression2(L parent, JdbcMappingFactory factory,
            SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        super(parent, factory, queryRelation);
        sortBuilder = new SqlSortBuilder(dialect, queryRelation.getEntityRelationMapping(0).getTableAlias());
        this.sqlPageFactory = sqlPageFactory;
        entitySqlQueryConditionGroupQuery = new EntitySqlQueryConditionGroupQuery<>(this, sqlPageFactory,
                entityRelation);
    }

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

    @Override
    public long count() {
        entityRelation.getBuilder().addColumn(AggregateFunction.COUNT, Chars.STAR);
        return entityRelation.getJdbc().queryLong(getRoot().expression(), getRoot().getParams().toArray());
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

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L co(Consumer<Tuple2<ContainsEntityExpression<E>, ContainsEntityExpression<E2>>> containsEntityExpressions) {
        MulitiEntityContainsExpression<C,
                L> mulitiEntityContainsExpression = new MulitiEntityContainsExpressionImpl<>(this);
        containsEntityExpressions
                .accept(Tuples.of(new ContainsEntityExpressionImpl<E, C, L>(0, mulitiEntityContainsExpression),
                        new ContainsEntityExpressionImpl<E2, C, L>(1, mulitiEntityContainsExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L co(BiConsumer<ContainsEntityExpression<E>, ContainsEntityExpression<E2>> containsEntityExpressions) {
        MulitiEntityContainsExpression<C,
                L> mulitiEntityContainsExpression = new MulitiEntityContainsExpressionImpl<>(this);
        containsEntityExpressions.accept(new ContainsEntityExpressionImpl<E, C, L>(0, mulitiEntityContainsExpression),
                new ContainsEntityExpressionImpl<E2, C, L>(1, mulitiEntityContainsExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(Consumer<Tuple2<EndWithEntityExpression<E>, EndWithEntityExpression<E2>>> endWithEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(BiConsumer<EndWithEntityExpression<E>, EndWithEntityExpression<E2>> endWithEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Consumer<Tuple2<EqualsEntityExpression<E>, EqualsEntityExpression<E2>>> equalsEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(BiConsumer<EqualsEntityExpression<E>, EqualsEntityExpression<E2>> equalsEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(Consumer<
            Tuple2<GreatEqualsEntityExpression<E>, GreatEqualsEntityExpression<E2>>> greatEqualsEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(
            BiConsumer<GreatEqualsEntityExpression<E>, GreatEqualsEntityExpression<E2>> greatEqualsEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(
            Consumer<Tuple2<GreatThanEntityExpression<E>, GreatThanEntityExpression<E2>>> greatThanEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(BiConsumer<GreatThanEntityExpression<E>, GreatThanEntityExpression<E2>> greatThanEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Consumer<Tuple2<InEntityExpression<E>, InEntityExpression<E2>>> inEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(BiConsumer<InEntityExpression<E>, InEntityExpression<E2>> inEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(
            Consumer<Tuple2<IsNotNullEntityExpression<E>, IsNotNullEntityExpression<E2>>> isNotNullEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(BiConsumer<IsNotNullEntityExpression<E>, IsNotNullEntityExpression<E2>> isNotNullEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(Consumer<Tuple2<IsNullEntityExpression<E>, IsNullEntityExpression<E2>>> isNullEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(BiConsumer<IsNullEntityExpression<E>, IsNullEntityExpression<E2>> isNullEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(Consumer<
            Tuple2<LessEqualsEntityExpression<E>, LessEqualsEntityExpression<E2>>> lessEqualsEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(BiConsumer<LessEqualsEntityExpression<E>, LessEqualsEntityExpression<E2>> lessEqualsEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(Consumer<Tuple2<LessThanEntityExpression<E>, LessThanEntityExpression<E2>>> lessThanEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(BiConsumer<LessThanEntityExpression<E>, LessThanEntityExpression<E2>> lessThanEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(
            Consumer<Tuple2<NotEqualsEntityExpression<E>, NotEqualsEntityExpression<E2>>> notEqualsEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(BiConsumer<NotEqualsEntityExpression<E>, NotEqualsEntityExpression<E2>> notEqualsEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(Consumer<Tuple2<NotInEntityExpression<E>, NotInEntityExpression<E2>>> notInEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nin(BiConsumer<NotInEntityExpression<E>, NotInEntityExpression<E2>> notInEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L sw(
            Consumer<Tuple2<StartWithEntityExpression<E>, StartWithEntityExpression<E2>>> startWithEntityExpressions) {
        MulitiEntityStartWithExpression<C, L> expression = new MulitiEntityStartWithExpressionImpl<>(this);
        startWithEntityExpressions.accept(Tuples.of(new StartWithEntityExpressionImpl<E, C, L>(0, expression),
                new StartWithEntityExpressionImpl<E2, C, L>(1, expression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L sw(BiConsumer<StartWithEntityExpression<E>, StartWithEntityExpression<E2>> startWithEntityExpressions) {
        MulitiEntityStartWithExpression<C, L> expression = new MulitiEntityStartWithExpressionImpl<>(this);
        startWithEntityExpressions.accept(new StartWithEntityExpressionImpl<E, C, L>(0, expression),
                new StartWithEntityExpressionImpl<E2, C, L>(1, expression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(Consumer<Tuple2<LikeEntityExpression<E>, LikeEntityExpression<E2>>> likeEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(BiConsumer<LikeEntityExpression<E>, LikeEntityExpression<E2>> likeEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L property(
            BiFunction<EntityPropertyFunction<E, C, L>, EntityPropertyFunction<E2, C, L>, L> entitiesPropertyFunction) {
        // IMPLSOON 后续来实现
        return null;
    }

    // ****************************************************************************************************************
    //	sort
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression2<E, E2, RS> sort() {
        return this;
    }

    /**
     * Asc.
     *
     * @param names the names
     * @return the entity query sorted expression
     */
    //        @Override
    public EntityQuerySortedExpression2<E, E2, RS> asc(String... names) {
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
    public EntityQuerySortedExpression2<E, E2, RS> asc(List<String> names) {
        getRootSortBuilder().asc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <P> EntityQuerySortedExpression2<E, E2, RS> asc(SerializableFunction<E, P> name) {
        return asc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression2<E, E2, RS> asc(
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
    public EntityQuerySortedExpression2<E, E2, RS> desc(String... names) {
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
    public EntityQuerySortedExpression2<E, E2, RS> desc(List<String> names) {
        getRootSortBuilder().desc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <P> EntityQuerySortedExpression2<E, E2, RS> desc(SerializableFunction<E, P> name) {
        return desc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression2<E, E2, RS> desc(
            @SuppressWarnings("unchecked") SerializableFunction<E, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return desc(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression2<E, E2, RS> asc(
            BiConsumer<SortEntityExpression<E>, SortEntityExpression<E2>> sortEntityExpressions) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression2<E, E2, RS> desc(
            BiConsumer<SortEntityExpression<E>, SortEntityExpression<E2>> sortEntityExpressions) {
        // IMPLSOON 后续来实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression2<E, E2, RS> asc(
            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
            SerializableFunction1<E, R> name) {
        int index = entities.apply(Tuples.of(new QueryEntityRepository<>(0, classMapping.getType()),
                new QueryEntityRepository<>(1, classMapping2.getType()))).getIndex();
        if (index == 0) {
            return asc(name);
        }
        throw new SqldbHammerException("调试错误");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression2<E, E2, RS> asc(
            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
            @SuppressWarnings("unchecked") SerializableFunction1<E, ?>... names) {
        int index = entities.apply(Tuples.of(new QueryEntityRepository<>(0, classMapping.getType()),
                new QueryEntityRepository<>(1, classMapping2.getType()))).getIndex();
        if (index == 1) {
            return asc(names);
        }
        throw new SqldbHammerException("调试错误");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression2<E, E2, RS> asc(
            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
            SerializableFunction2<E2, R> name) {
        int index = entities.apply(Tuples.of(new QueryEntityRepository<>(0, classMapping.getType()),
                new QueryEntityRepository<>(1, classMapping2.getType()))).getIndex();
        if (index == 1) {
            return asc2(name);
        }
        throw new SqldbHammerException("调试错误");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression2<E, E2, RS> asc(
            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
            @SuppressWarnings("unchecked") SerializableFunction2<E2, ?>... names) {
        int index = entities.apply(Tuples.of(new QueryEntityRepository<>(0, classMapping.getType()),
                new QueryEntityRepository<>(1, classMapping2.getType()))).getIndex();
        if (index == 1) {
            return asc2(names);
        }
        throw new SqldbHammerException("调试错误");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression2<E, E2, RS> desc(
            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
            SerializableFunction1<E, R> name) {
        int index = entities.apply(Tuples.of(new QueryEntityRepository<>(0, classMapping.getType()),
                new QueryEntityRepository<>(1, classMapping2.getType()))).getIndex();
        if (index == 0) {
            return desc(name);
        }
        throw new SqldbHammerException("调试错误");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression2<E, E2, RS> desc(
            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
            @SuppressWarnings("unchecked") SerializableFunction1<E, ?>... names) {
        int index = entities.apply(Tuples.of(new QueryEntityRepository<>(0, classMapping.getType()),
                new QueryEntityRepository<>(1, classMapping2.getType()))).getIndex();
        if (index == 0) {
            return desc(names);
        }
        throw new SqldbHammerException("调试错误");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression2<E, E2, RS> desc(
            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
            SerializableFunction2<E2, R> name) {
        int index = entities.apply(Tuples.of(new QueryEntityRepository<>(0, classMapping.getType()),
                new QueryEntityRepository<>(1, classMapping2.getType()))).getIndex();
        if (index == 1) {
            return desc2(name);
        }
        throw new SqldbHammerException("调试错误");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression2<E, E2, RS> desc(
            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
            @SuppressWarnings("unchecked") SerializableFunction2<E2, ?>... names) {
        int index = entities.apply(Tuples.of(new QueryEntityRepository<>(0, classMapping.getType()),
                new QueryEntityRepository<>(1, classMapping2.getType()))).getIndex();
        if (index == 1) {
            return desc2(names);
        }
        throw new SqldbHammerException("调试错误");
    }

    public <R> EntityQuerySortedExpression2<E, E2, RS> asc2(String name) {
        getRootSortBuilder().asc(getCurrentQueryAlias(), () -> name);
        return this;
    }

    public EntityQuerySortedExpression2<E, E2, RS> asc2(String... names) {
        for (String name : names) {
            asc2(name);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression2<E, E2, RS> asc2(SerializableFunction<E2, R> name) {
        return asc2(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression2<E, E2, RS> asc2(
            @SuppressWarnings("unchecked") SerializableFunction<E2, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return asc2(nameArray);
    }

    public <R> EntityQuerySortedExpression2<E, E2, RS> desc2(String name) {
        getRootSortBuilder().desc(getCurrentQueryAlias(), () -> name);
        return this;
    }

    public EntityQuerySortedExpression2<E, E2, RS> desc2(String... names) {
        for (String name : names) {
            asc2(name);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression2<E, E2, RS> desc2(SerializableFunction<E2, R> name) {
        return desc2(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression2<E, E2, RS> desc2(
            @SuppressWarnings("unchecked") SerializableFunction<E2, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return desc2(nameArray);
    }

    // ****************************************************************************************************************
    //  private method
    // ****************************************************************************************************************

    @SuppressWarnings("unchecked")
    private SortBuilder getRootSortBuilder() {
        return ((AbstractEntitySqlQueryConditionGroupExpression2<E, E2, RS, C, L>) getRoot()).sortBuilder;
    }
}
