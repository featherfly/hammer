
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Sort.java
 * @Package cn.featherfly.hammer.expression.api
 * @Description: Sort
 * @author: zhongj
 * @date: 2023-05-31 15:37:31
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.query;

/**
 * Sortable.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface Sortable<S> {

    /**
     * Sort.
     *
     * @return sort expression
     */
    S sort();

    /**
     * sort alias. More user-friendly for users familiar with sql,
     *
     * @return sort expression
     */
    default S orderBy() {
        return sort();
    }
}
