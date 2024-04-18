/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-15 15:20:15
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.function.serializable.SerializableArraySupplier;
import cn.featherfly.common.function.serializable.SerializableDoubleSupplier;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.lang.Console;
import cn.featherfly.common.operator.ComparisonOperator;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.MulitiRepositoryExpression;
import cn.featherfly.hammer.sqldb.Constants;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.AbstractSqlConditionExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.InternalMulitiCondition;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlRelation;
import cn.featherfly.hammer.sqldb.sql.dml.SqlConditionExpressionBuilder;

/**
 * abstract muliti repository condition expression.
 *
 * @author zhongj
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <C2> the generic type
 * @param <S>  the generic type
 * @param <B>  the generic type
 */
public abstract class AbstractMulitiRepositorySqlConditionExpression<C extends ConditionExpression,
    L extends LogicExpression<C, L>, C2 extends ConditionConfig<C2>, S extends RepositorySqlRelation<S, B>,
    B extends SqlBuilder> extends AbstractSqlConditionExpression<C, L, C2>
    implements InternalMulitiCondition<L>, MulitiRepositoryExpression, ConditionConfigureExpression<C, C2> {

    /** The entity sql relation. */
    protected final S repositoryRelation;

    /** The index. */
    protected final int index;

    /** The repository alias. */
    protected final String repositoryAlias;

    /**
     * Instantiates a new abstract muliti repository condition expression.
     *
     * @param parent             the parent
     * @param index              the index
     * @param repositoryRelation the repository relation
     */
    protected AbstractMulitiRepositorySqlConditionExpression(L parent, int index, S repositoryRelation) {
        super(parent, repositoryRelation.getJdbc().getDialect(), repositoryRelation.getConfig());
        this.repositoryRelation = repositoryRelation;
        this.index = index;
        repositoryAlias = repositoryRelation.getRepositoryRelation(0).getRepositoryAlias();

        if (Constants.DEBUG) {
            Console.log("{} end at time {}", this.getClass().getName(), System.currentTimeMillis());
        }
    }

    // ****************************************************************************************************************

    /** {@inheritDoc} */
    @Override
    public <V> L ba(AtomicInteger index, Serializable name, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return ba(index, getPropertyName(name), min, max, p -> ignoreStrategy.test(min, max));
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ba(AtomicInteger index, Serializable name, V min, V max, Predicate<?> ignoreStrategy) {
        return ba(index, getPropertyName(name), min, max, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ba(AtomicInteger index, String name, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return ba(index, name, min, max, p -> ignoreStrategy.test(min, max));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L ba(AtomicInteger index, String name, V min, V max, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), name,
            new FieldValueOperator[] { getFieldValueOperator(min), getFieldValueOperator(max) }, ComparisonOperator.BA,
            getAlias(index), ignoreStrategy));
    }

    // ********************************************************************

    /** {@inheritDoc} */
    @Override
    public <V> L nba(AtomicInteger index, Serializable name, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return nba(index, getPropertyName(name), min, max, p -> ignoreStrategy.test(min, max));
    }

    /** {@inheritDoc} */
    @Override
    public <V> L nba(AtomicInteger index, Serializable name, V min, V max, Predicate<?> ignoreStrategy) {
        return nba(index, getPropertyName(name), min, max, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L nba(AtomicInteger index, String name, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return nba(index, name, min, max, p -> ignoreStrategy.test(min, max));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L nba(AtomicInteger index, String name, V min, V max, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), name,
            new FieldValueOperator[] { getFieldValueOperator(min), getFieldValueOperator(max) }, ComparisonOperator.NBA,
            getAlias(index), ignoreStrategy));
    }

    // ********************************************************************

    /** {@inheritDoc} */
    @Override
    public <R> L eq(AtomicInteger index, SerializableSupplier<R> property, Predicate<?> ignoreStrategy) {
        return eq(index, property, property.get(), MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L eq(AtomicInteger index, SerializableSupplier<R> property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return eq(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L eq(AtomicInteger index, Serializable property, int value, IntPredicate ignoreStrategy) {
        return eq(index, property, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L eq(AtomicInteger index, Serializable property, long value, LongPredicate ignoreStrategy) {
        return eq(index, property, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L eq(AtomicInteger index, Serializable property, double value, DoublePredicate ignoreStrategy) {
        return eq(index, property, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <R> L eq(AtomicInteger index, Serializable property, R value, Predicate<?> ignoreStrategy) {
        return eq(index, property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L eq(AtomicInteger index, Serializable property, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return eq(index, getPropertyName(property), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L eq(AtomicInteger index, String name, int value, IntPredicate ignoreStrategy) {
        return eq(index, name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L eq(AtomicInteger index, String name, long value, LongPredicate ignoreStrategy) {
        return eq(index, name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L eq(AtomicInteger index, String name, double value, DoublePredicate ignoreStrategy) {
        return eq(index, name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <R> L eq(AtomicInteger index, String name, R value, Predicate<?> ignoreStrategy) {
        return eq(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L eq(AtomicInteger index, String name, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return eqOrNe(index, ComparisonOperator.EQ, name, value, matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /** {@inheritDoc} */
    @Override
    public <R> L ne(AtomicInteger index, SerializableSupplier<R> property, Predicate<?> ignoreStrategy) {
        return ne(index, property, property.get(), MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ne(AtomicInteger index, SerializableSupplier<R> property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return ne(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ne(AtomicInteger index, Serializable property, int value, IntPredicate ignoreStrategy) {
        return ne(index, property, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ne(AtomicInteger index, Serializable property, long value, LongPredicate ignoreStrategy) {
        return ne(index, property, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ne(AtomicInteger index, Serializable property, double value, DoublePredicate ignoreStrategy) {
        return ne(index, property, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ne(AtomicInteger index, Serializable property, R value, Predicate<?> ignoreStrategy) {
        return ne(index, property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ne(AtomicInteger index, Serializable property, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return ne(index, getPropertyName(property), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ne(AtomicInteger index, String name, int value, IntPredicate ignoreStrategy) {
        return ne(index, name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ne(AtomicInteger index, String name, long value, LongPredicate ignoreStrategy) {
        return ne(index, name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ne(AtomicInteger index, String name, double value, DoublePredicate ignoreStrategy) {
        return ne(index, name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ne(AtomicInteger index, String name, R value, Predicate<?> ignoreStrategy) {
        return ne(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ne(AtomicInteger index, String name, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return eqOrNe(index, ComparisonOperator.NE, name, value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public <R> L eqOrNe(AtomicInteger index, ComparisonOperator comparisonOperator, String name, R value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), name, prepareFieldValue(value),
            comparisonOperator, matchStrategy, getAlias(index), ignoreStrategy));
        //        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), name, getFieldValueOperator(value),
        //                comparisonOperator, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    /** {@inheritDoc} */
    @Override
    public L sw(AtomicInteger index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return sw(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L sw(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return sw(index, getPropertyName(property), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L sw(AtomicInteger index, String name, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), name, getFieldValueOperator(value),
            ComparisonOperator.SW, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    /** {@inheritDoc} */
    @Override
    public L nsw(AtomicInteger index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return nsw(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L nsw(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return nsw(index, getPropertyName(property), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L nsw(AtomicInteger index, String name, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), name, getFieldValueOperator(value),
            ComparisonOperator.NSW, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    /** {@inheritDoc} */
    @Override
    public L co(AtomicInteger index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return co(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L co(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return co(index, getPropertyName(property), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L co(AtomicInteger index, String name, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), name, getFieldValueOperator(value),
            ComparisonOperator.CO, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    /** {@inheritDoc} */
    @Override
    public L nco(AtomicInteger index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return nco(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L nco(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return nco(index, getPropertyName(property), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L nco(AtomicInteger index, String name, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), name, getFieldValueOperator(value),
            ComparisonOperator.NCO, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    /** {@inheritDoc} */
    @Override
    public L ew(AtomicInteger index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return ew(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ew(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return ew(index, getPropertyName(property), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L ew(AtomicInteger index, String name, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), name, getFieldValueOperator(value),
            ComparisonOperator.EW, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    /** {@inheritDoc} */
    @Override
    public L newv(AtomicInteger index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return newv(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L newv(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return newv(index, getPropertyName(property), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L newv(AtomicInteger index, String name, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), name, getFieldValueOperator(value),
            ComparisonOperator.NEW, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    /** {@inheritDoc} */
    @Override
    public L lk(AtomicInteger index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return lk(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L lk(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return lk(index, getPropertyName(property), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L lk(AtomicInteger index, String name, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), name, getFieldValueOperator(value),
            ComparisonOperator.LK, matchStrategy, getAlias(index), ignoreStrategy));
    }
    // ****************************************************************************************************************

    /** {@inheritDoc} */
    @Override
    public L nl(AtomicInteger index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return nl(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L nl(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return nl(index, getPropertyName(property), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L nl(AtomicInteger index, String name, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), name, getFieldValueOperator(value),
            ComparisonOperator.NL, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return in(index, property, property.getAsInt(), v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, SerializableIntSupplier property, Predicate<?> ignoreStrategy) {
        return in(index, property, property.getAsInt(), ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return in(index, property, property.getAsLong(), v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, SerializableLongSupplier property, Predicate<?> ignoreStrategy) {
        return in(index, property, property.getAsLong(), ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return in(index, property, property.getAsDouble(), v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy) {
        return in(index, property, property.getAsDouble(), ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L in(AtomicInteger index, SerializableSupplier<R> property, Predicate<?> ignoreStrategy) {
        return in(index, property, property.get(), ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return in(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, SerializableArraySupplier<String> property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return in(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <T> L in(AtomicInteger index, SerializableToIntFunction<T> property, int value,
        IntPredicate ignoreStrategy) {
        return in(index, (Serializable) property, value, v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public <T> L in(AtomicInteger index, SerializableToLongFunction<T> property, long value,
        LongPredicate ignoreStrategy) {
        return in(index, (Serializable) property, value, v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public <T> L in(AtomicInteger index, SerializableToDoubleFunction<T> property, double value,
        DoublePredicate ignoreStrategy) {
        return in(index, (Serializable) property, value, v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <R> L in(AtomicInteger index, Serializable property, R value, Predicate<?> ignoreStrategy) {
        return in(index, getPropertyName(property), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L in(AtomicInteger index, Serializable property, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return in(index, getPropertyName(property), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, String name, int value, IntPredicate ignoreStrategy) {
        return in(index, name, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, String name, long value, LongPredicate ignoreStrategy) {
        return in(index, name, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, String name, double value, DoublePredicate ignoreStrategy) {
        return in(index, name, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <R> L in(AtomicInteger index, String name, R value, Predicate<?> ignoreStrategy) {
        return in(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <R> L in(AtomicInteger index, String name, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), name, getInParam(value),
            ComparisonOperator.IN, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return ni(index, property, property.getAsInt(), v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, SerializableIntSupplier property, Predicate<?> ignoreStrategy) {
        return ni(index, property, property.getAsInt(), ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return ni(index, property, property.getAsLong(), v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, SerializableLongSupplier property, Predicate<?> ignoreStrategy) {
        return ni(index, property, property.getAsLong(), ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return ni(index, property, property.getAsDouble(), v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy) {
        return ni(index, property, property.getAsDouble(), ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ni(AtomicInteger index, SerializableSupplier<R> property, Predicate<?> ignoreStrategy) {
        return ni(index, property, property.get(), ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <T> L ni(AtomicInteger index, SerializableToIntFunction<T> property, int value,
        IntPredicate ignoreStrategy) {
        return ni(index, (Serializable) property, value, v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public <T> L ni(AtomicInteger index, SerializableToLongFunction<T> property, long value,
        LongPredicate ignoreStrategy) {
        return ni(index, (Serializable) property, value, v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public <T> L ni(AtomicInteger index, SerializableToDoubleFunction<T> property, double value,
        DoublePredicate ignoreStrategy) {
        return ni(index, (Serializable) property, value, v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ni(AtomicInteger index, Serializable property, R value, Predicate<?> ignoreStrategy) {
        return ni(index, getPropertyName(property), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ni(AtomicInteger index, Serializable property, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return ni(index, getPropertyName(property), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, String name, int value, IntPredicate ignoreStrategy) {
        return ni(index, name, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, String name, long value, LongPredicate ignoreStrategy) {
        return ni(index, name, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, String name, double value, DoublePredicate ignoreStrategy) {
        return ni(index, name, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ni(AtomicInteger index, String name, R value, Predicate<?> ignoreStrategy) {
        return ni(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <R> L ni(AtomicInteger index, String name, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), name, getInParam(value),
            ComparisonOperator.NI, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L isn(AtomicInteger index, String name, Boolean value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), name, value, ComparisonOperator.ISN,
            getAlias(index), getIgnoreStrategy()));
    }

    /** {@inheritDoc} */
    @Override
    public L isn(AtomicInteger index, Serializable property, Boolean value) {
        return isn(index, getPropertyName(property), value);
    }

    /** {@inheritDoc} */
    @Override
    public L inn(AtomicInteger index, Serializable property, Boolean value) {
        return inn(index, getPropertyName(property), value);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L inn(AtomicInteger index, String name, Boolean value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), name, value, ComparisonOperator.INN,
            getAlias(index), getIgnoreStrategy()));
    }

    // ********************************************************************

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return ge(index, property, property.getAsInt(), v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return ge(index, property, property.getAsLong(), v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return ge(index, property, property.getAsDouble(), v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, SerializableIntSupplier property, Predicate<?> ignoreStrategy) {
        return ge(index, property, property.getAsInt(), ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, SerializableLongSupplier property, Predicate<?> ignoreStrategy) {
        return ge(index, property, property.getAsLong(), ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy) {
        return ge(index, property, property.getAsDouble(), ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ge(AtomicInteger index, SerializableSupplier<V> property, Predicate<?> ignoreStrategy) {
        return ge(index, property, property.get(), ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return ge(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, SerializableToIntFunction<?> name, int value, IntPredicate ignoreStrategy) {
        return ge(index, getPropertyName(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, SerializableToLongFunction<?> name, long value, LongPredicate ignoreStrategy) {
        return ge(index, getPropertyName(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, SerializableToDoubleFunction<?> name, double value,
        DoublePredicate ignoreStrategy) {
        return ge(index, getPropertyName(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ge(AtomicInteger index, Serializable name, V value, Predicate<?> ignoreStrategy) {
        return ge(index, getPropertyName(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ge(AtomicInteger index, Serializable name, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return ge(index, getPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, String name, int value, IntPredicate ignoreStrategy) {
        return ge(index, name, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, String name, long value, LongPredicate ignoreStrategy) {
        return ge(index, name, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, String name, double value, DoublePredicate ignoreStrategy) {
        return ge(index, name, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L ge(AtomicInteger index, String name, V value, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), name, getFieldValueOperator(value),
            ComparisonOperator.GE, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L ge(AtomicInteger index, String name, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), name, getFieldValueOperator(value),
            ComparisonOperator.GE, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ********************************************************************

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return gt(index, property, property.getAsInt(), v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return gt(index, property, property.getAsLong(), v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return gt(index, property, property.getAsDouble(), v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, SerializableIntSupplier property, Predicate<?> ignoreStrategy) {
        return gt(index, property, property.getAsInt(), ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, SerializableLongSupplier property, Predicate<?> ignoreStrategy) {
        return gt(index, property, property.getAsLong(), ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy) {
        return gt(index, property, property.getAsDouble(), ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L gt(AtomicInteger index, SerializableSupplier<V> property, Predicate<?> ignoreStrategy) {
        return gt(index, property, property.get(), ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return gt(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, SerializableToIntFunction<?> name, int value, IntPredicate ignoreStrategy) {
        return gt(index, getPropertyName(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, SerializableToLongFunction<?> name, long value, LongPredicate ignoreStrategy) {
        return gt(index, getPropertyName(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, SerializableToDoubleFunction<?> name, double value,
        DoublePredicate ignoreStrategy) {
        return gt(index, getPropertyName(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L gt(AtomicInteger index, Serializable name, V value, Predicate<?> ignoreStrategy) {
        return gt(index, getPropertyName(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L gt(AtomicInteger index, Serializable name, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return gt(index, getPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, String name, int value, IntPredicate ignoreStrategy) {
        return gt(index, name, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, String name, long value, LongPredicate ignoreStrategy) {
        return gt(index, name, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, String name, double value, DoublePredicate ignoreStrategy) {
        return gt(index, name, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L gt(AtomicInteger index, String name, V value, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), name, getFieldValueOperator(value),
            ComparisonOperator.GT, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L gt(AtomicInteger index, String name, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), name, getFieldValueOperator(value),
            ComparisonOperator.GT, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ********************************************************************

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return le(index, property, property.getAsInt(), v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return le(index, property, property.getAsLong(), v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return le(index, property, property.getAsDouble(), v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, SerializableIntSupplier property, Predicate<?> ignoreStrategy) {
        return le(index, property, property.getAsInt(), ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, SerializableLongSupplier property, Predicate<?> ignoreStrategy) {
        return le(index, property, property.getAsLong(), ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy) {
        return le(index, property, property.getAsDouble(), ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L le(AtomicInteger index, SerializableSupplier<V> property, Predicate<?> ignoreStrategy) {
        return le(index, property, property.get(), ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return le(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, SerializableToIntFunction<?> name, int value, IntPredicate ignoreStrategy) {
        return le(index, getPropertyName(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, SerializableToLongFunction<?> name, long value, LongPredicate ignoreStrategy) {
        return le(index, getPropertyName(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, SerializableToDoubleFunction<?> name, double value,
        DoublePredicate ignoreStrategy) {
        return le(index, getPropertyName(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L le(AtomicInteger index, Serializable name, V value, Predicate<?> ignoreStrategy) {
        return le(index, getPropertyName(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L le(AtomicInteger index, Serializable name, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return le(index, getPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, String name, int value, IntPredicate ignoreStrategy) {
        return le(index, name, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, String name, long value, LongPredicate ignoreStrategy) {
        return le(index, name, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, String name, double value, DoublePredicate ignoreStrategy) {
        return le(index, name, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L le(AtomicInteger index, String name, V value, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), name, getFieldValueOperator(value),
            ComparisonOperator.LE, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L le(AtomicInteger index, String name, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), name, getFieldValueOperator(value),
            ComparisonOperator.LE, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return lt(index, property, property.getAsInt(), v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return lt(index, property, property.getAsLong(), v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return lt(index, property, property.getAsDouble(), v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, SerializableIntSupplier property, Predicate<?> ignoreStrategy) {
        return lt(index, property, property.getAsInt(), ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, SerializableLongSupplier property, Predicate<?> ignoreStrategy) {
        return lt(index, property, property.getAsLong(), ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy) {
        return lt(index, property, property.getAsDouble(), ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L lt(AtomicInteger index, SerializableSupplier<V> property, Predicate<?> ignoreStrategy) {
        return lt(index, property, property.get(), ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return lt(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, SerializableToIntFunction<?> name, int value, IntPredicate ignoreStrategy) {
        return lt(index, getPropertyName(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, SerializableToLongFunction<?> name, long value, LongPredicate ignoreStrategy) {
        return lt(index, getPropertyName(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, SerializableToDoubleFunction<?> name, double value,
        DoublePredicate ignoreStrategy) {
        return lt(index, getPropertyName(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L lt(AtomicInteger index, Serializable name, V value, Predicate<?> ignoreStrategy) {
        return lt(index, getPropertyName(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L lt(AtomicInteger index, Serializable name, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return lt(index, getPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, String name, int value, IntPredicate ignoreStrategy) {
        return lt(index, name, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, String name, long value, LongPredicate ignoreStrategy) {
        return lt(index, name, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, String name, double value, DoublePredicate ignoreStrategy) {
        return lt(index, name, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L lt(AtomicInteger index, String name, V value, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), name, getFieldValueOperator(value),
            ComparisonOperator.LT, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L lt(AtomicInteger index, String name, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), name, getFieldValueOperator(value),
            ComparisonOperator.LT, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************
    //  property
    // ****************************************************************************************************************

    /**
     * Gets the index.
     *
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Gets the alias.
     *
     * @param index the index
     * @return the alias
     */
    protected String getAlias(AtomicInteger index) {
        return getAlias(index.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAlias(int index) {
        return repositoryRelation.getRepositoryRelation(index).getRepositoryAlias();
    }

    @Override
    public Jdbc getJdbc() {
        return repositoryRelation.getJdbc();
    }

}
