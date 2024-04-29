
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
import cn.featherfly.hammer.sqldb.Constants;

/**
 * abstract muliti repository sql conditions group expression base5.
 *
 * @author zhongj
 * @param <C>  condition expression
 * @param <L>  logic expression
 * @param <T>  filterable repository index tuple type
 * @param <C2> condition config
 * @param <S>  repository sql relation
 * @param <B>  sql builder
 */
public abstract class AbstractMulitiRepositorySqlConditionsGroupExpressionBase5<C extends GroupExpression<C, L>,
    L extends GroupEndExpression<C, L>, T extends Tuple, C2 extends ConditionConfig<C2>,
    S extends RepositorySqlRelation<S, B>, B extends SqlBuilder>
    extends AbstractMulitiRepositorySqlConditionsGroupExpressionBase4<C, L, T, C2, S, B>
//    implements RepositoryBetweenExpressionBase5<C, L>, RepositoryNotBetweenExpressionBase5<C, L> //
//    , RepositoryContainsExpressionBase5<C, L>, RepositoryNotContainsExpressionBase5<C, L> //
//    , RepositoryEndWithExpressionBase5<C, L>, RepositoryNotEndWithExpressionBase5<C, L>//
//    , RepositoryEqualsExpressionBase5<C, L>, RepositoryNotEqualsExpressionBase5<C, L> //
//    , RepositoryGreatEqualsExpressionBase5<C, L>, RepositoryGreatThanExpressionBase5<C, L> //
//    , RepositoryInExpressionBase5<C, L>, RepositoryNotInExpressionBase5<C, L> //
//    , RepositoryIsNotNullExpressionBase5<C, L>, RepositoryIsNullExpressionBase5<C, L> //
//    , RepositoryLessEqualsExpressionBase5<C, L>, RepositoryLessThanExpressionBase5<C, L> //
//    , RepositoryStartWithExpressionBase5<C, L>, RepositoryNotStartWithExpressionBase5<C, L> //
//    , RepositoryLikeExpressionBase5<C, L>, RepositoryNotLikeExpressionBase5<C, L> //
// 这里注释掉是为了编译速度
/*, RepositoryFieldExpression<C, L>*/ {

    /** The repository alias 5. */
    protected final String repositoryAlias5;

    /**
     * Instantiates a new abstract muliti repository sql conditions group
     * expression base 5.
     *
     * @param parent             the parent
     * @param index              the index
     * @param repositoryRelation the repository relation
     */
    protected AbstractMulitiRepositorySqlConditionsGroupExpressionBase5(L parent, int index, S repositoryRelation) {
        super(parent, index, repositoryRelation);
        repositoryAlias5 = repositoryRelation.getRepositoryRelation(4).getRepositoryAlias();
        if (Constants.DEBUG) {
            Console.log("{} end at time {}", this.getClass().getName(), System.currentTimeMillis());
        }
    }

    // ****************************************************************************************************************

    /**
     * Eq 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L eq5(String name, boolean value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Eq 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L eq5(String name, char value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Eq 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L eq5(String name, char value, CharPredicate ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Eq 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L eq5(String name, int value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Eq 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L eq5(String name, int value, IntPredicate ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Eq 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L eq5(String name, long value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Eq 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L eq5(String name, long value, LongPredicate ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Eq 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L eq5(String name, double value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Eq 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L eq5(String name, double value, DoublePredicate ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Eq 5.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L eq5(String name, String value, MatchStrategy matchStrategy) {
        return eq(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Eq 5.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L eq5(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return eq(name, value, matchStrategy, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Eq 5.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <R extends Serializable> L eq5(String name, R value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Eq 5.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R extends Serializable> L eq5(String name, R value, Predicate<R> ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias5);
    }
    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Ne 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ne5(String name, boolean value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ne 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ne5(String name, char value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ne 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ne5(String name, char value, CharPredicate ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Ne 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ne5(String name, int value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ne 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ne5(String name, int value, IntPredicate ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Ne 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ne5(String name, long value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ne 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ne5(String name, long value, LongPredicate ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Ne 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ne5(String name, double value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ne 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ne5(String name, double value, DoublePredicate ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Ne 5.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L ne5(String name, String value, MatchStrategy matchStrategy) {
        return ne(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ne 5.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ne5(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ne(name, value, matchStrategy, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Ne 5.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <R extends Serializable> L ne5(String name, R value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ne 5.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R extends Serializable> L ne5(String name, R value, Predicate<R> ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias5);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Ba 5.
     *
     * @param <N>  the number type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public <N extends Number> L ba5(String name, N min, N max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ba 5.
     *
     * @param <N>            the number type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <N extends Number> L ba5(String name, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Ba 5.
     *
     * @param <D>  the generic type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public <D extends Date> L ba5(String name, D min, D max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ba 5.
     *
     * @param <D>            the generic type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <D extends Date> L ba5(String name, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Ba 5.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public L ba5(String name, LocalTime min, LocalTime max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ba 5.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ba5(String name, LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Ba 5.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public L ba5(String name, LocalDate min, LocalDate max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ba 5.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ba5(String name, LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Ba 5.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public L ba5(String name, LocalDateTime min, LocalDateTime max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ba 5.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ba5(String name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ba 5.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public L ba5(String name, String min, String max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ba 5.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ba5(String name, String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias5);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Nba 5.
     *
     * @param <N>  the number type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public <N extends Number> L nba5(String name, N min, N max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Nba 5.
     *
     * @param <N>            the number type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <N extends Number> L nba5(String name, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Nba 5.
     *
     * @param <D>  the generic type
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public <D extends Date> L nba5(String name, D min, D max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Nba 5.
     *
     * @param <D>            the generic type
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <D extends Date> L nba5(String name, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Nba 5.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public L nba5(String name, LocalTime min, LocalTime max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Nba 5.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L nba5(String name, LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Nba 5.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public L nba5(String name, LocalDate min, LocalDate max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Nba 5.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L nba5(String name, LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Nba 5.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public L nba5(String name, LocalDateTime min, LocalDateTime max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Nba 5.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L nba5(String name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Nba 5.
     *
     * @param name the name
     * @param min  the min
     * @param max  the max
     * @return the l
     */
    public L nba5(String name, String min, String max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Nba 5.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L nba5(String name, String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias5);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Co 5.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L co5(String name, String value, MatchStrategy matchStrategy) {
        return co(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Co 5.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L co5(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return co(name, value, matchStrategy, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Nco 5.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L nco5(String name, String value, MatchStrategy matchStrategy) {
        return nco(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Nco 5.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L nco5(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nco(name, value, matchStrategy, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Ew 5.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L ew5(String name, String value, MatchStrategy matchStrategy) {
        return ew(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ew 5.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ew5(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ew(name, value, matchStrategy, ignoreStrategy, repositoryAlias5);
    }

    /**
     * New 5.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L new5(String name, String value, MatchStrategy matchStrategy) {
        return newv(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * New 5.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L new5(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return newv(name, value, matchStrategy, ignoreStrategy, repositoryAlias5);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Ge 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ge5(String name, int value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ge 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ge5(String name, int value, IntPredicate ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Ge 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ge5(String name, long value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ge 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ge5(String name, long value, LongPredicate ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Ge 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ge5(String name, double value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ge 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ge5(String name, double value, DoublePredicate ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Ge 5.
     *
     * @param <E>   the element type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <E extends Enum<E>> L ge5(String name, E value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ge 5.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <E extends Enum<E>> L ge5(String name, E value, Predicate<E> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Ge 5.
     *
     * @param <N>   the number type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <N extends Number> L ge5(String name, N value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ge 5.
     *
     * @param <N>            the number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <N extends Number> L ge5(String name, N value, Predicate<N> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Ge 5.
     *
     * @param <D>   the generic type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <D extends Date> L ge5(String name, D value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ge 5.
     *
     * @param <D>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <D extends Date> L ge5(String name, D value, Predicate<D> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Ge 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ge5(String name, LocalTime value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ge 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ge5(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Ge 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ge5(String name, LocalDate value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ge 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ge5(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Ge 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L ge5(String name, LocalDateTime value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ge 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ge5(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Ge 5.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L ge5(String name, String value, MatchStrategy matchStrategy) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ge 5.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ge5(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias5);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Gt 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L gt5(String name, int value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Gt 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L gt5(String name, int value, IntPredicate ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Gt 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L gt5(String name, long value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Gt 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L gt5(String name, long value, LongPredicate ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Gt 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L gt5(String name, double value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Gt 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L gt5(String name, double value, DoublePredicate ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Gt 5.
     *
     * @param <E>   the element type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <E extends Enum<E>> L gt5(String name, E value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Gt 5.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <E extends Enum<E>> L gt5(String name, E value, Predicate<E> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Gt 5.
     *
     * @param <N>   the number type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <N extends Number> L gt5(String name, N value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Gt 5.
     *
     * @param <N>            the number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <N extends Number> L gt5(String name, N value, Predicate<N> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Gt 5.
     *
     * @param <D>   the generic type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <D extends Date> L gt5(String name, D value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Gt 5.
     *
     * @param <D>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <D extends Date> L gt5(String name, D value, Predicate<D> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Gt 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L gt5(String name, LocalTime value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Gt 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L gt5(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Gt 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L gt5(String name, LocalDate value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Gt 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L gt5(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Gt 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L gt5(String name, LocalDateTime value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Gt 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L gt5(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Gt 5.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L gt5(String name, String value, MatchStrategy matchStrategy) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Gt 5.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L gt5(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias5);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * In 5.
     *
     * @param name   the name
     * @param values the values
     * @return the l
     */
    public L in5(String name, int... values) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * In 5.
     *
     * @param name           the name
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L in5(String name, int[] values, Predicate<int[]> ignoreStrategy) {
        return in(name, values, ignoreStrategy, repositoryAlias5);
    }

    /**
     * In 5.
     *
     * @param name   the name
     * @param values the values
     * @return the l
     */
    public L in5(String name, long... values) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * In 5.
     *
     * @param name           the name
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L in5(String name, long[] values, Predicate<long[]> ignoreStrategy) {
        return in(name, values, ignoreStrategy, repositoryAlias5);
    }

    /**
     * In 5.
     *
     * @param name   the name
     * @param values the values
     * @return the l
     */
    public L in5(String name, double... values) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * In 5.
     *
     * @param name           the name
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L in5(String name, double[] values, Predicate<double[]> ignoreStrategy) {
        return in(name, values, ignoreStrategy, repositoryAlias5);
    }

    /**
     * In 5.
     *
     * @param name          the name
     * @param values        the values
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L in5(String name, String[] values, MatchStrategy matchStrategy) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * In 5.
     *
     * @param name           the name
     * @param values         the values
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L in5(String name, String[] values, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy) {
        return in(name, values, ignoreStrategy, repositoryAlias5);
    }

    /**
     * In 5.
     *
     * @param <R>    the generic type
     * @param name   the name
     * @param values the values
     * @return the l
     */
    public <R extends Serializable> L in5(String name, @SuppressWarnings("unchecked") R... values) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * In 5.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R extends Serializable> L in5(String name, R value, Predicate<R> ignoreStrategy) {
        return in(name, value, ignoreStrategy, repositoryAlias5);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Ni 5.
     *
     * @param name   the name
     * @param values the values
     * @return the l
     */
    public L ni5(String name, int... values) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ni 5.
     *
     * @param name           the name
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ni5(String name, int[] values, Predicate<int[]> ignoreStrategy) {
        return ni(name, values, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Ni 5.
     *
     * @param name   the name
     * @param values the values
     * @return the l
     */
    public L ni5(String name, long... values) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ni 5.
     *
     * @param name           the name
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ni5(String name, long[] values, Predicate<long[]> ignoreStrategy) {
        return ni(name, values, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Ni 5.
     *
     * @param name   the name
     * @param values the values
     * @return the l
     */
    public L ni5(String name, double... values) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ni 5.
     *
     * @param name           the name
     * @param values         the values
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ni5(String name, double[] values, Predicate<double[]> ignoreStrategy) {
        return ni(name, values, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Ni 5.
     *
     * @param name          the name
     * @param values        the values
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L ni5(String name, String[] values, MatchStrategy matchStrategy) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ni 5.
     *
     * @param name           the name
     * @param values         the values
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ni5(String name, String[] values, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy) {
        return ni(name, values, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Ni 5.
     *
     * @param <R>    the generic type
     * @param name   the name
     * @param values the values
     * @return the l
     */
    public <R extends Serializable> L ni5(String name, @SuppressWarnings("unchecked") R... values) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Ni 5.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <R extends Serializable> L ni5(String name, R value, Predicate<R> ignoreStrategy) {
        return ni(name, value, ignoreStrategy, repositoryAlias5);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Inn 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L inn5(String name, Boolean value) {
        return inn(name, value, repositoryAlias5);
    }

    /**
     * Isn 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L isn5(String name, Boolean value) {
        return isn(name, value, repositoryAlias5);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Le 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L le5(String name, int value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Le 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L le5(String name, int value, IntPredicate ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Le 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L le5(String name, long value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Le 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L le5(String name, long value, LongPredicate ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Le 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L le5(String name, double value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Le 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L le5(String name, double value, DoublePredicate ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Le 5.
     *
     * @param <E>   the element type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <E extends Enum<E>> L le5(String name, E value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Le 5.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <E extends Enum<E>> L le5(String name, E value, Predicate<E> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Le 5.
     *
     * @param <N>   the number type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <N extends Number> L le5(String name, N value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Le 5.
     *
     * @param <N>            the number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <N extends Number> L le5(String name, N value, Predicate<N> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Le 5.
     *
     * @param <D>   the generic type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <D extends Date> L le5(String name, D value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Le 5.
     *
     * @param <D>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <D extends Date> L le5(String name, D value, Predicate<D> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Le 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L le5(String name, LocalTime value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Le 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L le5(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Le 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L le5(String name, LocalDate value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Le 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L le5(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Le 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L le5(String name, LocalDateTime value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Le 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L le5(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Le 5.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L le5(String name, String value, MatchStrategy matchStrategy) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Le 5.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L le5(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias5);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Lt 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L lt5(String name, int value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Lt 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lt5(String name, int value, IntPredicate ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Lt 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L lt5(String name, long value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Lt 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lt5(String name, long value, LongPredicate ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Lt 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L lt5(String name, double value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Lt 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lt5(String name, double value, DoublePredicate ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Lt 5.
     *
     * @param <E>   the element type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <E extends Enum<E>> L lt5(String name, E value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Lt 5.
     *
     * @param <E>            the element type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <E extends Enum<E>> L lt5(String name, E value, Predicate<E> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Lt 5.
     *
     * @param <N>   the number type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <N extends Number> L lt5(String name, N value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Lt 5.
     *
     * @param <N>            the number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <N extends Number> L lt5(String name, N value, Predicate<N> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Lt 5.
     *
     * @param <D>   the generic type
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public <D extends Date> L lt5(String name, D value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Lt 5.
     *
     * @param <D>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public <D extends Date> L lt5(String name, D value, Predicate<D> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Lt 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L lt5(String name, LocalTime value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Lt 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lt5(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Lt 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L lt5(String name, LocalDate value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Lt 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lt5(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Lt 5.
     *
     * @param name  the name
     * @param value the value
     * @return the l
     */
    public L lt5(String name, LocalDateTime value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Lt 5.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lt5(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Lt 5.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L lt5(String name, String value, MatchStrategy matchStrategy) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Lt 5.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lt5(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias5);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Sw 5.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L sw5(String name, String value, MatchStrategy matchStrategy) {
        return sw(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Sw 5.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L sw5(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return sw(name, value, matchStrategy, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Nsw 5.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L nsw5(String name, String value, MatchStrategy matchStrategy) {
        return nco(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Nsw 5.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L nsw5(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nsw(name, value, matchStrategy, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Lk 5.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L lk5(String name, String value, MatchStrategy matchStrategy) {
        return lk(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Lk 5.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L lk5(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lk(name, value, matchStrategy, ignoreStrategy, repositoryAlias5);
    }

    /**
     * Nl 5.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    public L nl5(String name, String value, MatchStrategy matchStrategy) {
        return nl(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias5);
    }

    /**
     * Nl 5.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L nl5(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nl(name, value, matchStrategy, ignoreStrategy, repositoryAlias5);
    }

    // ********************************************************************
    // private method
    // ********************************************************************

    // ********************************************************************
    // protected method
    // ********************************************************************
}
