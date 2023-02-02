
/*
 * All rights Reserved, Designed By zhongj
 * @Title: SqlUpdaterTest.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.execute
 * @Description: SqlUpdaterTest
 * @author: zhongj
 * @date: 2023-02-10 16:28:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import static org.testng.Assert.assertEquals;

import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.lang.Dates;
import cn.featherfly.common.lang.Randoms;
import cn.featherfly.common.lang.Randoms.CharType;
import cn.featherfly.common.repository.IgnorePolicy;
import cn.featherfly.common.repository.SimpleRepository;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.vo.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.User;

/**
 * SqlUpdaterTest.
 *
 * @author zhongj
 */
public class SqlUpdaterTest extends JdbcTestBase {

    SqlUpdater sqlUpdater;

    @BeforeClass
    void setup() {
        sqlUpdater = new SqlUpdater(jdbc, mappingFactory);
    }

    @Test(expectedExceptions = SqldbHammerException.class)
    public void testException() {
        new SqlUpdater(jdbc).update(User.class);
    }

    @Test
    public void testUpdateSet() {
        int id = 10;
        String updated = "descp_1122";
        int result = sqlUpdater.update("role").set("descp", updated).where().eq("id", id).execute();
        assertEquals(result, 1);

        String descp = jdbc.queryString("select descp from role where  id = ?", id);
        assertEquals(descp, updated);
    }

    @Test
    public void testUpdateSet2() {
        int id = 10;
        String updated = "descp_1122";
        int result = sqlUpdater.update(new SimpleRepository("role")).set("descp", updated).where().eq("id", id)
                .execute();
        assertEquals(result, 1);

        String descp = jdbc.queryString("select descp from role where  id = ?", id);
        assertEquals(descp, updated);
    }

    @Test
    public void testUpdateSet3() {
        String strDate = Dates.formatTime(new Date());
        Long count = hammer.query(Role.class).count();
        int result = sqlUpdater.update("role").set("create_time", strDate).execute();
        assertEquals(result, count.intValue());

        String createTime = jdbc.queryString("select create_time from role where  id = ?", 1);
        assertEquals(createTime, strDate);
    }

    @Test
    public void testUpdateSet4() {
        User user = user();
        hammer.save(user);

        int setAge = 20;
        sqlUpdater.update("user").set(User::getAge, setAge).where().eq("id", user.getId()).execute();
        User load = hammer.get(user);
        assertEquals(load.getAge().intValue(), setAge);

        sqlUpdater.update("user").set(user::getAge).where().eq("id", user.getId()).execute();
        load = hammer.get(user);
        assertEquals(load.getAge(), user.getAge());

        hammer.delete(user);
    }

    @Test
    public void testUpdateSet5() {
        User user = user();
        hammer.save(user);

        int setAge = 20;
        sqlUpdater.update("user").set(c -> c.set(User::getAge, setAge)).where().eq("id", user.getId()).execute();
        User load = hammer.get(user);
        assertEquals(load.getAge().intValue(), setAge);

        hammer.delete(user);
    }

    @Test
    public void testUpdateSetIgnore() {
        String strDate = Dates.formatTime(new Date());
        Long count = hammer.query(Role.class).count();
        int result = sqlUpdater.update("role").set("create_time", strDate)
                .where(c -> c.setIgnorePolicy(IgnorePolicy.EMPTY)).eq("id", null).execute();
        assertEquals(result, count.intValue());

        String createTime = jdbc.queryString("select create_time from role where  id = ?", 1);
        assertEquals(createTime, strDate);

        result = sqlUpdater.update("role").set("create_time", strDate).where(c -> c.setIgnorePolicy(IgnorePolicy.NONE))
                .eq("id", null).execute();
        assertEquals(result, 0);
    }

    @Test
    public void testUpdatePropertySet() {
        User user = user();
        hammer.save(user);

        int setAge = 18;
        sqlUpdater.update("user").property(User::getAge).set(setAge).where().eq("id", user.getId()).execute();
        User load = hammer.get(user);
        assertEquals(load.getAge().intValue(), setAge);

        hammer.delete(user);
    }

    @Test
    public void testUpdatePropertyIncrease() {
        User user = user();
        hammer.save(user);

        sqlUpdater.update("user").propertyNumber(User::getAge).increase(1).where().eq("id", user.getId()).execute();

        User load = hammer.get(user);
        assertEquals(load.getAge().intValue(), 19);

        hammer.delete(user);
    }

    @Test
    public void testUpdateIncrease() {
        User user = user();
        hammer.save(user);

        sqlUpdater.update("user").increase(User::getAge, 1).where().eq("id", user.getId()).execute();

        User load = hammer.get(user);
        assertEquals(load.getAge().intValue(), 19);

        sqlUpdater.update("user").increase(user::getAge).where().eq("id", user.getId()).execute();
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), 19 + user.getAge());

        hammer.delete(user);
    }

    User user() {
        User user = new User();
        user.setUsername("name_testUpdate4" + Randoms.getInt(100));
        user.setPwd("123456");
        user.setMobileNo(Randoms.getString(11, CharType.NUMBER_CASE));
        user.setAge(18);
        return user;
    }
}
