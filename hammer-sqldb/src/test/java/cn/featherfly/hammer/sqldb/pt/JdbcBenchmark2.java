
/*
 * All rights Reserved, Designed By zhongj
 * @Title: HammerBenchmark.java
 * @Description: HammerBenchmark
 * @author: zhongj
 * @date: 2023-08-23 15:44:23
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.pt;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.dialect.Dialects;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.UserInfo2;

/**
 * The Class JdbcBenchmark.
 *
 * @author zhongj
 */
@Test
public class JdbcBenchmark2 extends AbstractBenchmark {

    final String insertSql = "insert into `user_info` (`id`, `user_id`, `name`, `descp`, `province`, `city`, `district`) values(?,?,?,?,?,?,?)";

    final String selectUserInfoByIdSql = "select `id`, `user_id` , `name`, `descp`, `province`, `city`, `district` from `user_info` where `id` = ?";

    Connection conn;

    @BeforeClass
    public void before() {
        conn = JdbcUtils.getConnection(dataSource);
        //        System.out.println("connection.open");
    }

    @AfterClass
    public void after() {
        JdbcUtils.close(conn);
        //        System.out.println("connection.close");
    }

    /**
     * {@inheritDoc}
     *
     * @throws SQLException
     */
    @Override
    protected void doInsertOne(UserInfo2 userInfo) {
        //        ConnectionWrapper conn = JdbcUtils.getConnectionWrapper(dataSource);
        try {
            PreparedStatement prep = conn.prepareStatement(insertSql);
            prep.setObject(1, userInfo.getId());
            prep.setInt(2, userInfo.getUserId());
            prep.setString(3, userInfo.getName());
            prep.setString(4, userInfo.getDescp());
            prep.setString(5, userInfo.getProvince());
            prep.setString(6, userInfo.getCity());
            prep.setString(7, userInfo.getDistrict());
            prep.executeUpdate();
            prep.close();
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
        //        conn.close();
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    protected void doInsertOne(List<UserInfo2> userInfos) {
    //        for (UserInfo2 userInfo : userInfos) {
    //            doInsertOne(userInfo);
    //        }
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doInsertBatch(List<UserInfo2> userInfos) {
        String insertSql = Dialects.MYSQL.buildInsertSql("user_info",
            new String[] { "id", "user_id", "name", "descp", "province", "city", "district" });
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
            prep.executeUpdate();
            prep.close();
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
        //        conn.close();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getName() {
        return "jdbc";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected UserInfo2 doSelectById(Serializable id) {
        try {
            return doSelectById(id, conn.prepareStatement(selectUserInfoByIdSql));
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected List<UserInfo2> doSelectById(Serializable... ids) {
        List<UserInfo2> list = new ArrayList<>();
        for (Serializable id : ids) {
            //            list.add(doSelectById(id));
            try {
                list.add(doSelectById(id, conn.prepareStatement(selectUserInfoByIdSql)));
            } catch (SQLException e) {
                throw new JdbcException(e);
            }
        }
        return list;
    }

    private UserInfo2 doSelectById(Serializable id, PreparedStatement prep) {
        try {
            prep.setInt(1, (int) id);
            ResultSet res = prep.executeQuery();
            UserInfo2 userInfo = new UserInfo2();
            if (res.next()) {
                userInfo.setId(res.getInt(1));
                userInfo.setUserId(res.getInt(2));
                userInfo.setName(res.getString(3));
                userInfo.setDescp(res.getString(4));
                userInfo.setProvince(res.getString(5));
                userInfo.setCity(res.getString(6));
                userInfo.setDistrict(res.getString(7));
            }
            res.close();
            return userInfo;
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }
}
