
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-12-27 18:35:27
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.function.date;

/**
 * DateFunctions.
 *
 * @author zhongj
 * @param <R> the generic type
 * @param <S> the generic type
 */
public interface DateFunctions<R, S>
    extends Functions<S> {

    /**
     * get year.
     *
     * @return year object
     */
    R getYear();

    /**
     * get month.
     *
     * @return month object
     */
    R getMonth();

    /**
     * get day of month.
     *
     * @return day of month object
     */
    R getDayOfMonth();

    /**
     * get day of month.
     *
     * @return day of month object
     */
    R getDayOfYear();

    /**
     * get week day.
     *
     * @return week day object
     */
    R getWeekDay();

    /**
     * get week.
     *
     * @return week object
     */
    R getWeekOfYear();

    /**
     * get week.
     *
     * @return week object
     */
    R getQuarter();
}
