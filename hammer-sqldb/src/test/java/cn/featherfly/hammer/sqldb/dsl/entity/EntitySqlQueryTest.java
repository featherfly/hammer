
package cn.featherfly.hammer.sqldb.dsl.entity;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.Params;
import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePage;
import cn.featherfly.common.tuple.MutableTuples;
import cn.featherfly.common.tuple.mutable.MutableTuple1;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic;
import cn.featherfly.hammer.sqldb.dsl.entity.query.EntitySqlQueryExpression;
import cn.featherfly.hammer.sqldb.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.DistrictDivision;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Order;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Tree;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User1;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserRole2;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.Order2;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.Tree2;

/**
 * sql query type test.
 *
 * @author zhongj
 */
public class EntitySqlQueryTest extends JdbcTestBase {

    SqlQuery query;

    UserInfo userInfo = null;
    User user = null;
    Integer uid = 1;
    List<Tree> trees = new ArrayList<>();

    @BeforeTest
    void setupTest() {
        query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory, hammerConfig);
    }

    @BeforeMethod
    void setupMethod() {
        userInfo = null;
        user = null;
        uid = 1;
        trees = new ArrayList<>();
    }

    @Test
    void list() {
        List<Order> list = query.find(Order.class).list();
        assertTrue(list.size() > 0);
    }

    @Test
    void limit() {
        User user = query.find(User.class).limit(1).single();
        assertTrue(user.getId() == 1);

        user = query.find(User.class).limit(1, 1).single();
        assertTrue(user.getId() == 2);

        user = query.find(User.class).limit(new SimplePage(1, 1)).single();
        assertTrue(user.getId() == 1);

        user = query.find(User.class).limit(new SimplePage(1, 2)).single();
        assertTrue(user.getId() == 2);
    }

    @Test
    void sort() {
        List<User> users = query.find(User.class).sort().asc(User::getId).limit(2).list();
        assertTrue(users.size() == 2);
        assertTrue(users.get(0).getId() < users.get(1).getId());

        users = query.find(User.class).sort().desc(User::getId).limit(2).list();
        assertTrue(users.size() == 2);
        assertTrue(users.get(0).getId() > users.get(1).getId());
    }

    @Test
    void conditionConfig() {
        MutableTuple1<Predicate<?>> ignoreStrategy = MutableTuples.create1();
        query.find(User.class).where().configure(c -> {
            ignoreStrategy.set0(c.setIgnoreStrategy(IgnoreStrategy.EMPTY).getIgnoreStrategy());
        });
        assertEquals(ignoreStrategy.get0().get(), IgnoreStrategy.EMPTY);

        List<User> users = query.find(User.class) //
            .configure(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)) //
            .where().eq(User::getUsername, "").list();
        assertTrue(users.size() > 0);

        users = query.find(User.class).where() //
            .configure(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)) //
            .eq(User::getUsername, "").list();
        assertTrue(users.size() > 0);

        users = query.find(User.class).where().configure(c -> c.setIgnoreStrategy(IgnoreStrategy.NULL))
            .eq(User::getUsername, "") //
            .list();
        assertTrue(users.size() == 0);

        users = query.find(User.class).where().configure(c -> c.setIgnoreStrategy(IgnoreStrategy.NULL))
            .eq(User::getUsername, null).list();
        assertTrue(users.size() > 0);

        users = query.find(User.class).where().configure(c -> c.setIgnoreStrategy(IgnoreStrategy.NONE))
            .eq(User::getUsername, null).list();
        assertTrue(users.size() == 0);

        users = query.find(User.class).where().configure(c -> c.setIgnoreStrategy(IgnoreStrategy.NONE))
            .eq(User::getUsername, "").list();
        assertTrue(users.size() == 0);
    }

    @Test
    void ignoreStrategy() {
        List<User> users = null;
        users = query.find(User.class).where().eq(User::getUsername, "", IgnoreStrategy.EMPTY).list();
        assertTrue(users.size() > 0);

        users = query.find(User.class).where().eq(User::getUsername, "", IgnoreStrategy.NULL).list();
        assertTrue(users.size() == 0);

        users = query.find(User.class).where().eq(User::getUsername, (String) null, IgnoreStrategy.NULL).list();
        assertTrue(users.size() > 0);

        users = query.find(User.class).where().eq(User::getUsername, (String) null, IgnoreStrategy.NONE).list();
        assertTrue(users.size() == 0);

        users = query.find(User.class).where().eq(User::getUsername, "", IgnoreStrategy.NONE).list();
        assertTrue(users.size() == 0);

        users = query.find(User.class).where().eq(User::getUsername, "", t -> {
            return Lang.isEmpty(t);
        }).list();
        assertTrue(users.size() > 0);

        String name = "NoName12345";
        //        users = query.find(User.class).where().eq(c -> {
        //            if (name.equals("yufei")) {
        //                c.eq(User::getUsername, name); // 这里还有IgnorePolicy会生效
        //            }
        //        }).list();
        users = query.find(User.class).where().eq(User::getUsername, name, (v) -> !"yufei".equals(v)).list();
        assertTrue(users.size() > 0);

        //        users = query.find(User.class).where().eq(c -> {
        //            if (name.equals(name)) {
        //                c.eq(User::getUsername, name); // 这里还有IgnorePolicy会生效
        //            }
        //        }).list();
        // 使用下面这行代替
        users = query.find(User.class).where().eq(User::getUsername, name, (v) -> !name.equals(v)).list();
        assertTrue(users.size() == 0);
    }

    @Test
    void fetchProperty() {
        Consumer<User> assertUser = user -> {
            assertNotNull(user.getId());
            assertNotNull(user.getAge());
            assertNull(user.getUsername());
            assertNull(user.getMobileNo());
            assertNull(user.getPwd());
        };
        @SuppressWarnings("unchecked")
        List<User> users = query.find(User.class).fetch(User::getId, User::getAge).list();
        for (User user : users) {
            assertUser.accept(user);
        }
        users = query.find(User.class).fetch(User::getId).fetch(User::getAge).list();
        for (User user : users) {
            assertUser.accept(user);
        }

        @SuppressWarnings("unchecked")
        User user = query.find(User.class).fetch(User::getId, User::getAge) //
            .limit(1).single();
        assertUser.accept(user);
        user = query.find(User.class).fetch(User::getId) //
            .fetch(User::getAge) //
            .limit(1).single();
        assertUser.accept(user);
    }

    @Test
    void fetchOneProperty_Retrun_Entity() {
        String name = "yufei";
        User user = query.find(User.class).fetch(User::getUsername).where().eq(User::getUsername, name).single();
        assertEquals(user.getUsername(), name);

        user = query.find(User.class).fetch(User::getUsername).where().eq(User::getUsername, name).unique();
        assertEquals(user.getUsername(), name);

        // ----------------------------------------------------------------------------------------------------------------

        List<User> users = query.find(User.class).limit(2).list();
        Integer[] ids = users.stream().map(User::getId).toArray(n -> new Integer[n]);
        List<User> findUsers = query.find(User.class).fetch(User::getUsername).where().in(User::getId, ids).list();
        Lang.each(findUsers, (e, i) -> {
            assertEquals(e.getUsername(), users.get(i).getUsername());
        });

        findUsers = query.find(User.class).fetch(User::getUsername).where().in(User::getId, ids).limit(2).list();
        assertEquals(findUsers.size(), 2);
        Lang.each(findUsers, (e, i) -> {
            assertEquals(e.getUsername(), users.get(i).getUsername());
        });

        PaginationResults<User> userPage = query.find(User.class).fetch(User::getUsername).where().in(User::getId, ids)
            .limit(2).pagination();
        assertEquals(userPage.getSize(), 2);
        Lang.each(userPage.getPageResults(), (e, i) -> {
            assertEquals(e.getUsername(), users.get(i).getUsername());
        });
    }

    @Test
    void fetchOneProperty() {
        String name = "yufei";
        String username = query.find(User.class).fetch(User::getUsername).where().eq(User::getUsername, name).value();
        assertEquals(username, name);

        // ----------------------------------------------------------------------------------------------------------------

        List<User> users = query.find(User.class).limit(2).list();
        Integer[] ids = users.stream().map(User::getId).toArray(n -> new Integer[n]);
        List<String> usernames = query.find(User.class).fetch(User::getUsername).where().in(User::getId, ids)
            .valueList();
        Lang.each(usernames, (e, i) -> {
            assertEquals(e, users.get(i).getUsername());
        });

        usernames = query.find(User.class).fetch(User::getUsername).where().in(User::getId, ids).limit(2).valueList();
        assertEquals(usernames.size(), 2);
        Lang.each(usernames, (e, i) -> {
            assertEquals(e, users.get(i).getUsername());
        });

        PaginationResults<String> userPage = query.find(User.class).fetch(User::getUsername).where()
            .in(User::getId, ids).limit(2).valuePagination();
        assertEquals(userPage.getSize(), 2);
        Lang.each(userPage.getPageResults(), (e, i) -> {
            assertEquals(e, users.get(i).getUsername());
        });
    }

    @Test
    void count() {
        long size = query.find(User.class).list().size();
        System.out.println("user list size: " + size);

        long count = query.find(User.class).count();
        System.out.println("count: " + count);
        assertTrue(count > 0);
        assertEquals(count, size);

        size = query.find(User.class).where().eq(User::getAge, 55).list().size();
        assertTrue(size == 1);

        count = query.find(User.class).where().eq(User::getAge, 55).count();
        assertTrue(count == 1);
        assertEquals(size, count);

        size = query.find(User.class).fetch(User::getId).list().size();
        count = query.find(User.class).fetch(User::getId) //
            .count();
        assertEquals(size, count);
    }

    @Test
    void avg() {
        Integer avg = query.find(User.class).avg(User::getAge).value();
        System.out.println("avg: " + avg);
        assertTrue(avg > 0);

        avg = query.find(User.class).avg(User::getAge).where().eq(User::getAge, 5).value();
        assertTrue(avg == 5);
    }

    @Test
    void sum() {
        Long count = query.find(User.class).where().eq(User::getAge, 5).count();

        Integer sum = query.find(User.class).sum(User::getAge).where().eq(User::getAge, 5).value();
        System.out.println("sum:" + sum);
        assertTrue(sum > 0);
        assertTrue(sum == count * 5);
    }

    @Test
    void min() {
        Integer min = query.find(User.class).min(User::getAge).value();
        System.out.println("min:" + min);
        assertTrue(min == 5);

        min = query.find(User.class).min(User::getAge).where().ge(User::getAge, 10).value();
        System.out.println("min:" + min);
        assertTrue(min == 10);
    }

    @Test
    void max() {
        Integer max = query.find(User.class).max(User::getAge).value();
        System.out.println("max:" + max);
        assertTrue(max == 55);

        max = query.find(User.class).max(User::getAge).where().le(User::getAge, 10).value();
        System.out.println("max:" + max);
        assertTrue(max == 10);
    }

    @SuppressWarnings("unchecked")
    @Test
    void mapping() {

        query.find(User.class).where().eq(User::getUsername, "yufei").and().eq(User::getPwd, "123456").and().group()
            .gt(User::getAge, 18).and().lt(User::getAge, 60).list();

        query.find(User.class).where().eq(User::getUsername, "yufei").and().eq(User::getPwd, "123456").and().group()
            .gt(User::getAge, 18).and().property(User::getAge).lt(60).list();

        query.find(User.class).property(User::getUsername, User::getPwd, User::getAge).where()
            .eq(User::getUsername, "yufei").and().eq(User::getPwd, "123456").and().group().gt(User::getAge, 18).and()
            .lt(User::getAge, 60).list();
        /*
         * query.find(User.class).join(UserInfo.class, UserInfo::getUser)
         * query.find(UserInfo.class).join(UserInfo::getUser, User.class)
         * query.find(UserInfo.class).join(UserInfo::getUser)
         * query.find("user").join("user_info").on("user_id",
         * "id").join("user_role").on("user_id", "id").join("role",
         * "user_role").on("id", "role_id")
         * query.find("user_info").join("user_id", "user")
         */
        query.find(User.class).property(User::getUsername, User::getPwd, User::getAge).where()
            .eq(User::getUsername, "yufei").and().eq(User::getPwd, "123456").and().group().gt(User::getAge, 18).and()
            .lt(User::getAge, 60).list();
    }

    @Test
    void mapping2() {

        User user = new User();
        user.setUsername("yufei");
        user.setPwd("123456");
        query.find(User.class).where().eq(user::getUsername).and().eq(user::getPwd).list();
    }

    @SuppressWarnings("unchecked")
    @Test
    void condition_property() {

        query.find(User.class).where()//
            .property(User::getUsername).eq("yufei") //
            .and().property(User::getPwd).eq("123456") //
            .list();

        query.find(User.class).where().property(User::getUsername).eq("yufei").and().property(User::getPwd).eq("123456")
            .and().group().property(User::getAge).gt(18).and().property(User::getAge).lt(60).list();

        query.find(User.class).where().property(User::getUsername).eq("yufei").and().property(User::getPwd).eq("123456")
            .and().group().gt(User::getAge, 18).and().property(User::getAge).lt(60).list();

        query.find(User.class).property(User::getUsername, User::getPwd, User::getAge).where()
            .eq(User::getUsername, "yufei").and().eq(User::getPwd, "123456").and().group().gt(User::getAge, 18).and()
            .lt(User::getAge, 60).list();

        query.find(User.class).property(User::getUsername, User::getPwd, User::getAge).where()
            .eq(User::getUsername, "yufei").and().eq(User::getPwd, "123456").and().group().gt(User::getAge, 18).and()
            .lt(User::getAge, 60).list();
    }

    @Test
    void condition_property_join() {
        List<User> users = null;
        final int id = 1;
        final int min = id;
        final int max = 5;
        final User user = query.find(User.class).where().eq(User::getId, id).single();

        Consumer<List<User>> assertUsers = (list) -> {
            assertEquals(list.size(), 1);
            User u = list.get(0);
            assertEquals(u.getId(), user.getId());
            assertEquals(u.getUsername(), user.getUsername());
        };

        users = query.find(User.class).join(UserInfo::getUser).where().eq(User::getId, user.getId()) //
            .and().ba2(UserInfo::getId, min, max) //
            .and().eq(User::getUsername, user.getUsername()) //
            .list();
        assertUsers.accept(users);

        users = query.find(User.class).join(UserInfo::getUser).where( //
            (e0, e1) -> e0.property(User::getId).eq(user.getId()) //
                .and().property(User::getUsername) //
                .eq(user.getUsername()) //
        ).and().ba2(UserInfo::getId, min, max).list();
        assertUsers.accept(users);

        users = query.find(User.class).join(UserInfo::getUser).where( //
            (e0, e1) -> e0.property(User::getId).eq(user.getId()) //
                .and().property(User::getUsername) //
                .eq(user.getUsername()) //
                .and(e1.property(UserInfo::getId) //
                    .ba(min, max)))
            .list();
        assertUsers.accept(users);

        users = query.find(User.class).join(UserInfo::getUser).where( //
            (e0, e1) -> e0.property(User::getId).eq(user.getId()) //
                .and().property(User::getUsername).eq(user.getUsername()) //
                .and(e1.property(UserInfo::getId).ba(min, max)) //
        ).list();
        assertUsers.accept(users);

        users = query.find(User.class).join(UserInfo::getUser).where( //
            (e0, e1) -> e1.property(UserInfo::getId).ba(min, max) //
                .and(e0.property(User::getId).eq(user.getId()) //
                    .and().property(User::getUsername).eq(user.getUsername())) //

        ).list();
        assertUsers.accept(users);

        //        users = query.find(User.class).join(UserInfo::getUser).where( //
        //                (e0, e1) -> e0.property(User::getId).eq(user.getId()) //
        //                        .and(e0.property(User::getUsername).eq(user.getUsername()))
        //                          FIXME 触发异常：语法错误，连续相同类型的表达式
        // IMPLSOON 后续改为强类型，即e0.xx.and(e0.eq()),e1.xx.and(e1.eq())编译报错,只能e0.xx.and(e1.eq()),e0.xx.and(e2.eq())
        //                        .and(e1.property(UserInfo::getId).ba(min, max)) //
        //        ).list();
        //        assertUsers.accept(users);

        //        users = query.find(User.class).join(UserInfo::getUser).where( //
        //                (e0, e1) -> e0.property(User::getId).eq(user.getId()) //
        //                        .and().property(User::getUsername).eq(user.getUsername()) //
        //                        .and().ba2(UserInfo::getId, min, max) // api已经没有ba(N)
        //        ).list();
        //        assertUsers.accept(users);

        users = query.find(User.class).join(UserInfo::getUser).where( //
            (e0, e1) -> e0.property(User::getId).eq(user.getId()) //
                .and(e1.property(UserInfo::getId).ba(min, max))) //
            .and().property(User::getUsername).eq(user.getUsername()) //
            .list();
        assertUsers.accept(users);

        users = query.find(User.class).join(UserInfo::getUser).where( //
            (e0, e1) -> e0.property(User::getId).eq(user.getId()) //
                .and(e1.property(UserInfo::getId).ba(min, max))) //
            .and().eq(User::getUsername, user.getUsername()) //
            .list();
        assertUsers.accept(users);
    }

    @Test
    void condition_property_join2() {
        List<Order> orders = null;
        final int id = 1;

        orders = query.find(Order.class).where() //
            .property(Order::getUser1).property(User1::getId).eq(id) //
            .list();
        assertEquals(orders.size(), 2);
    }

    @Test
    void nestedMapping() {
        Integer userId = 1;
        //        UserInfo userInfo = query.find(UserInfo.class).where().eq("user.id", userId).single();
        UserInfo userInfo = query.find(UserInfo.class).where().eq(UserInfo::getUser, userId).single();
        assertEquals(userInfo.getUser().getId(), userId);
        System.out.println(userInfo);
    }

    @Test
    void nestedMapping2() {
        UserInfo userInfo = null;
        String province = "广东";
        //        userInfo = query.find(UserInfo.class).where().eq("division.province", province).single();
        //        userInfo = query.find(UserInfo.class).where().eq(UserInfo::getDivision, DistrictDivision::getProvince, province)
        //                .single(); // 使用下面这行代替
        userInfo = query.find(UserInfo.class).where().property(UserInfo::getDivision)
            .property(DistrictDivision::getProvince).eq(province).single();
        assertEquals(userInfo.getDivision().getProvince(), province);
        System.out.println(userInfo);
    }

    @Test
    void manyToOne() {

        int parent = 1;
        List<Tree> list = query.find(Tree.class).where().eq(Tree::getParent, parent).list();
        System.out.println(list);
        for (Tree t : list) {
            assertTrue(parent == t.getParent().getId());
        }
    }

    @Test
    void manyToOne2() {

        int parent = 1;
        Tree tree2 = new Tree();
        tree2.setParent(new Tree(parent));
        List<Tree> list = query.find(Tree.class).where().eq(tree2::getParent).list();
        System.out.println(list);
        for (Tree t : list) {
            assertTrue(1 == t.getParent().getId());
        }
    }

    @Test
    void property_eq() {
        long c = query.find(User.class) //
            .where() //
            .property(User::getId).eq(null, v -> false) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getId).eq(null, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getUsername).eq(null, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);
    }

    @Test
    void property_eq_property() {
        List<Order2> orders = query.find(Order2.class) //
            .where(r -> r.property(Order2::getCreateUser).eq(r.property(Order2::getUser1))).list();
        for (Order2 order : orders) {
            assertEquals(order.getCreateUser(), order.getUser1());
        }
    }

    @Test
    void property_eq_embedded() {
        List<UserInfo> userInfos = null;

        DistrictDivision division = new DistrictDivision();
        division.setProvince("四川");
        division.setCity("成都");

        userInfos = query.find(UserInfo.class).where().eq(UserInfo::getDivision, division).list();
        for (UserInfo userInfo : userInfos) {
            assertEquals(userInfo.getDivision().getProvince(), division.getProvince());
            assertEquals(userInfo.getDivision().getCity(), division.getCity());
        }
    }

    @Test
    void property_eq_manyToOne_pk() {
        List<UserInfo> userInfos = null;

        User user = new User();
        user.setId(1);

        userInfos = query.find(UserInfo.class).where().eq(UserInfo::getUser, user).list();
        for (UserInfo userInfo : userInfos) {
            assertEquals(userInfo.getUser().getId(), user.getId());
        }
    }

    @Test
    void property_eq_ManyToOne_autojoin() {
        List<UserInfo> userInfos = null;

        User user = new User();
        user.setUsername("yufei");
        user.setMobileNo("12345678901");

        userInfos = query.find(UserInfo.class).where().eq(UserInfo::getUser, user).list();
        for (UserInfo userInfo : userInfos) {
            User u = query.find(User.class).where().eq(User::getId, userInfo.getUser().getId()).single();
            assertEquals(u.getUsername(), user.getUsername());
            assertEquals(u.getMobileNo(), user.getMobileNo());
        }
    }

    @Test
    void property_ne() {
        long c = query.find(User.class) //
            .where() //
            .property(User::getId).ne(null, v -> false) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getId).ne(null, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getUsername).ne(null, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);
    }

    @Test
    void property_ne_manyToOne_pk() {
        List<UserInfo> userInfos = null;

        User user = new User();
        user.setId(1);

        userInfos = query.find(UserInfo.class).where().ne(UserInfo::getUser, user).list();
        for (UserInfo userInfo : userInfos) {
            assertNotEquals(userInfo.getUser().getId(), user.getId());
        }
    }

    @Test
    void property_ne_manyToOne_autojoin() {
        List<UserInfo> userInfos = null;

        User user = new User();
        user.setUsername("yufei");
        user.setMobileNo("12345678901");

        userInfos = query.find(UserInfo.class).where().ne(UserInfo::getUser, user).list();
        for (UserInfo userInfo : userInfos) {
            User u = query.find(User.class).where().eq(User::getId, userInfo.getUser().getId()).single();
            assertNotEquals(u.getUsername(), user.getUsername());
            assertNotEquals(u.getMobileNo(), user.getMobileNo());
        }
    }

    @Test
    void property_ne_embedded() {
        List<UserInfo> userInfos = null;

        DistrictDivision division = new DistrictDivision();
        division.setProvince("四川");
        division.setCity("成都");

        userInfos = query.find(UserInfo.class).where().ne(UserInfo::getDivision, division).list();
        for (UserInfo userInfo : userInfos) {
            assertNotEquals(userInfo.getDivision().getProvince(), division.getProvince());
            assertNotEquals(userInfo.getDivision().getCity(), division.getCity());
        }
    }

    @Test
    void condition_expr() {
        Integer id = 1;
        User user = query.find(User.class).where().eq(User::getId, id).single();
        assertEquals(user.getId(), id);

        user = query.find(User.class).where().eq(User::getId, id).and()
            .expression("{0}.age - :age >= 0", new ChainMapImpl<String, Serializable>().putChain("age", 100)).single();
        assertNull(user);

        user = query.find(User.class).where().eq(User::getId, id).and().expression("{0}.age - ? >= 0", 100).single();
        assertNull(user);

        user = query.find(User.class).where().eq(User::getId, id).and().expression("{0}.username = password").single();
        assertNull(user);

        user = query.find(User.class).where().eq(User::getId, id).and()
            .expr("{as0}.age - :age >= 0", Params.setParam("age", 100)).single();
        assertNull(user);

        user = query.find(User.class).where().eq(User::getId, id).and().expr("{as0}.age - ? >= 0", 100).single();
        assertNull(user);

        user = query.find(User.class).where().eq(User::getId, id).and().expr("{as0}.username = password").single();
        assertNull(user);
    }

    @Test
    void condition_in() {
        Integer id = null;
        Integer[] ids = null;
        int[] idsInt = null;
        Integer one = 1;
        Integer two = 2;
        String username = null;
        //        String[] usernames = null;
        List<Integer> idList = null;
        Collection<Integer> idCollection = null;

        long c = query.find(User.class) //
            .where() //
            .in(User::getId, id, v -> false) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .in(User::getUsername, username, v -> false) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .in(User::getId, id, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .in(User::getUsername, username, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);

        // ----------------------------------------------------------------------------------------------------------------

        c = query.find(User.class) //
            .where() //
            .in(User::getId, ids, v -> false) // 不忽略
            .count();
        assertEquals(c, 0);
        c = query.find(User.class) //
            .where() //
            .in(User::getId, ids, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);
        ids = Lang.array(1, 2);
        c = query.find(User.class) //
            .where() //
            .in(User::getId, ids) // 不忽略
            .count();
        assertEquals(c, ids.length);
        c = query.find(User.class) //
            .where() //
            .in(User::getId, ids, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, ids.length);
        c = query.find(User.class) //
            .where() //
            .in(User::getId, one, two) // 不忽略
            .count();
        assertEquals(c, 2);

        // ----------------------------------------------------------------------------------------------------------------

        c = query.find(User.class) //
            .where() //
            .in(User::getId, idsInt, (Predicate<int[]>) v -> false) // 不忽略
            .count();
        assertEquals(c, 0);
        c = query.find(User.class) //
            .where() //
            .in(User::getId, idsInt, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);
        idsInt = new int[] { 1, 2, 3 };
        c = query.find(User.class) //
            .where() //
            .in(User::getId, idsInt) // 不忽略
            .count();
        assertEquals(c, idsInt.length);
        c = query.find(User.class) //
            .where() //
            .in(User::getId, idsInt, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, idsInt.length);
        int i1 = 1;
        int i2 = 2;
        c = query.find(User.class) //
            .where() //
            .in(User::getId, 1, 2) // 不忽略
            .count();
        assertEquals(c, 2);
        c = query.find(User.class) //
            .where() //
            .in(User::getId, i1, i2) // 不忽略
            .count();
        assertEquals(c, 2);

        c = query.find(User.class) //
            .where() //
            .in(User::getUsername, "", "").count();

        // ----------------------------------------------------------------------------------------------------------------

        c = query.find(User.class) //
            .where() //
            .in(User::getId, idList, (Predicate<Collection<Integer>>) v -> false) // 不忽略
            .count();
        assertEquals(c, 0);
        c = query.find(User.class) //
            .where() //
            .in(User::getId, idList, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);
        idList = Lang.list(1, 2);
        c = query.find(User.class) //
            .where() //
            .in(User::getId, idList) // 不忽略
            .count();
        assertEquals(c, idList.size());
        c = query.find(User.class) //
            .where() //
            .in(User::getId, idList, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, idList.size());

        idCollection = idList;
        c = query.find(User.class) //
            .where() //
            .in(User::getId, idCollection, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, idCollection.size());
    }

    @Test
    void condition_property_in() {
        Integer id = null;
        Integer[] ids = null;
        String username = null;
        String[] usernames = null;

        long c = query.find(User.class) //
            .where() //
            .property(User::getId).in(id, v -> false) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getUsername).in(username, v -> false) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getId).in(id, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getUsername).in(username, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getId).in(ids, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getUsername).in(usernames, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);
    }

    @Test
    void property_ni() {
        Integer id = null;
        Integer[] ids = null;
        String username = null;
        String[] usernames = null;

        long c = query.find(User.class) //
            .where() //
            .property(User::getId).ni(id, v -> false) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getUsername).ni(username, v -> false) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getId).ni(id, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getUsername).ni(username, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getId).ni(ids, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getUsername).ni(usernames, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);
    }

    @Test
    void property_ge() {
        int qa = 40;
        List<User> users = query.find(User.class) //
            .where() //
            .property(User::getAge).ge(qa, v -> false) // 不忽略
            .list();
        for (User user : users) {
            assertTrue(user.getAge() >= qa);
        }

        long c = query.find(User.class) //
            .where() //
            .property(User::getId).ge(null, v -> false) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getId).ge(null, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getUsername).ge(null, v -> false) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getUsername).ge(null, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);
    }

    @Test
    void property_gt() {
        int qa = 40;
        List<User> users = query.find(User.class) //
            .where() //
            .property(User::getAge).gt(qa, v -> false) // 不忽略
            .list();
        for (User user : users) {
            assertTrue(user.getAge() > qa);
        }

        long c = query.find(User.class) //
            .where() //
            .property(User::getId).gt(null, v -> false) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getId).gt(null, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getUsername).gt(null, v -> false) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getUsername).gt(null, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);
    }

    @Test
    void property_le() {
        int qa = 40;
        List<User> users = query.find(User.class) //
            .where() //
            .property(User::getAge).le(qa, v -> false) // 不忽略
            .list();
        for (User user : users) {
            assertTrue(user.getAge() <= qa);
        }

        long c = query.find(User.class) //
            .where() //
            .property(User::getId).le(null, v -> false) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getId).le(null, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getUsername).le(null, v -> false) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getUsername).le(null, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);
    }

    @Test
    void property_lt() {
        int qa = 40;
        List<User> users = query.find(User.class) //
            .where() //
            .property(User::getAge).lt(qa, v -> false) // 不忽略
            .list();
        for (User user : users) {
            assertTrue(user.getAge() < qa);
        }

        long c = query.find(User.class) //
            .where() //
            .property(User::getId).lt(null, v -> false) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getId).lt(null, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getUsername).lt(null, v -> false) // 不忽略
            .count();
        assertEquals(c, 0);

        c = query.find(User.class) //
            .where() //
            .property(User::getUsername).lt(null, IgnoreStrategy.NONE) // 不忽略
            .count();
        assertEquals(c, 0);
    }

    @Test
    void nestedProperty() {

        UserRole2 userRole2 = new UserRole2();
        userRole2.setRole(new Role(2));
        userRole2.setUser(new User(1));
        query.find(UserRole2.class).where().eq(userRole2::getRole).and().ne(userRole2::getUser).list();

        UserInfo userInfo = new UserInfo();
        DistrictDivision division = new DistrictDivision();
        division.setCity("成都");
        division.setProvince("四川");
        division.setDistrict("金牛");
        userInfo.setDivision(division);

        List<UserInfo> list = query.find(UserInfo.class).where().eq(UserInfo::getDivision, division).list();
        int size = list.size();
        for (UserInfo ui : list) {
            assertEquals(ui.getDivision(), division);
        }
        list = query.find(UserInfo.class).where().eq(UserInfo::getId, 1).or().eq(UserInfo::getDivision, division).or()
            .eq(UserInfo::getId, 1).list();
        size = list.size();
        for (UserInfo ui : list) {
            assertEquals(ui.getDivision(), division);
        }

        list = query.find(UserInfo.class).where().ne(UserInfo::getDivision, division).list();
        for (UserInfo ui : list) {
            assertNotEquals(ui.getDivision(), division);
        }

        userInfo.getDivision().setDistrict(null);
        list = query.find(UserInfo.class).where().eq(UserInfo::getDivision, division).or()
            .eq(UserInfo::getDivision, division).list();
        assertTrue(list.size() > size);

        list = query.find(UserInfo.class).where().eq(UserInfo::getDivision, null).or().eq(UserInfo::getDivision, null)
            .list();
        assertTrue(list.size() > size);
    }

    @Test
    void nestedProperty2() {

        UserRole2 userRole2 = new UserRole2();
        userRole2.setRole(new Role(2));
        userRole2.setUser(new User(1));
        query.find(UserRole2.class).where().eq(userRole2::getRole).and().ne(userRole2::getUser).list();

        UserInfo userInfo = new UserInfo();
        DistrictDivision division = new DistrictDivision();
        division.setCity("成都");
        division.setProvince("四川");
        division.setDistrict("金牛");
        userInfo.setDivision(division);

        List<UserInfo> list = query.find(UserInfo.class).where().eq(UserInfo::getDivision, division).list();
        int size = list.size();
        for (UserInfo ui : list) {
            assertEquals(ui.getDivision(), division);
        }
        list = query.find(UserInfo.class).where().ne(UserInfo::getDivision, division).list();
        for (UserInfo ui : list) {
            assertNotEquals(ui.getDivision(), division);
        }

        userInfo.getDivision().setDistrict(null);
        list = query.find(UserInfo.class).where().eq(UserInfo::getDivision, division).or()
            .eq(UserInfo::getDivision, division).list();
        assertTrue(list.size() > size);

        list = query.find(UserInfo.class).where().eq(UserInfo::getDivision, null).or().eq(UserInfo::getDivision, null)
            .list();
        assertTrue(list.size() > size);
    }

    @Test
    void nestedProperty3() {
        UserRole2 userRole2 = new UserRole2();
        userRole2.setRole(new Role(2));
        userRole2.setUser(new User(1));
        query.find(UserRole2.class) //
            .where() //
            .property(UserRole2::getRole).eq(userRole2.getRole())//
            .and() //
            .property(UserRole2::getUser).ne(userRole2.getUser()).list();

        query.find(UserRole2.class) //
            .where() //
            .property(UserRole2::getRole).property(Role::getId).eq(userRole2.getRole().getId()) //
            .and() //
            .property(UserRole2::getUser).property(User::getId).ne(userRole2.getUser().getId()).list();

        UserInfo userInfo = new UserInfo();
        DistrictDivision division = new DistrictDivision();
        division.setCity("成都");
        division.setProvince("四川");
        division.setDistrict("金牛");
        userInfo.setDivision(division);

        List<UserInfo> list = query.find(UserInfo.class) //
            .where() //
            .property(UserInfo::getDivision).eq(division) //
            .list();
        int size = list.size();
        for (UserInfo ui : list) {
            assertEquals(ui.getDivision(), division);
        }
        list = query.find(UserInfo.class) //
            .where() //
            .property(UserInfo::getDivision).ne(division) //
            .list();
        for (UserInfo ui : list) {
            assertNotEquals(ui.getDivision(), division);
        }

        userInfo.getDivision().setDistrict(null);
        list = query.find(UserInfo.class).where()//
            .property(UserInfo::getDivision).eq(division)//
            .or() //
            .property(UserInfo::getDivision).eq(division)//
            .list();
        assertTrue(list.size() > size);

        list = query.find(UserInfo.class).where()//
            .property(UserInfo::getDivision).eq((DistrictDivision) null)//
            .or() //
            .property(UserInfo::getDivision).eq((DistrictDivision) null)//
            .list();
        assertTrue(list.size() > size);

        list = query.find(UserInfo.class).where()//
            .property(UserInfo::getDivision).eq((DistrictDivision) null)//
            .or() //
            .property(UserInfo::getDivision).eq((DistrictDivision) null)//
            .list();
        assertTrue(list.size() > size);

        list = query.find(UserInfo.class) //
            .where() //
            .property(UserInfo::getDivision).property(DistrictDivision::getCity).eq(division.getCity()) //
            .list();
        for (UserInfo ui : list) {
            assertEquals(ui.getDivision().getCity(), division.getCity());
        }
    }

    @Test
    void nestedPropertyAutoJoin_eq() {
        Integer rid = 2;
        Integer uid = 1;

        Role role = query.find(Role.class).where().eq(Role::getId, rid).single();
        User user = query.find(User.class).where().eq(User::getId, uid).single();
        assertEquals(rid, role.getId());
        assertEquals(uid, user.getId());

        List<UserRole2> list = query.find(UserRole2.class) //
            .where() //
            .property(UserRole2::getRole) //
            .property(Role::getName) //
            .eq(role.getName()).list();

        for (UserRole2 ur : list) {
            Role r = query.find(Role.class).where().eq(Role::getId, ur.getRole().getId()).single();
            assertEquals(r.getName(), role.getName());
        }
    }

    @Test
    void nestedPropertyAutoJoin_eq2() {
        Integer rid = 2;
        Integer uid = 1;

        Role role = query.find(Role.class).where().eq(Role::getId, rid).single();
        User user = query.find(User.class).where().eq(User::getId, uid).single();
        assertEquals(rid, role.getId());
        assertEquals(uid, user.getId());

        List<UserRole2> list = null;

        list = query.find(UserRole2.class).join(UserRole2::getRole)//
            .where() //
            .property((e1, e2) -> e1.property(UserRole2::getRole) //
                .property(Role::getName).eq(role.getName()))
            .list();

        for (UserRole2 ur : list) {
            Role r = query.find(Role.class).where().eq(Role::getId, ur.getRole().getId()).single();
            assertEquals(r.getName(), role.getName());
        }

        list = query.find(UserRole2.class).join(UserRole2::getRole)//
            .where() //
            .eq((e1, e2) -> e1.property(UserRole2::getRole) //
                .property(Role::getName).value(role.getName())) //
            .list();

        for (UserRole2 ur : list) {
            Role r = query.find(Role.class).where().eq(Role::getId, ur.getRole().getId()).single();
            assertEquals(r.getName(), role.getName());
        }
    }

    @Test
    void nestedPropertyAutoJoin_co() {
        String name = "yufei";

        List<UserInfo> userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser)
            .property(User::getUsername).co(name).list();
        for (UserInfo ui : userInfos) {
            User u = query.find(User.class).where().eq(User::getId, ui.getUser().getId()).single();
            assertTrue(u.getUsername().contains(name));
        }
    }

    @Test
    void nestedPropertyAutoJoin_nco() {
        String name = "yufei";

        List<UserInfo> userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser)
            .property(User::getUsername).nco(name).list();
        for (UserInfo ui : userInfos) {
            User u = query.find(User.class).where().eq(User::getId, ui.getUser().getId()).single();
            assertFalse(u.getUsername().contains(name));
        }
    }

    @Test
    void nestedPropertyAutoJoin_sw() {
        String name = "yufei";

        List<UserInfo> userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser)
            .property(User::getUsername).sw(name).list();
        for (UserInfo ui : userInfos) {
            User u = query.find(User.class).where().eq(User::getId, ui.getUser().getId()).single();
            assertTrue(u.getUsername().startsWith(name));
        }
    }

    @Test
    void nestedPropertyAutoJoin_nsw() {
        String name = "yufei";

        List<UserInfo> userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser)
            .property(User::getUsername).nsw(name).list();
        for (UserInfo ui : userInfos) {
            User u = query.find(User.class).where().eq(User::getId, ui.getUser().getId()).single();
            assertFalse(u.getUsername().startsWith(name));
        }
    }

    @Test
    void nestedPropertyAutoJoin_ew() {
        String name = "fly";

        List<UserInfo> userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser)
            .property(User::getUsername).sw(name).list();
        for (UserInfo ui : userInfos) {
            User u = query.find(User.class).where().eq(User::getId, ui.getUser().getId()).single();
            assertTrue(u.getUsername().endsWith(name));
        }
    }

    @Test
    void nestedPropertyAutoJoin_new() {
        String name = "fly";

        List<UserInfo> userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser)
            .property(User::getUsername).newv(name).list();
        for (UserInfo ui : userInfos) {
            User u = query.find(User.class).where().eq(User::getId, ui.getUser().getId()).single();
            assertFalse(u.getUsername().endsWith(name));
        }
    }

    @Test
    void nestedPropertyAutoJoin_ba() {
        int min = 10;
        int max = 20;

        List<UserInfo> userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getAge)
            .ba(min, max).list();
        for (UserInfo ui : userInfos) {
            User u = query.find(User.class).where().eq(User::getId, ui.getUser().getId()).single();
            assertTrue(min <= u.getAge() && u.getAge() <= max);
        }
    }

    @Test
    void nestedPropertyAutoJoin_nba() {
        int min = 10;
        int max = 20;

        List<UserInfo> userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getAge)
            .nba(min, max).list();
        for (UserInfo ui : userInfos) {
            User u = query.find(User.class).where().eq(User::getId, ui.getUser().getId()).single();
            assertTrue(u.getAge() < min || max < u.getAge());
        }
    }

    @Test
    void nestedPropertyAutoJoin_ge() {
        int age = 15;

        List<UserInfo> userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getAge)
            .ge(age).list();
        for (UserInfo ui : userInfos) {
            User u = query.find(User.class).where().eq(User::getId, ui.getUser().getId()).single();
            assertTrue(u.getAge() >= age);
        }
    }

    @Test
    void nestedPropertyAutoJoin_gt() {
        int age = 15;

        List<UserInfo> userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getAge)
            .gt(age).list();
        for (UserInfo ui : userInfos) {
            User u = query.find(User.class).where().eq(User::getId, ui.getUser().getId()).single();
            assertTrue(u.getAge() > age);
        }
    }

    @Test
    void nestedPropertyAutoJoin_le() {
        int age = 15;

        List<UserInfo> userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getAge)
            .le(age).list();
        for (UserInfo ui : userInfos) {
            User u = query.find(User.class).where().eq(User::getId, ui.getUser().getId()).single();
            assertTrue(u.getAge() <= age);
        }
    }

    @Test
    void nestedPropertyAutoJoin_lt() {
        int age = 15;

        List<UserInfo> userInfos = query.find(UserInfo.class).where().property(UserInfo::getUser).property(User::getAge)
            .lt(age).list();
        for (UserInfo ui : userInfos) {
            User u = query.find(User.class).where().eq(User::getId, ui.getUser().getId()).single();
            assertTrue(u.getAge() < age);
        }
    }

    @Test
    void isn_inn() {

        long nullNum = 1;

        long total = query.find(Tree.class).count();

        long count = query.find(Tree2.class).where().isn(Tree2::getParentId).count();
        assertEquals(count, nullNum);

        count = query.find(Tree2.class).where().isn(Tree2::getParentId, true).count();
        assertEquals(count, nullNum);

        count = query.find(Tree2.class).where().isn(Tree2::getParentId, false).count();
        assertTrue(nullNum < count);

        count = query.find(Tree2.class).where().isn(Tree2::getParentId, (Boolean) null).count();
        assertTrue(count == total);

        count = query.find(Tree2.class).where().isn(Tree2::getParentId).count();
        assertEquals(count, nullNum);

        count = query.find(Tree2.class).where().isn(Tree2::getParentId, true).count();
        assertEquals(count, nullNum);

        count = query.find(Tree2.class).where().isn(Tree2::getParentId, false).count();
        assertTrue(nullNum < count);

        count = query.find(Tree2.class).where().isn(Tree2::getParentId, (Boolean) null).count();
        assertTrue(count == total);

        count = query.find(Tree2.class).where().inn(Tree2::getParentId).count();
        assertTrue(nullNum < count);

        count = query.find(Tree2.class).where().inn(Tree2::getParentId, true).count();
        assertTrue(nullNum < count);

        count = query.find(Tree2.class).where().inn(Tree2::getParentId, false).count();
        assertEquals(count, nullNum);

        count = query.find(Tree2.class).where().inn(Tree2::getParentId, (Boolean) null).count();
        assertTrue(count == total);

        count = query.find(Tree2.class).where().inn(Tree2::getParentId).count();
        assertTrue(nullNum < count);

        count = query.find(Tree2.class).where().inn(Tree2::getParentId, true).count();
        assertTrue(nullNum < count);

        count = query.find(Tree2.class).where().inn(Tree2::getParentId, false).count();
        assertEquals(count, nullNum);

        count = query.find(Tree2.class).where().inn(Tree2::getParentId, (Boolean) null).count();
        assertTrue(count == total);
    }

    @Test
    void complexQuery() {
        //        query.find(User.class).where().gt(User::getId, 1).and().group().group();

        //        query.find(User.class).where().gt(User::getId, 1).and(c -> {
        //            c.group(g1 -> {
        //                g1.eq(User::getId, 2).and().eq(User::getAge, 5);
        //            }).or().group(g2 -> {
        //                g2.eq(User::getId, 3).and().eq(User::getAge, 15);
        //            });
        //        }).list();

        //        query.find(User.class).where().gt(User::getId, 1).and().group()
        //                .group(g1 -> g1.eq(User::getId, 2).and().eq(User::getAge, 5)).or()
        //                .group(g2 -> g2.eq(User::getId, 3).and().eq(User::getAge, 15)).endGroup().list();

        long count = -1;

        // 基于group() endGroup() 方法
        count = query.find(User.class) //
            .where() //
            .gt(User::getId, 1) //
            .and() //
            .group() //
            /**/ .group().eq(User::getId, 2).and().eq(User::getAge, 5).endGroup() //
            /**/ .or() //
            /**/ .group().eq(User::getId, 3).and().eq(User::getAge, 15).endGroup() //
            .endGroup() //
            .count();
        assertEquals(count, 2);

        //  基于and().group(g -> g.xxx)
        count = query.find(User.class) //
            .where() //
            .gt(User::getId, 1) //
            .and() //
            .group( //
                g -> g.group(g1 -> g1.eq(User::getId, 2).and().eq(User::getAge, 5)) //
                    .or() //
                    .group(g2 -> g2.eq(User::getId, 3).and().eq(User::getAge, 15)) //
            ) //
            .count();
        assertEquals(count, 2);

        //  基于 and(g -> g.xxx)
        count = query.find(User.class) //
            .where() //
            .gt(User::getId, 1) //
            .and( //
                (Function<EntityQueryConditionGroup<User>,
                    EntityQueryConditionGroupLogic<User>>) g -> g
                        .group(g1 -> g1.eq(User::getId, 2).and().eq(User::getAge, 5)) //
                        .or() //
                        .group(g2 -> g2.eq(User::getId, 3).and().eq(User::getAge, 15)) //
            ) //
            .count();
        assertEquals(count, 2);

        //  混合使用1
        count = query.find(User.class) //
            .where() //
            .gt(User::getId, 1) //
            .and() //
            .group() //
            /**/ .group(g -> g.eq(User::getId, 2).and().eq(User::getAge, 5)) //
            /**/ .or() //
            /**/ .group(g -> g.eq(User::getId, 3).and().eq(User::getAge, 15)) //
            .endGroup() //
            .count();
        assertEquals(count, 2);

        //  混合使用2
        count = query.find(User.class) //
            .where() //
            .gt(User::getId, 1) //
            .and( //
                (Function<EntityQueryConditionGroup<User>,
                    EntityQueryConditionGroupLogic<User>>) g -> g.group().eq(User::getId, 2).and().eq(User::getAge, 5)
                        .endGroup() //
                        .or() //
                        .group().eq(User::getId, 3).and().eq(User::getAge, 15).endGroup() //
            ) //
            .count();
        assertEquals(count, 2);

        // 混合使用，这个使用方法不建议，太难看懂了
        count = query.find(User.class) //
            .where() //
            .gt(User::getId, 1) //
            .and( //
                (Function<EntityQueryConditionGroup<User>,
                    EntityQueryConditionGroupLogic<User>>) g -> g
                        .group(g1 -> g1.eq(User::getId, 2).and().eq(User::getAge, 5).endGroup() //
                            .or() //
                            .group(g2 -> g2.eq(User::getId, 3).and().eq(User::getAge, 15))))
            .count();
        assertEquals(count, 2);
    }

    // @Test
    // void test1111() {
    // JdbcClassMapping<?> classMapping =
    // mappingFactory.getClassMapping(Tree2.class);
    // System.err.println(ClassMappingUtils.getSelectColumnsSql(classMapping,
    // "t0", Dialects.MYSQL, mappingFactory,
    // new ChainMapImpl<String, String>().putChain("parent", "t1")));
    //
    // }

    @Test
    void testCoverage() {
        EntitySqlQueryExpression<User> q = (EntitySqlQueryExpression<User>) query.find(User.class).where();
        String sql = q.toString();
        String sql2 = q.expression();
        assertNotNull(sql);
        assertNotNull(sql2);
        assertEquals(sql, sql2);
    }
}
