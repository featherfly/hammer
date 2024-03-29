
package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Nullable;

import cn.featherfly.common.db.mapping.SqlTypeMappingManager;

/**
 * <p>
 * ConnectionCallback
 *
 * @author zhongj
 */
@FunctionalInterface
public interface ConnectionCallback<T> {

    @Nullable
    T doInConnection(Connection con, SqlTypeMappingManager sqlTypeMappingManager) throws SQLException;
}
