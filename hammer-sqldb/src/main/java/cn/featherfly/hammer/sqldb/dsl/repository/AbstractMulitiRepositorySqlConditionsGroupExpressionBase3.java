
package cn.featherfly.hammer.sqldb.dsl.repository;

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

import cn.featherfly.common.tuple.Tuple;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.function.CharPredicate;
import cn.featherfly.common.lang.Console;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.sqldb.Constants;

/**
 * abstract muliti repository sql conditions group expression base3.
 *
 * @author zhongj
 * @param <C> condition expression
 * @param <L> logic expression
 * @param <T> filterable repository index tuple type
 * @param <C2> condition config
 * @param <S> repository sql relation
 * @param <B> sql builder
 */
public abstract class AbstractMulitiRepositorySqlConditionsGroupExpressionBase3<C extends GroupExpression<C, L>,
    L extends GroupEndExpression<C, L>, T extends Tuple, C2 extends ConditionConfig<C2>,
    S extends RepositorySqlRelation<S, B>, B extends SqlBuilder>
    extends AbstractMulitiRepositorySqlConditionsGroupExpressionBase2<C, L, T, C2, S, B>
//    implements RepositoryBetweenExpressionBase3<C, L>, RepositoryNotBetweenExpressionBase3<C, L> //
//    , RepositoryContainsExpressionBase3<C, L>, RepositoryNotContainsExpressionBase3<C, L> //
//    , RepositoryEndWithExpressionBase3<C, L>, RepositoryNotEndWithExpressionBase3<C, L>//
//    , RepositoryEqualsExpressionBase3<C, L>, RepositoryNotEqualsExpressionBase3<C, L> //
//    , RepositoryGreatEqualsExpressionBase3<C, L>, RepositoryGreatThanExpressionBase3<C, L> //
//    , RepositoryInExpressionBase3<C, L>, RepositoryNotInExpressionBase3<C, L> //
//    , RepositoryIsNotNullExpressionBase3<C, L>, RepositoryIsNullExpressionBase3<C, L> //
//    , RepositoryLessEqualsExpressionBase3<C, L>, RepositoryLessThanExpressionBase3<C, L> //
//    , RepositoryStartWithExpressionBase3<C, L>, RepositoryNotStartWithExpressionBase3<C, L> //
//    , RepositoryLikeExpressionBase3<C, L>, RepositoryNotLikeExpressionBase3<C, L> //
// 这里注释掉是为了编译速度
/* , RepositoryFieldExpression<C, L> */ {

    /** The repository alias 3. */
    protected final String repositoryAlias3;

    /**
     * Instantiates a new abstract muliti repository sql conditions group
     * expression base 3.
     *
     * @param parent the parent
     * @param index the index
     * @param repositoryRelation the repository relation
     */
    protected AbstractMulitiRepositorySqlConditionsGroupExpressionBase3(L parent, int index, S repositoryRelation) {
        super(parent, index, repositoryRelation);
        repositoryAlias3 = repositoryRelation.getRepositoryRelation(2).getRepositoryAlias();

        if (Constants.DEBUG) {
            Console.log("{} end at time {}", this.getClass().getName(), System.currentTimeMillis());
        }
    }

    // ****************************************************************************************************************

    public L eq3(String name, boolean value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L eq3(String name, char value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L eq3(String name, char value, CharPredicate ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L eq3(String name, int value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L eq3(String name, int value, IntPredicate ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L eq3(String name, long value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L eq3(String name, long value, LongPredicate ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L eq3(String name, double value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L eq3(String name, double value, DoublePredicate ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L eq3(String name, String value, MatchStrategy matchStrategy) {
        return eq(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias3);
    }

    public L eq3(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return eq(name, value, matchStrategy, ignoreStrategy, repositoryAlias3);
    }

    public <R extends Serializable> L eq3(String name, R value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public <R extends Serializable> L eq3(String name, R value, Predicate<R> ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias3);
    }
    // ----------------------------------------------------------------------------------------------------------------

    public L ne3(String name, boolean value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L ne3(String name, char value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L ne3(String name, char value, CharPredicate ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L ne3(String name, int value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L ne3(String name, int value, IntPredicate ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L ne3(String name, long value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L ne3(String name, long value, LongPredicate ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L ne3(String name, double value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L ne3(String name, double value, DoublePredicate ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L ne3(String name, String value, MatchStrategy matchStrategy) {
        return ne(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias3);
    }

    public L ne3(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ne(name, value, matchStrategy, ignoreStrategy, repositoryAlias3);
    }

    public <R extends Serializable> L ne3(String name, R value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public <R extends Serializable> L ne3(String name, R value, Predicate<R> ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias3);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public <N extends Number> L ba3(String name, N min, N max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias3);
    }

    public <N extends Number> L ba3(String name, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias3);
    }

    public <D extends Date> L ba3(String name, D min, D max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias3);
    }

    public <D extends Date> L ba3(String name, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias3);
    }

    public L ba3(String name, LocalTime min, LocalTime max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias3);
    }

    public L ba3(String name, LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias3);
    }

    public L ba3(String name, LocalDate min, LocalDate max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias3);
    }

    public L ba3(String name, LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias3);
    }

    public L ba3(String name, LocalDateTime min, LocalDateTime max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias3);
    }

    public L ba3(String name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias3);
    }

    public L ba3(String name, String min, String max) {
        return ba(name, min, max, getIgnoreStrategy(), repositoryAlias3);
    }

    public L ba3(String name, String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias3);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public <N extends Number> L nba3(String name, N min, N max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias3);
    }

    public <N extends Number> L nba3(String name, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias3);
    }

    public <D extends Date> L nba3(String name, D min, D max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias3);
    }

    public <D extends Date> L nba3(String name, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias3);
    }

    public L nba3(String name, LocalTime min, LocalTime max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias3);
    }

    public L nba3(String name, LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias3);
    }

    public L nba3(String name, LocalDate min, LocalDate max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias3);
    }

    public L nba3(String name, LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias3);
    }

    public L nba3(String name, LocalDateTime min, LocalDateTime max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias3);
    }

    public L nba3(String name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias3);
    }

    public L nba3(String name, String min, String max) {
        return nba(name, min, max, getIgnoreStrategy(), repositoryAlias3);
    }

    public L nba3(String name, String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias3);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public L co3(String name, String value, MatchStrategy matchStrategy) {
        return co(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias3);
    }

    public L co3(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return co(name, value, matchStrategy, ignoreStrategy, repositoryAlias3);
    }

    public L nco3(String name, String value, MatchStrategy matchStrategy) {
        return nco(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias3);
    }

    public L nco3(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nco(name, value, matchStrategy, ignoreStrategy, repositoryAlias3);
    }

    public L ew3(String name, String value, MatchStrategy matchStrategy) {
        return ew(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias3);
    }

    public L ew3(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ew(name, value, matchStrategy, ignoreStrategy, repositoryAlias3);
    }

    public L new3(String name, String value, MatchStrategy matchStrategy) {
        return newv(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias3);
    }

    public L new3(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return newv(name, value, matchStrategy, ignoreStrategy, repositoryAlias3);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public L ge3(String name, int value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L ge3(String name, int value, IntPredicate ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L ge3(String name, long value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L ge3(String name, long value, LongPredicate ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L ge3(String name, double value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L ge3(String name, double value, DoublePredicate ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias3);
    }

    public <E extends Enum<E>> L ge3(String name, E value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public <E extends Enum<E>> L ge3(String name, E value, Predicate<E> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias3);
    }

    public <N extends Number> L ge3(String name, N value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public <N extends Number> L ge3(String name, N value, Predicate<N> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias3);
    }

    public <D extends Date> L ge3(String name, D value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public <D extends Date> L ge3(String name, D value, Predicate<D> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L ge3(String name, LocalTime value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L ge3(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L ge3(String name, LocalDate value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L ge3(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L ge3(String name, LocalDateTime value) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L ge3(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L ge3(String name, String value, MatchStrategy matchStrategy) {
        return ge(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L ge3(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ge(name, value, ignoreStrategy, repositoryAlias3);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public L gt3(String name, int value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L gt3(String name, int value, IntPredicate ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L gt3(String name, long value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L gt3(String name, long value, LongPredicate ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L gt3(String name, double value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L gt3(String name, double value, DoublePredicate ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias3);
    }

    public <E extends Enum<E>> L gt3(String name, E value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public <E extends Enum<E>> L gt3(String name, E value, Predicate<E> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias3);
    }

    public <N extends Number> L gt3(String name, N value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public <N extends Number> L gt3(String name, N value, Predicate<N> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias3);
    }

    public <D extends Date> L gt3(String name, D value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public <D extends Date> L gt3(String name, D value, Predicate<D> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L gt3(String name, LocalTime value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L gt3(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L gt3(String name, LocalDate value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L gt3(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L gt3(String name, LocalDateTime value) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L gt3(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L gt3(String name, String value, MatchStrategy matchStrategy) {
        return gt(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L gt3(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return gt(name, value, ignoreStrategy, repositoryAlias3);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public L in3(String name, int... values) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias3);
    }

    public L in3(String name, int[] values, Predicate<int[]> ignoreStrategy) {
        return in(name, values, ignoreStrategy, repositoryAlias3);
    }

    public L in3(String name, long... values) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias3);
    }

    public L in3(String name, long[] values, Predicate<long[]> ignoreStrategy) {
        return in(name, values, ignoreStrategy, repositoryAlias3);
    }

    public L in3(String name, double... values) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias3);
    }

    public L in3(String name, double[] values, Predicate<double[]> ignoreStrategy) {
        return in(name, values, ignoreStrategy, repositoryAlias3);
    }

    public L in3(String name, String[] values, MatchStrategy matchStrategy) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias3);
    }

    public L in3(String name, String[] values, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy) {
        return in(name, values, ignoreStrategy, repositoryAlias3);
    }

    public <R extends Serializable> L in3(String name, @SuppressWarnings("unchecked") R... values) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias3);
    }

    public <R extends Serializable> L in3(String name, R value, Predicate<R> ignoreStrategy) {
        return in(name, value, ignoreStrategy, repositoryAlias3);
    }

    public <R extends Serializable> L in3(String name, R[] value, Predicate<R[]> ignoreStrategy) {
        return in(name, value, ignoreStrategy, repositoryAlias3);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public L ni3(String name, int... values) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias3);
    }

    public L ni3(String name, int[] values, Predicate<int[]> ignoreStrategy) {
        return ni(name, values, ignoreStrategy, repositoryAlias3);
    }

    public L ni3(String name, long... values) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias3);
    }

    public L ni3(String name, long[] values, Predicate<long[]> ignoreStrategy) {
        return ni(name, values, ignoreStrategy, repositoryAlias3);
    }

    public L ni3(String name, double... values) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias3);
    }

    public L ni3(String name, double[] values, Predicate<double[]> ignoreStrategy) {
        return ni(name, values, ignoreStrategy, repositoryAlias3);
    }

    public L ni3(String name, String[] values, MatchStrategy matchStrategy) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias3);
    }

    public L ni3(String name, String[] values, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy) {
        return ni(name, values, ignoreStrategy, repositoryAlias3);
    }

    public <R extends Serializable> L ni3(String name, @SuppressWarnings("unchecked") R... values) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias3);
    }

    public <R extends Serializable> L ni3(String name, R value, Predicate<R> ignoreStrategy) {
        return ni(name, value, ignoreStrategy, repositoryAlias3);
    }

    public <R extends Serializable> L ni3(String name, R[] value, Predicate<R[]> ignoreStrategy) {
        return ni(name, value, ignoreStrategy, repositoryAlias3);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public L inn3(String name, Boolean value) {
        return inn(name, value, repositoryAlias3);
    }

    public L isn3(String name, Boolean value) {
        return isn(name, value, repositoryAlias3);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public L le3(String name, int value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L le3(String name, int value, IntPredicate ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L le3(String name, long value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L le3(String name, long value, LongPredicate ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L le3(String name, double value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L le3(String name, double value, DoublePredicate ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias3);
    }

    public <E extends Enum<E>> L le3(String name, E value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public <E extends Enum<E>> L le3(String name, E value, Predicate<E> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias3);
    }

    public <N extends Number> L le3(String name, N value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public <N extends Number> L le3(String name, N value, Predicate<N> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias3);
    }

    public <D extends Date> L le3(String name, D value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public <D extends Date> L le3(String name, D value, Predicate<D> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L le3(String name, LocalTime value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L le3(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L le3(String name, LocalDate value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L le3(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L le3(String name, LocalDateTime value) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L le3(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L le3(String name, String value, MatchStrategy matchStrategy) {
        return le(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L le3(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return le(name, value, ignoreStrategy, repositoryAlias3);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public L lt3(String name, int value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L lt3(String name, int value, IntPredicate ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L lt3(String name, long value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L lt3(String name, long value, LongPredicate ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L lt3(String name, double value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L lt3(String name, double value, DoublePredicate ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias3);
    }

    public <E extends Enum<E>> L lt3(String name, E value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public <E extends Enum<E>> L lt3(String name, E value, Predicate<E> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias3);
    }

    public <N extends Number> L lt3(String name, N value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public <N extends Number> L lt3(String name, N value, Predicate<N> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias3);
    }

    public <D extends Date> L lt3(String name, D value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public <D extends Date> L lt3(String name, D value, Predicate<D> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L lt3(String name, LocalTime value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L lt3(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L lt3(String name, LocalDate value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L lt3(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L lt3(String name, LocalDateTime value) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L lt3(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias3);
    }

    public L lt3(String name, String value, MatchStrategy matchStrategy) {
        return lt(name, value, getIgnoreStrategy(), repositoryAlias3);
    }

    public L lt3(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lt(name, value, ignoreStrategy, repositoryAlias3);
    }

    // ----------------------------------------------------------------------------------------------------------------

    public L sw3(String name, String value, MatchStrategy matchStrategy) {
        return sw(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias3);
    }

    public L sw3(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return sw(name, value, matchStrategy, ignoreStrategy, repositoryAlias3);
    }

    public L nsw3(String name, String value, MatchStrategy matchStrategy) {
        return nco(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias3);
    }

    public L nsw3(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nsw(name, value, matchStrategy, ignoreStrategy, repositoryAlias3);
    }

    public L lk3(String name, String value, MatchStrategy matchStrategy) {
        return lk(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias3);
    }

    public L lk3(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lk(name, value, matchStrategy, ignoreStrategy, repositoryAlias3);
    }

    public L nl3(String name, String value, MatchStrategy matchStrategy) {
        return nl(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias3);
    }

    public L nl3(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nl(name, value, matchStrategy, ignoreStrategy, repositoryAlias3);
    }

    // ********************************************************************
    // private method
    // ********************************************************************

    // ********************************************************************
    // protected method
    // ********************************************************************
}
