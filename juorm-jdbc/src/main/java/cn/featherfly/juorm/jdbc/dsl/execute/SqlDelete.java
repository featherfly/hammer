
package cn.featherfly.juorm.jdbc.dsl.execute;

import cn.featherfly.juorm.dsl.Repository;
import cn.featherfly.juorm.dsl.execute.Delete;
import cn.featherfly.juorm.dsl.execute.ExecutableConditionGroupExpression;
import cn.featherfly.juorm.jdbc.Jdbc;

/**
 * <p>
 * SqlDelete
 * </p>
 *
 * @author zhongj
 */
public class SqlDelete implements Delete {

    private String tableName;

    private Jdbc jdbc;

    /**
     * @param tableName
     */
    public SqlDelete(String tableName, Jdbc jdbc) {
        this.tableName = tableName;
        this.jdbc = jdbc;
    }

    /**
     * @param repository
     */
    public SqlDelete(Repository repository, Jdbc jdbc) {
        this(repository.name(), jdbc);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableConditionGroupExpression where() {
        return new SqlDeleteExpression(jdbc, tableName);
    }
}
