
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import com.speedment.common.tuple.Tuple;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.function.CharPredicate;
import cn.featherfly.common.lang.Console;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.expression.repository.condition.ba.RepositoryBetweenExpressionBase2;
import cn.featherfly.hammer.expression.repository.condition.co.RepositoryContainsExpressionBase2;
import cn.featherfly.hammer.expression.repository.condition.eq.RepositoryEqualsExpressionBase2;
import cn.featherfly.hammer.expression.repository.condition.ew.RepositoryEndWithExpressionBase2;
import cn.featherfly.hammer.expression.repository.condition.ge.RepositoryGreatEqualsExpressionBase2;
import cn.featherfly.hammer.expression.repository.condition.gt.RepositoryGreatThanExpressionBase2;
import cn.featherfly.hammer.expression.repository.condition.in.RepositoryInExpressionBase2;
import cn.featherfly.hammer.expression.repository.condition.inn.RepositoryIsNotNullExpressionBase2;
import cn.featherfly.hammer.expression.repository.condition.isn.RepositoryIsNullExpressionBase2;
import cn.featherfly.hammer.expression.repository.condition.le.RepositoryLessEqualsExpressionBase2;
import cn.featherfly.hammer.expression.repository.condition.lk.RepositoryLikeExpressionBase2;
import cn.featherfly.hammer.expression.repository.condition.lt.RepositoryLessThanExpressionBase2;
import cn.featherfly.hammer.expression.repository.condition.nba.RepositoryNotBetweenExpressionBase2;
import cn.featherfly.hammer.expression.repository.condition.nco.RepositoryNotContainsExpressionBase2;
import cn.featherfly.hammer.expression.repository.condition.ne.RepositoryNotEqualsExpressionBase2;
import cn.featherfly.hammer.expression.repository.condition.newv.RepositoryNotEndWithExpressionBase2;
import cn.featherfly.hammer.expression.repository.condition.ni.RepositoryNotInExpressionBase2;
import cn.featherfly.hammer.expression.repository.condition.nl.RepositoryNotLikeExpressionBase2;
import cn.featherfly.hammer.expression.repository.condition.nsw.RepositoryNotStartWithExpressionBase2;
import cn.featherfly.hammer.expression.repository.condition.sw.RepositoryStartWithExpressionBase2;
import cn.featherfly.hammer.sqldb.Constants;

/**
 * abstract muliti repository sql conditions group expression base2.
 *
 * @author zhongj
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <T>  the generic type
 * @param <C2> the generic type
 * @param <S>  the generic type
 * @param <B>  the generic type
 */
public abstract class AbstractMulitiRepositorySqlConditionsGroupExpressionBase2<C extends GroupExpression<C, L>,
    L extends GroupEndExpression<C, L>, T extends Tuple, C2 extends ConditionConfig<C2>,
    S extends RepositorySqlRelation<S, B>, B extends SqlBuilder>
    extends AbstractMulitiRepositorySqlConditionsGroupExpressionBase<C, L, T, C2, S, B>
    implements RepositoryBetweenExpressionBase2<C, L>, RepositoryNotBetweenExpressionBase2<C, L> //
    , RepositoryContainsExpressionBase2<C, L>, RepositoryNotContainsExpressionBase2<C, L> //
    , RepositoryEndWithExpressionBase2<C, L>, RepositoryNotEndWithExpressionBase2<C, L>//
    , RepositoryEqualsExpressionBase2<C, L>, RepositoryNotEqualsExpressionBase2<C, L> //
    , RepositoryGreatEqualsExpressionBase2<C, L>, RepositoryGreatThanExpressionBase2<C, L> //
    , RepositoryInExpressionBase2<C, L>, RepositoryNotInExpressionBase2<C, L> //
    , RepositoryIsNotNullExpressionBase2<C, L>, RepositoryIsNullExpressionBase2<C, L> //
    , RepositoryLessEqualsExpressionBase2<C, L>, RepositoryLessThanExpressionBase2<C, L> //
    , RepositoryStartWithExpressionBase2<C, L>, RepositoryNotStartWithExpressionBase2<C, L> //
    , RepositoryLikeExpressionBase2<C, L>, RepositoryNotLikeExpressionBase2<C, L> //
