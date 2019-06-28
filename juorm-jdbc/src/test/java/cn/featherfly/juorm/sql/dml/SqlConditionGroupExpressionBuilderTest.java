
package cn.featherfly.juorm.sql.dml;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.juorm.dml.builder.QueryBuilder;
import cn.featherfly.juorm.dsl.SimpleRepository;
import cn.featherfly.juorm.jdbc.Jdbc;
import cn.featherfly.juorm.jdbc.dsl.execute.SqlConditionGroupExpressionBuilder;
import cn.featherfly.juorm.jdbc.dsl.execute.SqlDeleteExpression;
import cn.featherfly.juorm.jdbc.dsl.execute.SqlUpdater;
import cn.featherfly.juorm.sql.dialect.Dialects;

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
public class SqlConditionGroupExpressionBuilderTest {

    Jdbc jdbc = new Jdbc(null, Dialects.MYSQL);
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
        SqlConditionGroupExpressionBuilder builder = new SqlConditionGroupExpressionBuilder(
                new Jdbc(null, Dialects.MYSQL));
        builder.eq("name", name).and().eq("pwd", pwd).and().group().eq("sex", sex).or().gt("age", age);

        System.out.println(builder.build());
        System.out.println(builder.getParams());

        assertEquals("`name` = ? AND `pwd` = ? AND ( `sex` = ? OR `age` > ? )", builder.build());
        assertEquals(params, builder.getParams());

    }

    @Test
    public void testSqlDeleteExpression() {
        SqlDeleteExpression del = new SqlDeleteExpression(jdbc, "user");
        del.eq("name", name).and().eq("pwd", pwd).and().group().eq("sex", sex).or().gt("age", age);

        System.out.println(del.build());
        System.out.println(del.getParams());

        assertEquals("DELETE FROM `user` WHERE `name` = ? AND `pwd` = ? AND ( `sex` = ? OR `age` > ? )", del.build());
        assertEquals(params, del.getParams());

    }

    @Test
    public void testSqlUpdateExpression() {
        params.clear();
        params.add(name);
        params.add(pwd);
        params.add(age);
        params.add(sex);
        SqlUpdater updater = new SqlUpdater(jdbc);
        SqlConditionGroupExpressionBuilder e = (SqlConditionGroupExpressionBuilder) updater
                .update(new SimpleRepository("user")).set("name", name).set("pwd", pwd).increase("age", age).where()
                .eq("sex", sex);

        System.out.println(e);
        System.out.println(e.getParams());

        assertEquals("UPDATE `user` SET `name` = ?, `pwd` = ?, `age` = `age` + ? WHERE `sex` = ?", e.toString());
        assertEquals(params, e.getParams());

    }

}
