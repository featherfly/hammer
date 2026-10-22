
package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Nullable;

import cn.featherfly.common.db.mapping.SqlTypeMappingManager;

/**
 * <p>
 * ConnectionCallback.
 *
 * @author zhongj
 * @param <T> the generic type
 */
@FunctionalInterface
public interface ConnectionCallback<T> {

    /**
     * Do in connection.
     *
     * @param con the con
     * @param sqlTypeMappingManager the sql type mapping manager
     * @return the t
     * @throws SQLException the SQL exception
     */
    @Nullable
    T doInConnection(Connection con, SqlTypeMappingManager sqlTypeMappingManager) throws SQLException;
}
