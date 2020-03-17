
package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.lang.Nullable;

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
    T doInConnection(Connection con) throws SQLException;
}
