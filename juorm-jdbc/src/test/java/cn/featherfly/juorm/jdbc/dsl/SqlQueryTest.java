
package cn.featherfly.juorm.jdbc.dsl;

import org.testng.annotations.Test;

import cn.featherfly.juorm.expression.SimpleRepository;
import cn.featherfly.juorm.jdbc.Jdbc;
import cn.featherfly.juorm.jdbc.dsl.query.SqlQuery;
import cn.featherfly.juorm.sql.dialect.Dialects;

/**
 * <p>
 * SqlQueryTest
 * </p>
 *
 * @author zhongj
 */
public class SqlQueryTest {

    Jdbc jdbc = new Jdbc(null, Dialects.MYSQL);

    @Test
    void test1() {
        SqlQuery query = new SqlQuery(jdbc);
        query.find("user").property("name", "pwd", "age").list(SqlQuery.class);
        query.find("user").property("name", "pwd", "age").where().eq("name", "yufei").and().eq("pwd", "123456").and()
                .group().gt("age", 18).and().lt("age", 60).list(SqlQuery.class);
    }

    @Test
    void test2() {
        SqlQuery query = new SqlQuery(jdbc);
        query.find("user").property("name", "pwd", "age").where().eq("name", "yufei").and().eq("pwd", "123456").and()
                .group().gt("age", 18).and().lt("age", 60).list(SqlQuery.class);
    }

    @Test
    void test3() {
        SqlQuery query = new SqlQuery(jdbc);
        query.find(new SimpleRepository("user", "u")).where().eq("name", "yufei").and().eq("pwd", "123456").and()
                .group().gt("age", 18).and().lt("age", 60).list(SqlQuery.class);
    }

    @Test
    void test4() {
        SqlQuery query = new SqlQuery(jdbc);
        query.find(new SimpleRepository("user", "u")).property("name", "pwd", "age").where().eq("name", "yufei").and()
                .eq("pwd", "123456").and().group().gt("age", 18).and().lt("age", 60).list(SqlQuery.class);
    }
}
