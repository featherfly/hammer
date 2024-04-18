/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-15 15:20:15
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import com.speedment.common.tuple.Tuple;

import cn.featherfly.common.db.SqlUtils;
import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.function.CharPredicate;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.Console;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializableSupplierLambdaInfo;
import cn.featherfly.common.operator.ComparisonOperator;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.Execution;
import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.MulitiRepositoryFieldExpression;
import cn.featherfly.hammer.expression.condition.NativeStringConditionExpression;
import cn.featherfly.hammer.expression.condition.ParamedExpression;
import cn.featherfly.hammer.expression.condition.field.FieldExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.ba.RepositoryBetweenExpression;
import cn.featherfly.hammer.expression.repository.condition.co.RepositoryContainsExpression;
import cn.featherfly.hammer.expression.repository.condition.eq.RepositoryEqualsExpression;
import cn.featherfly.hammer.expression.repository.condition.ew.RepositoryEndWithExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryDateFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryEnumFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryLocalDateFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryLocalDateTimeFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryLocalTimeFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryNumberFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositorySerializableFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryStringFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.ge.RepositoryGreatEqualsExpression;
import cn.featherfly.hammer.expression.repository.condition.gt.RepositoryGreatThanExpression;
import cn.featherfly.hammer.expression.repository.condition.in.RepositoryInExpression;
import cn.featherfly.hammer.expression.repository.condition.inn.RepositoryIsNotNullExpression;
import cn.featherfly.hammer.expression.repository.condition.isn.RepositoryIsNullExpression;
import cn.featherfly.hammer.expression.repository.condition.le.RepositoryLessEqualsExpression;
import cn.featherfly.hammer.expression.repository.condition.lk.RepositoryLikeExpression;
import cn.featherfly.hammer.expression.repository.condition.lt.RepositoryLessThanExpression;
import cn.featherfly.hammer.expression.repository.condition.nba.RepositoryNotBetweenExpression;
import cn.featherfly.hammer.expression.repository.condition.nco.RepositoryNotContainsExpression;
import cn.featherfly.hammer.expression.repository.condition.ne.RepositoryNotEqualsExpression;
import cn.featherfly.hammer.expression.repository.condition.newv.RepositoryNotEndWithExpression;
import cn.featherfly.hammer.expression.repository.condition.ni.RepositoryNotInExpression;
import cn.featherfly.hammer.expression.repository.condition.nl.RepositoryNotLikeExpression;
import cn.featherfly.hammer.expression.repository.condition.nsw.RepositoryNotStartWithExpression;
import cn.featherfly.hammer.expression.repository.condition.sw.RepositoryStartWithExpression;
import cn.featherfly.hammer.sqldb.Constants;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.AbstractMulitiRepositorySqlConditionExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.DateFieldExpressionMulitiRepositoryImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.EnumFieldExpressionMulitiRepositoryImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.LocalDateFieldExpressionMulitiRepositoryImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.LocalDateTimeFieldExpressionMulitiRepositoryImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.LocalTimeFieldExpressionMulitiRepositoryImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.NumberFieldExpressionMulitiRepositoryImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.SerializableFieldExpressionMulitiRepositoryImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.StringFieldExpressionMulitiRepositoryImpl;
import cn.featherfly.hammer.sqldb.sql.dml.SqlConditionExpressionBuilder;

/**
 * abstract muliti repository condition expression.
 *
 * @author zhongj
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <T>  the generic type
 * @param <C2> the generic type
 * @param <S>  the generic type
 * @param <B>  the generic type
 */
