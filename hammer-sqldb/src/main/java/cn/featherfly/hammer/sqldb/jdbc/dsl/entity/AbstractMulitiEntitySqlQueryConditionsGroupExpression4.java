
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple4;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.operator.SortOperator;
import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.condition.ba.MulitiBetweenExpression;
import cn.featherfly.hammer.expression.condition.co.MulitiContainsExpression;
import cn.featherfly.hammer.expression.condition.eq.MulitiEqualsExpression;
import cn.featherfly.hammer.expression.condition.ew.MulitiEndWithExpression;
import cn.featherfly.hammer.expression.condition.ge.MulitiGreatEqualsExpression;
import cn.featherfly.hammer.expression.condition.gt.MulitiGreatThanExpression;
import cn.featherfly.hammer.expression.condition.in.MulitiInExpression;
import cn.featherfly.hammer.expression.condition.inn.MulitiIsNotNullExpression;
import cn.featherfly.hammer.expression.condition.isn.MulitiIsNullExpression;
import cn.featherfly.hammer.expression.condition.le.MulitiLessEqualsExpression;
import cn.featherfly.hammer.expression.condition.lk.MulitiLikeExpression;
import cn.featherfly.hammer.expression.condition.lt.MulitiLessThanExpression;
import cn.featherfly.hammer.expression.condition.nba.MulitiNotBetweenExpression;
import cn.featherfly.hammer.expression.condition.nco.MulitiNotContainsExpression;
import cn.featherfly.hammer.expression.condition.ne.MulitiNotEqualsExpression;
import cn.featherfly.hammer.expression.condition.newv.MulitiNotEndWithExpression;
import cn.featherfly.hammer.expression.condition.ni.MulitiNotInExpression;
import cn.featherfly.hammer.expression.condition.nl.MulitiNotLikeExpression;
import cn.featherfly.hammer.expression.condition.nsw.MulitiNotStartWithExpression;
import cn.featherfly.hammer.expression.condition.sw.MulitiStartWithExpression;
import cn.featherfly.hammer.expression.entity.condition.ba.BetweenEntityExpression;
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
import cn.featherfly.hammer.expression.entity.condition.nba.NotBetweenEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nco.NotContainsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpression4;
import cn.featherfly.hammer.expression.entity.condition.ne.NotEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.newv.NotEndWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ni.EntityNotInExpression4;
import cn.featherfly.hammer.expression.entity.condition.ni.NotInEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nl.NotLikeEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nsw.NotStartWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpression4;
import cn.featherfly.hammer.expression.entity.condition.sw.StartWithEntityExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQueryLimitExecutor;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression4;
import cn.featherfly.hammer.expression.entity.query.sort.EntitySetSortPropertyExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.ba.BetweenEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.ba.MulitiEntityBetweenExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.co.ContainsEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.co.MulitiEntityContainsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.eq.EqualsEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.eq.MulitiEntityEqualsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.ew.EndWithEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.ew.MulitiEntityEndWithExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.ge.GreatEqualsEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.ge.MulitiEntityGreatEqualsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.gt.GreatThanEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.gt.MulitiEntityGreatThanExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.in.InEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.in.MulitiEntityInExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.inn.IsNotNullEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.inn.MulitiEntityIsNotNullExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.isn.IsNullEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.isn.MulitiEntityIsNullExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.le.LessEqualsEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.le.MulitiEntityLessEqualsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.lk.LikeEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.lk.MulitiEntityLikeExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.lt.LessThanEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.lt.MulitiEntityLessThanExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.nba.MulitiEntityNotBetweenExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.nba.NotBetweenEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.nco.MulitiEntityNotContainsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.nco.NotContainsEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.ne.MulitiEntityNotEqualsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.ne.NotEqualsEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.newv.MulitiEntityNotEndWithExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.newv.NotEndWithEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.ni.MulitiEntityNotInExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.ni.NotInEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.nl.MulitiEntityNotLikeExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.nl.NotLikeEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.nsw.MulitiEntityNotStartWithExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.nsw.NotStartWithEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.sw.MulitiEntityStartWithExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.sw.StartWithEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.sort.EntitySetSqlSortPropertyExpression;

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
public abstract class AbstractMulitiEntitySqlQueryConditionsGroupExpression4<E, E2, E3, E4, RS,
    C extends EntityQueryConditionGroupExpression4<E, E2, E3, E4, C, L, EntityQuerySortExpression4<E, E2, E3, E4, RS>,
        RS>,
    L extends EntityQueryConditionGroupLogicExpression4<E, E2, E3, E4, C, L,
        EntityQuerySortExpression4<E, E2, E3, E4, RS>, RS>>
    extends
    AbstractMulitiEntitySqlConditionsGroupExpressionBase4<E, E2, E3, E4, EntitySqlQueryRelation, SqlSelectBasicBuilder,
        C, L, QueryConditionConfig>
    implements
    EntityQueryConditionGroupExpression4<E, E2, E3, E4, C, L, EntityQuerySortExpression4<E, E2, E3, E4, RS>, RS>,
    EntityQueryConditionGroupLogicExpression4<E, E2, E3, E4, C, L, EntityQuerySortExpression4<E, E2, E3, E4, RS>, RS>,
    EntityContainsExpression4<E, E2, E3, E4, C, L>, EntityEndWithExpression4<E, E2, E3, E4, C, L>,
    EntityEqualsExpression4<E, E2, E3, E4, C, L>, EntityGreatEqualsExpression4<E, E2, E3, E4, C, L>,
    EntityGreatThanExpression4<E, E2, E3, E4, C, L>, EntityInExpression4<E, E2, E3, E4, C, L>,
    EntityIsNotNullExpression4<E, E2, E3, E4, C, L>, EntityIsNullExpression4<E, E2, E3, E4, C, L>,
    EntityLessEqualsExpression4<E, E2, E3, E4, C, L>, EntityLessThanExpression4<E, E2, E3, E4, C, L>,
    EntityNotEqualsExpression4<E, E2, E3, E4, C, L>, EntityNotInExpression4<E, E2, E3, E4, C, L>,
    EntityStartWithExpression4<E, E2, E3, E4, C, L>, EntityLikeExpression4<E, E2, E3, E4, C, L>,
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
    protected AbstractMulitiEntitySqlQueryConditionsGroupExpression4(L parent, JdbcMappingFactory factory,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        super(parent, factory, queryRelation);
        sortBuilder = new SqlSortBuilder(dialect, queryRelation.getEntityRelationMapping(0).getTableAlias());
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

    @Override
    public long count() {
        entityRelation.getBuilder().clearColumns().addColumn(AggregateFunction.COUNT, Chars.STAR);
        return entityRelation.getJdbc().queryLong(getRoot().expression(), getRoot().getParams().toArray());
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lk(Consumer<Tuple4<LikeEntityExpression<E>, LikeEntityExpression<E2>, LikeEntityExpression<E3>,
        LikeEntityExpression<E4>>> likeEntityExpressions) {
        MulitiLikeExpression<C, L> mulitiExpression = new MulitiEntityLikeExpressionImpl<>(this);
        likeEntityExpressions
            .accept(Tuples.of(new LikeEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new LikeEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new LikeEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new LikeEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lk(FourArgusConsumer<LikeEntityExpression<E>, LikeEntityExpression<E2>, LikeEntityExpression<E3>,
        LikeEntityExpression<E4>> likeEntityExpressions) {
        MulitiLikeExpression<C, L> mulitiExpression = new MulitiEntityLikeExpressionImpl<>(this);
        likeEntityExpressions.accept(new LikeEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new LikeEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new LikeEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new LikeEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L sw(Consumer<Tuple4<StartWithEntityExpression<E>, StartWithEntityExpression<E2>,
        StartWithEntityExpression<E3>, StartWithEntityExpression<E4>>> startWithEntityExpressions) {
        MulitiStartWithExpression<C, L> expression = new MulitiEntityStartWithExpressionImpl<>(this);
        startWithEntityExpressions
            .accept(Tuples.of(new StartWithEntityExpressionImpl<>(0, expression, factory, entityRelation),
                new StartWithEntityExpressionImpl<>(1, expression, factory, entityRelation),
                new StartWithEntityExpressionImpl<>(2, expression, factory, entityRelation),
                new StartWithEntityExpressionImpl<>(3, expression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L sw(FourArgusConsumer<StartWithEntityExpression<E>, StartWithEntityExpression<E2>,
        StartWithEntityExpression<E3>, StartWithEntityExpression<E4>> startWithEntityExpressions) {
        MulitiStartWithExpression<C, L> expression = new MulitiEntityStartWithExpressionImpl<>(this);
        startWithEntityExpressions.accept(new StartWithEntityExpressionImpl<>(0, expression, factory, entityRelation),
            new StartWithEntityExpressionImpl<>(1, expression, factory, entityRelation),
            new StartWithEntityExpressionImpl<>(2, expression, factory, entityRelation),
            new StartWithEntityExpressionImpl<>(3, expression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ni(Consumer<Tuple4<NotInEntityExpression<E>, NotInEntityExpression<E2>, NotInEntityExpression<E3>,
        NotInEntityExpression<E4>>> notInEntityExpressions) {
        MulitiNotInExpression<C, L> mulitiExpression = new MulitiEntityNotInExpressionImpl<>(this);
        notInEntityExpressions
            .accept(Tuples.of(new NotInEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotInEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new NotInEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new NotInEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ni(FourArgusConsumer<NotInEntityExpression<E>, NotInEntityExpression<E2>, NotInEntityExpression<E3>,
        NotInEntityExpression<E4>> notInEntityExpressions) {
        MulitiNotInExpression<C, L> mulitiExpression = new MulitiEntityNotInExpressionImpl<>(this);
        notInEntityExpressions.accept(new NotInEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new NotInEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new NotInEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new NotInEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ne(Consumer<Tuple4<NotEqualsEntityExpression<E>, NotEqualsEntityExpression<E2>,
        NotEqualsEntityExpression<E3>, NotEqualsEntityExpression<E4>>> notEqualsEntityExpressions) {
        MulitiNotEqualsExpression<C, L> mulitiExpression = new MulitiEntityNotEqualsExpressionImpl<>(this);
        notEqualsEntityExpressions
            .accept(Tuples.of(new NotEqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotEqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new NotEqualsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new NotEqualsEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ne(FourArgusConsumer<NotEqualsEntityExpression<E>, NotEqualsEntityExpression<E2>,
        NotEqualsEntityExpression<E3>, NotEqualsEntityExpression<E4>> notEqualsEntityExpressions) {
        MulitiNotEqualsExpression<C, L> mulitiExpression = new MulitiEntityNotEqualsExpressionImpl<>(this);
        notEqualsEntityExpressions.accept(
            new NotEqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new NotEqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new NotEqualsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new NotEqualsEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lt(Consumer<Tuple4<LessThanEntityExpression<E>, LessThanEntityExpression<E2>, LessThanEntityExpression<E3>,
        LessThanEntityExpression<E4>>> lessThanEntityExpressions) {
        MulitiLessThanExpression<C, L> mulitiExpression = new MulitiEntityLessThanExpressionImpl<>(this);
        lessThanEntityExpressions
            .accept(Tuples.of(new LessThanEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new LessThanEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new LessThanEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new LessThanEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lt(FourArgusConsumer<LessThanEntityExpression<E>, LessThanEntityExpression<E2>,
        LessThanEntityExpression<E3>, LessThanEntityExpression<E4>> lessThanEntityExpressions) {
        MulitiLessThanExpression<C, L> mulitiExpression = new MulitiEntityLessThanExpressionImpl<>(this);
        lessThanEntityExpressions.accept(
            new LessThanEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new LessThanEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new LessThanEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new LessThanEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L le(Consumer<Tuple4<LessEqualsEntityExpression<E>, LessEqualsEntityExpression<E2>,
        LessEqualsEntityExpression<E3>, LessEqualsEntityExpression<E4>>> lessEqualsEntityExpressions) {
        MulitiLessEqualsExpression<C, L> mulitiExpression = new MulitiEntityLessEqualsExpressionImpl<>(this);
        lessEqualsEntityExpressions
            .accept(Tuples.of(new LessEqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new LessEqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new LessEqualsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new LessEqualsEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L le(FourArgusConsumer<LessEqualsEntityExpression<E>, LessEqualsEntityExpression<E2>,
        LessEqualsEntityExpression<E3>, LessEqualsEntityExpression<E4>> lessEqualsEntityExpressions) {
        MulitiLessEqualsExpression<C, L> mulitiExpression = new MulitiEntityLessEqualsExpressionImpl<>(this);
        lessEqualsEntityExpressions.accept(
            new LessEqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new LessEqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new LessEqualsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new LessEqualsEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L isn(Consumer<Tuple4<IsNullEntityExpression<E>, IsNullEntityExpression<E2>, IsNullEntityExpression<E3>,
        IsNullEntityExpression<E4>>> isNullEntityExpressions) {
        MulitiIsNullExpression<C, L> mulitiExpression = new MulitiEntityIsNullExpressionImpl<>(this);
        isNullEntityExpressions
            .accept(Tuples.of(new IsNullEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new IsNullEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new IsNullEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new IsNullEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L isn(FourArgusConsumer<IsNullEntityExpression<E>, IsNullEntityExpression<E2>, IsNullEntityExpression<E3>,
        IsNullEntityExpression<E4>> isNullEntityExpressions) {
        MulitiIsNullExpression<C, L> mulitiExpression = new MulitiEntityIsNullExpressionImpl<>(this);
        isNullEntityExpressions.accept(new IsNullEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new IsNullEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new IsNullEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new IsNullEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L inn(Consumer<Tuple4<IsNotNullEntityExpression<E>, IsNotNullEntityExpression<E2>,
        IsNotNullEntityExpression<E3>, IsNotNullEntityExpression<E4>>> isNotNullEntityExpressions) {
        MulitiIsNotNullExpression<C, L> mulitiExpression = new MulitiEntityIsNotNullExpressionImpl<>(this);
        isNotNullEntityExpressions
            .accept(Tuples.of(new IsNotNullEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new IsNotNullEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new IsNotNullEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new IsNotNullEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L inn(FourArgusConsumer<IsNotNullEntityExpression<E>, IsNotNullEntityExpression<E2>,
        IsNotNullEntityExpression<E3>, IsNotNullEntityExpression<E4>> isNotNullEntityExpressions) {
        MulitiIsNotNullExpression<C, L> mulitiExpression = new MulitiEntityIsNotNullExpressionImpl<>(this);
        isNotNullEntityExpressions.accept(
            new IsNotNullEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new IsNotNullEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new IsNotNullEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new IsNotNullEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L in(Consumer<Tuple4<InEntityExpression<E>, InEntityExpression<E2>, InEntityExpression<E3>,
        InEntityExpression<E4>>> inEntityExpressions) {
        MulitiInExpression<C, L> mulitiExpression = new MulitiEntityInExpressionImpl<>(this);
        inEntityExpressions.accept(Tuples.of(new InEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new InEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new InEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new InEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L in(FourArgusConsumer<InEntityExpression<E>, InEntityExpression<E2>, InEntityExpression<E3>,
        InEntityExpression<E4>> inEntityExpressions) {
        MulitiInExpression<C, L> mulitiExpression = new MulitiEntityInExpressionImpl<>(this);
        inEntityExpressions.accept(new InEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new InEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new InEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new InEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L gt(Consumer<Tuple4<GreatThanEntityExpression<E>, GreatThanEntityExpression<E2>,
        GreatThanEntityExpression<E3>, GreatThanEntityExpression<E4>>> greatThanEntityExpressions) {
        MulitiGreatThanExpression<C, L> mulitiExpression = new MulitiEntityGreatThanExpressionImpl<>(this);
        greatThanEntityExpressions
            .accept(Tuples.of(new GreatThanEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new GreatThanEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new GreatThanEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new GreatThanEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L gt(FourArgusConsumer<GreatThanEntityExpression<E>, GreatThanEntityExpression<E2>,
        GreatThanEntityExpression<E3>, GreatThanEntityExpression<E4>> greatThanEntityExpressions) {
        MulitiGreatThanExpression<C, L> mulitiExpression = new MulitiEntityGreatThanExpressionImpl<>(this);
        greatThanEntityExpressions.accept(
            new GreatThanEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new GreatThanEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new GreatThanEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new GreatThanEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ge(Consumer<Tuple4<GreatEqualsEntityExpression<E>, GreatEqualsEntityExpression<E2>,
        GreatEqualsEntityExpression<E3>, GreatEqualsEntityExpression<E4>>> greatEqualsEntityExpressions) {
        MulitiGreatEqualsExpression<C, L> mulitiExpression = new MulitiEntityGreatEqualsExpressionImpl<>(this);
        greatEqualsEntityExpressions
            .accept(Tuples.of(new GreatEqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new GreatEqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new GreatEqualsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new GreatEqualsEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ge(FourArgusConsumer<GreatEqualsEntityExpression<E>, GreatEqualsEntityExpression<E2>,
        GreatEqualsEntityExpression<E3>, GreatEqualsEntityExpression<E4>> greatEqualsEntityExpressions) {
        MulitiGreatEqualsExpression<C, L> mulitiExpression = new MulitiEntityGreatEqualsExpressionImpl<>(this);
        greatEqualsEntityExpressions.accept(
            new GreatEqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new GreatEqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new GreatEqualsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new GreatEqualsEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L eq(Consumer<Tuple4<EqualsEntityExpression<E>, EqualsEntityExpression<E2>, EqualsEntityExpression<E3>,
        EqualsEntityExpression<E4>>> equalsEntityExpressions) {
        MulitiEqualsExpression<C, L> mulitiExpression = new MulitiEntityEqualsExpressionImpl<>(this);
        equalsEntityExpressions
            .accept(Tuples.of(new EqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new EqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new EqualsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new EqualsEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L eq(FourArgusConsumer<EqualsEntityExpression<E>, EqualsEntityExpression<E2>, EqualsEntityExpression<E3>,
        EqualsEntityExpression<E4>> equalsEntityExpressions) {
        MulitiEqualsExpression<C, L> mulitiExpression = new MulitiEntityEqualsExpressionImpl<>(this);
        equalsEntityExpressions.accept(new EqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new EqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new EqualsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new EqualsEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ew(Consumer<Tuple4<EndWithEntityExpression<E>, EndWithEntityExpression<E2>, EndWithEntityExpression<E3>,
        EndWithEntityExpression<E4>>> endWithEntityExpressions) {
        MulitiEndWithExpression<C, L> mulitiExpression = new MulitiEntityEndWithExpressionImpl<>(this);
        endWithEntityExpressions
            .accept(Tuples.of(new EndWithEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new EndWithEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new EndWithEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new EndWithEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ew(FourArgusConsumer<EndWithEntityExpression<E>, EndWithEntityExpression<E2>, EndWithEntityExpression<E3>,
        EndWithEntityExpression<E4>> endWithEntityExpressions) {
        MulitiEndWithExpression<C, L> mulitiExpression = new MulitiEntityEndWithExpressionImpl<>(this);
        endWithEntityExpressions.accept(new EndWithEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new EndWithEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new EndWithEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new EndWithEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L co(Consumer<Tuple4<ContainsEntityExpression<E>, ContainsEntityExpression<E2>, ContainsEntityExpression<E3>,
        ContainsEntityExpression<E4>>> containsEntityExpressions) {
        MulitiContainsExpression<C, L> mulitiEntityContainsExpression = new MulitiEntityContainsExpressionImpl<>(this);
        containsEntityExpressions.accept(
            Tuples.of(new ContainsEntityExpressionImpl<>(0, mulitiEntityContainsExpression, factory, entityRelation),
                new ContainsEntityExpressionImpl<>(1, mulitiEntityContainsExpression, factory, entityRelation),
                new ContainsEntityExpressionImpl<>(2, mulitiEntityContainsExpression, factory, entityRelation),
                new ContainsEntityExpressionImpl<>(3, mulitiEntityContainsExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L co(FourArgusConsumer<ContainsEntityExpression<E>, ContainsEntityExpression<E2>,
        ContainsEntityExpression<E3>, ContainsEntityExpression<E4>> containsEntityExpressions) {
        MulitiContainsExpression<C, L> mulitiEntityContainsExpression = new MulitiEntityContainsExpressionImpl<>(this);
        containsEntityExpressions.accept(
            new ContainsEntityExpressionImpl<>(0, mulitiEntityContainsExpression, factory, entityRelation),
            new ContainsEntityExpressionImpl<>(1, mulitiEntityContainsExpression, factory, entityRelation),
            new ContainsEntityExpressionImpl<>(2, mulitiEntityContainsExpression, factory, entityRelation),
            new ContainsEntityExpressionImpl<>(3, mulitiEntityContainsExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ba(Consumer<Tuple4<BetweenEntityExpression<E>, BetweenEntityExpression<E2>, BetweenEntityExpression<E3>,
        BetweenEntityExpression<E4>>> betweenEntityExpressions) {
        MulitiBetweenExpression<C, L> mulitiExpression = new MulitiEntityBetweenExpressionImpl<>(this);
        betweenEntityExpressions
            .accept(Tuples.of(new BetweenEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new BetweenEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new BetweenEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new BetweenEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ba(FourArgusConsumer<BetweenEntityExpression<E>, BetweenEntityExpression<E2>, BetweenEntityExpression<E3>,
        BetweenEntityExpression<E4>> betweenEntityExpressions) {
        MulitiBetweenExpression<C, L> mulitiExpression = new MulitiEntityBetweenExpressionImpl<>(this);
        betweenEntityExpressions.accept(new BetweenEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new BetweenEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new BetweenEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new BetweenEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nba(Consumer<Tuple4<NotBetweenEntityExpression<E>, NotBetweenEntityExpression<E2>,
        NotBetweenEntityExpression<E3>, NotBetweenEntityExpression<E4>>> notBetweenEntityExpressions) {
        MulitiNotBetweenExpression<C, L> mulitiExpression = new MulitiEntityNotBetweenExpressionImpl<>(this);
        notBetweenEntityExpressions
            .accept(Tuples.of(new NotBetweenEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotBetweenEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new NotBetweenEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new NotBetweenEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nba(FourArgusConsumer<NotBetweenEntityExpression<E>, NotBetweenEntityExpression<E2>,
        NotBetweenEntityExpression<E3>, NotBetweenEntityExpression<E4>> notBetweenEntityExpressions) {
        MulitiNotBetweenExpression<C, L> mulitiExpression = new MulitiEntityNotBetweenExpressionImpl<>(this);
        notBetweenEntityExpressions.accept(
            new NotBetweenEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new NotBetweenEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new NotBetweenEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new NotBetweenEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nco(Consumer<Tuple4<NotContainsEntityExpression<E>, NotContainsEntityExpression<E2>,
        NotContainsEntityExpression<E3>, NotContainsEntityExpression<E4>>> notContainsEntityExpressions) {
        MulitiNotContainsExpression<C, L> mulitiExpression = new MulitiEntityNotContainsExpressionImpl<>(this);
        notContainsEntityExpressions
            .accept(Tuples.of(new NotContainsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotContainsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new NotContainsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new NotContainsEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nco(FourArgusConsumer<NotContainsEntityExpression<E>, NotContainsEntityExpression<E2>,
        NotContainsEntityExpression<E3>, NotContainsEntityExpression<E4>> notContainsEntityExpressions) {
        MulitiNotContainsExpression<C, L> mulitiExpression = new MulitiEntityNotContainsExpressionImpl<>(this);
        notContainsEntityExpressions.accept(
            new NotContainsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new NotContainsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new NotContainsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new NotContainsEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L newv(Consumer<Tuple4<NotEndWithEntityExpression<E>, NotEndWithEntityExpression<E2>,
        NotEndWithEntityExpression<E3>, NotEndWithEntityExpression<E4>>> notEndWithEntityExpressions) {
        MulitiNotEndWithExpression<C, L> mulitiExpression = new MulitiEntityNotEndWithExpressionImpl<>(this);
        notEndWithEntityExpressions
            .accept(Tuples.of(new NotEndWithEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotEndWithEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new NotEndWithEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new NotEndWithEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L newv(FourArgusConsumer<NotEndWithEntityExpression<E>, NotEndWithEntityExpression<E2>,
        NotEndWithEntityExpression<E3>, NotEndWithEntityExpression<E4>> notEndWithEntityExpressions) {
        MulitiNotEndWithExpression<C, L> mulitiExpression = new MulitiEntityNotEndWithExpressionImpl<>(this);
        notEndWithEntityExpressions.accept(
            new NotEndWithEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new NotEndWithEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new NotEndWithEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new NotEndWithEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nl(Consumer<Tuple4<NotLikeEntityExpression<E>, NotLikeEntityExpression<E2>, NotLikeEntityExpression<E3>,
        NotLikeEntityExpression<E4>>> notLikeEntityExpressions) {
        MulitiNotLikeExpression<C, L> mulitiExpression = new MulitiEntityNotLikeExpressionImpl<>(this);
        notLikeEntityExpressions
            .accept(Tuples.of(new NotLikeEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotLikeEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new NotLikeEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new NotLikeEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nl(FourArgusConsumer<NotLikeEntityExpression<E>, NotLikeEntityExpression<E2>, NotLikeEntityExpression<E3>,
        NotLikeEntityExpression<E4>> notLikeEntityExpressions) {
        MulitiNotLikeExpression<C, L> mulitiExpression = new MulitiEntityNotLikeExpressionImpl<>(this);
        notLikeEntityExpressions.accept(new NotLikeEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new NotLikeEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new NotLikeEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new NotLikeEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nsw(Consumer<Tuple4<NotStartWithEntityExpression<E>, NotStartWithEntityExpression<E2>,
        NotStartWithEntityExpression<E3>, NotStartWithEntityExpression<E4>>> notStartWithEntityExpressions) {
        MulitiNotStartWithExpression<C, L> mulitiExpression = new MulitiEntityNotStartWithExpressionImpl<>(this);
        notStartWithEntityExpressions
            .accept(Tuples.of(new NotStartWithEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotStartWithEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new NotStartWithEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new NotStartWithEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nsw(FourArgusConsumer<NotStartWithEntityExpression<E>, NotStartWithEntityExpression<E2>,
        NotStartWithEntityExpression<E3>, NotStartWithEntityExpression<E4>> notStartWithEntityExpressions) {
        MulitiNotStartWithExpression<C, L> mulitiExpression = new MulitiEntityNotStartWithExpressionImpl<>(this);
        notStartWithEntityExpressions.accept(
            new NotStartWithEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new NotStartWithEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new NotStartWithEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new NotStartWithEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation));
        return (L) this;
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

    // ****************************************************************************************************************

    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(String... names) {
        getRootSortBuilder().asc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc2(String... names) {
        getRootSortBuilder().asc(queryAlias2, () -> ClassMappingUtils.getColumnNames(classMapping2, names));
        return this;
    }

    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc3(String... names) {
        getRootSortBuilder().asc(queryAlias3, () -> ClassMappingUtils.getColumnNames(classMapping3, names));
        return this;
    }

    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc4(String... names) {
        getRootSortBuilder().asc(queryAlias4, () -> ClassMappingUtils.getColumnNames(classMapping4, names));
        return this;
    }

    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(String... names) {
        getRootSortBuilder().desc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc2(String... names) {
        getRootSortBuilder().desc(queryAlias2, () -> ClassMappingUtils.getColumnNames(classMapping2, names));
        return this;
    }

    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc3(String... names) {
        getRootSortBuilder().desc(queryAlias3, () -> ClassMappingUtils.getColumnNames(classMapping3, names));
        return this;
    }

    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc4(String... names) {
        getRootSortBuilder().desc(queryAlias4, () -> ClassMappingUtils.getColumnNames(classMapping4, names));
        return this;
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(
        FourArgusConsumer<EntitySetSortPropertyExpression<E>, EntitySetSortPropertyExpression<E2>,
            EntitySetSortPropertyExpression<E3>, EntitySetSortPropertyExpression<E4>> sortEntityExpressions) {
        sortEntityExpressions.accept(
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), tableAlias, SortOperator.ASC, classMapping),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), queryAlias2, SortOperator.ASC,
                classMapping2),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), queryAlias3, SortOperator.ASC,
                classMapping3),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), queryAlias4, SortOperator.ASC,
                classMapping4));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(
        FourArgusConsumer<EntitySetSortPropertyExpression<E>, EntitySetSortPropertyExpression<E2>,
            EntitySetSortPropertyExpression<E3>, EntitySetSortPropertyExpression<E4>> sortEntityExpressions) {
        sortEntityExpressions.accept(
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), tableAlias, SortOperator.DESC, classMapping),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), queryAlias2, SortOperator.DESC,
                classMapping2),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), queryAlias3, SortOperator.DESC,
                classMapping3),
            new EntitySetSqlSortPropertyExpression<>(getRootSortBuilder(), queryAlias4, SortOperator.DESC,
                classMapping4));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc4(SerializableFunction<E4, R> name) {
        return asc4(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc4(
        @SuppressWarnings("unchecked") SerializableFunction<E4, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return asc4(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc4(SerializableFunction<E4, R> name) {
        return desc4(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc4(
        @SuppressWarnings("unchecked") SerializableFunction<E4, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return desc4(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc3(SerializableFunction<E3, R> name) {
        return asc3(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc3(
        @SuppressWarnings("unchecked") SerializableFunction<E3, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return asc3(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc3(SerializableFunction<E3, R> name) {
        return desc3(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc3(
        @SuppressWarnings("unchecked") SerializableFunction<E3, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return desc3(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc2(SerializableFunction<E2, R> name) {
        return asc2(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc2(
        @SuppressWarnings("unchecked") SerializableFunction<E2, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return asc2(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc2(SerializableFunction<E2, R> name) {
        return desc2(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc2(
        @SuppressWarnings("unchecked") SerializableFunction<E2, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
            .toArray(value -> new String[value]);
        return desc2(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> asc(SerializableFunction<E, R> name) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression4<E, E2, E3, E4, RS> desc(SerializableFunction<E, R> name) {
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

    // ****************************************************************************************************************
    //  private method
    // ****************************************************************************************************************

    @SuppressWarnings("unchecked")
    protected SortBuilder getRootSortBuilder() {
        return ((AbstractMulitiEntitySqlQueryConditionsGroupExpression4<E, E2, E3, E4, RS, C,
            L>) getRoot()).sortBuilder;
    }
}
