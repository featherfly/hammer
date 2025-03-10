
package cn.featherfly.hammer.sqldb.dsl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.lang.UUIDGenerator;
import cn.featherfly.hammer.sqldb.SqldbHammerImpl;
import cn.featherfly.hammer.sqldb.dsl.execute.SqlDeleter;
import cn.featherfly.hammer.sqldb.dsl.execute.SqlUpdater;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.DistrictDivision;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User0;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;

/**
 * SqlDslExpressionTest.
 *
 * @author zhongj
 */
public class SqlDslExpressionTest extends JdbcTestBase {

    List<Object> params = new ArrayList<>();

    String name = "yufei";
    String pwd = "123";
    String sex = "m";
    Integer age = 18;

    SqldbHammerImpl hammer;

    @BeforeClass
    public void init2() {
        params.add(name);
        params.add(pwd);
        params.add(sex);
        params.add(age);

        //        hammer = SqldbHammerImpl.builder(jdbc, mappingFactory, configFactory, propertyAccessorFactory, hammerConfig).build();
        hammer = SqldbHammerImpl.builder(jdbc, mappingFactory, configFactory, propertyAccessorFactory, hammerConfig)
            .build();
    }

    //    @Test
    //    public void testSqlConditionGroupExpressionBuilder() {
    //  TODO 后续来处理
    //        SqlExecutableConditionGroupExpression<
    //                UpdateConditionConfig> expression = new SqlExecutableConditionGroupExpression<>(jdbc,
    //                        hammerConfig.getDslConfig().getUpdateConfig());
    //        expression.eq("name", name).and().eq("pwd", pwd).and().group().eq("sex", sex).or().gt("age", age);
    //
    //        System.out.println(expression.expression());
    //        System.out.println(expression.getParams());
    //
    //        assertEquals("`name` = ? AND `pwd` = ? AND ( `sex` = ? OR `age` > ? )".replaceAll("`",
    //                jdbc.getDialect().getWrapSymbol()), expression.expression());
    //        assertEquals(params, expression.getParams());
    //    }

    //    @Test
    //    public void testSqlConditionGroupExpressionBuilder2() {
    //  TODO 后续来处理
    //        SqlExecutableConditionGroupExpression<
    //                UpdateConditionConfig> builder = new SqlExecutableConditionGroupExpression<>(jdbc,
    //                        hammerConfig.getDslConfig().getUpdateConfig());
    //        // 测试忽略策略为NONE
    //
    //        String mobile = null;
    //        List<Object> params2 = new ArrayList<>();
    //        params2.add(name);
    //        params2.add(pwd);
    //        params2.add(sex);
    //        params2.add(age);
    //        params2.add(mobile);
    //
    //        UpdateConfig updateConfig = new UpdateConfigImpl();
    //        updateConfig.setIgnoreStrategy(IgnoreStrategy.NONE);
    //
    //        builder = new SqlExecutableConditionGroupExpression<>(jdbc, updateConfig);
    //        builder.eq("name", name).and().eq("pwd", pwd).and().group().eq("sex", sex).or().gt("age", age).endGroup().and()
    //                .eq("mobile", mobile);
    //
    //        System.out.println(builder.expression());
    //        System.out.println(builder.getParams());
    //
    //        assertEquals("`name` = ? AND `pwd` = ? AND ( `sex` = ? OR `age` > ? ) AND `mobile` = ?".replaceAll("`",
    //                jdbc.getDialect().getWrapSymbol()), builder.expression());
    //        assertEquals(params2, builder.getParams());
    //    }

    //    @Test
    //    public void testSqlDeleteExpression() {
    // //      TODO 后续来处理
    //        SqlDeleteExpression del = new SqlDeleteExpression(jdbc,
    //                new SqlDeleteFromBasicBuilder(jdbc.getDialect(), "user"),
    //                hammerConfig.getDslConfig().getDeleteConfig());
    //        del.eq("name", name).and().eq("pwd", pwd).and().group().eq("sex", sex).or().gt("age", age);
    //
    //        System.out.println(del.expression());
    //        System.out.println(del.getParams());
    //
    //        assertEquals("DELETE FROM `user` WHERE `name` = ? AND `pwd` = ? AND ( `sex` = ? OR `age` > ? )".replaceAll("`",
    //                jdbc.getDialect().getWrapSymbol()), del.expression());
    //        assertEquals(params, del.getParams());
    //
    //    }

