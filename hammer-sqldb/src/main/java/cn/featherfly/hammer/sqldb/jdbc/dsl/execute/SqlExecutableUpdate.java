
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import java.lang.invoke.SerializedLambda;
import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.bean.BeanPropertyValue;
import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.common.db.builder.model.UpdateColumnElement.SetType;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializableSupplierLambdaInfo;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.repository.IgnorePolicy;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.execute.ExecutableConditionGroupExpression;
import cn.featherfly.hammer.dsl.execute.ExecutableUpdate;
import cn.featherfly.hammer.dsl.execute.SimpleUpdateNumberValue;
import cn.featherfly.hammer.dsl.execute.SimpleUpdateValue;
import cn.featherfly.hammer.dsl.execute.UpdateNumberValue;
import cn.featherfly.hammer.dsl.execute.UpdateValue;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * SqlExecutableUpdate .
 *
 * @author zhongj
 */
public class SqlExecutableUpdate implements SqlUpdate, ExecutableUpdate {

    private Jdbc jdbc;

    private SqlUpdateSetBasicBuilder builder;

    private JdbcClassMapping<?> classMapping;

    /**
     * Instantiates a new sql executable update.
     *
     * @param tableName tableName
     * @param jdbc      jdbc
     */
    public SqlExecutableUpdate(String tableName, Jdbc jdbc) {
        this(tableName, jdbc, IgnorePolicy.NONE);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param repository the repository
     * @param jdbc       the jdbc
     */
    public SqlExecutableUpdate(Repository repository, Jdbc jdbc) {
        this(repository.name(), jdbc);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param classMapping the class mapping
     * @param jdbc         the jdbc
     */
    public SqlExecutableUpdate(JdbcClassMapping<?> classMapping, Jdbc jdbc) {
        this(classMapping, jdbc, IgnorePolicy.NONE);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param tableName    tableName
     * @param jdbc         jdbc
     * @param ignorePolicy the ignore policy
     */
    public SqlExecutableUpdate(String tableName, Jdbc jdbc, Predicate<Object> ignorePolicy) {
        this.jdbc = jdbc;
        builder = new SqlUpdateSetBasicBuilder(jdbc.getDialect(), tableName, ignorePolicy);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param repository   the repository
     * @param jdbc         the jdbc
     * @param ignorePolicy the ignore policy
     */
    public SqlExecutableUpdate(Repository repository, Jdbc jdbc, Predicate<Object> ignorePolicy) {
        this(repository.name(), jdbc, ignorePolicy);
    }

    /**
     * Instantiates a new sql executable update.
     *
     * @param classMapping the class mapping
     * @param jdbc         the jdbc
     * @param ignorePolicy the ignore policy
     */
    public SqlExecutableUpdate(JdbcClassMapping<?> classMapping, Jdbc jdbc, Predicate<Object> ignorePolicy) {
        this.classMapping = classMapping;
        this.jdbc = jdbc;
        builder = new SqlUpdateSetBasicBuilder(jdbc.getDialect(), classMapping.getRepositoryName(), ignorePolicy);
    }

    private SqlExecutableUpdate _set(String name, Object value) {
        builder.setValue(name, value);
        return this;
    }

    private <N extends Number> SqlExecutableUpdate _increase(String name, N value) {
        builder.setValue(name, value, SetType.INCR);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlExecutableUpdate set(String name, Object value) {
        return _set(ClassMappingUtils.getColumnName(name, classMapping), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> SqlExecutableUpdate increase(String name, N value) {
        return _increase(ClassMappingUtils.getColumnName(name, classMapping), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> ExecutableUpdate set(SerializableFunction<T, R> name, R value) {
        SerializedLambda serializedLambda = LambdaUtils.getSerializedLambda(name);
        String propertyName = LambdaUtils.getLambdaPropertyName(serializedLambda);
        if (classMapping != null) {
            BeanDescriptor<?> bd = BeanDescriptor.getBeanDescriptor(classMapping.getType());
            BeanProperty<R> bp = bd.getBeanProperty(propertyName);
            return set(bp.getName(), new BeanPropertyValue<>(bp, value));
        } else {
            return set(propertyName, value);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> ExecutableUpdate increase(SerializableFunction<T, R> name, R value) {
        return increase(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> ExecutableUpdate set(SerializableSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        if (classMapping != null) {
            BeanDescriptor<?> bd = BeanDescriptor.getBeanDescriptor(classMapping.getType());
            BeanProperty<R> bp = bd.getBeanProperty(info.getSerializedLambdaInfo().getPropertyName());
            return set(bp.getName(), new BeanPropertyValue<>(bp, info.getValue()));
        } else {
            return set(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableUpdate set(Consumer<ExecutableUpdate> consumer) {
        consumer.accept(this);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> ExecutableUpdate increase(SerializableSupplier<N> property) {
        // TODO increase 应该用不上自定义类型映射?? 暂时先不包装BeanPropertyValue
        SerializableSupplierLambdaInfo<N> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return increase(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableUpdate increase(Consumer<ExecutableUpdate> consumer) {
        consumer.accept(this);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateValue property(String name) {
        return new SimpleUpdateValue(ClassMappingUtils.getColumnName(name, classMapping), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateNumberValue propertyNumber(String name) {
        return new SimpleUpdateNumberValue(ClassMappingUtils.getColumnName(name, classMapping), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UpdateValue property(SerializableFunction<T, R> name) {
        return property(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> UpdateNumberValue propertyNumber(SerializableFunction<T, R> name) {
        return propertyNumber(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableConditionGroupExpression where() {
        return new SqlUpdateExpression(jdbc, builder, classMapping, builder.getIgnorePolicy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableConditionGroupExpression where(
            Consumer<ConditionGroupConfig<ExecutableConditionGroupExpression>> consumer) {
        SqlUpdateExpression sqlUpdateExpression = new SqlUpdateExpression(jdbc, builder, classMapping,
                builder.getIgnorePolicy());
        if (consumer != null) {
            consumer.accept(sqlUpdateExpression);
        }
        return sqlUpdateExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        return new SqlUpdateExpression(jdbc, builder, classMapping).execute();
    }
}
