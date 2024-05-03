
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-22 18:05:22
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import cn.featherfly.common.db.Table;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Order;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;

/**
 * RepositorySqlQueryJoin1Test.
 *
 * @author zhongj
 */
public class RepositorySqlQueryJoin2Test extends AbstractRepositorySqlQueryTest {

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
            .join("order").on("user1") //
            .limit(1).single();
        assertFields(map, tm.getColumns().stream().map(c -> c.name()).toArray(n -> new String[n]));
    }

    @Test
    void joinFetch() {
        String[] fields = Lang.array("username", "password", "age");
        String[] joinFields = Lang.array("id", "name", "user_id");
        String[] join2Fields = Lang.array("no", "app_id");
        String queryTableAlias = "_user0";
        String joinTableAlias = "_user_info0";
        String joinTableAlias2 = "_order0";
        // AliasManger with default alias generetor
        list = query.find("user").fields(fields) //
            .join("user_info").on("user_id").fetch(joinFields) //
            .join("order").on("user1").fetch(join2Fields) //
            .list();
        assertFields(list, Arrays.stream(fields).map(f -> queryTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(joinFields).map(f -> joinTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(join2Fields).map(f -> joinTableAlias2 + "." + f).toArray(num -> new String[num]));

        list = query.find("user").fields("username", "password").field("age") //
            .join("user_info").on("user_id").fetch("id", "name").fetch("user_id") //
            .join("order").on("user1").fetch("no").fetch("app_id") //
            .list();
        assertFields(list, Arrays.stream(fields).map(f -> queryTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(joinFields).map(f -> joinTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(join2Fields).map(f -> joinTableAlias2 + "." + f).toArray(num -> new String[num]));

        String[] joinFields2 = Lang.array("id", "name", "userId");
        String[] join2Fields2 = Lang.array("no", "appId");
        list = query.find("user").fields(fields) //
            .join("user_info").on("user_id").fetch((repo, fieldBuilder) -> repo.fetch( //
                fieldBuilder.name("id"), //
                fieldBuilder.name("name"), //
                fieldBuilder.name("user_id").as("userId"))) //
            .join("order").on("user1").fetch((repo, fieldBuilder) -> repo.fetch( //
                fieldBuilder.name("no"), //
                fieldBuilder.name("app_id").as("appId"))) //
            .list();
        assertFields(list, Arrays.stream(fields).map(f -> queryTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(joinFields2).map(f -> joinTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(join2Fields2).map(f -> joinTableAlias2 + "." + f).toArray(num -> new String[num]));

        list = query.find("user").fields(fields) //
            .join("user_info").on("user_id").fetch((repo, fieldBuilder) -> repo.field( //
                fieldBuilder.name("id"), //
                fieldBuilder.name("name"), //
                fieldBuilder.name("user_id").as("userId"))) //
            .join("order").on("user1").fetch((repo, fieldBuilder) -> repo.field( //
                fieldBuilder.name("no"), //
                fieldBuilder.name("app_id").as("appId"))) //
            .list();
        assertFields(list, Arrays.stream(fields).map(f -> queryTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(joinFields2).map(f -> joinTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(join2Fields2).map(f -> joinTableAlias2 + "." + f).toArray(num -> new String[num]));

        list = query.find("user").fields(fields) //
            .join("user_info").on("user_id").fetch((repo, fieldBuilder) -> repo.fetch(fieldBuilder.name("id")) //
                .fetch(fieldBuilder.name("name")) //
                .fetch(fieldBuilder.name("user_id").as("userId")) //
            ) //
            .join("order").on("user1").fetch((repo, fieldBuilder) -> repo.fetch(fieldBuilder.name("no")) //
                .fetch(fieldBuilder.name("app_id").as("appId")) //
            ) //
            .list();
        assertFields(list, Arrays.stream(fields).map(f -> queryTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(joinFields2).map(f -> joinTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(join2Fields2).map(f -> joinTableAlias2 + "." + f).toArray(num -> new String[num]));

        list = query.find("user").fields(fields) //
            .join("user_info").on("user_id").fetch((repo, fieldBuilder) -> repo.field(fieldBuilder.name("id")) //
                .field(fieldBuilder.name("name")) //
                .field(fieldBuilder.name("user_id").as("userId")) //
            ) //
            .join("order").on("user1").fetch((repo, fieldBuilder) -> repo.field(fieldBuilder.name("no")) //
                .field(fieldBuilder.name("app_id").as("appId")) //
            ) //
            .list();
        assertFields(list, Arrays.stream(fields).map(f -> queryTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(joinFields2).map(f -> joinTableAlias + "." + f).toArray(num -> new String[num]),
            Arrays.stream(join2Fields2).map(f -> joinTableAlias2 + "." + f).toArray(num -> new String[num]));
    }

    @Test
    void joinCondition() {
        List<Map<String, Object>> list = query.find("user").fields("username", "password", "age") //
            .join("user_info").on("user_id") //
            .join("order").on("user1") //
            .where() //
            .eq2("name", "羽飞") //
            .and().eq3("no", "no:1") //
            .list();
        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age") //
            .join("user_info").on("user_id") //
            .join("order").on("user1") //
            .where() //
            .eq2(UserInfo::getName, "羽飞") //
            .and().eq3(Order::getNo, "no:1") //
            .list();
        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age") //
            .join("user_info").on("user_id") //
            .join("order").on("user1") //
            .where() //
            .eq((r1, r2, r3) -> r2.accept("name", "羽飞")) //
            .and().eq((r1, r2, r3) -> r3.accept("no", "no:1")) //
            .list();
        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age") //
            .join("user_info").on("user_id") //
            .join("order").on("user1") //
            .where() //
            .eq((r1, r2, r3) -> r2.field("name").value("羽飞")) //
            .and().eq((r1, r2, r3) -> r3.field("no").value("no:1")) //
            .list();
        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age")//
            .join("user_info").on("user_id") //
            .join("order").on("user1") //
            .where() //
            .field((f1, f2, f3) -> f1.field("username") //
                .eq("yufei") //
                .and() //
                .field("age") //
                .gt(18) //
            ) //
            .list();
        assertEquals(list.size(), 0);

        list = query.find("user").fields("username", "password", "age") //
            .join("user_info").on("user_id") //
            .join("order").on("user2") //
            .where().field((f1, f2, f3) -> f1.field("username") //
                .eq("featherfly") //
                .and() //
                .field("age") //
                .eq(5).and(f3.field("no").eq("no:2")) //
            ) //
            .list();
        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age") //
            .join("user_info").on("user_id") //
            .join("order").on("user1") //
            .where().field((f1, f2, f3) -> f1.field("username").eq("yufei").and().fieldAsNumber("age").gt(18)) //
            .list();
        assertEquals(list.size(), 0);

        list = query.find("user").fields("username", "password", "age") //
            .join("user_info").on("user_id") //
            .join("order").on("user2") //
            .where()
            .field((f1, f2, f3) -> f1.field("username").eq(username2).and().fieldAsNumber("age").eq(age2)
                .and(f3.field("no").eq("no:2"))) //
            .list();
        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age") //
            .join("user_info").on("user_id") //
            .join("order").on("user1") //
            .where() //
            .field(es -> es.get1(), "name").eq("羽飞") //
            .and().field(es -> es.get2(), "no").eq("no:1") //
            .list();
        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age") //
            .join("user_info").on("user_id") //
            .join("order").on("user2") //
            .where().field((f1, f2, f3) -> f1.field("username").eq(username2) //
                .and().fieldAsNumber("age").eq(age2) //
                .and(f2.field("name").eq(name2)) //
                .and(f3.field("no").eq("no:2")) //
            ) //
            .list();
        assertEquals(list.size(), 1);

    }

    @Test
    void joinCondition2() {
        List<Map<String, Object>> list = query.find("user").fields("username", "password", "age") //
            .join("user_info").on("user_id") //
            .join("order").on("user1") //
            .where((r1, r2, r3) -> r2.field("name").eq("羽飞").and(r3.field("no").eq("no:1")))//
            .list();
        assertEquals(list.size(), 1);

        //        list = query.find("user").fields("username", "password", "age") //
        //            .join("user_info").on("user_id") //
        //            .where((r1, r2) -> r2.field(UserInfo::getName).eq("羽飞")) // TODO 是否需要加入UserInfo::getName方法定义后续再考虑
        //            .list();
        //        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age") //
            .join("user_info").on("user_id") //
            .join("order").on("user1") //
            .where((r1, r2, r3) -> r1.field("username").eq("yufei") //
                .and().field("age").gt(18)) //
            .list();
        assertEquals(list.size(), 0);

        list = query.find("user").fields("username", "password", "age") //
            .join("user_info").on("user_id") //
            .join("order").on("user1") //
            .where((r1, r2, r3) -> r1.field("username").eq("yufei") //
                .and().fieldAsNumber("age").gt(18)) //
            .list();
        assertEquals(list.size(), 0);

        list = query.find("user").fields("username", "password", "age") //
            .join("user_info").on("user_id") //
            .join("order").on("user2") //
            .where((r1, r2, r3) -> r1.field("username").eq("featherfly") //
                .and().field("age").eq(5).and(r3.field("no").eq("no:2"))) //
            .list();
        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age") //
            .join("user_info").on("user_id") //
            .join("order").on("user2") //
            .where((r1, r2, r3) -> r1.field("username").eq("featherfly") //
                .and().fieldAsNumber("age").eq(5).and(r3.field("no").eq("no:2"))) //
            .list();
        assertEquals(list.size(), 1);

        list = query.find("user").fields("username", "password", "age") //
            .join("user_info").on("user_id") //
            .join("order").on("user2") //
            .where((r1, r2, r3) -> r1.field("username").eq(username2).and().fieldAsNumber("age").eq(age2) //
                .and(r2.field("name").eq(name2)) //
                .and(r3.field("no").eq("no:2")) //
            ) //
            .list();
        assertEquals(list.size(), 1);
    }

    @Test
    void joinCondition2_EqColumn() {
        List<Map<String, Object>> list = query.find("user").fields("username", "password", "age") //
            .join("user_info").on("user_id") //
            .join("order").on("user3") //
            .where((r1, r2, r3) -> r1.field("username").eq(r2.field("name"))) //
            .list();
        assertEquals(list.size(), 1);
    }

}
