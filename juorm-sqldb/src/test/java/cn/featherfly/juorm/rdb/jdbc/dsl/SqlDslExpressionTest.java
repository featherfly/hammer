
package cn.featherfly.juorm.rdb.jdbc.dsl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.lang.UUIDGenerator;
import cn.featherfly.juorm.dml.builder.QueryBuilder;
import cn.featherfly.juorm.expression.SimpleRepository;
import cn.featherfly.juorm.rdb.jdbc.JdbcTestBase;
import cn.featherfly.juorm.rdb.jdbc.JuormJdbcImpl;
import cn.featherfly.juorm.rdb.jdbc.dsl.execute.SqlConditionGroupExpression;
import cn.featherfly.juorm.rdb.jdbc.dsl.execute.SqlDeleteExpression;
import cn.featherfly.juorm.rdb.jdbc.dsl.execute.SqlDeleter;
import cn.featherfly.juorm.rdb.jdbc.dsl.execute.SqlUpdater;
import cn.featherfly.juorm.rdb.jdbc.vo.DistrictDivision;
import cn.featherfly.juorm.rdb.jdbc.vo.User;
import cn.featherfly.juorm.rdb.jdbc.vo.UserInfo;
import cn.featherfly.juorm.rdb.sql.dml.builder.basic.SqlDeleteFromBasicBuilder;

/**
 * <p>
 * 类的说明放这里
 * </p>
 * <p>
 * copyright cdthgk 2010-2020, all rights reserved.
 * </p>
 *
 * @author 钟冀
 */
public class SqlDslExpressionTest extends JdbcTestBase {

    QueryBuilder sub = null;
    List<Object> params = new ArrayList<>();

    String name = "yufei";
    String pwd = "123";
    String sex = "m";
    Integer age = 18;

    @BeforeClass
    public void init() {
        params.add(name);
        params.add(pwd);
        params.add(sex);
        params.add(age);
    }

    @Test
    public void testSqlConditionGroupExpressionBuilder() {
        SqlConditionGroupExpression builder = new SqlConditionGroupExpression(jdbc);
        builder.eq("name", name).and().eq("pwd", pwd).and().group().eq("sex", sex).or().gt("age", age);

        System.out.println(builder.build());
        System.out.println(builder.getParams());

        assertEquals("`name` = ? AND `pwd` = ? AND ( `sex` = ? OR `age` > ? )", builder.build());
        assertEquals(params, builder.getParams());

    }

    @Test
    public void testSqlDeleteExpression() {
        SqlDeleteExpression del = new SqlDeleteExpression(jdbc,
                new SqlDeleteFromBasicBuilder(jdbc.getDialect(), "user"));
        del.eq("name", name).and().eq("pwd", pwd).and().group().eq("sex", sex).or().gt("age", age);

        System.out.println(del.build());
        System.out.println(del.getParams());

        assertEquals("DELETE FROM `user` WHERE `name` = ? AND `pwd` = ? AND ( `sex` = ? OR `age` > ? )", del.build());
        assertEquals(params, del.getParams());

    }

    @Test
    public void testSqlTypeDelete() {
        JuormJdbcImpl juorm = new JuormJdbcImpl(jdbc, factory);
        int size = 10;
        for (int i = 0; i < size; i++) {
            User u = new User();
            u.setUsername("name_delete_" + UUIDGenerator.generateUUID22Letters());
            juorm.save(u);
        }
        SqlDeleter sqlDeleter = new SqlDeleter(jdbc, factory);
        int no = sqlDeleter.delete(User.class).where().sw("username", "name_delete_").execute();
        assertTrue(no == size);

        for (int i = 0; i < size; i++) {
            User u = new User();
            u.setPwd("pwd_delete_" + UUIDGenerator.generateUUID22Letters());
            juorm.save(u);
        }
        no = sqlDeleter.delete(User.class).where().sw("pwd", "pwd_delete_").execute();
        assertTrue(no == size);
    }

    @Test
    public void testSqlTypeDelete2() {
        JuormJdbcImpl juorm = new JuormJdbcImpl(jdbc, factory);
        int size = 10;
        int userId = 10;
        for (int i = 0; i < size; i++) {
            UserInfo u = new UserInfo();
            u.setUser(new User(userId));
            juorm.save(u);
        }
        SqlDeleter sqlDeleter = new SqlDeleter(jdbc, factory);
        int no = sqlDeleter.delete(UserInfo.class).where().eq("user.id", userId).execute();
        assertEquals(no, size);

        String province = "黑龙江";
        for (int i = 0; i < size; i++) {
            UserInfo u = new UserInfo();
            u.setUser(new User(1));
            DistrictDivision division = new DistrictDivision();
            division.setProvince(province);
            division.setCity("哈尔冰");
            u.setDivision(division);
            juorm.save(u);
        }
        no = sqlDeleter.delete(UserInfo.class).where().eq("division.province", province).execute();
        assertEquals(no, size);
    }

    @Test
    public void testSqlUpdateExpression() {
        params.clear();
        params.add(name);
        params.add(pwd);
        params.add(age);
        params.add(sex);
        SqlUpdater updater = new SqlUpdater(jdbc);
        SqlConditionGroupExpression e = (SqlConditionGroupExpression) updater.update(new SimpleRepository("user"))
                .set("name", name).set("pwd", pwd).increase("age", age).where().eq("sex", sex);

        System.out.println(e);
        System.out.println(e.getParams());

        assertEquals("UPDATE `user` SET `name` = ?, `pwd` = ?, `age` = `age` + ? WHERE `sex` = ?", e.toString());
        assertEquals(params, e.getParams());

        e = (SqlConditionGroupExpression) updater.update(new SimpleRepository("user")).property("name").set(name)
                .property("pwd").set(pwd).propertyNumber("age").increase(age).where().eq("sex", sex);

        System.out.println(e);
        System.out.println(e.getParams());

        assertEquals("UPDATE `user` SET `name` = ?, `pwd` = ?, `age` = `age` + ? WHERE `sex` = ?", e.toString());
        assertEquals(params, e.getParams());

    }

    @Test
    public void testSqlTypeUpdateExpression() {
        SqlUpdater sqlUpdater = new SqlUpdater(jdbc, factory);

        int no = sqlUpdater.update(User.class).property("password").set("111111").where().property("id").eq("3")
                .execute();
        assertTrue(no == 1);

        no = sqlUpdater.update(User.class).property("pwd").set("222222").where().in("id", new Integer[] { 4, 5 })
                .execute();
        assertTrue(no == 2);
    }

    @Test
    public void testSqlTypeUpdateExpression2() {
        SqlUpdater sqlUpdater = new SqlUpdater(jdbc, factory);

        int no = sqlUpdater.update(UserInfo.class).property("province").set("四川1").where().property("id").eq(1)
                .execute();
        assertTrue(no == 1);

        no = sqlUpdater.update(UserInfo.class).property("division.province").set("四川").where().property("id").eq(1)
                .execute();
        assertTrue(no == 1);

        no = sqlUpdater.update(UserInfo.class).property("user_id").set(3).where().eq("id", 2).execute();
        assertTrue(no == 1);

        no = sqlUpdater.update(UserInfo.class).property("user.id").set(2).where().eq("id", 2).execute();
        assertTrue(no == 1);
    }

}
