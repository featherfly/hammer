
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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.testng.Assert.assertEquals;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.db.model.SimpleTable;
import cn.featherfly.common.lang.Dates;
import cn.featherfly.common.lang.Randoms;
import cn.featherfly.common.lang.Randoms.CharType;
import cn.featherfly.common.repository.IgnorePolicy;
import cn.featherfly.common.repository.SimpleRepository;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.HammerJdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.vo.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.UserInfo;

/**
 * SqlUpdaterTest.
 *
 * @author zhongj
 */
public class SqlUpdaterTest extends HammerJdbcTestBase {

    SqlUpdater sqlUpdater;

    final String NOT_MODIFY = "not_modify";

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
        SimpleTable table = new SimpleTable();
        table.setName("role");
        int result = sqlUpdater.update("role").set("descp", updated).where().eq("id", id).execute();
        assertEquals(result, 1);

        String descp = jdbc.queryString("select descp from role where  id = ?", id);
        assertEquals(descp, updated);

        result = sqlUpdater.update(table).set(() -> false, "descp", NOT_MODIFY).where().eq("id", id).execute();
        assertEquals(result, 0);

        result = sqlUpdater.update(table).set(() -> true, "descp", updated).where().eq("id", id).execute();
        assertEquals(result, 1);

        descp = jdbc.queryString("select descp from role where  id = ?", id);
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

        int result = sqlUpdater.update("user").set(() -> false, User::getAge, 1000).where().eq("id", user.getId())
                .execute();
        assertEquals(result, 0);

        result = sqlUpdater.update("user").set(() -> false, user::getAge).where().eq("id", user.getId()).execute();
        assertEquals(result, 0);

        result = sqlUpdater.update("user").set(() -> true, User::getAge, 1).where().eq("id", user.getId()).execute();
        assertEquals(result, 1);

        result = sqlUpdater.update("user").set(() -> true, user::getAge).where().eq("id", user.getId()).execute();
        assertEquals(result, 1);

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
        AtomicInteger age = new AtomicInteger(18);

