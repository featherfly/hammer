/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-15 15:20:15
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.condition;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.builder.BuilderUtils;
import cn.featherfly.common.db.builder.model.SqlElement;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.exception.UnsupportedException;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.lang.Console;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializableSupplierLambdaInfo;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.Params;
import cn.featherfly.common.repository.builder.BuilderException;
import cn.featherfly.common.repository.builder.BuilderExceptionCode;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping.Mode;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.AbstractConditionExpression;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.Expression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.LogicOperatorExpression;
import cn.featherfly.hammer.expression.condition.MulitiExpression;
import cn.featherfly.hammer.expression.condition.ParamedExpression;
import cn.featherfly.hammer.sqldb.Constants;

/**
 * abstract sqldb condition expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractSqlConditionExpression<C extends ConditionExpression, L extends LogicExpression<C, L>,
    C2 extends ConditionConfig<C2>> extends AbstractConditionExpression<C2> implements ParamedExpression {
    // TODO 后续来处理和AbstractSqlConditionsExpression的关系
    /** The parent. */
    protected L parent;

    // The conditions.
    private List<Expression> conditions = new ArrayList<>();

    private Expression previousCondition;

    // --------------------------------------------------------------------------------------------------------------

    protected Dialect dialect;

    /**
     * Instantiates a new abstract sqldb muliti condition expression.
     *
     * @param parent          the parent
     * @param dialect         the dialect
     * @param conditionConfig the condition config
     */
    protected AbstractSqlConditionExpression(L parent, Dialect dialect, C2 conditionConfig) {
        super(conditionConfig);
        this.parent = parent;
        this.dialect = dialect;
        if (Constants.DEBUG) {
            Console.log("{} end at time {}", this.getClass().getName(), System.currentTimeMillis());
        }
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        //      String parentCondition = parent == null ? "" : ((Builder) parent).build();
        StringBuilder result = new StringBuilder();
        if (conditions.size() > 0) {
            Expression last = conditions.get(conditions.size() - 1);
            if (last instanceof LogicOperatorExpression) {
                throw new BuilderException(BuilderExceptionCode
                    .createNoConditionBehindCode(((LogicOperatorExpression) last).getLogicOperator().name()));
            }
        }

        List<String> availableConditions = new ArrayList<>();
        List<Expression> availableExpressions = new ArrayList<>();
        for (Expression expression : conditions) {
            String condition = expression.expression();
            if (Strings.isNotBlank(condition)) {
                availableConditions.add(condition);
                availableExpressions.add(expression);
            } else {
                if (availableExpressions.size() > 0) {
                    Expression pre = availableExpressions.get(availableExpressions.size() - 1);
                    if (pre instanceof LogicOperatorExpression) {
                        availableExpressions.remove(availableExpressions.size() - 1);
                        availableConditions.remove(availableConditions.size() - 1);
                    }
                }
            }
        }

        if (availableExpressions.size() > 0) {
            if (availableExpressions.get(0) instanceof LogicOperatorExpression) {
                availableExpressions.remove(0);
                availableConditions.remove(0);
            }
            if (availableExpressions.get(availableExpressions.size() - 1) instanceof LogicOperatorExpression) {
                availableExpressions.remove(availableExpressions.size() - 1);
                availableConditions.remove(availableConditions.size() - 1);
            }
        }

        for (String condition : availableConditions) {
            BuilderUtils.link(result, condition);
        }
        if (result.length() > 0 && parent != null) {
            return " ( " + result.toString() + " ) ";
        } else {
            return result.toString();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getParam() {
        return getParams();
    }

    /**
     * Gets the params.
     *
     * @return the params
     */
    public List<Object> getParams() {
        List<Object> params = new ArrayList<>();
        for (Expression condition : conditions) {
            if (!(condition instanceof ParamedExpression)) {
                continue;
            }

            Object param = ((ParamedExpression) condition).getParam();
            if (param == Params.NONE) { // ignore param
            } else if (param == null) {
                params.add(param);
            } else if (param instanceof Collection) {
                params.addAll((Collection<?>) param);
            } else if (param.getClass().isArray()) {
                int length = Array.getLength(param);
                for (int i = 0; i < length; i++) {
                    params.add(Array.get(param, i));
                }
            } else {
                params.add(param);
            }
        }
        return params;
    }

    public List<Expression> getExpressions() {
        return conditions;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return expression();
    }

    // ********************************************************************
    // protected method
    // ********************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public Expression addCondition(Expression condition) {
        if (previousCondition != null && previousCondition.getClass().isInstance(condition)) {
            throw new BuilderException(
                BuilderExceptionCode.createNextToSameConditionCode(condition.getClass().getName()));
        }
        if (condition instanceof MulitiExpression) {
            for (Expression expression : ((MulitiExpression) condition).getExpressions()) {
                addCondition(expression);
            }
        } else {
            previousCondition = condition;
            conditions.add(condition);
        }
        return this;
    }

    /**
     * Supplier.
     *
     * @param <R>          the generic type
     * @param info         the info
     * @param value        the value
     * @param classMapping the class mapping
     * @return LogicExpressionist
     */
    @SuppressWarnings("unchecked")
    protected <R> List<Tuple2<String, Optional<R>>> supplier(SerializedLambdaInfo info, R value,
        JdbcClassMapping<?> classMapping) {
        List<Tuple2<String, Optional<R>>> list = new ArrayList<>();
        if (value != null) {
            String propertyName = info.getPropertyName();
            if (classMapping != null) {
                JdbcPropertyMapping propertyMapping = classMapping.getPropertyMapping(propertyName);
                if (Lang.isNotEmpty(propertyMapping.getPropertyMappings())
                    && propertyMapping.getPropertyType() == value.getClass()) {
                    for (JdbcPropertyMapping pm : propertyMapping.getPropertyMappings()) {
                        Object obj = BeanUtils.getProperty(value, pm.getPropertyName());
                        // TODO 这里的返回值不是R类型
                        Optional<R> optional = Optional.empty();
                        if (obj != null) {
                            optional = (Optional<R>) Optional.of(obj);
                        }
                        list.add(Tuples.of(pm.getRepositoryFieldName(), optional));
                    }
                    return list;
                }
            }
            list.add(Tuples.of(propertyName, Optional.of(value)));
        }
        return list;
    }

    /**
     * Supplier.
     *
     * @param <R>          the generic type
     * @param info         the info
     * @param classMapping the class mapping
     * @return LogicExpressionist
     */
    protected <R> List<Tuple2<String, Optional<R>>> supplier(SerializableSupplierLambdaInfo<R> info,
        JdbcClassMapping<?> classMapping) {
        return supplier(info.getSerializedLambdaInfo(), info.get(), classMapping);
    }

    /**
     * Condition result.
     *
     * @param <O>            the generic type
     * @param <T>            the generic type
     * @param <R>            the generic type
     * @param property       the repository
     * @param nestedProperty the property
     * @param value          the value
     * @param classMapping   the class mapping
     * @param factory        the factory
     * @return the tuple 2
     */
    protected <O, T, R> Tuple2<String, String> conditionResult(SerializableFunction<O, T> property,
        SerializableFunction<T, R> nestedProperty, Object value, JdbcClassMapping<O> classMapping,
        JdbcMappingFactory factory) {
        SerializedLambdaInfo propertyRepo = LambdaUtils.getLambdaInfo(property);
        SerializedLambdaInfo propertyInfo = LambdaUtils.getLambdaInfo(nestedProperty);
        String pn = propertyInfo.getPropertyName();
        // IMPLSOON 参考set(SerializableFunction<T, R> property,SerializableFunction<R, O> nestedProperty, O value)的实现重构逻辑

        JdbcPropertyMapping pm = classMapping.getPropertyMapping(propertyRepo.getPropertyName());
        if (pm.getMode() == Mode.EMBEDDED) {
            JdbcPropertyMapping spm = pm.getPropertyMapping(pn);
            if (spm != null) {
                return Tuples.of(propertyRepo.getPropertyName(), spm.getRepositoryFieldName());
            }
        } else if (pm.getMode() == Mode.ONE_TO_MANY) {
            // FIXME 未实现
            throw new NotImplementedException();
        } else if (pm.getMode() == Mode.SINGLE) {
            // FIXME 未实现
            throw new NotImplementedException();
        } else if (pm.getMode() == Mode.MANY_TO_ONE) {
            JdbcPropertyMapping spm = pm.getPropertyMapping(pn);
            if (spm != null) {
                return Tuples.of(propertyRepo.getPropertyName(), spm.getRepositoryFieldName());
            } else {
                @SuppressWarnings("unchecked")
                JdbcClassMapping<T> cm = factory.getClassMapping((Class<T>) pm.getPropertyType());
                spm = cm.getPropertyMapping(pn);
                if (spm != null) {
                    return Tuples.of(propertyRepo.getPropertyName(), spm.getRepositoryFieldName());
                }
            }
        }
        throw new UnsupportedException();
        // IMPLSOON 下面的逻辑还未测试，应该是有问题的
        //        JdbcClassMapping<?> cm = factory.getClassMapping(propertyRepo.getPropertyType());
        //        String column = ClassMappingUtils.getColumnName(pn, cm);
        //        return Tuples.of(propertyRepo.getPropertyName(), column);
    }

    /**
     * Condition result.
     *
     * @param <O>          the generic type
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param repository   the repository
     * @param property     the property
     * @param classMapping the class mapping
     * @param factory      the factory
     * @return the tuple 3
     */
    protected <O, T, R> Tuple3<String, String, Object> conditionResult(SerializableSupplier<T> repository,
        SerializableFunction<T, R> property, JdbcClassMapping<O> classMapping, JdbcMappingFactory factory) {
        // IMPLSOON 这里未测试
        SerializableSupplierLambdaInfo<T> repositoryInfo = LambdaUtils.getSerializableSupplierLambdaInfo(repository);
        SerializedLambdaInfo propertyInfo = LambdaUtils.getLambdaInfo(property);
        String pn = propertyInfo.getPropertyName();
        T obj = repositoryInfo.getValue();

        JdbcPropertyMapping pm = classMapping
            .getPropertyMapping(repositoryInfo.getSerializedLambdaInfo().getPropertyName());
        if (pm.getMode() == Mode.EMBEDDED) {
            for (JdbcPropertyMapping spm : pm.getPropertyMappings()) {
                if (spm.getPropertyName().equals(pn)) {
                    return Tuples.of(repositoryInfo.getSerializedLambdaInfo().getPropertyName(),
                        spm.getRepositoryFieldName(), BeanUtils.getProperty(obj, pn));
                }
            }
        }
        // IMPLSOON 下面的逻辑还未测试，应该是有问题的
        JdbcClassMapping<?> cm = factory.getClassMapping(repositoryInfo.getSerializedLambdaInfo().getPropertyType());
        String column = ClassMappingUtils.getColumnName(pn, cm);
        return Tuples.of(repositoryInfo.getSerializedLambdaInfo().getPropertyName(), column,
            BeanUtils.getProperty(obj, pn));
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

    protected Object prepareFieldValue(Object value) {
        if (value instanceof Field || value instanceof SqlElement) {
            return value;
        } else {
            return getFieldValueOperator(value);
        }
    }

    // ****************************************************************************************************************
    //	property
    // ****************************************************************************************************************

    /**
     * get getDialect() value.
     *
     * @return getDialect()
     */
    public Dialect getDialect() {
        return dialect;
    }
}
