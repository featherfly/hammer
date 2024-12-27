
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-12-27 18:27:27
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.function.date;

/**
 * date format.
 *
 * @author zhongj
 * @param <R> the formated type
 */
public interface Format<R> {

    /**
     * get day.
     *
     * @param format the format
     * @return formated string object
     */
    R format(String format);
}
