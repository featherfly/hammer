
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
import cn.featherfly.hammer.expression.repository.condition.ba.RepositoryBetweenExpressionBase6;
import cn.featherfly.hammer.expression.repository.condition.co.RepositoryContainsExpressionBase6;
import cn.featherfly.hammer.expression.repository.condition.eq.RepositoryEqualsExpressionBase6;
import cn.featherfly.hammer.expression.repository.condition.ew.RepositoryEndWithExpressionBase6;
import cn.featherfly.hammer.expression.repository.condition.ge.RepositoryGreatEqualsExpressionBase6;
import cn.featherfly.hammer.expression.repository.condition.gt.RepositoryGreatThanExpressionBase6;
import cn.featherfly.hammer.expression.repository.condition.in.RepositoryInExpressionBase6;
import cn.featherfly.hammer.expression.repository.condition.inn.RepositoryIsNotNullExpressionBase6;
import cn.featherfly.hammer.expression.repository.condition.isn.RepositoryIsNullExpressionBase6;
import cn.featherfly.hammer.expression.repository.condition.le.RepositoryLessEqualsExpressionBase6;
import cn.featherfly.hammer.expression.repository.condition.lk.RepositoryLikeExpressionBase6;
import cn.featherfly.hammer.expression.repository.condition.lt.RepositoryLessThanExpressionBase6;
import cn.featherfly.hammer.expression.repository.condition.nba.RepositoryNotBetweenExpressionBase6;
import cn.featherfly.hammer.expression.repository.condition.nco.RepositoryNotContainsExpressionBase6;
import cn.featherfly.hammer.expression.repository.condition.ne.RepositoryNotEqualsExpressionBase6;
import cn.featherfly.hammer.expression.repository.condition.newv.RepositoryNotEndWithExpressionBase6;
import cn.featherfly.hammer.expression.repository.condition.ni.RepositoryNotInExpressionBase6;
import cn.featherfly.hammer.expression.repository.condition.nl.RepositoryNotLikeExpressionBase6;
import cn.featherfly.hammer.expression.repository.condition.nsw.RepositoryNotStartWithExpressionBase6;
import cn.featherfly.hammer.expression.repository.condition.sw.RepositoryStartWithExpressionBase6;
import cn.featherfly.hammer.sqldb.Constants;

/**
 * abstract muliti repository sql conditions group expression base6.
 *
 * @author zhongj
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <T>  the generic type
 * @param <C6> the generic type
 * @param <S>  the generic type
 * @param <B>  the generic type
 */
public abstract class AbstractMulitiRepositorySqlConditionsGroupExpressionBase6<C extends GroupExpression<C, L>,
    L extends GroupEndExpression<C, L>, T extends Tuple, C6 extends ConditionConfig<C6>,
    S extends RepositorySqlRelation<S, B>, B extends SqlBuilder>
    extends AbstractMulitiRepositorySqlConditionsGroupExpressionBase5<C, L, T, C6, S, B>
    implements RepositoryBetweenExpressionBase6<C, L>, RepositoryNotBetweenExpressionBase6<C, L> //
    , RepositoryContainsExpressionBase6<C, L>, RepositoryNotContainsExpressionBase6<C, L> //
    , RepositoryEndWithExpressionBase6<C, L>, RepositoryNotEndWithExpressionBase6<C, L>//
    , RepositoryEqualsExpressionBase6<C, L>, RepositoryNotEqualsExpressionBase6<C, L> //
    , RepositoryGreatEqualsExpressionBase6<C, L>, RepositoryGreatThanExpressionBase6<C, L> //
    , RepositoryInExpressionBase6<C, L>, RepositoryNotInExpressionBase6<C, L> //
    , RepositoryIsNotNullExpressionBase6<C, L>, RepositoryIsNullExpressionBase6<C, L> //
    , RepositoryLessEqualsExpressionBase6<C, L>, RepositoryLessThanExpressionBase6<C, L> //
    , RepositoryStartWithExpressionBase6<C, L>, RepositoryNotStartWithExpressionBase6<C, L> //
    , RepositoryLikeExpressionBase6<C, L>, RepositoryNotLikeExpressionBase6<C, L> //
