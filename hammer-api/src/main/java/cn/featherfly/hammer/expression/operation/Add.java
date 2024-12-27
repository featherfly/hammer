
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-17 16:41:17
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.operation;

/**
 * Plus.
 *
 * @author zhongj
 * @param <N> the number type
 * @param <R> the add return type
 */
public interface Add<N extends Number, R> {

    /**
     * Adds the.
     *
     * @param value the value
     * @return added object
     */
    R add(N value);
}
