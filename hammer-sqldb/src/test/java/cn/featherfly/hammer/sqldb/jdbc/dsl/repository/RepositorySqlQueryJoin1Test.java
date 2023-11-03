
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-22 18:05:22
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.testng.annotations.Test;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.Order2;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.User2;

/**
 * RepositorySqlQueryJoin1Test.
 *
 * @author zhongj
 */
public class RepositorySqlQueryJoin1Test extends AbstractRepositorySqlQueryTest {

    @Test
    void join_on_two_fields() {
        Map<String, Object> order = query.find(ORDER_REPO) //
                .join(USER_REPO).on("id", "create_user") //
                .where() //
                .eq("id", oid1) //
                .single();
        assertNotNull(order);
        assertEquals(order.get("id"), oid1.intValue());

        order = query.find(ORDER_REPO) //
                .join(USER_REPO).on("id", "create_user") //
                .where().configure(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)) //
                .eq("id", oid1) //
                .single();
        assertNotNull(order);
        assertEquals(order.get("id"), oid1.intValue());

        Order2 order2 = query.find(ORDER_REPO) //
                .join(USER_REPO).on("id", "create_user") //
                .where() //
                .eq("id", oid1) //
                .single(Order2.class);
        assertNotNull(order2);
        assertEquals(order2.getId(), oid1);

        order2 = query.find(ORDER_REPO) //
                .join(USER_REPO).on("id", "create_user") //
                .where().configure(c -> c.setIgnoreStrategy(IgnoreStrategy.EMPTY)) //
                .eq("id", oid1) //
                .single(Order2.class);
        assertNotNull(order2);
        assertEquals(order2.getId(), oid1);