@SuppressWarnings("unchecked")
public abstract class AbstractMulitiRepositorySqlConditionsExpressionBase<C extends ConditionExpression,
    L extends LogicExpression<C, L>, T extends Tuple, C2 extends ConditionConfig<C2>,
    S extends RepositorySqlRelation<S, B>, B extends SqlBuilder>
    extends AbstractMulitiRepositorySqlConditionExpression<C, L, C2, S, B>
    implements RepositoryBetweenExpression<C, L>, RepositoryNotBetweenExpression<C, L> //
    , RepositoryContainsExpression<C, L>, RepositoryNotContainsExpression<C, L>//
    , RepositoryEndWithExpression<C, L>, RepositoryNotEndWithExpression<C, L> //
    , RepositoryEqualsExpression<C, L>, RepositoryIsNotNullExpression<C, L>//
    , RepositoryGreatEqualsExpression<C, L>, RepositoryGreatThanExpression<C, L> //
    , RepositoryInExpression<C, L>, RepositoryNotInExpression<C, L>//
    , RepositoryIsNullExpression<C, L>, RepositoryNotEqualsExpression<C, L> //
    , RepositoryLessEqualsExpression<C, L>, RepositoryLessThanExpression<C, L> //
    , RepositoryStartWithExpression<C, L>, RepositoryNotStartWithExpression<C, L>//
    , RepositoryLikeExpression<C, L>, RepositoryNotLikeExpression<C, L>//
    , NativeStringConditionExpression<C, L> //
    , RepositoryFieldExpression<C, L>, MulitiRepositoryFieldExpression<T, C, L> {

    /**
     * Instantiates a new abstract muliti repository condition expression.
     *
     * @param parent             the parent
     * @param index              the index
     * @param repositoryRelation the repository relation
     */
    protected AbstractMulitiRepositorySqlConditionsExpressionBase(L parent, int index, S repositoryRelation) {
        super(parent, index, repositoryRelation);
        if (Constants.DEBUG) {
            Console.log("{} end at time {}", this.getClass().getName(), System.currentTimeMillis());
        }
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, FieldExpression value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, Field value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, boolean value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, char value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, char value, CharPredicate ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, int value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, int value, IntPredicate ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, long value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, long value, LongPredicate ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, double value) {
        return eq(name, value, getIgnoreStrategy(), repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, double value, DoublePredicate ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, String value, MatchStrategy matchStrategy) {
        return eq(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return eq(name, value, matchStrategy, ignoreStrategy, repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L eq(String name, R value) {
        return eq(name, value, getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L eq(String name, R value, Predicate<R> ignoreStrategy) {
        return eq(name, value, ignoreStrategy, repositoryAlias);
    }
    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, boolean value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, char value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, char value, CharPredicate ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, int value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, int value, IntPredicate ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, long value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, long value, LongPredicate ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, double value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, double value, DoublePredicate ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, String value, MatchStrategy matchStrategy) {
        return ne(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ne(name, value, matchStrategy, ignoreStrategy, repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ne(String name, R value) {
        return ne(name, value, getIgnoreStrategy(), repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ne(String name, R value, Predicate<R> ignoreStrategy) {
        return ne(name, value, ignoreStrategy, repositoryAlias);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String name, String value, MatchStrategy matchStrategy) {
        return lk(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lk(name, value, matchStrategy, ignoreStrategy, repositoryAlias);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(String name, String value, MatchStrategy matchStrategy) {
        return nl(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nl(name, value, matchStrategy, ignoreStrategy, repositoryAlias);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String name, String value, MatchStrategy matchStrategy) {
        return sw(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return sw(name, value, matchStrategy, ignoreStrategy, repositoryAlias);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(String name, String value, MatchStrategy matchStrategy) {
        return nsw(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nsw(name, value, matchStrategy, ignoreStrategy, repositoryAlias);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String name, String value, MatchStrategy matchStrategy) {
        return ew(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ew(name, value, matchStrategy, ignoreStrategy, repositoryAlias);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(String name, String value, MatchStrategy matchStrategy) {
        return newv(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return newv(name, value, matchStrategy, ignoreStrategy, repositoryAlias);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String name, String value, MatchStrategy matchStrategy) {
        return co(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return co(name, value, matchStrategy, ignoreStrategy, repositoryAlias);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(String name, String value, MatchStrategy matchStrategy) {
        return newv(name, value, matchStrategy, getIgnoreStrategy(), repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return newv(name, value, matchStrategy, ignoreStrategy, repositoryAlias);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(String name, N value) {
        return ge(name, value, getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(String name, N value, Predicate<N> ignoreStrategy) {
        return ge0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(String name, D value) {
        return ge0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(String name, D value, Predicate<D> ignoreStrategy) {
        return ge0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalTime value) {
        return ge0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalDate value) {
        return ge0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalDateTime value) {
        return ge0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return ge0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, int value) {
        return ge0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, int value, IntPredicate ignoreStrategy) {
        return ge0(name, value, v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, long value) {
        return ge0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, long value, LongPredicate ignoreStrategy) {
        return ge0(name, value, v -> ignoreStrategy.test((Long) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, double value) {
        return ge0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, double value, DoublePredicate ignoreStrategy) {
        return ge0(name, value, v -> ignoreStrategy.test((Double) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge(String name, E value) {
        return ge0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge(String name, E value, Predicate<E> ignoreStrategy) {
        return ge0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, String value, MatchStrategy matchStrategy) {
        return ge0(name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ge0(name, value, matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(String name, N value) {
        return gt0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L gt(String name, N value, Predicate<N> ignoreStrategy) {
        return gt0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(String name, D value) {
        return gt0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L gt(String name, D value, Predicate<D> ignoreStrategy) {
        return gt0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalTime value) {
        return gt0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalDate value) {
        return gt0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalDateTime value) {
        return gt0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return gt0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, int value) {
        return gt0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, int value, IntPredicate ignoreStrategy) {
        return gt0(name, value, v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, long value) {
        return gt0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, long value, LongPredicate ignoreStrategy) {
        return gt0(name, value, v -> ignoreStrategy.test((Long) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, double value) {
        return gt0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, double value, DoublePredicate ignoreStrategy) {
        return gt0(name, value, v -> ignoreStrategy.test((Double) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L gt(String name, E value) {
        return gt0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L gt(String name, E value, Predicate<E> ignoreStrategy) {
        return gt0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, String value, MatchStrategy matchStrategy) {
        return gt0(name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return gt0(name, value, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************
    //  in
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String name, int... values) {
        return in(name, values, getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String name, int[] values, Predicate<int[]> ignoreStrategy) {
        return in(name, (Serializable) values, v -> ignoreStrategy.test(ArrayUtils.unpack((Integer[]) v)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String name, long... values) {
        return in(name, values, getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String name, long[] values, Predicate<long[]> ignoreStrategy) {
        return in(name, (Serializable) values, v -> ignoreStrategy.test(ArrayUtils.unpack((Long[]) v)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String name, double... values) {
        return in(name, values, getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String name, double[] values, Predicate<double[]> ignoreStrategy) {
        return in(name, (Serializable) values, v -> ignoreStrategy.test(ArrayUtils.unpack((Double[]) v)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String name, String[] values, MatchStrategy matchStrategy) {
        return in(name, values, matchStrategy, getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String name, String[] values, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy) {
        return in(name, values, matchStrategy, ignoreStrategy, repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in(String name, R... values) {
        return in(name, values, getIgnoreStrategy(), repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in(String name, R value, Predicate<R> ignoreStrategy) {
        return in(name, value, ignoreStrategy, repositoryAlias);
    }

    /**
     * In.
     *
     * @param <R>             the generic type
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected <R> L in(String name, R value, Predicate<R> ignoreStrategy, String repositoryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, getInParam(value),
            ComparisonOperator.IN, repositoryAlias, ignoreStrategy));
    }

    /**
     * In.
     *
     * @param name            the name
     * @param values          the values
     * @param matchStrategy   the match strategy
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L in(String name, String[] values, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy,
        String repositoryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, getInParam(values),
            ComparisonOperator.IN, matchStrategy, repositoryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(String name, Boolean value) {
        return inn(name, value, repositoryAlias);
    }

    /**
     * Inn.
     *
     * @param name            the name
     * @param value           the value
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L inn(String name, Boolean value, String repositoryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.INN,
            repositoryAlias, getIgnoreStrategy()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(String name, Boolean value) {
        return isn(name, value, repositoryAlias);
    }

    /**
     * Isn.
     *
     * @param name            the name
     * @param value           the value
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L isn(String name, Boolean value, String repositoryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.ISN,
            repositoryAlias, getIgnoreStrategy()));
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(String name, N value) {
        return le0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L le(String name, N value, Predicate<N> ignoreStrategy) {
        return le0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le(String name, D value) {
        return le0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L le(String name, D value, Predicate<D> ignoreStrategy) {
        return le0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalTime value) {
        return le0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return le0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalDate value) {
        return le0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return le0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalDateTime value) {
        return le0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return le0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, String value) {
        return le0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, String value, Predicate<String> ignoreStrategy) {
        return le0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, int value) {
        return le0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, int value, IntPredicate ignoreStrategy) {
        return le0(name, value, v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, long value) {
        return le0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, long value, LongPredicate ignoreStrategy) {
        return le0(name, value, v -> ignoreStrategy.test((Long) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, double value) {
        return le0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, double value, DoublePredicate ignoreStrategy) {
        return le0(name, value, v -> ignoreStrategy.test((Double) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L le(String name, E value) {
        return le0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L le(String name, E value, Predicate<E> ignoreStrategy) {
        return le0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, String value, MatchStrategy matchStrategy) {
        return le0(name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return le0(name, value, matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(String name, N value) {
        return lt0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(String name, N value, Predicate<N> ignoreStrategy) {
        return lt0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(String name, D value) {
        return lt0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(String name, D value, Predicate<D> ignoreStrategy) {
        return lt0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalTime value) {
        return lt0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalDate value) {
        return lt0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalDateTime value) {
        return lt0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return lt0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, int value) {
        return lt0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, int value, IntPredicate ignoreStrategy) {
        return lt0(name, value, v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, long value) {
        return lt0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, long value, LongPredicate ignoreStrategy) {
        return lt0(name, value, v -> ignoreStrategy.test((Long) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, double value) {
        return lt0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, double value, DoublePredicate ignoreStrategy) {
        return lt0(name, value, v -> ignoreStrategy.test((Double) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt(String name, E value) {
        return lt0(name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt(String name, E value, Predicate<E> ignoreStrategy) {
        return lt0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, String value, MatchStrategy matchStrategy) {
        return lt0(name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lt0(name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        SerializableSupplierLambdaInfo<String> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return lt(info.getSerializedLambdaInfo().getPropertyName(), info.getValue(), ignoreStrategy);
    }

    // ****************************************************************************************************************
    //  ni
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String name, int... values) {
        return ni(name, values, getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String name, int[] values, Predicate<int[]> ignoreStrategy) {
        return ni(name, (Serializable) values, v -> ignoreStrategy.test(ArrayUtils.unpack((Integer[]) v)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String name, long... values) {
        return ni(name, values, getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String name, long[] values, Predicate<long[]> ignoreStrategy) {
        return ni(name, (Serializable) values, v -> ignoreStrategy.test(ArrayUtils.unpack((Long[]) v)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String name, double... values) {
        return ni(name, values, getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String name, double[] values, Predicate<double[]> ignoreStrategy) {
        return ni(name, (Serializable) values, v -> ignoreStrategy.test(ArrayUtils.unpack((Double[]) v)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String name, String[] values, MatchStrategy matchStrategy) {
        return ni(name, values, matchStrategy, getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String name, String[] values, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy) {
        return ni(name, values, matchStrategy, ignoreStrategy, repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni(String name, R... values) {
        return ni(name, values, getIgnoreStrategy(), repositoryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni(String name, R value, Predicate<R> ignoreStrategy) {
        return ni(name, value, ignoreStrategy, repositoryAlias);
    }

    /**
     * Ni.
     *
     * @param <R>             the generic type
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected <R> L ni(String name, R value, Predicate<R> ignoreStrategy, String repositoryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, getInParam(value),
            ComparisonOperator.NI, repositoryAlias, ignoreStrategy));
    }

    /**
     * Ni.
     *
     * @param name            the name
     * @param values          the values
     * @param matchStrategy   the match strategy
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L ni(String name, String[] values, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy,
        String repositoryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, getInParam(values),
            ComparisonOperator.NI, matchStrategy, repositoryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba(String name, N min, N max) {
        return ba0(name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ba(String name, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return ba0(name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba(String name, D min, D max) {
        return ba0(name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ba(String name, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return ba0(name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(String name, LocalTime min, LocalTime max) {
        return ba0(name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(String name, LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba0(name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(String name, LocalDate min, LocalDate max) {
        return ba0(name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(String name, LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba0(name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(String name, LocalDateTime min, LocalDateTime max) {
        return ba0(name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(String name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba0(name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(String name, String min, String max) {
        return ba0(name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(String name, String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return ba0(name, min, max, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    private L ba0(String name, Object min, Object max, BiPredicate<?, ?> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias);
    }

    private L ba0(String name, Object min, Object max, Predicate<?> ignoreStrategy) {
        return ba(name, min, max, ignoreStrategy, repositoryAlias);
    }

    /**
     * Ba.
     *
     * @param name            the name
     * @param min             the min
     * @param max             the max
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L ba(String name, Object min, Object max, BiPredicate<?, ?> ignoreStrategy, String repositoryAlias) {
        return ba(name, min, max, v -> {
            Object[] params = (Object[]) v;
            return ((BiPredicate<Object, Object>) ignoreStrategy).test(params[0], params[1]);
        }, repositoryAlias);
    }

    /**
     * Ba.
     *
     * @param name            the name
     * @param min             the min
     * @param max             the max
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L ba(String name, Object min, Object max, Predicate<?> ignoreStrategy, String repositoryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, new Object[] { min, max },
            ComparisonOperator.BA, repositoryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba(String name, N min, N max) {
        return nba0(name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba(String name, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return nba0(name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba(String name, D min, D max) {
        return nba0(name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba(String name, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return nba0(name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(String name, LocalTime min, LocalTime max) {
        return nba0(name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(String name, LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba0(name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(String name, LocalDate min, LocalDate max) {
        return nba0(name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(String name, LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba0(name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(String name, LocalDateTime min, LocalDateTime max) {
        return nba0(name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(String name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba0(name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(String name, String min, String max) {
        return nba0(name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(String name, String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return nba0(name, min, max, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    private L nba0(String name, Object min, Object max, BiPredicate<?, ?> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias);
    }

    private L nba0(String name, Object min, Object max, Predicate<?> ignoreStrategy) {
        return nba(name, min, max, ignoreStrategy, repositoryAlias);
    }

    /**
     * Nba.
     *
     * @param name            the name
     * @param min             the min
     * @param max             the max
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L nba(String name, Object min, Object max, BiPredicate<?, ?> ignoreStrategy, String repositoryAlias) {
        return nba(name, min, max, v -> {
            Object[] params = (Object[]) v;
            return ((BiPredicate<Object, Object>) ignoreStrategy).test(params[0], params[1]);
        }, repositoryAlias);
    }

    /**
     * Nba.
     *
     * @param name            the name
     * @param min             the min
     * @param max             the max
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L nba(String name, Object min, Object max, Predicate<?> ignoreStrategy, String repositoryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, new Object[] { min, max },
            ComparisonOperator.NBA, repositoryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    private L ge0(String name, Object value, Predicate<?> ignoreStrategy) {
        return ge0(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    private L ge0(String name, Object value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return ge(name, value, matchStrategy, ignoreStrategy, repositoryAlias);
    }

    /**
     * Ge.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L ge(String name, int value, IntPredicate ignoreStrategy, String repositoryAlias) {
        return ge(name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test(value), repositoryAlias);
    }

    /**
     * Ge.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L ge(String name, long value, LongPredicate ignoreStrategy, String repositoryAlias) {
        return ge(name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test(value), repositoryAlias);
    }

    /**
     * Ge.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L ge(String name, double value, DoublePredicate ignoreStrategy, String repositoryAlias) {
        return ge(name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test(value), repositoryAlias);
    }

    /**
     * Ge.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L ge(String name, Object value, Predicate<?> ignoreStrategy, String repositoryAlias) {
        return ge(name, value, MatchStrategy.AUTO, ignoreStrategy, repositoryAlias);
    }

    /**
     * Ge.
     *
     * @param name            the name
     * @param value           the value
     * @param matchStrategy   the match strategy
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L ge(String name, Object value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy,
        String repositoryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    private L gt0(String name, Object value, Predicate<?> ignoreStrategy) {
        return gt0(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    private L gt0(String name, Object value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return gt(name, value, matchStrategy, ignoreStrategy, repositoryAlias);
    }

    /**
     * Gt.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L gt(String name, int value, IntPredicate ignoreStrategy, String repositoryAlias) {
        return gt(name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test(value), repositoryAlias);
    }

    /**
     * Gt.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L gt(String name, long value, LongPredicate ignoreStrategy, String repositoryAlias) {
        return gt(name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test(value), repositoryAlias);
    }

    /**
     * Gt.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L gt(String name, double value, DoublePredicate ignoreStrategy, String repositoryAlias) {
        return gt(name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test(value), repositoryAlias);
    }

    /**
     * Gt.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L gt(String name, Object value, Predicate<?> ignoreStrategy, String repositoryAlias) {
        return gt(name, value, MatchStrategy.AUTO, ignoreStrategy, repositoryAlias);
    }

    /**
     * Gt.
     *
     * @param name            the name
     * @param value           the value
     * @param matchStrategy   the match strategy
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L gt(String name, Object value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy,
        String repositoryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    private L le0(String name, Object value, Predicate<?> ignoreStrategy) {
        return le0(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    private L le0(String name, Object value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return le(name, value, matchStrategy, ignoreStrategy, repositoryAlias);
    }

    /**
     * Le.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L le(String name, int value, IntPredicate ignoreStrategy, String repositoryAlias) {
        return le(name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test(value), repositoryAlias);
    }

    /**
     * Le.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L le(String name, long value, LongPredicate ignoreStrategy, String repositoryAlias) {
        return le(name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test(value), repositoryAlias);
    }

    /**
     * Le.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L le(String name, double value, DoublePredicate ignoreStrategy, String repositoryAlias) {
        return le(name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test(value), repositoryAlias);
    }

    /**
     * Le.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L le(String name, Object value, Predicate<?> ignoreStrategy, String repositoryAlias) {
        return le(name, value, MatchStrategy.AUTO, ignoreStrategy, repositoryAlias);
    }

    /**
     * Le.
     *
     * @param name            the name
     * @param value           the value
     * @param matchStrategy   the match strategy
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L le(String name, Object value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy,
        String repositoryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    private L lt0(String name, Object value, Predicate<?> ignoreStrategy) {
        return lt0(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    private L lt0(String name, Object value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return lt(name, value, matchStrategy, ignoreStrategy, repositoryAlias);
    }

    /**
     * Lt.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L lt(String name, int value, IntPredicate ignoreStrategy, String repositoryAlias) {
        return lt(name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test(value), repositoryAlias);
    }

    /**
     * Lt.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L lt(String name, long value, LongPredicate ignoreStrategy, String repositoryAlias) {
        return lt(name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test(value), repositoryAlias);
    }

    /**
     * Lt.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L lt(String name, double value, DoublePredicate ignoreStrategy, String repositoryAlias) {
        return lt(name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test(value), repositoryAlias);
    }

    /**
     * Lt.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L lt(String name, Object value, Predicate<?> ignoreStrategy, String repositoryAlias) {
        return lt(name, value, MatchStrategy.AUTO, ignoreStrategy, repositoryAlias);
    }

    /**
     * Lt.
     *
     * @param name            the name
     * @param value           the value
     * @param matchStrategy   the match strategy
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L lt(String name, Object value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy,
        String repositoryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    // ----------------------------------------------------------------------------------------------------------------

    // ****************************************************************************************************************
    // protected method

    /**
     * Eq.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L eq(String name, char value, CharPredicate ignoreStrategy, String repositoryAlias) {
        return eq(name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test(value), repositoryAlias);
    }

    /**
     * Eq.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L eq(String name, int value, IntPredicate ignoreStrategy, String repositoryAlias) {
        return eq(name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test(value), repositoryAlias);
    }

    /**
     * Eq.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L eq(String name, long value, LongPredicate ignoreStrategy, String repositoryAlias) {
        return eq(name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test(value), repositoryAlias);
    }

    /**
     * Eq.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L eq(String name, double value, DoublePredicate ignoreStrategy, String repositoryAlias) {
        return eq(name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test(value), repositoryAlias);
    }

    /**
     * Eq.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L eq(String name, Object value, Predicate<?> ignoreStrategy, String repositoryAlias) {
        return eq(name, value, MatchStrategy.AUTO, ignoreStrategy, repositoryAlias);
    }

    /**
     * Eq.
     *
     * @param name            the name
     * @param value           the value
     * @param matchStrategy   the match strategy
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L eq(String name, Object value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy,
        String repositoryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EQ,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    /**
     * Ne.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L ne(String name, char value, CharPredicate ignoreStrategy, String repositoryAlias) {
        return ne(name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test(value), repositoryAlias);
    }

    /**
     * Ne.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L ne(String name, int value, IntPredicate ignoreStrategy, String repositoryAlias) {
        return ne(name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test(value), repositoryAlias);
    }

    /**
     * Ne.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L ne(String name, long value, LongPredicate ignoreStrategy, String repositoryAlias) {
        return ne(name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test(value), repositoryAlias);
    }

    /**
     * Ne.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L ne(String name, double value, DoublePredicate ignoreStrategy, String repositoryAlias) {
        return ne(name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test(value), repositoryAlias);
    }

    /**
     * Ne.
     *
     * @param name            the name
     * @param value           the value
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L ne(String name, Object value, Predicate<?> ignoreStrategy, String repositoryAlias) {
        return ne(name, value, MatchStrategy.AUTO, ignoreStrategy, repositoryAlias);
    }

    /**
     * Ne.
     *
     * @param name            the name
     * @param value           the value
     * @param matchStrategy   the match strategy
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L ne(String name, Object value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy,
        String repositoryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.NE,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Lk.
     *
     * @param name            the name
     * @param value           the value
     * @param matchStrategy   the match strategy
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L lk(String name, String value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy,
        String repositoryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LK,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    /**
     * Nl.
     *
     * @param name            the name
     * @param value           the value
     * @param matchStrategy   the match strategy
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L nl(String name, String value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy,
        String repositoryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.NL,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    /**
     * Sw.
     *
     * @param name            the name
     * @param value           the value
     * @param matchStrategy   the match strategy
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L sw(String name, String value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy,
        String repositoryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.SW,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    /**
     * Nsw.
     *
     * @param name            the name
     * @param value           the value
     * @param matchStrategy   the match strategy
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L nsw(String name, String value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy,
        String repositoryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.NSW,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    /**
     * Co.
     *
     * @param name            the name
     * @param value           the value
     * @param matchStrategy   the match strategy
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L co(String name, String value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy,
        String repositoryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.CO,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    /**
     * Nco.
     *
     * @param name            the name
     * @param value           the value
     * @param matchStrategy   the match strategy
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L nco(String name, String value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy,
        String repositoryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.NCO,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    /**
     * Ew.
     *
     * @param name            the name
     * @param value           the value
     * @param matchStrategy   the match strategy
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L ew(String name, String value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy,
        String repositoryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EW,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    /**
     * Newv.
     *
     * @param name            the name
     * @param value           the value
     * @param matchStrategy   the match strategy
     * @param ignoreStrategy  the ignore strategy
     * @param repositoryAlias the repository alias
     * @return the l
     */
    protected L newv(String name, String value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy,
        String repositoryAlias) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.NEW,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Creates the tuple.
     *
     * @return the t
     */
    protected abstract T createTuple();

    // protected method
    // ****************************************************************************************************************

    // ****************************************************************************************************************
    // field expression
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositorySerializableFieldExpression<C, L> field(String name) {
        return new SerializableFieldExpressionMulitiRepositoryImpl<>(index, name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryStringFieldExpression<C, L> fieldAsString(String name) {
        return new StringFieldExpressionMulitiRepositoryImpl<>(index, name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositoryNumberFieldExpression<N, C, L> fieldAsNumber(String name) {
        return new NumberFieldExpressionMulitiRepositoryImpl<>(index, name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> RepositoryDateFieldExpression<D, C, L> fieldAsDate(String name) {
        return new DateFieldExpressionMulitiRepositoryImpl<>(index, name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> RepositoryEnumFieldExpression<E, C, L> fieldAsEnum(String name) {
        return new EnumFieldExpressionMulitiRepositoryImpl<>(index, name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryLocalDateFieldExpression<C, L> fieldAsLocalDate(String name) {
        return new LocalDateFieldExpressionMulitiRepositoryImpl<>(index, name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryLocalDateTimeFieldExpression<C, L> fieldAsLocalDateTime(String name) {
        return new LocalDateTimeFieldExpressionMulitiRepositoryImpl<>(index, name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryLocalTimeFieldExpression<C, L> fieldAsLocalTime(String name) {
        return new LocalTimeFieldExpressionMulitiRepositoryImpl<>(index, name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositorySerializableFieldExpression<C, L> field(ToIntFunction<T> repositoiesFunction, String name) {
        return new SerializableFieldExpressionMulitiRepositoryImpl<>(repositoiesFunction.applyAsInt(createTuple()),
            name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryStringFieldExpression<C, L> fieldAsString(ToIntFunction<T> repositoiesFunction, String name) {
        return new StringFieldExpressionMulitiRepositoryImpl<>(repositoiesFunction.applyAsInt(createTuple()), name,
            this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositoryNumberFieldExpression<N, C, L> fieldAsNumber(
        ToIntFunction<T> repositoiesFunction, String name) {
        return new NumberFieldExpressionMulitiRepositoryImpl<>(repositoiesFunction.applyAsInt(createTuple()), name,
            this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Enum<R>> RepositoryEnumFieldExpression<R, C, L> fieldAsEnum(ToIntFunction<T> repositoiesFunction,
        String name) {
        return new EnumFieldExpressionMulitiRepositoryImpl<>(repositoiesFunction.applyAsInt(createTuple()), name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> RepositoryDateFieldExpression<D, C, L> fieldAsDate(ToIntFunction<T> repositoiesFunction,
        String name) {
        return new DateFieldExpressionMulitiRepositoryImpl<>(repositoiesFunction.applyAsInt(createTuple()), name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryLocalDateFieldExpression<C, L> fieldAsLocalDate(ToIntFunction<T> repositoiesFunction,
        String name) {
        return new LocalDateFieldExpressionMulitiRepositoryImpl<>(repositoiesFunction.applyAsInt(createTuple()), name,
            this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryLocalDateTimeFieldExpression<C, L> fieldAsLocalDateTime(ToIntFunction<T> repositoiesFunction,
        String name) {
        return new LocalDateTimeFieldExpressionMulitiRepositoryImpl<>(repositoiesFunction.applyAsInt(createTuple()),
            name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryLocalTimeFieldExpression<C, L> fieldAsLocalTime(ToIntFunction<T> repositoiesFunction,
        String name) {
        return new LocalTimeFieldExpressionMulitiRepositoryImpl<>(repositoiesFunction.applyAsInt(createTuple()), name,
            this);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L expression(String expression, final Map<String, Object> params) {
        final Execution execution = SqlUtils.convertNamedParamSql(expression, params);
        return expression(execution.getExecution(), execution.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L expression(String expression, Object... params) {
        return (L) addCondition(new ParamedExpression() {

            @Override
            public String expression() {
                return expression;
            }

            @Override
            public Object getParam() {
                return params;
            }
        });
    }

    // ********************************************************************
    //
    // ********************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public C configure(Consumer<C2> consumer) {
        if (consumer != null) {
            consumer.accept(conditionConfig);
        }
        return (C) this;
    }

}
