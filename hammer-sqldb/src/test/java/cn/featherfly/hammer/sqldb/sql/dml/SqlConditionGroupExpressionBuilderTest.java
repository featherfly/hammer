//
//package cn.featherfly.hammer.sqldb.sql.dml;
//
//import static org.testng.Assert.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import cn.featherfly.common.db.dialect.Dialects;
//import cn.featherfly.common.operator.ComparisonOperator;
//import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
//import cn.featherfly.common.repository.IgnoreStrategy;
//import cn.featherfly.common.repository.builder.BuilderException;
//import cn.featherfly.hammer.config.DslConfigImpl;
//import cn.featherfly.hammer.config.dsl.DslConfig;
//import cn.featherfly.hammer.sqldb.jdbc.SimpleSqlPageFactory;
//import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
//import cn.featherfly.hammer.sqldb.jdbc.TestBase;
//
///**
// * SqlConditionGroupExpressionBuilderTest.
// *
// * @author zhongj
// */
//@Test(groups = { "dml-test" })
//public class SqlConditionGroupExpressionBuilderTest extends TestBase {
// FIXME 后续来处理
//    SqlPageFactory sqlPageFactory = new SimpleSqlPageFactory();
//
//    List<Object> params = new ArrayList<>();
//
//    String name = "yufei";
//    String username = "featherfly";
//    String pwd = "123";
//    String sex = "m";
//    Integer age = 18;
//
//    DslConfig dslConfig = null;
//
//    @BeforeClass
//    public void init2() {
//        params.clear();
//        params.add(name);
//        params.add(pwd);
//        params.add(sex);
//        params.add(age);
//        params.add(username);
//
//        dslConfig = new DslConfigImpl();
//    }
//
//    @Test
//    public void testSqlConditionExpressionBuilder() {
//        SqlConditionExpressionBuilder builder = new SqlConditionExpressionBuilder(Dialects.MYSQL, "id", 1,
//                ComparisonOperator.EQ, IgnoreStrategy.EMPTY);
//        String result = builder.toString();
//        assertEquals(result, "`id` = ?");
//
//        assertEquals(builder.getConditionColumnElement().toSql(), "`id` = ?");
//    }
//
//    @Test(expectedExceptions = BuilderException.class)
//    public void testSqlConditionExpressionBuilderException() {
//        new SqlConditionExpressionBuilder(Dialects.MYSQL, "id", 1, null, MatchStrategy.AUTO, "u", IgnoreStrategy.EMPTY);
//    }
//
//    @Test
//    public void testSqlConditionGroupExpressionBuilder() {
//        SqlConditionGroupExpressionBuilder builder = new SqlConditionGroupExpressionBuilder(Dialects.MYSQL,
//                dslConfig.getQueryConfig());
//        builder.eq("name", name).and().eq("pwd", pwd).and().group().eq("sex", sex).or().gt("age", age).endGroup().and()
//                .eq("username", username);
//
//        System.out.println(builder.build());
//        System.out.println(builder.getParams());
//
//        assertEquals(builder.build(), "`name` = ? AND `pwd` = ? AND ( `sex` = ? OR `age` > ? ) AND `username` = ?");
//        assertEquals(builder.getParams(), params);
//
//        builder = new SqlConditionGroupExpressionBuilder(Dialects.MYSQL, dslConfig.getQueryConfig());
//        builder.eq("name", name).and().eq("pwd", pwd).and().group(c -> c.eq("sex", sex).or().gt("age", age)).and()
//                .eq("username", username);
//
//        System.out.println(builder.build());
//        System.out.println(builder.getParams());
//
//        assertEquals("`name` = ? AND `pwd` = ? AND ( `sex` = ? OR `age` > ? ) AND `username` = ?", builder.build());
//        assertEquals(params, builder.getParams());
//
//        builder = new SqlConditionGroupExpressionBuilder(Dialects.MYSQL, dslConfig.getQueryConfig());
//        builder.eq("name", name).and().eq("pwd", pwd).and(c -> c.eq("sex", sex).or().gt("age", age)).and()
//                .eq("username", username);
//
//        System.out.println(builder.build());
//        System.out.println(builder.getParams());
//
//        assertEquals("`name` = ? AND `pwd` = ? AND ( `sex` = ? OR `age` > ? ) AND `username` = ?", builder.build());
//        assertEquals(params, builder.getParams());
//    }
//
//    @Test
//    public void testSqlConditionGroupExpressionBuilderEmptyParam() {
//        SqlConditionGroupExpressionBuilder builder = new SqlConditionGroupExpressionBuilder(Dialects.MYSQL,
//                dslConfig.getQueryConfig());
//        Integer a = null;
//
//        builder.eq("name", name).and().eq("pwd", null).and().eq("sex", sex).or().gt("age", a);
//
//        System.out.println(builder.build());
//        System.out.println(builder.getParams());
//
//        assertEquals("`name` = ? AND `sex` = ?", builder.build());
//        //        assertEquals(params, builder.getParams());
//
//        builder = new SqlConditionGroupExpressionBuilder(Dialects.MYSQL, dslConfig.getQueryConfig());
//        builder.eq("name", name).and().eq("pwd", null).and().eq("sex", null).and().gt("age", a);
//
//        System.out.println(builder.build());
//        System.out.println(builder.getParams());
//        assertEquals("`name` = ?", builder.build());
//        //        assertEquals(params, builder.getParams());
//
//        builder = new SqlConditionGroupExpressionBuilder(Dialects.MYSQL, dslConfig.getQueryConfig());
//        builder.eq("name", null).and().eq("pwd", "1234").and().eq("sex", null).and().gt("age", a);
//
//        System.out.println(builder.build());
//        System.out.println(builder.getParams());
//        //        assertEquals("`name` = ?", builder.build());
//
//    }
//}
