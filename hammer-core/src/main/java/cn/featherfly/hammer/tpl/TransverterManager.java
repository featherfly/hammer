//
///*
// * All rights Reserved, Designed By zhongj
// * @Title: TransverterManager.java
// * @Package cn.featherfly.hammer.sqldb.tpl
// * @Description: todo (用一句话描述该文件做什么)
// * @author: zhongj
// * @date: 2021-08-17 15:06:17
// * @Copyright: 2021 www.featherfly.cn Inc. All rights reserved.
// */
//package cn.featherfly.hammer.tpl;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
//import cn.featherfly.hammer.HammerException;
//
///**
// * TransverterManager.
// *
// * @author zhongj
// */
//public class TransverterManager {
//
//    private Map<String, Transverter> transverterMap = new HashMap<>();
//
//    /**
//     * Register.
//     *
//     * @param name        the name
//     * @param transverter the transverter
//     * @return the transverter manager
//     */
//    public TransverterManager register(String name, Transverter transverter) {
//        Transverter t = transverterMap.get(name);
//        if (t != null) {
//            throw new HammerException(name + " already register for " + t.getClass().getName());
//        }
//        transverterMap.put(name, transverter);
//        return this;
//    }
//
//    /**
//     * Gets the.
//     *
//     * @param name the name
//     * @return the transverter
//     */
//    public Transverter get(String name) {
//        return transverterMap.get(name);
//    }
//
//    /**
//     * Gets the all.
//     *
//     * @return the all
//     */
//    public Collection<Transverter> getAll() {
//        return new ArrayList<>(transverterMap.values());
//    }
//}
