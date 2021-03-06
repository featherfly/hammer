
package cn.featherfly.hammer.sqldb;

import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * <p>
 * SqldbHammer
 * </p>
 *
 * @author zhongj
 */
public interface SqldbHammer extends Hammer {
    /**
     * get Jdbc
     * 
     * @return jdbc
     */
    Jdbc getJdbc();
}
