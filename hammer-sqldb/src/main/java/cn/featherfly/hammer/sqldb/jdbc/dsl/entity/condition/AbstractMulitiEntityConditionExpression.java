/*
 * All rights Reserved, Designed By zhongj
 * @Title: AbstractMulitiEntityConditionExpression.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition
 * @Description: AbstractMulitiEntityConditionExpression
 * @author: zhongj
 * @date: 2023-08-07 17:33:07
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
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
import cn.featherfly.hammer.expression.condition.AbstractMulitiConditionExpression;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.sql.dml.SqlConditionExpressionBuilder;

/**
 * The Class AbstractMulitiEntityConditionExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractMulitiEntityConditionExpression<C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends AbstractMulitiConditionExpression {

    /**
     * Instantiates a new abstract muliti entity condition expression.
     *
     * @param ignoreStrategy the ignore strategy
     */
    protected AbstractMulitiEntityConditionExpression(Predicate<?> ignoreStrategy) {
        super(ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object getInParam(PropertyMapping<?> pm, Object value) {
        Object param = null;
        if (value != null) {
            if (value.getClass().isArray()) {
                int length = Array.getLength(value);
                param = Array.newInstance(FieldValueOperator.class, length);
                for (int i = 0; i < length; i++) {
                    Array.set(param, i, getFieldValueOperator(pm, Array.get(value, i)));
                }
            } else if (value instanceof Collection) {
                param = ((Collection<?>) value).stream().map(op -> getFieldValueOperator(pm, op))
                        .collect(Collectors.toList());
                //                Collection<FieldValueOperator<?>> paramCollection = new ArrayList<>();
                //                for (Object op : (Collection<?>) value) {
                //                    paramCollection.add(getFieldValueOperator(pm, op));
                //                }
                //                param = paramCollection;
            } else if (value instanceof FieldValueOperator) {
                param = value;
            } else {
                param = getFieldValueOperator(pm, value);
            }
        }
        return param;
    }

    /**
     * Gets the field value operator.
     *
     * @param <R>   the generic type
     * @param pm    the pm
     * @param value the value
     * @return the field value operator
     */
    protected <R> FieldValueOperator<R> getFieldValueOperator(PropertyMapping<?> pm, R value) {
        return FieldValueOperator.create((JdbcPropertyMapping) pm, value);
    }

    // ********************************************************************

    /**
     * Ba 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L ba0(AtomicInteger index, Serializable name, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return ba0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), min, max,
                p -> ignoreStrategy.test(min, max));
    }

    /**
     * Ba 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L ba0(AtomicInteger index, Serializable name, V min, V max, Predicate<?> ignoreStrategy) {
        return ba0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), min, max, ignoreStrategy);
    }

    /**
     * Ba 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param pm             the pm
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L ba0(AtomicInteger index, PropertyMapping<?> pm, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return ba0(index, pm, min, max, p -> ignoreStrategy.test(min, max));
    }

    /**
     * Ba 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param pm             the pm
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    @SuppressWarnings("unchecked")
    protected <V> L ba0(AtomicInteger index, PropertyMapping<?> pm, V min, V max, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                new FieldValueOperator[] { getFieldValueOperator(pm, min), getFieldValueOperator(pm, max) },
                ComparisonOperator.BA, getAlias(index), ignoreStrategy));
        //        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
        //                getFieldValueOperator(pm, new Object[] { min, max }), ComparisonOperator.BA, getAlias(index),
        //                ignoreStrategy));
    }

    // ********************************************************************

    /**
     * Nba 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L nba0(AtomicInteger index, Serializable name, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return nba0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), min, max,
                p -> ignoreStrategy.test(min, max));
        //        return nba0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), min, max, p -> {
        //            Object[] ps = (Object[]) p;
        //            return ignoreStrategy.test((V) ps[0], (V) ps[1]);
        //        });
    }

    /**
     * Nba 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L nba0(AtomicInteger index, Serializable name, V min, V max, Predicate<?> ignoreStrategy) {
        return nba0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), min, max, ignoreStrategy);
    }

    /**
     * Nba 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param pm             the pm
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L nba0(AtomicInteger index, PropertyMapping<?> pm, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return nba0(index, pm, min, max, p -> ignoreStrategy.test(min, max));
    }

    /**
     * Nba 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param pm             the pm
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    @SuppressWarnings("unchecked")
    protected <V> L nba0(AtomicInteger index, PropertyMapping<?> pm, V min, V max, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                new FieldValueOperator[] { getFieldValueOperator(pm, min), getFieldValueOperator(pm, max) },
                ComparisonOperator.NBA, getAlias(index), ignoreStrategy));
    }

    // ********************************************************************

    /**
     * Eq 0.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L eq0(AtomicInteger index, SerializableSupplier<R> property, Predicate<?> ignoreStrategy) {
        return eq0(index, property, property.get(), MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * Eq 0.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L eq0(AtomicInteger index, SerializableSupplier<R> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return eq0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * Eq 0.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L eq0(AtomicInteger index, Serializable property, int value, IntPredicate ignoreStrategy) {
        return eq0(index, property, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * Eq 0.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L eq0(AtomicInteger index, Serializable property, long value, LongPredicate ignoreStrategy) {
        return eq0(index, property, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Long) v));
    }

    /**
     * Eq 0.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L eq0(AtomicInteger index, Serializable property, double value, DoublePredicate ignoreStrategy) {
        return eq0(index, property, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Double) v));
    }

    /**
     * Eq 0.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L eq0(AtomicInteger index, Serializable property, R value, Predicate<?> ignoreStrategy) {
        return eq0(index, property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * Eq 0.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L eq0(AtomicInteger index, Serializable property, R value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return eq0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
                ignoreStrategy);
    }

    /**
     * Eq 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L eq0(AtomicInteger index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy) {
        return eq0(index, pm, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * Eq 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L eq0(AtomicInteger index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy) {
        return eq0(index, pm, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Long) v));
    }

    /**
     * Eq 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L eq0(AtomicInteger index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy) {
        return eq0(index, pm, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Double) v));
    }

    /**
     * Eq 0.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L eq0(AtomicInteger index, PropertyMapping<?> pm, R value, Predicate<?> ignoreStrategy) {
        return eq0(index, pm, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * Eq 0.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L eq0(AtomicInteger index, PropertyMapping<?> pm, R value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return eq_ne(index, ComparisonOperator.EQ, pm, value, matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Ne 0.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L ne0(AtomicInteger index, SerializableSupplier<R> property, Predicate<?> ignoreStrategy) {
        return ne0(index, property, property.get(), MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * Ne 0.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L ne0(AtomicInteger index, SerializableSupplier<R> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return ne0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * Ne 0.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ne0(AtomicInteger index, Serializable property, int value, IntPredicate ignoreStrategy) {
        return ne0(index, property, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * Ne 0.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ne0(AtomicInteger index, Serializable property, long value, LongPredicate ignoreStrategy) {
        return ne0(index, property, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Long) v));
    }

    /**
     * Ne 0.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ne0(AtomicInteger index, Serializable property, double value, DoublePredicate ignoreStrategy) {
        return ne0(index, property, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Double) v));
    }

    /**
     * Ne 0.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L ne0(AtomicInteger index, Serializable property, R value, Predicate<?> ignoreStrategy) {
        return ne0(index, property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * Ne 0.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L ne0(AtomicInteger index, Serializable property, R value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return ne0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
                ignoreStrategy);
    }

    /**
     * Ne 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ne0(AtomicInteger index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy) {
        return ne0(index, pm, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * Ne 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ne0(AtomicInteger index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy) {
        return ne0(index, pm, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Long) v));
    }

    /**
     * Ne 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ne0(AtomicInteger index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy) {
        return ne0(index, pm, value, MatchStrategy.AUTO, v -> ignoreStrategy.test((Double) v));
    }

    /**
     * Ne 0.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L ne0(AtomicInteger index, PropertyMapping<?> pm, R value, Predicate<?> ignoreStrategy) {
        return ne0(index, pm, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * Ne 0.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L ne0(AtomicInteger index, PropertyMapping<?> pm, R value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return eq_ne(index, ComparisonOperator.NE, pm, value, matchStrategy, ignoreStrategy);
    }

    /**
     * Eq ne.
     *
     * @param <R>                the generic type
     * @param index              the index
     * @param comparisonOperator the comparison operator
     * @param pm                 the pm
     * @param value              the value
     * @param matchStrategy      the match strategy
     * @param ignoreStrategy     the ignore strategy
     * @return the l
     */
    protected abstract <R> L eq_ne(AtomicInteger index, ComparisonOperator comparisonOperator, PropertyMapping<?> pm,
            R value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    //    protected abstract <R> L eq_ne(AtomicInteger index, ComparisonOperator comparisonOperator, List<PropertyMapping<?>> pms,
    //            R value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    //    protected <R> L eq_ne(ComparisonOperator comparisonOperator, PropertyMapping<?> pm, R value,
    //            MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
    //                getFieldValueOperator(pm, value), comparisonOperator, matchStrategy,  ignoreStrategy));
    //    }

    // ****************************************************************************************************************

    /**
     * Sw 0.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L sw0(AtomicInteger index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return sw0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * Sw 0.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L sw0(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return sw0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
                ignoreStrategy);
    }

    /**
     * Sw 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    @SuppressWarnings("unchecked")
    protected L sw0(AtomicInteger index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.SW, matchStrategy, getAlias(index),
                ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * Nsw 0.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L nsw0(AtomicInteger index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return nsw0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * Nsw 0.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L nsw0(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return nsw0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
                ignoreStrategy);
    }

    /**
     * Nsw 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    @SuppressWarnings("unchecked")
    protected L nsw0(AtomicInteger index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.NSW, matchStrategy, getAlias(index),
                ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * Co 0.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L co0(AtomicInteger index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return co0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * Co 0.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L co0(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return co0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
                ignoreStrategy);
    }

    /**
     * Co 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    @SuppressWarnings("unchecked")
    protected L co0(AtomicInteger index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.CO, matchStrategy, getAlias(index),
                ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * Nco 0.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L nco0(AtomicInteger index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return nco0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * Nco 0.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L nco0(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return nco0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
                ignoreStrategy);
    }

    /**
     * Nco 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    @SuppressWarnings("unchecked")
    protected L nco0(AtomicInteger index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.NCO, matchStrategy, getAlias(index),
                ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * Ew 0.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ew0(AtomicInteger index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return ew0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * Ew 0.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ew0(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return ew0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
                ignoreStrategy);
    }

    /**
     * Ew 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    @SuppressWarnings("unchecked")
    protected L ew0(AtomicInteger index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.EW, matchStrategy, getAlias(index),
                ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * New 0.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L new0(AtomicInteger index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return new0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * New 0.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L new0(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return new0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
                ignoreStrategy);
    }

    /**
     * New 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    @SuppressWarnings("unchecked")
    protected L new0(AtomicInteger index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.NEW, matchStrategy, getAlias(index),
                ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * Lk 0.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L lk0(AtomicInteger index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return lk0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * Lk 0.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L lk0(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return lk0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
                ignoreStrategy);
    }

    /**
     * Lk 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    @SuppressWarnings("unchecked")
    protected L lk0(AtomicInteger index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.LK, matchStrategy, getAlias(index),
                ignoreStrategy));
    }
    // ****************************************************************************************************************

    /**
     * Nl 0.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L nl0(AtomicInteger index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return nl0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * Nl 0.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L nl0(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return nl0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
                ignoreStrategy);
    }

    /**
     * Nl 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    @SuppressWarnings("unchecked")
    protected L nl0(AtomicInteger index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.NL, matchStrategy, getAlias(index),
                ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * In 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L in0(AtomicInteger index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return in0(index, property, property.getAsInt(), v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * In 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L in0(AtomicInteger index, SerializableIntSupplier property, Predicate<?> ignoreStrategy) {
        return in0(index, property, property.getAsInt(), ignoreStrategy);
    }

    /**
     * In 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L in0(AtomicInteger index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return in0(index, property, property.getAsLong(), v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * In 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L in0(AtomicInteger index, SerializableLongSupplier property, Predicate<?> ignoreStrategy) {
        return in0(index, property, property.getAsLong(), ignoreStrategy);
    }

    /**
     * In 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L in0(AtomicInteger index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return in0(index, property, property.getAsDouble(), v -> ignoreStrategy.test((Double) v));
    }

    /**
     * In 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L in0(AtomicInteger index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy) {
        return in0(index, property, property.getAsDouble(), ignoreStrategy);
    }

    /**
     * In 0.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L in0(AtomicInteger index, SerializableSupplier<R> property, Predicate<?> ignoreStrategy) {
        return in0(index, property, property.get(), ignoreStrategy);
    }

    /**
     * In 0.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L in0(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return in0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * In 0.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L in0(AtomicInteger index, SerializableArraySupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return in0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * In 0.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <T> L in0(AtomicInteger index, SerializableToIntFunction<T> property, int value,
            IntPredicate ignoreStrategy) {
        return in0(index, (Serializable) property, value, v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * In 0.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <T> L in0(AtomicInteger index, SerializableToLongFunction<T> property, long value,
            LongPredicate ignoreStrategy) {
        return in0(index, (Serializable) property, value, v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * In 0.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <T> L in0(AtomicInteger index, SerializableToDoubleFunction<T> property, double value,
            DoublePredicate ignoreStrategy) {
        return in0(index, (Serializable) property, value, v -> ignoreStrategy.test((Double) v));
    }

    /**
     * In 0.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L in0(AtomicInteger index, Serializable property, R value, Predicate<?> ignoreStrategy) {
        return in0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, ignoreStrategy);
    }

    /**
     * In 0.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L in0(AtomicInteger index, Serializable property, R value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return in0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
                ignoreStrategy);
    }

    /**
     * In 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L in0(AtomicInteger index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy) {
        return in0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * In 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L in0(AtomicInteger index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy) {
        return in0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /**
     * In 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L in0(AtomicInteger index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy) {
        return in0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /**
     * In 0.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L in0(AtomicInteger index, PropertyMapping<?> pm, R value, Predicate<?> ignoreStrategy) {
        return in0(index, pm, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * In 0.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    @SuppressWarnings("unchecked")
    protected <R> L in0(AtomicInteger index, PropertyMapping<?> pm, R value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getInParam(pm, value), ComparisonOperator.IN, matchStrategy, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * Ni 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ni0(AtomicInteger index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return ni0(index, property, property.getAsInt(), v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * Ni 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ni0(AtomicInteger index, SerializableIntSupplier property, Predicate<?> ignoreStrategy) {
        return ni0(index, property, property.getAsInt(), ignoreStrategy);
    }

    /**
     * Ni 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ni0(AtomicInteger index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return ni0(index, property, property.getAsLong(), v -> ignoreStrategy.test((Long) v));
    }

    /**
     * Ni 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ni0(AtomicInteger index, SerializableLongSupplier property, Predicate<?> ignoreStrategy) {
        return ni0(index, property, property.getAsLong(), ignoreStrategy);
    }

    /**
     * Ni 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ni0(AtomicInteger index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return ni0(index, property, property.getAsDouble(), v -> ignoreStrategy.test((Double) v));
    }

    /**
     * Ni 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ni0(AtomicInteger index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy) {
        return ni0(index, property, property.getAsDouble(), ignoreStrategy);
    }

    /**
     * Ni 0.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L ni0(AtomicInteger index, SerializableSupplier<R> property, Predicate<?> ignoreStrategy) {
        return ni0(index, property, property.get(), ignoreStrategy);
    }

    /**
     * Ni 0.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <T> L ni0(AtomicInteger index, SerializableToIntFunction<T> property, int value,
            IntPredicate ignoreStrategy) {
        return ni0(index, (Serializable) property, value, v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * Ni 0.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <T> L ni0(AtomicInteger index, SerializableToLongFunction<T> property, long value,
            LongPredicate ignoreStrategy) {
        return ni0(index, (Serializable) property, value, v -> ignoreStrategy.test((Long) v));
    }

    /**
     * Ni 0.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <T> L ni0(AtomicInteger index, SerializableToDoubleFunction<T> property, double value,
            DoublePredicate ignoreStrategy) {
        return ni0(index, (Serializable) property, value, v -> ignoreStrategy.test((Double) v));
    }

    /**
     * Ni 0.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L ni0(AtomicInteger index, Serializable property, R value, Predicate<?> ignoreStrategy) {
        return ni0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, ignoreStrategy);
    }

    /**
     * Ni 0.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L ni0(AtomicInteger index, Serializable property, R value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return ni0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
                ignoreStrategy);
    }

    /**
     * Ni 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ni0(AtomicInteger index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy) {
        return ni0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * Ni 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ni0(AtomicInteger index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy) {
        return ni0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /**
     * Ni 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ni0(AtomicInteger index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy) {
        return ni0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /**
     * Ni 0.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <R> L ni0(AtomicInteger index, PropertyMapping<?> pm, R value, Predicate<?> ignoreStrategy) {
        return ni0(index, pm, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * Ni 0.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    @SuppressWarnings("unchecked")
    protected <R> L ni0(AtomicInteger index, PropertyMapping<?> pm, R value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getInParam(pm, value), ComparisonOperator.NI, matchStrategy, getAlias(index), ignoreStrategy));
    }

    /**
     * Isn 0.
     *
     * @param index    the index
     * @param property the property
     * @param value    the value
     * @return the l
     */
    protected L isn0(AtomicInteger index, Serializable property, Boolean value) {
        return isn0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value);
    }

    /**
     * Isn 0.
     *
     * @param index the index
     * @param pm    the pm
     * @param value the value
     * @return the l
     */
    @SuppressWarnings("unchecked")
    protected L isn0(AtomicInteger index, PropertyMapping<?> pm, Boolean value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(), value,
                ComparisonOperator.ISN, getAlias(index), ignoreStrategy));
    }

    /**
     * Inn 0.
     *
     * @param index    the index
     * @param property the property
     * @param value    the value
     * @return the l
     */
    protected L inn0(AtomicInteger index, Serializable property, Boolean value) {
        return inn0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value);
    }

    /**
     * Inn 0.
     *
     * @param index the index
     * @param pm    the pm
     * @param value the value
     * @return the l
     */
    @SuppressWarnings("unchecked")
    protected L inn0(AtomicInteger index, PropertyMapping<?> pm, Boolean value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(), value,
                ComparisonOperator.INN, getAlias(index), ignoreStrategy));
    }

    // ********************************************************************

    /**
     * Ge 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ge0(AtomicInteger index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return ge0(index, property, property.getAsInt(), v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * Ge 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ge0(AtomicInteger index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return ge0(index, property, property.getAsLong(), v -> ignoreStrategy.test((Long) v));
    }

    /**
     * Ge 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ge0(AtomicInteger index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return ge0(index, property, property.getAsDouble(), v -> ignoreStrategy.test((Double) v));
    }

    /**
     * Ge 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ge0(AtomicInteger index, SerializableIntSupplier property, Predicate<?> ignoreStrategy) {
        return ge0(index, property, property.getAsInt(), ignoreStrategy);
    }

    /**
     * Ge 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ge0(AtomicInteger index, SerializableLongSupplier property, Predicate<?> ignoreStrategy) {
        return ge0(index, property, property.getAsLong(), ignoreStrategy);
    }

    /**
     * Ge 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ge0(AtomicInteger index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy) {
        return ge0(index, property, property.getAsDouble(), ignoreStrategy);
    }

    /**
     * Ge 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L ge0(AtomicInteger index, SerializableSupplier<V> property, Predicate<?> ignoreStrategy) {
        return ge0(index, property, property.get(), ignoreStrategy);
    }

    /**
     * Ge 0.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ge0(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return ge0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * Ge 0.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ge0(AtomicInteger index, SerializableToIntFunction<?> name, int value, IntPredicate ignoreStrategy) {
        return ge0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /**
     * Ge 0.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ge0(AtomicInteger index, SerializableToLongFunction<?> name, long value, LongPredicate ignoreStrategy) {
        return ge0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /**
     * Ge 0.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ge0(AtomicInteger index, SerializableToDoubleFunction<?> name, double value,
            DoublePredicate ignoreStrategy) {
        return ge0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /**
     * Ge 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L ge0(AtomicInteger index, Serializable name, V value, Predicate<?> ignoreStrategy) {
        return ge0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /**
     * Ge 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L ge0(AtomicInteger index, Serializable name, V value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return ge0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, matchStrategy,
                ignoreStrategy);
    }

    /**
     * Ge 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ge0(AtomicInteger index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy) {
        return ge0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * Ge 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ge0(AtomicInteger index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy) {
        return ge0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /**
     * Ge 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L ge0(AtomicInteger index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy) {
        return ge0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /**
     * Ge 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    @SuppressWarnings("unchecked")
    protected <V> L ge0(AtomicInteger index, PropertyMapping<?> pm, V value, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.GE, getAlias(index), ignoreStrategy));
    }

    /**
     * Ge 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    @SuppressWarnings("unchecked")
    protected <V> L ge0(AtomicInteger index, PropertyMapping<?> pm, V value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.GE, matchStrategy, getAlias(index),
                ignoreStrategy));
    }

    // ********************************************************************

    /**
     * Gt 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L gt0(AtomicInteger index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return gt0(index, property, property.getAsInt(), v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * Gt 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L gt0(AtomicInteger index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return gt0(index, property, property.getAsLong(), v -> ignoreStrategy.test((Long) v));
    }

    /**
     * Gt 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L gt0(AtomicInteger index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return gt0(index, property, property.getAsDouble(), v -> ignoreStrategy.test((Double) v));
    }

    /**
     * Gt 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L gt0(AtomicInteger index, SerializableIntSupplier property, Predicate<?> ignoreStrategy) {
        return gt0(index, property, property.getAsInt(), ignoreStrategy);
    }

    /**
     * Gt 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L gt0(AtomicInteger index, SerializableLongSupplier property, Predicate<?> ignoreStrategy) {
        return gt0(index, property, property.getAsLong(), ignoreStrategy);
    }

    /**
     * Gt 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L gt0(AtomicInteger index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy) {
        return gt0(index, property, property.getAsDouble(), ignoreStrategy);
    }

    /**
     * Gt 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L gt0(AtomicInteger index, SerializableSupplier<V> property, Predicate<?> ignoreStrategy) {
        return gt0(index, property, property.get(), ignoreStrategy);
    }

    /**
     * Gt 0.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L gt0(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return gt0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * Gt 0.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L gt0(AtomicInteger index, SerializableToIntFunction<?> name, int value, IntPredicate ignoreStrategy) {
        return gt0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /**
     * Gt 0.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L gt0(AtomicInteger index, SerializableToLongFunction<?> name, long value, LongPredicate ignoreStrategy) {
        return gt0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /**
     * Gt 0.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L gt0(AtomicInteger index, SerializableToDoubleFunction<?> name, double value,
            DoublePredicate ignoreStrategy) {
        return gt0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /**
     * Gt 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L gt0(AtomicInteger index, Serializable name, V value, Predicate<?> ignoreStrategy) {
        return gt0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /**
     * Gt 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L gt0(AtomicInteger index, Serializable name, V value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return gt0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, matchStrategy,
                ignoreStrategy);
    }

    /**
     * Gt 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L gt0(AtomicInteger index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy) {
        return gt0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * Gt 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L gt0(AtomicInteger index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy) {
        return gt0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /**
     * Gt 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L gt0(AtomicInteger index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy) {
        return gt0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /**
     * Gt 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    @SuppressWarnings("unchecked")
    protected <V> L gt0(AtomicInteger index, PropertyMapping<?> pm, V value, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.GT, getAlias(index), ignoreStrategy));
    }

    /**
     * Gt 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    @SuppressWarnings("unchecked")
    protected <V> L gt0(AtomicInteger index, PropertyMapping<?> pm, V value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.GT, matchStrategy, getAlias(index),
                ignoreStrategy));
    }

    // ********************************************************************

    /**
     * Le 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L le0(AtomicInteger index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return le0(index, property, property.getAsInt(), v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * Le 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L le0(AtomicInteger index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return le0(index, property, property.getAsLong(), v -> ignoreStrategy.test((Long) v));
    }

    /**
     * Le 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L le0(AtomicInteger index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return le0(index, property, property.getAsDouble(), v -> ignoreStrategy.test((Double) v));
    }

    /**
     * Le 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L le0(AtomicInteger index, SerializableIntSupplier property, Predicate<?> ignoreStrategy) {
        return le0(index, property, property.getAsInt(), ignoreStrategy);
    }

    /**
     * Le 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L le0(AtomicInteger index, SerializableLongSupplier property, Predicate<?> ignoreStrategy) {
        return le0(index, property, property.getAsLong(), ignoreStrategy);
    }

    /**
     * Le 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L le0(AtomicInteger index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy) {
        return le0(index, property, property.getAsDouble(), ignoreStrategy);
    }

    /**
     * Le 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L le0(AtomicInteger index, SerializableSupplier<V> property, Predicate<?> ignoreStrategy) {
        return le0(index, property, property.get(), ignoreStrategy);
    }

    /**
     * Le 0.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L le0(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return le0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * Le 0.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L le0(AtomicInteger index, SerializableToIntFunction<?> name, int value, IntPredicate ignoreStrategy) {
        return le0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /**
     * Le 0.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L le0(AtomicInteger index, SerializableToLongFunction<?> name, long value, LongPredicate ignoreStrategy) {
        return le0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /**
     * Le 0.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L le0(AtomicInteger index, SerializableToDoubleFunction<?> name, double value,
            DoublePredicate ignoreStrategy) {
        return le0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /**
     * Le 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L le0(AtomicInteger index, Serializable name, V value, Predicate<?> ignoreStrategy) {
        return le0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /**
     * Le 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L le0(AtomicInteger index, Serializable name, V value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return le0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, matchStrategy,
                ignoreStrategy);
    }

    /**
     * Le 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L le0(AtomicInteger index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy) {
        return le0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * Le 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L le0(AtomicInteger index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy) {
        return le0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /**
     * Le 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L le0(AtomicInteger index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy) {
        return le0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /**
     * Le 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    @SuppressWarnings("unchecked")
    protected <V> L le0(AtomicInteger index, PropertyMapping<?> pm, V value, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.LE, getAlias(index), ignoreStrategy));
    }

    /**
     * Le 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    @SuppressWarnings("unchecked")
    protected <V> L le0(AtomicInteger index, PropertyMapping<?> pm, V value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.LE, matchStrategy, getAlias(index),
                ignoreStrategy));
    }

    // ****************************************************************************************************************

    /**
     * Lt 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L lt0(AtomicInteger index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return lt0(index, property, property.getAsInt(), v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * Lt 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L lt0(AtomicInteger index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return lt0(index, property, property.getAsLong(), v -> ignoreStrategy.test((Long) v));
    }

    /**
     * Lt 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L lt0(AtomicInteger index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return lt0(index, property, property.getAsDouble(), v -> ignoreStrategy.test((Double) v));
    }

    /**
     * Lt 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L lt0(AtomicInteger index, SerializableIntSupplier property, Predicate<?> ignoreStrategy) {
        return lt0(index, property, property.getAsInt(), ignoreStrategy);
    }

    /**
     * Lt 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L lt0(AtomicInteger index, SerializableLongSupplier property, Predicate<?> ignoreStrategy) {
        return lt0(index, property, property.getAsLong(), ignoreStrategy);
    }

    /**
     * Lt 0.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L lt0(AtomicInteger index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy) {
        return lt0(index, property, property.getAsDouble(), ignoreStrategy);
    }

    /**
     * Lt 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L lt0(AtomicInteger index, SerializableSupplier<V> property, Predicate<?> ignoreStrategy) {
        return lt0(index, property, property.get(), ignoreStrategy);
    }

    /**
     * Lt 0.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L lt0(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return lt0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * Lt 0.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L lt0(AtomicInteger index, SerializableToIntFunction<?> name, int value, IntPredicate ignoreStrategy) {
        return lt0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /**
     * Lt 0.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L lt0(AtomicInteger index, SerializableToLongFunction<?> name, long value, LongPredicate ignoreStrategy) {
        return lt0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /**
     * Lt 0.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L lt0(AtomicInteger index, SerializableToDoubleFunction<?> name, double value,
            DoublePredicate ignoreStrategy) {
        return lt0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /**
     * Lt 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L lt0(AtomicInteger index, Serializable name, V value, Predicate<?> ignoreStrategy) {
        return lt0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    /**
     * Lt 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected <V> L lt0(AtomicInteger index, Serializable name, V value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return lt0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, matchStrategy,
                ignoreStrategy);
    }

    /**
     * Lt 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L lt0(AtomicInteger index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy) {
        return lt0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    /**
     * Lt 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L lt0(AtomicInteger index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy) {
        return lt0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    /**
     * Lt 0.
     *
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    protected L lt0(AtomicInteger index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy) {
        return lt0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    /**
     * Lt 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    @SuppressWarnings("unchecked")
    protected <V> L lt0(AtomicInteger index, PropertyMapping<?> pm, V value, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.LT, getAlias(index), ignoreStrategy));
    }

    /**
     * Lt 0.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param pm             the pm
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    @SuppressWarnings("unchecked")
    protected <V> L lt0(AtomicInteger index, PropertyMapping<?> pm, V value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.LT, matchStrategy, getAlias(index),
                ignoreStrategy));
    }

    /**
     * Gets the class mapping.
     *
     * @param <CM>  the generic type
     * @param <T>   the generic type
     * @param <P>   the generic type
     * @param index the index
     * @return the class mapping
     */
    protected <CM extends ClassMapping<T, P>, T, P extends PropertyMapping<P>> CM getClassMapping(AtomicInteger index) {
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

    // ****************************************************************************************************************
    //	property
    // ****************************************************************************************************************

    /**
     * get getDialect() value.
     *
     * @return getDialect()
     */
    public abstract Dialect getDialect();
}
