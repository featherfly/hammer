
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
 * abstract muliti repository sql conditions group expression base4.
 *
 * @author zhongj
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <T>  the generic type
 * @param <C4> the generic type
 * @param <S>  the generic type
 * @param <B>  the generic type
 */
public abstract class AbstractMulitiRepositorySqlConditionsGroupExpressionBase4<C extends GroupExpression<C, L>,
    L extends GroupEndExpression<C, L>, T extends Tuple, C4 extends ConditionConfig<C4>,
    S extends RepositorySqlRelation<S, B>, B extends SqlBuilder>
    extends AbstractMulitiRepositorySqlConditionsGroupExpressionBase3<C, L, T, C4, S, B>
//    implements RepositoryBetweenExpressionBase4<C, L>, RepositoryNotBetweenExpressionBase4<C, L> //
//    , RepositoryContainsExpressionBase4<C, L>, RepositoryNotContainsExpressionBase4<C, L> //
//    , RepositoryEndWithExpressionBase4<C, L>, RepositoryNotEndWithExpressionBase4<C, L>//
//    , RepositoryEqualsExpressionBase4<C, L>, RepositoryNotEqualsExpressionBase4<C, L> //
//    , RepositoryGreatEqualsExpressionBase4<C, L>, RepositoryGreatThanExpressionBase4<C, L> //
//    , RepositoryInExpressionBase4<C, L>, RepositoryNotInExpressionBase4<C, L> //
//    , RepositoryIsNotNullExpressionBase4<C, L>, RepositoryIsNullExpressionBase4<C, L> //
//    , RepositoryLessEqualsExpressionBase4<C, L>, RepositoryLessThanExpressionBase4<C, L> //
//    , RepositoryStartWithExpressionBase4<C, L>, RepositoryNotStartWithExpressionBase4<C, L> //
//    , RepositoryLikeExpressionBase4<C, L>, RepositoryNotLikeExpressionBase4<C, L> //
// 这里注释掉是为了编译速度
/*, RepositoryFieldExpression<C, L>*/ {

    /** The repository alias 4. */
    protected final String repositoryAlias4;

    /**
     * Instantiates a new abstract muliti repository sql conditions group
     * expression base 4.
     *
     * @param parent             the parent
     * @param index              the index
     * @param repositoryRelation the repository relation
     */
    protected AbstractMulitiRepositorySqlConditionsGroupExpressionBase4(L parent, int index, S repositoryRelation) {
        super(parent, index, repositoryRelation);
        repositoryAlias4 = repositoryRelation.getRepositoryRelation(3).getRepositoryAlias();

        if (Constants.DEBUG) {
            Console.log("{} end at time {}", this.getClass().getName(), System.currentTimeMillis());
        }
    }

    // ****************************************************************************************************************

    public L eq4(String name, boolean value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L eq4(String name, char value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L eq4(String name, char value, CharPredicate ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L eq4(String name, int value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L eq4(String name, int value, IntPredicate ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L eq4(String name, long value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L eq4(String name, long value, LongPredicate ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L eq4(String name, double value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L eq4(String name, double value, DoublePredicate ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L eq4(String name, String value, MatchStrategy matchStrategy) {
        return eq(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias4);
    }

    public L eq4(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return eq(name, value, matchStrategy, ignoreStrategy, repositoryAlias4);
    }

    public <R extends Serializable> L eq4(String name, R value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public <R extends Serializable> L eq4(String name, R value, Predicate<R> ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias4);
    }
    // ----------------------------------------------------------------------------------------------------------------

    public L ne4(String name, boolean value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L ne4(String name, char value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L ne4(String name, char value, CharPredicate ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L ne4(String name, int value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L ne4(String name, int value, IntPredicate ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L ne4(String name, long value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L ne4(String name, long value, LongPredicate ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L ne4(String name, double value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L ne4(String name, double value, DoublePredicate ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L ne4(String name, String value, MatchStrategy matchStrategy) {
        return ne(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias4);
    }

    public L ne4(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ne(name, value, matchStrategy, ignoreStrategy, repositoryAlias4);
    }

    public <R extends Serializable> L ne4(String name, R value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public <R extends Serializable> L ne4(String name, R value, Predicate<R> ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias4);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public <N extends Number> L ba4(String name, N min, N max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias4);
    }

    public <N extends Number> L ba4(String name, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias4);
    }

    public <D extends Date> L ba4(String name, D min, D max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias4);
    }

    public <D extends Date> L ba4(String name, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias4);
    }

    public L ba4(String name, LocalTime min, LocalTime max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias4);
    }

    public L ba4(String name, LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias4);
    }

    public L ba4(String name, LocalDate min, LocalDate max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias4);
    }

    public L ba4(String name, LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias4);
    }

    public L ba4(String name, LocalDateTime min, LocalDateTime max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias4);
    }

    public L ba4(String name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias4);
    }

    public L ba4(String name, String min, String max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias4);
    }

    public L ba4(String name, String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias4);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public <N extends Number> L nba4(String name, N min, N max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias4);
    }

    public <N extends Number> L nba4(String name, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias4);
    }

    public <D extends Date> L nba4(String name, D min, D max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias4);
    }

    public <D extends Date> L nba4(String name, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias4);
    }

    public L nba4(String name, LocalTime min, LocalTime max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias4);
    }

    public L nba4(String name, LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias4);
    }

    public L nba4(String name, LocalDate min, LocalDate max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias4);
    }

    public L nba4(String name, LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias4);
    }

    public L nba4(String name, LocalDateTime min, LocalDateTime max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias4);
    }

    public L nba4(String name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias4);
    }

    public L nba4(String name, String min, String max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias4);
    }

    public L nba4(String name, String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias4);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public L co4(String name, String value, MatchStrategy matchStrategy) {
        return co(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias4);
    }

    public L co4(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return co(name, value, matchStrategy, ignoreStrategy, repositoryAlias4);
    }

    public L nco4(String name, String value, MatchStrategy matchStrategy) {
        return nco(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias4);
    }

    public L nco4(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nco(name, value, matchStrategy, ignoreStrategy, repositoryAlias4);
    }

    public L ew4(String name, String value, MatchStrategy matchStrategy) {
        return ew(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias4);
    }

    public L ew4(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ew(name, value, matchStrategy, ignoreStrategy, repositoryAlias4);
    }

    public L new4(String name, String value, MatchStrategy matchStrategy) {
        return newv(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias4);
    }

    public L new4(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return newv(name, value, matchStrategy, ignoreStrategy, repositoryAlias4);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public L ge4(String name, int value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L ge4(String name, int value, IntPredicate ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L ge4(String name, long value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L ge4(String name, long value, LongPredicate ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L ge4(String name, double value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L ge4(String name, double value, DoublePredicate ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias4);
    }

    public <E extends Enum<E>> L ge4(String name, E value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public <E extends Enum<E>> L ge4(String name, E value, Predicate<E> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias4);
    }

    public <N extends Number> L ge4(String name, N value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public <N extends Number> L ge4(String name, N value, Predicate<N> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias4);
    }

    public <D extends Date> L ge4(String name, D value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public <D extends Date> L ge4(String name, D value, Predicate<D> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L ge4(String name, LocalTime value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L ge4(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L ge4(String name, LocalDate value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L ge4(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L ge4(String name, LocalDateTime value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L ge4(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L ge4(String name, String value, MatchStrategy matchStrategy) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L ge4(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias4);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public L gt4(String name, int value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L gt4(String name, int value, IntPredicate ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L gt4(String name, long value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L gt4(String name, long value, LongPredicate ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L gt4(String name, double value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L gt4(String name, double value, DoublePredicate ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias4);
    }

    public <E extends Enum<E>> L gt4(String name, E value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public <E extends Enum<E>> L gt4(String name, E value, Predicate<E> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias4);
    }

    public <N extends Number> L gt4(String name, N value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public <N extends Number> L gt4(String name, N value, Predicate<N> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias4);
    }

    public <D extends Date> L gt4(String name, D value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public <D extends Date> L gt4(String name, D value, Predicate<D> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L gt4(String name, LocalTime value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L gt4(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L gt4(String name, LocalDate value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L gt4(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L gt4(String name, LocalDateTime value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L gt4(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L gt4(String name, String value, MatchStrategy matchStrategy) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L gt4(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias4);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public L in4(String name, int... values) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias4);
    }

    public L in4(String name, int[] values, Predicate<int[]> ignoreStrategy) {
        return in(name, values, ignoreStrategy, repositoryAlias4);
    }

    public L in4(String name, long... values) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias4);
    }

    public L in4(String name, long[] values, Predicate<long[]> ignoreStrategy) {
        return in(name, values, ignoreStrategy, repositoryAlias4);
    }

    public L in4(String name, double... values) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias4);
    }

    public L in4(String name, double[] values, Predicate<double[]> ignoreStrategy) {
        return in(name, values, ignoreStrategy, repositoryAlias4);
    }

    public L in4(String name, String[] values, MatchStrategy matchStrategy) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias4);
    }

    public L in4(String name, String[] values, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy) {
        return in(name, values, ignoreStrategy, repositoryAlias4);
    }

    public <R extends Serializable> L in4(String name, @SuppressWarnings("unchecked") R... values) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias4);
    }

    public <R extends Serializable> L in4(String name, R value, Predicate<R> ignoreStrategy) {
        return in(name, value, ignoreStrategy, repositoryAlias4);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public L ni4(String name, int... values) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias4);
    }

    public L ni4(String name, int[] values, Predicate<int[]> ignoreStrategy) {
        return ni(name, values, ignoreStrategy, repositoryAlias4);
    }

    public L ni4(String name, long... values) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias4);
    }

    public L ni4(String name, long[] values, Predicate<long[]> ignoreStrategy) {
        return ni(name, values, ignoreStrategy, repositoryAlias4);
    }

    public L ni4(String name, double... values) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias4);
    }

    public L ni4(String name, double[] values, Predicate<double[]> ignoreStrategy) {
        return ni(name, values, ignoreStrategy, repositoryAlias4);
    }

    public L ni4(String name, String[] values, MatchStrategy matchStrategy) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias4);
    }

    public L ni4(String name, String[] values, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy) {
        return ni(name, values, ignoreStrategy, repositoryAlias4);
    }

    public <R extends Serializable> L ni4(String name, @SuppressWarnings("unchecked") R... values) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias4);
    }

    public <R extends Serializable> L ni4(String name, R value, Predicate<R> ignoreStrategy) {
        return ni(name, value, ignoreStrategy, repositoryAlias4);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public L inn4(String name, Boolean value) {
        return inn(name, value, repositoryAlias4);
    }

    public L isn4(String name, Boolean value) {
        return isn(name, value, repositoryAlias4);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public L le4(String name, int value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L le4(String name, int value, IntPredicate ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L le4(String name, long value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L le4(String name, long value, LongPredicate ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L le4(String name, double value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L le4(String name, double value, DoublePredicate ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias4);
    }

    public <E extends Enum<E>> L le4(String name, E value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public <E extends Enum<E>> L le4(String name, E value, Predicate<E> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias4);
    }

    public <N extends Number> L le4(String name, N value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public <N extends Number> L le4(String name, N value, Predicate<N> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias4);
    }

    public <D extends Date> L le4(String name, D value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public <D extends Date> L le4(String name, D value, Predicate<D> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L le4(String name, LocalTime value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L le4(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L le4(String name, LocalDate value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L le4(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L le4(String name, LocalDateTime value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L le4(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L le4(String name, String value, MatchStrategy matchStrategy) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L le4(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias4);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public L lt4(String name, int value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L lt4(String name, int value, IntPredicate ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L lt4(String name, long value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L lt4(String name, long value, LongPredicate ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L lt4(String name, double value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L lt4(String name, double value, DoublePredicate ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias4);
    }

    public <E extends Enum<E>> L lt4(String name, E value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public <E extends Enum<E>> L lt4(String name, E value, Predicate<E> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias4);
    }

    public <N extends Number> L lt4(String name, N value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public <N extends Number> L lt4(String name, N value, Predicate<N> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias4);
    }

    public <D extends Date> L lt4(String name, D value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public <D extends Date> L lt4(String name, D value, Predicate<D> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L lt4(String name, LocalTime value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L lt4(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L lt4(String name, LocalDate value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L lt4(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L lt4(String name, LocalDateTime value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L lt4(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias4);
    }

    public L lt4(String name, String value, MatchStrategy matchStrategy) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias4);
    }

    public L lt4(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias4);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public L sw4(String name, String value, MatchStrategy matchStrategy) {
        return sw(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias4);
    }

    public L sw4(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return sw(name, value, matchStrategy, ignoreStrategy, repositoryAlias4);
    }

    public L nsw4(String name, String value, MatchStrategy matchStrategy) {
        return nco(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias4);
    }

    public L nsw4(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nsw(name, value, matchStrategy, ignoreStrategy, repositoryAlias4);
    }

    public L lk4(String name, String value, MatchStrategy matchStrategy) {
        return lk(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias4);
    }

    public L lk4(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lk(name, value, matchStrategy, ignoreStrategy, repositoryAlias4);
    }

    public L nl4(String name, String value, MatchStrategy matchStrategy) {
        return nl(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias4);
    }

    public L nl4(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nl(name, value, matchStrategy, ignoreStrategy, repositoryAlias4);
    }

    // ********************************************************************
    // private method
    // ********************************************************************

    // ********************************************************************
    // protected method
    // ********************************************************************
}
