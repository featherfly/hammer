
package cn.featherfly.hammer.sqldb.jdbc.dsl;

import static org.junit.Assert.assertNull;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.vo.Tree2;
import cn.featherfly.hammer.sqldb.jdbc.vo.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.UserInfo;
import cn.featherfly.hammer.sqldb.jdbc.vo.UserRole2;

/**
 * sql query type test.
 *
 * @author zhongj
 */
public class SqlQueryTypeJoinTest extends JdbcTestBase {

    SqlQuery query;

    UserInfo userInfo = null;
    User user = null;
    Integer uid = 1;
    List<Tree2> trees = new ArrayList<>();

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
    void testJoin0_ER() {
        userInfo = query.find(UserInfo.class).join(UserInfo::getUser).where().eq(UserInfo::getId, uid).single();
        System.err.println(userInfo);
        assertEquals(userInfo.getId(), uid);
        assertNotNull(userInfo.getUser().getId());
        assertNull(userInfo.getUser().getUsername());
        /*
         SELECT _user_info0.`province` `division.province`, _user_info0.`city` `division.city`, _user_info0.`district` `division.district`, _user_info0.`id` `id`, _user_info0.`user_id` `user.id`, _user_info0.`name` `name`, _user_info0.`descp` `descp`
         FROM `user_info` _user_info0
         JOIN `user` _user0 ON _user0.`id` = _user_info0.`user_id` WHERE _user_info0.`id` = ?
         */

        userInfo = query.find(UserInfo.class).join(UserInfo::getUser).fetch().where().eq(UserInfo::getId, uid).single();
        System.err.println(userInfo);
        assertEquals(userInfo.getId(), uid);
        assertNotNull(userInfo.getUser().getId());
        assertNotNull(userInfo.getUser().getUsername());
    }

    @Test
    void testJoin0_EE() {
        //        trees = query.find(Tree2.class).join(Tree2::getParent).list();
        //        System.err.println(trees);

        trees = query.find(Tree2.class).join(Tree2::getParent).fetch().list();
        System.err.println(trees);
    }

    @Test
    void testJoin0_RE() {
        user = query.find(User.class).join(UserInfo::getUser).where().eq(User::getId, uid).single();
        System.err.println(user);
        assertEquals(user.getId(), uid);
        /*
         SELECT _user0.`id` `id`, _user0.`username` `username`, _user0.`password` `pwd`, _user0.`mobile_no` `mobileNo`, _user0.`age` `age`
         FROM `user` _user0
         JOIN `user_info` _user_info0 ON _user_info0.`user_id` = _user0.`id` WHERE _user0.`id` = ?
         */
    }

    @Test(expectedExceptions = SqldbHammerException.class)
    void testJoin0_RE_Exception() {
        user = query.find(User.class).join(UserInfo::getUser).fetch().where().eq(User::getId, uid).single();
        // 因为User没有映射UserInfo,所以fetch()方法无法把返回内容映射进User对象，抛出异常
    }

    @Test
    void testJoin1_ER1_R2E() {
        userInfo = query.find(UserInfo.class).join(UserInfo::getUser).join1(UserRole2::getUser).where()
                .eq(UserInfo::getId, uid).single();
        System.err.println(userInfo);
        assertEquals(userInfo.getId(), uid);
        assertNotNull(userInfo.getUser().getId());
        assertNull(userInfo.getUser().getUsername());
        /*
         SELECT _user_info0.`province` `division.province`, _user_info0.`city` `division.city`, _user_info0.`district` `division.district`, _user_info0.`id` `id`, _user_info0.`user_id` `user.id`, _user_info0.`name` `name`, _user_info0.`descp` `descp`
        FROM `user_info` _user_info0
        JOIN `user` _user0 ON _user0.`id` = _user_info0.`user_id`
        JOIN `user_role` _user_role0 ON _user_role0.`user_id` = _user0.`id`
        WHERE _user_info0.`id` = 1
         */

        //        userInfo = query.find(UserInfo.class).join(UserInfo::getUser).fetch().join1(UserRole2::getUser).fetch().where()
        userInfo = query.find(UserInfo.class).join(UserInfo::getUser).fetch().join1(UserRole2::getUser).fetch().where()
                .eq(UserInfo::getId, uid).single();
        System.err.println(userInfo);
        assertEquals(userInfo.getId(), uid);
        assertNotNull(userInfo.getUser().getId());
        assertNotNull(userInfo.getUser().getUsername());
        /*
        
         */
    }

    @Test
    void testJoin1_EE_EE_() {
        // EE1_E1E2
        query.find(Tree2.class).join(Tree2::getParent).fetch().join1(Tree2::getParent).fetch().list();
        /*
        SELECT _tree0.`id` `id`, _tree0.`parent_id` `parent.id`, _tree0.`name` `name`,
            _tree1.`parent_id` `parent.parent.id`, _tree1.`name` `parent.name`,
            _tree2.`parent_id` `parent.parent.id`, _tree2.`name` `parent.name` -- 这个是错误的
        FROM `tree` _tree0
        JOIN `tree` _tree1 ON _tree1.`id` = _tree0.`parent_id`
        JOIN `tree` _tree2 ON _tree2.`id` = _tree1.`parent_id`
         */
    }

    @Test
    void testJoin1_EE_EE() {
        // EE1_E1E2
        query.find(Tree2.class).join(Tree2::getParent).join1(Tree2::getParent).list();
        /*
        SELECT _tree0.`id` `id`, _tree0.`parent_id` `parent.id`, _tree0.`name` `name`
        FROM `tree` _tree0
        JOIN `tree` _tree1 ON _tree1.`id` = _tree0.`parent_id`
        JOIN `tree` _tree2 ON _tree2.`id` = _tree1.`parent_id`
         */
        // EE1_E1E2
        query.find(Tree2.class).join(Tree2::getParent).fetch().join1(Tree2::getParent).list();
        /*
        SELECT _tree0.`id` `id`, _tree0.`parent_id` `parent.id`, _tree0.`name` `name`,
            _tree1.`parent_id` `parent.parent.id`, _tree1.`name` `parent.name`
        FROM `tree` _tree0
        JOIN `tree` _tree1 ON _tree1.`id` = _tree0.`parent_id`
        JOIN `tree` _tree2 ON _tree2.`id` = _tree1.`parent_id`
         */

        // EE1_E1E2
        query.find(Tree2.class).join(Tree2::getParent).fetch().join1(Tree2::getParent).fetch().list();
        /*
        SELECT _tree0.`id` `id`, _tree0.`parent_id` `parent.id`, _tree0.`name` `name`,
            _tree1.`parent_id` `parent.parent.id`, _tree1.`name` `parent.name`,
            _tree2.`parent_id` `parent.parent.parent.id`, _tree2.`name` `parent.parent.name`
        FROM `tree` _tree0
        JOIN `tree` _tree1 ON _tree1.`id` = _tree0.`parent_id`
        JOIN `tree` _tree2 ON _tree2.`id` = _tree1.`parent_id`
         */

        // EE1_EE2
        query.find(Tree2.class).join(Tree2::getParent).join(Tree2::getParent).list();
        /*
        SELECT _tree0.`id` `id`, _tree0.`parent_id` `parent.id`, _tree0.`name` `name`
        FROM `tree` _tree0
        JOIN `tree` _tree1 ON _tree1.`id` = _tree0.`parent_id`
        JOIN `tree` _tree2 ON _tree2.`id` = _tree0.`parent_id`
         */
    }
}
