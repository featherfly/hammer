
package cn.featherfly.hammer.sqldb.dsl.repository;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;

/**
 * entity sql query join 5 times test.
 *
 * @author zhongj
 */
public class RepositorySqlQueryJoin5EqTest extends AbstractRepositorySqlQueryTest {

    @Test
    void joinOnce() {
        List<Map<String, Serializable>> list = query.find("user").fields("username", "password", "age") //
            .join("user_info").on("user_id") //
            .where().eq2("name", name1) //
            .list();
        assertEquals(list.size(), 1);

        //        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
        //                .eq(1, "name", name1).list();
        list = query.find("user").fields("username", "password", "age") //
            .join("user_info").on("user_id") //
            .where() //
            .eq2(UserInfo::getName, name1) //
            .list();
        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
            .eq((r1, r2) -> r2.accept("name", name1)).list();
        assertEquals(list.size(), 1);
        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
            .eq((r1, r2) -> r2.field("name").value(name1)).list();
        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
            .field((e0, e1) -> e0.field("username").eq(username2).and().field("age").eq(age2)) //
            .list();
        assertEquals(list.size(), 1);
        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
            .field((e0, e1) -> e0.field("username").eq(username2).and().fieldAsNumber("age").eq(age2)) //
            .list();
        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
            .field((e0, e1) -> e1.field("name").eq(name2).and(e0.field("age").eq(age2))) //
            .list();
        assertEquals(list.size(), 1);
        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
            .field((e0, e1) -> e1.field("name").eq(name2).and(e0.fieldAsNumber("age").eq(age2))) //
            .list();
        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
            .field(es -> es.get1(), "name").eq(name1).list();
        assertEquals(list.size(), 1);
    }

    @Test
    void joinTwice() {
        List<Map<String, Serializable>> list = query.find("user").fields("username", "password", "age") //
            .join("user_info").on("user_id") //
            .where().eq2("name", name1) //
            .list();
        assertEquals(list.size(), 1);

        //        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
        //                .eq(1, "name", name1).list();
        list = query.find("user").fields("username", "password", "age") //
            .join("user_info").on("user_id") //
            .where() //
            .eq2(UserInfo::getName, name1) //
            .list();
        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
            .eq((r1, r2) -> r2.accept("name", name1)).list();
        assertEquals(list.size(), 1);
        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
            .eq((r1, r2) -> r2.field("name").value(name1)).list();
        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
            .field((e0, e1) -> e0.field("username").eq(username2).and().field("age").eq(age2)) //
            .list();
        assertEquals(list.size(), 1);
        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
            .field((e0, e1) -> e0.field("username").eq(username2).and().fieldAsNumber("age").eq(age2)) //
            .list();
        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
            .field(es -> es.get1(), "name").eq(name1).list();
        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
            .field((e0, e1) -> e1.field("name").eq(name2).and(e0.field("age").eq(age2))) //
            .list();
        assertEquals(list.size(), 1);
        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
            .field((e0, e1) -> e1.field("name").eq(name2).and(e0.fieldAsNumber("age").eq(age2))) //
            .list();
        assertEquals(list.size(), 1);
    }

    @Test
    void testJoin1() {
        Map<String, Serializable> order = null;
        order = query.find(ORDER_REPO) //
            .join(USER_REPO).on((r1, j) -> r1.field("create_user").eq(j.field("id"))) //
            .where() //
            .eq("id", oid1) //
            .single();
        assertNotNull(order);
        assertEquals(((Number) order.get("id")).intValue(), oid1.intValue());
    }

    @Test
    void testJoin2() {
        Map<String, Serializable> order = null;
        order = query.find(ORDER_REPO) //
            .join(USER_REPO).on((r1, j) -> r1.field("create_user").eq(j.field("id"))) //
            .join(USER_REPO).on((r1, r2, j) -> r1.field("update_user").eq(j.field("id"))) //
            .where() //
            .eq("id", oid1) //
            .single();
        assertNotNull(order);
        assertEquals(((Number) order.get("id")).intValue(), oid1.intValue());
    }

