
package cn.featherfly.hammer.sqldb;

import cn.featherfly.common.db.Table;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.dsl.execute.Delete;
import cn.featherfly.hammer.dsl.execute.Update;
import cn.featherfly.hammer.dsl.query.QueryEntity;
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
    QueryEntity query(Table table);

    /**
     * create update for table.
     *
     * @param table the table
     * @return Update
     */
    Update update(Table table);

    /**
     * create delete for table.
     *
     * @param table the table
     * @return Delete
     */
    Delete delete(Table table);

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
