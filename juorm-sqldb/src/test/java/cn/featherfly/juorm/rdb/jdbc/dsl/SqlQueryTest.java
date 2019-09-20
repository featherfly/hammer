
package cn.featherfly.juorm.rdb.jdbc.dsl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

import cn.featherfly.common.structure.HashChainMap;
import cn.featherfly.juorm.expression.SimpleRepository;
import cn.featherfly.juorm.mapping.ClassMapping;
import cn.featherfly.juorm.rdb.jdbc.JdbcTestBase;
import cn.featherfly.juorm.rdb.jdbc.JuormJdbcException;
import cn.featherfly.juorm.rdb.jdbc.dsl.query.SqlQuery;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMappingUtils;
import cn.featherfly.juorm.rdb.jdbc.vo.User;
import cn.featherfly.juorm.rdb.jdbc.vo.UserInfo;
import cn.featherfly.juorm.rdb.jdbc.vo.UserRole2;
import cn.featherfly.juorm.rdb.sql.dialect.Dialects;

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
        query.find("user").property("username", "password", "age")
                .list(User.class);
        query.find("user").property("username", "password", "age").where()
                .eq("username", "yufei").and().eq("password", "123456").and()
                .group().gt("age", 18).and().lt("age", 60).list(User.class);
    }

    @Test
    void test2() {
        SqlQuery query = new SqlQuery(jdbc);
        query.find("user").property("username", "password", "age").where()
                .eq("username", "yufei").and().eq("password", "123456").and()
                .group().gt("age", 18).and().lt("age", 60).list(User.class);
    }

    @Test
    void test3() {
        SqlQuery query = new SqlQuery(jdbc);
        query.find(new SimpleRepository("user", "u")).where()
                .eq("username", "yufei").and().eq("password", "123456").and()
                .group().gt("age", 18).and().lt("age", 60).list(User.class);
    }

    @Test
    void test4() {
        SqlQuery query = new SqlQuery(jdbc);
        query.find(new SimpleRepository("user", "u"))
                .property("username", "password", "age").where()
                .eq("username", "yufei").and().eq("password", "123456").and()
                .group().gt("age", 18).and().lt("age", 60).list(User.class);
    }

    @SuppressWarnings("unchecked")
    @Test
    void testMapping() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory);

        query.find(User.class).where().eq("username", "yufei").and()
                .eq("pwd", "123456").and().group().gt("age", 18).and()
                .lt("age", 60).list();

        query.find(User.class).property("username", "pwd", "age").where()
                .eq("username", "yufei").and().eq("pwd", "123456").and().group()
                .gt("age", 18).and().lt("age", 60).list();

        query.find(User.class)
                .property(User::getUsername, User::getPwd, User::getAge).where()
                .eq("username", "yufei").and().eq("pwd", "123456").and().group()
                .gt("age", 18).and().lt("age", 60).list();
        /*
         * query.find(User.class).with(UserInfo.class, UserInfo::getUser)
         * query.find(UserInfo.class).with(UserInfo::getUser, User.class)
         * query.find(UserInfo.class).with(UserInfo::getUser)
         * query.find("user").with("user_info").on("user_id",
         * "id").with("user_role").on("user_id", "id").with("role",
         * "user_role").on("id", "role_id")
         * query.find("user_info").with("user_id", "user")
         */
        query.find(User.class)
                .property(User::getUsername, User::getPwd, User::getAge).where()
                .eq("username", "yufei").and().eq(User::getPwd, "123456").and()
                .group().gt(User::getAge, 18).and().lt(User::getAge, 60).list();
    }

    @Test
    void testNestedMapping() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory);
        Integer userId = 1;
        UserInfo userInfo = query.find(UserInfo.class).where()
                .eq("user.id", userId).single();
        assertEquals(userInfo.getUser().getId(), userId);
        System.out.println(userInfo);

        String province = "四川";
        userInfo = query.find(UserInfo.class).where()
                .eq("division.province", province).single();
        assertEquals(userInfo.getDivision().getProvince(), province);
        System.out.println(userInfo);
    }

    @Test
    void testJoin() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory);

        query.find("user").property("username", "password", "age")
                .with("user_info").on("user_id").list();

        query.find("user").property("username", "password", "age")
                .with("user_info").on("user_id").fetch("name").list();

        query.find("user").property("username", "password", "age")
                .with("user_info").on("user_id").fetch().list();

        query.find("user").property("username", "password", "age")
                .with("user_info").on("user_id").fetch("name").list();

        query.find("user").property("username", "password", "age")
                .with("user_info").on("user_id").fetch("name").fetch().list();

        query.find("user").property("username", "password", "age")
                .with("user_info").on("user_id").fetch("name").fetch("descp")
                .list();

        query.find("user").property("username", "password", "age")
                .with("user_role").on("user_id").with("role")
                .on("id", "user_role", "role_id").fetch().list();

        query.find("user").property("username", "password", "age")
                .with(UserInfo.class).on("user_id").list();

        query.find("user").property("username", "password", "age")
                .with(UserInfo.class).on("user_id").fetch().list();

        // query.find("tree").with("tree").on("parent_id").list();
        //
        // query.find("tree").with("tree").on("parent_id").with("tree")
        // .on("parent_id").list();

        // query.find(Tree.class).with(Tree::getParentId).with(Tree.class)
        // .on("parent_id").list();

        query.find("user_info").with("user").on("id", "user_id")
                .fetchAlias("password", "pwd").fetch().list();

        UserInfo userInfo = query.find(UserInfo.class).with(UserInfo::getUser)
                .where().eq(UserInfo::getId, 1).single();
        System.err.println(userInfo);
        assertNull(userInfo.getUser().getUsername());
        userInfo = query.find(UserInfo.class).with(UserInfo::getUser).fetch()
                .where().eq(UserInfo::getId, 1).single();
        assertNotNull(userInfo.getUser().getUsername());
        System.err.println(userInfo);
    }

    @Test
    void testJoin2() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory);

        // query.find(User.class).with(UserRole2::getUser).list();
        //
        // query.find(Role.class).with(UserRole2::getRole).with(UserRole2::getUser)
        // .list();

        query.find(UserInfo.class).with(UserInfo::getUser)
                .with(UserRole2::getUser).with(UserRole2::getRole).list();

        // query.find(UserInfo.class).with(UserRole2::getUser).list();

        // query.find(User.class).with(UserRole2::getUser);
        // query.find(User.class).with(UserRole2::getUser)
        // .with(UserRole2::getRole);
        // query.find(User.class).with(UserRole2::getUser).with(UserRole2::getRole).where();
        // query.find(UserInfo.class).with(UserInfo::getUser).on(propertyName);
    }

    @Test(expectedExceptions = JuormJdbcException.class)
    void testJoinExceptions() {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory);
        query.find(UserInfo.class).with(UserRole2::getUser).list();
    }

    @Test
    void test11() {
        ClassMapping<?> cm = mappingFactory.getClassMapping(UserInfo.class);
        ClassMapping<?> cm2 = mappingFactory.getClassMapping(User.class);
        System.err.println(ClassMappingUtils.getSelectColumnsSql(cm, "ui",
                Dialects.MYSQL, mappingFactory,
                new HashChainMap<String, String>().putChain("user", "_u")));

        System.err.println(ClassMappingUtils.getSelectColumnsSql(cm, "ui",
                Dialects.MYSQL));

        System.err.println(ClassMappingUtils.getSelectColumnsSql(cm2, "u",
                "user", Dialects.MYSQL));

    }
}
