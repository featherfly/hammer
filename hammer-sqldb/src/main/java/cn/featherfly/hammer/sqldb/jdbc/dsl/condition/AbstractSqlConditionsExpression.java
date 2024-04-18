/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-15 15:20:15
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.condition;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.db.SqlUtils;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.function.CharPredicate;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.LambdaUtils.SerializableSupplierLambdaInfo;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.common.operator.ComparisonOperator;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.operator.LogicOperator;
import cn.featherfly.common.repository.Execution;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.NativeStringConditionExpression;
import cn.featherfly.hammer.expression.condition.ParamedExpression;
import cn.featherfly.hammer.expression.condition.ba.BetweenExpression;
import cn.featherfly.hammer.expression.condition.co.ContainsExpression;
import cn.featherfly.hammer.expression.condition.eq.EqualsExpression;
import cn.featherfly.hammer.expression.condition.ew.EndWithExpression;
import cn.featherfly.hammer.expression.condition.field.FieldExpression;
import cn.featherfly.hammer.expression.condition.ge.GreatEqualsExpression;
import cn.featherfly.hammer.expression.condition.gt.GreatThanExpression;
import cn.featherfly.hammer.expression.condition.in.InExpression;
import cn.featherfly.hammer.expression.condition.inn.IsNotNullExpression;
import cn.featherfly.hammer.expression.condition.isn.IsNullExpression;
import cn.featherfly.hammer.expression.condition.le.LessEqualsExpression;
import cn.featherfly.hammer.expression.condition.lk.LikeExpression;
import cn.featherfly.hammer.expression.condition.lt.LessThanExpression;
import cn.featherfly.hammer.expression.condition.nba.NotBetweenExpression;
import cn.featherfly.hammer.expression.condition.nco.NotContainsExpression;
import cn.featherfly.hammer.expression.condition.ne.NotEqualsExpression;
import cn.featherfly.hammer.expression.condition.newv.NotEndWithExpression;
import cn.featherfly.hammer.expression.condition.ni.NotInExpression;
import cn.featherfly.hammer.expression.condition.nl.NotLikeExpression;
import cn.featherfly.hammer.expression.condition.nsw.NotStartWithExpression;
import cn.featherfly.hammer.expression.condition.sw.StartWithExpression;
import cn.featherfly.hammer.sqldb.sql.dml.SqlConditionExpressionBuilder;
import cn.featherfly.hammer.sqldb.sql.dml.SqlLogicOperatorExpressionBuilder;

