
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
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import org.testng.annotations.Test;

import cn.featherfly.common.db.model.SimpleTable;
import cn.featherfly.common.lang.Dates;
import cn.featherfly.common.lang.Randoms;
import cn.featherfly.common.lang.Randoms.CharType;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.SimpleRepository;
import cn.featherfly.hammer.config.dsl.EmptyConditionStrategy;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;

/**
 * SqlUpdaterTest.
 *
 * @author zhongj
 */
public class SqlUpdaterTest extends AbstractUpdaterTest {

    //    @Test(expectedExceptions = SqldbHammerException.class)
    //    public void testException() {
    //        new SqlUpdater(jdbc, metadata, hammerConfig.getDslConfig().getUpdateConfig()).update(User.class);
    //    }

    @Test
    public void testUpdateSet() {
        int id = 10;
        String updated = "descp_1122";
        SimpleTable table = new SimpleTable();
        table.setName("role");
        int result = updater.update("role").set("descp", updated).where().eq("id", id).execute();
        assertEquals(result, 1);

        String descp = jdbc.queryString("select descp from role where  id = ?", id);
        assertEquals(descp, updated);

        result = updater.update(table).set("descp", updated, v -> false).where().eq("id", id).execute();
        assertEquals(result, 1);

        result = updater.update(table).set("descp", NOT_MODIFY, v -> true).where().eq("id", id).execute();
        assertEquals(result, 0);

        descp = jdbc.queryString("select descp from role where  id = ?", id);
        assertEquals(descp, updated);
    }

    @Test
    public void testUpdateSet2() {
        int id = 10;
        String updated = "descp_1122";
        int result = updater.update(new SimpleRepository("role")).set("descp", updated).where().eq("id", id).execute();
        assertEquals(result, 1);

        String descp = jdbc.queryString("select descp from role where  id = ?", id);
        assertEquals(descp, updated);
    }

    @Test
    public void testUpdateSet3() {
        String strDate = Dates.formatTime(new Date());
        Long count = hammer.query(Role.class).count();
        int result = updater.update("role").set("create_time", strDate).execute();
        assertEquals(result, 0);

        result = updater.update("role") //
            .configure(c -> c.setEmptyConditionStrategy(EmptyConditionStrategy.EXECUTION)) //
            .set("create_time", strDate) //
            .execute();
        assertEquals(result, count.intValue());

        String createTime = jdbc.queryString("select create_time from role where  id = ?", 1);
        assertEquals(createTime, strDate);
    }

    @Test
    public void testUpdateSet4() {
        User user = user();
        hammer.save(user);

        int setAge = 20;
        updater.update("user").set(User::getAge, setAge).where().eq("id", user.getId()).execute();
        User load = hammer.get(user);
        assertEquals(load.getAge().intValue(), setAge);

        updater.update("user").set(user::getAge).where().eq("id", user.getId()).execute();
        load = hammer.get(user);
        assertEquals(load.getAge(), user.getAge());

        int result = updater.update("user").set(User::getAge, 1000, v -> true).where().eq("id", user.getId()).execute();
        assertEquals(result, 0);

        result = updater.update("user").set(user::getAge, v -> true).where().eq("id", user.getId()).execute();
        assertEquals(result, 0);

        result = updater.update("user").set(User::getAge, 1, v -> false).where().eq("id", user.getId()).execute();
        assertEquals(result, 1);

        result = updater.update("user").set(user::getAge, v -> false).where().eq("id", user.getId()).execute();
        assertEquals(result, 1);

        hammer.delete(user);
    }

    @Test
    public void testUpdateSet5() {
        User user = user();
        hammer.save(user);

        int setAge = 20;
        updater.update("user").set(c -> c.set(User::getAge, setAge)).where().eq("id", user.getId()).execute();
        User load = hammer.get(user);
        assertEquals(load.getAge().intValue(), setAge);

        hammer.delete(user);
    }

    @Test
    public void testUpdateSetIgnore() {
        String strDate = Dates.formatTime(new Date());
        Long count = hammer.query(Role.class).count();
        int result = updater.update("role").set("create_time", strDate).where().configure(
            c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY).setEmptyConditionStrategy(EmptyConditionStrategy.EXECUTION))
            .eq("id", (Serializable) null).execute();
        assertEquals(result, count.intValue());

        String createTime = jdbc.queryString("select create_time from role where  id = ?", 1);
        assertEquals(createTime, strDate);

        result = updater.update("role").set("create_time", strDate).where().configure(
            c -> c.setIgnoreStrategy(IgnoreStrategy.NONE).setEmptyConditionStrategy(EmptyConditionStrategy.EXECUTION))
            .eq("id", (Serializable) null).execute();
        assertEquals(result, 0);

