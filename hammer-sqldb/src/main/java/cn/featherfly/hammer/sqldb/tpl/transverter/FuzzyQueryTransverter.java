//
///*
// * All rights Reserved, Designed By zhongj
// * @Title: FuzzyQueryTransverter.java
// * @Package cn.featherfly.hammer.sqldb.tpl
// * @Description: todo (用一句话描述该文件做什么)
// * @author: zhongj
// * @date: 2021-08-17 15:03:17
// * @Copyright: 2021 www.featherfly.cn Inc. All rights reserved.
// */
//package cn.featherfly.hammer.sqldb.tpl.transverter;
//
//import cn.featherfly.common.repository.operate.Operator;
//import cn.featherfly.common.repository.operate.QueryOperator;
//import cn.featherfly.hammer.tpl.Transverter;
//
///**
// * FuzzyQueryTransverter.
// *
// * @author zhongj
// */
//public class FuzzyQueryTransverter implements Transverter {
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Object transvert(Operator operator, Object value) {
//        if (operator instanceof QueryOperator) {
//            return transvert((QueryOperator) operator, value);
//        } else {
//            return value;
//        }
//    }
//
//    public Object transvert(QueryOperator operator, Object value) {
//        switch (operator) {
//            case CO:
//                return "%" + value + "%";
//            case SW:
//                return value + "%";
//            case EW:
//                return "%" + value;
//            default:
//                return value;
//        }
//    }
//
//}
