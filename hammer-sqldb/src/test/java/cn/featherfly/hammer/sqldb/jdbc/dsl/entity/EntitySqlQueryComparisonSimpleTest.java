
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Tree;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;

/**
 * sql query type test.
 *
 * @author zhongj
 */
public class EntitySqlQueryComparisonSimpleTest extends JdbcTestBase {

    SqlQuery query;

    UserInfo userInfo = null;
    User user = null;
    Integer uid = 1;
    List<Tree> trees = new ArrayList<>();

    String username = "yufei";

    String startWith = "yu";

    String contains = "ufe";

    String endWith = "fei";

    int min = 10;
    int max = 20;

    @BeforeTest
    void setupTest() {
        query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory, hammerConfig.getDslConfig().getQueryConfig());
    }

    @BeforeMethod
    void setupMethod() {
        userInfo = null;
        user = null;
        uid = 1;
        trees = new ArrayList<>();
    }

    @Test
    void ba() {
        List<User> users = query.find(User.class).where().ba(User::getAge, min, max).list();
        for (User user : users) {
            //            System.out.println(user.getAge());
            assertTrue(min <= user.getAge() && user.getAge() <= max);
        }
    }

    @Test
    void nba() {
        List<User> users = query.find(User.class).where().nba(User::getAge, min, max).list();
        for (User user : users) {
            //            System.out.println(user.getAge());
            assertTrue(user.getAge() < min || max < user.getAge());
        }
    }

    @Test
    void sw() {
        List<User> users = query.find(User.class).where().sw(User::getUsername, startWith).list();
        for (User user : users) {
            //            System.out.println(user.getUsername());
            assertTrue(user.getUsername().startsWith(startWith));
        }
    }

    @Test
    void nsw() {
        List<User> users = query.find(User.class).where().nsw(User::getUsername, startWith).list();
        for (User user : users) {
            //            System.out.println(user.getUsername());
            assertFalse(user.getUsername().startsWith(startWith));
        }
    }

    @Test
    void ew() {
        List<User> users = query.find(User.class).where().ew(User::getUsername, endWith).list();
        for (User user : users) {
            //            System.out.println(user.getUsername());
            assertTrue(user.getUsername().endsWith(endWith));
        }
    }

    @Test
    void newv() {
        List<User> users = query.find(User.class).where().newv(User::getUsername, endWith).list();
        for (User user : users) {
            //            System.out.println(user.getUsername());
            assertFalse(user.getUsername().endsWith(endWith));
        }
    }

    @Test
    void co() {
        List<User> users = query.find(User.class).where().co(User::getUsername, contains).list();
        for (User user : users) {
            //            System.out.println(user.getUsername());
            assertTrue(user.getUsername().contains(contains));
        }
    }

    @Test
    void nco() {
        List<User> users = query.find(User.class).where().nco(User::getUsername, contains).list();
        for (User user : users) {
            //            System.out.println(user.getUsername());
            assertFalse(user.getUsername().contains(contains));
        }
    }

    @Test
    void eq() {
        List<User> users = query.find(User.class).where().eq(User::getUsername, username).list();
        for (User user : users) {
            assertTrue(user.getUsername().equals(username));
        }
    }

    @Test
    void ne() {
        List<User> users = query.find(User.class).where().ne(User::getUsername, username).list();
        for (User user : users) {
            assertFalse(user.getUsername().equals(username));
        }
    }

    @Test
    void lk() {
        List<User> users = null;
        users = query.find(User.class).where().lk(User::getUsername, username).list();
        for (User user : users) {
            assertTrue(user.getUsername().equals(username));
        }

        users = query.find(User.class).where().lk(User::getUsername, startWith + "%").list();
        for (User user : users) {
            assertTrue(user.getUsername().startsWith(startWith));
        }

        users = query.find(User.class).where().lk(User::getUsername, "%" + endWith).list();
        for (User user : users) {
            assertTrue(user.getUsername().endsWith(endWith));
        }

        users = query.find(User.class).where().lk(User::getUsername, "%" + contains + "%").list();
        for (User user : users) {
            assertTrue(user.getUsername().contains(contains));
        }
    }

    @Test
    void nl() {
        List<User> users = query.find(User.class).where().nl(User::getUsername, username).list();
        for (User user : users) {
            assertFalse(user.getUsername().equals(username));
        }

        users = query.find(User.class).where().nl(User::getUsername, startWith + "%").list();
        for (User user : users) {
            assertFalse(user.getUsername().startsWith(startWith));
        }

        query.find(User.class).where().nl(User::getUsername, "%" + endWith).list();
        for (User user : users) {
            assertFalse(user.getUsername().endsWith(endWith));
        }

        users = query.find(User.class).where().nl(User::getUsername, "%" + contains + "%").list();
        for (User user : users) {
            assertFalse(user.getUsername().contains(contains));
        }
    }
}