/**
 * abstract sqldb condition expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
@SuppressWarnings("unchecked")
public abstract class AbstractSqlConditionsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>,
    C2 extends ConditionConfig<C2>> extends AbstractSqlConditionExpression<C, L, C2>
    implements ConditionExpression, LogicExpression<C, L>, ConditionConfigureExpression<C, C2> //
    , BetweenExpression<C, L>, NotBetweenExpression<C, L> //
    , ContainsExpression<C, L>, NotContainsExpression<C, L> //
    , EndWithExpression<C, L>, NotEndWithExpression<C, L> //
    , EqualsExpression<C, L>, NotEqualsExpression<C, L> //
    , GreatEqualsExpression<C, L>, GreatThanExpression<C, L> //
    , InExpression<C, L>, NotInExpression<C, L> //
    , IsNotNullExpression<C, L>, IsNullExpression<C, L> //
    , LessEqualsExpression<C, L>, LessThanExpression<C, L>//
    , StartWithExpression<C, L>, NotStartWithExpression<C, L>//
    , LikeExpression<C, L>, NotLikeExpression<C, L> //
    , NativeStringConditionExpression<C, L> {

    private String repositoryAlias;

    /**
     * Instantiates a new abstract sqldb muliti condition expression.
     *
     * @param conditionConfig the condition config
     * @param dialect         the dialect
     */
    protected AbstractSqlConditionsExpression(L parent, Dialect dialect, String repositoryAlias, C2 conditionConfig) {
        super(parent, dialect, conditionConfig);
        this.repositoryAlias = repositoryAlias;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, Field value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EQ,
            repositoryAlias, getIgnoreStrategy()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, FieldExpression value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EQ,
            repositoryAlias, getIgnoreStrategy()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, boolean value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EQ,
            repositoryAlias, v -> getIgnoreStrategy().test(v)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, char value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EQ,
            repositoryAlias, getIgnoreStrategy()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, char value, CharPredicate ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EQ,
            repositoryAlias, v -> ignoreStrategy.test((char) v)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, int value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EQ,
            repositoryAlias, getIgnoreStrategy()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, int value, IntPredicate ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EQ,
            repositoryAlias, v -> ignoreStrategy.test((int) v)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, long value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EQ,
            repositoryAlias, getIgnoreStrategy()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, long value, LongPredicate ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EQ,
            repositoryAlias, v -> ignoreStrategy.test((long) v)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, double value) {
        return eq(name, value, (DoublePredicate) getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, double value, DoublePredicate ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EQ,
            repositoryAlias, v -> ignoreStrategy.test((double) v)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, String value, MatchStrategy matchStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EQ,
            matchStrategy, repositoryAlias, getIgnoreStrategy()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EQ,
            matchStrategy, repositoryAlias, ignoreStrategy));
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
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EQ,
            repositoryAlias, ignoreStrategy));
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R> L eq(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
    //        SerializableSupplierLambdaInfo<R> lambdaInfo = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        if (property.get() == null) {
    //            return eq(lambdaInfo.getSerializedLambdaInfo().getPropertyName(), property.get(), ignoreStrategy);
    //        }
    //        List<Tuple2<String, Optional<R>>> tuples = supplier(lambdaInfo);
    //        L logic = null;
    //        C condition = (C) this;
    //        if (tuples.size() > 1) {
    //            condition = group();
    //        }
    //        for (Tuple2<String, Optional<R>> tuple : tuples) {
    //            if (logic != null) {
    //                condition = logic.and();
    //            }
    //            logic = condition.eq(tuple.get0(), tuple.get1().orElseGet(() -> null));
    //        }
    //        if (tuples.size() > 1) {
    //            logic = logic.endGroup();
    //        }
    //        return logic;
    //    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, boolean value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.NE,
            repositoryAlias, v -> getIgnoreStrategy().test(v)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, char value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.NE,
            repositoryAlias, getIgnoreStrategy()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, char value, CharPredicate ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.NE,
            repositoryAlias, v -> ignoreStrategy.test((char) v)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, int value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.NE,
            repositoryAlias, getIgnoreStrategy()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, int value, IntPredicate ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.NE,
            repositoryAlias, v -> ignoreStrategy.test((int) v)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, long value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.NE,
            repositoryAlias, getIgnoreStrategy()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, long value, LongPredicate ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.NE,
            repositoryAlias, v -> ignoreStrategy.test((long) v)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, double value) {
        return ne(name, value, (DoublePredicate) getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, double value, DoublePredicate ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EQ,
            repositoryAlias, v -> ignoreStrategy.test((double) v)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ne(String name, R value) {
        return ne(name, value, getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ne(String name, R value, Predicate<R> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EQ,
            repositoryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, String value, MatchStrategy matchStrategy) {
        return ne(name, value, matchStrategy, getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.NE,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R> L ne(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
    //        SerializableSupplierLambdaInfo<R> lambdaInfo = LambdaUtils.getSerializableSupplierLambdaInfo(property);
    //        if (property.get() == null) {
    //            return ne(lambdaInfo.getSerializedLambdaInfo().getPropertyName(), property.get(), ignoreStrategy);
    //        }
    //        List<Tuple2<String, Optional<R>>> tuples = supplier(lambdaInfo);
    //        L l = null;
    //        C c = (C) this;
    //        if (tuples.size() > 1) {
    //            c = group();
    //        }
    //        for (Tuple2<String, Optional<R>> tuple : tuples) {
    //            if (l != null) {
    //                c = l.and();
    //            }
    //            l = c.ne(tuple.get0(), tuple.get1().orElseGet(() -> null));
    //        }
    //        if (tuples.size() > 1) {
    //            l = l.endGroup();
    //        }
    //        return l;
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String name, String value, MatchStrategy matchStrategy) {
        return lk(name, value, matchStrategy, getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LK,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LK,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(String name, String value, MatchStrategy matchStrategy) {
        return nl(name, value, matchStrategy, getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LK,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LK,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String name, String value, MatchStrategy matchStrategy) {
        return sw(name, value, matchStrategy, getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.SW,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(String name, String value, MatchStrategy matchStrategy) {
        return nsw(name, value, matchStrategy, getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.SW,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String name, String value, MatchStrategy matchStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EW,
            matchStrategy, repositoryAlias, getIgnoreStrategy()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EW,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(String name, String value, MatchStrategy matchStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EW,
            matchStrategy, repositoryAlias, getIgnoreStrategy()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EW,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.EW,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String name, String value, MatchStrategy matchStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.CO,
            matchStrategy, repositoryAlias, getIgnoreStrategy()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.CO,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(String name, String value, MatchStrategy matchStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.CO,
            matchStrategy, repositoryAlias, getIgnoreStrategy()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.CO,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.CO,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    // ****************************************************************************************************************

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
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
            repositoryAlias, ignoreStrategy));
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
        return in(name, (Serializable) values, v -> ignoreStrategy.test((int[]) v));
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
        return in(name, (Serializable) values, v -> ignoreStrategy.test((long[]) v));
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
        return in(name, (Serializable) values, v -> ignoreStrategy.test((double[]) v));
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
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, getInParam(values),
            ComparisonOperator.IN, matchStrategy, repositoryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in(String name, R... values) {
        return in(name, values, getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L in(String name, R value, Predicate<R> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, getInParam(value),
            ComparisonOperator.IN, repositoryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(String name, Boolean value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.INN,
            repositoryAlias, getIgnoreStrategy()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(String name, Boolean value) {
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
        return ni(name, (Serializable) values, v -> ignoreStrategy.test((int[]) v));
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
        return ni(name, (Serializable) values, v -> ignoreStrategy.test((long[]) v));
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
        return ni(name, (Serializable) values, v -> ignoreStrategy.test((double[]) v));
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
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, getInParam(values),
            ComparisonOperator.NI, matchStrategy, repositoryAlias, ignoreStrategy));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni(String name, R... values) {
        return ni(name, values, getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> L ni(String name, R value, Predicate<R> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, getInParam(value),
            ComparisonOperator.NI, repositoryAlias, ignoreStrategy));
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

    // ****************************************************************************************************************

    public L ge0(String name, Object value, Predicate<?> ignoreStrategy) {
        return ge0(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    private L ge0(String name, Object value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GE,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    public L gt0(String name, Object value, Predicate<?> ignoreStrategy) {
        return gt0(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    private L gt0(String name, Object value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.GT,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    public L le0(String name, Object value, Predicate<?> ignoreStrategy) {
        return le0(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    private L le0(String name, Object value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LE,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    public L lt0(String name, Object value, Predicate<?> ignoreStrategy) {
        return lt0(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    private L lt0(String name, Object value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, value, ComparisonOperator.LT,
            matchStrategy, repositoryAlias, ignoreStrategy));
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Ba 0.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L ba0(String name, Object min, Object max, BiPredicate<?, ?> ignoreStrategy) {
        return ba0(name, min, max, v -> {
            Object[] params = (Object[]) v;
            return ((BiPredicate<Object, Object>) ignoreStrategy).test(params[0], params[1]);
        });
    }

    /**
     * Ba 0.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    private L ba0(String name, Object min, Object max, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, new Object[] { min, max },
            ComparisonOperator.BA, repositoryAlias, ignoreStrategy));
    }

    /**
     * Nba 0.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    public L nba0(String name, Object min, Object max, BiPredicate<?, ?> ignoreStrategy) {
        return nba0(name, min, max, v -> {
            Object[] params = (Object[]) v;
            return ((BiPredicate<Object, Object>) ignoreStrategy).test(params[0], params[1]);
        });
    }

    /**
     * Nba 0.
     *
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    private L nba0(String name, Object min, Object max, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, name, new Object[] { min, max },
            ComparisonOperator.NBA, repositoryAlias, ignoreStrategy));
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
    public C logic(LogicOperator operator) {
        AssertIllegalArgument.isNotNull(operator, "operator");
        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(operator));
    }

    @Override
    public L logic(LogicOperator operator, LogicExpression<?, ?> logicExpression) {
        logic(operator);
        return (L) addCondition(logicExpression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public C and() {
        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(LogicOperator.AND));
    }

    @Override
    public L and(LogicExpression<?, ?> logicExpression) {
        and();
        return (L) addCondition(logicExpression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public C or() {
        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(LogicOperator.OR));
    }

    @Override
    public L or(LogicExpression<?, ?> logicExpression) {
        or();
        return (L) addCondition(logicExpression);
    }

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

    // ********************************************************************
    // protected method
    // ********************************************************************

    /**
     * Supplier.
     *
     * @param <R>   the generic type
     * @param info  the info
     * @param value the value
     * @return LogicExpressionist
     */
    protected <R> List<Tuple2<String, Optional<R>>> supplier(SerializedLambdaInfo info, R value) {
        List<Tuple2<String, Optional<R>>> list = new ArrayList<>();
        if (value != null) {
            String propertyName = info.getPropertyName();
            list.add(Tuples.of(propertyName, Optional.of(value)));
        }
        return list;
    }

    /**
     * Supplier.
     *
     * @param <R>  the generic type
     * @param info the info
     * @return LogicExpressionist
     */
    protected <R> List<Tuple2<String, Optional<R>>> supplier(SerializableSupplierLambdaInfo<R> info) {
        return supplier(info.getSerializedLambdaInfo(), info.get());
    }

    // ****************************************************************************************************************
    // property
    // ****************************************************************************************************************

    /**
     * 返回repositoryAlias
     *
     * @return repositoryAlias
     */
    public String getRepositoryAlias() {
        return repositoryAlias;
    }
}
