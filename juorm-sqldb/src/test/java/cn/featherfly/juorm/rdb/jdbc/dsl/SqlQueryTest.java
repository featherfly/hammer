
package cn.featherfly.juorm.rdb.jdbc.dsl;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import cn.featherfly.juorm.expression.SimpleRepository;
import cn.featherfly.juorm.rdb.jdbc.JdbcTestBase;
import cn.featherfly.juorm.rdb.jdbc.dsl.query.SqlQuery;
import cn.featherfly.juorm.rdb.jdbc.vo.User;
import cn.featherfly.juorm.rdb.jdbc.vo.UserInfo;

/**
 * <p>
 * SqlQueryTest
 * </p>
 *
 * @author zhongj
 */
public class SqlQueryTest extends JdbcTestBase {

    @Test
    void test1() {
        SqlQuery query = new SqlQuery(jdbc);
        query.find("user").list(User.class);
        query.find("user").property("username", "password", "age").list(User.class);
        query.find("user").property("username", "password", "age").where().eq("username", "yufei").and()
                .eq("password", "123456").and().group().gt("age", 18).and().lt("age", 60).list(User.class);
    }

    @Test
    void test2() {
        SqlQuery query = new SqlQuery(jdbc);
        query.find("user").property("username", "password", "age").where().eq("username", "yufei").and()
                .eq("password", "123456").and().group().gt("age", 18).and().lt("age", 60).list(User.class);
    }

    @Test
    void test3() {
        SqlQuery query = new SqlQuery(jdbc);
        query.find(new SimpleRepository("user", "u")).where().eq("username", "yufei").and().eq("password", "123456")
                .and().group().gt("age", 18).and().lt("age", 60).list(User.class);
    }

    @Test
    void test4() {
        SqlQuery query = new SqlQuery(jdbc);
        query.find(new SimpleRepository("user", "u")).property("username", "password", "age").where()
                .eq("username", "yufei").and().eq("password", "123456").and().group().gt("age", 18).and().lt("age", 60)
                .list(User.class);
    }

    @Test
    void testMapping() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory);
        query.find(User.class).property("username", "pwd", "age").where().eq("username", "yufei").and()
                .eq("pwd", "123456").and().group().gt("age", 18).and().lt("age", 60).list(User.class);
    }

    @Test
    void testNestedMapping() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory);
        Integer userId = 1;
        UserInfo userInfo = query.find(UserInfo.class).where().eq("user.id", userId).single(UserInfo.class);
        assertEquals(userInfo.getUser().getId(), userId);
        System.out.println(userInfo);

        String province = "四川";
        userInfo = query.find(UserInfo.class).where().eq("division.province", province).single(UserInfo.class);
        assertEquals(userInfo.getDivision().getProvince(), province);
        System.out.println(userInfo);
    }
}