/*, RepositoryFieldExpression<C, L>*/ {

    /** The repository alias 2. */
    protected final String repositoryAlias2;

    /**
     * Instantiates a new abstract muliti repository sql conditions group
     * expression base 2.
     *
     * @param parent             the parent
     * @param index              the index
     * @param repositoryRelation the repository relation
     */
    protected AbstractMulitiRepositorySqlConditionsGroupExpressionBase2(L parent, int index, S repositoryRelation) {
        super(parent, index, repositoryRelation);
        repositoryAlias2 = repositoryRelation.getRepositoryRelation(1).getRepositoryAlias();
        if (Constants.DEBUG) {
            Console.log("{} end at time {}", this.getClass().getName(), System.currentTimeMillis());
        }
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(String name, boolean value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(String name, char value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(String name, char value, CharPredicate ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(String name, int value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(String name, int value, IntPredicate ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(String name, long value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(String name, long value, LongPredicate ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(String name, double value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(String name, double value, DoublePredicate ignoreStrategy) {
        return eq(name, value, v -> ignoreStrategy.test(v), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(String name, String value, MatchStrategy matchStrategy) {
        return eq(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq2(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return eq(name, value, matchStrategy, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L eq2(String name, R value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L eq2(String name, R value, Predicate<R> ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias2);
    }
    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(String name, boolean value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(String name, char value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(String name, char value, CharPredicate ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(String name, int value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(String name, int value, IntPredicate ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(String name, long value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(String name, long value, LongPredicate ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(String name, double value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(String name, double value, DoublePredicate ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(String name, String value, MatchStrategy matchStrategy) {
        return ne(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne2(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ne(name, value, matchStrategy, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ne2(String name, R value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ne2(String name, R value, Predicate<R> ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias2);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba2(String name, N min, N max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba2(String name, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba2(String name, D min, D max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba2(String name, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba2(String name, LocalTime min, LocalTime max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba2(String name, LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba2(String name, LocalDate min, LocalDate max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba2(String name, LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba2(String name, LocalDateTime min, LocalDateTime max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba2(String name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba2(String name, String min, String max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba2(String name, String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias2);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba2(String name, N min, N max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba2(String name, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba2(String name, D min, D max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba2(String name, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba2(String name, LocalTime min, LocalTime max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba2(String name, LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba2(String name, LocalDate min, LocalDate max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba2(String name, LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba2(String name, LocalDateTime min, LocalDateTime max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba2(String name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba2(String name, String min, String max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba2(String name, String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias2);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L co2(String name, String value, MatchStrategy matchStrategy) {
        return co(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co2(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return co(name, value, matchStrategy, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco2(String name, String value, MatchStrategy matchStrategy) {
        return nco(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco2(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nco(name, value, matchStrategy, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew2(String name, String value, MatchStrategy matchStrategy) {
        return ew(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew2(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ew(name, value, matchStrategy, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L new2(String name, String value, MatchStrategy matchStrategy) {
        return newv(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L new2(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return newv(name, value, matchStrategy, ignoreStrategy, repositoryAlias2);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(String name, int value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(String name, int value, IntPredicate ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(String name, long value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(String name, long value, LongPredicate ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(String name, double value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(String name, double value, DoublePredicate ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge2(String name, E value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge2(String name, E value, Predicate<E> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge2(String name, N value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge2(String name, N value, Predicate<N> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge2(String name, D value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge2(String name, D value, Predicate<D> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(String name, LocalTime value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(String name, LocalDate value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(String name, LocalDateTime value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(String name, String value, MatchStrategy matchStrategy) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge2(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias2);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(String name, int value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(String name, int value, IntPredicate ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(String name, long value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(String name, long value, LongPredicate ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(String name, double value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(String name, double value, DoublePredicate ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L gt2(String name, E value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L gt2(String name, E value, Predicate<E> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt2(String name, N value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt2(String name, N value, Predicate<N> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt2(String name, D value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt2(String name, D value, Predicate<D> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(String name, LocalTime value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(String name, LocalDate value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(String name, LocalDateTime value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(String name, String value, MatchStrategy matchStrategy) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt2(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias2);
    }

    // ----------------------------------------------------------------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(String name, int... values) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(String name, int[] values, Predicate<int[]> ignoreStrategy) {
        return in(name, values, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(String name, long... values) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(String name, long[] values, Predicate<long[]> ignoreStrategy) {
        return in(name, values, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(String name, double... values) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(String name, double[] values, Predicate<double[]> ignoreStrategy) {
        return in(name, values, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(String name, String[] values, MatchStrategy matchStrategy) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in2(String name, String[] values, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy) {
        return in(name, values, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in2(String name, @SuppressWarnings("unchecked") R... values) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in2(String name, R value, Predicate<R> ignoreStrategy) {
        return in(name, value, ignoreStrategy, repositoryAlias2);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(String name, int... values) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(String name, int[] values, Predicate<int[]> ignoreStrategy) {
        return ni(name, values, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(String name, long... values) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(String name, long[] values, Predicate<long[]> ignoreStrategy) {
        return ni(name, values, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(String name, double... values) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(String name, double[] values, Predicate<double[]> ignoreStrategy) {
        return ni(name, values, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(String name, String[] values, MatchStrategy matchStrategy) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni2(String name, String[] values, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy) {
        return ni(name, values, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni2(String name, @SuppressWarnings("unchecked") R... values) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni2(String name, R value, Predicate<R> ignoreStrategy) {
        return ni(name, value, ignoreStrategy, repositoryAlias2);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn2(String name, Boolean value) {
        return inn(name, value, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn2(String name, Boolean value) {
        return isn(name, value, repositoryAlias2);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(String name, int value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(String name, int value, IntPredicate ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(String name, long value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(String name, long value, LongPredicate ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(String name, double value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(String name, double value, DoublePredicate ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L le2(String name, E value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L le2(String name, E value, Predicate<E> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le2(String name, N value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le2(String name, N value, Predicate<N> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le2(String name, D value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le2(String name, D value, Predicate<D> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(String name, LocalTime value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(String name, LocalDate value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(String name, LocalDateTime value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(String name, String value, MatchStrategy matchStrategy) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le2(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias2);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(String name, int value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(String name, int value, IntPredicate ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(String name, long value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(String name, long value, LongPredicate ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(String name, double value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(String name, double value, DoublePredicate ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt2(String name, E value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt2(String name, E value, Predicate<E> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt2(String name, N value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt2(String name, N value, Predicate<N> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt2(String name, D value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt2(String name, D value, Predicate<D> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(String name, LocalTime value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(String name, LocalDate value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(String name, LocalDateTime value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(String name, String value, MatchStrategy matchStrategy) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt2(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias2);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw2(String name, String value, MatchStrategy matchStrategy) {
        return sw(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw2(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return sw(name, value, matchStrategy, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw2(String name, String value, MatchStrategy matchStrategy) {
        return nco(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw2(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nsw(name, value, matchStrategy, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk2(String name, String value, MatchStrategy matchStrategy) {
        return lk(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk2(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lk(name, value, matchStrategy, ignoreStrategy, repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl2(String name, String value, MatchStrategy matchStrategy) {
        return nl(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl2(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nl(name, value, matchStrategy, ignoreStrategy, repositoryAlias2);
    }

    // ********************************************************************
    // private method
    // ********************************************************************

    // ********************************************************************
    // protected method
    // ********************************************************************
}
