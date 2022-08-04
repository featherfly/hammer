/*
 * All rights Reserved, Designed By zhongj
 * @Title: Transverter.java
 * @Package cn.featherfly.hammer.sqldb.tpl
 * @Description: Transverter
 * @author: zhongj
 * @date: 2021-08-17 14:53:17
 * @Copyright: 2021 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.tpl;

/**
 * transvert param value before use.
 *
 * @author zhongj
 */
public interface Transverter {

    /**
     * Transvert.
     *
     * @param operator the operator
     * @param value    the value
     * @return the object
     */
    Object transvert(String operator, Object value);
}
