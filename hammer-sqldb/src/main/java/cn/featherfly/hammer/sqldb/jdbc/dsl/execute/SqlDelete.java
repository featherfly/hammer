
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import java.util.function.Consumer;

import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.dsl.execute.Delete;
import cn.featherfly.hammer.dsl.execute.ExecutableConditionGroup;
import cn.featherfly.hammer.dsl.execute.ExecutableConditionGroupLogic;
import cn.featherfly.hammer.expression.execute.DeleteExpression;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * SqlDelete .
 *
 * @author zhongj
 */
public class SqlDelete implements Delete {

    private String tableName;

    private String tableAlias;

    private Jdbc jdbc;

    private DeleteConfig deleteConfig;

    /**
     * Instantiates a new sql delete.
     *
     * @param jdbc         the jdbc
     * @param tableName    the table name
     * @param deleteConfig the delete config
     */
    public SqlDelete(Jdbc jdbc, String tableName, DeleteConfig deleteConfig) {
        this(jdbc, tableName, null, deleteConfig);
    }

    /**
     * Instantiates a new sql delete.
     *
     * @param jdbc         the jdbc
     * @param tableName    the table name
     * @param tableAlias   the table alias
     * @param deleteConfig the delete config
     */
    public SqlDelete(Jdbc jdbc, String tableName, String tableAlias, DeleteConfig deleteConfig) {
        this.tableName = tableName;
        this.tableAlias = tableAlias;
        this.jdbc = jdbc;
        this.deleteConfig = deleteConfig.clone();
    }

    /**
     * Instantiates a new sql delete.
     *
     * @param jdbc       jdbc
     * @param repository repository
     */
    public SqlDelete(Jdbc jdbc, Repository repository, DeleteConfig deleteConfig) {
        this(jdbc, repository.name(), deleteConfig);
    }

    /**
     * Instantiates a new sql delete.
     *
     * @param jdbc       jdbc
     * @param repository repository
     */
    public SqlDelete(Jdbc jdbc, AliasRepository repository, DeleteConfig deleteConfig) {
        this(jdbc, repository.name(), repository.alias(), deleteConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableConditionGroup<DeleteConditionConfig> where() {
        return new SqlDeleteExpression(jdbc, new SqlDeleteFromBasicBuilder(jdbc.getDialect(), tableName, tableAlias),
                deleteConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableConditionGroup<DeleteConditionConfig> where(
            Consumer<ExecutableConditionGroup<DeleteConditionConfig>> consumer) {
        SqlDeleteExpression sqlDeleteExpression = new SqlDeleteExpression(jdbc,
                new SqlDeleteFromBasicBuilder(jdbc.getDialect(), tableName, tableAlias), deleteConfig);
        if (consumer != null) {
            consumer.accept(sqlDeleteExpression);
        }
        return sqlDeleteExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeleteExpression<ExecutableConditionGroup<DeleteConditionConfig>,
            ExecutableConditionGroupLogic<DeleteConditionConfig>> configure(Consumer<DeleteConfig> configure) {
        if (configure != null) {
            configure.accept(deleteConfig);
        }
        return this;
    }
}