        Tuple2<Order2, User2> orderUser = query.find(ORDER_REPO) //
                .join(USER_REPO).on("id", "create_user").fetch() //
                .where() //
                .eq("id", oid1) //
                .single(Order2.class, User2.class);
        // SELECT _order0.*, _user0.* FROM `order` _order0 JOIN `user` _user0 ON _user0.`id` = _order0.`create_user` WHERE _order0.`id` = ?
        // FIXME 生成的sql没有别名，所有就没有映射前缀（ _order0.id as _order0.id, _user0.id as _user0.id ）
        assertNotNull(orderUser);
        assertEquals(orderUser.get0().getId(), oid1);
        assertEquals(orderUser.get1().getId(), orderUser.get0().getCreateUser());
    }

    //    @Test
    //    void testJoin_on1_2() {
    //        Order2 order = query.find(Order2.class).join(User2.class).on(Order2::getCreateUser).where() //
    //                .eq((e1, e2) -> e1.accept(Order2::getId, oid1)) //
    //                .single();
    //        assertNotNull(order);
    //        assertEquals(order.getId(), oid1);
    //
    //        order = query.find(Order2.class).join(User2.class).on(Order2::getCreateUser).where() //
    //                .property((e1, e2) -> e1.property(Order2::getId).eq(oid1)) //
    //                .single();
    //        assertNotNull(order);
    //        assertEquals(order.getId(), oid1);
    //
    //        order = query.find(Order2.class).join(User2.class).on(Order2::getCreateUser).where() //
    //                .eq((e1, e2) -> e2.accept(User2::getId, uid1)) //
    //                .single();
    //        assertNotNull(order);
    //        assertEquals(order.getId(), oid1);
    //
    //        order = query.find(Order2.class).join(User2.class).on(Order2::getCreateUser).where() //
    //                .property((e1, e2) -> e2.property(User2::getId).eq(uid1)) //
    //                .single();
    //        assertNotNull(order);
    //        assertEquals(order.getId(), oid1);
    //
    //        // ****************************************************************************************************************
    //
    //        Tuple2<Order2, User2> orderUser = query.find(Order2.class).join(User2.class).on(Order2::getCreateUser).fetch() //
    //                .where() //
    //                .eq((e1, e2) -> e1.accept(Order2::getId, oid1)) //
    //                .single();
    //        assertNotNull(orderUser);
    //        assertEquals(orderUser.get0().getId(), oid1);
    //        assertEquals(orderUser.get1().getId(), orderUser.get0().getCreateUser());
    //
    //        orderUser = query.find(Order2.class).join(User2.class).on(Order2::getCreateUser).fetch().where() //
    //                .property((e1, e2) -> e1.property(Order2::getId).eq(oid1)) //
    //                .single();
    //        assertNotNull(orderUser);
    //        assertEquals(orderUser.get0().getId(), oid1);
    //        assertEquals(orderUser.get1().getId(), orderUser.get0().getCreateUser());
    //
    //        orderUser = query.find(Order2.class).join(User2.class).on(Order2::getCreateUser).fetch().where() //
    //                .eq((e1, e2) -> e2.accept(User2::getId, uid1)) //
    //                .single();
    //        assertNotNull(orderUser);
    //        assertEquals(orderUser.get0().getId(), oid1);
    //        assertEquals(orderUser.get1().getId(), orderUser.get0().getCreateUser());
    //
    //        orderUser = query.find(Order2.class).join(User2.class).on(Order2::getCreateUser).fetch().where() //
    //                .property((e1, e2) -> e2.property(User2::getId).eq(uid1)) //
    //                .single();
    //        assertNotNull(orderUser);
    //        assertEquals(orderUser.get0().getId(), oid1);
    //        assertEquals(orderUser.get1().getId(), orderUser.get0().getCreateUser());
    //    }
    //
    //    @Test
    //    void testJoin_on3() {
    //        Order2 order = query.find(Order2.class).join(User2.class).on(Order2::getCreateUser, User2::getId).where()
    //                .eq(Order2::getId, oid1).single();
    //        assertNotNull(order);
    //        assertEquals(order.getId(), oid1);
    //
    //        order = query.find(Order2.class).join(User2.class).on(Order2::getCreateUser, User2::getId).where()
    //                .eq2(User2::getId, uid1).single();
    //        assertNotNull(order);
    //        assertEquals(order.getId(), oid1);
    //
    //        // ****************************************************************************************************************
    //
    //        Tuple2<Order2, User2> orderUser = query.find(Order2.class).join(User2.class)
    //                .on(Order2::getCreateUser, User2::getId).fetch().where().eq(Order2::getId, oid1).single();
    //        assertNotNull(orderUser);
    //        assertEquals(orderUser.get0().getId(), oid1);
    //        assertEquals(orderUser.get1().getId(), orderUser.get0().getCreateUser());
    //    }
    //
    //    @Test
    //    void testJoin_on3_2() {
    //        Order2 order = query.find(Order2.class).join(User2.class).on(Order2::getCreateUser, User2::getId).where()
    //                .eq((e1, e2) -> e1.accept(Order2::getId, oid1)).single();
    //        assertNotNull(order);
    //        assertEquals(order.getId(), oid1);
    //
    //        order = query.find(Order2.class).join(User2.class).on(Order2::getCreateUser, User2::getId).where()
    //                .eq((e1, e2) -> e2.accept(User2::getId, uid1)).single();
    //        assertNotNull(order);
    //        assertEquals(order.getId(), oid1);
    //
    //        // ****************************************************************************************************************
    //
    //        Tuple2<Order2,
    //                User2> orderUser = query.find(Order2.class).join(User2.class).on(Order2::getCreateUser, User2::getId)
    //                        .fetch().where().eq((e1, e2) -> e1.accept(Order2::getId, oid1)).single();
    //        assertNotNull(orderUser);
    //        assertEquals(orderUser.get0().getId(), oid1);
    //        assertEquals(orderUser.get1().getId(), orderUser.get0().getCreateUser());
    //
    //        orderUser = query.find(Order2.class).join(User2.class).on(Order2::getCreateUser, User2::getId).fetch().where()
    //                .eq((e1, e2) -> e2.accept(User2::getId, uid1)).single();
    //        assertNotNull(orderUser);
    //        assertEquals(orderUser.get0().getId(), oid1);
    //        assertEquals(orderUser.get1().getId(), orderUser.get0().getCreateUser());
    //    }
    //
    //    @Test
    //    void testJoin_on2() {
    //        User2 user = query.find(User2.class).join(Order2.class).on(Order2::getCreateUser).where()
    //                .eq2(Order2::getId, oid1).single();
    //        assertNotNull(user);
    //        assertEquals(user.getId(), uid1);
    //
    //        // ****************************************************************************************************************
    //
    //        Tuple2<User2, Order2> userOrder = query.find(User2.class).join(Order2.class).on(Order2::getCreateUser).fetch()
    //                .where().eq2(Order2::getId, oid1).single();
    //        assertNotNull(userOrder);
    //        assertEquals(userOrder.get1().getId(), oid1);
    //        assertEquals(userOrder.get0().getId(), userOrder.get1().getCreateUser());
    //    }
    //
    //    @Test
    //    void testJoin_on2_2() {
    //        User2 user = query.find(User2.class).join(Order2.class).on(Order2::getCreateUser).where()
    //                .eq((e1, e2) -> e2.accept(Order2::getId, oid1)).single();
    //        assertNotNull(user);
    //        assertEquals(user.getId(), uid1);
    //
    //        // ****************************************************************************************************************
    //
    //        Tuple2<User2, Order2> userOrder = query.find(User2.class).join(Order2.class).on(Order2::getCreateUser).fetch()
    //                .where().eq((e1, e2) -> e2.accept(Order2::getId, oid1)).single();
    //        assertNotNull(userOrder);
    //        assertEquals(userOrder.get1().getId(), oid1);
    //        assertEquals(userOrder.get0().getId(), userOrder.get1().getCreateUser());
    //    }

}