        result = updater.update("role").set("create_time", strDate).where()
            .configure(c -> c.setIgnoreStrategy(IgnoreStrategy.NONE)).eq("id", (Serializable) null).execute();
        assertEquals(result, 0);
    }

    @Test
    public void testUpdatePropertySet() {
        User user = user();
        hammer.save(user);

        int setAge = 18;
        updater.update("user").field(User::getAge).set(setAge).where().eq("id", user.getId()).execute();
        User load = hammer.get(user);
        assertEquals(load.getAge().intValue(), setAge);

        hammer.delete(user);
    }

    @Test
    public void testUpdatePropertyIncrease() {
        User user = user();
        hammer.save(user);

        updater.update("user").fieldAsNumber(User::getAge).increase(1).where().eq("id", user.getId()).execute();

        User load = hammer.get(user);
        assertEquals(load.getAge().intValue(), 19);

        hammer.delete(user);
    }

    @Test
    public void testUpdateIncrease() {
        User user = user();
        hammer.save(user);
        AtomicInteger age = new AtomicInteger(18);

        int result = updater.update("user").increase("age", 1).where().eq("id", user.getId()).execute();
        assertEquals(result, 1);
        User load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.addAndGet(1));

        result = updater.update("user").increase("age", 1, v -> true).where().eq("id", user.getId()).execute();
        assertEquals(result, 0);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.get());

        result = updater.update("user").increase("age", 1, v -> false).where().eq("id", user.getId()).execute();
        assertEquals(result, 1);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.addAndGet(1));

        // -----------------------------------------------------------------------

        result = updater.update("user").increase(User::getAge, 1).where().eq("id", user.getId()).execute();
        assertEquals(result, 1);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.addAndGet(1));

        result = updater.update("user").increase(User::getAge, 1, v -> true).where().eq("id", user.getId()).execute();
        assertEquals(result, 0);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.get());

        result = updater.update("user").increase(User::getAge, 1, v -> false).where().eq("id", user.getId()).execute();
        assertEquals(result, 1);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.addAndGet(1));

        // -----------------------------------------------------------------------

        result = updater.update("user").increase(user::getAge).where().eq("id", user.getId()).execute();
        assertEquals(result, 1);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.addAndGet(user.getAge()));

        result = updater.update("user").increase(user::getAge, v -> true).where().eq("id", user.getId()).execute();
        assertEquals(result, 0);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.get());

        result = updater.update("user").increase(user::getAge, v -> false).where().eq("id", user.getId()).execute();
        assertEquals(result, 1);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.addAndGet(user.getAge()));

        hammer.delete(user);
    }

    @Test
    public void testUpdateGroupablCondition() {
        User user = user();
        hammer.save(user);

        updater.update("user").increase("age", 1).where()//
            .eq(User::getId, user.getId())//
            .and().group().eq("password", user.getPwd()) //
            .and().eq("mobile_no", user.getMobileNo()) //
            .endGroup() //
            .execute();

        User load = hammer.get(user);
        assertEquals(load.getAge().intValue(), 19);

        updater.update("user").increase("age", user.getAge()).where().eq(User::getId, user.getId()).and().group()
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
        int result = updater.update(Role.class).set(Role::getDescp, updated).where().eq(Role::getId, id).execute();
        assertEquals(result, 1);
        result = updater.update(Role.class).set(Role::getDescp, updated).where(role -> role.eq(Role::getId, id))
            .execute();
        assertEquals(result, 1);

        String descp = jdbc.queryString(selectDescpSql, id);
        assertEquals(descp, updated);

        result = updater.update(Role.class).set(Role::getDescp, NOT_MODIFY, v -> true).where().eq(Role::getId, id)
            .execute();
        assertEquals(result, 0);

        updated = "descp_testUpdateEntitySet2";
        result = updater.update(Role.class).set(Role::getDescp, updated, v -> false).where().eq(Role::getId, id)
            .execute();
        assertEquals(result, 1);

        descp = jdbc.queryString(selectDescpSql, id);
        assertEquals(descp, updated);

        // -----------------------------------------------------------------------------------------------------------

        Role updatedRole = new Role(id);
        updated = "descp_testUpdateEntitySet3";
        updatedRole.setDescp(updated);

        result = updater.update(Role.class).set(updatedRole::getDescp).where().eq(Role::getId, id).execute();
        assertEquals(result, 1);
        descp = jdbc.queryString(selectDescpSql, id);
        assertEquals(descp, updatedRole.getDescp());

        updatedRole.setDescp("descp_testUpdateEntitySet4");
        result = updater.update(Role.class).set(updatedRole::getDescp, (Predicate<String>) v -> true) //
            .where().eq(Role::getId, id) //
            .execute();
        assertEquals(result, 0);
        descp = jdbc.queryString(selectDescpSql, id);
        assertEquals(descp, updated);

        result = updater.update(Role.class).set(updatedRole::getDescp, (Predicate<String>) v -> false) //
            .where().eq(Role::getId, id).execute();
        assertEquals(result, 1);
        descp = jdbc.queryString(selectDescpSql, id);
        assertEquals(descp, updatedRole.getDescp());

    }

    @Test
    public void testUpdateEntityIncrease() {
        User user = user();
        hammer.save(user);

        AtomicInteger age = new AtomicInteger(18);

        int result = updater.update(User.class).increase(User::getAge, 1).where().eq(User::getId, user.getId())
            .execute();
        assertEquals(result, 1);
        User load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.addAndGet(1));

        result = updater.update(User.class).increase(User::getAge, 1, v -> true).where().eq(User::getId, user.getId())
            .execute();
        assertEquals(result, 0);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.intValue());

        result = updater.update(User.class).increase(User::getAge, 1, v -> false).where().eq(User::getId, user.getId())
            .execute();
        assertEquals(result, 1);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.addAndGet(1));

        // ------------------------------------------------------------------------------------------

        result = updater.update(User.class).increase(user::getAge).where().eq(User::getId, user.getId()).execute();
        assertEquals(result, 1);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.addAndGet(user.getAge()));

        result = updater.update(User.class).increase(user::getAge, (Predicate<Integer>) v -> true).where()
            .eq(User::getId, user.getId()).execute();
        assertEquals(result, 0);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.intValue());

        result = updater.update(User.class).increase(user::getAge, (Predicate<Integer>) v -> false).where()
            .eq(User::getId, user.getId()).execute();
        assertEquals(result, 1);
        load = hammer.get(user);
        assertEquals(load.getAge().intValue(), age.addAndGet(user.getAge()));

        hammer.delete(user);
    }

    //    @Test
    //    public void test111() {
    //        UserInfo ui = hammer.get(1, UserInfo.class);
    //        assertNotNull(ui);
    //        assertNotNull(ui.getUser());
    //        assertNotNull(ui.getUser().getId());
    //
    //        int result = hammer.update(UserInfo.class).set(UserInfo::getUser, User::getId, null).where()
    //                .eq(UserInfo::getId, ui.getId()).execute();
    //        assertEquals(result, 1);
    //    }

    @Test
    public void testUpdateEntitySetNestedProperty() {
        UserInfo ui = hammer.get(1, UserInfo.class);
        assertNotNull(ui);
        assertNotNull(ui.getUser());
        assertNotNull(ui.getUser().getId());

        int newUserId = 2;
        int newUserId2 = 3;
        String newDescp = "newDescp_" + Randoms.getInt(100);
        String newDescp2 = "newDescp2_" + Randoms.getInt(100);

        // set value
        int result = hammer.update(UserInfo.class).set(UserInfo::getUser, User::getId, newUserId).where()
            .eq(UserInfo::getId, ui.getId()).execute();
        assertEquals(result, 1);
        UserInfo load = hammer.get(ui.getId(), UserInfo.class);
        assertNotNull(load);
        assertNotNull(load.getUser());
        assertNotNull(load.getUser().getId());
        assertEquals(load.getUser().getId().intValue(), newUserId);

        result = hammer.update(UserInfo.class) //
            .set(UserInfo::getDescp, newDescp) //
            .set(UserInfo::getUser, User::getId, newUserId2, v -> true) //
            .where().eq(UserInfo::getId, ui.getId()).execute();
        assertEquals(result, 1);
        load = hammer.get(ui.getId(), UserInfo.class);
        assertNotNull(load);
        assertNotNull(load.getUser());
        assertNotNull(load.getUser().getId());
        assertEquals(load.getUser().getId().intValue(), newUserId);
        assertEquals(load.getDescp(), newDescp);

        result = hammer.update(UserInfo.class).set(UserInfo::getUser, User::getId, newUserId2, v -> false).where()
            .eq(UserInfo::getId, ui.getId()).execute();
        assertEquals(result, 1);
        load = hammer.get(ui.getId(), UserInfo.class);
        assertNotNull(load);
        assertNotNull(load.getUser());
        assertNotNull(load.getUser().getId());
        assertEquals(load.getUser().getId().intValue(), newUserId2);

        // ---------------------------------------------------------------------------------------------------------------

        User user = new User(newUserId);
        UserInfo userInfo = new UserInfo();
        userInfo.setUser(user);

        result = hammer.update(UserInfo.class).set(userInfo::getUser, User::getId).where()
            .eq(UserInfo::getId, ui.getId()).execute();
        assertEquals(result, 1);
        load = hammer.get(ui.getId(), UserInfo.class);
        assertNotNull(load);
        assertNotNull(load.getUser());
        assertNotNull(load.getUser().getId());
        assertEquals(load.getUser().getId().intValue(), user.getId().intValue());
        assertEquals(load.getUser().getId().intValue(), newUserId);

        userInfo.setUser(new User(newUserId2));
        result = hammer.update(UserInfo.class).set(userInfo::getUser, User::getId, v -> false).where()
            .eq(UserInfo::getId, ui.getId()).execute();
        assertEquals(result, 1);
        load = hammer.get(ui.getId(), UserInfo.class);
        assertNotNull(load);
        assertNotNull(load.getUser());
        assertNotNull(load.getUser().getId());
        assertEquals(load.getUser().getId().intValue(), newUserId2);

        userInfo.setDescp(newDescp2);
        result = hammer.update(UserInfo.class) //
            .set(userInfo::getDescp) //
            .set(userInfo::getUser, User::getId, v -> true) //
            .where().eq(UserInfo::getId, ui.getId()).execute();
        assertEquals(result, 1);
        load = hammer.get(ui.getId(), UserInfo.class);
        assertNotNull(load);
        assertNotNull(load.getUser());
        assertNotNull(load.getUser().getId());
        assertEquals(load.getDescp(), userInfo.getDescp());
        assertEquals(load.getDescp(), newDescp2);

        // --------------------------------------------------------------------------------------------------------------

        // set null value
        result = hammer.update(UserInfo.class) //
            .set(UserInfo::getUser, User::getId, null, v -> false) //
            .where().eq(UserInfo::getId, ui.getId()).execute();
        assertEquals(result, 1);

        load = hammer.get(1, UserInfo.class);
        assertNotNull(load);
        assertNotNull(load.getUser());
        assertNull(load.getUser().getId());

        result = hammer.update(UserInfo.class) //
            .set(UserInfo::getUser, User::getId, null, v -> false).where().eq(UserInfo::getId, ui.getId()).execute();
        assertEquals(result, 1);

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

        result = hammer.update(UserInfo.class).set(UserInfo::getDescp, ui.getDescp()) //
            .set(UserInfo::getUser, User::getId, ui.getUser().getId()) //
            .where().eq(UserInfo::getId, ui.getId()).execute();
        assertEquals(result, 1);
        load = hammer.get(1, UserInfo.class);
        assertNotNull(load);
        assertNotNull(load.getUser());
        assertNotNull(load.getUser().getId());
        assertEquals(load.getUser().getId(), ui.getUser().getId());
        assertEquals(load.getDescp(), ui.getDescp());

        result = hammer.update(UserInfo.class).set(UserInfo::getUser, User::getId, ui.getUser().getId(), v -> false)
            .where().eq(UserInfo::getId, ui.getId()).execute();
        assertEquals(result, 1);

        load = hammer.get(1, UserInfo.class);
        assertNotNull(load);
        assertNotNull(load.getUser());
        assertNotNull(load.getUser().getId());
        assertEquals(load.getUser().getId(), ui.getUser().getId());

    }

    @Test
    public void testUpdateEntitySetIgnore() {
        Long count = hammer.query(Role.class).count();

        //        String strDate = Dates.formatTime(new Date());
        LocalDateTime now = LocalDateTime.now();

        int result = updater.update(Role.class).set(Role::getCreateTime, now).execute();
        assertEquals(result, 0);

        result = updater.update(Role.class)
            .configure(c -> c.setEmptyConditionStrategy(EmptyConditionStrategy.EXECUTION)).set(Role::getCreateTime, now)
            .execute();
        assertEquals(result, count.intValue());

        result = updater.update(Role.class).set(Role::getCreateTime, now).where().configure(
            c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY).setEmptyConditionStrategy(EmptyConditionStrategy.EXECUTION))
            .eq(Role::getId, null).execute();
        assertEquals(result, count.intValue());

        result = updater.update(Role.class).set(Role::getCreateTime, now).where()
            .configure(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)).eq(Role::getId, null).execute();
        assertEquals(result, 0);

        //        String createTime = jdbc.queryString("select create_time from role where  id = ?", 1);
        LocalDateTime createTime = jdbc.queryValue("select create_time from role where  id = ?", LocalDateTime.class,
            1);
        assertEquals(Dates.formatTime(createTime), Dates.formatTime(now));

        result = updater.update(Role.class).set(Role::getCreateTime, now).where()
            .configure(c -> c.setIgnoreStrategy(IgnoreStrategy.NONE)).eq(Role::getId, null).execute();
        assertEquals(result, 0);
    }

    @Test
    public void testUpdateEntityGroupablCondition() {
        User user = user();
        hammer.save(user);

        updater.update(User.class).increase(User::getAge, 1).where().eq(User::getId, user.getId()).and().group()
            .eq(user::getPwd).and().eq(user::getMobileNo).endGroup().execute();

        User load = hammer.get(user);
        assertEquals(load.getAge().intValue(), 19);

        updater.update(User.class).increase(user::getAge).where().eq(User::getId, user.getId()).and().group()
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
