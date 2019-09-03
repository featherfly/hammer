
package cn.featherfly.juorm.rdb.jdbc.dsl.execute;

import cn.featherfly.juorm.dsl.execute.ExecutableConditionGroupExpression;
import cn.featherfly.juorm.dsl.execute.ExecutableUpdate;
import cn.featherfly.juorm.dsl.execute.SimpleUpdateNumberValue;
import cn.featherfly.juorm.dsl.execute.SimpleUpdateValue;
import cn.featherfly.juorm.dsl.execute.UpdateNumberValue;
import cn.featherfly.juorm.dsl.execute.UpdateValue;
import cn.featherfly.juorm.expression.Repository;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMapping;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMappingUtils;
import cn.featherfly.juorm.rdb.sql.dml.builder.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.juorm.rdb.sql.model.UpdateColumnElement.SetType;

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
        builder = new SqlUpdateSetBasicBuilder(jdbc.getDialect(), classMapping.getTableName());
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
