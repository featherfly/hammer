
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.condition.ParamedExpression;
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
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpression3;
import cn.featherfly.hammer.expression.entity.condition.eq.EntityEqualsExpression3;
import cn.featherfly.hammer.expression.entity.condition.eq.EqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.EndWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.EntityEndWithExpression3;
import cn.featherfly.hammer.expression.entity.condition.ge.EntityGreatEqualsExpression3;
import cn.featherfly.hammer.expression.entity.condition.ge.GreatEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.gt.EntityGreatThanExpression3;
import cn.featherfly.hammer.expression.entity.condition.gt.GreatThanEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.in.EntityInExpression3;
import cn.featherfly.hammer.expression.entity.condition.in.InEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.inn.EntityIsNotNullExpression3;
import cn.featherfly.hammer.expression.entity.condition.inn.IsNotNullEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.isn.EntityIsNullExpression3;
import cn.featherfly.hammer.expression.entity.condition.isn.IsNullEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.le.EntityLessEqualsExpression3;
import cn.featherfly.hammer.expression.entity.condition.le.LessEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.lk.EntityLikeExpression3;
import cn.featherfly.hammer.expression.entity.condition.lk.LikeEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.lt.EntityLessThanExpression3;
import cn.featherfly.hammer.expression.entity.condition.lt.LessThanEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nba.NotBetweenEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nco.NotContainsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpression3;
import cn.featherfly.hammer.expression.entity.condition.ne.NotEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.newv.NotEndWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ni.EntityNotInExpression3;
import cn.featherfly.hammer.expression.entity.condition.ni.NotInEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nl.NotLikeEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nsw.NotStartWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpression3;
import cn.featherfly.hammer.expression.entity.condition.sw.StartWithEntityExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupExpression3;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupLogicExpression3;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.AbstractMulitiEntitySqlConditionsGroupExpressionBase3;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;
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