    @Test
    void testJoin3() {
        Map<String, Serializable> order = null;
        order = query.find(ORDER_REPO) //
            .join(USER_REPO).on((r1, j) -> r1.field("create_user").eq(j.field("id"))) //
            .join(USER_REPO).on((r1, r2, j) -> r1.field("update_user").eq(j.field("id"))) //
            .join(USER_REPO).on((r1, r2, r3, j) -> r1.field("user1").eq(j.field("id"))) //
            .where() //
            .eq("id", oid1) //
            .single();
        assertNotNull(order);
        assertEquals(((Number) order.get("id")).intValue(), oid1.intValue());
    }

    @Test
    void testJoin4() {
        Map<String, Serializable> order = null;
        order = query.find(ORDER_REPO) //
            .join(USER_REPO).on((r1, j) -> r1.field("create_user").eq(j.field("id"))) //
            .join(USER_REPO).on((r1, r2, j) -> r1.field("update_user").eq(j.field("id"))) //
            .join(USER_REPO).on((r1, r2, r3, j) -> r1.field("user1").eq(j.field("id"))) //
            .join(USER_REPO).on((r1, r2, r3, r4, j) -> r1.field("user2").eq(j.field("id"))) //
            .where() //
            .eq("id", oid1) //
            .single();
        assertNotNull(order);
        assertEquals(((Number) order.get("id")).intValue(), oid1.intValue());
    }

    @Test
    void testJoin5() {
        Map<String, Serializable> order = null;
        //        order = query.find(ORDER_REPO) //
        //            .join(USER_REPO).on((r1, j) -> r1.field("create_user").eq(j.field("id"))) //
        //            .join(USER_REPO).on((r1, r2, j) -> r1.field("update_user").eq(j.field("id"))) //
        //            .join(USER_REPO).on((r1, r2, r3, j) -> r1.field("user1").eq(j.field("id"))) //
        //            .join(USER_REPO).on((r1, r2, r3, r4, j) -> r1.field("user2").eq(j.field("id"))) //
        //            .join(USER_REPO).on((r1, r2, r3, r4, r5, j) -> r1.field("user3").eq(j.field("id"))) //
        //            .where() //
        //            .eq("id", oid1) //
        //            .single();
        //        assertNotNull(order);
        //        assertEquals(((Number) order.get("id")).intValue(), oid1.intValue());

        // ENHANCE 当前实现方法性能太差了，后续必须优化，运行全部单元测试时，到这里性能是正常的，应该是和内存申请有关
        order = query.find(ORDER_REPO) //
            .join(USER_REPO).on((r1, j) -> r1.field("create_user").eq(j.field("id"))).fetch() //
            .join(USER_REPO).on((r1, r2, j) -> r1.field("update_user").eq(j.field("id"))).fetch() //
            .join(USER_REPO).on((r1, r2, r3, j) -> r1.field("user1").eq(j.field("id"))).fetch() //
            .join(USER_REPO).on((r1, r2, r3, r4, j) -> r1.field("user2").eq(j.field("id"))).fetch() //
            .join(USER_REPO).on((r1, r2, r3, r4, r5, j) -> r1.field("user3").eq(j.field("id"))).fetch() //
            .where() // ENHANCE 这里比较慢
            .eq("id", oid1) //
            .single();
        System.out.println(order);
        //        assertNotNull(orderUser5.get0());
        //        assertNotNull(orderUser5.get1());
        //        assertNotNull(orderUser5.get2());
        //        assertNotNull(orderUser5.get3());
        //        assertNotNull(orderUser5.get4());
        //        assertNotNull(orderUser5.get5());
        //
        //        assertEquals(order.getCreateUser(), orderUser5.get1().getId());
        //        assertEquals(order.getUpdateUser(), orderUser5.get2().getId());
        //        assertEquals(order.getUser1(), orderUser5.get3().getId());
        //        assertEquals(order.getUser2(), orderUser5.get4().getId());
        //        assertEquals(order.getUser3(), orderUser5.get5().getId());
    }

}
