
package cn.featherfly.juorm.sqldb.jdbc.dsl.execute;

import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.juorm.dsl.execute.ExecutableConditionGroupExpression;
import cn.featherfly.juorm.dsl.execute.ExecutableUpdate;
import cn.featherfly.juorm.dsl.execute.SimpleUpdateNumberValue;
import cn.featherfly.juorm.dsl.execute.SimpleUpdateValue;
import cn.featherfly.juorm.dsl.execute.UpdateNumberValue;
import cn.featherfly.juorm.dsl.execute.UpdateValue;
import cn.featherfly.juorm.expression.Repository;
import cn.featherfly.juorm.mapping.ClassMapping;
import cn.featherfly.juorm.sqldb.jdbc.Jdbc;
import cn.featherfly.juorm.sqldb.jdbc.mapping.ClassMappingUtils;
import cn.featherfly.juorm.sqldb.sql.dml.builder.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.juorm.sqldb.sql.model.UpdateColumnElement.SetType;

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