        int result = sqlUpdater.update("user").increase("age", 1).where().eq("id", user.getId()).execute();
        assertEquals(result, 1);
        User load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.addAndGet(1));

        result = sqlUpdater.update("user").increase(() -> false, "age", 1).where().eq("id", user.getId()).execute();
        assertEquals(result, 0);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.get());

        result = sqlUpdater.update("user").increase(() -> true, "age", 1).where().eq("id", user.getId()).execute();
        assertEquals(result, 1);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.addAndGet(1));

        // -----------------------------------------------------------------------

        result = sqlUpdater.update("user").increase(User::getAge, 1).where().eq("id", user.getId()).execute();
        assertEquals(result, 1);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.addAndGet(1));

        result = sqlUpdater.update("user").increase(() -> false, User::getAge, 1).where().eq("id", user.getId())
                .execute();
        assertEquals(result, 0);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.get());

        result = sqlUpdater.update("user").increase(() -> true, User::getAge, 1).where().eq("id", user.getId())
                .execute();
        assertEquals(result, 1);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.addAndGet(1));

        // -----------------------------------------------------------------------

        result = sqlUpdater.update("user").increase(user::getAge).where().eq("id", user.getId()).execute();
        assertEquals(result, 1);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.addAndGet(user.getAge()));

        result = sqlUpdater.update("user").increase(() -> false, user::getAge).where().eq("id", user.getId()).execute();
        assertEquals(result, 0);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.get());

        result = sqlUpdater.update("user").increase(() -> true, user::getAge).where().eq("id", user.getId()).execute();
        assertEquals(result, 1);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.addAndGet(user.getAge()));

        hammer.delete(user);
    }

    @Test
    public void testUpdateGroupablCondition() {
        User user = user();
        hammer.save(user);

        sqlUpdater.update("user").increase("age", 1).where().eq(User::getId, user.getId()).and().group()
                .eq("password", user.getPwd()).and().eq("mobile_no", user.getMobileNo()).endGroup().execute();

        User load = hammer.get(user);
        assertEquals(load.getAge().intValue(), 19);

        sqlUpdater.update("user").increase("age", user.getAge()).where().eq(User::getId, user.getId()).and().group()
                .eq("password", user.getPwd()).and().eq("mobile_no", user.getMobileNo()).execute();

        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), 19 + user.getAge());

        hammer.delete(user);
    }

    @Test
    public void testUpdateEntitySet() {
        int id = 10;
        String selectDescpSql = "select descp from role where  id = ?";
        String updated = "descp_testUpdateEntitySet";
        int result = sqlUpdater.update(Role.class).set(Role::getDescp, updated).where().eq(Role::getId, id).execute();
        assertEquals(result, 1);

        String descp = jdbc.queryString(selectDescpSql, id);
        assertEquals(descp, updated);

        result = sqlUpdater.update(Role.class).set(() -> false, Role::getDescp, NOT_MODIFY).where().eq(Role::getId, id)
                .execute();
        assertEquals(result, 0);

        updated = "descp_testUpdateEntitySet2";
        result = sqlUpdater.update(Role.class).set(() -> true, Role::getDescp, updated).where().eq(Role::getId, id)
                .execute();
        assertEquals(result, 1);

        descp = jdbc.queryString(selectDescpSql, id);
        assertEquals(descp, updated);

        // -----------------------------------------------------------------------------------------------------------

        Role updatedRole = new Role(id);
        updated = "descp_testUpdateEntitySet3";
        updatedRole.setDescp(updated);

        result = sqlUpdater.update(Role.class).set(updatedRole::getDescp).where().eq(Role::getId, id).execute();
        assertEquals(result, 1);
        descp = jdbc.queryString(selectDescpSql, id);
        assertEquals(descp, updatedRole.getDescp());

        updatedRole.setDescp("descp_testUpdateEntitySet4");
        result = sqlUpdater.update(Role.class).set(() -> false, updatedRole::getDescp).where().eq(Role::getId, id)
                .execute();
        assertEquals(result, 0);
        descp = jdbc.queryString(selectDescpSql, id);
        assertEquals(descp, updated);

        result = sqlUpdater.update(Role.class).set(() -> true, updatedRole::getDescp).where().eq(Role::getId, id)
                .execute();
        assertEquals(result, 1);
        descp = jdbc.queryString(selectDescpSql, id);
        assertEquals(descp, updatedRole.getDescp());

    }

    @Test
    public void testUpdateEntityIncrease() {
        User user = user();
        hammer.save(user);

        AtomicInteger age = new AtomicInteger(18);

        int result = sqlUpdater.update(User.class).increase(User::getAge, 1).where().eq(User::getId, user.getId())
                .execute();
        assertEquals(result, 1);
        User load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.addAndGet(1));

        result = sqlUpdater.update(User.class).increase(() -> false, User::getAge, 1).where()
                .eq(User::getId, user.getId()).execute();
        assertEquals(result, 0);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.intValue());

        result = sqlUpdater.update(User.class).increase(() -> true, User::getAge, 1).where()
                .eq(User::getId, user.getId()).execute();
        assertEquals(result, 1);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.addAndGet(1));

        // ------------------------------------------------------------------------------------------

        result = sqlUpdater.update(User.class).increase(user::getAge).where().eq(User::getId, user.getId()).execute();
        assertEquals(result, 1);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.addAndGet(user.getAge()));

        result = sqlUpdater.update(User.class).increase(() -> false, user::getAge).where().eq(User::getId, user.getId())
                .execute();
        assertEquals(result, 0);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.intValue());

        result = sqlUpdater.update(User.class).increase(() -> true, user::getAge).where().eq(User::getId, user.getId())
                .execute();
        assertEquals(result, 1);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.addAndGet(user.getAge()));

        hammer.delete(user);
    }

    @Test
    public void testUpdateEntitySetNestedProperty() {
        UserInfo ui = hammer.get(1, UserInfo.class);
        assertNotNull(ui);
        assertNotNull(ui.getUser());
        assertNotNull(ui.getUser().getId());

        int newUserId = 2;

        // set value
        int result = hammer.update(UserInfo.class).set(UserInfo::getUser, User::getId, newUserId).where()
                .eq(UserInfo::getId, ui.getId()).execute();
        assertEquals(result, 1);
        UserInfo load = hammer.get(1, UserInfo.class);
        assertNotNull(load);
        assertNotNull(load.getUser());
        assertNotNull(load.getUser().getId());
        assertEquals(load.getUser().getId().intValue(), newUserId);

        result = hammer.update(UserInfo.class).set(() -> false, UserInfo::getUser, User::getId, newUserId).where()
                .eq(UserInfo::getId, ui.getId()).execute();
        assertEquals(result, 0);

        result = hammer.update(UserInfo.class).set(() -> true, UserInfo::getUser, User::getId, newUserId).where()
                .eq(UserInfo::getId, ui.getId()).execute();
        assertEquals(result, 1);

        // ---------------------------------------------------------------------------------------------------------------

        User user = new User(newUserId);
        UserInfo userInfo = new UserInfo();
        userInfo.setUser(user);

        result = hammer.update(UserInfo.class).set(userInfo::getUser, User::getId).where()
                .eq(UserInfo::getId, ui.getId()).execute();
        assertEquals(result, 1);
        load = hammer.get(1, UserInfo.class);
        assertNotNull(load);
        assertNotNull(load.getUser());
        assertNotNull(load.getUser().getId());
        assertEquals(load.getUser().getId().intValue(), user.getId().intValue());

        result = hammer.update(UserInfo.class).set(() -> false, userInfo::getUser, User::getId).where()
                .eq(UserInfo::getId, ui.getId()).execute();
        assertEquals(result, 0);

        result = hammer.update(UserInfo.class).set(() -> true, userInfo::getUser, User::getId).where()
                .eq(UserInfo::getId, ui.getId()).execute();
        assertEquals(result, 1);

        // --------------------------------------------------------------------------------------------------------------

        // set null value
        result = hammer.update(UserInfo.class).set(UserInfo::getUser, User::getId, null).where()
                .eq(UserInfo::getId, ui.getId()).execute();
        assertEquals(result, 1);

        load = hammer.get(1, UserInfo.class);
        assertNotNull(load);
        assertNotNull(load.getUser());
        assertNull(load.getUser().getId());

        result = hammer.update(UserInfo.class).set(() -> false, UserInfo::getUser, User::getId, null).where()
                .eq(UserInfo::getId, ui.getId()).execute();
        assertEquals(result, 0);

        //-------------------------------------------------------------------------------------------------------------

        result = hammer.update(UserInfo.class).set(UserInfo::getUser, User::getId, newUserId).where()
                .eq(UserInfo::getId, ui.getId()).execute();
        assertEquals(result, 1);
        load = hammer.get(1, UserInfo.class);
        assertNotNull(load);
        assertNotNull(load.getUser());
        assertNotNull(load.getUser().getId());

        userInfo.setUser(null);
        result = hammer.update(UserInfo.class).set(userInfo::getUser, User::getId).where()
                .eq(UserInfo::getId, ui.getId()).execute();

        load = hammer.get(1, UserInfo.class);
        assertNotNull(load);
        assertNotNull(load.getUser());
        assertNull(load.getUser().getId());

        //-------------------------------------------------------------------------------------------------------------

        // rollback changed value

        result = hammer.update(UserInfo.class).set(UserInfo::getUser, User::getId, ui.getUser().getId()).where()
                .eq(UserInfo::getId, ui.getId()).execute();
        assertEquals(result, 1);

        result = hammer.update(UserInfo.class).set(() -> false, UserInfo::getUser, User::getId, ui.getUser().getId())
                .where().eq(UserInfo::getId, ui.getId()).execute();
        assertEquals(result, 0);

        load = hammer.get(1, UserInfo.class);
        assertNotNull(load);
        assertNotNull(load.getUser());
        assertNotNull(load.getUser().getId());
        assertEquals(load.getUser().getId(), ui.getUser().getId());

    }

    @Test
    public void testUpdateEntitySetIgnore() {
        Long count = hammer.query(Role.class).count();

        String strDate = Dates.formatTime(new Date());

        int result = sqlUpdater.update(Role.class).set(Role::getCreateTime, strDate).execute();
        assertEquals(result, count.intValue());

        result = sqlUpdater.update(Role.class).set(Role::getCreateTime, strDate)
                .where(c -> c.setIgnorePolicy(IgnorePolicy.EMPTY)).eq(Role::getId, null).execute();
        assertEquals(result, count.intValue());

        String createTime = jdbc.queryString("select create_time from role where  id = ?", 1);
        assertEquals(createTime, strDate);

        result = sqlUpdater.update(Role.class).set(Role::getCreateTime, strDate)
                .where(c -> c.setIgnorePolicy(IgnorePolicy.NONE)).eq(Role::getId, null).execute();
        assertEquals(result, 0);
    }

    @Test
    public void testUpdateEntityGroupablCondition() {
        User user = user();
        hammer.save(user);

        sqlUpdater.update(User.class).increase(User::getAge, 1).where().eq(User::getId, user.getId()).and().group()
                .eq(user::getPwd).and().eq(user::getMobileNo).endGroup().execute();

        User load = hammer.get(user);
        assertEquals(load.getAge().intValue(), 19);

        sqlUpdater.update(User.class).increase(user::getAge).where().eq(User::getId, user.getId()).and().group()
                .eq(user::getPwd).and().eq(user::getMobileNo).execute();

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
