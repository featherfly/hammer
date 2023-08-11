
package cn.featherfly.hammer.sqldb.sql.dml;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.function.ThreeArgusFunction;
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
import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression3;
import cn.featherfly.hammer.expression.entity.condition.co.ContainsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.co.ContainsEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpression3;
import cn.featherfly.hammer.expression.entity.condition.co.MulitiEntityContainsExpression;
import cn.featherfly.hammer.expression.entity.condition.eq.EntityEqualsExpression3;
import cn.featherfly.hammer.expression.entity.condition.eq.EqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.eq.EqualsEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.eq.MulitiEntityEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.EndWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.EndWithEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.ew.EntityEndWithExpression3;
import cn.featherfly.hammer.expression.entity.condition.ew.MulitiEntityEndWithExpression;
import cn.featherfly.hammer.expression.entity.condition.ge.EntityGreatEqualsExpression3;
import cn.featherfly.hammer.expression.entity.condition.ge.GreatEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ge.GreatEqualsEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.ge.MulitiEntityGreatEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.gt.EntityGreatThanExpression3;
import cn.featherfly.hammer.expression.entity.condition.gt.GreatThanEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.gt.GreatThanEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.gt.MulitiEntityGreatThanExpression;
import cn.featherfly.hammer.expression.entity.condition.in.EntityInExpression3;
import cn.featherfly.hammer.expression.entity.condition.in.InEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.in.InEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.in.MulitiEntityInExpression;
import cn.featherfly.hammer.expression.entity.condition.inn.EntityIsNotNullExpression3;
import cn.featherfly.hammer.expression.entity.condition.inn.IsNotNullEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.inn.IsNotNullEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.inn.MulitiEntityIsNotNullExpression;
import cn.featherfly.hammer.expression.entity.condition.isn.EntityIsNullExpression3;
import cn.featherfly.hammer.expression.entity.condition.isn.IsNullEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.isn.IsNullEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.isn.MulitiEntityIsNullExpression;
import cn.featherfly.hammer.expression.entity.condition.le.EntityLessEqualsExpression3;
import cn.featherfly.hammer.expression.entity.condition.le.LessEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.le.LessEqualsEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.le.MulitiEntityLessEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.lk.EntityLikeExpression3;
import cn.featherfly.hammer.expression.entity.condition.lk.LikeEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.lk.LikeEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.lk.MulitiEntityLikeExpression;
import cn.featherfly.hammer.expression.entity.condition.lt.EntityLessThanExpression3;
import cn.featherfly.hammer.expression.entity.condition.lt.LessThanEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.lt.LessThanEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.lt.MulitiEntityLessThanExpression;
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpression3;
import cn.featherfly.hammer.expression.entity.condition.ne.MulitiEntityNotEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.ne.NotEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ne.NotEqualsEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.nin.EntityNotInExpression3;
import cn.featherfly.hammer.expression.entity.condition.nin.MulitiEntityNotInExpression;
import cn.featherfly.hammer.expression.entity.condition.nin.NotInEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nin.NotInEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyFunction;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpression3;
import cn.featherfly.hammer.expression.entity.condition.sw.MulitiEntityStartWithExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.StartWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.StartWithEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryLimitExecutor;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression3;
import cn.featherfly.hammer.expression.entity.query.sort.SortEntityExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityContainsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityEndWithExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityEqualsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityGreatEqualsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityGreatThanExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityInExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityIsNotNullExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityIsNullExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityLessEqualsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityLessThanExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityLikeExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityNotEqualsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityNotInExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityStartWithExpressionImpl;

