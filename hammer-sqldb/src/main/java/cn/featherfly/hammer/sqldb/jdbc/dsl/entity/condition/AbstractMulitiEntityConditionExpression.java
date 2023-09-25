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
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.function.serializable.SerializableDoubleSupplier;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.operator.ComparisonOperator;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
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

    @SuppressWarnings("unchecked")
    @Override
    protected Object getInParam(PropertyMapping<?> pm, Object value) {
        Object param = null;
        if (value != null) {
            if (value.getClass().isArray()) {
                int length = Array.getLength(value);
                param = Array.newInstance(FieldValueOperator.class, length);
                for (int i = 0; i < length; i++) {
                    //                    Array.set(param, i, new FieldValueOperator(pm.getJavaTypeSqlTypeOperator(), Array.get(value, i)));
                    Array.set(param, i, FieldValueOperator.create((JdbcPropertyMapping) pm, Array.get(value, i)));
                }
            } else if (value instanceof Collection) {
                param = new ArrayList<>();
                for (Object op : (Collection<?>) value) {
                    ((Collection<FieldValueOperator<?>>) param)
                            .add(FieldValueOperator.create((JdbcPropertyMapping) pm, op));
                    //                    .add(new FieldValueOperator(pm.getJavaTypeSqlTypeOperator(), op));
                }
            } else if (!(value instanceof FieldValueOperator)) {
                param = FieldValueOperator.create((JdbcPropertyMapping) pm, value);
            } else {
                param = value;
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
        return value == null ? null : FieldValueOperator.create((JdbcPropertyMapping) pm, value);
    }

    // ********************************************************************

    protected <V> L ba0(int index, Serializable name, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return ba0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), min, max,
                p -> ignoreStrategy.test(min, max));
        //        return ba0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), min, max, p -> {
        //            Object[] ps = (Object[]) p;
        //            return ignoreStrategy.test((V) ps[0], (V) ps[1]);
        //        });
    }

    protected <V> L ba0(int index, Serializable name, V min, V max, Predicate<?> ignoreStrategy) {
        return ba0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), min, max, ignoreStrategy);
    }

    protected <V> L ba0(int index, PropertyMapping<?> pm, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return ba0(index, pm, min, max, p -> ignoreStrategy.test(min, max));
    }

    @SuppressWarnings("unchecked")
    protected <V> L ba0(int index, PropertyMapping<?> pm, V min, V max, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                new FieldValueOperator[] { getFieldValueOperator(pm, min), getFieldValueOperator(pm, max) },
                ComparisonOperator.BA, getAlias(index), ignoreStrategy));
        //        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
        //                getFieldValueOperator(pm, new Object[] { min, max }), ComparisonOperator.BA, getAlias(index),
        //                ignoreStrategy));
    }

    // ********************************************************************

    protected <V> L nba0(int index, Serializable name, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return nba0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), min, max,
                p -> ignoreStrategy.test(min, max));
        //        return nba0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), min, max, p -> {
        //            Object[] ps = (Object[]) p;
        //            return ignoreStrategy.test((V) ps[0], (V) ps[1]);
        //        });
    }

    protected <V> L nba0(int index, Serializable name, V min, V max, Predicate<?> ignoreStrategy) {
        return nba0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), min, max, ignoreStrategy);
    }

    protected <V> L nba0(int index, PropertyMapping<?> pm, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        return nba0(index, pm, min, max, p -> ignoreStrategy.test(min, max));
    }

    @SuppressWarnings("unchecked")
    protected <V> L nba0(int index, PropertyMapping<?> pm, V min, V max, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                new FieldValueOperator[] { getFieldValueOperator(pm, min), getFieldValueOperator(pm, max) },
                ComparisonOperator.NBA, getAlias(index), ignoreStrategy));
    }

    // ********************************************************************

    protected <R> L eq0(int index, SerializableSupplier<R> property, Predicate<?> ignoreStrategy) {
        return eq0(index, property, property.get(), MatchStrategy.AUTO, ignoreStrategy);
    }

    protected <R> L eq0(int index, SerializableSupplier<R> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return eq0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    protected <R> L eq0(int index, Serializable property, R value, Predicate<?> ignoreStrategy) {
        return eq0(index, property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    protected <R> L eq0(int index, Serializable property, R value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return eq0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
                ignoreStrategy);
    }

    protected <R> L eq0(int index, PropertyMapping<?> pm, R value, Predicate<?> ignoreStrategy) {
        return eq0(index, pm, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    protected <R> L eq0(int index, PropertyMapping<?> pm, R value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return eq_ne(index, ComparisonOperator.EQ, pm, value, matchStrategy, ignoreStrategy);
    }

    protected <R> L ne0(int index, SerializableSupplier<R> property, Predicate<?> ignoreStrategy) {
        return ne0(index, property, property.get(), MatchStrategy.AUTO, ignoreStrategy);
    }

    protected <R> L ne0(int index, SerializableSupplier<R> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return ne0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    protected <R> L ne0(int index, Serializable property, R value, Predicate<?> ignoreStrategy) {
        return ne0(index, property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    protected <R> L ne0(int index, Serializable property, R value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return ne0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
                ignoreStrategy);
    }

    protected <R> L ne0(int index, PropertyMapping<?> pm, R value, Predicate<?> ignoreStrategy) {
        return ne0(index, pm, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    protected <R> L ne0(int index, PropertyMapping<?> pm, R value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return eq_ne(index, ComparisonOperator.NE, pm, value, matchStrategy, ignoreStrategy);
    }

    protected abstract <R> L eq_ne(int index, ComparisonOperator comparisonOperator, PropertyMapping<?> pm, R value,
            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    //    protected <R> L eq_ne(ComparisonOperator comparisonOperator, PropertyMapping<?> pm, R value,
    //            MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
    //                getFieldValueOperator(pm, value), comparisonOperator, matchStrategy,  ignoreStrategy));
    //    }

    // ****************************************************************************************************************

    protected L sw0(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return sw0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    protected <R> L sw0(int index, Serializable property, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return sw0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
                ignoreStrategy);
    }

    @SuppressWarnings("unchecked")
    protected L sw0(int index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.SW, matchStrategy, getAlias(index),
                ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L nsw0(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return nsw0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    protected <R> L nsw0(int index, Serializable property, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return nsw0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
                ignoreStrategy);
    }

    @SuppressWarnings("unchecked")
    protected L nsw0(int index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.NSW, matchStrategy, getAlias(index),
                ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L co0(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return co0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    protected <R> L co0(int index, Serializable property, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return co0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
                ignoreStrategy);
    }

    @SuppressWarnings("unchecked")
    protected L co0(int index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.CO, matchStrategy, getAlias(index),
                ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L nco0(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return nco0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    protected <R> L nco0(int index, Serializable property, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return nco0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
                ignoreStrategy);
    }

    @SuppressWarnings("unchecked")
    protected L nco0(int index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.NCO, matchStrategy, getAlias(index),
                ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L ew0(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return ew0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    protected <R> L ew0(int index, Serializable property, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return ew0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
                ignoreStrategy);
    }

    @SuppressWarnings("unchecked")
    protected L ew0(int index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.EW, matchStrategy, getAlias(index),
                ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L new0(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return new0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    protected <R> L new0(int index, Serializable property, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return new0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
                ignoreStrategy);
    }

    @SuppressWarnings("unchecked")
    protected L new0(int index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.NEW, matchStrategy, getAlias(index),
                ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L lk0(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return lk0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    protected <R> L lk0(int index, Serializable property, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return lk0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
                ignoreStrategy);
    }

    @SuppressWarnings("unchecked")
    protected L lk0(int index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.LK, matchStrategy, getAlias(index),
                ignoreStrategy));
    }
    // ****************************************************************************************************************

    protected L nl0(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return nl0(index, property, property.get(), matchStrategy, ignoreStrategy);
    }

    protected <R> L nl0(int index, Serializable property, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return nl0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, matchStrategy,
                ignoreStrategy);
    }

    @SuppressWarnings("unchecked")
    protected L nl0(int index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.NL, matchStrategy, getAlias(index),
                ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L in0(int index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return in0(index, property, property.getAsInt(), v -> ignoreStrategy.test((Integer) v));
    }

    protected L in0(int index, SerializableIntSupplier property, Predicate<?> ignoreStrategy) {
        return in0(index, property, property.getAsInt(), ignoreStrategy);
    }

    protected L in0(int index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return in0(index, property, property.getAsLong(), v -> ignoreStrategy.test((Integer) v));
    }

    protected L in0(int index, SerializableLongSupplier property, Predicate<?> ignoreStrategy) {
        return in0(index, property, property.getAsLong(), ignoreStrategy);
    }

    protected L in0(int index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return in0(index, property, property.getAsDouble(), v -> ignoreStrategy.test((Double) v));
    }

    protected L in0(int index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy) {
        return in0(index, property, property.getAsDouble(), ignoreStrategy);
    }

    protected <R> L in0(int index, SerializableSupplier<R> property, Predicate<?> ignoreStrategy) {
        return in0(index, property, property.get(), ignoreStrategy);
    }

    protected <T> L in0(int index, SerializableToIntFunction<T> property, int value, IntPredicate ignoreStrategy) {
        return in0(index, (Serializable) property, value, v -> ignoreStrategy.test((Integer) v));
    }

    protected <T> L in0(int index, SerializableToLongFunction<T> property, long value, LongPredicate ignoreStrategy) {
        return in0(index, (Serializable) property, value, v -> ignoreStrategy.test((Integer) v));
    }

    protected <T> L in0(int index, SerializableToDoubleFunction<T> property, double value,
            DoublePredicate ignoreStrategy) {
        return in0(index, (Serializable) property, value, v -> ignoreStrategy.test((Double) v));
    }

    protected <R> L in0(int index, Serializable property, R value, Predicate<?> ignoreStrategy) {
        return in0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, ignoreStrategy);
    }

    protected <R> L in0(int index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy) {
        return in0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    protected <R> L in0(int index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy) {
        return in0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    protected <R> L in0(int index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy) {
        return in0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    @SuppressWarnings("unchecked")
    protected <R> L in0(int index, PropertyMapping<?> pm, R value, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getInParam(pm, value), ComparisonOperator.IN, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L ni0(int index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return ni0(index, property, property.getAsInt(), v -> ignoreStrategy.test((Integer) v));
    }

    protected L ni0(int index, SerializableIntSupplier property, Predicate<?> ignoreStrategy) {
        return ni0(index, property, property.getAsInt(), ignoreStrategy);
    }

    protected L ni0(int index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return ni0(index, property, property.getAsLong(), v -> ignoreStrategy.test((Long) v));
    }

    protected L ni0(int index, SerializableLongSupplier property, Predicate<?> ignoreStrategy) {
        return ni0(index, property, property.getAsLong(), ignoreStrategy);
    }

    protected L ni0(int index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return ni0(index, property, property.getAsDouble(), v -> ignoreStrategy.test((Double) v));
    }

    protected L ni0(int index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy) {
        return ni0(index, property, property.getAsDouble(), ignoreStrategy);
    }

    protected <R> L ni0(int index, SerializableSupplier<R> property, Predicate<?> ignoreStrategy) {
        return ni0(index, property, property.get(), ignoreStrategy);
    }

    protected <T> L ni0(int index, SerializableToIntFunction<T> property, int value, IntPredicate ignoreStrategy) {
        return ni0(index, (Serializable) property, value, v -> ignoreStrategy.test((Integer) v));
    }

    protected <T> L ni0(int index, SerializableToLongFunction<T> property, long value, LongPredicate ignoreStrategy) {
        return ni0(index, (Serializable) property, value, v -> ignoreStrategy.test((Long) v));
    }

    protected <T> L ni0(int index, SerializableToDoubleFunction<T> property, double value,
            DoublePredicate ignoreStrategy) {
        return ni0(index, (Serializable) property, value, v -> ignoreStrategy.test((Double) v));
    }

    protected <R> L ni0(int index, Serializable property, R value, Predicate<?> ignoreStrategy) {
        return ni0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, ignoreStrategy);
    }

    protected <R> L ni0(int index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy) {
        return ni0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    protected <R> L ni0(int index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy) {
        return ni0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    protected <R> L ni0(int index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy) {
        return ni0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    @SuppressWarnings("unchecked")
    protected <R> L ni0(int index, PropertyMapping<?> pm, R value, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getInParam(pm, value), ComparisonOperator.NI, getAlias(index), ignoreStrategy));
    }

    protected <R> L isn0(int index, Serializable property, Boolean value) {
        return isn0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value);
    }

    @SuppressWarnings("unchecked")
    protected L isn0(int index, PropertyMapping<?> pm, Boolean value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(), value,
                ComparisonOperator.ISN, getAlias(index), ignoreStrategy));
    }

    protected <R> L inn0(int index, Serializable property, Boolean value) {
        return inn0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value);
    }

    @SuppressWarnings("unchecked")
    protected L inn0(int index, PropertyMapping<?> pm, Boolean value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(), value,
                ComparisonOperator.INN, getAlias(index), ignoreStrategy));
    }

    // ********************************************************************

    protected L ge0(int index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return ge0(index, property, property.getAsInt(), v -> ignoreStrategy.test((Integer) v));
    }

    protected L ge0(int index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return ge0(index, property, property.getAsLong(), v -> ignoreStrategy.test((Long) v));
    }

    protected L ge0(int index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return ge0(index, property, property.getAsDouble(), v -> ignoreStrategy.test((Double) v));
    }

    protected L ge0(int index, SerializableIntSupplier property, Predicate<?> ignoreStrategy) {
        return ge0(index, property, property.getAsInt(), ignoreStrategy);
    }

    protected L ge0(int index, SerializableLongSupplier property, Predicate<?> ignoreStrategy) {
        return ge0(index, property, property.getAsLong(), ignoreStrategy);
    }

    protected L ge0(int index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy) {
        return ge0(index, property, property.getAsDouble(), ignoreStrategy);
    }

    protected <V> L ge0(int index, SerializableSupplier<V> property, Predicate<?> ignoreStrategy) {
        return ge0(index, property, property.get(), ignoreStrategy);
    }

    protected L ge0(int index, SerializableToIntFunction<?> name, int value, IntPredicate ignoreStrategy) {
        return ge0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    protected L ge0(int index, SerializableToLongFunction<?> name, long value, LongPredicate ignoreStrategy) {
        return ge0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    protected L ge0(int index, SerializableToDoubleFunction<?> name, double value, DoublePredicate ignoreStrategy) {
        return ge0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    protected <V> L ge0(int index, Serializable name, V value, Predicate<?> ignoreStrategy) {
        return ge0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    protected L ge0(int index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy) {
        return ge0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    protected L ge0(int index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy) {
        return ge0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    protected L ge0(int index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy) {
        return ge0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    @SuppressWarnings("unchecked")
    protected <V> L ge0(int index, PropertyMapping<?> pm, V value, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.GE, getAlias(index), ignoreStrategy));
    }

    // ********************************************************************

    protected L gt0(int index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return gt0(index, property, property.getAsInt(), v -> ignoreStrategy.test((Integer) v));
    }

    protected L gt0(int index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return gt0(index, property, property.getAsLong(), v -> ignoreStrategy.test((Long) v));
    }

    protected L gt0(int index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return gt0(index, property, property.getAsDouble(), v -> ignoreStrategy.test((Double) v));
    }

    protected L gt0(int index, SerializableIntSupplier property, Predicate<?> ignoreStrategy) {
        return gt0(index, property, property.getAsInt(), ignoreStrategy);
    }

    protected L gt0(int index, SerializableLongSupplier property, Predicate<?> ignoreStrategy) {
        return gt0(index, property, property.getAsLong(), ignoreStrategy);
    }

    protected L gt0(int index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy) {
        return gt0(index, property, property.getAsDouble(), ignoreStrategy);
    }

    protected <V> L gt0(int index, SerializableSupplier<V> property, Predicate<?> ignoreStrategy) {
        return gt0(index, property, property.get(), ignoreStrategy);
    }

    protected L gt0(int index, SerializableToIntFunction<?> name, int value, IntPredicate ignoreStrategy) {
        return gt0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    protected L gt0(int index, SerializableToLongFunction<?> name, long value, LongPredicate ignoreStrategy) {
        return gt0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    protected L gt0(int index, SerializableToDoubleFunction<?> name, double value, DoublePredicate ignoreStrategy) {
        return gt0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    protected <V> L gt0(int index, Serializable name, V value, Predicate<?> ignoreStrategy) {
        return gt0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    protected L gt0(int index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy) {
        return gt0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    protected L gt0(int index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy) {
        return gt0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    protected L gt0(int index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy) {
        return gt0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    @SuppressWarnings("unchecked")
    protected <V> L gt0(int index, PropertyMapping<?> pm, V value, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.GT, getAlias(index), ignoreStrategy));
    }

    // ********************************************************************

    protected L le0(int index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return le0(index, property, property.getAsInt(), v -> ignoreStrategy.test((Integer) v));
    }

    protected L le0(int index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return le0(index, property, property.getAsLong(), v -> ignoreStrategy.test((Long) v));
    }

    protected L le0(int index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return le0(index, property, property.getAsDouble(), v -> ignoreStrategy.test((Double) v));
    }

    protected L le0(int index, SerializableIntSupplier property, Predicate<?> ignoreStrategy) {
        return le0(index, property, property.getAsInt(), ignoreStrategy);
    }

    protected L le0(int index, SerializableLongSupplier property, Predicate<?> ignoreStrategy) {
        return le0(index, property, property.getAsLong(), ignoreStrategy);
    }

    protected L le0(int index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy) {
        return le0(index, property, property.getAsDouble(), ignoreStrategy);
    }

    protected <V> L le0(int index, SerializableSupplier<V> property, Predicate<?> ignoreStrategy) {
        return le0(index, property, property.get(), ignoreStrategy);
    }

    protected L le0(int index, SerializableToIntFunction<?> name, int value, IntPredicate ignoreStrategy) {
        return le0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    protected L le0(int index, SerializableToLongFunction<?> name, long value, LongPredicate ignoreStrategy) {
        return le0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    protected L le0(int index, SerializableToDoubleFunction<?> name, double value, DoublePredicate ignoreStrategy) {
        return le0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    protected <V> L le0(int index, Serializable name, V value, Predicate<?> ignoreStrategy) {
        return le0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    protected L le0(int index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy) {
        return le0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    protected L le0(int index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy) {
        return le0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    protected L le0(int index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy) {
        return le0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    @SuppressWarnings("unchecked")
    protected <V> L le0(int index, PropertyMapping<?> pm, V value, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.LE, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L lt0(int index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return lt0(index, property, property.getAsInt(), v -> ignoreStrategy.test((Integer) v));
    }

    protected L lt0(int index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return lt0(index, property, property.getAsLong(), v -> ignoreStrategy.test((Long) v));
    }

    protected L lt0(int index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return lt0(index, property, property.getAsDouble(), v -> ignoreStrategy.test((Double) v));
    }

    protected L lt0(int index, SerializableIntSupplier property, Predicate<?> ignoreStrategy) {
        return lt0(index, property, property.getAsInt(), ignoreStrategy);
    }

    protected L lt0(int index, SerializableLongSupplier property, Predicate<?> ignoreStrategy) {
        return lt0(index, property, property.getAsLong(), ignoreStrategy);
    }

    protected L lt0(int index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy) {
        return lt0(index, property, property.getAsDouble(), ignoreStrategy);
    }

    protected <V> L lt0(int index, SerializableSupplier<V> property, Predicate<?> ignoreStrategy) {
        return lt0(index, property, property.get(), ignoreStrategy);
    }

    protected L lt0(int index, SerializableToIntFunction<?> name, int value, IntPredicate ignoreStrategy) {
        return lt0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    protected L lt0(int index, SerializableToLongFunction<?> name, long value, LongPredicate ignoreStrategy) {
        return lt0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    protected L lt0(int index, SerializableToDoubleFunction<?> name, double value, DoublePredicate ignoreStrategy) {
        return lt0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    protected <V> L lt0(int index, Serializable name, V value, Predicate<?> ignoreStrategy) {
        return lt0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    protected L lt0(int index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy) {
        return lt0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Integer) v));
    }

    protected L lt0(int index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy) {
        return lt0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Long) v));
    }

    protected L lt0(int index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy) {
        return lt0(index, pm, value, (Predicate<?>) v -> ignoreStrategy.test((Double) v));
    }

    @SuppressWarnings("unchecked")
    protected <V> L lt0(int index, PropertyMapping<?> pm, V value, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), ComparisonOperator.LT, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************
    //	property
    // ****************************************************************************************************************

    /**
     * get getDialect() value
     *
     * @return getDialect()
     */
    public abstract Dialect getDialect();
}