    @Test
    public void testSqlTypeDelete() {
        int size = 10;
        for (int i = 0; i < size; i++) {
            User u = new User();
            u.setUsername("name_delete_" + UUIDGenerator.generateUUID22Letters());
            hammer.save(u);
        }
        SqlDeleter sqlDeleter = new SqlDeleter(jdbc, mappingFactory, hammerConfig.getDslConfig().getDeleteConfig());
        int no = sqlDeleter.delete(User.class).where().sw(User::getUsername, "name_delete_").execute();
        assertTrue(no == size);

        for (int i = 0; i < size; i++) {
            User u = new User();
            u.setPwd("pwd_del_" + UUIDGenerator.generateUUID22Letters());
            u.setUsername("un_del_" + UUIDGenerator.generateUUID22Letters());
            hammer.save(u);
        }
        no = sqlDeleter.delete(User.class).where().sw(User::getPwd, "pwd_del_").execute();
        assertTrue(no == size);
    }

    private void saveUserInfo(int size, User user) {
        for (int i = 0; i < size; i++) {
            UserInfo u = new UserInfo();
            u.setUser(user);
            hammer.save(u);
        }
    }

    @Test
    public void testSqlTypeDelete2() {
        int size = 3;
        int userId = 12;
        Integer uid = userId;
        User user = new User(userId);
        saveUserInfo(size, user);
        // ManyToOne
        SqlDeleter sqlDeleter = new SqlDeleter(jdbc, mappingFactory, hammerConfig.getDslConfig().getDeleteConfig());
        //        int no = sqlDeleter.delete(UserInfo.class).where().eq(UserInfo::getUser, User::getId, userId).execute();
        int no = sqlDeleter.delete(UserInfo.class).where().eq(UserInfo::getUser, user).execute();
        assertEquals(no, size);

        // ManyToOne
        saveUserInfo(size, user);
        no = sqlDeleter.delete(UserInfo.class).where().eq(UserInfo::getUser, uid).execute();
        assertEquals(no, size);

        //        Function<UserInfo, User> f = UserInfo::getUser;
        //        no = sqlDeleter.delete(UserInfo.class).where().eq(f, userId).execute(); // 编译错误

        String province = "黑龙江";
        for (int i = 0; i < size; i++) {
            UserInfo u = new UserInfo();
            u.setUser(new User(1));
            DistrictDivision division = new DistrictDivision();
            division.setProvince(province);
            division.setCity("哈尔冰");
            u.setDivision(division);
            hammer.save(u);
        }
        //        no = sqlDeleter.delete(UserInfo.class).where()
        //                .eq(UserInfo::getDivision, DistrictDivision::getProvince, province).execute();
        no = sqlDeleter.delete(UserInfo.class).where().property(UserInfo::getDivision)
            .property(DistrictDivision::getProvince).eq(province).execute();
        assertEquals(no, size);

        for (int i = 0; i < size; i++) {
            UserInfo u = new UserInfo();
            u.setUser(new User(1));
            DistrictDivision division = new DistrictDivision();
            division.setProvince(province);
            division.setCity("哈尔冰");
            u.setDivision(division);
            hammer.save(u);
        }

        UserInfo query = new UserInfo();
        query.setDivision(new DistrictDivision());
        query.getDivision().setProvince(province);

        //        no = sqlDeleter.delete(UserInfo.class).where().eq(query::getDivision, DistrictDivision::getProvince).execute();
        no = sqlDeleter.delete(UserInfo.class).where().property(UserInfo::getDivision)
            .property(DistrictDivision::getProvince).eq(query.getDivision().getProvince()).execute();
        assertEquals(no, size);
    }

    //    @Test
    //    public void testSqlUpdateExpression() {
    //      TODO 后续来处理
    //        params.clear();
    //        params.add(name);
    //        params.add(pwd);
    //        params.add(age);
    //        params.add(sex);
    //        SqlUpdater updater = new SqlUpdater(jdbc, mappingFactory, hammerConfig.getDslConfig().getUpdateConfig());
    //        SqlExecutableConditionGroupExpression<
    //                UpdateConditionConfig> e = (SqlExecutableConditionGroupExpression<UpdateConditionConfig>) updater
    //                        .update(new SimpleAliasRepository("user")).set("name", name).set("pwd", pwd)
    //                        .increase("age", age).where().eq("sex", sex);
    //
    //        System.out.println(e);
    //        System.out.println(e.getParams());
    //
    //        String sql = "UPDATE `user` SET `name` = ?, `pwd` = ?, `age` = `age` + ? WHERE `sex` = ?";
    //
    //        assertEquals(sql.replaceAll("`", jdbc.getDialect().getWrapSymbol()), e.toString());
    //        assertEquals(params, unwrapFieldValueOperators(e.getParams()));
    //
    //        e = (SqlExecutableConditionGroupExpression<UpdateConditionConfig>) updater.update(new SimpleRepository("user"))
    //                .property("name").set(name).property("pwd").set(pwd).propertyNumber("age").increase(age).where()
    //                .eq("sex", sex);
    //
    //        System.out.println(e);
    //        System.out.println(e.getParams());
    //
    //        assertEquals("UPDATE `user` SET `name` = ?, `pwd` = ?, `age` = `age` + ? WHERE `sex` = ?".replaceAll("`",
    //                jdbc.getDialect().getWrapSymbol()), e.toString());
    //        assertEquals(params, unwrapFieldValueOperators(e.getParams()));
    //
    //    }

