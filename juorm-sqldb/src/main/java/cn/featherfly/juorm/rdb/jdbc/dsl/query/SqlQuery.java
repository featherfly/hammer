
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import cn.featherfly.juorm.JuormException;
import cn.featherfly.juorm.dsl.query.Query;
import cn.featherfly.juorm.dsl.query.QueryEntity;
import cn.featherfly.juorm.expression.Repository;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.jdbc.mapping.JdbcMappingFactory;

/**
 * <p>
 * SqlQuery
 * </p>
 *
 * @author zhongj
 */
public class SqlQuery implements Query {

    private Jdbc jdbc;

    private JdbcMappingFactory mappingFactory;

    /**
     * @param jdbc jdbc
     */
    public SqlQuery(Jdbc jdbc) {
        super();
        this.jdbc = jdbc;
    }

    /**
     * @param jdbc
     * @param mappingFactory
     */
    public SqlQuery(Jdbc jdbc, JdbcMappingFactory mappingFactory) {
        super();
        this.jdbc = jdbc;
        this.mappingFactory = mappingFactory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlQueryEntityProperties find(Repository repository) {
        if (repository == null) {
            return null;
        }
        return new SqlQueryEntityProperties(repository.name(), jdbc, repository.alias());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlQueryEntityProperties find(String tableName) {
        return new SqlQueryEntityProperties(tableName, jdbc);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryEntity find(Class<?> repositType) {
        if (mappingFactory == null) {
            throw new JuormException("mappingFactory is null");
        }
        return new SqlQueryEntityProperties(mappingFactory.getClassMapping(repositType), jdbc);
    }
}
