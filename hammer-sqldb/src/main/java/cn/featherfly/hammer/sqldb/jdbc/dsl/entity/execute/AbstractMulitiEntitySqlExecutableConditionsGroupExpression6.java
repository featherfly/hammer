
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.execute;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple6;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
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
import cn.featherfly.hammer.expression.entity.condition.eq.EqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.EndWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ge.GreatEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.gt.GreatThanEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.in.InEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.inn.IsNotNullEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.isn.IsNullEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.le.LessEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.lk.LikeEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.lt.LessThanEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nba.NotBetweenEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nco.NotContainsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ne.NotEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.newv.NotEndWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ni.NotInEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nl.NotLikeEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nsw.NotStartWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.StartWithEntityExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupExpression6;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupLogicExpression6;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.AbstractMulitiEntitySqlConditionsGroupExpressionBase6;
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
 * sql condition group expression4. 条件逻辑组构造器4.
 *
 * @author zhongj
 * @param <E1> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <C2> the generic type
 * @param <ER> the generic type
 * @param <B>  the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public abstract class AbstractMulitiEntitySqlExecutableConditionsGroupExpression6<E1, E2, E3, E4, E5, E6,
    C2 extends ExecutableConditionConfig<C2>, ER extends EntitySqlRelation<ER, B>, B extends SqlBuilder,
    C extends EntityExecutableConditionGroupExpression6<E1, E2, E3, E4, E5, E6, C, L, C2>,
    L extends EntityExecutableConditionGroupLogicExpression6<E1, E2, E3, E4, E5, E6, C, L, C2>>
    extends AbstractMulitiEntitySqlConditionsGroupExpressionBase6<E1, E2, E3, E4, E5, E6, ER, B, C, L, C2>
    implements EntityExecutableConditionGroupExpression6<E1, E2, E3, E4, E5, E6, C, L, C2>,
    EntityExecutableConditionGroupLogicExpression6<E1, E2, E3, E4, E5, E6, C, L, C2> {

    /**
     * Instantiates a new abstract entity sql condition group expression 2.
     *
     * @param parent        the parent
     * @param factory       the factory
     * @param queryRelation the relation
     */
    protected AbstractMulitiEntitySqlExecutableConditionsGroupExpression6(L parent, JdbcMappingFactory factory,
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
    public L lk(Consumer<Tuple6<LikeEntityExpression<E1>, LikeEntityExpression<E2>, LikeEntityExpression<E3>,
        LikeEntityExpression<E4>, LikeEntityExpression<E5>, LikeEntityExpression<E6>>> likeEntityExpressions) {
        MulitiLikeExpression<C, L> mulitiExpression = new MulitiEntityLikeExpressionImpl<>(this);
        likeEntityExpressions
            .accept(Tuples.of(new LikeEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new LikeEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new LikeEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new LikeEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
                new LikeEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
                new LikeEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lk(SixArgusConsumer<LikeEntityExpression<E1>, LikeEntityExpression<E2>, LikeEntityExpression<E3>,
        LikeEntityExpression<E4>, LikeEntityExpression<E5>, LikeEntityExpression<E6>> likeEntityExpressions) {
        MulitiLikeExpression<C, L> mulitiExpression = new MulitiEntityLikeExpressionImpl<>(this);
        likeEntityExpressions.accept(new LikeEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new LikeEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new LikeEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new LikeEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
            new LikeEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
            new LikeEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L sw(Consumer<Tuple6<StartWithEntityExpression<E1>, StartWithEntityExpression<E2>,
        StartWithEntityExpression<E3>, StartWithEntityExpression<E4>, StartWithEntityExpression<E5>,
        StartWithEntityExpression<E6>>> startWithEntityExpressions) {
        MulitiStartWithExpression<C, L> expression = new MulitiEntityStartWithExpressionImpl<>(this);
        startWithEntityExpressions
            .accept(Tuples.of(new StartWithEntityExpressionImpl<>(0, expression, factory, entityRelation),
                new StartWithEntityExpressionImpl<>(1, expression, factory, entityRelation),
                new StartWithEntityExpressionImpl<>(2, expression, factory, entityRelation),
                new StartWithEntityExpressionImpl<>(3, expression, factory, entityRelation),
                new StartWithEntityExpressionImpl<>(4, expression, factory, entityRelation),
                new StartWithEntityExpressionImpl<>(5, expression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L sw(SixArgusConsumer<StartWithEntityExpression<E1>, StartWithEntityExpression<E2>,
        StartWithEntityExpression<E3>, StartWithEntityExpression<E4>, StartWithEntityExpression<E5>,
        StartWithEntityExpression<E6>> startWithEntityExpressions) {
        MulitiStartWithExpression<C, L> expression = new MulitiEntityStartWithExpressionImpl<>(this);
        startWithEntityExpressions.accept(new StartWithEntityExpressionImpl<>(0, expression, factory, entityRelation),
            new StartWithEntityExpressionImpl<>(1, expression, factory, entityRelation),
            new StartWithEntityExpressionImpl<>(2, expression, factory, entityRelation),
            new StartWithEntityExpressionImpl<>(3, expression, factory, entityRelation),
            new StartWithEntityExpressionImpl<>(4, expression, factory, entityRelation),
            new StartWithEntityExpressionImpl<>(5, expression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ni(Consumer<Tuple6<NotInEntityExpression<E1>, NotInEntityExpression<E2>, NotInEntityExpression<E3>,
        NotInEntityExpression<E4>, NotInEntityExpression<E5>, NotInEntityExpression<E6>>> notInEntityExpressions) {
        MulitiNotInExpression<C, L> mulitiExpression = new MulitiEntityNotInExpressionImpl<>(this);
        notInEntityExpressions
            .accept(Tuples.of(new NotInEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotInEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new NotInEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new NotInEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
                new NotInEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
                new NotInEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ni(SixArgusConsumer<NotInEntityExpression<E1>, NotInEntityExpression<E2>, NotInEntityExpression<E3>,
        NotInEntityExpression<E4>, NotInEntityExpression<E5>, NotInEntityExpression<E6>> notInEntityExpressions) {
        MulitiNotInExpression<C, L> mulitiExpression = new MulitiEntityNotInExpressionImpl<>(this);
        notInEntityExpressions.accept(new NotInEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new NotInEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new NotInEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new NotInEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
            new NotInEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
            new NotInEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ne(Consumer<Tuple6<NotEqualsEntityExpression<E1>, NotEqualsEntityExpression<E2>,
        NotEqualsEntityExpression<E3>, NotEqualsEntityExpression<E4>, NotEqualsEntityExpression<E5>,
        NotEqualsEntityExpression<E6>>> notEqualsEntityExpressions) {
        MulitiNotEqualsExpression<C, L> mulitiExpression = new MulitiEntityNotEqualsExpressionImpl<>(this);
        notEqualsEntityExpressions
            .accept(Tuples.of(new NotEqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotEqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new NotEqualsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new NotEqualsEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
                new NotEqualsEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
                new NotEqualsEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ne(SixArgusConsumer<NotEqualsEntityExpression<E1>, NotEqualsEntityExpression<E2>,
        NotEqualsEntityExpression<E3>, NotEqualsEntityExpression<E4>, NotEqualsEntityExpression<E5>,
        NotEqualsEntityExpression<E6>> notEqualsEntityExpressions) {
        MulitiNotEqualsExpression<C, L> mulitiExpression = new MulitiEntityNotEqualsExpressionImpl<>(this);
        notEqualsEntityExpressions.accept(
            new NotEqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new NotEqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new NotEqualsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new NotEqualsEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
            new NotEqualsEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
            new NotEqualsEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lt(Consumer<Tuple6<LessThanEntityExpression<E1>, LessThanEntityExpression<E2>,
        LessThanEntityExpression<E3>, LessThanEntityExpression<E4>, LessThanEntityExpression<E5>,
        LessThanEntityExpression<E6>>> lessThanEntityExpressions) {
        MulitiLessThanExpression<C, L> mulitiExpression = new MulitiEntityLessThanExpressionImpl<>(this);
        lessThanEntityExpressions
            .accept(Tuples.of(new LessThanEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new LessThanEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new LessThanEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new LessThanEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
                new LessThanEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
                new LessThanEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lt(SixArgusConsumer<LessThanEntityExpression<E1>, LessThanEntityExpression<E2>,
        LessThanEntityExpression<E3>, LessThanEntityExpression<E4>, LessThanEntityExpression<E5>,
        LessThanEntityExpression<E6>> lessThanEntityExpressions) {
        MulitiLessThanExpression<C, L> mulitiExpression = new MulitiEntityLessThanExpressionImpl<>(this);
        lessThanEntityExpressions.accept(
            new LessThanEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new LessThanEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new LessThanEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new LessThanEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
            new LessThanEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
            new LessThanEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L le(Consumer<Tuple6<LessEqualsEntityExpression<E1>, LessEqualsEntityExpression<E2>,
        LessEqualsEntityExpression<E3>, LessEqualsEntityExpression<E4>, LessEqualsEntityExpression<E5>,
        LessEqualsEntityExpression<E6>>> lessEqualsEntityExpressions) {
        MulitiLessEqualsExpression<C, L> mulitiExpression = new MulitiEntityLessEqualsExpressionImpl<>(this);
        lessEqualsEntityExpressions
            .accept(Tuples.of(new LessEqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new LessEqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new LessEqualsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new LessEqualsEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
                new LessEqualsEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
                new LessEqualsEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L le(SixArgusConsumer<LessEqualsEntityExpression<E1>, LessEqualsEntityExpression<E2>,
        LessEqualsEntityExpression<E3>, LessEqualsEntityExpression<E4>, LessEqualsEntityExpression<E5>,
        LessEqualsEntityExpression<E6>> lessEqualsEntityExpressions) {
        MulitiLessEqualsExpression<C, L> mulitiExpression = new MulitiEntityLessEqualsExpressionImpl<>(this);
        lessEqualsEntityExpressions.accept(
            new LessEqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new LessEqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new LessEqualsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new LessEqualsEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
            new LessEqualsEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
            new LessEqualsEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L isn(Consumer<Tuple6<IsNullEntityExpression<E1>, IsNullEntityExpression<E2>, IsNullEntityExpression<E3>,
        IsNullEntityExpression<E4>, IsNullEntityExpression<E5>, IsNullEntityExpression<E6>>> isNullEntityExpressions) {
        MulitiIsNullExpression<C, L> mulitiExpression = new MulitiEntityIsNullExpressionImpl<>(this);
        isNullEntityExpressions
            .accept(Tuples.of(new IsNullEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new IsNullEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new IsNullEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new IsNullEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
                new IsNullEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
                new IsNullEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L isn(SixArgusConsumer<IsNullEntityExpression<E1>, IsNullEntityExpression<E2>, IsNullEntityExpression<E3>,
        IsNullEntityExpression<E4>, IsNullEntityExpression<E5>, IsNullEntityExpression<E6>> isNullEntityExpressions) {
        MulitiIsNullExpression<C, L> mulitiExpression = new MulitiEntityIsNullExpressionImpl<>(this);
        isNullEntityExpressions.accept(new IsNullEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new IsNullEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new IsNullEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new IsNullEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
            new IsNullEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
            new IsNullEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L inn(Consumer<Tuple6<IsNotNullEntityExpression<E1>, IsNotNullEntityExpression<E2>,
        IsNotNullEntityExpression<E3>, IsNotNullEntityExpression<E4>, IsNotNullEntityExpression<E5>,
        IsNotNullEntityExpression<E6>>> isNotNullEntityExpressions) {
        MulitiIsNotNullExpression<C, L> mulitiExpression = new MulitiEntityIsNotNullExpressionImpl<>(this);
        isNotNullEntityExpressions
            .accept(Tuples.of(new IsNotNullEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new IsNotNullEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new IsNotNullEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new IsNotNullEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
                new IsNotNullEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
                new IsNotNullEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L inn(SixArgusConsumer<IsNotNullEntityExpression<E1>, IsNotNullEntityExpression<E2>,
        IsNotNullEntityExpression<E3>, IsNotNullEntityExpression<E4>, IsNotNullEntityExpression<E5>,
        IsNotNullEntityExpression<E6>> isNotNullEntityExpressions) {
        MulitiIsNotNullExpression<C, L> mulitiExpression = new MulitiEntityIsNotNullExpressionImpl<>(this);
        isNotNullEntityExpressions.accept(
            new IsNotNullEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new IsNotNullEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new IsNotNullEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new IsNotNullEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
            new IsNotNullEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
            new IsNotNullEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L in(Consumer<Tuple6<InEntityExpression<E1>, InEntityExpression<E2>, InEntityExpression<E3>,
        InEntityExpression<E4>, InEntityExpression<E5>, InEntityExpression<E6>>> inEntityExpressions) {
        MulitiInExpression<C, L> mulitiExpression = new MulitiEntityInExpressionImpl<>(this);
        inEntityExpressions.accept(Tuples.of(new InEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new InEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new InEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new InEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
            new InEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
            new InEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L in(SixArgusConsumer<InEntityExpression<E1>, InEntityExpression<E2>, InEntityExpression<E3>,
        InEntityExpression<E4>, InEntityExpression<E5>, InEntityExpression<E6>> inEntityExpressions) {
        MulitiInExpression<C, L> mulitiExpression = new MulitiEntityInExpressionImpl<>(this);
        inEntityExpressions.accept(new InEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new InEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new InEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new InEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
            new InEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
            new InEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L gt(Consumer<Tuple6<GreatThanEntityExpression<E1>, GreatThanEntityExpression<E2>,
        GreatThanEntityExpression<E3>, GreatThanEntityExpression<E4>, GreatThanEntityExpression<E5>,
        GreatThanEntityExpression<E6>>> greatThanEntityExpressions) {
        MulitiGreatThanExpression<C, L> mulitiExpression = new MulitiEntityGreatThanExpressionImpl<>(this);
        greatThanEntityExpressions
            .accept(Tuples.of(new GreatThanEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new GreatThanEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new GreatThanEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new GreatThanEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
                new GreatThanEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
                new GreatThanEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L gt(SixArgusConsumer<GreatThanEntityExpression<E1>, GreatThanEntityExpression<E2>,
        GreatThanEntityExpression<E3>, GreatThanEntityExpression<E4>, GreatThanEntityExpression<E5>,
        GreatThanEntityExpression<E6>> greatThanEntityExpressions) {
        MulitiGreatThanExpression<C, L> mulitiExpression = new MulitiEntityGreatThanExpressionImpl<>(this);
        greatThanEntityExpressions.accept(
            new GreatThanEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new GreatThanEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new GreatThanEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new GreatThanEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
            new GreatThanEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
            new GreatThanEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ge(Consumer<Tuple6<GreatEqualsEntityExpression<E1>, GreatEqualsEntityExpression<E2>,
        GreatEqualsEntityExpression<E3>, GreatEqualsEntityExpression<E4>, GreatEqualsEntityExpression<E5>,
        GreatEqualsEntityExpression<E6>>> greatEqualsEntityExpressions) {
        MulitiGreatEqualsExpression<C, L> mulitiExpression = new MulitiEntityGreatEqualsExpressionImpl<>(this);
        greatEqualsEntityExpressions
            .accept(Tuples.of(new GreatEqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new GreatEqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new GreatEqualsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new GreatEqualsEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
                new GreatEqualsEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
                new GreatEqualsEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ge(SixArgusConsumer<GreatEqualsEntityExpression<E1>, GreatEqualsEntityExpression<E2>,
        GreatEqualsEntityExpression<E3>, GreatEqualsEntityExpression<E4>, GreatEqualsEntityExpression<E5>,
        GreatEqualsEntityExpression<E6>> greatEqualsEntityExpressions) {
        MulitiGreatEqualsExpression<C, L> mulitiExpression = new MulitiEntityGreatEqualsExpressionImpl<>(this);
        greatEqualsEntityExpressions.accept(
            new GreatEqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new GreatEqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new GreatEqualsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new GreatEqualsEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
            new GreatEqualsEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
            new GreatEqualsEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L eq(Consumer<Tuple6<EqualsEntityExpression<E1>, EqualsEntityExpression<E2>, EqualsEntityExpression<E3>,
        EqualsEntityExpression<E4>, EqualsEntityExpression<E5>, EqualsEntityExpression<E6>>> equalsEntityExpressions) {
        MulitiEqualsExpression<C, L> mulitiExpression = new MulitiEntityEqualsExpressionImpl<>(this);
        equalsEntityExpressions
            .accept(Tuples.of(new EqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new EqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new EqualsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new EqualsEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
                new EqualsEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
                new EqualsEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L eq(SixArgusConsumer<EqualsEntityExpression<E1>, EqualsEntityExpression<E2>, EqualsEntityExpression<E3>,
        EqualsEntityExpression<E4>, EqualsEntityExpression<E5>, EqualsEntityExpression<E6>> equalsEntityExpressions) {
        MulitiEqualsExpression<C, L> mulitiExpression = new MulitiEntityEqualsExpressionImpl<>(this);
        equalsEntityExpressions.accept(new EqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new EqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new EqualsEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new EqualsEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
            new EqualsEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
            new EqualsEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ew(Consumer<Tuple6<EndWithEntityExpression<E1>, EndWithEntityExpression<E2>, EndWithEntityExpression<E3>,
        EndWithEntityExpression<E4>, EndWithEntityExpression<E5>,
        EndWithEntityExpression<E6>>> endWithEntityExpressions) {
        MulitiEndWithExpression<C, L> mulitiExpression = new MulitiEntityEndWithExpressionImpl<>(this);
        endWithEntityExpressions
            .accept(Tuples.of(new EndWithEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new EndWithEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new EndWithEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new EndWithEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
                new EndWithEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
                new EndWithEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ew(SixArgusConsumer<EndWithEntityExpression<E1>, EndWithEntityExpression<E2>, EndWithEntityExpression<E3>,
        EndWithEntityExpression<E4>, EndWithEntityExpression<E5>,
        EndWithEntityExpression<E6>> endWithEntityExpressions) {
        MulitiEndWithExpression<C, L> mulitiExpression = new MulitiEntityEndWithExpressionImpl<>(this);
        endWithEntityExpressions.accept(new EndWithEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new EndWithEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new EndWithEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new EndWithEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
            new EndWithEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
            new EndWithEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L co(Consumer<Tuple6<ContainsEntityExpression<E1>, ContainsEntityExpression<E2>,
        ContainsEntityExpression<E3>, ContainsEntityExpression<E4>, ContainsEntityExpression<E5>,
        ContainsEntityExpression<E6>>> containsEntityExpressions) {
        MulitiContainsExpression<C, L> mulitiEntityContainsExpression = new MulitiEntityContainsExpressionImpl<>(this);
        containsEntityExpressions.accept(
            Tuples.of(new ContainsEntityExpressionImpl<>(0, mulitiEntityContainsExpression, factory, entityRelation),
                new ContainsEntityExpressionImpl<>(1, mulitiEntityContainsExpression, factory, entityRelation),
                new ContainsEntityExpressionImpl<>(2, mulitiEntityContainsExpression, factory, entityRelation),
                new ContainsEntityExpressionImpl<>(3, mulitiEntityContainsExpression, factory, entityRelation),
                new ContainsEntityExpressionImpl<>(4, mulitiEntityContainsExpression, factory, entityRelation),
                new ContainsEntityExpressionImpl<>(5, mulitiEntityContainsExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L co(SixArgusConsumer<ContainsEntityExpression<E1>, ContainsEntityExpression<E2>,
        ContainsEntityExpression<E3>, ContainsEntityExpression<E4>, ContainsEntityExpression<E5>,
        ContainsEntityExpression<E6>> containsEntityExpressions) {
        MulitiContainsExpression<C, L> mulitiEntityContainsExpression = new MulitiEntityContainsExpressionImpl<>(this);
        containsEntityExpressions.accept(
            new ContainsEntityExpressionImpl<>(0, mulitiEntityContainsExpression, factory, entityRelation),
            new ContainsEntityExpressionImpl<>(1, mulitiEntityContainsExpression, factory, entityRelation),
            new ContainsEntityExpressionImpl<>(2, mulitiEntityContainsExpression, factory, entityRelation),
            new ContainsEntityExpressionImpl<>(3, mulitiEntityContainsExpression, factory, entityRelation),
            new ContainsEntityExpressionImpl<>(4, mulitiEntityContainsExpression, factory, entityRelation),
            new ContainsEntityExpressionImpl<>(5, mulitiEntityContainsExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ba(Consumer<Tuple6<BetweenEntityExpression<E1>, BetweenEntityExpression<E2>, BetweenEntityExpression<E3>,
        BetweenEntityExpression<E4>, BetweenEntityExpression<E5>,
        BetweenEntityExpression<E6>>> betweenEntityExpressions) {
        MulitiBetweenExpression<C, L> mulitiExpression = new MulitiEntityBetweenExpressionImpl<>(this);
        betweenEntityExpressions
            .accept(Tuples.of(new BetweenEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new BetweenEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new BetweenEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new BetweenEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
                new BetweenEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
                new BetweenEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ba(SixArgusConsumer<BetweenEntityExpression<E1>, BetweenEntityExpression<E2>, BetweenEntityExpression<E3>,
        BetweenEntityExpression<E4>, BetweenEntityExpression<E5>,
        BetweenEntityExpression<E6>> betweenEntityExpressions) {
        MulitiBetweenExpression<C, L> mulitiExpression = new MulitiEntityBetweenExpressionImpl<>(this);
        betweenEntityExpressions.accept(new BetweenEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new BetweenEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new BetweenEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new BetweenEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
            new BetweenEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
            new BetweenEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nba(Consumer<Tuple6<NotBetweenEntityExpression<E1>, NotBetweenEntityExpression<E2>,
        NotBetweenEntityExpression<E3>, NotBetweenEntityExpression<E4>, NotBetweenEntityExpression<E5>,
        NotBetweenEntityExpression<E6>>> notBetweenEntityExpressions) {
        MulitiNotBetweenExpression<C, L> mulitiExpression = new MulitiEntityNotBetweenExpressionImpl<>(this);
        notBetweenEntityExpressions
            .accept(Tuples.of(new NotBetweenEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotBetweenEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new NotBetweenEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new NotBetweenEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
                new NotBetweenEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
                new NotBetweenEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nba(SixArgusConsumer<NotBetweenEntityExpression<E1>, NotBetweenEntityExpression<E2>,
        NotBetweenEntityExpression<E3>, NotBetweenEntityExpression<E4>, NotBetweenEntityExpression<E5>,
        NotBetweenEntityExpression<E6>> notBetweenEntityExpressions) {
        MulitiNotBetweenExpression<C, L> mulitiExpression = new MulitiEntityNotBetweenExpressionImpl<>(this);
        notBetweenEntityExpressions.accept(
            new NotBetweenEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new NotBetweenEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new NotBetweenEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new NotBetweenEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
            new NotBetweenEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
            new NotBetweenEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nco(Consumer<Tuple6<NotContainsEntityExpression<E1>, NotContainsEntityExpression<E2>,
        NotContainsEntityExpression<E3>, NotContainsEntityExpression<E4>, NotContainsEntityExpression<E5>,
        NotContainsEntityExpression<E6>>> notContainsEntityExpressions) {
        MulitiNotContainsExpression<C,
            L> mulitiEntityContainsExpression = new MulitiEntityNotContainsExpressionImpl<>(this);
        notContainsEntityExpressions.accept(
            Tuples.of(new NotContainsEntityExpressionImpl<>(0, mulitiEntityContainsExpression, factory, entityRelation),
                new NotContainsEntityExpressionImpl<>(1, mulitiEntityContainsExpression, factory, entityRelation),
                new NotContainsEntityExpressionImpl<>(2, mulitiEntityContainsExpression, factory, entityRelation),
                new NotContainsEntityExpressionImpl<>(3, mulitiEntityContainsExpression, factory, entityRelation),
                new NotContainsEntityExpressionImpl<>(4, mulitiEntityContainsExpression, factory, entityRelation),
                new NotContainsEntityExpressionImpl<>(5, mulitiEntityContainsExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nco(SixArgusConsumer<NotContainsEntityExpression<E1>, NotContainsEntityExpression<E2>,
        NotContainsEntityExpression<E3>, NotContainsEntityExpression<E4>, NotContainsEntityExpression<E5>,
        NotContainsEntityExpression<E6>> notContainsEntityExpressions) {
        MulitiNotContainsExpression<C,
            L> mulitiEntityContainsExpression = new MulitiEntityNotContainsExpressionImpl<>(this);
        notContainsEntityExpressions.accept(
            new NotContainsEntityExpressionImpl<>(0, mulitiEntityContainsExpression, factory, entityRelation),
            new NotContainsEntityExpressionImpl<>(1, mulitiEntityContainsExpression, factory, entityRelation),
            new NotContainsEntityExpressionImpl<>(2, mulitiEntityContainsExpression, factory, entityRelation),
            new NotContainsEntityExpressionImpl<>(3, mulitiEntityContainsExpression, factory, entityRelation),
            new NotContainsEntityExpressionImpl<>(4, mulitiEntityContainsExpression, factory, entityRelation),
            new NotContainsEntityExpressionImpl<>(5, mulitiEntityContainsExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L newv(Consumer<Tuple6<NotEndWithEntityExpression<E1>, NotEndWithEntityExpression<E2>,
        NotEndWithEntityExpression<E3>, NotEndWithEntityExpression<E4>, NotEndWithEntityExpression<E5>,
        NotEndWithEntityExpression<E6>>> notEndWithEntityExpressions) {
        MulitiNotEndWithExpression<C, L> mulitiExpression = new MulitiEntityNotEndWithExpressionImpl<>(this);
        notEndWithEntityExpressions
            .accept(Tuples.of(new NotEndWithEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotEndWithEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new NotEndWithEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new NotEndWithEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
                new NotEndWithEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
                new NotEndWithEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L newv(SixArgusConsumer<NotEndWithEntityExpression<E1>, NotEndWithEntityExpression<E2>,
        NotEndWithEntityExpression<E3>, NotEndWithEntityExpression<E4>, NotEndWithEntityExpression<E5>,
        NotEndWithEntityExpression<E6>> notEndWithEntityExpressions) {
        MulitiNotEndWithExpression<C, L> mulitiExpression = new MulitiEntityNotEndWithExpressionImpl<>(this);
        notEndWithEntityExpressions.accept(
            new NotEndWithEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new NotEndWithEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new NotEndWithEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new NotEndWithEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
            new NotEndWithEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
            new NotEndWithEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nsw(Consumer<Tuple6<NotStartWithEntityExpression<E1>, NotStartWithEntityExpression<E2>,
        NotStartWithEntityExpression<E3>, NotStartWithEntityExpression<E4>, NotStartWithEntityExpression<E5>,
        NotStartWithEntityExpression<E6>>> notStartWithEntityExpressions) {
        MulitiNotStartWithExpression<C, L> mulitiExpression = new MulitiEntityNotStartWithExpressionImpl<>(this);
        notStartWithEntityExpressions
            .accept(Tuples.of(new NotStartWithEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotStartWithEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new NotStartWithEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new NotStartWithEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
                new NotStartWithEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
                new NotStartWithEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nsw(SixArgusConsumer<NotStartWithEntityExpression<E1>, NotStartWithEntityExpression<E2>,
        NotStartWithEntityExpression<E3>, NotStartWithEntityExpression<E4>, NotStartWithEntityExpression<E5>,
        NotStartWithEntityExpression<E6>> notStartWithEntityExpressions) {
        MulitiNotStartWithExpression<C, L> mulitiExpression = new MulitiEntityNotStartWithExpressionImpl<>(this);
        notStartWithEntityExpressions.accept(
            new NotStartWithEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new NotStartWithEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new NotStartWithEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new NotStartWithEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
            new NotStartWithEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
            new NotStartWithEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nl(Consumer<Tuple6<NotLikeEntityExpression<E1>, NotLikeEntityExpression<E2>, NotLikeEntityExpression<E3>,
        NotLikeEntityExpression<E4>, NotLikeEntityExpression<E5>,
        NotLikeEntityExpression<E6>>> notLikeEntityExpressions) {
        MulitiNotLikeExpression<C, L> mulitiExpression = new MulitiEntityNotLikeExpressionImpl<>(this);
        notLikeEntityExpressions
            .accept(Tuples.of(new NotLikeEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotLikeEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
                new NotLikeEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
                new NotLikeEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
                new NotLikeEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
                new NotLikeEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nl(SixArgusConsumer<NotLikeEntityExpression<E1>, NotLikeEntityExpression<E2>, NotLikeEntityExpression<E3>,
        NotLikeEntityExpression<E4>, NotLikeEntityExpression<E5>,
        NotLikeEntityExpression<E6>> notLikeEntityExpressions) {
        MulitiNotLikeExpression<C, L> mulitiExpression = new MulitiEntityNotLikeExpressionImpl<>(this);
        notLikeEntityExpressions.accept(new NotLikeEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
            new NotLikeEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation),
            new NotLikeEntityExpressionImpl<>(2, mulitiExpression, factory, entityRelation),
            new NotLikeEntityExpressionImpl<>(3, mulitiExpression, factory, entityRelation),
            new NotLikeEntityExpressionImpl<>(4, mulitiExpression, factory, entityRelation),
            new NotLikeEntityExpressionImpl<>(5, mulitiExpression, factory, entityRelation));
        return (L) this;
    }
}
