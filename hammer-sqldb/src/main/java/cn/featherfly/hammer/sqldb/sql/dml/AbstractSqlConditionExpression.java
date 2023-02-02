
package cn.featherfly.hammer.sqldb.sql.dml;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.db.builder.BuilderUtils;
import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.builder.dml.SqlLogicExpression;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.exception.UnsupportedException;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializableSupplierLambdaInfo;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.repository.IgnorePolicy;
import cn.featherfly.common.repository.builder.BuilderException;
import cn.featherfly.common.repository.builder.BuilderExceptionCode;
import cn.featherfly.common.repository.mapping.PropertyMapping.Mode;
import cn.featherfly.hammer.expression.condition.Expression;
import cn.featherfly.hammer.expression.condition.LogicOperatorExpression;
import cn.featherfly.hammer.expression.condition.ParamedExpression;

/**
 * sql condition group builder sql条件逻辑组构造器.
 *
 * @author zhongj
 * @param <L> the generic type
 */
public abstract class AbstractSqlConditionExpression<L> implements SqlBuilder, ParamedExpression {

    /**
     * Instantiates a new abstract sql condition expression.
     *
     * @param dialect      dialect
     * @param ignorePolicy the ignore policy
     */
    public AbstractSqlConditionExpression(Dialect dialect, Predicate<Object> ignorePolicy) {
        this(dialect, ignorePolicy, null);
    }

    /**
     * Instantiates a new abstract sql condition expression.
     *
     * @param dialect      dialect
     * @param ignorePolicy the ignore policy
     * @param parent       parent group
     */
    protected AbstractSqlConditionExpression(Dialect dialect, Predicate<Object> ignorePolicy, L parent) {
        AssertIllegalArgument.isNotNull(ignorePolicy, "ignorePolicy");
        this.ignorePolicy = ignorePolicy;
        this.dialect = dialect;
        this.parent = parent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        StringBuilder result = new StringBuilder();
        if (conditions.size() > 0) {
            Expression last = conditions.get(conditions.size() - 1);
            if (last instanceof LogicOperatorExpression) {
                //                throw new BuilderException(((SqlLogicExpression) last).getLogicOperator() + " 后没有跟条件表达式");
                throw new BuilderException(BuilderExceptionCode
                        .createNoConditionBehindCode(((SqlLogicExpression) last).getLogicOperator().name()));
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
                    //                    if (pre instanceof SqlLogicExpression) {
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
    public String expression() {
        return build();
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
            if (condition instanceof ParamedExpression) {
                Object param = ((ParamedExpression) condition).getParam();
                if (!ignorePolicy.test(param)) {
                    if (param == null) {
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
            }
        }
        return params;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return build();
    }

    // ********************************************************************
    // protected method
    // ********************************************************************

    /**
     * Gets the property name.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return the property name
     */
    protected <T, R> String getPropertyName(SerializableFunction<T, R> name) {
        return LambdaUtils.getLambdaPropertyName(name);
    }

    //    protected <T, R extends Number> String getPropertyName(ReturnNumberFunction<T, R> name) {
    //        return LambdaUtils.getLambdaPropertyName(name);
    //    }

    /**
     * Adds the condition.
     *
     * @param condition the condition
     * @return the object
     */
    protected Object addCondition(Expression condition) {
        if (previousCondition != null) {
            if (previousCondition.getClass().isInstance(condition)) {
                throw new BuilderException(
                        BuilderExceptionCode.createNextToSameConditionCode(condition.getClass().getName()));
            }
        }
        //        if (condition instanceof ParamedExpression) {
        //            ParamedExpression paramedExpression = (ParamedExpression) condition;
        //            if (ignorePolicy.test(paramedExpression.getParam())) { // 忽略带参数的条件表达式
        //                // 移除逻辑表达式
        //                conditions.remove(conditions.size() - 1);
        //                if (conditions.isEmpty()) {
        //                    previousCondition = null;
        //                } else {
        //                    previousCondition = conditions.get(conditions.size() - 1);
        //                }
        //                return this;
        //            }
        //        }
        previousCondition = condition;
        conditions.add(condition);
        return this;
    }

    /**
     * Supplier.
     *
     * @param <R>          the generic type
     * @param info         the info
     * @param value        the value
     * @param classMapping the class mapping
     * @return the list
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
     * @return the list
     */
    protected <R> List<Tuple2<String, Optional<R>>> supplier(SerializableSupplierLambdaInfo<R> info,
            JdbcClassMapping<?> classMapping) {
        return supplier(info.getSerializedLambdaInfo(), info.get(), classMapping);
        //        List<Tuple2<String, Optional<R>>> list = new ArrayList<>();
        //        String propertyName = info.getSerializedLambdaInfo().getPropertyName();
        //        R r = info.getValue();
        //        if (r != null && classMapping != null) {
        //            PropertyMapping propertyMapping = classMapping.getPropertyMapping(propertyName);
        //            if (Lang.isNotEmpty(propertyMapping.getPropertyMappings())) {
        //                for (PropertyMapping pm : propertyMapping.getPropertyMappings()) {
        //                    Object obj = BeanUtils.getProperty(r, pm.getPropertyName());
        //                    // TODO 这里的返回值不是R类型
        //                    Optional<R> optional = Optional.empty();
        //                    if (obj != null) {
        //                        optional = (Optional<R>) Optional.of(obj);
        //                    }
        //                    list.add(Tuples.of(pm.getRepositoryFieldName(), optional));
        //                }
        //                return list;
        //            }
        //        }
        //        list.add(Tuples.of(propertyName, Optional.of(r)));
        //        return list;
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
            throw new UnsupportedException();
        } else if (pm.getMode() == Mode.SINGLE) {
            // FIXME 未实现
            throw new UnsupportedException();
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
        // IMPLSOON 这里为测试
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

    // ********************************************************************
    // property
    // ********************************************************************

    /** The conditions. */
    private List<Expression> conditions = new ArrayList<>();

    /** The parent. */
    protected L parent;

    /** The dialect. */
    protected Dialect dialect;

    private Expression previousCondition;

    /** The ignore policy. */
    /*
     * 忽略策略
     */
    protected Predicate<Object> ignorePolicy = IgnorePolicy.EMPTY;

    /**
     * get ignorePolicy value.
     *
     * @return ignorePolicy
     */
    public Predicate<Object> getIgnorePolicy() {
        return ignorePolicy;
    }

    /**
     * Gets the conditions.
     *
     * @return the conditions
     */
    public List<Expression> getConditions() {
        return conditions;
    }
}
