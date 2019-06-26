
package cn.featherfly.juorm.dml.builder.sql;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import cn.featherfly.juorm.sql.dml.builder.basic.SqlOrderByBasicBuilder;
import cn.featherfly.juorm.sql.dml.builder.basic.SqlSelectBasicBuilder;

/**
 * <p>
 * BasicBuilderTest
 * </p>
 * 
 * @author zhongj
 */
public class BasicBuilderTest {

    @Test
    void testSqlSelectBasicBuilder() {
        SqlSelectBasicBuilder builder = new SqlSelectBasicBuilder("user", "u", "username");
        builder.addSelectColumns("mobile", "age", "sex");
        System.out.println(builder.build());
        assertEquals("select u.mobile,u.age,u.sex from user u", builder.build());
        
        builder = new SqlSelectBasicBuilder("user", "u");
        System.out.println(builder.build());
        assertEquals("select u.* from user u", builder.build());
        
        builder = new SqlSelectBasicBuilder("user");
        System.out.println(builder.build());
        assertEquals("select * from user", builder.build());
    }
    
    @Test
    void testSqlOrderByBasicBuilder() {
        SqlOrderByBasicBuilder builder = new SqlOrderByBasicBuilder();
        builder.addAsc("name", "age").addDesc("sex");
        System.out.println(builder.build());
        assertEquals(" ORDER BY name, age ASC, sex DESC", builder.build());
        
        builder = new SqlOrderByBasicBuilder();
        builder.addAsc("name").addDesc("sex","mobile").addAsc("age", "no");
        System.out.println(builder.build());
        assertEquals(" ORDER BY name ASC, sex, mobile DESC, age, no ASC", builder.build());
        
    }
}
