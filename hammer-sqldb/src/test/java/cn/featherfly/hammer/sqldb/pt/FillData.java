
/*
 * All rights Reserved, Designed By zhongj
 * @Title: HammerBenchmark.java
 * @Description: HammerBenchmark
 * @author: zhongj
 * @date: 2023-08-23 15:44:23
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.pt;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.lang.Timer;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.UserInfo2;

/**
 * The Class JdbcBenchmark.
 *
 * @author zhongj
 */
@Test
public class FillData extends BenchmarkTestBase {

    final String insertSql = "insert into `user_info2` (`id`, `user_id`, `name`, `descp`, `province`, `city`, `district`) values(?,?,?,?,?,?,?)";

    Connection conn;

    @BeforeSuite
    @Parameters({ "dataBase", "url" })
    @Override
    public void init(@Optional("mysql") String dataBase,
            @Optional("jdbc:mysql://127.0.0.1:3306/hammer_jdbc?characterEncoding=utf8&useUnicode=true&useSSL=false&allowPublicKeyRetrieval=true&rewriteBatchedStatements=true&amp") String url)
            throws IOException {
        super.init(dataBase, url);
    }

    private int times = 100;
    private int batchSize = 50000;

    @BeforeClass
    public void before() {
        conn = JdbcUtils.getConnection(dataSource);
    }

    @AfterClass
    public void after() {
        JdbcUtils.close(conn);
    }

    public void insertBatch() {

        List<List<UserInfo2>> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < times; i++) {
            List<UserInfo2> userInfos = new ArrayList<>();
            for (int j = 0; j < batchSize; j++) {
                UserInfo2 userInfo = new UserInfo2();
                userInfo.setId(null);
                userInfo.setUserId(1);
                userInfo.setName("yufei_" + index);
                userInfo.setDescp("yufei_descp_" + index);
                userInfo.setProvince("省_" + index);
                userInfo.setCity("市_" + index);
                userInfo.setDistrict("区_" + index);
                userInfos.add(userInfo);
                index++;
            }
            list.add(userInfos);
        }

        TimeUnit unit = TimeUnit.MILLISECONDS;
        Timer timer = Timer.start(unit);
        for (List<UserInfo2> userInfos : list) {
            doInsertBatch(userInfos);
        }
        long time = timer.stop();
        System.out.println(Strings.format("FillData({0}) use {1} {2} with batchSize[{3}] {4} loop times",
                times * batchSize, time, unit, batchSize, times));
    }

    protected void doInsertBatch(List<UserInfo2> userInfos) {
        //        String insertSql = Dialects.MYSQL.buildInsertBatchSql("user_info",
        //                new String[] { "id", "user_id", "name", "descp", "province", "city", "district" }, userInfos.size());
        //        ConnectionWrapper conn = JdbcUtils.getConnectionWrapper(dataSource);
        try {
            PreparedStatement prep = conn.prepareStatement(insertSql);
            for (int index = 0; index < userInfos.size(); index++) {
                int total = 0;
                UserInfo2 userInfo = userInfos.get(index);
                prep.setObject(++total, userInfo.getId());
                prep.setInt(++total, userInfo.getUserId());
                prep.setString(++total, userInfo.getName());
                prep.setString(++total, userInfo.getDescp());
                prep.setString(++total, userInfo.getProvince());
                prep.setString(++total, userInfo.getCity());
                prep.setString(++total, userInfo.getDistrict());
                prep.addBatch();
            }
            prep.executeBatch();
            prep.close();
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
        //        conn.close();
    }
}
