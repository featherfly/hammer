
package cn.featherfly.hammer.sqldb.sql.dml;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import cn.featherfly.common.db.dialect.Dialects;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.hammer.sqldb.jdbc.TestBase;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;

/**
 * SqlSortExpressionBuilderTest.
 *
 * @author zhongj
 */
@Test(groups = { "dml-test" })
public class SqlSortExpressionBuilderTest extends TestBase {

    @Test
    public void testStringParam() {
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
    public void testLambdaParam() {
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
}
