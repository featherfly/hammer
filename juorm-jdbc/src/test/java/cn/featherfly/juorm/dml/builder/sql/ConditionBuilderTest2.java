package cn.featherfly.juorm.dml.builder.sql;
//
//package cn.featherfly.db.dsl.build;
//
//import static org.testng.Assert.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.testng.annotations.Test;
//
//import cn.featherfly.common.db.builder.SqlBuilder;
//import cn.featherfly.db.dsl.build.sql.SqlQueryBuilder;
//
///**
// * <p>
// * 类的说明放这里
// * </p>
// * <p>
// * copyright cdthgk 2010-2020, all rights reserved.
// * </p>
// *
// * @author 钟冀
// */
//public class ConditionBuilderTest2 {
//
//	QueryBuilder builder = null;
//	ConditionBuilder sub = null;
//
//	@Test
//	public void test() {
//		String sql = "u.name = ? AND u.pwd = ? AND ( u.sex = ? )";
//		List<Object> params = new ArrayList<Object>();
//
//		builder = new SqlQueryBuilder("u");
//						
//		String name = "yufei";
//		String pwd = "123";
//		String sex = "m";
//		builder.where()
//		    .eq("name", name)
//			.and()
//			.eq("pwd", pwd)
//			.and()
//			.group()
//				.eq("sex", sex);
//		params.add(name);
//		params.add(pwd);
//		params.add(sex);
//
//		System.out.println(builder.build());
//		System.out.println(builder.where().getParamValue());
//		assertEquals(builder.build().trim(), sql);
//		assertEquals(builder.where().getParamValue(), params);
//	}
//	@Test
//	public void test1() {
//		String sql = "u.pwd = ? AND ( u.sex = ? )";
//		List<Object> params = new ArrayList<Object>();
//
//		builder = new SqlQueryBuilder("u");
//		String name = null;
//		String pwd = "123";
//		String sex = "m";
//		builder.where().eq("name", name)
//		.and()
//		.eq("pwd", pwd)
//		.and()
//		.group()
//		.eq("sex", sex);
////		params.add(name);
//		params.add(pwd);
//		params.add(sex);
//
//		System.out.println(builder.build());
//		System.out.println(builder.where().getParamValue());
//		assertEquals(builder.build(), sql);
//		assertEquals(builder.where().getParamValue(), params);
//	}
//	@Test
//	public void test2() {
//		String sql = "";
//		List<Object> params = new ArrayList<Object>();
//
//		builder = new SqlQueryBuilder("acc");
//		builder.where().group();
//
//		System.out.println(builder.build());
//		System.out.println(builder.where().getParamValue());
//		assertEquals(builder.build().trim(), sql);
//		assertEquals(builder.where().getParamValue(), params);
//	}
//}
