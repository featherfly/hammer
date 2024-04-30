
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.Map;

import org.testng.annotations.Test;

/**
 * entity sql query join 5 times test.
 *
 * @author zhongj
 */
public class RepositorySqlQueryJoin5Test extends AbstractRepositorySqlQueryTest {

    @Test
    void testJoin1() {
        Map<String, Object> order = null;
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
        Map<String, Object> order = null;
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
        Map<String, Object> order = null;
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
        Map<String, Object> order = null;
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
        Map<String, Object> order = null;
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

    @Test
    void testJoin5_2() {
        Map<String, Object> order = null;
        order = query.find(ORDER_REPO) //
            .join(USER_REPO).on("id", "create_user").fetch() //
            .join(USER_REPO).on("id", "update_user").fetch() //
            .join(USER_REPO).on("id", "user1").fetch() //
            .join(USER_REPO).on("id", "user2").fetch() //
            .join(USER_REPO).on("id", "user3").fetch() //
            .where() // ENHANCE 这里比较慢
            .eq("id", oid1) //
            .single();
        System.out.println(order);
    }
}
