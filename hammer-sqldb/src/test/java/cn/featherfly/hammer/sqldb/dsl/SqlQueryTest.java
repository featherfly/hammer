
package cn.featherfly.hammer.sqldb.dsl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cn.featherfly.common.db.Table;
import cn.featherfly.common.db.mapping.JdbcMappingException;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.repository.SimpleAliasRepository;
import cn.featherfly.common.repository.SimpleRepository;
import cn.featherfly.common.repository.builder.BuilderException;
import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic;
import cn.featherfly.hammer.expression.query.FetchField;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;

/**
 * SqlQueryTest.
 *
 * @author zhongj
 */
public class SqlQueryTest extends JdbcTestBase {

    SqlQuery query;

    List<Map<String, Object>> list = null;

    Map<String, Object> map = null;

    @BeforeClass
    public void beforeClass() {
        query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory, hammerConfig);
        System.err.println(this.getClass().getName() + " init with beforeClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    @Test
    void aggregateFunction() {
        Object result = null;

        //        List<Map<String, Object>> ages = query.find("user").field("age").list();
        List<Integer> ages = query.find("user").field("age").list();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        //        for (Map<String, Object> m : ages) {
        //        int i = (int) m.get("age");
        for (Integer age : ages) {
            sum += age;
            if (age > max) {
                max = age;
            }
            if (age < min) {
                min = age;
            }
        }
        int avg = sum / ages.size();

        result = query.find("user").min("age").intNumber();
        System.out.println("min = " + result);
        assertEquals(result, min);

        result = query.find("user").max("age").intNumber();
        System.out.println("max = " + result);
        assertEquals(result, max);

        result = query.find("user").avg("age").intNumber();
        System.out.println("avg = " + result);
        assertEquals(result, avg);

        result = query.find("user").sum("age").intNumber();
        System.out.println("sum = " + result);
        assertEquals(result, sum);

        result = query.find("user").count("age").intNumber();
        System.out.println("count = " + result);
        assertEquals(result, ages.size());
    }

    @Test
    void listMappingClass() {
        Consumer<List<User>> assertUser = (list) -> {
            for (User user : list) {
                assertNotNull(user.getUsername());
                assertNull(user.getPwd());
                assertNotNull(user.getAge());
            }
        };

        List<User> list = null;
        list = query.find("user").list(User.class);
        assertUser.accept(list);

        list = query.find("user").fields("username", "password", "age").list(User.class);
        assertUser.accept(list);

        String username = "yufei";
        String password = "123456";
        int min = 18;
        int max = 60;
        Consumer<List<User>> assertUser2 = (l) -> {
            for (User user : l) {
                assertNotNull(user.getUsername());
                assertNull(user.getPwd());
                assertNotNull(user.getAge());

                assertTrue(18 < user.getAge() && user.getAge() < max);
            }
        };

        list = query.find("user").fields("username", "password", "age")//
            .where() //
            .eq("username", username)//
            .and()//
            .eq("password", password)//
            .and().group()//
            .gt("age", min).and().lt("age", max) //
            .list(User.class);
        assertUser2.accept(list);

        list = query.find("user").fields("username", "password", "age")//
            .where()//
            .eq("username", username)//
            .and() //
            .eq("password", password)//
            .and().group(g -> g.gt("age", min).and().lt("age", max)) //
            .list(User.class);
        assertUser2.accept(list);

        list = query.find("user").fields("username", "password", "age")//
            .where()//
            .eq("username", username) //
            .and() //
            .eq("password", password) //
            .and((Function<RepositoryQueryConditionsGroup,
                RepositoryQueryConditionsGroupLogic>) g -> g.gt("age", min).and().lt("age", max)) //
            .list(User.class);
        assertUser2.accept(list);

        // ----------------------------------------------------------------------------------------------------------------

        list = query.find(new SimpleRepository("user")) //
            .where()//
            .eq("username", username)//
            .and() //
            .eq("password", password) //
            .and().group() //
            .gt("age", min).and().lt("age", max) //
            .list(User.class);
        assertUser2.accept(list);

        list = query.find(new SimpleAliasRepository("user", "u")) //
            .where()//
            .eq("username", username)//
            .and() //
            .eq("password", password) //
            .and().group() //
            .gt("age", min).and().lt("age", max) //
            .list(User.class);
        assertUser2.accept(list);

        Repository repository = new SimpleAliasRepository("user", "u");
        list = query.find(repository) //
            .where()//
            .eq("username", username)//
            .and() //
            .eq("password", password) //
            .and().group() //
            .gt("age", min).and().lt("age", max) //
            .list(User.class);
        assertUser2.accept(list);
    }

    @Test
    void value() {
        final int a = 55;
        int age = query.find("user").field("age").where().eq("id", 7).value();
        assertEquals(age, a);

        age = query.find("user").field("age").where().eq("id", 7).single();
        assertEquals(age, a);

        age = query.find("user").field("age").where().eq("id", 7).unique();
        assertEquals(age, a);
    }

    @Test
    void valueList() {
        int min = 5;
        int max = 20;
        List<Integer> ages = query.find("user").field("age").where().gt("age", min).and().lt("age", max).list();
        for (int age : ages) {
            assertTrue(min < age && age < max);
        }

        ages = query.find("user").field("age").where().ge("age", min).and().le("age", max).list();
        for (int age : ages) {
            assertTrue(min <= age && age <= max);
        }
    }

    BiConsumer<List<Map<String, Object>>, String> compareAge = (list, name) -> {
        int min = Integer.MIN_VALUE;
        for (Map<String, Object> map : list) {
            Integer a = (Integer) map.get(name);
            //            System.err.println(min + "    " + a);
            assertTrue(min <= a);
            min = a;
        }
    };

    @Test
    void fetchField() {
        list = query.find("user") //
            .fields("username", "password", "age") //
            .sort().asc("age") //
            .list();
        compareAge.accept(list, "age");

        list = query.find("user") //
            .fields("username", "password", "AGE") //
            .sort().asc("AGE") //
            .list();
        compareAge.accept(list, "AGE");

        list = query.find("user").fields("username", "password").field("AGE", "age").sort().asc("age").list();
        compareAge.accept(list, "age");
    }

    @Test
    void fetchFieldWithLambda() {
        list = query.find("user") //
            .field((Consumer<FetchField>) f -> f.name("username")) //
            .field((Consumer<FetchField>) f -> f.name("password")) //
            .field((Consumer<FetchField>) f -> f.name("age"))
            //
            .sort().asc("age") //
            .list();
        compareAge.accept(list, "age");

        list = query.find("user") //
            .field((q, f) -> q.field( //
                f.name("username"), //
                f.name("password"), //
                f.name("age"))) //
            .sort().asc("age") //
            .list();
        compareAge.accept(list, "age");

        list = query.find("user") //
            .field((q, f) -> q.field(f.name("username")) //
                .field(f.name("password")) //
                .field(f.name("age"))) //
            .sort().asc("age") //
            .list();
        compareAge.accept(list, "age");

        // ----------------------------------------------------------------------------------------------------------------

        list = query.find("user") //
            .fields("username", "password", "AGE") //
            .sort().asc("AGE") //
            .list();
        compareAge.accept(list, "AGE");

        list = query.find("user") //
            .field((q, f) -> q.field( //
                f.name("username"), //
                f.name("password"), //
                f.name("AGE"))) //
            .sort().asc("AGE") //
            .list();
        compareAge.accept(list, "AGE");

        list = query.find("user") //
            .field((q, f) -> q.field(f.name("username")) //
                .field(f.name("password")) //
                .field(f.name("AGE"))) //
            .sort().asc("AGE") //
            .list();
        compareAge.accept(list, "AGE");

        // ----------------------------------------------------------------------------------------------------------------

        list = query.find("user").fields("username", "password").field("AGE", "age").sort().asc("age").list();
        compareAge.accept(list, "age");

        list = query.find("user") //
            .field((q, f) -> q.field( //
                f.name("username"), //
                f.name("password"), //
                f.name("AGE").alias("age"))) //
            .sort().asc("age") //
            .list();
        compareAge.accept(list, "age");

        list = query.find("user") //
            .field((q, f) -> q.field(f.name("username")) //
                .field(f.name("password")) //
                .field(f.name("AGE").alias("age"))) //
            .sort().asc("age") //
            .list();
        compareAge.accept(list, "age");
    }

    @Test
    void conditionField() {
        List<Map<String, Object>> list = null;
        Map<String, Object> map = null;
        String username = "yufei";

        list = query.find("user").fields("username", "password", "age") //
            .where() //
            .field("username").eq(username) //
            .list();
        assertEquals(list.size(), 1);
        map = query.find("user").fields("username", "password", "age") //
            .where() //
            .field("username").eq(username) //
            .single();
        assertEquals(map.get("username"), username);

        list = query.find("user").fields("username", "password", "age") //
            .where() //
            .fieldAsString("username").eq("yufei") //
            .list();
        assertEquals(list.size(), 1);
        map = query.find("user").fields("username", "password", "age") //
            .where() //
            .fieldAsString("username").eq(username) //
            .single();
        assertEquals(map.get("username"), username);
    }

    @Test
    void conditionNull() {
        List<Map<String, Object>> list = query.find("user").where().eq("a", (Serializable) null).and()
            .eq("b", (Serializable) null).and().sw("username", "yufei").and().eq("d", (Serializable) null).list();
        for (Map<String, Object> map : list) {
            String username = (String) map.get("username");
            System.err.println(username);
            assertTrue(Strings.startsWith(username, "yufei"));
        }
    }

    @Test
    void conditionIn() {
        int[] ids = new int[] { 1, 2 };
        list = query.find("user") //
            .where() //
            .in("id", ids) //
            .list();
        assertEquals(list.size(), ids.length);
        list = query.find("user") //
            .where() //
            .field("id").in(ids) //
            .list();
        assertEquals(list.size(), ids.length);

        long total = query.find("user").count();
        list = query.find("user") //
            .where() //
            .in("id", (Serializable) null) //
            .list();
        assertEquals(list.size(), total);
        list = query.find("user") //
            .where() //
            .field("id").in((Serializable) null) //
            .list();
        assertEquals(list.size(), total);

        long c1 = query.find("user") //
            .where() //
            .in("id", (Integer) null, IgnoreStrategy.NONE)// 不忽略空值
            .count();
        c1 = query.find("user") //
            .where() //
            .field("id").in(null, IgnoreStrategy.NONE)// 不忽略空值
            .count();
        assertEquals(c1, 0);
    }

    @Test
    void conditionEq() {
        int id = 1;
        int userId = query.find("user").field("id") //
            .where() //
            .eq("id", id) //
            .intValue();
        assertEquals(userId, id);
        userId = query.find("user").field("id") //
            .where() //
            .field("id").eq(id) //
            .intValue();
        assertEquals(userId, id);

        long total = query.find("user").count();
        long c1 = query.find("user") //
            .where() //
            .eq("id", (Serializable) null) //
            .count();
        c1 = query.find("user") //
            .where() //
            .field("id").eq((Serializable) null) //
            .count();
        assertEquals(c1, total);

        long c2 = query.find("user") //
            .where() //
            .eq("id", null, IgnoreStrategy.NONE) // 不忽略空值
            .count();
        assertEquals(c2, 0);
        c2 = query.find("user") //
            .where() //
            .field("id").eq(null, IgnoreStrategy.NONE) // 不忽略空值
            .count();
        assertEquals(c2, 0);
        c2 = query.find("user") //
            .where() //
            .eq("id", null, v -> false) // 不忽略空值
            .count();
        assertEquals(c2, 0);
        c2 = query.find("user") //
            .where() //
            .field("id").eq(null, v -> false) // 不忽略空值
            .count();
        assertEquals(c2, 0);
    }

    @Test
    void conditionEqColumn() {
        int id = 1;
        //        r.eq("create_user", r.field("user1")
        int userId = query.find("order").field("id") //
            .where(r -> //
            r.field("create_user") //
                .eq(r.field("user1"))) // FIXME 此方式会触发内存溢出，应该是无限递归了
            .intValue();

        Integer userId2 = query.find("order").field("id") //
            .where(r -> r.field("create_user").eq(r.field("user1"))) //
            .value();

        assertTrue(userId == id);
        assertTrue(userId2 == id);
    }

    @Test
    void conditionNe() {
        int id = 1;
        List<Integer> userIds = query.find("user").field("id") //
            .where() //
            .ne("id", id) //
            .list(Integer.class);
        for (Integer userId : userIds) {
            assertNotEquals(userId, id);
        }

        long c1 = query.find("user") //
            .where() //
            .ne("id", null) //
            .count();
        long total = query.find("user").count();
        assertEquals(c1, total);

        long c2 = query.find("user") //
            .where() //
            .ne("id", null, IgnoreStrategy.NONE) // 不忽略空值
            .count();
        assertEquals(c2, 0);
        c2 = query.find("user") //
            .where() //
            .ne("id", null, v -> false) // 不忽略空值
            .count();
        assertEquals(c2, 0);
    }

    @Test
    void conditionSw() {
        String sw = "yufei";
        List<String> usernames = query.find("user").field("username") //
            .where() //
            .sw("username", sw) //
            .list(String.class);
        for (String username : usernames) {
            assertTrue(Strings.startsWith(username, sw));
        }

        long c = query.find("user")//
            .where() //
            .sw("username", "zzzzzzzz") //
            .count();
        assertEquals(c, 0);

        long c1 = query.find("user") //
            .where() //
            .sw("username", null) //
            .count();
        long total = query.find("user").count();
        assertEquals(c1, total);

        long c2 = query.find("user") //
            .where() //
            .sw("username", null, IgnoreStrategy.NONE) // 不忽略空值
            .count();
        assertEquals(c2, 0);

        c2 = query.find("user") //
            .where() //
            .sw("username", null, v -> false) // 不忽略空值
            .count();
        assertEquals(c2, 0);
    }

    @Test
    void conditionEw() {
        String ew = "55";
        List<String> usernames = query.find("user").field("username") //
            .where() //
            .ew("username", ew) //
            .list(String.class);
        for (String username : usernames) {
            assertTrue(Strings.endWith(username, ew));
        }

        long c = query.find("user")//
            .where() //
            .ew("username", "zzzzzzzz") //
            .count();
        assertEquals(c, 0);

        long c1 = query.find("user") //
            .where() //
            .ew("username", null) //
            .count();
        long total = query.find("user").count();
        assertEquals(c1, total);

        long c2 = query.find("user") //
            .where() //
            .ew("username", null, IgnoreStrategy.NONE) // 不忽略空值
            .count();
        assertEquals(c2, 0);

        c2 = query.find("user") //
            .where() //
            .ew("username", null, v -> false) // 不忽略空值
            .count();
        assertEquals(c2, 0);
    }

    @Test
    void conditionCo() {
        String co = "uf";
        List<String> usernames = query.find("user").field("username") //
            .where() //
            .co("username", co) //
            .list(String.class);
        for (String username : usernames) {
            assertTrue(Strings.contains(username, co));
        }

        long c = query.find("user")//
            .where() //
            .co("username", "zzzzzzzz") //
            .count();
        assertEquals(c, 0);

        long c1 = query.find("user") //
            .where() //
            .co("username", null) //
            .count();
        long total = query.find("user").count();
        assertEquals(c1, total);

        long c2 = query.find("user") //
            .where() //
            .co("username", null, IgnoreStrategy.NONE) // 不忽略空值
            .count();
        assertEquals(c2, 0);

        c2 = query.find("user") //
            .where() //
            .co("username", null, v -> false) // 不忽略空值
            .count();
        assertEquals(c2, 0);
    }

    @Test
    void conditionLk() {
        String yufei = "yufei";
        String un = query.find("user").field("username") //
            .where() //
            .lk("username", yufei) //
            .string();
        assertEquals(un, yufei);

        String sw = "yufei";
        List<String> usernames = query.find("user").field("username") //
            .where() //
            .sw("username", sw + "%") //
            .list(String.class);
        for (String username : usernames) {
            assertTrue(Strings.startsWith(username, sw));
        }

        String ew = "55";
        usernames = query.find("user").field("username") //
            .where() //
            .ew("username", "%" + ew) //
            .list(String.class);
        for (String username : usernames) {
            assertTrue(Strings.endWith(username, ew));
        }

        String co = "uf";
        usernames = query.find("user").field("username") //
            .where() //
            .co("username", "%" + co + "%") //
            .list(String.class);
        for (String username : usernames) {
            assertTrue(Strings.contains(username, co));
        }

        long c = query.find("user")//
            .where() //
            .lk("username", "zzzzzzzz") //
            .count();
        assertEquals(c, 0);

        long c1 = query.find("user") //
            .where() //
            .lk("username", null) //
            .count();
        long total = query.find("user").count();
        assertEquals(c1, total);

        long c2 = query.find("user") //
            .where() //
            .lk("username", null, IgnoreStrategy.NONE) // 不忽略空值
            .count();
        assertEquals(c2, 0);

        c2 = query.find("user") //
            .where() //
            .lk("username", null, v -> false) // 不忽略空值
            .count();
        assertEquals(c2, 0);
    }

    @Test
    void conditionGt() {
        int ageValue = 40;
        List<Integer> ages = query.find("user").field("age") //
            .where() //
            .gt("age", ageValue) //
            .list(Integer.class);
        for (Integer age : ages) {
            assertTrue(age > ageValue);
        }

        long c = query.find("user")//
            .where() //
            .gt("age", Integer.MAX_VALUE) //
            .count();
        assertEquals(c, 0);

        long c1 = query.find("user") //
            .where() //
            .gt("age", (Integer) null) //
            .count();
        long total = query.find("user").count();
        assertEquals(c1, total);

        long c2 = query.find("user") //
            .where() //
            .gt("age", (Integer) null, v -> false) // 不忽略空值
            .count();
        assertEquals(c2, 0);

        c2 = query.find("user") //
            .where() //
            .gt("age", (Integer) null, IgnoreStrategy.NONE) // 不忽略空值
            .count();
        assertEquals(c2, 0);

        c2 = query.find("user") //
            .where() //
            .gt("age", (Date) null, IgnoreStrategy.NONE) // 不忽略空值
            .count();
        assertEquals(c2, 0);
    }

    @Test
    void conditionGe() {
        int ageValue = 40;
        List<Integer> ages = query.find("user").field("age") //
            .where() //
            .ge("age", ageValue) //
            .list(Integer.class);
        for (Integer age : ages) {
            assertTrue(age >= ageValue);
        }

        long c = query.find("user")//
            .where() //
            .ge("age", Integer.MAX_VALUE) //
            .count();
        assertEquals(c, 0);

        long c1 = query.find("user") //
            .where() //
            .ge("age", (Integer) null) //
            .count();
        long total = query.find("user").count();
        assertEquals(c1, total);

        long c2 = query.find("user") //
            .where() //
            .ge("age", (Integer) null, v -> false) // 不忽略空值
            .count();
        assertEquals(c2, 0);

        c2 = query.find("user") //
            .where() //
            .ge("age", (Integer) null, IgnoreStrategy.NONE) // 不忽略空值
            .count();
        assertEquals(c2, 0);

        c2 = query.find("user") //
            .where() //
            .ge("age", (Date) null, IgnoreStrategy.NONE) // 不忽略空值
            .count();
        assertEquals(c2, 0);
    }

    @Test
    void conditionLt() {
        int ageValue = 40;
        List<Integer> ages = query.find("user").field("age") //
            .where() //
            .lt("age", ageValue) //
            .list(Integer.class);
        for (Integer age : ages) {
            assertTrue(age < ageValue);
        }

        long c = query.find("user")//
            .where() //
            .lt("age", 0) //
            .count();
        assertEquals(c, 0);

        long c1 = query.find("user") //
            .where() //
            .lt("age", (Integer) null) //
            .count();
        long total = query.find("user").count();
        assertEquals(c1, total);

        long c2 = query.find("user") //
            .where() //
            .lt("age", (Integer) null, v -> false) // 不忽略空值
            .count();
        assertEquals(c2, 0);

        c2 = query.find("user") //
            .where() //
            .lt("age", (Integer) null, IgnoreStrategy.NONE) // 不忽略空值
            .count();
        assertEquals(c2, 0);

        c2 = query.find("user") //
            .where() //
            .lt("age", (Date) null, IgnoreStrategy.NONE) // 不忽略空值
            .count();
        assertEquals(c2, 0);
    }

    @Test
    void conditionLe() {
        int ageValue = 40;
        List<Integer> ages = query.find("user").field("age") //
            .where() //
            .le("age", ageValue) //
            .list(Integer.class);
        for (Integer age : ages) {
            assertTrue(age <= ageValue);
        }

        long c = query.find("user")//
            .where() //
            .le("age", 0) //
            .count();
        assertEquals(c, 0);

        long c1 = query.find("user") //
            .where() //
            .le("age", (Integer) null) //
            .count();
        long total = query.find("user").count();
        assertEquals(c1, total);

        long c2 = query.find("user") //
            .where() //
            .le("age", (Integer) null, v -> false) // 不忽略空值
            .count();
        assertEquals(c2, 0);

        c2 = query.find("user") //
            .where() //
            .le("age", (Integer) null, IgnoreStrategy.NONE) // 不忽略空值
            .count();
        assertEquals(c2, 0);

        c2 = query.find("user") //
            .where() //
            .le("age", (Date) null, IgnoreStrategy.NONE) // 不忽略空值
            .count();
        assertEquals(c2, 0);
    }

    @Test
    void conditionExpr() {
        Integer id = 1;
        Map<String, Object> user = query.find("user").where().eq(User::getId, id).single();
        assertEquals(user.get("id"), id);

        user = query.find("user").where().eq(User::getId, id).and()
            .expression("{0}.age - :age >= 0", new ChainMapImpl<String, Object>().putChain("age", 100)).single();
        assertNull(user);

        user = query.find("user").where().eq(User::getId, id).and().expression("{0}.age - ? >= 0", 100).single();
        assertNull(user);

        user = query.find("user").where().eq(User::getId, id).and().expression("{0}.username = password").single();
        assertNull(user);

        user = query.find("user").where().eq(User::getId, id).and()
            .expr("{as0}.age - :age >= 0", new ChainMapImpl<String, Object>().putChain("age", 100)).single();
        assertNull(user);

        user = query.find("user").where().eq(User::getId, id).and().expr("{as0}.age - ? >= 0", 100).single();
        assertNull(user);

        user = query.find("user").where().eq(User::getId, id).and().expr("{as0}.username = password").single();
        assertNull(user);
    }

    @Test
    void conditionExpr2() {
        Consumer<List<Integer>> assertAge = (ages) -> ages.forEach((age) -> assertEquals(age, 5));

        Integer id = 1;
        Map<String, Object> user = query.find("user").where().eq(User::getId, id).single();
        assertEquals(user.get("id"), id);

        // add
        assertAge.accept(query.find("user").fetch("age").where() //
            .expression("{0}.age + :add = :age",
                new ChainMapImpl<String, Object>().putChain("add", 5).putChain("age", 10))//
            .list());

        // subtract
        assertAge.accept(query.find("user").fetch("age").where() //
            .expression("{0}.age - :subtract = :age",
                new ChainMapImpl<String, Object>().putChain("subtract", 5).putChain("age", 0))//
            .list());

        // multiply
        assertAge.accept(query.find("user").fetch("age").where() //
            .expression("{0}.age * :multiply = :age",
                new ChainMapImpl<String, Object>().putChain("multiply", 5).putChain("age", 25))//
            .list());

        // multiply
        assertAge.accept(query.find("user").fetch("age").where() //
            .expression("{0}.age / :divide = :age",
                new ChainMapImpl<String, Object>().putChain("divide", 5).putChain("age", 1))//
            .list());

        // ----------------------------------------------------------------------------------------------------------------

        // add
        assertAge.accept(query.find(User.class).fetch(User::getAge).where() //
            .expression("{0}.age + :add = :age",
                new ChainMapImpl<String, Object>().putChain("add", 5).putChain("age", 10))//
            .valueList());

        // subtract
        assertAge.accept(query.find(User.class).fetch(User::getAge).where() //
            .expression("{0}.age - :subtract = :age",
                new ChainMapImpl<String, Object>().putChain("subtract", 5).putChain("age", 0))//
            .valueList());

        // multiply
        assertAge.accept(query.find(User.class).fetch(User::getAge).where() //
            .expression("{0}.age * :multiply = :age",
                new ChainMapImpl<String, Object>().putChain("multiply", 5).putChain("age", 25))//
            .valueList());

        // multiply
        assertAge.accept(query.find(User.class).fetch(User::getAge).where() //
            .expression("{0}.age / :divide = :age",
                new ChainMapImpl<String, Object>().putChain("divide", 5).putChain("age", 1))//
            .valueList());
    }

    @Test
    void conditionOperationArithmetic() {
        Consumer<List<Integer>> assertAge = (ages) -> ages.forEach((age) -> assertEquals(age, 5));

        // add
        assertAge.accept(query.find("user").fetch("age").where().fieldAsNumber("age").add(5).eq(10).list());

        // subtract
        assertAge.accept(query.find("user").fetch("age").where().fieldAsNumber("age").subtract(5).eq(0).list());

        // multiply
        assertAge.accept(query.find("user").fetch("age").where().fieldAsNumber("age").multiply(5).eq(25).list());

        // divide
        assertAge.accept(query.find("user").fetch("age").where().fieldAsNumber("age").divide(5).eq(1).list());

        // add
        assertAge.accept(
            query.find(User.class).fetch(User::getAge).where().property(User::getAge).add(5).eq(10).valueList());

        // subtract
        assertAge.accept(
            query.find(User.class).fetch(User::getAge).where().property(User::getAge).subtract(5).eq(0).valueList());

        // multiply
        assertAge.accept(
            query.find(User.class).fetch(User::getAge).where().property(User::getAge).multiply(5).eq(25).valueList());

        // divide
        assertAge.accept(
            query.find(User.class).fetch(User::getAge).where().property(User::getAge).divide(5).eq(1).valueList());
    }

    @Test(expectedExceptions = BuilderException.class)
    void conditionException() {
        RepositoryQueryConditionsGroup condition = query.find(new SimpleAliasRepository("user", "u")).where();
        condition.eq("id", 1);
        condition.eq("id", 2).list();
    }

    @Test(expectedExceptions = BuilderException.class)
    void conditionException2() {
        RepositoryQueryConditionsGroup condition = query.find(new SimpleAliasRepository("user", "u")).where();
        RepositoryQueryConditionsGroupLogic logic = condition.eq("id", 1);
        logic.and();
        logic.list();
    }

    @Test
    void count() {
        Long number = query.find("user").count();
        System.out.println("count:" + number);
        assertTrue(number > 0);
    }

    @Test
    void count2() {
        long number = query.find("user").field("id") //
            .count();
        System.out.println("count:" + number);
        assertTrue(number > 0);
    }

    @Test
    void avg() {
        Integer number = query.find("user").avg("age").intNumber();
        System.out.println("avg:" + number);
        assertTrue(number > 0);

        //        query.find("user").intNumber(); 没有使用property或各种统计方法，则无法调用返回单个参数的方法
        //        query.find("user").where().eq("id", "id").intNumber(); 这里没有实现上面的逻辑

        number = query.find("user").avg("age").where().eq("age", 5).intNumber();
        assertTrue(number == 5);

    }

    @Test
    void sum() {
        Long count = query.find("user").where().eq("age", 5) //
            .count();

        Integer number = query.find("user").sum("age").where().eq("age", 5).intNumber();
        System.out.println("sum:" + number);
        assertTrue(number > 0);
        assertTrue(number == count * 5);

    }

    @Test
    void min() {
        Integer min = query.find("user").min("age").intNumber();
        System.out.println("min:" + min);
        assertTrue(min == 5);

        min = query.find("user").min("age").where().ge("age", 10).intNumber();
        System.out.println("min:" + min);
        assertTrue(min == 10);
    }

    @Test
    void max() {
        Integer max = query.find("user").max("age").intNumber();
        System.out.println("max:" + max);
        assertTrue(max == 55);

        max = query.find("user").max("age").where().le("age", 10).intNumber();
        System.out.println("max:" + max);
        assertTrue(max == 10);
    }

    @Test
    void limit() {

        int pageSize = 3;
        Integer total = 10;
        List<Role> roleList = query.find(new SimpleRepository("role")).where().le("id", total).limit(2, pageSize)
            .list(Role.class);
        assertEquals(roleList.size(), pageSize);

        List<Map<String, Object>> roleList2 = query.find(new SimpleRepository("role")).where().le("id", total)
            .limit(2, pageSize).list();
        assertEquals(roleList2.size(), pageSize);

        List<Integer> roleList3 = query.find(new SimpleRepository("role")).where().le("id", total).limit(2, pageSize)
            .list((res, rowNum) -> res.getInt("id"));
        assertEquals(roleList3.size(), pageSize);

        PaginationResults<Role> rolePage = query.find(new SimpleRepository("role")).where().le("id", total)
            .limit(2, pageSize).pagination(Role.class);
        assertEquals(rolePage.getTotal(), total);
        assertEquals(rolePage.getPageResults().size(), pageSize);

        PaginationResults<Map<String, Object>> rolePage2 = query.find(new SimpleRepository("role")).where()
            .le("id", total).limit(2, pageSize).pagination();
        assertEquals(rolePage2.getTotal(), total);
        assertEquals(rolePage2.getPageResults().size(), pageSize);

        PaginationResults<Integer> rolePage3 = query.find(new SimpleRepository("role")).where().le("id", total)
            .limit(2, pageSize).pagination((res, rowNum) -> res.getInt("id"));
        assertEquals(rolePage3.getTotal(), total);
        assertEquals(rolePage3.getPageResults().size(), pageSize);
    }

    @Test
    void join() {
        final String table = "user";
        final Table tm = metadata.getTable(table);

        map = query.find(table)//
            .limit(1) //
            .single();
        tm.getColumns().forEach(c -> {
            assertNotNull(map.get(c.getName()));
        });

        map = query.find(table)//
            .join("user_info").on("user_id") //
            .limit(1).single();
        tm.getColumns().forEach(c -> {
            assertNotNull(map.get(c.getName()));
        });
    }

    @Test
    void join1() {
        // query.find("user") 返回 SqlQueryEntity
        // query.find("user").property("username") 返回 QueryEntityProperties，应该返回SqlQueryEntity
        query.find("user").fields("username", "password", "age") //
            .join("user_info") //
            .on("user_id") //
            .list();

        query.find("user").fields("username", "password", "age").join("user_info").on("user_id").join("user_info")
            .on("user_id").list();

        // ENHANCE 后续加入省略on方法的形式，通过database metadata 自动获取join的table的id
        //  query.find("user").property("username", "password", "age").join("user_info").list();

        query.find("user").fields("username", "password", "age").join("user_info").on("user_id").fetch("name").list();

        query.find("user").fields("username", "password", "age").join("user_info").on("user_id").fetch().list();

        query.find("user").fields("username", "password", "age").join("user_info").on("user_id").fetch("name").list();

        //        query.find("user").fields("username", "password", "age").join("user_info").on("user_id").fetch("name").fetch()
        //                .list();

        //        query.find("user").fields("username", "password", "age").join("user_info").on("user_id").fetch("name")
        //        .fetch("descp").list();
        query.find("user").fields("username", "password", "age").join("user_info").on("user_id").fetch("name", "descp")
            .list();

        //        query.find("user").fields("username", "password", "age").join("user_role").on("user_id").join("role")
        //                .on("id", "user_role", "role_id").fetch().list();

        query.find("user").fields("username", "password", "age") //
            .join("user_role").on("user_id") //
            .join("role").on((r1, r2, j) -> j.field("id").eq(r2.field("role_id"))).fetch() //
            .list();

        query.find("user").fields("username", "password", "age") //
            .join("user_role").on((r1, j) -> j.field("user_id").eq(r1.field("id"))) //
            .join("role").on((r1, r2, j) -> j.field("id").eq(r2.field("role_id"))).fetch() //
            .list();

        query.find("user").fields("username", "password", "age").join("user_info").on("user_id").list();

        query.find("user").fields("username", "password", "age").join("user_info").on("user_id").fetch().list();

        query.find("tree").join("tree").on("parent_id").list();

        query.find("tree").join("tree").on("parent_id").join("tree").on("parent_id").list();

        query.find("user_info").join("user").on("id", "user_id").fetch((r, f) -> f.name("password").as("pwd")).list();
        query.find("user_info").join("user").on("id", "user_id").fetchAlias("password", "pwd").list();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    void repositoryNull() {
        query.find((Repository) null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    void repositoryNull2() {
        query.find((AliasRepository) null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    void repositoryNull3() {
        query.find((Table) null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    void repositoryNull4() {
        query.find((String) null);
    }

    @Test(expectedExceptions = SqldbHammerException.class)
    void classMappingFactorNull() {
        SqlQuery query = new SqlQuery(jdbc, metadata, sqlPageFactory, hammerConfig);
        query.find(User.class);
    }

    @Test(expectedExceptions = JdbcMappingException.class)
    void notEntityType() {
        query.find(String.class);
    }
}
