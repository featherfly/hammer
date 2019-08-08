
package cn.featherfly.juorm.rdb.sql.dml;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.juorm.dml.builder.QueryBuilder;
import cn.featherfly.juorm.rdb.jdbc.JdbcTestBase;
import cn.featherfly.juorm.rdb.sql.dialect.Dialects;

/**
 * <p>
 * SqlConditionGroupExpressionBuilderTest
 * </p>
 * 
 * @author zhongj
 */
@Test(groups = { "dml-test" })
public class SqlConditionGroupExpressionBuilderTest extends JdbcTestBase {
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
                Dialects.MYSQL);
        builder.eq("name", name).and().eq("pwd", pwd).and().group()
                .eq("sex", sex).or().gt("age", age);

        System.out.println(builder.build());
        System.out.println(builder.getParams());

        assertEquals("`name` = ? AND `pwd` = ? AND ( `sex` = ? OR `age` > ? )",
                builder.build());
        assertEquals(params, builder.getParams());

    }
}
