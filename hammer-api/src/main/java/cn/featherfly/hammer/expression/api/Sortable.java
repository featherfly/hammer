
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Sort.java
 * @Package cn.featherfly.hammer.expression.api
 * @Description: Sort
 * @author: zhongj
 * @date: 2023-05-31 15:37:31
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.api;

/**
 * Sortable.
 *
 * @author zhongj
 */
public interface Sortable<S> {

    /**
     * Sort.
     *
     * @return the s
     */
    S sort();
}
