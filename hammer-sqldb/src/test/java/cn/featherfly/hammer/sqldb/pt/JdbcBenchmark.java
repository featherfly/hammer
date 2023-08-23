
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
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.dialect.Dialects;
import cn.featherfly.common.db.wrapper.ConnectionWrapper;
import cn.featherfly.common.db.wrapper.PreparedStatementWrapper;
import cn.featherfly.common.db.wrapper.ResultSetWrapper;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.UserInfo2;

/**
 * The Class JdbcBenchmark.
 *
 * @author zhongj
 */
@Test
public class JdbcBenchmark extends AbstractBenchmark {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doInsertOne(UserInfo2 userInfo) {
        String insertSql = "insert into `user_info` (`id`, `user_id`, `name`, `descp`, `province`, `city`, `district`) values(?,?,?,?,?,?,?)";
        ConnectionWrapper conn = JdbcUtils.getConnectionWrapper(dataSource);
        int index = 0;
        PreparedStatementWrapper prep = conn.prepareStatement(insertSql);
        prep.setObject(1, null);
        prep.setInt(2, 1);
        prep.setString(3, "yufei_" + index);
        prep.setString(4, "yufei_descp_" + index);
        prep.setString(5, "省_" + index);
        prep.setString(6, "市_" + index);
        prep.setString(7, "区_" + index);
        prep.executeUpdate();
        prep.close();
        conn.close();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doInsertOne(List<UserInfo2> userInfos) {
        for (UserInfo2 userInfo : userInfos) {
            doInsertOne(userInfo);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doInsertBatch(List<UserInfo2> userInfo) {
        String insertSql = Dialects.MYSQL.buildInsertBatchSql("user_info",
                new String[] { "id", "user_id", "name", "descp", "province", "city", "district" }, userInfo.size());
        ConnectionWrapper conn = JdbcUtils.getConnectionWrapper(dataSource);
        int total = 0;
        PreparedStatementWrapper prep = conn.prepareStatement(insertSql);
        for (int index = 0; index < userInfo.size(); index++) {
            prep.setObject(++total, null);
            prep.setInt(++total, 1);
            prep.setString(++total, "yufei2_" + index);
            prep.setString(++total, "yufei2_descp_" + index);
            prep.setString(++total, "省2_" + index);
            prep.setString(++total, "市2_" + index);
            prep.setString(++total, "区2_" + index);
        }
        prep.executeUpdate();
        prep.close();
        conn.close();
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
        String selectSql = "select `id`, `user_id` , `name`, `descp`, `province`, `city`, `district` from `user_info` where `id` = ?";
        ConnectionWrapper conn = JdbcUtils.getConnectionWrapper(dataSource);
        PreparedStatementWrapper prep = conn.prepareStatement(selectSql);
        prep.setInt(1, (int) id);
        ResultSetWrapper res = prep.executeQuery();
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
        prep.close();
        conn.close();

        return userInfo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected List<UserInfo2> doSelectById(Serializable... ids) {
        List<UserInfo2> list = new ArrayList<>();
        for (Serializable id : ids) {
            list.add(doSelectById(id));
        }
        return list;
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
