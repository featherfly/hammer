//
///*
// * All rights Reserved, Designed By zhongj
// * @Description:
// * @author: zhongj
// * @date: 2024-03-22 16:41:22
// * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
// */
//package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.relation;
//
//import cn.featherfly.common.lang.Lang;
//import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryOnExpression;
//import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
//import cn.featherfly.hammer.sqldb.SqldbHammerException;
// TODO 后续删除
///**
// * MulitiRelate.
// *
// * @author zhongj
// */
//public interface InternalMulitiRelate<Q extends RepositoryQueryRelateExpression<F>, F> {
//    default RepositoryQueryOnExpression<Q, F> join(String[] names) {
//        int index = 0;
//        for (String name : names) {
//            if (Lang.isNotEmpty(name)) {
//                return join(index, name);
//            }
//        }
//        // ENHANCE 后续优化错误消息
//        throw new SqldbHammerException("join repository not set");
//    }
//
//    RepositoryQueryOnExpression<Q, F> join(int index, String repository);
//}
