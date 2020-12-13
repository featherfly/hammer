
package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.lang.Nullable;

import cn.featherfly.common.db.mapping.SqlTypeMappingManager;

/**
 * <p>
 * ConnectionCallback
 * </p>
 *
 * @author zhongj
 */
@FunctionalInterface
public interface ConnectionCallback<T> {

    @Nullable
    T doInConnection(Connection con, SqlTypeMappingManager sqlTypeMappingManager) throws SQLException;
}
