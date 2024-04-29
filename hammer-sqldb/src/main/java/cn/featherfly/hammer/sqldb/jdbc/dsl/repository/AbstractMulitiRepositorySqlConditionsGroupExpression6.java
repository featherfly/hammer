
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository;

import java.util.function.Consumer;
import java.util.function.Predicate;

import com.speedment.common.tuple.Tuple6;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.common.function.SixArgusFunction;
import cn.featherfly.common.lang.Console;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.LogicExpression;
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
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupExpression6;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupLogicExpression6;
import cn.featherfly.hammer.expression.repository.condition.ba.BetweenRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.co.ContainsRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.eq.EqualsRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.ew.EndWithRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.condition.ge.GreatEqualsRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.gt.GreatThanRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.in.InRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.inn.IsNotNullRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.isn.IsNullRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.le.LessEqualsRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.lk.LikeRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.lt.LessThanRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.nba.NotBetweenRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.nco.NotContainsRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.ne.NotEqualsRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.newv.NotEndWithRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.ni.NotInRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.nl.NotLikeRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.nsw.NotStartWithRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.sw.StartWithRepositoryExpression;
import cn.featherfly.hammer.sqldb.Constants;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.ba.BetweenRepositoryExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.ba.MulitiRepositoryBetweenExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.co.ContainsRepositoryExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.co.MulitiRepositoryContainsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.eq.EqualsRepositoryExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.eq.MulitiRepositoryEqualsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.ew.EndWithRepositoryExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.ew.MulitiRepositoryEndWithExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.RepositoryFieldOnlyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.ge.GreatEqualsRepositoryExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.ge.MulitiRepositoryGreatEqualsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.gt.GreatThanRepositoryExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.gt.MulitiRepositoryGreatThanExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.in.InRepositoryExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.in.MulitiRepositoryInExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.inn.IsNotNullRepositoryExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.inn.MulitiRepositoryIsNotNullExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.isn.IsNullRepositoryExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.isn.MulitiRepositoryIsNullExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.le.LessEqualsRepositoryExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.le.MulitiRepositoryLessEqualsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.lk.LikeRepositoryExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.lk.MulitiRepositoryLikeExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.lt.LessThanRepositoryExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.lt.MulitiRepositoryLessThanExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.nba.MulitiRepositoryNotBetweenExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.nba.NotBetweenRepositoryExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.nco.MulitiRepositoryNotContainsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.nco.NotContainsRepositoryExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.ne.MulitiRepositoryNotEqualsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.ne.NotEqualsRepositoryExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.newv.MulitiRepositoryNotEndWithExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.newv.NotEndWithRepositoryExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.ni.MulitiRepositoryNotInExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.ni.NotInRepositoryExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.nl.MulitiRepositoryNotLikeExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.nl.NotLikeRepositoryExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.nsw.MulitiRepositoryNotStartWithExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.nsw.NotStartWithRepositoryExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.sw.MulitiRepositoryStartWithExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.sw.StartWithRepositoryExpressionImpl;

/**
 * abstract muliti repository sql conditions group expression6.
 *
 * @author zhongj
 * @param <C>  condition expression
 * @param <L>  logic expression
 * @param <C2> condition config
 * @param <S>  repository sql relation
 * @param <B>  sql builder
 */
