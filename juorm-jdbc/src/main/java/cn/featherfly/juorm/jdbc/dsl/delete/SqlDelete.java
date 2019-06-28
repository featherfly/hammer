
package cn.featherfly.juorm.jdbc.dsl.delete;

import cn.featherfly.juorm.dsl.Repository;
import cn.featherfly.juorm.dsl.execute.ConditionGroupExpression;
import cn.featherfly.juorm.dsl.execute.Delete;
import cn.featherfly.juorm.jdbc.Jdbc;
import cn.featherfly.juorm.jdbc.dsl.execute.SqlConditionGroupExpression;

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
    public ConditionGroupExpression where() {
        return new SqlConditionGroupExpression(jdbc);
    }
}
