
/*
 * All rights Reserved, Designed By zhongj
 * @Title: JdbcPerformanceTest.java
 * @Description: JdbcPerformanceTest
 * @author: zhongj
 * @date: 2023-08-22 15:49:22
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.pt;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import org.testng.annotations.Test;

import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.dialect.Dialects;
import cn.featherfly.common.db.wrapper.ConnectionWrapper;
import cn.featherfly.common.db.wrapper.PreparedStatementWrapper;
import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.lang.Timer;
import cn.featherfly.hammer.sqldb.jdbc.HammerJdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.UserInfo2;

/**
 * JdbcPerformanceTest.
 *
 * @author zhongj
 */
public class JdbcPerformanceTest extends HammerJdbcTestBase {

    private int batchSize = 1000;

    private int batchTimes = 1;

    @Test
    public void testInsertBatch() {
        String insertSql = "insert into `user_info` (`id`, `user_id`, `name`, `descp`, `province`, `city`, `district`) values(?,?,?,?,?,?,?)";
        Timer timer = Timer.start();
        ConnectionWrapper conn = JdbcUtils.getConnectionWrapper(dataSource);
        int index = 0;
        for (int i = 0; i < batchTimes; i++) {
            PreparedStatementWrapper prep = conn.prepareStatement(insertSql);
            for (int j = 0; j < batchSize; j++) {
                prep.setObject(1, null);
                prep.setInt(2, 1);
                prep.setString(3, "yufei_" + index);
                prep.setString(4, "yufei_descp_" + index);
                prep.setString(5, "省_" + index);
                prep.setString(6, "市_" + index);
                prep.setString(7, "区_" + index);
                prep.addBatch();
                index++;
            }
            int[] res = prep.executeBatch();
            System.out.println("res: " + res.length);
            System.out.println(ArrayUtils.toString(res));
            prep.close();
        }
        conn.close();
        System.out.println(Strings.format("testInsertBatch use {0} time with insertBatch[{1}] times {2}", timer.stop(),
                batchSize, batchTimes));
    }

    @Test
    public void testInsertBatchSingleSql() {
        String insertSql = Dialects.mysql().dml().insertBatch("user_info",
                new String[] { "id", "user_id", "name", "descp", "province", "city", "district" }, batchSize);
        Timer timer = Timer.start();
        ConnectionWrapper conn = JdbcUtils.getConnectionWrapper(dataSource);
        int index = 0;
        int total = 0;
        for (int i = 0; i < batchTimes; i++) {
            PreparedStatementWrapper prep = conn.prepareStatement(insertSql);
            for (int j = 0; j < batchSize; j++) {
                prep.setObject(++total, null);
                prep.setInt(++total, 1);
                prep.setString(++total, "yufei2_" + index);
                prep.setString(++total, "yufei2_descp_" + index);
                prep.setString(++total, "省2_" + index);
                prep.setString(++total, "市2_" + index);
                prep.setString(++total, "区2_" + index);
                index++;
            }
            int res = prep.executeUpdate();
            System.out.println("res: " + res);
            prep.close();
        }
        conn.close();
        System.out.println(Strings.format("testInsertBatchSingleSql use {0} time with insertBatch[{1}] times {2}",
                timer.stop(), batchSize, batchTimes));
    }

    // ****************************************************************************************************************
    //
    // ****************************************************************************************************************

    ThreeArgusConsumer<PreparedStatementWrapper, Integer, Object> prepSetObject = (prep, index, value) -> prep
            .setObject(index, value);

    ThreeArgusConsumer<PreparedStatementWrapper, Integer, Integer> prepSetInt = (prep, index, value) -> prep
            .setInt(index, value);

    ThreeArgusConsumer<PreparedStatementWrapper, Integer, String> prepSetString = (prep, index, value) -> prep
            .setString(index, value);

