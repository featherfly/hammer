package cn.featherfly.hammer.sqldb.sql.dml.builder;
//
//package cn.featherfly.db.dsl.build;
//
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
//public class ConditionBuilderTest3 {
//    public static void main(String[] args) {
//        ConditionBuilder builder = null;
//        ConditionBuilder sub = null;
//
////        builder = new ConditionBuilder("u");
////        builder.eq("name", null)
////            .and()
////	        .eq("pwd", "yi");
////        System.out.println(builder.build());
////        System.out.println(builder.getParams());
//
//        builder = new ConditionBuilder("u");
//		String name = null;
//		String pwd = "123";
//		String sex = "m";
//		builder.eq("name", name)
//		.and()
//		.eq("pwd", pwd)
//		.and()
//		.group()
//		.eq("nation", "1")
//		.getParent()
//		.and()
//		.group()
//		.eq("sex", sex)
//		;
//
//		System.out.println(builder.build());
//		System.out.println(builder.getParams());
//
////        builder = new ConditionBuilder("u");
////        builder.eq("name", "yufei")
////            .and()
////            .eq("pwd", null)
////            .and()
////            .eq("pwd", "123")
////	        .and()
////	        .eq("pwd", null);
////        System.out.println(builder.build());
////        System.out.println(builder.getParams());
//
////        builder = new ConditionBuilder("u");
////        builder.eq("name", "yufei")
////            .and()
////            .eq("pwd", "123")
////            .and()
////            .group()
////                .eq("sex", "m");
////        System.out.println(builder.build());
////        System.out.println(builder.getParams());
//
////		builder = new ConditionBuilder("u2");
////		builder
////			.group()
////				.eq("sex", "m")
////				.getParent()
////			.and()
////			.eq("name", "yufei")
////			.and()
////			.eq("pwd", "123");
////		builder.desc("name", "sex").asc("pwd").desc("phone").desc("mobile");
////
////		System.out.println(builder.build());
////		System.out.println(builder.getParams());
////
////		builder = new ConditionBuilder("u3");
////		builder.group();
////
////		System.out.println(builder.build());
////		System.out.println(builder.getParams());
////
////		builder = new ConditionBuilder("acc");
////		builder.group();
////
////		System.out.println(builder.build());
////		System.out.println(builder.getParams());
////
////
////		builder = new ConditionBuilder("acc");
////		builder.eq("sex", "m");
////
////		System.out.println(builder.build());
////		System.out.println(builder.getParams());
////
////
////		builder = new ConditionBuilder("acc");
////		builder.group().eq("sex", "m").and().eq("sex", "m");
////
////		System.out.println(builder.build());
////		System.out.println(builder.getParams());
////
////		builder = new ConditionBuilder("u");
////		builder
////			.eq("name", "yufei")
////			.and()
////			.group()
////				.eq("sex", "m")
////				.or()
////				.group()
////					.co("school", "学校")
////				.getParent()
////			.getParent()
////			.or()
////			.eq("pwd", "123");
////
////		System.out.println(builder.build());
////		System.out.println(builder.getParams());
////
////		builder = new ConditionBuilder("acc");
////
////		builder
////			.group()
////				.eq("sex", "m")
////				.and()
////				.group()
////					.eq("sex2", "m")
////					.and()
////					.eq("ttt", "11")
////					.or()
////					.group()
////						.eq("name", "yufei")
////						.or()
////						.eq("name", "featherfly")
////					.getParent()
////				.getParent()
////			.getParent()
////			.or()
////			.eq("pwd", "123456")
////			.or()
////			.eq("qq", "3333");
////
////		System.out.println(builder.build());
////		System.out.println(builder.getParams());
////
////		builder = new ConditionBuilder("acc");
////
////		builder.eq("qq", "3333");
////
////		System.out.println(builder.build());
////		System.out.println(builder.getParams());
//    }
//}
