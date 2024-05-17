/*
 * All rights Reserved, Designed By zhongj
 * @Title: AbstractMulitiEntityConditionExpression.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition
 * @Description: AbstractMulitiEntityConditionExpression
 * @author: zhongj
 * @date: 2023-08-07 17:33:07
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.entity.condition;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.builder.model.ParamedColumnElement;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.function.serializable.SerializableArraySupplier;
import cn.featherfly.common.function.serializable.SerializableDoubleSupplier;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.operator.ComparisonOperator;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.MulitiEntityConditionExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.AbstractSqlConditionExpression;
import cn.featherfly.hammer.sqldb.sql.dml.SqlConditionExpressionBuilder;

/**
 * The Class AbstractMulitiEntityConditionExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <C2> the generic type
 */
public abstract class AbstractMulitiEntityConditionExpression<C extends ConditionExpression,
    L extends LogicExpression<C, L>, C2 extends ConditionConfig<C2>> extends AbstractSqlConditionExpression<C, L, C2>
    implements InternalMulitiEntityCondition<L>, MulitiEntityConditionExpression {

    /**
     * Instantiates a new abstract muliti entity condition expression.
     *
     * @param parent the parent
     * @param dialect the dialect
     * @param conditionConfig the condition config
     */
    protected AbstractMulitiEntityConditionExpression(L parent, Dialect dialect, C2 conditionConfig) {
        super(parent, dialect, conditionConfig);
    }

    // ********************************************************************

    /** {@inheritDoc} */
    @Override
    public <V> L ba(AtomicInteger index, Serializable name, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return ba(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), min, max,
            p -> ignoreStrategy.test(min, max));
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ba(AtomicInteger index, Serializable name, V min, V max, Predicate<?> ignoreStrategy) {
        return ba(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), min, max, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ba(AtomicInteger index, PropertyMapping<?> pm, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return ba(index, pm, min, max, p -> ignoreStrategy.test(min, max));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L ba(AtomicInteger index, PropertyMapping<?> pm, V min, V max, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
            new FieldValueOperator[] { getFieldValueOperator(pm, min), getFieldValueOperator(pm, max) },
            ComparisonOperator.BA, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ba(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, V min, V max,
        BiPredicate<V, V> ignoreStrategy) {
        return ba(index, pm, name, min, max, p -> ignoreStrategy.test(min, max));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L ba(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, V min, V max,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(builder(pm, name).dialect(getDialect()) //
            .comparisonOperator(ComparisonOperator.BA) //
            .value(new FieldValueOperator[] { getFieldValueOperator(pm, min), getFieldValueOperator(pm, max) }) //
            .tableAlias(getAlias(index))//
            .ignoreStrategy(ignoreStrategy) //
            .build());
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ba(AtomicInteger index, String name, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return ba(index, getClassMapping(index).getPropertyMapping(name), min, max, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ba(AtomicInteger index, String name, V min, V max, Predicate<?> ignoreStrategy) {
        return ba(index, getClassMapping(index).getPropertyMapping(name), min, max, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ba(AtomicInteger index, ParamedColumnElement name, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return ba(index, getClassMapping(index).getPropertyMapping(name.getName()), name, min, max, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ba(AtomicInteger index, ParamedColumnElement name, V min, V max, Predicate<?> ignoreStrategy) {
        return ba(index, getClassMapping(index).getPropertyMapping(name.getName()), name, min, max, ignoreStrategy);
    }

    // ********************************************************************

    /** {@inheritDoc} */
    @Override
    public <V> L nba(AtomicInteger index, Serializable name, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return nba(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), min, max,
            p -> ignoreStrategy.test(min, max));
        //        return nba(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), min, max, p -> {
        //            Object[] ps = (Object[]) p;
        //            return ignoreStrategy.test((V) ps[0], (V) ps[1]);
        //        });
    }

    /** {@inheritDoc} */
    @Override
    public <V> L nba(AtomicInteger index, Serializable name, V min, V max, Predicate<?> ignoreStrategy) {
        return nba(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), min, max, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L nba(AtomicInteger index, PropertyMapping<?> pm, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return nba(index, pm, min, max, p -> ignoreStrategy.test(min, max));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L nba(AtomicInteger index, PropertyMapping<?> pm, V min, V max, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
            new FieldValueOperator[] { getFieldValueOperator(pm, min), getFieldValueOperator(pm, max) },
            ComparisonOperator.NBA, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    public <V> L nba(AtomicInteger index, String name, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return nba(index, getClassMapping(index).getPropertyMapping(name), min, max, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L nba(AtomicInteger index, String name, V min, V max, Predicate<?> ignoreStrategy) {
        return nba(index, getClassMapping(index).getPropertyMapping(name), min, max, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L nba(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, V min, V max,
        BiPredicate<V, V> ignoreStrategy) {
        return nba(index, pm, name, min, max, p -> ignoreStrategy.test(min, max));
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L nba(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, V min, V max,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(builder(pm, name).dialect(getDialect()) //
            .comparisonOperator(ComparisonOperator.NBA) //
            .value(new FieldValueOperator[] { getFieldValueOperator(pm, min), getFieldValueOperator(pm, max) }) //
            .tableAlias(getAlias(index))//
            .ignoreStrategy(ignoreStrategy) //
            .build());
    }

    /** {@inheritDoc} */
    @Override
    public <V> L nba(AtomicInteger index, ParamedColumnElement name, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return nba(index, getClassMapping(index).getPropertyMapping(name.getName()), name, min, max, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L nba(AtomicInteger index, ParamedColumnElement name, V min, V max, Predicate<?> ignoreStrategy) {
        return nba(index, getClassMapping(index).getPropertyMapping(name.getName()), name, min, max, ignoreStrategy);
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
        return eq(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
            ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L eq(AtomicInteger index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy) {
        return eq(index, pm, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L eq(AtomicInteger index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy) {
        return eq(index, pm, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L eq(AtomicInteger index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy) {
        return eq(index, pm, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <R> L eq(AtomicInteger index, PropertyMapping<?> pm, R value, Predicate<?> ignoreStrategy) {
        return eq(index, pm, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L eq(AtomicInteger index, PropertyMapping<?> pm, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return eqOrNe(index, ComparisonOperator.EQ, pm, value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L eq(AtomicInteger index, String name, int value, IntPredicate ignoreStrategy) {
        return eq(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L eq(AtomicInteger index, String name, long value, LongPredicate ignoreStrategy) {
        return eq(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L eq(AtomicInteger index, String name, double value, DoublePredicate ignoreStrategy) {
        return eq(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L eq(AtomicInteger index, String name, R value, Predicate<?> ignoreStrategy) {
        return eq(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L eq(AtomicInteger index, String name, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return eq(index, getClassMapping(index).getPropertyMapping(name), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L eq(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, int value,
        IntPredicate ignoreStrategy) {
        return eq(index, pm, name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L eq(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, long value,
        LongPredicate ignoreStrategy) {
        return eq(index, pm, name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L eq(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, double value,
        DoublePredicate ignoreStrategy) {
        return eq(index, pm, name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <R> L eq(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, R value,
        Predicate<?> ignoreStrategy) {
        return eq(index, pm, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L eq(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, R value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return eqOrNe(index, ComparisonOperator.EQ, pm, name, value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L eq(AtomicInteger index, ParamedColumnElement name, int value, IntPredicate ignoreStrategy) {
        return eq(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L eq(AtomicInteger index, ParamedColumnElement name, long value, LongPredicate ignoreStrategy) {
        return eq(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L eq(AtomicInteger index, ParamedColumnElement name, double value, DoublePredicate ignoreStrategy) {
        return eq(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L eq(AtomicInteger index, ParamedColumnElement name, R value, Predicate<?> ignoreStrategy) {
        return eq(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L eq(AtomicInteger index, ParamedColumnElement name, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return eq(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, matchStrategy,
            ignoreStrategy);
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
        return ne(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
            ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ne(AtomicInteger index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy) {
        return ne(index, pm, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ne(AtomicInteger index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy) {
        return ne(index, pm, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ne(AtomicInteger index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy) {
        return ne(index, pm, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ne(AtomicInteger index, PropertyMapping<?> pm, R value, Predicate<?> ignoreStrategy) {
        return ne(index, pm, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ne(AtomicInteger index, PropertyMapping<?> pm, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return eqOrNe(index, ComparisonOperator.NE, pm, value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ne(AtomicInteger index, String name, int value, IntPredicate ignoreStrategy) {
        return ne(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ne(AtomicInteger index, String name, long value, LongPredicate ignoreStrategy) {
        return ne(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ne(AtomicInteger index, String name, double value, DoublePredicate ignoreStrategy) {
        return ne(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ne(AtomicInteger index, String name, R value, Predicate<?> ignoreStrategy) {
        return ne(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ne(AtomicInteger index, String name, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return ne(index, getClassMapping(index).getPropertyMapping(name), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ne(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, int value,
        IntPredicate ignoreStrategy) {
        return ne(index, pm, name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ne(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, long value,
        LongPredicate ignoreStrategy) {
        return ne(index, pm, name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ne(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, double value,
        DoublePredicate ignoreStrategy) {
        return ne(index, pm, name, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ne(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, R value,
        Predicate<?> ignoreStrategy) {
        return ne(index, pm, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ne(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, R value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return eqOrNe(index, ComparisonOperator.NE, pm, name, value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ne(AtomicInteger index, ParamedColumnElement name, int value, IntPredicate ignoreStrategy) {
        return ne(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ne(AtomicInteger index, ParamedColumnElement name, long value, LongPredicate ignoreStrategy) {
        return ne(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ne(AtomicInteger index, ParamedColumnElement name, double value, DoublePredicate ignoreStrategy) {
        return ne(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ne(AtomicInteger index, ParamedColumnElement name, R value, Predicate<?> ignoreStrategy) {
        return ne(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ne(AtomicInteger index, ParamedColumnElement name, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return ne(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, matchStrategy,
            ignoreStrategy);
    }

    //    public abstract <R> L eq_ne(AtomicInteger index, ComparisonOperator comparisonOperator, List<PropertyMapping<?>> pms,
    //            R value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    //    public <R> L eq_ne(ComparisonOperator comparisonOperator, PropertyMapping<?> pm,  R value,
    //            MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
    //                getFieldValueOperator( pm, value), comparisonOperator, matchStrategy,  ignoreStrategy));
    //    }

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
        return sw(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
            ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L sw(AtomicInteger index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.SW, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    public L sw(AtomicInteger index, String name, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return sw(index, getClassMapping(index).getPropertyMapping(name), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L sw(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, String value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return (L) addCondition(builder(pm, name).dialect(getDialect()) //
            .comparisonOperator(ComparisonOperator.SW) //
            .value(getFieldValueOperator(pm, value)) //
            .tableAlias(getAlias(index))//
            .matchStrategy(matchStrategy) //
            .ignoreStrategy(ignoreStrategy) //
            .build());
    }

    /** {@inheritDoc} */
    @Override
    public L sw(AtomicInteger index, ParamedColumnElement name, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return sw(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, matchStrategy,
            ignoreStrategy);
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
        return nsw(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
            ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L nsw(AtomicInteger index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.NSW, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    public L nsw(AtomicInteger index, String name, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return nsw(index, getClassMapping(index).getPropertyMapping(name), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L nsw(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, String value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return (L) addCondition(builder(pm, name).dialect(getDialect()) //
            .comparisonOperator(ComparisonOperator.NSW) //
            .value(getFieldValueOperator(pm, value)) //
            .tableAlias(getAlias(index))//
            .matchStrategy(matchStrategy) //
            .ignoreStrategy(ignoreStrategy) //
            .build());
    }

    /** {@inheritDoc} */
    @Override
    public L nsw(AtomicInteger index, ParamedColumnElement name, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return nsw(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, matchStrategy,
            ignoreStrategy);
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
        return co(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
            ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L co(AtomicInteger index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.CO, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    public L co(AtomicInteger index, String name, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return co(index, getClassMapping(index).getPropertyMapping(name), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L co(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, String value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return (L) addCondition(builder(pm, name).dialect(getDialect()) //
            .comparisonOperator(ComparisonOperator.CO) //
            .value(getFieldValueOperator(pm, value)) //
            .tableAlias(getAlias(index))//
            .matchStrategy(matchStrategy) //
            .ignoreStrategy(ignoreStrategy) //
            .build());
    }

    /** {@inheritDoc} */
    @Override
    public L co(AtomicInteger index, ParamedColumnElement name, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return co(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, matchStrategy,
            ignoreStrategy);
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
        return nco(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
            ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L nco(AtomicInteger index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.NCO, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    public L nco(AtomicInteger index, String name, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return nco(index, getClassMapping(index).getPropertyMapping(name), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L nco(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, String value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return (L) addCondition(builder(pm, name).dialect(getDialect()) //
            .comparisonOperator(ComparisonOperator.NCO) //
            .value(getFieldValueOperator(pm, value)) //
            .tableAlias(getAlias(index))//
            .matchStrategy(matchStrategy) //
            .ignoreStrategy(ignoreStrategy) //
            .build());
    }

    /** {@inheritDoc} */
    @Override
    public L nco(AtomicInteger index, ParamedColumnElement name, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return nco(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, matchStrategy,
            ignoreStrategy);
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
        return ew(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
            ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L ew(AtomicInteger index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.EW, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    public L ew(AtomicInteger index, String name, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return ew(index, getClassMapping(index).getPropertyMapping(name), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L ew(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, String value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return (L) addCondition(builder(pm, name).dialect(getDialect()) //
            .comparisonOperator(ComparisonOperator.EW) //
            .value(getFieldValueOperator(pm, value)) //
            .tableAlias(getAlias(index))//
            .matchStrategy(matchStrategy) //
            .ignoreStrategy(ignoreStrategy) //
            .build());
    }

    /** {@inheritDoc} */
    @Override
    public L ew(AtomicInteger index, ParamedColumnElement name, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return ew(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, matchStrategy,
            ignoreStrategy);
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
        return newv(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
            ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L newv(AtomicInteger index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.NEW, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    public L newv(AtomicInteger index, String name, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return newv(index, getClassMapping(index).getPropertyMapping(name), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L newv(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, String value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return (L) addCondition(builder(pm, name).dialect(getDialect()) //
            .comparisonOperator(ComparisonOperator.NEW) //
            .value(getFieldValueOperator(pm, value)) //
            .tableAlias(getAlias(index))//
            .matchStrategy(matchStrategy) //
            .ignoreStrategy(ignoreStrategy) //
            .build());
    }

    /** {@inheritDoc} */
    @Override
    public L newv(AtomicInteger index, ParamedColumnElement name, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return newv(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, matchStrategy,
            ignoreStrategy);
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
        return lk(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
            ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L lk(AtomicInteger index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.LK, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    public L lk(AtomicInteger index, String name, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return lk(index, getClassMapping(index).getPropertyMapping(name), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L lk(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, String value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return (L) addCondition(builder(pm, name).dialect(getDialect()) //
            .comparisonOperator(ComparisonOperator.LK) //
            .value(getFieldValueOperator(pm, value)) //
            .tableAlias(getAlias(index))//
            .matchStrategy(matchStrategy) //
            .ignoreStrategy(ignoreStrategy) //
            .build());
    }

    /** {@inheritDoc} */
    @Override
    public L lk(AtomicInteger index, ParamedColumnElement name, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return lk(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, matchStrategy,
            ignoreStrategy);
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
        return nl(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
            ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L nl(AtomicInteger index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.NL, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    public L nl(AtomicInteger index, String name, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return nl(index, getClassMapping(index).getPropertyMapping(name), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L nl(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, String value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return (L) addCondition(builder(pm, name).dialect(getDialect()) //
            .comparisonOperator(ComparisonOperator.NL) //
            .value(getFieldValueOperator(pm, value)) //
            .tableAlias(getAlias(index))//
            .matchStrategy(matchStrategy) //
            .ignoreStrategy(ignoreStrategy) //
            .build());
    }

    /** {@inheritDoc} */
    @Override
    public L nl(AtomicInteger index, ParamedColumnElement name, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return nl(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, matchStrategy,
            ignoreStrategy);
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
        return in(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L in(AtomicInteger index, Serializable property, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return in(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
            ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy) {
        return in(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy) {
        return in(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy) {
        return in(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <R> L in(AtomicInteger index, PropertyMapping<?> pm, R value, Predicate<?> ignoreStrategy) {
        return in(index, pm, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <R> L in(AtomicInteger index, PropertyMapping<?> pm, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
            getInParam(pm, value), ComparisonOperator.IN, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, String name, int value, IntPredicate ignoreStrategy) {
        return in(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, String name, long value, LongPredicate ignoreStrategy) {
        return in(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, String name, double value, DoublePredicate ignoreStrategy) {
        return in(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L in(AtomicInteger index, String name, R value, Predicate<?> ignoreStrategy) {
        return in(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L in(AtomicInteger index, String name, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return in(index, getClassMapping(index).getPropertyMapping(name), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, int value,
        IntPredicate ignoreStrategy) {
        return in(index, pm, name, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, long value,
        LongPredicate ignoreStrategy) {
        return in(index, pm, name, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, double value,
        DoublePredicate ignoreStrategy) {
        return in(index, pm, name, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <R> L in(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, R value,
        Predicate<?> ignoreStrategy) {
        return in(index, pm, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <R> L in(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, R value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return (L) addCondition(builder(pm, name).dialect(getDialect()) //
            .comparisonOperator(ComparisonOperator.IN) //
            .value(getInParam(pm, value)) //
            .tableAlias(getAlias(index))//
            .matchStrategy(matchStrategy) //
            .ignoreStrategy(ignoreStrategy) //
            .build());
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, ParamedColumnElement name, int value, IntPredicate ignoreStrategy) {
        return in(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, ParamedColumnElement name, long value, LongPredicate ignoreStrategy) {
        return in(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L in(AtomicInteger index, ParamedColumnElement name, double value, DoublePredicate ignoreStrategy) {
        return in(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L in(AtomicInteger index, ParamedColumnElement name, R value, Predicate<?> ignoreStrategy) {
        return in(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L in(AtomicInteger index, ParamedColumnElement name, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return in(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, matchStrategy,
            ignoreStrategy);
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
        return ni(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ni(AtomicInteger index, Serializable property, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return ni(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
            ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy) {
        return ni(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy) {
        return ni(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy) {
        return ni(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ni(AtomicInteger index, PropertyMapping<?> pm, R value, Predicate<?> ignoreStrategy) {
        return ni(index, pm, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <R> L ni(AtomicInteger index, PropertyMapping<?> pm, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
            getInParam(pm, value), ComparisonOperator.NI, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, String name, int value, IntPredicate ignoreStrategy) {
        return ni(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, String name, long value, LongPredicate ignoreStrategy) {
        return ni(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, String name, double value, DoublePredicate ignoreStrategy) {
        return ni(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ni(AtomicInteger index, String name, R value, Predicate<?> ignoreStrategy) {
        return ni(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ni(AtomicInteger index, String name, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return ni(index, getClassMapping(index).getPropertyMapping(name), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, int value,
        IntPredicate ignoreStrategy) {
        return ni(index, pm, name, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, long value,
        LongPredicate ignoreStrategy) {
        return ni(index, pm, name, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, double value,
        DoublePredicate ignoreStrategy) {
        return ni(index, pm, name, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ni(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, R value,
        Predicate<?> ignoreStrategy) {
        return ni(index, pm, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <R> L ni(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, R value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return (L) addCondition(builder(pm, name).dialect(getDialect()) //
            .comparisonOperator(ComparisonOperator.NI) //
            .value(getInParam(pm, value)) //
            .tableAlias(getAlias(index))//
            .matchStrategy(matchStrategy) //
            .ignoreStrategy(ignoreStrategy) //
            .build());
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, ParamedColumnElement name, int value, IntPredicate ignoreStrategy) {
        return ni(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, ParamedColumnElement name, long value, LongPredicate ignoreStrategy) {
        return ni(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ni(AtomicInteger index, ParamedColumnElement name, double value, DoublePredicate ignoreStrategy) {
        return ni(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ni(AtomicInteger index, ParamedColumnElement name, R value, Predicate<?> ignoreStrategy) {
        return ni(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <R> L ni(AtomicInteger index, ParamedColumnElement name, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return ni(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, matchStrategy,
            ignoreStrategy);
    }

    // ****************************************************************************************************************

    /** {@inheritDoc} */
    @Override
    public L isn(AtomicInteger index, String name, Boolean value) {
        return isn(index, getClassMapping(index).getPropertyMapping(name), value);
    }

    /** {@inheritDoc} */
    @Override
    public L isn(AtomicInteger index, Serializable property, Boolean value) {
        return isn(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L isn(AtomicInteger index, PropertyMapping<?> pm, Boolean value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(), value,
            ComparisonOperator.ISN, getAlias(index), getIgnoreStrategy()));
    }

    /** {@inheritDoc} */
    @Override
    public L inn(AtomicInteger index, Serializable property, Boolean value) {
        return inn(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public L inn(AtomicInteger index, PropertyMapping<?> pm, Boolean value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(), value,
            ComparisonOperator.INN, getAlias(index), getIgnoreStrategy()));
    }

    /** {@inheritDoc} */
    @Override
    public L inn(AtomicInteger index, String name, Boolean value) {
        return inn(index, getClassMapping(index).getPropertyMapping(name), value);
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
        return ge(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, SerializableToLongFunction<?> name, long value, LongPredicate ignoreStrategy) {
        return ge(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, SerializableToDoubleFunction<?> name, double value,
        DoublePredicate ignoreStrategy) {
        return ge(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ge(AtomicInteger index, Serializable name, V value, Predicate<?> ignoreStrategy) {
        return ge(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ge(AtomicInteger index, Serializable name, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return ge(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, matchStrategy,
            ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy) {
        return ge(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy) {
        return ge(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy) {
        return ge(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ge(AtomicInteger index, PropertyMapping<?> pm, V value, Predicate<?> ignoreStrategy) {
        return ge(index, pm, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L ge(AtomicInteger index, PropertyMapping<?> pm, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.GE, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, String name, int value, IntPredicate ignoreStrategy) {
        return ge(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, String name, long value, LongPredicate ignoreStrategy) {
        return ge(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, String name, double value, DoublePredicate ignoreStrategy) {
        return ge(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ge(AtomicInteger index, String name, V value, Predicate<?> ignoreStrategy) {
        return ge(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ge(AtomicInteger index, String name, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return ge(index, getClassMapping(index).getPropertyMapping(name), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, int value,
        IntPredicate ignoreStrategy) {
        return ge(index, pm, name, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, long value,
        LongPredicate ignoreStrategy) {
        return ge(index, pm, name, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, double value,
        DoublePredicate ignoreStrategy) {
        return ge(index, pm, name, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ge(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, V value,
        Predicate<?> ignoreStrategy) {
        return ge(index, pm, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L ge(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, V value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return (L) addCondition(builder(pm, name).dialect(getDialect()) //
            .comparisonOperator(ComparisonOperator.GE) //
            .value(getFieldValueOperator(pm, value)) //
            .tableAlias(getAlias(index))//
            .matchStrategy(matchStrategy) //
            .ignoreStrategy(ignoreStrategy) //
            .build());
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, ParamedColumnElement name, int value, IntPredicate ignoreStrategy) {
        return ge(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, ParamedColumnElement name, long value, LongPredicate ignoreStrategy) {
        return ge(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L ge(AtomicInteger index, ParamedColumnElement name, double value, DoublePredicate ignoreStrategy) {
        return ge(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ge(AtomicInteger index, ParamedColumnElement name, V value, Predicate<?> ignoreStrategy) {
        return ge(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L ge(AtomicInteger index, ParamedColumnElement name, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return ge(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, matchStrategy,
            ignoreStrategy);
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
        return gt(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, SerializableToLongFunction<?> name, long value, LongPredicate ignoreStrategy) {
        return gt(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, SerializableToDoubleFunction<?> name, double value,
        DoublePredicate ignoreStrategy) {
        return gt(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L gt(AtomicInteger index, Serializable name, V value, Predicate<?> ignoreStrategy) {
        return gt(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L gt(AtomicInteger index, Serializable name, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return gt(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, matchStrategy,
            ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy) {
        return gt(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy) {
        return gt(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy) {
        return gt(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <V> L gt(AtomicInteger index, PropertyMapping<?> pm, V value, Predicate<?> ignoreStrategy) {
        return gt(index, pm, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L gt(AtomicInteger index, PropertyMapping<?> pm, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.GT, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, String name, int value, IntPredicate ignoreStrategy) {
        return gt(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, String name, long value, LongPredicate ignoreStrategy) {
        return gt(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, String name, double value, DoublePredicate ignoreStrategy) {
        return gt(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L gt(AtomicInteger index, String name, V value, Predicate<?> ignoreStrategy) {
        return gt(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L gt(AtomicInteger index, String name, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return gt(index, getClassMapping(index).getPropertyMapping(name), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, int value,
        IntPredicate ignoreStrategy) {
        return gt(index, pm, name, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, long value,
        LongPredicate ignoreStrategy) {
        return gt(index, pm, name, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, double value,
        DoublePredicate ignoreStrategy) {
        return gt(index, pm, name, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <V> L gt(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, V value,
        Predicate<?> ignoreStrategy) {
        return gt(index, pm, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L gt(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, V value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return (L) addCondition(builder(pm, name).dialect(getDialect()) //
            .comparisonOperator(ComparisonOperator.GT) //
            .value(getFieldValueOperator(pm, value)) //
            .tableAlias(getAlias(index))//
            .matchStrategy(matchStrategy) //
            .ignoreStrategy(ignoreStrategy) //
            .build());
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, ParamedColumnElement name, int value, IntPredicate ignoreStrategy) {
        return gt(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, ParamedColumnElement name, long value, LongPredicate ignoreStrategy) {
        return gt(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L gt(AtomicInteger index, ParamedColumnElement name, double value, DoublePredicate ignoreStrategy) {
        return gt(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L gt(AtomicInteger index, ParamedColumnElement name, V value, Predicate<?> ignoreStrategy) {
        return gt(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L gt(AtomicInteger index, ParamedColumnElement name, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return gt(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, matchStrategy,
            ignoreStrategy);
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
        return le(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, SerializableToLongFunction<?> name, long value, LongPredicate ignoreStrategy) {
        return le(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, SerializableToDoubleFunction<?> name, double value,
        DoublePredicate ignoreStrategy) {
        return le(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L le(AtomicInteger index, Serializable name, V value, Predicate<?> ignoreStrategy) {
        return le(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L le(AtomicInteger index, Serializable name, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return le(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, matchStrategy,
            ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy) {
        return le(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy) {
        return le(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy) {
        return le(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <V> L le(AtomicInteger index, PropertyMapping<?> pm, V value, Predicate<?> ignoreStrategy) {
        return le(index, pm, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L le(AtomicInteger index, PropertyMapping<?> pm, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.LE, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, String name, int value, IntPredicate ignoreStrategy) {
        return le(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, String name, long value, LongPredicate ignoreStrategy) {
        return le(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, String name, double value, DoublePredicate ignoreStrategy) {
        return le(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L le(AtomicInteger index, String name, V value, Predicate<?> ignoreStrategy) {
        return le(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L le(AtomicInteger index, String name, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return le(index, getClassMapping(index).getPropertyMapping(name), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, int value,
        IntPredicate ignoreStrategy) {
        return le(index, pm, name, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, long value,
        LongPredicate ignoreStrategy) {
        return le(index, pm, name, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, double value,
        DoublePredicate ignoreStrategy) {
        return le(index, pm, name, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <V> L le(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, V value,
        Predicate<?> ignoreStrategy) {
        return le(index, pm, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L le(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, V value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return (L) addCondition(builder(pm, name).dialect(getDialect()) //
            .comparisonOperator(ComparisonOperator.LE) //
            .value(getFieldValueOperator(pm, value)) //
            .tableAlias(getAlias(index))//
            .matchStrategy(matchStrategy) //
            .ignoreStrategy(ignoreStrategy) //
            .build());
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, ParamedColumnElement name, int value, IntPredicate ignoreStrategy) {
        return le(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, ParamedColumnElement name, long value, LongPredicate ignoreStrategy) {
        return le(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L le(AtomicInteger index, ParamedColumnElement name, double value, DoublePredicate ignoreStrategy) {
        return le(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L le(AtomicInteger index, ParamedColumnElement name, V value, Predicate<?> ignoreStrategy) {
        return le(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L le(AtomicInteger index, ParamedColumnElement name, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return le(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, matchStrategy,
            ignoreStrategy);
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
        return lt(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, SerializableToLongFunction<?> name, long value, LongPredicate ignoreStrategy) {
        return lt(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, SerializableToDoubleFunction<?> name, double value,
        DoublePredicate ignoreStrategy) {
        return lt(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L lt(AtomicInteger index, Serializable name, V value, Predicate<?> ignoreStrategy) {
        return lt(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L lt(AtomicInteger index, Serializable name, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return lt(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, matchStrategy,
            ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy) {
        return lt(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy) {
        return lt(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy) {
        return lt(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <V> L lt(AtomicInteger index, PropertyMapping<?> pm, V value, Predicate<?> ignoreStrategy) {
        return lt(index, pm, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L lt(AtomicInteger index, PropertyMapping<?> pm, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
            getFieldValueOperator(pm, value), ComparisonOperator.LT, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, String name, int value, IntPredicate ignoreStrategy) {
        return lt(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, String name, long value, LongPredicate ignoreStrategy) {
        return lt(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, String name, double value, DoublePredicate ignoreStrategy) {
        return lt(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L lt(AtomicInteger index, String name, V value, Predicate<?> ignoreStrategy) {
        return lt(index, getClassMapping(index).getPropertyMapping(name), value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L lt(AtomicInteger index, String name, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return lt(index, getClassMapping(index).getPropertyMapping(name), value, matchStrategy, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, int value,
        IntPredicate ignoreStrategy) {
        return lt(index, pm, name, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, long value,
        LongPredicate ignoreStrategy) {
        return lt(index, pm, name, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, double value,
        DoublePredicate ignoreStrategy) {
        return lt(index, pm, name, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /** {@inheritDoc} */
    @Override
    public <V> L lt(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, V value,
        Predicate<?> ignoreStrategy) {
        return lt(index, pm, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <V> L lt(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, V value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return (L) addCondition(builder(pm, name).dialect(getDialect()) //
            .comparisonOperator(ComparisonOperator.LT) //
            .value(getFieldValueOperator(pm, value)) //
            .tableAlias(getAlias(index))//
            .matchStrategy(matchStrategy) //
            .ignoreStrategy(ignoreStrategy) //
            .build());
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, ParamedColumnElement name, int value, IntPredicate ignoreStrategy) {
        return lt(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, ParamedColumnElement name, long value, LongPredicate ignoreStrategy) {
        return lt(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public L lt(AtomicInteger index, ParamedColumnElement name, double value, DoublePredicate ignoreStrategy) {
        return lt(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L lt(AtomicInteger index, ParamedColumnElement name, V value, Predicate<?> ignoreStrategy) {
        return lt(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, ignoreStrategy);
    }

    /** {@inheritDoc} */
    @Override
    public <V> L lt(AtomicInteger index, ParamedColumnElement name, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        return lt(index, getClassMapping(index).getPropertyMapping(name.getName()), name, value, matchStrategy,
            ignoreStrategy);
    }

    // ****************************************************************************************************************

    private SqlConditionExpressionBuilder.Builder builder(PropertyMapping<?> pm, ParamedColumnElement name) {
        SqlConditionExpressionBuilder.Builder builder = null;
        if (name == null) {
            builder = SqlConditionExpressionBuilder.field(pm.getRepositoryFieldName());
        } else {
            builder = SqlConditionExpressionBuilder.field(name);
        }
        return builder;
    }

    // ****************************************************************************************************************
    //  property
    // ****************************************************************************************************************

    /**
     * Gets the class mapping.
     *
     * @param <M> the generic type
     * @param <T> the generic type
     * @param <P> the generic type
     * @param index the index
     * @return the class mapping
     */
    protected <M extends ClassMapping<T, P>, T, P extends PropertyMapping<P>> M getClassMapping(AtomicInteger index) {
        return getClassMapping(index.get());
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
}
