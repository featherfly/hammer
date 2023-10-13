
package cn.featherfly.hammer.sqldb.jdbc;

import static org.testng.Assert.assertEquals;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.lang.Randoms;

/**
 * JdbcNativeTest.
 *
 * @author zhongj
 */
public class JdbcNativeTest extends JdbcTestBase {

    @Test
    void testCallQuery() throws SQLException {
        Connection conn = dataSource.getConnection();
        CallableStatement call = conn.prepareCall("call call_query_user(?)");
        call.setString(1, "yufei%");
        boolean b = call.execute();
        System.out.println("call.execute() = " + b);
        List<Map<String, Object>> list = JdbcUtils.getResultSetMaps(call.getResultSet());
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }

    @Test
    void testCallOutArgu() throws SQLException {
        Connection conn = dataSource.getConnection();

        CallableStatement call = conn.prepareCall("call call_update_user_one(?,?,?)");
        call.setInt(1, 13);
        call.setString(2, "featherfly_call" + Randoms.getInt(1000));
        //        call.setInt(3, 0);
        //        call.registerOutParameter(3, JDBCType.INTEGER);
        //        call.registerOutParameter("out_row_count", JDBCType.INTEGER);

        ParameterMetaData meta = call.getParameterMetaData();
        System.out.println("meta.getParameterCount() = " + meta.getParameterCount());
        for (int i = 1; i <= meta.getParameterCount(); i++) {
            System.out.println("param:" + i);
            System.out.println("meta.getParameterMode() = " + meta.getParameterMode(i));
            System.out.println("meta.getParameterType() = " + meta.getParameterType(i));
            System.out.println("meta.getParameterTypeName() = " + meta.getParameterTypeName(i));
            System.out.println("meta.getParameterClassName() = " + meta.getParameterClassName(i));
            System.out.println();
        }

        boolean b = call.execute();

        //        ParameterMetaData meta = call.getParameterMetaData();
        System.out.println("meta.getParameterCount() = " + meta.getParameterCount());
        for (int i = 1; i <= meta.getParameterCount(); i++) {
            System.out.printf("meta.getParameterType(%d) = %s\n", i, JDBCType.valueOf(meta.getParameterType(i)));
        }

        System.out.println("call.execute() = " + b);
        System.out.println("call.getUpdateCount() = " + call.getUpdateCount());
        System.out.println("call.getInt(3) = " + call.getInt(3));

        assertEquals(call.getInt(3), call.getUpdateCount());
    }

    @Test
    void testCallOutArgu2() throws SQLException {
        Connection conn = dataSource.getConnection();

        CallableStatement call = conn.prepareCall("call call_update_role_more(?,?,?)");
        call.setString(1, "name_init%");
        call.setString(2, "call_update_batch_" + Randoms.getInt(1000));
        boolean b = call.execute();
        System.out.println("call.execute() = " + b);
        System.out.println("call.getUpdateCount() = " + call.getUpdateCount());
        System.out.println("call.getInt(3) = " + call.getInt(3));

        assertEquals(call.getInt(3), call.getUpdateCount());
    }

    @Test
    void testCallOutArgu3() throws SQLException {
        Connection conn = dataSource.getConnection();
        CallableStatement call = conn.prepareCall("call call_update_role_more(?,?,?)");
        call.setString("q_name", "name_init%");
        call.setString("u_descp", "call_update_batch_" + Randoms.getInt(1000));
        boolean b = call.execute();
        System.out.println("call.execute() = " + b);
        System.out.println("call.getUpdateCount() = " + call.getUpdateCount());
        System.out.println("call.getInt(\"out_row_count\") = " + call.getInt("out_row_count"));

        assertEquals(call.getInt(3), call.getUpdateCount());
    }

    @Test
    void testClose() throws SQLException {
        Connection conn = dataSource.getConnection();
        PreparedStatement prep = conn.prepareStatement("select * from user");
        ResultSet set = prep.executeQuery();
        set.close();
        prep.close();
        conn.close();
        System.out.println("conn.close()");
    }
}
