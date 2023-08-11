
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import java.util.function.Consumer;

import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.execute.Delete;
import cn.featherfly.hammer.dsl.execute.ExecutableConditionGroup;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
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

    /**
     * Instantiates a new sql delete.
     *
     * @param jdbc      the jdbc
     * @param tableName the table name
     */
    public SqlDelete(Jdbc jdbc, String tableName) {
        this(jdbc, tableName, null);
    }

    /**
     * Instantiates a new sql delete.
     *
     * @param jdbc       the jdbc
     * @param tableName  the table name
     * @param tableAlias the table alias
     */
    public SqlDelete(Jdbc jdbc, String tableName, String tableAlias) {
        this.tableName = tableName;
        this.tableAlias = tableAlias;
        this.jdbc = jdbc;
    }

    /**
     * Instantiates a new sql delete.
     *
     * @param jdbc       jdbc
     * @param repository repository
     */
    public SqlDelete(Jdbc jdbc, Repository repository) {
        this(jdbc, repository.name());
    }

    /**
     * Instantiates a new sql delete.
     *
     * @param jdbc       jdbc
     * @param repository repository
     */
    public SqlDelete(Jdbc jdbc, AliasRepository repository) {
        this(jdbc, repository.name(), repository.alias());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableConditionGroup where() {
        return new SqlDeleteExpression(jdbc, new SqlDeleteFromBasicBuilder(jdbc.getDialect(), tableName, tableAlias));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableConditionGroup where(
            Consumer<ConditionGroupConfig<ExecutableConditionGroup>> consumer) {
        SqlDeleteExpression sqlDeleteExpression = new SqlDeleteExpression(jdbc,
                new SqlDeleteFromBasicBuilder(jdbc.getDialect(), tableName, tableAlias));
        if (consumer != null) {
            consumer.accept(sqlDeleteExpression);
        }
        return sqlDeleteExpression;
    }
}
