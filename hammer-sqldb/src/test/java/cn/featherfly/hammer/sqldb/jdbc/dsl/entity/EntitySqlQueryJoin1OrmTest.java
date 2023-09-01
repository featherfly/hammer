
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import static org.junit.Assert.assertNull;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.repository.IgnoreStrategy;
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
    }
}
