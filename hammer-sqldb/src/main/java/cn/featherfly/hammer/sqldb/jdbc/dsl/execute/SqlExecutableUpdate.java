
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.common.db.builder.model.UpdateColumnElement.SetType;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializableSupplierLambdaInfo;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.hammer.dsl.execute.ExecutableConditionGroupExpression;
import cn.featherfly.hammer.dsl.execute.ExecutableUpdate;
import cn.featherfly.hammer.dsl.execute.SimpleUpdateNumberValue;
import cn.featherfly.hammer.dsl.execute.SimpleUpdateValue;
import cn.featherfly.hammer.dsl.execute.UpdateNumberValue;
import cn.featherfly.hammer.dsl.execute.UpdateValue;
import cn.featherfly.hammer.expression.Repository;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * <p>
 * SqlExecutableUpdate
 * </p>
 * .
 *
 * @author zhongj
 */
public class SqlExecutableUpdate implements SqlUpdate, ExecutableUpdate {

    private Jdbc jdbc;

    private SqlUpdateSetBasicBuilder builder;

    private ClassMapping<?> classMapping;

    /**
     * Instantiates a new sql executable update.
     *
     * @param tableName tableName
     * @param jdbc      jdbc
     */
    public SqlExecutableUpdate(String tableName, Jdbc jdbc) {
        this.jdbc = jdbc;
        builder = new SqlUpdateSetBasicBuilder(jdbc.getDialect(), tableName);
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
    public SqlExecutableUpdate(ClassMapping<?> classMapping, Jdbc jdbc) {
        this.classMapping = classMapping;
        this.jdbc = jdbc;
        builder = new SqlUpdateSetBasicBuilder(jdbc.getDialect(), classMapping.getRepositoryName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlExecutableUpdate set(String name, Object value) {
        builder.setValue(ClassMappingUtils.getColumnName(name, classMapping), value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> SqlExecutableUpdate increase(String name, N value) {
        builder.setValue(ClassMappingUtils.getColumnName(name, classMapping), value, SetType.INCR);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> ExecutableUpdate set(SerializableFunction<T, R> name, Object value) {
        return set(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number, N extends Number> ExecutableUpdate increase(SerializableFunction<T, R> name, N value) {
        return increase(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> ExecutableUpdate set(SerializableSupplier<R> property) {
        SerializableSupplierLambdaInfo<R> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return set(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> ExecutableUpdate increase(SerializableSupplier<N> property) {
        SerializableSupplierLambdaInfo<N> info = LambdaUtils.getSerializableSupplierLambdaInfo(property);
        return increase(info.getSerializedLambdaInfo().getPropertyName(), info.getValue());
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
        return new SqlUpdateExpression(jdbc, builder, classMapping);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        return new SqlUpdateExpression(jdbc, builder, classMapping).execute();
    }
}
