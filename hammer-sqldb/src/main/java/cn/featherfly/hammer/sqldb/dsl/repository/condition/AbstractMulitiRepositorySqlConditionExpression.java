/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-15 15:20:15
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository.condition;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.builder.model.ParamedColumnElement;
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
import cn.featherfly.hammer.sqldb.dsl.condition.AbstractSqlConditionExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.InternalMulitiCondition;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlRelation;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.sql.dml.SqlConditionExpressionBuilder;

/**
 * abstract muliti repository condition expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <C2> the generic type
 * @param <S> the generic type
 * @param <B> the generic type
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
     * @param parent the parent
     * @param index the index
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
    public <V> L ba(AtomicInteger index, Serializable field, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return ba(index, getPropertyName(field), min, max, p -> ignoreStrategy.test(min, max));
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ba(AtomicInteger index, Serializable field, V min, V max, Predicate<?> ignoreStrategy) {
        return ba(index, getPropertyName(field), min, max, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ba(AtomicInteger index, String field, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return ba(index, field, min, max, p -> ignoreStrategy.test(min, max));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L ba(AtomicInteger index, String field, V min, V max, Predicate<?> ignoreStrategy) {
        return (L) addCondition(
            new SqlConditionExpressionBuilder(getDialect(), field,
                new FieldValueOperator[] { getFieldValueOperator((Serializable) min),
                    getFieldValueOperator((Serializable) max) },
                ComparisonOperator.BA, getAlias(index), ignoreStrategy));
    }

    @Override
    public <V> L ba(AtomicInteger index, ParamedColumnElement field, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return ba(index, field, min, max, p -> ignoreStrategy.test(min, max));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <V> L ba(AtomicInteger index, ParamedColumnElement field, V min, V max, Predicate<?> ignoreStrategy) {
        return (L) addCondition(SqlConditionExpressionBuilder.field(field) //
            .comparisonOperator(ComparisonOperator.BA) //
            .value(new FieldValueOperator[] { getFieldValueOperator((Serializable) min),
                getFieldValueOperator((Serializable) max) }) //
            .tableAlias(repositoryAlias) //
            .ignoreStrategy(ignoreStrategy) //
            .dialect(dialect).build()); //
    }

    // ********************************************************************

    /** {@inheritDoc} */
    @Override
    public <V> L nba(AtomicInteger index, Serializable field, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return nba(index, getPropertyName(field), min, max, p -> ignoreStrategy.test(min, max));
    }

    /** {@inheritDoc} */
    @Override
    public <V> L nba(AtomicInteger index, Serializable field, V min, V max, Predicate<?> ignoreStrategy) {
        return nba(index, getPropertyName(field), min, max, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L nba(AtomicInteger index, String field, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return nba(index, field, min, max, p -> ignoreStrategy.test(min, max));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L nba(AtomicInteger index, String field, V min, V max, Predicate<?> ignoreStrategy) {
        return (L) addCondition(
            new SqlConditionExpressionBuilder(getDialect(), field,
                new FieldValueOperator[] { getFieldValueOperator((Serializable) min),
                    getFieldValueOperator((Serializable) max) },
                ComparisonOperator.NBA, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    public <V> L nba(AtomicInteger index, ParamedColumnElement field, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return nba(index, field, min, max, p -> ignoreStrategy.test(min, max));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L nba(AtomicInteger index, ParamedColumnElement field, V min, V max, Predicate<?> ignoreStrategy) {
        return (L) addCondition(SqlConditionExpressionBuilder.field(field) //
            .comparisonOperator(ComparisonOperator.BA) //
            .value(new FieldValueOperator[] { getFieldValueOperator((Serializable) min),
                getFieldValueOperator((Serializable) max) }) //
            .tableAlias(repositoryAlias) //
            .ignoreStrategy(ignoreStrategy) //
            .dialect(dialect).build()); //
    }

    // ********************************************************************

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
    public L eq(AtomicInteger index, String field, int value, IntPredicate ignoreStrategy) {
        return eq(index, field, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L eq(AtomicInteger index, String field, long value, LongPredicate ignoreStrategy) {
        return eq(index, field, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L eq(AtomicInteger index, String field, double value, DoublePredicate ignoreStrategy) {
        return eq(index, field, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <R> L eq(AtomicInteger index, String field, R value, Predicate<?> ignoreStrategy) {
        return eq(index, field, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L eq(AtomicInteger index, String field, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return eqOrNe(index, ComparisonOperator.EQ, field, value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L eq(AtomicInteger index, ParamedColumnElement field, int value, IntPredicate ignoreStrategy) {
        return eq(index, field, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L eq(AtomicInteger index, ParamedColumnElement field, long value, LongPredicate ignoreStrategy) {
        return eq(index, field, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L eq(AtomicInteger index, ParamedColumnElement field, double value, DoublePredicate ignoreStrategy) {
        return eq(index, field, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <R> L eq(AtomicInteger index, ParamedColumnElement field, R value, Predicate<?> ignoreStrategy) {
        return eq(index, field, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L eq(AtomicInteger index, ParamedColumnElement field, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return eqOrNe(index, ComparisonOperator.EQ, field, value, matchStrategy, ignoreStrategy);
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
    public L ne(AtomicInteger index, String field, int value, IntPredicate ignoreStrategy) {
        return ne(index, field, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ne(AtomicInteger index, String field, long value, LongPredicate ignoreStrategy) {
        return ne(index, field, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ne(AtomicInteger index, String field, double value, DoublePredicate ignoreStrategy) {
        return ne(index, field, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ne(AtomicInteger index, String field, R value, Predicate<?> ignoreStrategy) {
        return ne(index, field, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ne(AtomicInteger index, String field, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return eqOrNe(index, ComparisonOperator.NE, field, value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ne(AtomicInteger index, ParamedColumnElement field, int value, IntPredicate ignoreStrategy) {
        return ne(index, field, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ne(AtomicInteger index, ParamedColumnElement field, long value, LongPredicate ignoreStrategy) {
        return ne(index, field, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ne(AtomicInteger index, ParamedColumnElement field, double value, DoublePredicate ignoreStrategy) {
        return ne(index, field, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ne(AtomicInteger index, ParamedColumnElement field, R value, Predicate<?> ignoreStrategy) {
        return ne(index, field, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ne(AtomicInteger index, ParamedColumnElement field, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return eqOrNe(index, ComparisonOperator.NE, field, value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public <R> L eqOrNe(AtomicInteger index, ComparisonOperator comparisonOperator, String field, R value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), field, prepareFieldValue(value),
            comparisonOperator, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public <R> L eqOrNe(AtomicInteger index, ComparisonOperator comparisonOperator, ParamedColumnElement field, R value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), field, prepareFieldValue(value),
            comparisonOperator, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    /** {@inheritDoc} */
    @Override
    public L sw(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
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
    public L sw(AtomicInteger index, String field, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), field, getFieldValueOperator(value),
            ComparisonOperator.SW, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L sw(AtomicInteger index, ParamedColumnElement field, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), field, getFieldValueOperator(value),
            ComparisonOperator.SW, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    /** {@inheritDoc} */
    @Override
    public L nsw(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
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
    public L nsw(AtomicInteger index, String field, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), field, getFieldValueOperator(value),
            ComparisonOperator.NSW, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L nsw(AtomicInteger index, ParamedColumnElement field, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), field, getFieldValueOperator(value),
            ComparisonOperator.NSW, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    /** {@inheritDoc} */
    @Override
    public L co(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
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
    public L co(AtomicInteger index, String field, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), field, getFieldValueOperator(value),
            ComparisonOperator.CO, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L co(AtomicInteger index, ParamedColumnElement field, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), field, getFieldValueOperator(value),
            ComparisonOperator.CO, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    /** {@inheritDoc} */
    @Override
    public L nco(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
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
    public L nco(AtomicInteger index, String field, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), field, getFieldValueOperator(value),
            ComparisonOperator.NCO, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L nco(AtomicInteger index, ParamedColumnElement field, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), field, getFieldValueOperator(value),
            ComparisonOperator.NCO, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    /** {@inheritDoc} */
    @Override
    public L ew(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
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
    public L ew(AtomicInteger index, String field, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), field, getFieldValueOperator(value),
            ComparisonOperator.EW, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L ew(AtomicInteger index, ParamedColumnElement field, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), field, getFieldValueOperator(value),
            ComparisonOperator.EW, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    /** {@inheritDoc} */
    @Override
    public L newv(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
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
    public L newv(AtomicInteger index, String field, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), field, getFieldValueOperator(value),
            ComparisonOperator.NEW, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L newv(AtomicInteger index, ParamedColumnElement field, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), field, getFieldValueOperator(value),
            ComparisonOperator.NEW, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    /** {@inheritDoc} */
    @Override
    public L lk(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
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
    public L lk(AtomicInteger index, String field, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), field, getFieldValueOperator(value),
            ComparisonOperator.LK, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L lk(AtomicInteger index, ParamedColumnElement field, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), field, getFieldValueOperator(value),
            ComparisonOperator.LK, matchStrategy, getAlias(index), ignoreStrategy));
    }
    // ****************************************************************************************************************

    /** {@inheritDoc} */
    @Override
    public L nl(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
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
    public L nl(AtomicInteger index, String field, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), field, getFieldValueOperator(value),
            ComparisonOperator.NL, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L nl(AtomicInteger index, ParamedColumnElement field, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), field, getFieldValueOperator(value),
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
        return in(index, property, property.getAsLong(), v -> ignoreStrategy.test((Long) v));
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
        return in(index, (Serializable) property, value, v -> ignoreStrategy.test((Long) v));
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
    public L in(AtomicInteger index, String field, int value, IntPredicate ignoreStrategy) {
        return in(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, String field, long value, LongPredicate ignoreStrategy) {
        return in(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, String field, double value, DoublePredicate ignoreStrategy) {
        return in(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <R> L in(AtomicInteger index, String field, R value, Predicate<?> ignoreStrategy) {
        return in(index, field, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <R> L in(AtomicInteger index, String field, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), field, getInParam(value),
            ComparisonOperator.IN, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, ParamedColumnElement field, int value, IntPredicate ignoreStrategy) {
        return in(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, ParamedColumnElement field, long value, LongPredicate ignoreStrategy) {
        return in(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, ParamedColumnElement field, double value, DoublePredicate ignoreStrategy) {
        return in(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <R> L in(AtomicInteger index, ParamedColumnElement field, R value, Predicate<?> ignoreStrategy) {
        return in(index, field, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <R> L in(AtomicInteger index, ParamedColumnElement field, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), field, getInParam(value),
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
    public L ni(AtomicInteger index, String field, int value, IntPredicate ignoreStrategy) {
        return ni(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, String field, long value, LongPredicate ignoreStrategy) {
        return ni(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, String field, double value, DoublePredicate ignoreStrategy) {
        return ni(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ni(AtomicInteger index, String field, R value, Predicate<?> ignoreStrategy) {
        return ni(index, field, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <R> L ni(AtomicInteger index, String field, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), field, getInParam(value),
            ComparisonOperator.NI, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, ParamedColumnElement field, int value, IntPredicate ignoreStrategy) {
        return ni(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, ParamedColumnElement field, long value, LongPredicate ignoreStrategy) {
        return ni(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, ParamedColumnElement field, double value, DoublePredicate ignoreStrategy) {
        return ni(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ni(AtomicInteger index, ParamedColumnElement field, R value, Predicate<?> ignoreStrategy) {
        return ni(index, field, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <R> L ni(AtomicInteger index, ParamedColumnElement field, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), field, getInParam(value),
            ComparisonOperator.NI, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ----------------------------------------------------------------------------------------------------------------

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L isn(AtomicInteger index, String field, Boolean value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), field, value, ComparisonOperator.ISN,
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
    public L inn(AtomicInteger index, String field, Boolean value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), field, value, ComparisonOperator.INN,
            getAlias(index), getIgnoreStrategy()));
    }

    // ********************************************************************

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, Serializable field, int value, IntPredicate ignoreStrategy) {
        return ge(index, getPropertyName(field), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, Serializable field, long value, LongPredicate ignoreStrategy) {
        return ge(index, getPropertyName(field), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, Serializable field, double value, DoublePredicate ignoreStrategy) {
        return ge(index, getPropertyName(field), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ge(AtomicInteger index, Serializable field, V value, Predicate<?> ignoreStrategy) {
        return ge(index, getPropertyName(field), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ge(AtomicInteger index, Serializable field, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return ge(index, getPropertyName(field), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, String field, int value, IntPredicate ignoreStrategy) {
        return ge(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, String field, long value, LongPredicate ignoreStrategy) {
        return ge(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, String field, double value, DoublePredicate ignoreStrategy) {
        return ge(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ge(AtomicInteger index, String field, V value, Predicate<?> ignoreStrategy) {
        return ge(index, field, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L ge(AtomicInteger index, String field, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(
            new SqlConditionExpressionBuilder(getDialect(), field, getFieldValueOperator((Serializable) value),
                ComparisonOperator.GE, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, ParamedColumnElement field, int value, IntPredicate ignoreStrategy) {
        return ge(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, ParamedColumnElement field, long value, LongPredicate ignoreStrategy) {
        return ge(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, ParamedColumnElement field, double value, DoublePredicate ignoreStrategy) {
        return ge(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ge(AtomicInteger index, ParamedColumnElement field, V value, Predicate<?> ignoreStrategy) {
        return ge(index, field, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L ge(AtomicInteger index, ParamedColumnElement field, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(
            new SqlConditionExpressionBuilder(getDialect(), field, getFieldValueOperator((Serializable) value),
                ComparisonOperator.GE, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ********************************************************************

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, Serializable field, int value, IntPredicate ignoreStrategy) {
        return gt(index, getPropertyName(field), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, Serializable field, long value, LongPredicate ignoreStrategy) {
        return gt(index, getPropertyName(field), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, Serializable field, double value, DoublePredicate ignoreStrategy) {
        return gt(index, getPropertyName(field), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L gt(AtomicInteger index, Serializable field, V value, Predicate<?> ignoreStrategy) {
        return gt(index, getPropertyName(field), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L gt(AtomicInteger index, Serializable field, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return gt(index, getPropertyName(field), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, String field, int value, IntPredicate ignoreStrategy) {
        return gt(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, String field, long value, LongPredicate ignoreStrategy) {
        return gt(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, String field, double value, DoublePredicate ignoreStrategy) {
        return gt(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <V> L gt(AtomicInteger index, String field, V value, Predicate<?> ignoreStrategy) {
        return gt(index, field, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L gt(AtomicInteger index, String field, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(
            new SqlConditionExpressionBuilder(getDialect(), field, getFieldValueOperator((Serializable) value),
                ComparisonOperator.GT, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, ParamedColumnElement field, int value, IntPredicate ignoreStrategy) {
        return gt(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, ParamedColumnElement field, long value, LongPredicate ignoreStrategy) {
        return gt(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, ParamedColumnElement field, double value, DoublePredicate ignoreStrategy) {
        return gt(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <V> L gt(AtomicInteger index, ParamedColumnElement field, V value, Predicate<?> ignoreStrategy) {
        return gt(index, field, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L gt(AtomicInteger index, ParamedColumnElement field, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(
            new SqlConditionExpressionBuilder(getDialect(), field, getFieldValueOperator((Serializable) value),
                ComparisonOperator.GT, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ********************************************************************

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, Serializable field, int value, IntPredicate ignoreStrategy) {
        return le(index, getPropertyName(field), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, Serializable field, long value, LongPredicate ignoreStrategy) {
        return le(index, getPropertyName(field), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, Serializable field, double value, DoublePredicate ignoreStrategy) {
        return le(index, getPropertyName(field), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L le(AtomicInteger index, Serializable field, V value, Predicate<?> ignoreStrategy) {
        return le(index, getPropertyName(field), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L le(AtomicInteger index, Serializable field, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return le(index, getPropertyName(field), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, String field, int value, IntPredicate ignoreStrategy) {
        return le(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, String field, long value, LongPredicate ignoreStrategy) {
        return le(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, String field, double value, DoublePredicate ignoreStrategy) {
        return le(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <V> L le(AtomicInteger index, String field, V value, Predicate<?> ignoreStrategy) {
        return le(index, field, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L le(AtomicInteger index, String field, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(
            new SqlConditionExpressionBuilder(getDialect(), field, getFieldValueOperator((Serializable) value),
                ComparisonOperator.LE, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, ParamedColumnElement field, int value, IntPredicate ignoreStrategy) {
        return le(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, ParamedColumnElement field, long value, LongPredicate ignoreStrategy) {
        return le(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, ParamedColumnElement field, double value, DoublePredicate ignoreStrategy) {
        return le(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <V> L le(AtomicInteger index, ParamedColumnElement field, V value, Predicate<?> ignoreStrategy) {
        return le(index, field, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L le(AtomicInteger index, ParamedColumnElement field, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(
            new SqlConditionExpressionBuilder(getDialect(), field, getFieldValueOperator((Serializable) value),
                ComparisonOperator.LE, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, Serializable field, int value, IntPredicate ignoreStrategy) {
        return lt(index, getPropertyName(field), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, Serializable field, long value, LongPredicate ignoreStrategy) {
        return lt(index, getPropertyName(field), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, Serializable field, double value, DoublePredicate ignoreStrategy) {
        return lt(index, getPropertyName(field), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L lt(AtomicInteger index, Serializable field, V value, Predicate<?> ignoreStrategy) {
        return lt(index, getPropertyName(field), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L lt(AtomicInteger index, Serializable field, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return lt(index, getPropertyName(field), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, String field, int value, IntPredicate ignoreStrategy) {
        return lt(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, String field, long value, LongPredicate ignoreStrategy) {
        return lt(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, String field, double value, DoublePredicate ignoreStrategy) {
        return lt(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <V> L lt(AtomicInteger index, String field, V value, Predicate<?> ignoreStrategy) {
        return lt(index, field, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L lt(AtomicInteger index, String field, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(
            new SqlConditionExpressionBuilder(getDialect(), field, getFieldValueOperator((Serializable) value),
                ComparisonOperator.LT, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, ParamedColumnElement field, int value, IntPredicate ignoreStrategy) {
        return lt(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, ParamedColumnElement field, long value, LongPredicate ignoreStrategy) {
        return lt(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, ParamedColumnElement field, double value, DoublePredicate ignoreStrategy) {
        return lt(index, field, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <V> L lt(AtomicInteger index, ParamedColumnElement field, V value, Predicate<?> ignoreStrategy) {
        return lt(index, field, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L lt(AtomicInteger index, ParamedColumnElement field, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(
            new SqlConditionExpressionBuilder(getDialect(), field, getFieldValueOperator((Serializable) value),
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
