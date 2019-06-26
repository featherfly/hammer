
package cn.featherfly.juorm.dml.builder.sql;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import cn.featherfly.juorm.dml.builder.ConditionBuilder;
import cn.featherfly.juorm.dml.builder.QueryBuilder;
import cn.featherfly.juorm.dml.builder.SortBuilder;
import cn.featherfly.juorm.sql.dml.builder.SqlConditionGroup;
import cn.featherfly.juorm.sql.dml.builder.SqlFindBuilder;
import cn.featherfly.juorm.sql.dml.builder.SqlQueryBuilder;
import cn.featherfly.juorm.sql.dml.builder.SqlSortBuilder;

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
public class ConditionBuilderTest {

    cn.featherfly.juorm.dml.builder.QueryBuilder builder = null;
	QueryBuilder sub = null;

	@Test
	public void test() {
		List<Object> params = new ArrayList<Object>();

		String name = "yufei";
		String pwd = "123";
		String sex = "m";
		Integer age = 18;
		params.add(name);
		params.add(pwd);
		params.add(sex);
		params.add(age);
		
		builder = new SqlQueryBuilder();
		builder
		    .find("user", "u")
		    .where()
    		    .eq("name", name)
    			.and()
    			.eq("pwd", pwd)
    			.and()
    			.group()
    				.eq("sex", sex)
    				.or()
    				.gt("age", age)
			.sort().asc("age", "sex").desc("name");
		builder = new SqlQueryBuilder();
        builder
            .find("user", "u")
                .with("name", "pwd", "age", "sex")
            .where()
                .eq("name", name)
                .and()
                .eq("pwd", pwd)
                .and()
                .group()
                    .eq("sex", sex)
                    .or()
                    .gt("age", age)
            .sort().asc("age", "sex").desc("name");
        

		System.out.println(builder.build());
		System.out.println(((SqlQueryBuilder)builder).getParams());
		assertEquals("select u.name, u.pwd, u.age, u.sex from user u where u.name = ? AND u.pwd = ? AND ( u.sex = ? OR u.age > ? ) ORDER BY age, sex ASC, name DESC"
		        , builder.build());
		assertEquals(params
		        , ((SqlQueryBuilder)builder).getParams());
		
//		
		cn.featherfly.juorm.sql.dml.builder.QueryBuilder builder2 = new SqlQueryBuilder();
		builder2
		    .from("user", "u")
		    .where()
            .eq("name", name)
            .and()
            .eq("pwd", pwd)
            .and()
            .group()
                .eq("sex", sex)
                .or()
                .gt("age", 18)
            .sort().asc("age", "sex").desc("name");
		System.out.println(builder2.build());
		System.out.println(((SqlQueryBuilder)builder2).getParams());
        assertEquals("select u.* from user u where u.name = ? AND u.pwd = ? AND ( u.sex = ? OR u.age > ? ) ORDER BY age, sex ASC, name DESC"
                , builder2.build());
        assertEquals(params
                , ((SqlQueryBuilder)builder2).getParams());
		
		builder2 = new SqlQueryBuilder();
		builder2
		    .select("name", "pwd", "age", "sex")
    		.from("user", "u2")
            .where()
                .eq("name", name)
                .and()
                .eq("pwd", pwd)
                .and()
                .group()
                    .eq("sex", sex)
                    .or()
                    .gt("age", age)
                .sort().asc("age", "sex").desc("name");
            System.out.println(builder2.build());
            System.out.println(((SqlQueryBuilder)builder2).getParams());
            assertEquals("select u2.name, u2.pwd, u2.age, u2.sex from user u2 where name = ? AND pwd = ? AND ( sex = ? OR age > ? ) ORDER BY age, sex ASC, name DESC"
                    , builder2.build());
            assertEquals(params
                    , ((SqlQueryBuilder)builder2).getParams());
                        
            ConditionBuilder cb = new SqlConditionGroup(null);
            cb.eq("name", name)
                    .and()
                    .eq("pwd", pwd)
                    .and()
                    .group()
                        .eq("sex", sex)
                        .or()
                        .gt("age", age);
                System.out.println(cb.build());
                System.out.println(((SqlConditionGroup)cb).getParamValues());
                assertEquals("name = ? AND pwd = ? AND ( sex = ? OR age > ? )"
                        , cb.build());
                assertEquals(params
                        , ((SqlQueryBuilder)builder2).getParams());
//		
		SortBuilder sortBuilder = new SqlSortBuilder();
		sortBuilder.desc("dddesc").asc("zzz", "xxx");
		System.out.println(sortBuilder.build());
		
		SqlFindBuilder findBuilder = new SqlFindBuilder("user", null);		
		System.out.println(findBuilder.build());
	}
	
}
