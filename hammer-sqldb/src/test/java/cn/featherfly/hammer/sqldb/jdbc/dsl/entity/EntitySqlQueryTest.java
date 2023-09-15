
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.structure.page.SimplePage;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.EntitySqlQueryExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.DistrictDivision;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Order;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Tree;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserRole2;
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
        query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory);
    }

    @BeforeMethod
    void setupMethod() {
        userInfo = null;
        user = null;
        uid = 1;
        trees = new ArrayList<>();
    }

    @Test
    void testList() {
        List<Order> list = query.find(Order.class).list();
        assertTrue(list.size() > 0);
    }

    @Test
    void testLimit() {
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
    void testSort() {
        List<User> users = query.find(User.class).sort().asc(User::getId).limit(2).list();
        assertTrue(users.size() == 2);
        assertTrue(users.get(0).getId() < users.get(1).getId());

        users = query.find(User.class).sort().desc(User::getId).limit(2).list();
        assertTrue(users.size() == 2);
        assertTrue(users.get(0).getId() > users.get(1).getId());
    }

    @Test
    void testConditionConfig() {
        assertEquals(query.find(User.class).where(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)).getIgnoreStrategy(),
                IgnoreStrategy.EMPTY);

        List<User> users = query.find(User.class).where(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY))
                .eq(User::getUsername, "").list();
        assertTrue(users.size() > 0);

        users = query.find(User.class).where(c -> c.setIgnoreStrategy(IgnoreStrategy.NULL)).eq(User::getUsername, "")
                .list();
        assertTrue(users.size() == 0);

        users = query.find(User.class).where(c -> c.setIgnoreStrategy(IgnoreStrategy.NULL)).eq(User::getUsername, null)
                .list();
        assertTrue(users.size() > 0);

        users = query.find(User.class).where(c -> c.setIgnoreStrategy(IgnoreStrategy.NONE)).eq(User::getUsername, null)
                .list();
        assertTrue(users.size() == 0);

        users = query.find(User.class).where(c -> c.setIgnoreStrategy(IgnoreStrategy.NONE)).eq(User::getUsername, "")
                .list();
        assertTrue(users.size() == 0);
    }

    @Test
    void testIgnorePolicy() {
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
    void testCount() {
        Long number = query.find("user").count();
        System.out.println("count:" + number);

        Long number2 = query.find(User.class).count();
        System.out.println("count:" + number2);
        assertTrue(number2 > 0);
        assertEquals(number, number2);

        number = query.find("user").where().eq("age", 5).count();
        assertTrue(number == 2);

        number2 = query.find(User.class).where().eq(User::getAge, 5).count();
        assertTrue(number2 == 2);
        assertEquals(number, number2);

    }

    @Test
    void testAvg() {
        Integer number = query.find("user").avg("age").integer();
        System.out.println("avg:" + number);
        assertTrue(number > 0);

        //        query.find("user").integer(); 没有使用property或各种统计方法，则无法调用返回单个参数的方法
        //        query.find("user").where().eq("id", "id").integer(); 这里没有实现上面的逻辑

        Integer number2 = query.find(User.class).avg(User::getAge).integer();
        System.out.println("avg:" + number2);
        assertTrue(number2 > 0);
        assertEquals(number, number2);

        number = query.find("user").avg("age").where().eq("age", 5).integer();
        assertTrue(number == 5);

        number2 = query.find(User.class).avg(User::getAge).where().eq(User::getAge, 5).integer();
        assertTrue(number2 == 5);
        assertEquals(number, number2);
    }

    @Test
    void testSum() {
        Long count = query.find("user").where().eq("age", 5).count();

        Integer number = query.find("user").sum("age").where().eq("age", 5).integer();
        System.out.println("sum:" + number);
        assertTrue(number > 0);
        assertTrue(number == count * 5);

        Integer number2 = query.find(User.class).sum(User::getAge).where().eq(User::getAge, 5).integer();
        System.out.println("avg:" + number2);
        assertTrue(number2 > 0);
        assertTrue(number == count * 5);
        assertEquals(number, number2);
    }

    @Test
    void testMin() {

        Integer number = query.find("user").min("age").integer();
        System.out.println("min:" + number);
        assertTrue(number == 5);

        Integer number2 = query.find(User.class).min(User::getAge).integer();
        System.out.println("min:" + number2);
        assertTrue(number2 == 5);
        assertEquals(number, number2);
    }

    @Test
    void testMax() {

        Integer number = query.find("user").max("age").integer();
        System.out.println("min:" + number);
        assertTrue(number == 55);

        Integer number2 = query.find(User.class).max(User::getAge).integer();
        System.out.println("min:" + number2);
        assertTrue(number2 == 55);
        assertEquals(number, number2);
    }

    @SuppressWarnings("unchecked")
    @Test
    void testMapping() {

        query.find(User.class).where().eq(User::getUsername, "yufei").and().eq(User::getPwd, "123456").and().group()
                .gt(User::getAge, 18).and().lt(User::getAge, 60).list();

        query.find(User.class).where().eq(User::getUsername, "yufei").and().eq(User::getPwd, "123456").and().group()
                .gt(User::getAge, 18).and().property(User::getAge).lt(60).list();

        query.find(User.class).property(User::getUsername, User::getPwd, User::getAge).where()
                .eq(User::getUsername, "yufei").and().eq(User::getPwd, "123456").and().group().gt(User::getAge, 18)
                .and().lt(User::getAge, 60).list();
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
                .eq(User::getUsername, "yufei").and().eq(User::getPwd, "123456").and().group().gt(User::getAge, 18)
                .and().lt(User::getAge, 60).list();
    }

    @Test
    void testMapping2() {

        User user = new User();
        user.setUsername("yufei");
        user.setPwd("123456");
        query.find(User.class).where().eq(user::getUsername).and().eq(user::getPwd).list();
    }

    @SuppressWarnings("unchecked")
    @Test
    void testPropertyExpression() {

        query.find(User.class).where()//
                .property(User::getUsername).eq("yufei") //
                .and().property(User::getPwd).eq("123456") //
                .list();

        query.find(User.class).where().property(User::getUsername).eq("yufei").and().property(User::getPwd).eq("123456")
                .and().group().property(User::getAge).gt(18).and().property(User::getAge).lt(60).list();

        query.find(User.class).where().property(User::getUsername).eq("yufei").and().property(User::getPwd).eq("123456")
                .and().group().gt(User::getAge, 18).and().property(User::getAge).lt(60).list();

        query.find(User.class).property(User::getUsername, User::getPwd, User::getAge).where()
                .eq(User::getUsername, "yufei").and().eq(User::getPwd, "123456").and().group().gt(User::getAge, 18)
                .and().lt(User::getAge, 60).list();

        query.find(User.class).property(User::getUsername, User::getPwd, User::getAge).where()
                .eq(User::getUsername, "yufei").and().eq(User::getPwd, "123456").and().group().gt(User::getAge, 18)
                .and().lt(User::getAge, 60).list();
    }

    @Test
    void testNestedMapping() {
        Integer userId = 1;
        //        UserInfo userInfo = query.find(UserInfo.class).where().eq("user.id", userId).single();
        UserInfo userInfo = query.find(UserInfo.class).where().eq(UserInfo::getUser, userId).single();
        assertEquals(userInfo.getUser().getId(), userId);
        System.out.println(userInfo);
    }

    @Test
    void testNestedMapping2() {
        UserInfo userInfo = null;
        String province = "四川";
        //        userInfo = query.find(UserInfo.class).where().eq("division.province", province).single();
        //        userInfo = query.find(UserInfo.class).where().eq(UserInfo::getDivision, DistrictDivision::getProvince, province)
        //                .single(); // 使用下面这行代替
        userInfo = query.find(UserInfo.class).where().property(UserInfo::getDivision)
                .property(DistrictDivision::getProvince).eq(province).single(); // YUFEI_TEST 需要测试
        assertEquals(userInfo.getDivision().getProvince(), province);
        System.out.println(userInfo);
    }

    @Test
    void testManyToOne() {

        int parent = 1;
        List<Tree> list = query.find(Tree.class).where().eq(Tree::getParent, parent).list();
        System.out.println(list);
        for (Tree t : list) {
            assertTrue(parent == t.getParent().getId());
        }
    }

    @Test
    void testManyToOne2() {

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
    void testNestedProperty() {

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
        assertTrue(list.size() == size);

        list = query.find(UserInfo.class).where().eq(UserInfo::getDivision, null).or().eq(UserInfo::getDivision, null)
                .list();
        assertTrue(list.size() > size);
    }

    @Test
    void testNestedProperty2() {

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
        assertTrue(list.size() == size);

        list = query.find(UserInfo.class).where().eq(UserInfo::getDivision, null).or().eq(UserInfo::getDivision, null)
                .list();
        assertTrue(list.size() > size);
    }

    @Test
    void testNestedProperty3() {
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
        assertTrue(list.size() == size);

        list = query.find(UserInfo.class).where()//
                .property(UserInfo::getDivision).eq(null)//
                .or() //
                .property(UserInfo::getDivision).eq(null)//
                .list();
        assertTrue(list.size() > size);

        list = query.find(UserInfo.class).where()//
                .property(UserInfo::getDivision).eq(null)//
                .or() //
                .property(UserInfo::getDivision).eq(null)//
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
    void testNestedProperty4() {
        Integer rid = 2;
        Integer uid = 1;

        Role role = query.find(Role.class).where().eq(Role::getId, rid).single();
        User user = query.find(User.class).where().eq(User::getId, uid).single();
        assertEquals(rid, role.getId());
        assertEquals(uid, user.getId());

        List<UserRole2> list = query.find(UserRole2.class) //
                .where() //
                .property(UserRole2::getRole).property(Role::getName).eq(role.getName()) //
                .list();

        for (UserRole2 ur : list) {
            Role r = query.find(Role.class).where().eq(Role::getId, ur.getRole().getId()).single();
            assertEquals(r.getName(), role.getName());
        }
    }

    @Test
    void testInn() {

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
    void testComplexQuery() {

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

        //  基于group(g -> g.xxx)
        count = query.find(User.class) //
                .where() //
                .gt(User::getId, 1) //
                .and( //
                        g -> g.group(g1 -> g1.eq(User::getId, 2).and().eq(User::getAge, 5)) //
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
                        g -> g.group().eq(User::getId, 2).and().eq(User::getAge, 5).endGroup() //
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
                        g -> g.group(g1 -> g1.eq(User::getId, 2).and().eq(User::getAge, 5).endGroup() //
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
        String sql2 = q.build();
        assertNotNull(sql);
        assertNotNull(sql2);
        assertEquals(sql, sql2);
    }
}
