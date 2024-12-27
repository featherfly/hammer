
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-12-27 18:36:27
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.function.date;

/**
 * TimeFunctions.
 *
 * @author zhongj
 * @param <R> the generic type
 * @param <S> the generic type
 */
public interface TimeFunctions<R, S> extends Functions<S> {
    /**
     * get hour.
     *
     * @return hour object
     */
    R getHour();

    /**
     * get minute.
     *
     * @return minute object
     */
    R getMinute();

    /**
     * get second.
     *
     * @return second object
     */
    R getSecond();
}
