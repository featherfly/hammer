/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-15 15:20:15
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.condition;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.stream.Collectors;

import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.AbstractConditionExpression;
import cn.featherfly.hammer.expression.condition.Expression;

/**
 * abstract sqldb condition expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractSqldbConditionExpression extends AbstractConditionExpression {

    protected Dialect dialect;

    /**
     * Instantiates a new abstract sqldb muliti condition expression.
     *
     * @param conditionConfig the condition config
     * @param dialect         the dialect
     */
    protected AbstractSqldbConditionExpression(ConditionConfig<?> conditionConfig, Dialect dialect) {
        super(conditionConfig);
        this.dialect = dialect;
    }

    // ****************************************************************************************************************

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
     * {@inheritDoc}
     */
    @Override
    protected Object getInParam(Object value) {
        return getInParam(null, value);
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
        if (pm == null) {
            return getFieldValueOperator(value);
        }
        return FieldValueOperator.create((JdbcPropertyMapping) pm, value);
    }

    /**
     * Gets the field value operator.
     *
     * @param <R>   the generic type
     * @param pm    the pm
     * @param value the value
     * @return the field value operator
     */
    protected <R> FieldValueOperator<R> getFieldValueOperator(R value) {
        return FieldValueOperator.create(value);
    }

    // ****************************************************************************************************************
    //	property
    // ****************************************************************************************************************

    /**
     * Adds the condition.
     *
     * @param condition the condition
     * @return the object
     */
    public abstract Expression addCondition(Expression condition);

    /**
     * get getDialect() value.
     *
     * @return getDialect()
     */
    public Dialect getDialect() {
        return dialect;
    }
}
