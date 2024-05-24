
package cn.featherfly.hammer.sqldb.jdbc;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Randoms;

/**
 * JdbcNativeTest.
 *
 * @author zhongj
 */
public class JdbcNativeTest extends JdbcTestBase {

    @Test
    void callQuery() throws SQLException {
        Connection conn = dataSource.getConnection();
        CallableStatement call = conn.prepareCall("call call_query_user(?)");
        call.setString(1, "yufei%");
        boolean b = call.execute();
        System.out.println("call.execute() = " + b);
        List<Map<String, Serializable>> list = JdbcUtils.getResultSetMaps(call.getResultSet());
        for (Map<String, Serializable> map : list) {
            System.out.println(map);
        }
    }

    @Test
    void callQuery2() throws SQLException {
        Connection conn = dataSource.getConnection();
        CallableStatement call = conn.prepareCall("call call_query_user(?)");
        call.setString("arg_username", "yufei%");
        boolean b = call.execute();
        System.out.println("call.execute() = " + b);
        List<Map<String, Serializable>> list = JdbcUtils.getResultSetMaps(call.getResultSet());
        for (Map<String, Serializable> map : list) {
            System.out.println(map);
        }
    }

    @Test
    void callMulityQuery() throws SQLException {
        Connection conn = dataSource.getConnection();
        CallableStatement call = conn.prepareCall("call call_query_user_by_id2(?)");
        call.setInt(1, 1);
        boolean b = call.execute();
        System.out.println("call.execute() = " + b);
        List<Map<String, Serializable>> list = JdbcUtils.getResultSetMaps(call.getResultSet());
        for (Map<String, Serializable> map : list) {
            System.out.println(map);
        }
        boolean hasMore = false;
        while (call.getMoreResults()) {
            hasMore = true;
            list = JdbcUtils.getResultSetMaps(call.getResultSet());
            for (Map<String, Serializable> map : list) {
                System.out.println(map);
            }
        }

        assertTrue(hasMore);
    }

    @Test
    void callMulityQuery2() throws SQLException {
        Connection conn = dataSource.getConnection();
        CallableStatement call = conn.prepareCall("call call_query_user_by_id3(?)");
        call.setInt(1, 1);
        boolean b = call.execute();
        System.out.println("call.execute() = " + b);
        List<Map<String, Serializable>> list = JdbcUtils.getResultSetMaps(call.getResultSet());
        for (Map<String, Serializable> map : list) {
            System.out.println(map);
        }
        int queryNum = 1;
        while (call.getMoreResults()) {
            queryNum++;
            list = JdbcUtils.getResultSetMaps(call.getResultSet());
            for (Map<String, Serializable> map : list) {
                System.out.println(map);
            }
        }

        assertEquals(queryNum, 3);
    }

    @Test
    void callOutArgu() throws SQLException {
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
            System.out.println("meta.isNullable() = " + meta.isNullable(i));
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
    void callOutArgu2() throws SQLException {
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
    void callOutArgu3() throws SQLException {
        Connection conn = dataSource.getConnection();
        CallableStatement call = conn.prepareCall("call call_update_role_more(?,?,?)");
        call.setString("q_name", "name_init%");
        call.setString("u_descp", "call_update_batch_" + Randoms.getInt(1000));
        boolean b = call.execute();
        System.out.println("call.execute() = " + b);
        System.out.println("call.getUpdateCount() = " + call.getUpdateCount());
        System.out.println("call.getInt(\"out_row_count\") = " + call.getInt("out_row_count"));

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

        assertEquals(call.getInt(3), call.getUpdateCount());
    }

    @Test
    void callOutArgu4() throws SQLException {
        Connection conn = dataSource.getConnection();

        LinkedHashMap<String, Serializable> params = new LinkedHashMap<>();
        params.put("q_name", "name_init%");
        params.put("u_descp", "call_update_batch_" + Randoms.getInt(1000));
        params.put("out_row_count", null); // 使用map必须把所有的参数都加进来，包含out参数

        String[] keys = Lang.toArray(params.keySet());

        CallableStatement call = conn.prepareCall("call call_update_role_more(?,?,?)");
        for (Entry<String, Serializable> param : params.entrySet()) {
            JdbcUtils.setParameter(call, param.getKey(), param.getValue());
        }
        boolean b = call.execute();
        System.out.println("call.execute() = " + b);
        System.out.println("call.getUpdateCount() = " + call.getUpdateCount());
        System.out.println("call.getInt(\"out_row_count\") = " + call.getInt("out_row_count"));

        ParameterMetaData meta = call.getParameterMetaData();
        System.out.println("meta.getParameterCount() = " + meta.getParameterCount());
        for (int i = 1; i <= meta.getParameterCount(); i++) {
            System.out.println("param:" + i);
            System.out.println("meta.getParameterMode() = " + meta.getParameterMode(i));
            System.out.println("meta.getParameterType() = " + meta.getParameterType(i));
            System.out.println("meta.getParameterTypeName() = " + meta.getParameterTypeName(i));
            System.out.println("meta.getParameterClassName() = " + meta.getParameterClassName(i));
            System.out.println();

            if (meta.getParameterMode(i) == ParameterMetaData.parameterModeInOut
                || meta.getParameterMode(i) == ParameterMetaData.parameterModeOut) {
                params.put(keys[i - 1], call.getInt(i));
            }
        }

        assertNotNull(params.get("out_row_count"));

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