/*, RepositoryFieldExpression<C, L>*/ {

    /** The repository alias 6. */
    protected final String repositoryAlias6;

    /**
     * Instantiates a new abstract muliti repository sql conditions group
     * expression base 6.
     *
     * @param parent             the parent
     * @param index              the index
     * @param repositoryRelation the repository relation
     */
    protected AbstractMulitiRepositorySqlConditionsGroupExpressionBase6(L parent, int index, S repositoryRelation) {
        super(parent, index, repositoryRelation);
        repositoryAlias6 = repositoryRelation.getRepositoryRelation(5).getRepositoryAlias();

        if (Constants.DEBUG) {
            Console.log("{} end at time {}", this.getClass().getName(), System.currentTimeMillis());
        }
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(String name, boolean value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(String name, char value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(String name, char value, CharPredicate ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(String name, int value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(String name, int value, IntPredicate ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(String name, long value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(String name, long value, LongPredicate ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(String name, double value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(String name, double value, DoublePredicate ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(String name, String value, MatchStrategy matchStrategy) {
        return eq(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq6(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return eq(name, value, matchStrategy, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L eq6(String name, R value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L eq6(String name, R value, Predicate<R> ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias6);
    }
    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(String name, boolean value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(String name, char value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(String name, char value, CharPredicate ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(String name, int value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(String name, int value, IntPredicate ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(String name, long value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(String name, long value, LongPredicate ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(String name, double value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(String name, double value, DoublePredicate ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(String name, String value, MatchStrategy matchStrategy) {
        return ne(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne6(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ne(name, value, matchStrategy, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ne6(String name, R value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ne6(String name, R value, Predicate<R> ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias6);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba6(String name, N min, N max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba6(String name, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba6(String name, D min, D max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba6(String name, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba6(String name, LocalTime min, LocalTime max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba6(String name, LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba6(String name, LocalDate min, LocalDate max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba6(String name, LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba6(String name, LocalDateTime min, LocalDateTime max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba6(String name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba6(String name, String min, String max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba6(String name, String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias6);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba6(String name, N min, N max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba6(String name, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba6(String name, D min, D max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba6(String name, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba6(String name, LocalTime min, LocalTime max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba6(String name, LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba6(String name, LocalDate min, LocalDate max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba6(String name, LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba6(String name, LocalDateTime min, LocalDateTime max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba6(String name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba6(String name, String min, String max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba6(String name, String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias6);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L co6(String name, String value, MatchStrategy matchStrategy) {
        return co(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co6(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return co(name, value, matchStrategy, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco6(String name, String value, MatchStrategy matchStrategy) {
        return nco(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco6(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nco(name, value, matchStrategy, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew6(String name, String value, MatchStrategy matchStrategy) {
        return ew(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew6(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ew(name, value, matchStrategy, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L new6(String name, String value, MatchStrategy matchStrategy) {
        return newv(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L new6(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return newv(name, value, matchStrategy, ignoreStrategy, repositoryAlias6);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(String name, int value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(String name, int value, IntPredicate ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(String name, long value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(String name, long value, LongPredicate ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(String name, double value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(String name, double value, DoublePredicate ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge6(String name, E value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge6(String name, E value, Predicate<E> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge6(String name, N value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge6(String name, N value, Predicate<N> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge6(String name, D value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge6(String name, D value, Predicate<D> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(String name, LocalTime value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(String name, LocalDate value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(String name, LocalDateTime value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(String name, String value, MatchStrategy matchStrategy) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge6(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias6);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(String name, int value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(String name, int value, IntPredicate ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(String name, long value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(String name, long value, LongPredicate ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(String name, double value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(String name, double value, DoublePredicate ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L gt6(String name, E value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L gt6(String name, E value, Predicate<E> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt6(String name, N value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt6(String name, N value, Predicate<N> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt6(String name, D value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt6(String name, D value, Predicate<D> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(String name, LocalTime value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(String name, LocalDate value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(String name, LocalDateTime value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(String name, String value, MatchStrategy matchStrategy) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt6(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias6);
    }

    // ----------------------------------------------------------------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(String name, int... values) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(String name, int[] values, Predicate<int[]> ignoreStrategy) {
        return in(name, values, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(String name, long... values) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(String name, long[] values, Predicate<long[]> ignoreStrategy) {
        return in(name, values, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(String name, double... values) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(String name, double[] values, Predicate<double[]> ignoreStrategy) {
        return in(name, values, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(String name, String[] values, MatchStrategy matchStrategy) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in6(String name, String[] values, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy) {
        return in(name, values, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in6(String name, @SuppressWarnings("unchecked") R... values) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in6(String name, R value, Predicate<R> ignoreStrategy) {
        return in(name, value, ignoreStrategy, repositoryAlias6);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(String name, int... values) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(String name, int[] values, Predicate<int[]> ignoreStrategy) {
        return ni(name, values, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(String name, long... values) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(String name, long[] values, Predicate<long[]> ignoreStrategy) {
        return ni(name, values, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(String name, double... values) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(String name, double[] values, Predicate<double[]> ignoreStrategy) {
        return ni(name, values, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(String name, String[] values, MatchStrategy matchStrategy) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni6(String name, String[] values, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy) {
        return ni(name, values, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni6(String name, @SuppressWarnings("unchecked") R... values) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni6(String name, R value, Predicate<R> ignoreStrategy) {
        return ni(name, value, ignoreStrategy, repositoryAlias6);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn6(String name, Boolean value) {
        return inn(name, value, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn6(String name, Boolean value) {
        return isn(name, value, repositoryAlias6);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(String name, int value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(String name, int value, IntPredicate ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(String name, long value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(String name, long value, LongPredicate ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(String name, double value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(String name, double value, DoublePredicate ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L le6(String name, E value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L le6(String name, E value, Predicate<E> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le6(String name, N value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le6(String name, N value, Predicate<N> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le6(String name, D value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le6(String name, D value, Predicate<D> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(String name, LocalTime value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(String name, LocalDate value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(String name, LocalDateTime value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(String name, String value, MatchStrategy matchStrategy) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le6(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias6);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(String name, int value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(String name, int value, IntPredicate ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(String name, long value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(String name, long value, LongPredicate ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(String name, double value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(String name, double value, DoublePredicate ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt6(String name, E value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt6(String name, E value, Predicate<E> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt6(String name, N value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt6(String name, N value, Predicate<N> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt6(String name, D value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt6(String name, D value, Predicate<D> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(String name, LocalTime value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(String name, LocalDate value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(String name, LocalDateTime value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(String name, String value, MatchStrategy matchStrategy) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt6(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias6);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw6(String name, String value, MatchStrategy matchStrategy) {
        return sw(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw6(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return sw(name, value, matchStrategy, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw6(String name, String value, MatchStrategy matchStrategy) {
        return nco(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw6(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nsw(name, value, matchStrategy, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk6(String name, String value, MatchStrategy matchStrategy) {
        return lk(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk6(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lk(name, value, matchStrategy, ignoreStrategy, repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl6(String name, String value, MatchStrategy matchStrategy) {
        return nl(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl6(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nl(name, value, matchStrategy, ignoreStrategy, repositoryAlias6);
    }

    // ********************************************************************
    // private method
    // ********************************************************************

    // ********************************************************************
    // protected method
    // ********************************************************************
}
