
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-17 16:42:17
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.operation;

/**
 * Divide.
 *
 * @author zhongj
 * @param <N> the number type
 * @param <R> the add return type
 */
public interface Divide<N extends Number, R> {

    /**
     * Divide.
     *
     * @param value the value
     * @return the r
     */
    R divide(N value);
}
