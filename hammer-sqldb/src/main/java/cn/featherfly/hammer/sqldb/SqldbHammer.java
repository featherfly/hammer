
package cn.featherfly.hammer.sqldb;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * SqldbHammer.
 *
 * @author zhongj
 */
public interface SqldbHammer extends Hammer {

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