    @Test
    public void testInsertBatch2() {
        BiConsumer<PreparedStatementWrapper, Object> prepSet1 = (prep, value) -> prep.setObject(1, value);
        BiConsumer<PreparedStatementWrapper, Integer> prepSet2 = (prep, value) -> prep.setInt(2, value);
        BiConsumer<PreparedStatementWrapper, String> prepSet3 = (prep, value) -> prep.setString(3, value);
        BiConsumer<PreparedStatementWrapper, String> prepSet4 = (prep, value) -> prep.setString(4, value);
        BiConsumer<PreparedStatementWrapper, String> prepSet5 = (prep, value) -> prep.setString(5, value);
        BiConsumer<PreparedStatementWrapper, String> prepSet6 = (prep, value) -> prep.setString(6, value);
        BiConsumer<PreparedStatementWrapper, String> prepSet7 = (prep, value) -> prep.setString(7, value);

        String insertSql = "insert into `user_info` (`id`, `user_id`, `name`, `descp`, `province`, `city`, `district`) values(?,?,?,?,?,?,?)";
        Timer timer = Timer.start();
        ConnectionWrapper conn = JdbcUtils.getConnectionWrapper(dataSource);
        int index = 0;
        for (int i = 0; i < batchTimes; i++) {
            PreparedStatementWrapper prep = conn.prepareStatement(insertSql);
            for (int j = 0; j < batchSize; j++) {
                prepSet1.accept(prep, null);
                prepSet2.accept(prep, 1);
                prepSet3.accept(prep, "yufei_" + index);
                prepSet4.accept(prep, "yufei_descp_" + index);
                prepSet5.accept(prep, "省_" + index);
                prepSet6.accept(prep, "市_" + index);
                prepSet7.accept(prep, "区_" + index);
                prep.addBatch();
                index++;
            }
            int[] res = prep.executeBatch();
            System.out.println("res: " + res.length);
            System.out.println(ArrayUtils.toString(res));
            prep.close();
        }
        conn.close();
        System.out.println(Strings.format("testInsertBatch2 use {0} time with insertBatch[{1}] times {2}", timer.stop(),
                batchSize, batchTimes));
    }

    @Test
    public void testInsertBatchSingleSql2() {
        String insertSql = Dialects.mysql().dml().insertBatch("user_info",
                new String[] { "id", "user_id", "name", "descp", "province", "city", "district" }, batchSize);
        Timer timer = Timer.start();
        ConnectionWrapper conn = JdbcUtils.getConnectionWrapper(dataSource);
        int index = 0;
        int total = 0;
        for (int i = 0; i < batchTimes; i++) {
            PreparedStatementWrapper prep = conn.prepareStatement(insertSql);
            for (int j = 0; j < batchSize; j++) {
                prepSetObject.accept(prep, ++total, null);
                prepSetInt.accept(prep, ++total, 1);
                prepSetString.accept(prep, ++total, "yufei2_" + index);
                prepSetString.accept(prep, ++total, "yufei2_descp_" + index);
                prepSetString.accept(prep, ++total, "省2_" + index);
                prepSetString.accept(prep, ++total, "市2_" + index);
                prepSetString.accept(prep, ++total, "区2_" + index);
                index++;
            }
            int res = prep.executeUpdate();
            System.out.println("res: " + res);
            prep.close();
        }
        conn.close();
        System.out.println(Strings.format("testInsertBatchSingleSql2 use {0} time with insertBatch[{1}] times {2}",
                timer.stop(), batchSize, batchTimes));
    }

    // ****************************************************************************************************************
    //
    // ****************************************************************************************************************

    @Test
    public void testInsertBatch3() {
        String insertSql = "insert into `user_info` (`id`, `user_id`, `name`, `descp`, `province`, `city`, `district`) values(?,?,?,?,?,?,?)";
        Timer timer = Timer.start();
        ConnectionWrapper conn = JdbcUtils.getConnectionWrapper(dataSource);
        int index = 0;
        for (int i = 0; i < batchTimes; i++) {
            PreparedStatementWrapper prep = conn.prepareStatement(insertSql);
            for (int j = 0; j < batchSize; j++) {
                Object[] params = new Object[] { null, 1, "yufei_" + index, "yufei_descp_" + index, "省_" + index,
                        "市_" + index, "区_" + index };
                JdbcUtils.setParameters(prep, params);
                prep.addBatch();
                index++;
            }
            int[] res = prep.executeBatch();
            System.out.println("res: " + res.length);
            System.out.println(ArrayUtils.toString(res));
            prep.close();
        }
        conn.close();
        System.out.println(Strings.format("testInsertBatch3 use {0} time with insertBatch[{1}] times {2}", timer.stop(),
                batchSize, batchTimes));
    }

    // ****************************************************************************************************************
    //
    // ****************************************************************************************************************

    @Test
    public void testInsertBatchHammer() {
        List<UserInfo2> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < batchTimes; i++) {
            for (int j = 0; j < batchSize; j++) {
                UserInfo2 userInfo2 = new UserInfo2();
                userInfo2.setId(null);
                userInfo2.setUserId(1);
                userInfo2.setName("yufei_" + index);
                userInfo2.setDescp("yufei_descp_" + index);
                userInfo2.setProvince("省_" + index);
                userInfo2.setCity("市_" + index);
                userInfo2.setDistrict("区_" + index);
                list.add(userInfo2);
                index++;
            }
        }

        Timer timer = Timer.start();
        hammer.save(list);
        System.out.println(Strings.format("testInsertBatchHammer use {0} time with insertBatch[{1}] times {2}",
                timer.stop(), batchSize, batchTimes));
    }
}