/**
 * sql condition group expression3. 条件逻辑组构造器3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <RS> the query result type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public abstract class AbstractEntitySqlQueryConditionGroupExpression3<E, E2, E3, RS,
        C extends EntityQueryConditionGroupExpression3<E, E2, E3, C, L, EntityQuerySortExpression3<E, E2, E3, RS>, RS>,
        L extends EntityQueryConditionGroupLogicExpression3<E, E2, E3, C, L, EntityQuerySortExpression3<E, E2, E3, RS>,
                RS>>
        extends
        AbstractEntitySqlConditionGroupExpressionBase3<E, E2, E3, EntitySqlQueryRelation, SqlSelectBasicBuilder, C, L>
        implements EntityQueryConditionGroupExpression3<E, E2, E3, C, L, EntityQuerySortExpression3<E, E2, E3, RS>, RS>,
        EntityQueryConditionGroupLogicExpression3<E, E2, E3, C, L, EntityQuerySortExpression3<E, E2, E3, RS>, RS>,
        SqlBuilder, ParamedExpression, EntityContainsExpression3<E, E2, E3, C, L>,
        EntityEndWithExpression3<E, E2, E3, C, L>, EntityEqualsExpression3<E, E2, E3, C, L>,
        EntityGreatEqualsExpression3<E, E2, E3, C, L>, EntityGreatThanExpression3<E, E2, E3, C, L>,
        EntityInExpression3<E, E2, E3, C, L>, EntityIsNotNullExpression3<E, E2, E3, C, L>,
        EntityIsNullExpression3<E, E2, E3, C, L>, EntityLessEqualsExpression3<E, E2, E3, C, L>,
        EntityLessThanExpression3<E, E2, E3, C, L>, EntityNotEqualsExpression3<E, E2, E3, C, L>,
        EntityNotInExpression3<E, E2, E3, C, L>, EntityStartWithExpression3<E, E2, E3, C, L>,
        EntityLikeExpression3<E, E2, E3, C, L>, EntityPropertyExpression3<E, E2, E3, C, L>,
        EntityQuerySortExpression3<E, E2, E3, RS>, EntityQuerySortedExpression3<E, E2, E3, RS> {

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
    protected AbstractEntitySqlQueryConditionGroupExpression3(L parent, JdbcMappingFactory factory,
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

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L co(Consumer<Tuple3<ContainsEntityExpression<E>, ContainsEntityExpression<E2>,
            ContainsEntityExpression<E3>>> containsEntityExpressions) {
        MulitiEntityContainsExpression<C,
                L> mulitiEntityContainsExpression = new MulitiEntityContainsExpressionImpl<>(this);
        containsEntityExpressions
                .accept(Tuples.of(new ContainsEntityExpressionImpl<E, C, L>(0, mulitiEntityContainsExpression),
                        new ContainsEntityExpressionImpl<E2, C, L>(1, mulitiEntityContainsExpression),
                        new ContainsEntityExpressionImpl<E3, C, L>(2, mulitiEntityContainsExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L co(ThreeArgusConsumer<ContainsEntityExpression<E>, ContainsEntityExpression<E2>,
            ContainsEntityExpression<E3>> containsEntityExpressions) {
        MulitiEntityContainsExpression<C,
                L> mulitiEntityContainsExpression = new MulitiEntityContainsExpressionImpl<>(this);
        containsEntityExpressions.accept(new ContainsEntityExpressionImpl<E, C, L>(0, mulitiEntityContainsExpression),
                new ContainsEntityExpressionImpl<E2, C, L>(1, mulitiEntityContainsExpression),
                new ContainsEntityExpressionImpl<E3, C, L>(2, mulitiEntityContainsExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ew(Consumer<Tuple3<EndWithEntityExpression<E>, EndWithEntityExpression<E2>,
            EndWithEntityExpression<E3>>> endWithEntityExpressions) {
        MulitiEntityEndWithExpression<C, L> mulitiExpression = new MulitiEntityEndWithExpressionImpl<>(this);
        endWithEntityExpressions.accept(Tuples.of(new EndWithEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new EndWithEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new EndWithEntityExpressionImpl<E3, C, L>(2, mulitiExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ew(ThreeArgusConsumer<EndWithEntityExpression<E>, EndWithEntityExpression<E2>,
            EndWithEntityExpression<E3>> endWithEntityExpressions) {
        MulitiEntityEndWithExpression<C, L> mulitiExpression = new MulitiEntityEndWithExpressionImpl<>(this);
        endWithEntityExpressions.accept(new EndWithEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new EndWithEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new EndWithEntityExpressionImpl<E3, C, L>(2, mulitiExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L eq(Consumer<Tuple3<EqualsEntityExpression<E>, EqualsEntityExpression<E2>,
            EqualsEntityExpression<E3>>> equalsEntityExpressions) {
        MulitiEntityEqualsExpression<C, L> mulitiExpression = new MulitiEntityEqualsExpressionImpl<>(this);
        equalsEntityExpressions.accept(Tuples.of(new EqualsEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new EqualsEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new EqualsEntityExpressionImpl<E3, C, L>(2, mulitiExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L eq(ThreeArgusConsumer<EqualsEntityExpression<E>, EqualsEntityExpression<E2>,
            EqualsEntityExpression<E3>> equalsEntityExpressions) {
        MulitiEntityEqualsExpression<C, L> mulitiExpression = new MulitiEntityEqualsExpressionImpl<>(this);
        equalsEntityExpressions.accept(new EqualsEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new EqualsEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new EqualsEntityExpressionImpl<E3, C, L>(2, mulitiExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ge(Consumer<Tuple3<GreatEqualsEntityExpression<E>, GreatEqualsEntityExpression<E2>,
            GreatEqualsEntityExpression<E3>>> greatEqualsEntityExpressions) {
        MulitiEntityGreatEqualsExpression<C, L> mulitiExpression = new MulitiEntityGreatEqualsExpressionImpl<>(this);
        greatEqualsEntityExpressions.accept(Tuples.of(new GreatEqualsEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new GreatEqualsEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new GreatEqualsEntityExpressionImpl<E3, C, L>(2, mulitiExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ge(ThreeArgusConsumer<GreatEqualsEntityExpression<E>, GreatEqualsEntityExpression<E2>,
            GreatEqualsEntityExpression<E3>> greatEqualsEntityExpressions) {
        MulitiEntityGreatEqualsExpression<C, L> mulitiExpression = new MulitiEntityGreatEqualsExpressionImpl<>(this);
        greatEqualsEntityExpressions.accept(new GreatEqualsEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new GreatEqualsEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new GreatEqualsEntityExpressionImpl<E3, C, L>(2, mulitiExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L gt(Consumer<Tuple3<GreatThanEntityExpression<E>, GreatThanEntityExpression<E2>,
            GreatThanEntityExpression<E3>>> greatThanEntityExpressions) {
        MulitiEntityGreatThanExpression<C, L> mulitiExpression = new MulitiEntityGreatThanExpressionImpl<>(this);
        greatThanEntityExpressions.accept(Tuples.of(new GreatThanEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new GreatThanEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new GreatThanEntityExpressionImpl<E3, C, L>(2, mulitiExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L gt(ThreeArgusConsumer<GreatThanEntityExpression<E>, GreatThanEntityExpression<E2>,
            GreatThanEntityExpression<E3>> greatThanEntityExpressions) {
        MulitiEntityGreatThanExpression<C, L> mulitiExpression = new MulitiEntityGreatThanExpressionImpl<>(this);
        greatThanEntityExpressions.accept(new GreatThanEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new GreatThanEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new GreatThanEntityExpressionImpl<E3, C, L>(2, mulitiExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L in(Consumer<
            Tuple3<InEntityExpression<E>, InEntityExpression<E2>, InEntityExpression<E3>>> inEntityExpressions) {
        MulitiEntityInExpression<C, L> mulitiExpression = new MulitiEntityInExpressionImpl<>(this);
        inEntityExpressions.accept(Tuples.of(new InEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new InEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new InEntityExpressionImpl<E3, C, L>(2, mulitiExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L in(ThreeArgusConsumer<InEntityExpression<E>, InEntityExpression<E2>,
            InEntityExpression<E3>> inEntityExpressions) {
        MulitiEntityInExpression<C, L> mulitiExpression = new MulitiEntityInExpressionImpl<>(this);
        inEntityExpressions.accept(new InEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new InEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new InEntityExpressionImpl<E3, C, L>(2, mulitiExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L inn(Consumer<Tuple3<IsNotNullEntityExpression<E>, IsNotNullEntityExpression<E2>,
            IsNotNullEntityExpression<E3>>> isNotNullEntityExpressions) {
        MulitiEntityIsNotNullExpression<C, L> mulitiExpression = new MulitiEntityIsNotNullExpressionImpl<>(this);
        isNotNullEntityExpressions.accept(Tuples.of(new IsNotNullEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new IsNotNullEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new IsNotNullEntityExpressionImpl<E3, C, L>(2, mulitiExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L inn(ThreeArgusConsumer<IsNotNullEntityExpression<E>, IsNotNullEntityExpression<E2>,
            IsNotNullEntityExpression<E3>> isNotNullEntityExpressions) {
        MulitiEntityIsNotNullExpression<C, L> mulitiExpression = new MulitiEntityIsNotNullExpressionImpl<>(this);
        isNotNullEntityExpressions.accept(new IsNotNullEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new IsNotNullEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new IsNotNullEntityExpressionImpl<E3, C, L>(2, mulitiExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L isn(Consumer<Tuple3<IsNullEntityExpression<E>, IsNullEntityExpression<E2>,
            IsNullEntityExpression<E3>>> isNullEntityExpressions) {
        MulitiEntityIsNullExpression<C, L> mulitiExpression = new MulitiEntityIsNullExpressionImpl<>(this);
        isNullEntityExpressions.accept(Tuples.of(new IsNullEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new IsNullEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new IsNullEntityExpressionImpl<E3, C, L>(2, mulitiExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L isn(ThreeArgusConsumer<IsNullEntityExpression<E>, IsNullEntityExpression<E2>,
            IsNullEntityExpression<E3>> isNullEntityExpressions) {
        MulitiEntityIsNullExpression<C, L> mulitiExpression = new MulitiEntityIsNullExpressionImpl<>(this);
        isNullEntityExpressions.accept(new IsNullEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new IsNullEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new IsNullEntityExpressionImpl<E3, C, L>(2, mulitiExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L le(Consumer<Tuple3<LessEqualsEntityExpression<E>, LessEqualsEntityExpression<E2>,
            LessEqualsEntityExpression<E3>>> lessEqualsEntityExpressions) {
        MulitiEntityLessEqualsExpression<C, L> mulitiExpression = new MulitiEntityLessEqualsExpressionImpl<>(this);
        lessEqualsEntityExpressions.accept(Tuples.of(new LessEqualsEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new LessEqualsEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new LessEqualsEntityExpressionImpl<E3, C, L>(2, mulitiExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L le(ThreeArgusConsumer<LessEqualsEntityExpression<E>, LessEqualsEntityExpression<E2>,
            LessEqualsEntityExpression<E3>> lessEqualsEntityExpressions) {
        MulitiEntityLessEqualsExpression<C, L> mulitiExpression = new MulitiEntityLessEqualsExpressionImpl<>(this);
        lessEqualsEntityExpressions.accept(new LessEqualsEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new LessEqualsEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new LessEqualsEntityExpressionImpl<E3, C, L>(2, mulitiExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lt(Consumer<Tuple3<LessThanEntityExpression<E>, LessThanEntityExpression<E2>,
            LessThanEntityExpression<E3>>> lessThanEntityExpressions) {
        MulitiEntityLessThanExpression<C, L> mulitiExpression = new MulitiEntityLessThanExpressionImpl<>(this);
        lessThanEntityExpressions.accept(Tuples.of(new LessThanEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new LessThanEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new LessThanEntityExpressionImpl<E3, C, L>(2, mulitiExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lt(ThreeArgusConsumer<LessThanEntityExpression<E>, LessThanEntityExpression<E2>,
            LessThanEntityExpression<E3>> lessThanEntityExpressions) {
        MulitiEntityLessThanExpression<C, L> mulitiExpression = new MulitiEntityLessThanExpressionImpl<>(this);
        lessThanEntityExpressions.accept(new LessThanEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new LessThanEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new LessThanEntityExpressionImpl<E3, C, L>(2, mulitiExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ne(Consumer<Tuple3<NotEqualsEntityExpression<E>, NotEqualsEntityExpression<E2>,
            NotEqualsEntityExpression<E3>>> notEqualsEntityExpressions) {
        MulitiEntityNotEqualsExpression<C, L> mulitiExpression = new MulitiEntityNotEqualsExpressionImpl<>(this);
        notEqualsEntityExpressions.accept(Tuples.of(new NotEqualsEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new NotEqualsEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new NotEqualsEntityExpressionImpl<E3, C, L>(2, mulitiExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ne(ThreeArgusConsumer<NotEqualsEntityExpression<E>, NotEqualsEntityExpression<E2>,
            NotEqualsEntityExpression<E3>> notEqualsEntityExpressions) {
        MulitiEntityNotEqualsExpression<C, L> mulitiExpression = new MulitiEntityNotEqualsExpressionImpl<>(this);
        notEqualsEntityExpressions.accept(new NotEqualsEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new NotEqualsEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new NotEqualsEntityExpressionImpl<E3, C, L>(2, mulitiExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nin(Consumer<Tuple3<NotInEntityExpression<E>, NotInEntityExpression<E2>,
            NotInEntityExpression<E3>>> notInEntityExpressions) {
        MulitiEntityNotInExpression<C, L> mulitiExpression = new MulitiEntityNotInExpressionImpl<>(this);
        notInEntityExpressions.accept(Tuples.of(new NotInEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new NotInEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new NotInEntityExpressionImpl<E3, C, L>(2, mulitiExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nin(ThreeArgusConsumer<NotInEntityExpression<E>, NotInEntityExpression<E2>,
            NotInEntityExpression<E3>> notInEntityExpressions) {
        MulitiEntityNotInExpression<C, L> mulitiExpression = new MulitiEntityNotInExpressionImpl<>(this);
        notInEntityExpressions.accept(new NotInEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new NotInEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new NotInEntityExpressionImpl<E3, C, L>(2, mulitiExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L sw(Consumer<Tuple3<StartWithEntityExpression<E>, StartWithEntityExpression<E2>,
            StartWithEntityExpression<E3>>> startWithEntityExpressions) {
        MulitiEntityStartWithExpression<C, L> expression = new MulitiEntityStartWithExpressionImpl<>(this);
        startWithEntityExpressions.accept(Tuples.of(new StartWithEntityExpressionImpl<E, C, L>(0, expression),
                new StartWithEntityExpressionImpl<E2, C, L>(1, expression),
                new StartWithEntityExpressionImpl<E3, C, L>(2, expression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L sw(ThreeArgusConsumer<StartWithEntityExpression<E>, StartWithEntityExpression<E2>,
            StartWithEntityExpression<E3>> startWithEntityExpressions) {
        MulitiEntityStartWithExpression<C, L> expression = new MulitiEntityStartWithExpressionImpl<>(this);
        startWithEntityExpressions.accept(new StartWithEntityExpressionImpl<E, C, L>(0, expression),
                new StartWithEntityExpressionImpl<E2, C, L>(1, expression),
                new StartWithEntityExpressionImpl<E3, C, L>(2, expression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lk(Consumer<Tuple3<LikeEntityExpression<E>, LikeEntityExpression<E2>,
            LikeEntityExpression<E3>>> likeEntityExpressions) {
        MulitiEntityLikeExpression<C, L> mulitiExpression = new MulitiEntityLikeExpressionImpl<>(this);
        likeEntityExpressions.accept(Tuples.of(new LikeEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new LikeEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new LikeEntityExpressionImpl<E3, C, L>(2, mulitiExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lk(ThreeArgusConsumer<LikeEntityExpression<E>, LikeEntityExpression<E2>,
            LikeEntityExpression<E3>> likeEntityExpressions) {
        MulitiEntityLikeExpression<C, L> mulitiExpression = new MulitiEntityLikeExpressionImpl<>(this);
        likeEntityExpressions.accept(new LikeEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new LikeEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new LikeEntityExpressionImpl<E3, C, L>(2, mulitiExpression));
        return (L) this;
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L property(ThreeArgusFunction<EntityPropertyFunction<E, C, L>, EntityPropertyFunction<E2, C, L>,
            EntityPropertyFunction<E3, C, L>, L> entitiesPropertyFunction) {
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
    public EntityQuerySortExpression3<E, E2, E3, RS> sort() {
        return this;
    }

    /**
     * Asc.
     *
     * @param names the names
     * @return the entity query sorted expression
     */
    //        @Override
    public EntityQuerySortedExpression3<E, E2, E3, RS> asc(String... names) {
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
    public EntityQuerySortedExpression3<E, E2, E3, RS> asc(List<String> names) {
        // YUFEI_TODO asc desc 需要和强类型绑定
        getRootSortBuilder().asc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <P> EntityQuerySortedExpression3<E, E2, E3, RS> asc(SerializableFunction<E, P> name) {
        // YUFEI_TODO asc desc 需要和强类型绑定
        return asc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E, E2, E3, RS> asc(
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
    public EntityQuerySortedExpression3<E, E2, E3, RS> desc(String... names) {
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
    public EntityQuerySortedExpression3<E, E2, E3, RS> desc(List<String> names) {
        getRootSortBuilder().desc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <P> EntityQuerySortedExpression3<E, E2, E3, RS> desc(SerializableFunction<E, P> name) {
        return desc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E, E2, E3, RS> desc(
            @SuppressWarnings("unchecked") SerializableFunction<E, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return desc(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E, E2, E3, RS> asc(ThreeArgusConsumer<SortEntityExpression<E>,
            SortEntityExpression<E2>, SortEntityExpression<E3>> sortEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E, E2, E3, RS> desc(ThreeArgusConsumer<SortEntityExpression<E>,
            SortEntityExpression<E2>, SortEntityExpression<E3>> sortEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression3<E, E2, E3, RS> asc(
            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
                    QueryEntityRepository<E>> entities,
            SerializableFunction<E, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E, E2, E3, RS> asc(
            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
                    QueryEntityRepository<E>> entities,
            SerializableFunction<E, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression3<E, E2, E3, RS> asc(
            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
                    QueryEntityRepository<E2>> entities,
            SerializableFunction1<E2, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E, E2, E3, RS> asc(
            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
                    QueryEntityRepository<E2>> entities,
            SerializableFunction1<E2, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression3<E, E2, E3, RS> asc(
            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
                    QueryEntityRepository<E3>> entities,
            SerializableFunction2<E3, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E, E2, E3, RS> asc(
            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
                    QueryEntityRepository<E3>> entities,
            SerializableFunction2<E3, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression3<E, E2, E3, RS> desc(
            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
                    QueryEntityRepository<E>> entities,
            SerializableFunction<E, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E, E2, E3, RS> desc(
            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
                    QueryEntityRepository<E>> entities,
            SerializableFunction<E, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression3<E, E2, E3, RS> desc(
            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
                    QueryEntityRepository<E2>> entities,
            SerializableFunction1<E2, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E, E2, E3, RS> desc(
            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
                    QueryEntityRepository<E2>> entities,
            SerializableFunction1<E2, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression3<E, E2, E3, RS> desc(
            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
                    QueryEntityRepository<E3>> entities,
            SerializableFunction2<E3, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E, E2, E3, RS> desc(
            Function<Tuple3<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>>,
                    QueryEntityRepository<E3>> entities,
            SerializableFunction2<E3, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression3<E, E2, E3, RS> asc3(SerializableFunction<E3, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E, E2, E3, RS> asc3(SerializableFunction<E3, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression3<E, E2, E3, RS> desc3(SerializableFunction<E3, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E, E2, E3, RS> desc3(SerializableFunction<E3, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression3<E, E2, E3, RS> asc2(SerializableFunction<E2, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E, E2, E3, RS> asc2(SerializableFunction<E2, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression3<E, E2, E3, RS> desc2(SerializableFunction<E2, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E, E2, E3, RS> desc2(SerializableFunction<E2, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    // ****************************************************************************************************************
    //  private method
    // ****************************************************************************************************************

    @SuppressWarnings("unchecked")
    private SortBuilder getRootSortBuilder() {
        return ((AbstractEntitySqlQueryConditionGroupExpression3<E, E2, E3, RS, C, L>) getRoot()).sortBuilder;
    }
}
