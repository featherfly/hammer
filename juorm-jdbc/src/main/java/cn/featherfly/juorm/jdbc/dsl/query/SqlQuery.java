
package cn.featherfly.juorm.jdbc.dsl.query;

import cn.featherfly.juorm.dsl.query.Query;
import cn.featherfly.juorm.dsl.query.QueryEntity;
import cn.featherfly.juorm.expression.Repository;
import cn.featherfly.juorm.jdbc.Jdbc;

/**
 * <p>
 * SqlQuery
 * </p>
 *
 * @author zhongj
 */
public class SqlQuery implements Query {

    private Jdbc jdbc;

    /**
     * @param jdbc jdbc
     */
    public SqlQuery(Jdbc jdbc) {
        super();
        this.jdbc = jdbc;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryEntity find(Repository repository) {
        if (repository == null) {
            return null;
        }
        return new SqlQueryEntityProperties(repository.name(), jdbc, repository.alias());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryEntity find(String tableName) {
        return new SqlQueryEntityProperties(tableName, jdbc);
    }
}
