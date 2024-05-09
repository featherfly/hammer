
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
import cn.featherfly.common.db.NamedParamSql;
import cn.featherfly.common.db.dialect.Dialects;
import cn.featherfly.common.exception.UnsupportedException;
import cn.featherfly.common.repository.Execution;
import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.UserInfo2;

/**
 * The Class JdbcBenchmark.
 *
 * @author zhongj
 */
@Test
public class JdbcBenchmark extends AbstractBenchmark {

    final String insertSql = "insert into `user_info` (`id`, `user_id`, `name`, `descp`, `province`, `city`, `district`) values(?,?,?,?,?,?,?)";

    final String deleteSql = "delete from `user_info` where id = ?";

    final String updateSql = "update `user_info` set  descp = CONCAT(descp, '_update') where id = ?";

    final NamedParamSql deleteSqlBatch = NamedParamSql.compile("delete from `user_info` where id in :ids");

    final String selectUserInfoByIdSql = "select `id`, `user_id` , `name`, `descp`, `province`, `city`, `district` from `user_info` where `id` = ?";

    Connection conn;

    @BeforeClass
    public void before() {
        conn = JdbcUtils.getConnection(dataSource);
    }

    @AfterClass
    public void after() {
        JdbcUtils.close(conn);
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
        String insertSql = Dialects.MYSQL.buildInsertBatchSql("user_info",
                new String[] { "id", "user_id", "name", "descp", "province", "city", "district" }, userInfos.size());
        //        ConnectionWrapper conn = JdbcUtils.getConnectionWrapper(dataSource);
        try {
            int total = 0;
            PreparedStatement prep = conn.prepareStatement(insertSql);
            for (int index = 0; index < userInfos.size(); index++) {
                UserInfo2 userInfo = userInfos.get(index);
                prep.setObject(++total, userInfo.getId());
                prep.setInt(++total, userInfo.getUserId());
                prep.setString(++total, userInfo.getName());
                prep.setString(++total, userInfo.getDescp());
                prep.setString(++total, userInfo.getProvince());
                prep.setString(++total, userInfo.getCity());
                prep.setString(++total, userInfo.getDistrict());
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
        //        String selectSql = "select `id`, `user_id` , `name`, `descp`, `province`, `city`, `district` from `user_info` where `id` = ?";
        //        ConnectionWrapper conn = JdbcUtils.getConnectionWrapper(dataSource);
        try {
            return doSelectById(id, conn.prepareStatement(selectUserInfoByIdSql));
            //            PreparedStatement prep = conn.prepareStatement(selectUserInfoByIdSql);
            //            ResultSet res = prep.executeQuery();
            //            UserInfo2 userInfo = new UserInfo2();
            //            if (res.next()) {
            //                userInfo.setId(res.getInt(1));
            //                userInfo.setUserId(res.getInt(2));
            //                userInfo.setName(res.getString(3));
            //                userInfo.setDescp(res.getString(4));
            //                userInfo.setProvince(res.getString(5));
            //                userInfo.setCity(res.getString(6));
            //                userInfo.setDistrict(res.getString(7));
            //            }
            //            res.close();
            //            prep.close();
            //            return userInfo;
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
        //        conn.close();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected int[] doDeleteById(boolean batch, Serializable... ids) {
        if (batch) {
            Execution exec = deleteSqlBatch.getExecution(new ChainMapImpl<String, Object>().putChain("ids", ids));
            try (PreparedStatement prep = conn.prepareStatement(exec.getExecution())) {
                for (int i = 0; i < ids.length; i++) {
                    Serializable id = ids[i];
                    prep.setInt(i + 1, (Integer) id);
                }
                return new int[] { prep.executeUpdate() };
            } catch (SQLException e) {
                throw new JdbcException(e);
            }
        } else {
            int[] res = new int[ids.length];
            for (int i = 0; i < res.length; i++) {
                try (PreparedStatement prep = conn.prepareStatement(deleteSql)) {
                    Serializable id = ids[i];
                    prep.setInt(1, (Integer) id);
                    res[i] = prep.executeUpdate();
                } catch (SQLException e) {
                    throw new JdbcException(e);
                }
            }
            return res;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected int[] doUpdateById(boolean batch, Serializable... ids) {
        if (batch) {
            throw new UnsupportedException("不支持批量更新优化为一个sql");
        } else {
            int[] res = new int[ids.length];
            for (int i = 0; i < res.length; i++) {
                try (PreparedStatement prep = conn.prepareStatement(updateSql)) {
                    Serializable id = ids[i];
                    prep.setInt(1, (Integer) id);
                    res[i] = prep.executeUpdate();
                } catch (SQLException e) {
                    throw new JdbcException(e);
                }
            }
            return res;
        }
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    protected List<UserInfo2> doSelectById(Serializable... ids) {
    //        List<UserInfo2> list = new ArrayList<>();
    //        StringBuilder selectSql = new StringBuilder(
    //                "select `id`, `user_id` , `name`, `descp`, `province`, `city`, `district` from `user_info` where `id` in (");
    //        for (int i = 0; i < ids.length; i++) {
    //            selectSql.append("?,");
    //        }
    //        selectSql.replace(selectSql.length() - 1, selectSql.length(), ")");
    //
    //        ConnectionWrapper conn = JdbcUtils.getConnectionWrapper(dataSource);
    //        PreparedStatementWrapper prep = conn.prepareStatement(selectSql.toString());
    //        for (int i = 0; i < ids.length; i++) {
    //            prep.setInt(i + 1, (Integer) ids[i]);
    //        }
    //        ResultSetWrapper res = prep.executeQuery();
    //        while (res.next()) {
    //            UserInfo2 userInfo = new UserInfo2();
    //            userInfo.setId(res.getInt(1));
    //            userInfo.setUserId(res.getInt(2));
    //            userInfo.setName(res.getString(3));
    //            userInfo.setDescp(res.getString(4));
    //            userInfo.setProvince(res.getString(5));
    //            userInfo.setCity(res.getString(6));
    //            userInfo.setDistrict(res.getString(7));
    //            list.add(userInfo);
    //        }
    //        return list;
    //    }
}
