
/*
 * All rights Reserved, Designed By zhongj
 * @Title: MulitiEntityContainsExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.condition.co
 * @Description: MulitiEntityContainsExpressionImpl
 * @author: zhongj
 * @date: 2023-07-28 16:58:28
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.lang.function.SerializableDoubleSupplier;
import cn.featherfly.common.lang.function.SerializableIntSupplier;
import cn.featherfly.common.lang.function.SerializableLongSupplier;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.operator.QueryOperator;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
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

    protected <R> L eq0(int index, SerializableSupplier<R> property, QueryPolicy queryPolicy,
            Predicate<?> ignoreStrategy) {
        return eq0(index, property, property.get(), queryPolicy, ignoreStrategy);
    }

    protected <T, R> L eq0(int index, Serializable property, R value, QueryPolicy queryPolicy,
            Predicate<?> ignoreStrategy) {
        return eq_ne(index, QueryOperator.EQ, getClassMapping(index).getPropertyMapping(getPropertyName(property)),
                value, queryPolicy, ignoreStrategy);
    }

    protected <R> L ne0(int index, SerializableSupplier<R> property, QueryPolicy queryPolicy,
            Predicate<?> ignoreStrategy) {
        return ne0(index, property, property.get(), queryPolicy, ignoreStrategy);
    }

    protected <T, R> L ne0(int index, Serializable property, R value, QueryPolicy queryPolicy,
            Predicate<?> ignoreStrategy) {
        return eq_ne(index, QueryOperator.NE, getClassMapping(index).getPropertyMapping(getPropertyName(property)),
                value, queryPolicy, ignoreStrategy);
    }

    protected abstract <T, R> L eq_ne(int index, QueryOperator queryOperator, PropertyMapping<?> pm, R value,
            QueryPolicy queryPolicy, Predicate<?> ignoreStrategy);

    //    protected <T, R> L eq_ne(QueryOperator queryOperator, PropertyMapping<?> pm, R value,
    //            QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
    //        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
    //                getFieldValueOperator(pm, value), queryOperator, queryPolicy,  ignoreStrategy));
    //    }

    // ****************************************************************************************************************

    protected L sw0(int index, SerializableSupplier<String> property, QueryPolicy queryPolicy,
            Predicate<?> ignoreStrategy) {
        return sw0(index, property, property.get(), queryPolicy, ignoreStrategy);
    }

    protected <T, R> L sw0(int index, Serializable property, String value, QueryPolicy queryPolicy,
            Predicate<?> ignoreStrategy) {
        return sw0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, queryPolicy,
                ignoreStrategy);
    }

    @SuppressWarnings("unchecked")
    protected <T> L sw0(int index, PropertyMapping<?> pm, String value, QueryPolicy queryPolicy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), QueryOperator.SW, queryPolicy, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L co0(int index, SerializableSupplier<String> property, QueryPolicy queryPolicy,
            Predicate<?> ignoreStrategy) {
        return co0(index, property, property.get(), queryPolicy, ignoreStrategy);
    }

    protected <T, R> L co0(int index, Serializable property, String value, QueryPolicy queryPolicy,
            Predicate<?> ignoreStrategy) {
        return co0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, queryPolicy,
                ignoreStrategy);
    }

    @SuppressWarnings("unchecked")
    protected <T> L co0(int index, PropertyMapping<?> pm, String value, QueryPolicy queryPolicy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), QueryOperator.CO, queryPolicy, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L ew0(int index, SerializableSupplier<String> property, QueryPolicy queryPolicy,
            Predicate<?> ignoreStrategy) {
        return ew0(index, property, property.get(), queryPolicy, ignoreStrategy);
    }

    protected <T, R> L ew0(int index, Serializable property, String value, QueryPolicy queryPolicy,
            Predicate<?> ignoreStrategy) {
        return ew0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, queryPolicy,
                ignoreStrategy);
    }

    @SuppressWarnings("unchecked")
    protected <T> L ew0(int index, PropertyMapping<?> pm, String value, QueryPolicy queryPolicy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), QueryOperator.EW, queryPolicy, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected L lk0(int index, SerializableSupplier<String> property, QueryPolicy queryPolicy,
            Predicate<?> ignoreStrategy) {
        return lk0(index, property, property.get(), queryPolicy, ignoreStrategy);
    }

    protected <T, R> L lk0(int index, Serializable property, String value, QueryPolicy queryPolicy,
            Predicate<?> ignoreStrategy) {
        return lk0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, queryPolicy,
                ignoreStrategy);
    }

    @SuppressWarnings("unchecked")
    protected <T> L lk0(int index, PropertyMapping<?> pm, String value, QueryPolicy queryPolicy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), QueryOperator.LK, queryPolicy, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected <T> L in0(int index, SerializableIntSupplier property, Predicate<?> ignoreStrategy) {
        return in0(index, property, property.getAsInt(), ignoreStrategy);
    }

    protected <T> L in0(int index, SerializableLongSupplier property, Predicate<?> ignoreStrategy) {
        return in0(index, property, property.getAsLong(), ignoreStrategy);
    }

    protected <T> L in0(int index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy) {
        return in0(index, property, property.getAsDouble(), ignoreStrategy);
    }

    protected <R> L in0(int index, SerializableSupplier<R> property, Predicate<?> ignoreStrategy) {
        return in0(index, property, property.get(), ignoreStrategy);
    }

    protected <T, R> L in0(int index, Serializable property, R value, Predicate<?> ignoreStrategy) {
        return in0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, ignoreStrategy);
    }

    @SuppressWarnings("unchecked")
    protected <T, R> L in0(int index, PropertyMapping<?> pm, R value, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getInParam(pm, value), QueryOperator.IN, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

    protected <T> L nin0(int index, SerializableIntSupplier property, Predicate<?> ignoreStrategy) {
        return nin0(index, property, property.getAsInt(), ignoreStrategy);
    }

    protected <T> L nin0(int index, SerializableLongSupplier property, Predicate<?> ignoreStrategy) {
        return nin0(index, property, property.getAsLong(), ignoreStrategy);
    }

    protected <T> L nin0(int index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy) {
        return nin0(index, property, property.getAsDouble(), ignoreStrategy);
    }

    protected <R> L nin0(int index, SerializableSupplier<R> property, Predicate<?> ignoreStrategy) {
        return nin0(index, property, property.get(), ignoreStrategy);
    }

    protected <T, R> L nin0(int index, Serializable property, R value, Predicate<?> ignoreStrategy) {
        return nin0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value, ignoreStrategy);
    }

    @SuppressWarnings("unchecked")
    protected <R> L nin0(int index, PropertyMapping<?> pm, R value, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getInParam(pm, value), QueryOperator.NIN, getAlias(index), ignoreStrategy));
    }

    protected <T, R> L isn0(int index, Serializable property, Boolean value) {
        return isn0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value);
    }

    @SuppressWarnings("unchecked")
    protected L isn0(int index, PropertyMapping<?> pm, Boolean value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(), value,
                QueryOperator.ISN, getAlias(index), null));
    }

    protected <T, R> L inn0(int index, Serializable property, Boolean value) {
        return inn0(index, getClassMapping(index).getPropertyMapping(getPropertyName(property)), value);
    }

    @SuppressWarnings("unchecked")
    protected L inn0(int index, PropertyMapping<?> pm, Boolean value) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(), value,
                QueryOperator.INN, getAlias(index), null));
    }

    // ********************************************************************

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

    protected <T, V> L ge0(int index, Serializable name, V value, Predicate<?> ignoreStrategy) {
        return ge0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    @SuppressWarnings("unchecked")
    protected <V> L ge0(int index, PropertyMapping<?> pm, V value, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), QueryOperator.GE, getAlias(index), ignoreStrategy));
    }

    // ********************************************************************

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

    protected <T, V> L gt0(int index, Serializable name, V value, Predicate<?> ignoreStrategy) {
        return gt0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    @SuppressWarnings("unchecked")
    protected <V> L gt0(int index, PropertyMapping<?> pm, V value, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), QueryOperator.GT, getAlias(index), ignoreStrategy));
    }

    // ********************************************************************

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

    protected <T, V> L le0(int index, Serializable name, V value, Predicate<?> ignoreStrategy) {
        return le0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    @SuppressWarnings("unchecked")
    protected <V> L le0(int index, PropertyMapping<?> pm, V value, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), QueryOperator.LE, getAlias(index), ignoreStrategy));
    }

    // ****************************************************************************************************************

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

    protected <T, V> L lt0(int index, Serializable name, V value, Predicate<?> ignoreStrategy) {
        return lt0(index, getClassMapping(index).getPropertyMapping(getPropertyName(name)), value, ignoreStrategy);
    }

    @SuppressWarnings("unchecked")
    protected <V> L lt0(int index, PropertyMapping<?> pm, V value, Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(getDialect(), pm.getRepositoryFieldName(),
                getFieldValueOperator(pm, value), QueryOperator.LT, getAlias(index), ignoreStrategy));
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
