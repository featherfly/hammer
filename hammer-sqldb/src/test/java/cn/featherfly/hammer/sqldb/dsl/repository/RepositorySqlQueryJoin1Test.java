
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-22 18:05:22
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.Table;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.SimpleAliasRepository;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.Order2;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.User2;

/**
 * RepositorySqlQueryJoin1Test.
 *
 * @author zhongj
 */
public class RepositorySqlQueryJoin1Test extends AbstractRepositorySqlQueryTest {

    @Test
    public void joinFetchFields() {
        final String table = "user";
        final Table tm = metadata.getTable(table);

        map = query.find(table)//
            .limit(1) //
            .single();
        assertFields(map, tm.getColumns().stream().map(c -> c.name()).toArray(n -> new String[n]));

        map = query.find(table)//
            .join("user_info").on("user_id") //
            .limit(1).single();
        assertFields(map, tm.getColumns().stream().map(c -> c.name()).toArray(n -> new String[n]));
    }

    @Test
    void joinFetch() {
        String[] fields = Lang.array("username", "password", "age");
        String[] joinFields = Lang.array("id", "name", "user_id");
        String queryTableAlias = "_user0";
        String joinTableAlias = "_user_info0";
        // AliasManger with default alias generetor
        list = query.find("user").fields(fields) //
            .join("user_info").on("user_id").fetch(joinFields) //
            .list();
        assertFields(list, Arrays.stream(fields).map(f -> queryTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(joinFields).map(f -> joinTableAlias + "." + f).toArray(num -> new String[num]));

        list = query.find("user").fields("username", "password").field("age") //
            .join("user_info").on("user_id").fetch("id", "name").fetch("user_id") //
            .list();
        assertFields(list, Arrays.stream(fields).map(f -> queryTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(joinFields).map(f -> joinTableAlias + "." + f).toArray(num -> new String[num]));

        String[] joinFields2 = Lang.array("id", "name", "userId");
        list = query.find("user").fields(fields) //
            .join("user_info").on("user_id").fetch((repo, fieldBuilder) -> repo.fetch( //
                fieldBuilder.name("id"), //
                fieldBuilder.name("name"), //
                fieldBuilder.name("user_id").as("userId"))) //
            .list();
        assertFields(list, Arrays.stream(fields).map(f -> queryTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(joinFields2).map(f -> joinTableAlias + "." + f).toArray(num -> new String[num]));

        list = query.find("user").fields(fields) //
            .join("user_info").on("user_id").fetch((repo, fieldBuilder) -> repo.field( //
                fieldBuilder.name("id"), //
                fieldBuilder.name("name"), //
                fieldBuilder.name("user_id").as("userId"))) //
            .list();
        assertFields(list, Arrays.stream(fields).map(f -> queryTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(joinFields2).map(f -> joinTableAlias + "." + f).toArray(num -> new String[num]));

        list = query.find("user").fields(fields) //
            .join("user_info").on("user_id").fetch((repo, fieldBuilder) -> repo.fetch(fieldBuilder.name("id")) //
                .fetch(fieldBuilder.name("name")) //
                .fetch(fieldBuilder.name("user_id").as("userId")) //
            ) //
            .list();
        assertFields(list, Arrays.stream(fields).map(f -> queryTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(joinFields2).map(f -> joinTableAlias + "." + f).toArray(num -> new String[num]));

        list = query.find("user").fields(fields) //
            .join("user_info").on("user_id").fetch((repo, fieldBuilder) -> repo.field(fieldBuilder.name("id")) //
                .field(fieldBuilder.name("name")) //
                .field(fieldBuilder.name("user_id").as("userId")) //
            ) //
            .list();
        assertFields(list, Arrays.stream(fields).map(f -> queryTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(joinFields2).map(f -> joinTableAlias + "." + f).toArray(num -> new String[num]));
    }

    @Test
    void joinFetchAssignAlias() {
        String[] fields = Lang.array("username", "password", "age");
        String[] joinFields = Lang.array("id", "name", "user_id");
        String queryTableAlias = "u";
        String joinTableAlias = "ui";
        list = query.find(new SimpleAliasRepository("user", queryTableAlias)).fields(fields) //
            .join(new SimpleAliasRepository("user_info", joinTableAlias)).on("user_id").fetch(joinFields) //
            .list();
        assertFields(list, Arrays.stream(fields).map(f -> queryTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(joinFields).map(f -> joinTableAlias + "." + f).toArray(num -> new String[num]));

        list = query.find(r -> r.name("user").as(queryTableAlias)).fields(fields) //
            .join(r -> r.name("user_info").as(joinTableAlias)).on("user_id").fetch(joinFields) //
            .list();
        assertFields(list, Arrays.stream(fields).map(f -> queryTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(joinFields).map(f -> joinTableAlias + "." + f).toArray(num -> new String[num]));

        // ----------------------------------------------------------------------------------------------------------------

        list = query.find(new SimpleAliasRepository("user", queryTableAlias)).fields("username", "password")
            .field("age") //
            .join(new SimpleAliasRepository("user_info", joinTableAlias)).on("user_id").fetch("id", "name")
            .fetch("user_id") //
            .list();
        assertFields(list, Arrays.stream(fields).map(f -> queryTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(joinFields).map(f -> joinTableAlias + "." + f).toArray(num -> new String[num]));

        list = query.find(r -> r.name("user").as(queryTableAlias)).fields("username", "password").field("age") //
            .join(r -> r.name("user_info").as(joinTableAlias)).on("user_id").fetch("id", "name").fetch("user_id") //
            .list();
        assertFields(list, Arrays.stream(fields).map(f -> queryTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(joinFields).map(f -> joinTableAlias + "." + f).toArray(num -> new String[num]));

        // ----------------------------------------------------------------------------------------------------------------

        String[] joinFields2 = Lang.array("id", "name", "userId");
        list = query.find(new SimpleAliasRepository("user", queryTableAlias)).fields(fields) //
            .join(new SimpleAliasRepository("user_info", joinTableAlias)).on("user_id")
            .fetch((repo, fieldBuilder) -> repo.fetch( //
                fieldBuilder.name("id"), //
                fieldBuilder.name("name"), //
                fieldBuilder.name("user_id").as("userId"))) //
            .list();
        assertFields(list, Arrays.stream(fields).map(f -> queryTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(joinFields2).map(f -> joinTableAlias + "." + f).toArray(num -> new String[num]));

        list = query.find(r -> r.name("user").as(queryTableAlias)).fields(fields) //
            .join(r -> r.name("user_info").as(joinTableAlias)).on("user_id").fetch((repo, fieldBuilder) -> repo.fetch( //
                fieldBuilder.name("id"), //
                fieldBuilder.name("name"), //
                fieldBuilder.name("user_id").as("userId"))) //
            .list();
        assertFields(list, Arrays.stream(fields).map(f -> queryTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(joinFields2).map(f -> joinTableAlias + "." + f).toArray(num -> new String[num]));

        // ----------------------------------------------------------------------------------------------------------------

        list = query.find(new SimpleAliasRepository("user", queryTableAlias)).fields(fields) //
            .join(new SimpleAliasRepository("user_info", joinTableAlias)).on("user_id")
            .fetch((repo, fieldBuilder) -> repo.field( //
                fieldBuilder.name("id"), //
                fieldBuilder.name("name"), //
                fieldBuilder.name("user_id").as("userId"))) //
            .list();
        assertFields(list, Arrays.stream(fields).map(f -> queryTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(joinFields2).map(f -> joinTableAlias + "." + f).toArray(num -> new String[num]));
        list = query.find(r -> r.name("user").as(queryTableAlias)).fields(fields) //
            .join(r -> r.name("user_info").as(joinTableAlias)).on("user_id").fetch((repo, fieldBuilder) -> repo.field( //
                fieldBuilder.name("id"), //
                fieldBuilder.name("name"), //
                fieldBuilder.name("user_id").as("userId"))) //
            .list();
        assertFields(list, Arrays.stream(fields).map(f -> queryTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(joinFields2).map(f -> joinTableAlias + "." + f).toArray(num -> new String[num]));

        // ----------------------------------------------------------------------------------------------------------------

        list = query.find(new SimpleAliasRepository("user", queryTableAlias)).fields(fields) //
            .join(new SimpleAliasRepository("user_info", joinTableAlias)).on("user_id")
            .fetch((repo, fieldBuilder) -> repo.fetch(fieldBuilder.name("id")) //
                .fetch(fieldBuilder.name("name")) //
                .fetch(fieldBuilder.name("user_id").as("userId")) //
            ) //
            .list();
        assertFields(list, Arrays.stream(fields).map(f -> queryTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(joinFields2).map(f -> joinTableAlias + "." + f).toArray(num -> new String[num]));
        list = query.find(r -> r.name("user").as(queryTableAlias)).fields(fields) //
            .join(r -> r.name("user_info").as(joinTableAlias)).on("user_id")
            .fetch((repo, fieldBuilder) -> repo.fetch(fieldBuilder.name("id")) //
                .fetch(fieldBuilder.name("name")) //
                .fetch(fieldBuilder.name("user_id").as("userId")) //
            ) //
            .list();
        assertFields(list, Arrays.stream(fields).map(f -> queryTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(joinFields2).map(f -> joinTableAlias + "." + f).toArray(num -> new String[num]));

        // ----------------------------------------------------------------------------------------------------------------

        list = query.find(new SimpleAliasRepository("user", queryTableAlias)).fields(fields) //
            .join(new SimpleAliasRepository("user_info", joinTableAlias)).on("user_id")
            .fetch((repo, fieldBuilder) -> repo.field(fieldBuilder.name("id")) //
                .field(fieldBuilder.name("name")) //
                .field(fieldBuilder.name("user_id").as("userId")) //
            ) //
            .list();
        assertFields(list, Arrays.stream(fields).map(f -> queryTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(joinFields2).map(f -> joinTableAlias + "." + f).toArray(num -> new String[num]));
        list = query.find(r -> r.name("user").as(queryTableAlias)).fields(fields) //
            .join(r -> r.name("user_info").as(joinTableAlias)).on("user_id")
            .fetch((repo, fieldBuilder) -> repo.field(fieldBuilder.name("id")) //
                .field(fieldBuilder.name("name")) //
                .field(fieldBuilder.name("user_id").as("userId")) //
            ) //
            .list();
        assertFields(list, Arrays.stream(fields).map(f -> queryTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(joinFields2).map(f -> joinTableAlias + "." + f).toArray(num -> new String[num]));
    }

    @Test
    void joinCondition() {
        //        List<Map<String, Serializable>> list = query.find("user").fields("username", "password", "age") //
        //                .join("user_info").on("user_id") //
        //                .where().eq("user_info", "name", "羽飞") //
        //                .list();
        List<Map<String, Serializable>> list = query.find("user").fields("username", "password", "age") //
            .join("user_info").on("user_id") //
            .where().eq2("name", "羽飞") //
            .list();
        assertEquals(list.size(), 1);

        //        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
        //                .eq(1, "name", "羽飞").list();
        list = query.find("user").fields("username", "password", "age") //
            .join("user_info").on("user_id") //
            .where() //
            .eq2(UserInfo::getName, "羽飞") //
            .list();
        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
            .eq((r1, r2) -> r2.accept("name", "羽飞")).list();
        assertEquals(list.size(), 1);
        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
            .eq((r1, r2) -> r2.field("name").value("羽飞")).list();
        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
            .field((e0, e1) -> e0.field("username") //
                .eq("yufei") //
                .and() //
                .field("age") //
                .gt(18) //
            ) //
            .list();
        assertEquals(list.size(), 0);

        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
            .field((e0, e1) -> e0.field("username") //
                .eq("featherfly") //
                .and() //
                .field("age") //
                .eq(5) //
            ) //
            .list();
        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
            .field((e0, e1) -> e0.field("username").eq("yufei").and().fieldAsNumber("age").gt(18)) //
            .list();
        assertEquals(list.size(), 0);
        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
            .field((e0, e1) -> e0.field("username").eq(username2).and().fieldAsNumber("age").eq(age2)) //
            .list();
        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
            .field(es -> es.get1(), "name").eq("羽飞").list();
        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id").where()
            .field((e0, e1) -> e0.field("username").eq(username2).and().fieldAsNumber("age").eq(age2) //
                .and(e1.field("name").eq(name2)) //
            ) //
            .list();
        assertEquals(list.size(), 1);

    }

    @Test
    void joinCondition2() {
        List<Map<String, Serializable>> list = query.find("user").fields("username", "password", "age") //
            .join("user_info").on("user_id") //
            .where((r1, r2) -> r2.field("name").eq("羽飞"))//
            .list();
        assertEquals(list.size(), 1);

        //        list = query.find("user").fields("username", "password", "age") //
        //            .join("user_info").on("user_id") //
        //            .where((r1, r2) -> r2.field(UserInfo::getName).eq("羽飞")) // TODO 是否需要加入UserInfo::getName方法定义后续再考虑
        //            .list();
        //        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id") //
            .where((r1, r2) -> r1.field("username").eq("yufei") //
                .and().field("age").gt(18)) //
            .list();
        assertEquals(list.size(), 0);

        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id") //
            .where((r1, r2) -> r1.field("username").eq("yufei") //
                .and().fieldAsNumber("age").gt(18)) //
            .list();
        assertEquals(list.size(), 0);

        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id") //
            .where((r1, r2) -> r1.field("username").eq("featherfly") //
                .and().field("age").eq(5)) //
            .list();
        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id") //
            .where((r1, r2) -> r1.field("username").eq("featherfly") //
                .and().fieldAsNumber("age").eq(5)) //
            .list();
        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age").join("user_info").on("user_id") //
            .where((e0, e1) -> e0.field("username").eq(username2).and().fieldAsNumber("age").eq(age2) //
                .and(e1.field("name").eq(name2)) //
            ) //
            .list();
        assertEquals(list.size(), 1);
    }

    @Test
    void joinCondition2_EqColumn() {
        List<Map<String, Serializable>> list = query.find("user").fields("username", "password", "age")
            .join("user_info").on("user_id") //
            .where((e0, e1) -> e0.field("username").eq(e1.field("name"))) //
            .list();
        assertEquals(list.size(), 2);
    }

    @Test
    void join_on_two_fields() {
        Map<String, Serializable> order = query.find(ORDER_REPO) //
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
