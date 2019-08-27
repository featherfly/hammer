
package cn.featherfly.juorm.rdb.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.lang.Nullable;

/**
 * <p>
 * ConnectionCallback
 * </p>
 * <p>
 * 2019-09-03
 * </p>
 *
 * @author zhongj
 */
@FunctionalInterface
public interface ConnectionCallback<T> {

    @Nullable
    T doInConnection(Connection con) throws SQLException;
}
