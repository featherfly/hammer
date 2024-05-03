
package cn.featherfly.hammer.sqldb;

import cn.featherfly.common.db.Table;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryDelete;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdate;
import cn.featherfly.hammer.sqldb.dsl.repository.query.RepositorySqlQueryFetch;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * SqldbHammer.
 *
 * @author zhongj
 */
public interface SqldbHammer extends Hammer {

    /**
     * create QueryEntity for table.
     *
     * @param table the table
     * @return the query entity
     */
    RepositorySqlQueryFetch query(Table table);

    /**
     * create update for table.
     *
     * @param table the table
     * @return Update
     */
    RepositoryUpdate update(Table table);

    /**
     * create delete for table.
     *
     * @param table the table
     * @return Delete
     */
    RepositoryDelete delete(Table table);

    /**
     * get Jdbc.
     *
     * @return jdbc
     */
    Jdbc getJdbc();

    /**
     * Gets the mapping factory.
     *
     * @return the mapping factory
     */
    JdbcMappingFactory getMappingFactory();
}
