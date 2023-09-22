
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.testng.annotations.Test;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Address;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.DistrictDivision;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Order;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Tree;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;

/**
 * sql query type test.
 *
 * @author zhongj
 */
public class EntitySqlQueryJoin1OrmTest extends AbstractEntitySqlQueryJoinTest {

    final String username = "yufei";

    final String startWith = "yu";

    final String contains = "ufe";

    final String endWith = "fei";

    final int min = 10;
    final int max = 20;

    @Test
    void testJoin_E_R1() {
        Order order = null;

        order = query.find(Order.class) //
                .join(Order::getCreateUser) //
                .where() //
                .eq(Order::getId, oid1) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid1);
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());

        order = query.find(Order.class) //
                .join(Order::getCreateUser) //
                .where(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)) //
                .eq(Order::getId, oid1) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid1);
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());

        order = query.find(Order.class).join(Order::getCreateUser).fetch().where().eq(Order::getId, oid1).single();
        assertNotNull(order);
        assertEquals(order.getId(), oid1);
        assertNotNull(order.getCreateUser().getId());
        assertNotNull(order.getCreateUser().getUsername());
    }

    @Test
    void testJoin_E_R1_2() {
        Order order = null;

        order = query.find(Order.class) //
                .join(Order::getCreateUser) //
                .where() //
                .eq((e1, e2) -> e1.accept(Order::getId, oid1)) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid1);
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());

        order = query.find(Order.class) //
                .join(Order::getCreateUser) //
                .where(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)) //
                .eq((e1, e2) -> e1.accept(Order::getId, oid1)) //
                .single();
        assertNotNull(order);
        assertEquals(order.getId(), oid1);
        assertNotNull(order.getCreateUser().getId());
        assertNull(order.getCreateUser().getUsername());

        order = query.find(Order.class).join(Order::getCreateUser).fetch().where().eq(Order::getId, oid1).single();
        assertNotNull(order);
        assertEquals(order.getId(), oid1);
        assertNotNull(order.getCreateUser().getId());
        assertNotNull(order.getCreateUser().getUsername());
    }

    @Test
    void testJoin_E_E() {
        Tree tree = null;
        tree = query.find(Tree.class) //
                .join(Tree::getParent) //
                .where() //
                .eq(Tree::getId, tid2) //
                .single();
        assertNotNull(tree);
        assertEquals(tree.getId(), tid2);
        assertNotNull(tree.getParent().getId());
        assertNull(tree.getParent().getName());

        tree = query.find(Tree.class) //
                .join(Tree::getParent).fetch() //
                .where() //
                .eq(Tree::getId, tid2) //
                .single();
        assertNotNull(tree);
        assertEquals(tree.getId(), tid2);
        assertNotNull(tree.getParent().getId());
        assertNotNull(tree.getParent().getName());
    }

    @Test
    void testJoin_E_E_2() {
        Tree tree = null;
        tree = query.find(Tree.class) //
                .join(Tree::getParent) //
                .where() //
                .eq((e1, e2) -> e1.accept(Tree::getId, tid2)) //
                .single();
        assertNotNull(tree);
        assertEquals(tree.getId(), tid2);
        assertNotNull(tree.getParent().getId());
        assertNull(tree.getParent().getName());

        tree = query.find(Tree.class) //
                .join(Tree::getParent).fetch() //
                .where() //
                .eq((e1, e2) -> e1.accept(Tree::getId, tid2)) //
                .single();
        assertNotNull(tree);
        assertEquals(tree.getId(), tid2);
        assertNotNull(tree.getParent().getId());
        assertNotNull(tree.getParent().getName());
    }

    @Test
    void testJoin_R_E() {
        User user = null;
        user = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .eq(User::getId, uid1) //
                .single();
        assertNotNull(user);
        assertEquals(user.getId(), uid1);
        assertNotNull(user.getUsername());

        Tuple2<User, UserInfo> tuple2 = query.find(User.class) //
                .join(UserInfo::getUser).fetch() //
                .where() //
                .eq(User::getId, uid1) //
                .single();
        assertNotNull(tuple2);
        user = tuple2.get0();
        UserInfo userInfo = tuple2.get1();

        assertNotNull(user);
        assertEquals(user.getId(), uid1);
        assertNotNull(user.getUsername());

        assertNotNull(userInfo);
        assertNotNull(userInfo.getUser());
        assertEquals(userInfo.getUser().getId(), user.getId());
        assertNotNull(userInfo.getName());

    }

    @Test
    void testJoin_R_E_2() {
        User user = null;
        user = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .eq((e1, e2) -> e1.accept(User::getId, uid1)) //
                .single();
        assertNotNull(user);
        assertEquals(user.getId(), uid1);
        assertNotNull(user.getUsername());

        Tuple2<User, UserInfo> tuple2 = query.find(User.class) //
                .join(UserInfo::getUser).fetch() //
                .where() //
                .eq((e1, e2) -> e1.accept(User::getId, uid1)) //
                .single();
        assertNotNull(tuple2);
        user = tuple2.get0();
        UserInfo userInfo = tuple2.get1();

        assertNotNull(user);
        assertEquals(user.getId(), uid1);
        assertNotNull(user.getUsername());

        assertNotNull(userInfo);
        assertNotNull(userInfo.getUser());
        assertEquals(userInfo.getUser().getId(), user.getId());
        assertNotNull(userInfo.getName());

        // ----------------------------------------------------------------------------------------------------------------

        String city = "成都";
        String district = "金牛";
        int id = 1;
        tuple2 = query.find(User.class) //
                .join(UserInfo::getUser).fetch() //
                .where() //
                .eq((e1, e2) -> e2.property(UserInfo::getId).value(id)) //
                .and() //
                .eq((e1, e2) -> e2.property(UserInfo::getDivision).property(DistrictDivision::getCity).value(city)) //
                .and() //
                .eq((e1, e2) -> e2.property(UserInfo::getDivision).property(DistrictDivision::getDistrict)
                        .value(district)) //
                .single();
        assertNotNull(tuple2);
        user = tuple2.get0();
        userInfo = tuple2.get1();

        assertNotNull(user);
        assertEquals(user.getId(), uid1);
        assertNotNull(user.getUsername());

        assertNotNull(userInfo);
        assertNotNull(userInfo.getUser());
        assertEquals(userInfo.getUser().getId(), user.getId());
        assertNotNull(userInfo.getName());
        assertEquals(userInfo.getId().intValue(), id);
        assertEquals(userInfo.getDivision().getCity(), city);
        assertEquals(userInfo.getDivision().getDistrict(), district);

    }

    @Test
    void testJoin_E_R_ne() {
        String city = "成都";
        String district = "金牛";
        int id = 1;
        List<UserInfo> userInfos = query.find(UserInfo.class) //
                .join(UserInfo::getUser) //
                .where() //
                .ne((e1, e2) -> e1.property(UserInfo::getId).value(id)) //
                .list();
        for (UserInfo userInfo : userInfos) {
            assertFalse(userInfo.getId().equals(id));
        }

        userInfos = query.find(UserInfo.class) //
                .join(UserInfo::getUser) //
                .where() //
                .ne((e1, e2) -> e1.property(UserInfo::getDivision).property(DistrictDivision::getCity).value(city)) //
                .and() //
                .ne((e1, e2) -> e1.property(UserInfo::getDivision).property(DistrictDivision::getDistrict)
                        .value(district)) //
                .list();
        for (UserInfo userInfo : userInfos) {
            assertFalse(userInfo.getDivision().getCity().equals(city));
            assertFalse(userInfo.getDivision().getDistrict().equals(district));
        }
    }

    @Test
    void testJoin_R_E_ba() {
        List<User> userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .ba((e1, e2) -> e1.property(User::getAge).value(min, max)) //
                .list();
        for (User u : userInfos) {
            assertTrue(min <= u.getAge());
            assertTrue(u.getAge() <= max);
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .ba((e1, e2) -> e1.accept(User::getAge, min, max)) //
                .list();
        for (User u : userInfos) {
            assertTrue(min <= u.getAge());
            assertTrue(u.getAge() <= max);
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .property((e1, e2) -> e1.apply(User::getAge).ba(min, max)) //
                .list();
        for (User u : userInfos) {
            assertTrue(min <= u.getAge());
            assertTrue(u.getAge() <= max);
        }
    }

    @Test
    void testJoin_R_E_ba2() {
        int minNo = 88;
        int maxNo = 99;
        List<UserInfo> userInfos = query.find(UserInfo.class) //
                .join(UserInfo::getUser) //
                .where() //
                .ba((e1, e2) -> e1.property(UserInfo::getAddress).accept(Address::getStreetNo, minNo, maxNo)) //
                .list();
        for (UserInfo ui : userInfos) {
            assertTrue(minNo <= ui.getAddress().getStreetNo());
            assertTrue(ui.getAddress().getStreetNo() <= maxNo);
        }
    }

    @Test
    void testJoin_R_E_nba() {
        List<User> userInfos = null;
        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .nba((e1, e2) -> e1.property(User::getAge).value(min, max)) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getAge() < min || max < u.getAge());
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .nba((e1, e2) -> e1.accept(User::getAge, min, max)) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getAge() < min || max < u.getAge());
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .property((e1, e2) -> e1.apply(User::getAge).nba(min, max)) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getAge() < min || max < u.getAge());
        }
    }

    @Test
    void testJoin_R_E_nba2() {
        int minNo = 88;
        int maxNo = 99;
        List<UserInfo> userInfos = query.find(UserInfo.class) //
                .join(UserInfo::getUser) //
                .where() //
                .nba((e1, e2) -> e1.property(UserInfo::getAddress).accept(Address::getStreetNo, minNo, maxNo)) //
                .list();
        for (UserInfo ui : userInfos) {
            assertTrue(ui.getAddress().getStreetNo() < minNo || maxNo < ui.getAddress().getStreetNo());
        }
    }

    @Test
    void testJoin_R_E_co() {
        List<User> userInfos = null;
        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .co((e1, e2) -> e1.property(User::getUsername).value(contains)) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getUsername().contains(contains));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .co((e1, e2) -> e1.accept(User::getUsername, contains)) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getUsername().contains(contains));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .co((e1, e2) -> e1.accept(User::getUsername, contains)) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getUsername().contains(contains));
        }
    }

    @Test
    void testJoin_R_E_co2() {
        List<UserInfo> userInfos = null;

        String city = "成都";
        userInfos = query.find(UserInfo.class) //
                .join(UserInfo::getUser) //
                .where() //
                .co((e1, e2) -> e1.property(UserInfo::getDivision).accept(DistrictDivision::getCity, city)) //
                .list();
        for (UserInfo ui : userInfos) {
            assertTrue(ui.getDivision().getCity().contains(city));
        }

        DistrictDivision d = new DistrictDivision();
        d.setCity(city);
        userInfos = query.find(UserInfo.class) //
                .join(UserInfo::getUser) //
                .where() //
                .co((e1, e2) -> e1.property(UserInfo::getDivision).accept(d::getCity)) //
                .list();
        for (UserInfo ui : userInfos) {
            assertTrue(ui.getDivision().getCity().contains(city));
        }
    }

    @Test
    void testJoin_R_E_sw() {
        List<User> userInfos = null;
        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .sw((e1, e2) -> e1.property(User::getUsername).value(startWith)) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getUsername().startsWith(startWith));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .sw((e1, e2) -> e1.accept(User::getUsername, startWith)) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getUsername().startsWith(startWith));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .property((e1, e2) -> e1.apply(User::getUsername).sw(startWith)) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getUsername().startsWith(startWith));
        }
    }

    @Test
    void testJoin_R_E_sw2() {
        List<UserInfo> userInfos = null;

        String city = "成";
        userInfos = query.find(UserInfo.class) //
                .join(UserInfo::getUser) //
                .where() //
                .sw((e1, e2) -> e1.property(UserInfo::getDivision).accept(DistrictDivision::getCity, city)) //
                .list();
        for (UserInfo ui : userInfos) {
            assertTrue(ui.getDivision().getCity().startsWith(city));
        }

        DistrictDivision d = new DistrictDivision();
        d.setCity(city);
        userInfos = query.find(UserInfo.class) //
                .join(UserInfo::getUser) //
                .where() //
                .sw((e1, e2) -> e1.property(UserInfo::getDivision).accept(d::getCity)) //
                .list();
        for (UserInfo ui : userInfos) {
            assertTrue(ui.getDivision().getCity().startsWith(city));
        }
    }

    @Test
    void testJoin_R_E_ew() {
        List<User> userInfos = null;
        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .ew((e1, e2) -> e1.property(User::getUsername).value(endWith)) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getUsername().endsWith(endWith));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .ew((e1, e2) -> e1.accept(User::getUsername, endWith)) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getUsername().endsWith(endWith));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .property((e1, e2) -> e1.apply(User::getUsername).ew(endWith)) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getUsername().endsWith(endWith));
        }
    }

    @Test
    void testJoin_R_E_ew2() {
        List<UserInfo> userInfos = null;

        String city = "都";
        userInfos = query.find(UserInfo.class) //
                .join(UserInfo::getUser) //
                .where() //
                .ew((e1, e2) -> e1.property(UserInfo::getDivision).accept(DistrictDivision::getCity, city)) //
                .list();
        for (UserInfo ui : userInfos) {
            assertTrue(ui.getDivision().getCity().endsWith(city));
        }

        DistrictDivision d = new DistrictDivision();
        d.setCity(city);
        userInfos = query.find(UserInfo.class) //
                .join(UserInfo::getUser) //
                .where() //
                .ew((e1, e2) -> e1.property(UserInfo::getDivision).accept(d::getCity)) //
                .list();
        for (UserInfo ui : userInfos) {
            assertTrue(ui.getDivision().getCity().endsWith(city));
        }
    }

    @Test
    void testJoin_R_E_lk() {
        List<User> userInfos = null;

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .lk((e1, e2) -> e1.property(User::getUsername).value(startWith + "%")) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getUsername().startsWith(startWith));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .lk((e1, e2) -> e1.accept(User::getUsername, startWith + "%")) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getUsername().startsWith(startWith));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .property((e1, e2) -> e1.apply(User::getUsername).lk(startWith + "%")) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getUsername().startsWith(startWith));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .lk((e1, e2) -> e1.property(User::getUsername).value("%" + endWith)) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getUsername().endsWith(endWith));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .lk((e1, e2) -> e1.accept(User::getUsername, "%" + endWith)) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getUsername().endsWith(endWith));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .property((e1, e2) -> e1.apply(User::getUsername).lk("%" + endWith)) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getUsername().endsWith(endWith));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .lk((e1, e2) -> e1.property(User::getUsername).value("%" + contains + "%")) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getUsername().contains(contains));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .lk((e1, e2) -> e1.accept(User::getUsername, "%" + contains + "%")) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getUsername().contains(contains));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .property((e1, e2) -> e1.apply(User::getUsername).lk("%" + contains + "%")) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getUsername().contains(contains));
        }
    }

    @Test
    void testJoin_R_E_lk2() {
        List<UserInfo> userInfos = null;

        final String cityContains = "成都";
        userInfos = query.find(UserInfo.class) //
                .join(UserInfo::getUser) //
                .where() //
                .co((e1, e2) -> e1.property(UserInfo::getDivision).accept(DistrictDivision::getCity,
                        "%" + cityContains + "%")) //
                .list();
        for (UserInfo ui : userInfos) {
            assertTrue(ui.getDivision().getCity().contains(cityContains));
        }

        DistrictDivision d = new DistrictDivision();
        d.setCity("%" + cityContains + "%");
        userInfos = query.find(UserInfo.class) //
                .join(UserInfo::getUser) //
                .where() //
                .co((e1, e2) -> e1.property(UserInfo::getDivision).accept(d::getCity)) //
                .list();
        for (UserInfo ui : userInfos) {
            assertTrue(ui.getDivision().getCity().contains(cityContains));
        }

        final String cityStart = "成";
        userInfos = query.find(UserInfo.class) //
                .join(UserInfo::getUser) //
                .where() //
                .sw((e1, e2) -> e1.property(UserInfo::getDivision).accept(DistrictDivision::getCity, cityStart + "%")) //
                .list();
        for (UserInfo ui : userInfos) {
            assertTrue(ui.getDivision().getCity().startsWith(cityStart));
        }

        d.setCity(cityStart + "%");
        userInfos = query.find(UserInfo.class) //
                .join(UserInfo::getUser) //
                .where() //
                .sw((e1, e2) -> e1.property(UserInfo::getDivision).accept(d::getCity)) //
                .list();
        for (UserInfo ui : userInfos) {
            assertTrue(ui.getDivision().getCity().startsWith(cityStart));
        }

        final String cityEnd = "都";
        userInfos = query.find(UserInfo.class) //
                .join(UserInfo::getUser) //
                .where() //
                .ew((e1, e2) -> e1.property(UserInfo::getDivision).accept(DistrictDivision::getCity, "%" + cityEnd)) //
                .list();
        for (UserInfo ui : userInfos) {
            assertTrue(ui.getDivision().getCity().endsWith(cityEnd));
        }

        d.setCity("%" + cityEnd);
        userInfos = query.find(UserInfo.class) //
                .join(UserInfo::getUser) //
                .where() //
                .ew((e1, e2) -> e1.property(UserInfo::getDivision).accept(d::getCity)) //
                .list();
        for (UserInfo ui : userInfos) {
            assertTrue(ui.getDivision().getCity().endsWith(cityEnd));
        }
    }

    @Test
    void testJoin_R_E_nco() {
        List<User> userInfos = null;
        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .nco((e1, e2) -> e1.property(User::getUsername).value(contains)) //
                .list();
        for (User u : userInfos) {
            assertFalse(u.getUsername().contains(contains));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .nco((e1, e2) -> e1.accept(User::getUsername, contains)) //
                .list();
        for (User u : userInfos) {
            assertFalse(u.getUsername().contains(contains));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .property((e1, e2) -> e1.apply(User::getUsername).nco(contains)) //
                .list();
        for (User u : userInfos) {
            assertFalse(u.getUsername().contains(contains));
        }
    }

    @Test
    void testJoin_R_E_nsw() {
        List<User> userInfos = null;
        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .nsw((e1, e2) -> e1.property(User::getUsername).value(startWith)) //
                .list();
        for (User u : userInfos) {
            assertFalse(u.getUsername().startsWith(startWith));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .nsw((e1, e2) -> e1.accept(User::getUsername, startWith)) //
                .list();
        for (User u : userInfos) {
            assertFalse(u.getUsername().startsWith(startWith));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .property((e1, e2) -> e1.apply(User::getUsername).nsw(startWith)) //
                .list();
        for (User u : userInfos) {
            assertFalse(u.getUsername().startsWith(startWith));
        }
    }

    @Test
    void testJoin_R_E_new() {
        List<User> userInfos = null;
        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .newv((e1, e2) -> e1.property(User::getUsername).value(endWith)) //
                .list();
        for (User u : userInfos) {
            assertFalse(u.getUsername().endsWith(endWith));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .newv((e1, e2) -> e1.accept(User::getUsername, endWith)) //
                .list();
        for (User u : userInfos) {
            assertFalse(u.getUsername().endsWith(endWith));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .property((e1, e2) -> e1.apply(User::getUsername).newv(endWith)) //
                .list();
        for (User u : userInfos) {
            assertFalse(u.getUsername().endsWith(endWith));
        }
    }

    @Test
    void testJoin_R_E_nlk() {
        List<User> userInfos = null;

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .nl((e1, e2) -> e1.property(User::getUsername).value(startWith + "%")) //
                .list();
        for (User u : userInfos) {
            assertFalse(u.getUsername().startsWith(startWith));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .nl((e1, e2) -> e1.accept(User::getUsername, startWith + "%")) //
                .list();
        for (User u : userInfos) {
            assertFalse(u.getUsername().startsWith(startWith));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .property((e1, e2) -> e1.apply(User::getUsername).nl(startWith + "%")) //
                .list();
        for (User u : userInfos) {
            assertFalse(u.getUsername().startsWith(startWith));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .nl((e1, e2) -> e1.property(User::getUsername).value("%" + endWith)) //
                .list();
        for (User u : userInfos) {
            assertFalse(u.getUsername().endsWith(endWith));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .nl((e1, e2) -> e1.accept(User::getUsername, "%" + endWith)) //
                .list();
        for (User u : userInfos) {
            assertFalse(u.getUsername().endsWith(endWith));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .property((e1, e2) -> e1.apply(User::getUsername).nl("%" + endWith)) //
                .list();
        for (User u : userInfos) {
            assertFalse(u.getUsername().endsWith(endWith));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .nl((e1, e2) -> e1.property(User::getUsername).value("%" + contains + "%")) //
                .list();
        for (User u : userInfos) {
            assertFalse(u.getUsername().contains(contains));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .nl((e1, e2) -> e1.accept(User::getUsername, "%" + contains + "%")) //
                .list();
        for (User u : userInfos) {
            assertFalse(u.getUsername().contains(contains));
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .property((e1, e2) -> e1.apply(User::getUsername).nl("%" + contains + "%")) //
                .list();
        for (User u : userInfos) {
            assertFalse(u.getUsername().contains(contains));
        }
    }

    @Test
    void testJoin_R_E_ge() {
        List<User> userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .ge((e1, e2) -> e1.property(User::getAge).value(min)) //
                .list();
        for (User u : userInfos) {
            assertTrue(min <= u.getAge());
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .ge((e1, e2) -> e1.accept(User::getAge, min)) //
                .list();
        for (User u : userInfos) {
            assertTrue(min <= u.getAge());
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .property((e1, e2) -> e1.apply(User::getAge).ge(min)) //
                .list();
        for (User u : userInfos) {
            assertTrue(min <= u.getAge());
        }
    }

    @Test
    void testJoin_R_E_ge2() {
        int no = 66;
        List<UserInfo> userInfos = query.find(UserInfo.class) //
                .join(UserInfo::getUser) //
                .where() //
                .ge((e1, e2) -> e1.property(UserInfo::getAddress).accept(Address::getStreetNo, no)) //
                .list();
        for (UserInfo ui : userInfos) {
            assertTrue(no <= ui.getAddress().getStreetNo());
        }

        Address address = new Address();
        address.setStreetNo(no);

        userInfos = query.find(UserInfo.class) //
                .join(UserInfo::getUser) //
                .where() //
                .ge((e1, e2) -> e1.property(UserInfo::getAddress).accept(address::getStreetNo)) //
                .list();
        for (UserInfo ui : userInfos) {
            assertTrue(no <= ui.getAddress().getStreetNo());
        }
    }

    @Test
    void testJoin_R_E_gt() {
        List<User> userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .gt((e1, e2) -> e1.property(User::getAge).value(min)) //
                .list();
        for (User u : userInfos) {
            assertTrue(min < u.getAge());
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .gt((e1, e2) -> e1.accept(User::getAge, min)) //
                .list();
        for (User u : userInfos) {
            assertTrue(min < u.getAge());
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .property((e1, e2) -> e1.apply(User::getAge).gt(min)) //
                .list();
        for (User u : userInfos) {
            assertTrue(min < u.getAge());
        }
    }

    @Test
    void testJoin_R_E_gt2() {
        int no = 66;
        List<UserInfo> userInfos = query.find(UserInfo.class) //
                .join(UserInfo::getUser) //
                .where() //
                .gt((e1, e2) -> e1.property(UserInfo::getAddress).accept(Address::getStreetNo, no)) //
                .list();
        for (UserInfo ui : userInfos) {
            assertTrue(no < ui.getAddress().getStreetNo());
        }

        Address address = new Address();
        address.setStreetNo(no);

        userInfos = query.find(UserInfo.class) //
                .join(UserInfo::getUser) //
                .where() //
                .gt((e1, e2) -> e1.property(UserInfo::getAddress).accept(address::getStreetNo)) //
                .list();
        for (UserInfo ui : userInfos) {
            assertTrue(no < ui.getAddress().getStreetNo());
        }
    }

    @Test
    void testJoin_R_E_le() {
        List<User> userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .le((e1, e2) -> e1.property(User::getAge).value(max)) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getAge() <= max);
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .le((e1, e2) -> e1.accept(User::getAge, max)) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getAge() <= max);
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .property((e1, e2) -> e1.apply(User::getAge).le(max)) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getAge() <= max);
        }
    }

    @Test
    void testJoin_R_E_le2() {
        int no = 112;
        List<UserInfo> userInfos = query.find(UserInfo.class) //
                .join(UserInfo::getUser) //
                .where() //
                .le((e1, e2) -> e1.property(UserInfo::getAddress).accept(Address::getStreetNo, no)) //
                .list();
        for (UserInfo ui : userInfos) {
            assertTrue(ui.getAddress().getStreetNo() <= no);
        }

        Address address = new Address();
        address.setStreetNo(no);

        userInfos = query.find(UserInfo.class) //
                .join(UserInfo::getUser) //
                .where() //
                .le((e1, e2) -> e1.property(UserInfo::getAddress).accept(address::getStreetNo)) //
                .list();
        for (UserInfo ui : userInfos) {
            assertTrue(ui.getAddress().getStreetNo() <= no);
        }
    }

    @Test
    void testJoin_R_E_lt() {
        List<User> userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .lt((e1, e2) -> e1.property(User::getAge).value(max)) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getAge() < max);
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .lt((e1, e2) -> e1.accept(User::getAge, max)) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getAge() < max);
        }

        userInfos = query.find(User.class) //
                .join(UserInfo::getUser) //
                .where() //
                .property((e1, e2) -> e1.apply(User::getAge).lt(max)) //
                .list();
        for (User u : userInfos) {
            assertTrue(u.getAge() < max);
        }
    }

    @Test
    void testJoin_R_E_lt2() {
        int no = 112;
        List<UserInfo> userInfos = query.find(UserInfo.class) //
                .join(UserInfo::getUser) //
                .where() //
                .lt((e1, e2) -> e1.property(UserInfo::getAddress).accept(Address::getStreetNo, no)) //
                .list();
        for (UserInfo ui : userInfos) {
            assertTrue(ui.getAddress().getStreetNo() < no);
        }

        Address address = new Address();
        address.setStreetNo(no);

        userInfos = query.find(UserInfo.class) //
                .join(UserInfo::getUser) //
                .where() //
                .lt((e1, e2) -> e1.property(UserInfo::getAddress).accept(address::getStreetNo)) //
                .list();
        for (UserInfo ui : userInfos) {
            assertTrue(ui.getAddress().getStreetNo() < no);
        }
    }
}
