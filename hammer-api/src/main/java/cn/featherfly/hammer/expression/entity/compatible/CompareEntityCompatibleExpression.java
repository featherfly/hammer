
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConpareEntityExpression.java
 * @Package cn.featherfly.hammer.expression.entity.condition
 * @Description: ConpareEntityExpression
 * @author: zhongj
 * @date: 2023-07-19 18:01:19
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.entity.condition.CompareEntityExpression;

/**
 * compare entity expression.
 *
 * @author zhongj
 * @param <T> the element type
 */
public interface CompareEntityCompatibleExpression<T> extends CompareEntityExpression<T> {

    /**
     * compare. 比较
     *
     * @param name the name
     * @param value the value
     */
    void accept(String name, int value);

    /**
     * compare. 比较
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String name, int value, IntPredicate ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param name the name
     * @param value the value
     */
    void accept(String name, long value);

    /**
     * compare. 比较
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String name, long value, LongPredicate ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param name the name
     * @param value the value
     */
    void accept(String name, double value);

    /**
     * compare. 比较
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String name, double value, DoublePredicate ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param <N> number type
     * @param name the name
     * @param value the value
     */
    <N extends Number> void accept(String name, N value);

    /**
     * compare. 比较
     *
     * @param <N> number type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    <N extends Number> void accept(String name, N value, Predicate<N> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param <D> date type
     * @param name the name
     * @param value the value
     */
    <D extends Date> void accept(String name, D value);

    /**
     * compare. 比较
     *
     * @param <D> date type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    <D extends Date> void accept(String name, D value, Predicate<D> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param name the name
     * @param value the value
     */
    void accept(String name, LocalTime value);

    /**
     * compare. 比较
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param name the name
     * @param value the value
     */
    void accept(String name, LocalDate value);

    /**
     * compare. 比较
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param name the name
     * @param value the value
     */
    void accept(String name, LocalDateTime value);

    /**
     * compare. 比较
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param name the name
     * @param value the value
     */
    void accept(String name, String value);

    /**
     * compare. 比较
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String name, String value, Predicate<String> ignoreStrategy);

    /**
     * equals or not equals. 等于或者不等于.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     */
    void accept(String name, String value, MatchStrategy matchStrategy);

    /**
     * equals or not equals. 等于或者不等于.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}