public abstract class AbstractMulitiRepositorySqlConditionsGroupExpression6<
    C extends RepositoryConditionsGroupExpression6<C, L>, L extends RepositoryConditionsGroupLogicExpression6<C, L>,
    C2 extends ConditionConfig<C2>, S extends RepositorySqlRelation<S, B>, B extends SqlBuilder> extends
    AbstractMulitiRepositorySqlConditionsGroupExpressionBase6<C, L,
        Tuple6<Integer, Integer, Integer, Integer, Integer, Integer>, C2, S, B>
    implements RepositoryConditionsGroupExpression6<C, L>, RepositoryConditionsGroupLogicExpression6<C, L> {

    /**
     * Instantiates a new abstract muliti repository sql conditions group
     * expression base 6.
     *
     * @param parent             the parent
     * @param index              the index
     * @param repositoryRelation the repository relation
     */
    protected AbstractMulitiRepositorySqlConditionsGroupExpression6(L parent, int index, S repositoryRelation) {
        super(parent, index, repositoryRelation);
        if (Constants.DEBUG) {
            Console.log("{} end at time {}", this.getClass().getName(), System.currentTimeMillis());
        }
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L field(SixArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
        RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
        RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoiesFieldFunction) {
        return (L) addCondition(
            repositoiesFieldFunction.apply(new RepositoryFieldOnlyExpressionImpl<>(0, repositoryRelation),
                new RepositoryFieldOnlyExpressionImpl<>(1, repositoryRelation),
                new RepositoryFieldOnlyExpressionImpl<>(2, repositoryRelation),
                new RepositoryFieldOnlyExpressionImpl<>(3, repositoryRelation),
                new RepositoryFieldOnlyExpressionImpl<>(4, repositoryRelation),
                new RepositoryFieldOnlyExpressionImpl<>(5, repositoryRelation)));
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L co(Consumer<Tuple6<ContainsRepositoryExpression, ContainsRepositoryExpression,
        ContainsRepositoryExpression, ContainsRepositoryExpression, ContainsRepositoryExpression,
        ContainsRepositoryExpression>> containsRepositoryExpressions) {
        MulitiContainsExpression<C, L> mulitiExp = new MulitiRepositoryContainsExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        containsRepositoryExpressions
            .accept(Tuples.of(new ContainsRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
                new ContainsRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
                new ContainsRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
                new ContainsRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
                new ContainsRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
                new ContainsRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L co(SixArgusConsumer<ContainsRepositoryExpression, ContainsRepositoryExpression,
        ContainsRepositoryExpression, ContainsRepositoryExpression, ContainsRepositoryExpression,
        ContainsRepositoryExpression> containsRepositoryExpressions) {
        MulitiContainsExpression<C, L> mulitiExp = new MulitiRepositoryContainsExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        containsRepositoryExpressions.accept(new ContainsRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new ContainsRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new ContainsRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new ContainsRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new ContainsRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new ContainsRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nco(Consumer<Tuple6<NotContainsRepositoryExpression, NotContainsRepositoryExpression,
        NotContainsRepositoryExpression, NotContainsRepositoryExpression, NotContainsRepositoryExpression,
        NotContainsRepositoryExpression>> notContainsRepositoryExpressions) {
        MulitiNotContainsExpression<C, L> mulitiExp = new MulitiRepositoryNotContainsExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        notContainsRepositoryExpressions
            .accept(Tuples.of(new NotContainsRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
                new NotContainsRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
                new NotContainsRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
                new NotContainsRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
                new NotContainsRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
                new NotContainsRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nco(SixArgusConsumer<NotContainsRepositoryExpression, NotContainsRepositoryExpression,
        NotContainsRepositoryExpression, NotContainsRepositoryExpression, NotContainsRepositoryExpression,
        NotContainsRepositoryExpression> notContainsRepositoryExpressions) {
        MulitiNotContainsExpression<C, L> mulitiExp = new MulitiRepositoryNotContainsExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        notContainsRepositoryExpressions.accept(new NotContainsRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new NotContainsRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new NotContainsRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new NotContainsRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new NotContainsRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new NotContainsRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L eq(Consumer<Tuple6<EqualsRepositoryExpression, EqualsRepositoryExpression, EqualsRepositoryExpression,
        EqualsRepositoryExpression, EqualsRepositoryExpression,
        EqualsRepositoryExpression>> equalsRepositoryExpressions) {
        MulitiEqualsExpression<C, L> mulitiExp = new MulitiRepositoryEqualsExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        equalsRepositoryExpressions.accept(Tuples.of(new EqualsRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new EqualsRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new EqualsRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new EqualsRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new EqualsRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new EqualsRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L eq(SixArgusConsumer<EqualsRepositoryExpression, EqualsRepositoryExpression, EqualsRepositoryExpression,
        EqualsRepositoryExpression, EqualsRepositoryExpression,
        EqualsRepositoryExpression> equalsRepositoryExpressions) {
        MulitiEqualsExpression<C, L> mulitiExp = new MulitiRepositoryEqualsExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        equalsRepositoryExpressions.accept(new EqualsRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new EqualsRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new EqualsRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new EqualsRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new EqualsRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new EqualsRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ne(Consumer<Tuple6<NotEqualsRepositoryExpression, NotEqualsRepositoryExpression,
        NotEqualsRepositoryExpression, NotEqualsRepositoryExpression, NotEqualsRepositoryExpression,
        NotEqualsRepositoryExpression>> notEqualsRepositoryExpressions) {
        MulitiNotEqualsExpression<C, L> mulitiExp = new MulitiRepositoryNotEqualsExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        notEqualsRepositoryExpressions
            .accept(Tuples.of(new NotEqualsRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
                new NotEqualsRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
                new NotEqualsRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
                new NotEqualsRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
                new NotEqualsRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
                new NotEqualsRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ne(SixArgusConsumer<NotEqualsRepositoryExpression, NotEqualsRepositoryExpression,
        NotEqualsRepositoryExpression, NotEqualsRepositoryExpression, NotEqualsRepositoryExpression,
        NotEqualsRepositoryExpression> notEqualsRepositoryExpressions) {
        MulitiNotEqualsExpression<C, L> mulitiExp = new MulitiRepositoryNotEqualsExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        notEqualsRepositoryExpressions.accept(new NotEqualsRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new NotEqualsRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new NotEqualsRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new NotEqualsRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new NotEqualsRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new NotEqualsRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L isn(Consumer<Tuple6<IsNullRepositoryExpression, IsNullRepositoryExpression, IsNullRepositoryExpression,
        IsNullRepositoryExpression, IsNullRepositoryExpression,
        IsNullRepositoryExpression>> isNullRepositoryExpressions) {
        MulitiIsNullExpression<C, L> mulitiExp = new MulitiRepositoryIsNullExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        isNullRepositoryExpressions.accept(Tuples.of(new IsNullRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new IsNullRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new IsNullRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new IsNullRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new IsNullRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new IsNullRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L isn(SixArgusConsumer<IsNullRepositoryExpression, IsNullRepositoryExpression, IsNullRepositoryExpression,
        IsNullRepositoryExpression, IsNullRepositoryExpression,
        IsNullRepositoryExpression> isNullRepositoryExpressions) {
        MulitiIsNullExpression<C, L> mulitiExp = new MulitiRepositoryIsNullExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        isNullRepositoryExpressions.accept(new IsNullRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new IsNullRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new IsNullRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new IsNullRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new IsNullRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new IsNullRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public L inn(Consumer<Tuple6<IsNotNullRepositoryExpression, IsNotNullRepositoryExpression,
        IsNotNullRepositoryExpression, IsNotNullRepositoryExpression, IsNotNullRepositoryExpression,
        IsNotNullRepositoryExpression>> isNotNullExpressions) {
        MulitiIsNotNullExpression<C, L> mulitiExp = new MulitiRepositoryIsNotNullExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        isNotNullExpressions.accept(Tuples.of(new IsNotNullRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new IsNotNullRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new IsNotNullRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new IsNotNullRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new IsNotNullRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new IsNotNullRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public L inn(SixArgusConsumer<IsNotNullRepositoryExpression, IsNotNullRepositoryExpression,
        IsNotNullRepositoryExpression, IsNotNullRepositoryExpression, IsNotNullRepositoryExpression,
        IsNotNullRepositoryExpression> isNotNullExpressions) {
        MulitiIsNotNullExpression<C, L> mulitiExp = new MulitiRepositoryIsNotNullExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        isNotNullExpressions.accept(new IsNotNullRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new IsNotNullRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new IsNotNullRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new IsNotNullRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new IsNotNullRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new IsNotNullRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ew(Consumer<Tuple6<EndWithRepositoryExpression, EndWithRepositoryExpression, EndWithRepositoryExpression,
        EndWithRepositoryExpression, EndWithRepositoryExpression, EndWithRepositoryExpression>> endWithExpressions) {
        MulitiEndWithExpression<C, L> mulitiExp = new MulitiRepositoryEndWithExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        endWithExpressions.accept(Tuples.of(new EndWithRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new EndWithRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new EndWithRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new EndWithRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new EndWithRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new EndWithRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ew(SixArgusConsumer<EndWithRepositoryExpression, EndWithRepositoryExpression, EndWithRepositoryExpression,
        EndWithRepositoryExpression, EndWithRepositoryExpression, EndWithRepositoryExpression> endWithExpressions) {
        MulitiEndWithExpression<C, L> mulitiExp = new MulitiRepositoryEndWithExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        endWithExpressions.accept(new EndWithRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new EndWithRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new EndWithRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new EndWithRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new EndWithRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new EndWithRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L newv(Consumer<Tuple6<NotEndWithRepositoryExpression, NotEndWithRepositoryExpression,
        NotEndWithRepositoryExpression, NotEndWithRepositoryExpression, NotEndWithRepositoryExpression,
        NotEndWithRepositoryExpression>> notEndWithExpressions) {
        MulitiNotEndWithExpression<C, L> mulitiExp = new MulitiRepositoryNotEndWithExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        notEndWithExpressions.accept(Tuples.of(new NotEndWithRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new NotEndWithRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new NotEndWithRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new NotEndWithRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new NotEndWithRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new NotEndWithRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L newv(SixArgusConsumer<NotEndWithRepositoryExpression, NotEndWithRepositoryExpression,
        NotEndWithRepositoryExpression, NotEndWithRepositoryExpression, NotEndWithRepositoryExpression,
        NotEndWithRepositoryExpression> notEndWithExpressions) {
        MulitiNotEndWithExpression<C, L> mulitiExp = new MulitiRepositoryNotEndWithExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        notEndWithExpressions.accept(new NotEndWithRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new NotEndWithRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new NotEndWithRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new NotEndWithRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new NotEndWithRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new NotEndWithRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public L sw(Consumer<Tuple6<StartWithRepositoryExpression, StartWithRepositoryExpression,
        StartWithRepositoryExpression, StartWithRepositoryExpression, StartWithRepositoryExpression,
        StartWithRepositoryExpression>> startWithExpressions) {
        MulitiStartWithExpression<C, L> mulitiExp = new MulitiRepositoryStartWithExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        startWithExpressions.accept(Tuples.of(new StartWithRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new StartWithRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new StartWithRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new StartWithRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new StartWithRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new StartWithRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public L sw(SixArgusConsumer<StartWithRepositoryExpression, StartWithRepositoryExpression,
        StartWithRepositoryExpression, StartWithRepositoryExpression, StartWithRepositoryExpression,
        StartWithRepositoryExpression> startWithExpressions) {
        MulitiStartWithExpression<C, L> mulitiExp = new MulitiRepositoryStartWithExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        startWithExpressions.accept(new StartWithRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new StartWithRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new StartWithRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new StartWithRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new StartWithRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new StartWithRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nsw(Consumer<Tuple6<NotStartWithRepositoryExpression, NotStartWithRepositoryExpression,
        NotStartWithRepositoryExpression, NotStartWithRepositoryExpression, NotStartWithRepositoryExpression,
        NotStartWithRepositoryExpression>> notStartWithExpressions) {
        MulitiNotStartWithExpression<C, L> mulitiExp = new MulitiRepositoryNotStartWithExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        notStartWithExpressions
            .accept(Tuples.of(new NotStartWithRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
                new NotStartWithRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
                new NotStartWithRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
                new NotStartWithRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
                new NotStartWithRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
                new NotStartWithRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nsw(SixArgusConsumer<NotStartWithRepositoryExpression, NotStartWithRepositoryExpression,
        NotStartWithRepositoryExpression, NotStartWithRepositoryExpression, NotStartWithRepositoryExpression,
        NotStartWithRepositoryExpression> notStartWithExpressions) {
        MulitiNotStartWithExpression<C, L> mulitiExp = new MulitiRepositoryNotStartWithExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        notStartWithExpressions.accept(new NotStartWithRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new NotStartWithRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new NotStartWithRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new NotStartWithRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new NotStartWithRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new NotStartWithRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lk(Consumer<Tuple6<LikeRepositoryExpression, LikeRepositoryExpression, LikeRepositoryExpression,
        LikeRepositoryExpression, LikeRepositoryExpression, LikeRepositoryExpression>> likeExpressions) {
        MulitiLikeExpression<C, L> mulitiExp = new MulitiRepositoryLikeExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        likeExpressions.accept(Tuples.of(new LikeRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new LikeRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new LikeRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new LikeRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new LikeRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new LikeRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lk(SixArgusConsumer<LikeRepositoryExpression, LikeRepositoryExpression, LikeRepositoryExpression,
        LikeRepositoryExpression, LikeRepositoryExpression, LikeRepositoryExpression> likeExpressions) {
        MulitiLikeExpression<C, L> mulitiExp = new MulitiRepositoryLikeExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        likeExpressions.accept(new LikeRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new LikeRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new LikeRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new LikeRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new LikeRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new LikeRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nl(Consumer<Tuple6<NotLikeRepositoryExpression, NotLikeRepositoryExpression, NotLikeRepositoryExpression,
        NotLikeRepositoryExpression, NotLikeRepositoryExpression, NotLikeRepositoryExpression>> notLikeExpressions) {
        MulitiNotLikeExpression<C, L> mulitiExp = new MulitiRepositoryNotLikeExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        notLikeExpressions.accept(Tuples.of(new NotLikeRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new NotLikeRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new NotLikeRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new NotLikeRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new NotLikeRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new NotLikeRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nl(SixArgusConsumer<NotLikeRepositoryExpression, NotLikeRepositoryExpression, NotLikeRepositoryExpression,
        NotLikeRepositoryExpression, NotLikeRepositoryExpression, NotLikeRepositoryExpression> notLikeExpressions) {
        MulitiNotLikeExpression<C, L> mulitiExp = new MulitiRepositoryNotLikeExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        notLikeExpressions.accept(new NotLikeRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new NotLikeRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new NotLikeRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new NotLikeRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new NotLikeRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new NotLikeRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ba(Consumer<Tuple6<BetweenRepositoryExpression, BetweenRepositoryExpression, BetweenRepositoryExpression,
        BetweenRepositoryExpression, BetweenRepositoryExpression, BetweenRepositoryExpression>> betweenExpressions) {
        MulitiBetweenExpression<C, L> mulitiExp = new MulitiRepositoryBetweenExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        betweenExpressions.accept(Tuples.of(new BetweenRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new BetweenRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new BetweenRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new BetweenRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new BetweenRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new BetweenRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ba(SixArgusConsumer<BetweenRepositoryExpression, BetweenRepositoryExpression, BetweenRepositoryExpression,
        BetweenRepositoryExpression, BetweenRepositoryExpression, BetweenRepositoryExpression> betweenExpressions) {
        MulitiBetweenExpression<C, L> mulitiExp = new MulitiRepositoryBetweenExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        betweenExpressions.accept(new BetweenRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new BetweenRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new BetweenRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new BetweenRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new BetweenRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new BetweenRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nba(Consumer<Tuple6<NotBetweenRepositoryExpression, NotBetweenRepositoryExpression,
        NotBetweenRepositoryExpression, NotBetweenRepositoryExpression, NotBetweenRepositoryExpression,
        NotBetweenRepositoryExpression>> notBetweenExpressions) {
        MulitiNotBetweenExpression<C, L> mulitiExp = new MulitiRepositoryNotBetweenExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        notBetweenExpressions.accept(Tuples.of(new NotBetweenRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new NotBetweenRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new NotBetweenRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new NotBetweenRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new NotBetweenRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new NotBetweenRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nba(SixArgusConsumer<NotBetweenRepositoryExpression, NotBetweenRepositoryExpression,
        NotBetweenRepositoryExpression, NotBetweenRepositoryExpression, NotBetweenRepositoryExpression,
        NotBetweenRepositoryExpression> notBetweenExpressions) {
        MulitiNotBetweenExpression<C, L> mulitiExp = new MulitiRepositoryNotBetweenExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        notBetweenExpressions.accept(new NotBetweenRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new NotBetweenRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new NotBetweenRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new NotBetweenRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new NotBetweenRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new NotBetweenRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L in(Consumer<Tuple6<InRepositoryExpression, InRepositoryExpression, InRepositoryExpression,
        InRepositoryExpression, InRepositoryExpression, InRepositoryExpression>> inExpressions) {
        MulitiInExpression<C, L> mulitiExp = new MulitiRepositoryInExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        inExpressions.accept(Tuples.of(new InRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new InRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new InRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new InRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new InRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new InRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L in(SixArgusConsumer<InRepositoryExpression, InRepositoryExpression, InRepositoryExpression,
        InRepositoryExpression, InRepositoryExpression, InRepositoryExpression> inExpressions) {
        MulitiInExpression<C, L> mulitiExp = new MulitiRepositoryInExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        inExpressions.accept(new InRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new InRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new InRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new InRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new InRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new InRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ni(Consumer<Tuple6<NotInRepositoryExpression, NotInRepositoryExpression, NotInRepositoryExpression,
        NotInRepositoryExpression, NotInRepositoryExpression, NotInRepositoryExpression>> notInExpressions) {
        MulitiNotInExpression<C, L> mulitiExp = new MulitiRepositoryNotInExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        notInExpressions.accept(Tuples.of(new NotInRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new NotInRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new NotInRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new NotInRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new NotInRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new NotInRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ni(SixArgusConsumer<NotInRepositoryExpression, NotInRepositoryExpression, NotInRepositoryExpression,
        NotInRepositoryExpression, NotInRepositoryExpression, NotInRepositoryExpression> notInExpressions) {
        MulitiNotInExpression<C, L> mulitiExp = new MulitiRepositoryNotInExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        notInExpressions.accept(new NotInRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new NotInRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new NotInRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new NotInRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new NotInRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new NotInRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ge(Consumer<Tuple6<GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression,
        GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression,
        GreatEqualsRepositoryExpression>> greatEqualsExpressions) {
        MulitiGreatEqualsExpression<C, L> mulitiExp = new MulitiRepositoryGreatEqualsExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        greatEqualsExpressions.accept(Tuples.of(new GreatEqualsRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new GreatEqualsRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new GreatEqualsRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new GreatEqualsRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new GreatEqualsRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new GreatEqualsRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ge(SixArgusConsumer<GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression,
        GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression, GreatEqualsRepositoryExpression,
        GreatEqualsRepositoryExpression> greatEqualsExpressions) {
        MulitiGreatEqualsExpression<C, L> mulitiExp = new MulitiRepositoryGreatEqualsExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        greatEqualsExpressions.accept(new GreatEqualsRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new GreatEqualsRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new GreatEqualsRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new GreatEqualsRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new GreatEqualsRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new GreatEqualsRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L gt(Consumer<Tuple6<GreatThanRepositoryExpression, GreatThanRepositoryExpression,
        GreatThanRepositoryExpression, GreatThanRepositoryExpression, GreatThanRepositoryExpression,
        GreatThanRepositoryExpression>> greatThanExpressions) {
        MulitiGreatThanExpression<C, L> mulitiExp = new MulitiRepositoryGreatThanExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        greatThanExpressions.accept(Tuples.of(new GreatThanRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new GreatThanRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new GreatThanRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new GreatThanRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new GreatThanRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new GreatThanRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L gt(SixArgusConsumer<GreatThanRepositoryExpression, GreatThanRepositoryExpression,
        GreatThanRepositoryExpression, GreatThanRepositoryExpression, GreatThanRepositoryExpression,
        GreatThanRepositoryExpression> greatThanExpressions) {
        MulitiGreatThanExpression<C, L> mulitiExp = new MulitiRepositoryGreatThanExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        greatThanExpressions.accept(new GreatThanRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new GreatThanRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new GreatThanRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new GreatThanRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new GreatThanRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new GreatThanRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L le(Consumer<Tuple6<LessEqualsRepositoryExpression, LessEqualsRepositoryExpression,
        LessEqualsRepositoryExpression, LessEqualsRepositoryExpression, LessEqualsRepositoryExpression,
        LessEqualsRepositoryExpression>> lessEqualsExpressions) {
        MulitiLessEqualsExpression<C, L> mulitiExp = new MulitiRepositoryLessEqualsExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        lessEqualsExpressions.accept(Tuples.of(new LessEqualsRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new LessEqualsRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new LessEqualsRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new LessEqualsRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new LessEqualsRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new LessEqualsRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public L le(SixArgusConsumer<LessEqualsRepositoryExpression, LessEqualsRepositoryExpression,
        LessEqualsRepositoryExpression, LessEqualsRepositoryExpression, LessEqualsRepositoryExpression,
        LessEqualsRepositoryExpression> lessEqualsExpressions) {
        MulitiLessEqualsExpression<C, L> mulitiExp = new MulitiRepositoryLessEqualsExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        lessEqualsExpressions.accept(new LessEqualsRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new LessEqualsRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new LessEqualsRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new LessEqualsRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new LessEqualsRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new LessEqualsRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lt(Consumer<Tuple6<LessThanRepositoryExpression, LessThanRepositoryExpression,
        LessThanRepositoryExpression, LessThanRepositoryExpression, LessThanRepositoryExpression,
        LessThanRepositoryExpression>> lessThanExpressions) {
        MulitiLessThanExpression<C, L> mulitiExp = new MulitiRepositoryLessThanExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        lessThanExpressions.accept(Tuples.of(new LessThanRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new LessThanRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new LessThanRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new LessThanRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new LessThanRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new LessThanRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lt(SixArgusConsumer<LessThanRepositoryExpression, LessThanRepositoryExpression,
        LessThanRepositoryExpression, LessThanRepositoryExpression, LessThanRepositoryExpression,
        LessThanRepositoryExpression> lessThanExpressions) {
        MulitiLessThanExpression<C, L> mulitiExp = new MulitiRepositoryLessThanExpressionImpl<>(this);
        Predicate<Object> ignoreStrategy = getIgnoreStrategy();
        lessThanExpressions.accept(new LessThanRepositoryExpressionImpl<>(0, mulitiExp, ignoreStrategy),
            new LessThanRepositoryExpressionImpl<>(1, mulitiExp, ignoreStrategy),
            new LessThanRepositoryExpressionImpl<>(2, mulitiExp, ignoreStrategy),
            new LessThanRepositoryExpressionImpl<>(3, mulitiExp, ignoreStrategy),
            new LessThanRepositoryExpressionImpl<>(4, mulitiExp, ignoreStrategy),
            new LessThanRepositoryExpressionImpl<>(5, mulitiExp, ignoreStrategy));
        return (L) this;
    }

    // ********************************************************************
    // protected method
    // ********************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    protected Tuple6<Integer, Integer, Integer, Integer, Integer, Integer> createTuple() {
        return Tuples.of(0, 1, 2, 3, 4, 5);
    }
}