/**
 * sql condition group expression3. 条件逻辑组构造器3.
 *
 * @author zhongj
 * @param <E1> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C2> the generic type
 * @param <ER> the generic type
 * @param <B>  the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public abstract class AbstractMulitiEntitySqlExecutableConditionsGroupExpression3<E1, E2, E3,
    C2 extends ExecutableConditionConfig<C2>, ER extends EntitySqlRelation<ER, B>, B extends SqlBuilder,
    C extends EntityExecutableConditionGroupExpression3<E1, E2, E3, C, L, C2>,
    L extends EntityExecutableConditionGroupLogicExpression3<E1, E2, E3, C, L, C2>>
    extends AbstractMulitiEntitySqlConditionsGroupExpressionBase3<E1, E2, E3, ER, B, C, L, C2>
    implements EntityExecutableConditionGroupExpression3<E1, E2, E3, C, L, C2>,
    EntityExecutableConditionGroupLogicExpression3<E1, E2, E3, C, L, C2>, ParamedExpression,
    EntityContainsExpression3<E1, E2, E3, C, L>, EntityEndWithExpression3<E1, E2, E3, C, L>,
    EntityEqualsExpression3<E1, E2, E3, C, L>, EntityGreatEqualsExpression3<E1, E2, E3, C, L>,
    EntityGreatThanExpression3<E1, E2, E3, C, L>, EntityInExpression3<E1, E2, E3, C, L>,
    EntityIsNotNullExpression3<E1, E2, E3, C, L>, EntityIsNullExpression3<E1, E2, E3, C, L>,
    EntityLessEqualsExpression3<E1, E2, E3, C, L>, EntityLessThanExpression3<E1, E2, E3, C, L>,
    EntityNotEqualsExpression3<E1, E2, E3, C, L>, EntityNotInExpression3<E1, E2, E3, C, L>,
    EntityStartWithExpression3<E1, E2, E3, C, L>, EntityLikeExpression3<E1, E2, E3, C, L> {

    /**
     * Instantiates a new abstract entity sql condition group expression 2.
     *
     * @param parent        the parent
     * @param factory       the factory
     * @param queryRelation the relation
     */
    protected AbstractMulitiEntitySqlExecutableConditionsGroupExpression3(L parent, JdbcMappingFactory factory,
        ER queryRelation) {
        super(parent, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        if (parent != null) {
            return parent.execute();
        } else {
            return entityRelation.getJdbc().update(expression(), getParams().toArray());
        }
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lk(Consumer<
        Tuple3<LikeEntityExpression<E1>, LikeEntityExpression<E2>, LikeEntityExpression<E3>>> likeEntityExpressions) {
        MulitiLikeExpression<C, L> mulitiExpression = new MulitiEntityLikeExpressionImpl<>(this);
        likeEntityExpressions
            .accept(Tuples.of(new LikeEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new LikeEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new LikeEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lk(ThreeArgusConsumer<LikeEntityExpression<E1>, LikeEntityExpression<E2>,
        LikeEntityExpression<E3>> likeEntityExpressions) {
        MulitiLikeExpression<C, L> mulitiExpression = new MulitiEntityLikeExpressionImpl<>(this);
        likeEntityExpressions.accept(new LikeEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new LikeEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new LikeEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L sw(Consumer<Tuple3<StartWithEntityExpression<E1>, StartWithEntityExpression<E2>,
        StartWithEntityExpression<E3>>> startWithEntityExpressions) {
        MulitiStartWithExpression<C, L> expression = new MulitiEntityStartWithExpressionImpl<>(this);
        startWithEntityExpressions
            .accept(Tuples.of(new StartWithEntityExpressionImpl<>(0, expression, factory, entityRelation),
                new StartWithEntityExpressionImpl<>(1, expression, factory, entityRelation),
                new StartWithEntityExpressionImpl<>(2, expression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L sw(ThreeArgusConsumer<StartWithEntityExpression<E1>, StartWithEntityExpression<E2>,
        StartWithEntityExpression<E3>> startWithEntityExpressions) {
        MulitiStartWithExpression<C, L> expression = new MulitiEntityStartWithExpressionImpl<>(this);
        startWithEntityExpressions.accept(new StartWithEntityExpressionImpl<>(0, expression, factory, entityRelation),
            new StartWithEntityExpressionImpl<>(1, expression, factory, entityRelation),
            new StartWithEntityExpressionImpl<>(2, expression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ni(Consumer<Tuple3<NotInEntityExpression<E1>, NotInEntityExpression<E2>,
        NotInEntityExpression<E3>>> notInEntityExpressions) {
        MulitiNotInExpression<C, L> mulitiExpression = new MulitiEntityNotInExpressionImpl<>(this);
        notInEntityExpressions
            .accept(Tuples.of(new NotInEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotInEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new NotInEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ni(ThreeArgusConsumer<NotInEntityExpression<E1>, NotInEntityExpression<E2>,
        NotInEntityExpression<E3>> notInEntityExpressions) {
        MulitiNotInExpression<C, L> mulitiExpression = new MulitiEntityNotInExpressionImpl<>(this);
        notInEntityExpressions.accept(new NotInEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new NotInEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new NotInEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ne(Consumer<Tuple3<NotEqualsEntityExpression<E1>, NotEqualsEntityExpression<E2>,
        NotEqualsEntityExpression<E3>>> notEqualsEntityExpressions) {
        MulitiNotEqualsExpression<C, L> mulitiExpression = new MulitiEntityNotEqualsExpressionImpl<>(this);
        notEqualsEntityExpressions
            .accept(Tuples.of(new NotEqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotEqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new NotEqualsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ne(ThreeArgusConsumer<NotEqualsEntityExpression<E1>, NotEqualsEntityExpression<E2>,
        NotEqualsEntityExpression<E3>> notEqualsEntityExpressions) {
        MulitiNotEqualsExpression<C, L> mulitiExpression = new MulitiEntityNotEqualsExpressionImpl<>(this);
        notEqualsEntityExpressions.accept(
            new NotEqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new NotEqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new NotEqualsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lt(Consumer<Tuple3<LessThanEntityExpression<E1>, LessThanEntityExpression<E2>,
        LessThanEntityExpression<E3>>> lessThanEntityExpressions) {
        MulitiLessThanExpression<C, L> mulitiExpression = new MulitiEntityLessThanExpressionImpl<>(this);
        lessThanEntityExpressions
            .accept(Tuples.of(new LessThanEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new LessThanEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new LessThanEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lt(ThreeArgusConsumer<LessThanEntityExpression<E1>, LessThanEntityExpression<E2>,
        LessThanEntityExpression<E3>> lessThanEntityExpressions) {
        MulitiLessThanExpression<C, L> mulitiExpression = new MulitiEntityLessThanExpressionImpl<>(this);
        lessThanEntityExpressions.accept(
            new LessThanEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new LessThanEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new LessThanEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L le(Consumer<Tuple3<LessEqualsEntityExpression<E1>, LessEqualsEntityExpression<E2>,
        LessEqualsEntityExpression<E3>>> lessEqualsEntityExpressions) {
        MulitiLessEqualsExpression<C, L> mulitiExpression = new MulitiEntityLessEqualsExpressionImpl<>(this);
        lessEqualsEntityExpressions
            .accept(Tuples.of(new LessEqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new LessEqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new LessEqualsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L le(ThreeArgusConsumer<LessEqualsEntityExpression<E1>, LessEqualsEntityExpression<E2>,
        LessEqualsEntityExpression<E3>> lessEqualsEntityExpressions) {
        MulitiLessEqualsExpression<C, L> mulitiExpression = new MulitiEntityLessEqualsExpressionImpl<>(this);
        lessEqualsEntityExpressions.accept(
            new LessEqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new LessEqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new LessEqualsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L isn(Consumer<Tuple3<IsNullEntityExpression<E1>, IsNullEntityExpression<E2>,
        IsNullEntityExpression<E3>>> isNullEntityExpressions) {
        MulitiIsNullExpression<C, L> mulitiExpression = new MulitiEntityIsNullExpressionImpl<>(this);
        isNullEntityExpressions
            .accept(Tuples.of(new IsNullEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new IsNullEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new IsNullEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L isn(ThreeArgusConsumer<IsNullEntityExpression<E1>, IsNullEntityExpression<E2>,
        IsNullEntityExpression<E3>> isNullEntityExpressions) {
        MulitiIsNullExpression<C, L> mulitiExpression = new MulitiEntityIsNullExpressionImpl<>(this);
        isNullEntityExpressions.accept(new IsNullEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new IsNullEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new IsNullEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L inn(Consumer<Tuple3<IsNotNullEntityExpression<E1>, IsNotNullEntityExpression<E2>,
        IsNotNullEntityExpression<E3>>> isNotNullEntityExpressions) {
        MulitiIsNotNullExpression<C, L> mulitiExpression = new MulitiEntityIsNotNullExpressionImpl<>(this);
        isNotNullEntityExpressions
            .accept(Tuples.of(new IsNotNullEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new IsNotNullEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new IsNotNullEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L inn(ThreeArgusConsumer<IsNotNullEntityExpression<E1>, IsNotNullEntityExpression<E2>,
        IsNotNullEntityExpression<E3>> isNotNullEntityExpressions) {
        MulitiIsNotNullExpression<C, L> mulitiExpression = new MulitiEntityIsNotNullExpressionImpl<>(this);
        isNotNullEntityExpressions.accept(
            new IsNotNullEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new IsNotNullEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new IsNotNullEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L in(
        Consumer<Tuple3<InEntityExpression<E1>, InEntityExpression<E2>, InEntityExpression<E3>>> inEntityExpressions) {
        MulitiInExpression<C, L> mulitiExpression = new MulitiEntityInExpressionImpl<>(this);
        inEntityExpressions.accept(Tuples.of(new InEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new InEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new InEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L in(ThreeArgusConsumer<InEntityExpression<E1>, InEntityExpression<E2>,
        InEntityExpression<E3>> inEntityExpressions) {
        MulitiInExpression<C, L> mulitiExpression = new MulitiEntityInExpressionImpl<>(this);
        inEntityExpressions.accept(new InEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new InEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new InEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L gt(Consumer<Tuple3<GreatThanEntityExpression<E1>, GreatThanEntityExpression<E2>,
        GreatThanEntityExpression<E3>>> greatThanEntityExpressions) {
        MulitiGreatThanExpression<C, L> mulitiExpression = new MulitiEntityGreatThanExpressionImpl<>(this);
        greatThanEntityExpressions
            .accept(Tuples.of(new GreatThanEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new GreatThanEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new GreatThanEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L gt(ThreeArgusConsumer<GreatThanEntityExpression<E1>, GreatThanEntityExpression<E2>,
        GreatThanEntityExpression<E3>> greatThanEntityExpressions) {
        MulitiGreatThanExpression<C, L> mulitiExpression = new MulitiEntityGreatThanExpressionImpl<>(this);
        greatThanEntityExpressions.accept(
            new GreatThanEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new GreatThanEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new GreatThanEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ge(Consumer<Tuple3<GreatEqualsEntityExpression<E1>, GreatEqualsEntityExpression<E2>,
        GreatEqualsEntityExpression<E3>>> greatEqualsEntityExpressions) {
        MulitiGreatEqualsExpression<C, L> mulitiExpression = new MulitiEntityGreatEqualsExpressionImpl<>(this);
        greatEqualsEntityExpressions
            .accept(Tuples.of(new GreatEqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new GreatEqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new GreatEqualsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ge(ThreeArgusConsumer<GreatEqualsEntityExpression<E1>, GreatEqualsEntityExpression<E2>,
        GreatEqualsEntityExpression<E3>> greatEqualsEntityExpressions) {
        MulitiGreatEqualsExpression<C, L> mulitiExpression = new MulitiEntityGreatEqualsExpressionImpl<>(this);
        greatEqualsEntityExpressions.accept(
            new GreatEqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new GreatEqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new GreatEqualsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L eq(Consumer<Tuple3<EqualsEntityExpression<E1>, EqualsEntityExpression<E2>,
        EqualsEntityExpression<E3>>> equalsEntityExpressions) {
        MulitiEqualsExpression<C, L> mulitiExpression = new MulitiEntityEqualsExpressionImpl<>(this);
        equalsEntityExpressions
            .accept(Tuples.of(new EqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new EqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new EqualsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L eq(ThreeArgusConsumer<EqualsEntityExpression<E1>, EqualsEntityExpression<E2>,
        EqualsEntityExpression<E3>> equalsEntityExpressions) {
        MulitiEqualsExpression<C, L> mulitiExpression = new MulitiEntityEqualsExpressionImpl<>(this);
        equalsEntityExpressions.accept(new EqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new EqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new EqualsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ew(Consumer<Tuple3<EndWithEntityExpression<E1>, EndWithEntityExpression<E2>,
        EndWithEntityExpression<E3>>> endWithEntityExpressions) {
        MulitiEndWithExpression<C, L> mulitiExpression = new MulitiEntityEndWithExpressionImpl<>(this);
        endWithEntityExpressions
            .accept(Tuples.of(new EndWithEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new EndWithEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new EndWithEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ew(ThreeArgusConsumer<EndWithEntityExpression<E1>, EndWithEntityExpression<E2>,
        EndWithEntityExpression<E3>> endWithEntityExpressions) {
        MulitiEndWithExpression<C, L> mulitiExpression = new MulitiEntityEndWithExpressionImpl<>(this);
        endWithEntityExpressions.accept(new EndWithEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new EndWithEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new EndWithEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L co(Consumer<Tuple3<ContainsEntityExpression<E1>, ContainsEntityExpression<E2>,
        ContainsEntityExpression<E3>>> containsEntityExpressions) {
        MulitiContainsExpression<C, L> mulitiEntityContainsExpression = new MulitiEntityContainsExpressionImpl<>(this);
        containsEntityExpressions.accept(
            Tuples.of(new ContainsEntityExpressionImpl<>(0, mulitiEntityContainsExpression, factory, entityRelation),
                new ContainsEntityExpressionImpl<>(1, mulitiEntityContainsExpression, factory, entityRelation),
                new ContainsEntityExpressionImpl<>(2, mulitiEntityContainsExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L co(ThreeArgusConsumer<ContainsEntityExpression<E1>, ContainsEntityExpression<E2>,
        ContainsEntityExpression<E3>> containsEntityExpressions) {
        MulitiContainsExpression<C, L> mulitiEntityContainsExpression = new MulitiEntityContainsExpressionImpl<>(this);
        containsEntityExpressions.accept(
            new ContainsEntityExpressionImpl<>(0, mulitiEntityContainsExpression, factory, entityRelation),
            new ContainsEntityExpressionImpl<>(1, mulitiEntityContainsExpression, factory, entityRelation),
            new ContainsEntityExpressionImpl<>(2, mulitiEntityContainsExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ba(Consumer<Tuple3<BetweenEntityExpression<E1>, BetweenEntityExpression<E2>,
        BetweenEntityExpression<E3>>> betweenEntityExpressions) {
        MulitiBetweenExpression<C, L> mulitiExpression = new MulitiEntityBetweenExpressionImpl<>(this);
        betweenEntityExpressions
            .accept(Tuples.of(new BetweenEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new BetweenEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new BetweenEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ba(ThreeArgusConsumer<BetweenEntityExpression<E1>, BetweenEntityExpression<E2>,
        BetweenEntityExpression<E3>> betweenEntityExpressions) {
        MulitiBetweenExpression<C, L> mulitiExpression = new MulitiEntityBetweenExpressionImpl<>(this);
        betweenEntityExpressions.accept(new BetweenEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new BetweenEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new BetweenEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nba(Consumer<Tuple3<NotBetweenEntityExpression<E1>, NotBetweenEntityExpression<E2>,
        NotBetweenEntityExpression<E3>>> notBetweenEntityExpressions) {
        MulitiNotBetweenExpression<C, L> mulitiExpression = new MulitiEntityNotBetweenExpressionImpl<>(this);
        notBetweenEntityExpressions
            .accept(Tuples.of(new NotBetweenEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotBetweenEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new NotBetweenEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nba(ThreeArgusConsumer<NotBetweenEntityExpression<E1>, NotBetweenEntityExpression<E2>,
        NotBetweenEntityExpression<E3>> notBetweenEntityExpressions) {
        MulitiNotBetweenExpression<C, L> mulitiExpression = new MulitiEntityNotBetweenExpressionImpl<>(this);
        notBetweenEntityExpressions.accept(
            new NotBetweenEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new NotBetweenEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new NotBetweenEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nco(Consumer<Tuple3<NotContainsEntityExpression<E1>, NotContainsEntityExpression<E2>,
        NotContainsEntityExpression<E3>>> notContainsEntityExpressions) {
        MulitiNotContainsExpression<C,
            L> mulitiEntityContainsExpression = new MulitiEntityNotContainsExpressionImpl<>(this);
        notContainsEntityExpressions.accept(
            Tuples.of(new NotContainsEntityExpressionImpl<>(0, mulitiEntityContainsExpression, factory, entityRelation),
                new NotContainsEntityExpressionImpl<>(1, mulitiEntityContainsExpression, factory, entityRelation),
                new NotContainsEntityExpressionImpl<>(2, mulitiEntityContainsExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nco(ThreeArgusConsumer<NotContainsEntityExpression<E1>, NotContainsEntityExpression<E2>,
        NotContainsEntityExpression<E3>> notContainsEntityExpressions) {
        MulitiNotContainsExpression<C,
            L> mulitiEntityContainsExpression = new MulitiEntityNotContainsExpressionImpl<>(this);
        notContainsEntityExpressions.accept(
            new NotContainsEntityExpressionImpl<>(0, mulitiEntityContainsExpression, factory, entityRelation),
            new NotContainsEntityExpressionImpl<>(1, mulitiEntityContainsExpression, factory, entityRelation),
            new NotContainsEntityExpressionImpl<>(2, mulitiEntityContainsExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L newv(Consumer<Tuple3<NotEndWithEntityExpression<E1>, NotEndWithEntityExpression<E2>,
        NotEndWithEntityExpression<E3>>> notEndWithEntityExpressions) {
        MulitiNotEndWithExpression<C, L> mulitiExpression = new MulitiEntityNotEndWithExpressionImpl<>(this);
        notEndWithEntityExpressions
            .accept(Tuples.of(new NotEndWithEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotEndWithEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new NotEndWithEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L newv(ThreeArgusConsumer<NotEndWithEntityExpression<E1>, NotEndWithEntityExpression<E2>,
        NotEndWithEntityExpression<E3>> notEndWithEntityExpressions) {
        MulitiNotEndWithExpression<C, L> mulitiExpression = new MulitiEntityNotEndWithExpressionImpl<>(this);
        notEndWithEntityExpressions.accept(
            new NotEndWithEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new NotEndWithEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new NotEndWithEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nsw(Consumer<Tuple3<NotStartWithEntityExpression<E1>, NotStartWithEntityExpression<E2>,
        NotStartWithEntityExpression<E3>>> notStartWithEntityExpressions) {
        MulitiNotStartWithExpression<C, L> mulitiExpression = new MulitiEntityNotStartWithExpressionImpl<>(this);
        notStartWithEntityExpressions
            .accept(Tuples.of(new NotStartWithEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotStartWithEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new NotStartWithEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nsw(ThreeArgusConsumer<NotStartWithEntityExpression<E1>, NotStartWithEntityExpression<E2>,
        NotStartWithEntityExpression<E3>> notStartWithEntityExpressions) {
        MulitiNotStartWithExpression<C, L> mulitiExpression = new MulitiEntityNotStartWithExpressionImpl<>(this);
        notStartWithEntityExpressions.accept(
            new NotStartWithEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new NotStartWithEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new NotStartWithEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nl(Consumer<Tuple3<NotLikeEntityExpression<E1>, NotLikeEntityExpression<E2>,
        NotLikeEntityExpression<E3>>> notLikeEntityExpressions) {
        MulitiNotLikeExpression<C, L> mulitiExpression = new MulitiEntityNotLikeExpressionImpl<>(this);
        notLikeEntityExpressions
            .accept(Tuples.of(new NotLikeEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotLikeEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new NotLikeEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nl(ThreeArgusConsumer<NotLikeEntityExpression<E1>, NotLikeEntityExpression<E2>,
        NotLikeEntityExpression<E3>> notLikeEntityExpressions) {
        MulitiNotLikeExpression<C, L> mulitiExpression = new MulitiEntityNotLikeExpressionImpl<>(this);
        notLikeEntityExpressions.accept(new NotLikeEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new NotLikeEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new NotLikeEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation));
        return (L) this;
    }
}