    @Test
    public void testSqlTypeUpdateExpression() {
        SqlUpdater sqlUpdater = new SqlUpdater(jdbc, mappingFactory, hammerConfig.getDslConfig().getUpdateConfig());

        int no = sqlUpdater.update(User.class).property(User::getPwd).set("a11111").where().property(User::getId).eq(3)
            .execute();
        assertTrue(no == 1);

        no = sqlUpdater.update(User.class).property(User::getPwd).set("222222").where()
            .in(User::getId, new Integer[] { 4, 5 }).execute();
        //        .in((SerializableFunction<User, Integer>) User::getId, new Integer[] { 4, 5 }).execute();
        assertTrue(no == 2);

        no = sqlUpdater.update(User.class).property(User::getPwd).set("222222").where()
            //            .in(User::getId, Integer.valueOf(4), Integer.valueOf(5)).execute();
            .in((SerializableFunction<User, Integer>) User::getId, Integer.valueOf(4), Integer.valueOf(5)).execute();
        assertTrue(no == 2);

        //        no = sqlUpdater.update(User0.class).property(User0::getPwd).set("222222").where().in(User0::getId, 4, 5)
        //                .execute(); // 这样在oracle jdk 进行编译时报错
        no = sqlUpdater.update(User0.class).property(User0::getPwd).set("222222").where()
            .in((SerializableToIntFunction<User0>) User0::getId, 4, 5).execute();
        assertTrue(no == 2);
    }

    @Test
    public void testSqlTypeUpdateExpression2() {
        SqlUpdater sqlUpdater = new SqlUpdater(jdbc, mappingFactory, hammerConfig.getDslConfig().getUpdateConfig());

        DistrictDivision division = new DistrictDivision();
        division.setProvince("四川1");
        int no = 0;

        // Embbemed
        no = sqlUpdater.update(UserInfo.class).set(UserInfo::getDivision, division).where().property(UserInfo::getId)
            .eq(1).execute();
        assertTrue(no == 1);

        division.setProvince("四川");
        division.setCity("成都");
        division.setDistrict("金牛");

        no = sqlUpdater.update(UserInfo.class).set(UserInfo::getDivision, division).where().property(UserInfo::getId)
            .eq(1).execute();
        assertTrue(no == 1);

        no = sqlUpdater.update(UserInfo.class).property(UserInfo::getDivision).set(division).where()
            .property(UserInfo::getId).eq(1).execute();
        assertTrue(no == 1);

        no = sqlUpdater.update(UserInfo.class).set(UserInfo::getDivision, DistrictDivision::getProvince, "四川1").where()
            .property(UserInfo::getId).eq(1).execute();
        assertTrue(no == 1);

        no = sqlUpdater.update(UserInfo.class).property(UserInfo::getDivision, DistrictDivision::getProvince).set("四川")
            .where().property(UserInfo::getId).eq(1).execute();
        assertTrue(no == 1);

        // ManyToOne
        no = sqlUpdater.update(UserInfo.class).set(UserInfo::getUser, User::getId, 3).where().eq(UserInfo::getId, 2)
            .execute();
        assertTrue(no == 1);

        no = sqlUpdater.update(UserInfo.class).property(UserInfo::getUser, User::getId).set(3).where()
            .eq(UserInfo::getId, 2).execute();
        assertTrue(no == 1);

        User user = new User();
        user.setId(1);

        no = sqlUpdater.update(UserInfo.class).property(UserInfo::getUser).set(user).where().eq(UserInfo::getId, 2)
            .execute();
        assertTrue(no == 1);

        no = sqlUpdater.update(UserInfo.class).set(UserInfo::getUser, 2).where().eq(UserInfo::getId, 2).execute();
        assertTrue(no == 1);

        //        int no = sqlUpdater.update(UserInfo.class).property("province").set("四川1").where().property(UserInfo::getId)
        //                .eq(1).execute();
        //        assertTrue(no == 1);
        //
        //        no = sqlUpdater.update(UserInfo.class).property("division.province").set("四川").where().property(UserInfo::getId)
        //                .eq(1).execute();
        //        assertTrue(no == 1);
        //
        //        no = sqlUpdater.update(UserInfo.class).property("user_id").set(3).where().eq(UserInfo::getId, 2).execute();
        //        assertTrue(no == 1);
        //
        //        no = sqlUpdater.update(UserInfo.class).property("user.id").set(2).where().eq(UserInfo::getId, 2).execute();
        //        assertTrue(no == 1);
    }
}