
package cn.featherfly.juorm.jdbc.dsl.execute;

import cn.featherfly.juorm.dsl.Repository;
import cn.featherfly.juorm.dsl.execute.ExecutableConditionGroupExpression;
import cn.featherfly.juorm.expression.execute.IExecutableUpdate;
import cn.featherfly.juorm.expression.execute.property.SimpleUpdateNumberValue;
import cn.featherfly.juorm.expression.execute.property.SimpleUpdateValue;
import cn.featherfly.juorm.expression.execute.property.UpdateNumberValue;
import cn.featherfly.juorm.expression.execute.property.UpdateValue;
import cn.featherfly.juorm.jdbc.Jdbc;
import cn.featherfly.juorm.sql.dml.builder.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.juorm.sql.model.UpdateColumnElement.SetType;

/**
 * <p>
 * SqlExecutableUpdate
 * </p>
 *
 * @author zhongj
 */
public class SqlExecutableUpdate
        implements SqlUpdate, IExecutableUpdate<SqlExecutableUpdate> {

    private String tableName;

    private Jdbc jdbc;

    private SqlUpdateSetBasicBuilder builder;

    /**
     * @param tableName
     *            tableName
     * @param jdbc
     *            jdbc
     */
    public SqlExecutableUpdate(String tableName, Jdbc jdbc) {
        this.tableName = tableName;
        this.jdbc = jdbc;
        builder = new SqlUpdateSetBasicBuilder(jdbc.getDialect(), tableName);
    }

    /**
     * @param repository
     * @param jdbc
     */
    public SqlExecutableUpdate(Repository repository, Jdbc jdbc) {
        this(repository.name(), jdbc);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlExecutableUpdate set(String name, Object value) {
        builder.setValue(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> SqlExecutableUpdate increase(String name,
            N value) {
        builder.setValue(name, value, SetType.INCR);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <V extends UpdateValue<SqlExecutableUpdate, Object>> V property(
            String name) {
        return (V) new SimpleUpdateValue<>(this, name);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <V extends UpdateNumberValue<SqlExecutableUpdate, Number>> V propertyNumber(
            String name) {
        return (V) new SimpleUpdateNumberValue<>(this, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableConditionGroupExpression where() {
        return new SqlUpdateExpression(jdbc, tableName, builder);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        return new SqlUpdateExpression(jdbc, tableName, builder).execute();
    }

}
