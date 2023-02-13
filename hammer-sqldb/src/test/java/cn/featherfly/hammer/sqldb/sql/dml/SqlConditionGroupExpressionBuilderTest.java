
package cn.featherfly.hammer.sqldb.sql.dml;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.db.dialect.Dialects;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.operator.QueryOperator;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.common.repository.IgnorePolicy;
import cn.featherfly.common.repository.builder.BuilderException;
import cn.featherfly.hammer.sqldb.jdbc.SimpleSqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.TestBase;
import cn.featherfly.hammer.sqldb.jdbc.vo.UserInfo;

/**
 * SqlConditionGroupExpressionBuilderTest.
 *
 * @author zhongj
 */
@Test(groups = { "dml-test" })
public class SqlConditionGroupExpressionBuilderTest extends TestBase {

    SqlPageFactory sqlPageFactory = new SimpleSqlPageFactory();

    List<Object> params = new ArrayList<>();

    String name = "yufei";
    String username = "featherfly";
    String pwd = "123";
    String sex = "m";
    Integer age = 18;

    @BeforeClass
    public void init2() {
        params.clear();
        params.add(name);
        params.add(pwd);
        params.add(sex);
        params.add(age);
        params.add(username);
    }

    @Test
    public void testSqlSortExpressionBuilder() {
        SqlSortExpressionBuilder builder = new SqlSortExpressionBuilder(Dialects.MYSQL);
        String result = builder.asc("id", "name").build();
        System.out.println(result);
        assertEquals(result, " ORDER BY `id` ASC, `name` ASC");
        assertEquals(builder.expression(), result);
        System.out.println(builder.toString());

        builder = new SqlSortExpressionBuilder(Dialects.MYSQL, "u");
        result = builder.asc(ArrayUtils.toList("id", "name")).build();
        System.out.println(result);
        assertEquals(result, " ORDER BY u.`id` ASC, u.`name` ASC");
        assertEquals(builder.expression(), result);

        builder = new SqlSortExpressionBuilder(Dialects.MYSQL);
        result = builder.desc("id", "name").build();
        System.out.println(result);
        assertEquals(result, " ORDER BY `id` DESC, `name` DESC");
        assertEquals(builder.expression(), result);

        builder = new SqlSortExpressionBuilder(Dialects.MYSQL);
        builder.setTableAlias("u");
        assertEquals(builder.getTableAlias(), "u");
        result = builder.desc(ArrayUtils.toList("id", "name")).build();
        System.out.println(result);
        assertEquals(result, " ORDER BY u.`id` DESC, u.`name` DESC");
        assertEquals(builder.expression(), result);

        builder = new SqlSortExpressionBuilder(Dialects.MYSQL, "u");
        result = builder.asc("id", "name").desc("age", "password").asc("email").desc("mobile").build();
        System.out.println(result);
        assertEquals(result,
                " ORDER BY u.`id` ASC, u.`name` ASC, u.`age` DESC, u.`password` DESC, u.`email` ASC, u.`mobile` DESC");
        assertEquals(builder.expression(), result);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testSqlSortExpressionBuilder2() {
        SqlSortExpressionBuilder builder = new SqlSortExpressionBuilder(Dialects.MYSQL);
        String result = builder.asc(UserInfo::getId).build();
        System.out.println(result);
        assertEquals(result, " ORDER BY `id` ASC");
        assertEquals(builder.expression(), result);
        System.out.println(builder.toString());

        builder = new SqlSortExpressionBuilder(Dialects.MYSQL, "u");
        result = builder.asc(UserInfo::getId, UserInfo::getName).build();
        System.out.println(result);
        assertEquals(result, " ORDER BY u.`id` ASC, u.`name` ASC");
        assertEquals(builder.expression(), result);

        builder = new SqlSortExpressionBuilder(Dialects.MYSQL);
        result = builder.desc(UserInfo::getId).build();
        System.out.println(result);
        assertEquals(result, " ORDER BY `id` DESC");
        assertEquals(builder.expression(), result);
        System.out.println(builder.toString());

        builder = new SqlSortExpressionBuilder(Dialects.MYSQL, "u");
        result = builder.desc(UserInfo::getId, UserInfo::getName).build();
        System.out.println(result);
        assertEquals(result, " ORDER BY u.`id` DESC, u.`name` DESC");
        assertEquals(builder.expression(), result);

    }

    @Test
    public void testSqlConditionExpressionBuilder() {
        SqlConditionExpressionBuilder builder = new SqlConditionExpressionBuilder(Dialects.MYSQL, "id", 1,
                QueryOperator.EQ, IgnorePolicy.EMPTY);
        String result = builder.toString();
        assertEquals(result, "`id` = ?");

        assertEquals(builder.getConditionColumnElement().toSql(), "`id` = ?");
    }

    @Test(expectedExceptions = BuilderException.class)
    public void testSqlConditionExpressionBuilderException() {
        new SqlConditionExpressionBuilder(Dialects.MYSQL, "id", 1, null, QueryPolicy.AUTO, "u", IgnorePolicy.EMPTY);
    }

    @Test
    public void testSqlConditionGroupExpressionBuilder() {
        SqlConditionGroupExpressionBuilder builder = new SqlConditionGroupExpressionBuilder(Dialects.MYSQL,
                sqlPageFactory, IgnorePolicy.EMPTY);
        builder.eq("name", name).and().eq("pwd", pwd).and().group().eq("sex", sex).or().gt("age", age).endGroup().and()
                .eq("username", username);

        System.out.println(builder.build());
        System.out.println(builder.getParams());

        assertEquals(builder.build(), "`name` = ? AND `pwd` = ? AND ( `sex` = ? OR `age` > ? ) AND `username` = ?");
        assertEquals(builder.getParams(), params);

        builder = new SqlConditionGroupExpressionBuilder(Dialects.MYSQL, sqlPageFactory, IgnorePolicy.EMPTY);
        builder.eq("name", name).and().eq("pwd", pwd).and().group(c -> c.eq("sex", sex).or().gt("age", age)).and()
                .eq("username", username);

        System.out.println(builder.build());
        System.out.println(builder.getParams());

        assertEquals("`name` = ? AND `pwd` = ? AND ( `sex` = ? OR `age` > ? ) AND `username` = ?", builder.build());
        assertEquals(params, builder.getParams());

        builder = new SqlConditionGroupExpressionBuilder(Dialects.MYSQL, sqlPageFactory, IgnorePolicy.EMPTY);
        builder.eq("name", name).and().eq("pwd", pwd).and(c -> c.eq("sex", sex).or().gt("age", age)).and()
                .eq("username", username);

        System.out.println(builder.build());
        System.out.println(builder.getParams());

        assertEquals("`name` = ? AND `pwd` = ? AND ( `sex` = ? OR `age` > ? ) AND `username` = ?", builder.build());
        assertEquals(params, builder.getParams());
    }

    @Test
    public void testSqlConditionGroupExpressionBuilderEmptyParam() {
        SqlConditionGroupExpressionBuilder builder = new SqlConditionGroupExpressionBuilder(Dialects.MYSQL,
                sqlPageFactory, IgnorePolicy.EMPTY);
        Integer a = null;

        builder.eq("name", name).and().eq("pwd", null).and().eq("sex", sex).or().gt("age", a);

        System.out.println(builder.build());
        System.out.println(builder.getParams());

        assertEquals("`name` = ? AND `sex` = ?", builder.build());
        //        assertEquals(params, builder.getParams());

        builder = new SqlConditionGroupExpressionBuilder(Dialects.MYSQL, sqlPageFactory, IgnorePolicy.EMPTY);
        builder.eq("name", name).and().eq("pwd", null).and().eq("sex", null).and().gt("age", a);

        System.out.println(builder.build());
        System.out.println(builder.getParams());
        assertEquals("`name` = ?", builder.build());
        //        assertEquals(params, builder.getParams());

        builder = new SqlConditionGroupExpressionBuilder(Dialects.MYSQL, sqlPageFactory, IgnorePolicy.EMPTY);
        builder.eq("name", null).and().eq("pwd", "1234").and().eq("sex", null).and().gt("age", a);

        System.out.println(builder.build());
        System.out.println(builder.getParams());
        //        assertEquals("`name` = ?", builder.build());

    }
}
