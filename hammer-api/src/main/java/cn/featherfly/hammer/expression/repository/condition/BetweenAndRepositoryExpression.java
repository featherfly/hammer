
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConpareEntityExpression.java
 * @Package cn.featherfly.hammer.expression.entity.condition
 * @Description: ConpareEntityExpression
 * @author: zhongj
 * @date: 2023-07-19 18:01:19
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.condition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.BiPredicate;

import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.BetweenAndExpression;

/**
 * The Interface BetweenAndRepositoryExpression.
 *
 * @author zhongj
 */
public interface BetweenAndRepositoryExpression extends BetweenAndExpression {

    /**
     * between and.
     *
     * @param field the field
     * @param min the min
     * @param max the max
     */
    default void accept(Field field, int min, int max) {
        accept(field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(Field field, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        accept(field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param field the field
     * @param min the min
     * @param max the max
     */
    default void accept(Field field, long min, long max) {
        accept(field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(Field field, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        accept(field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param field the field
     * @param min the min
     * @param max the max
     */
    default void accept(Field field, double min, double max) {
        accept(field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(Field field, double min, double max, BiPredicate<Double, Double> ignoreStrategy) {
        accept(field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <N> number type
     * @param field the field
     * @param min the min
     * @param max the max
     */
    default <N extends Number> void accept(Field field, N min, N max) {
        accept(field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param <N> number type
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     */
    default <N extends Number> void accept(Field field, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        accept(field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <D> date type
     * @param field the field
     * @param min the min
     * @param max the max
     */
    default <D extends Date> void accept(Field field, D min, D max) {
        accept(field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param <D> date type
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     */
    default <D extends Date> void accept(Field field, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        accept(field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <E> the element type
     * @param field the field
     * @param min the min
     * @param max the max
     */
    default <E extends Enum<E>> void accept(Field field, E min, E max) {
        accept(field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param <E> the element type
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     */
    default <E extends Enum<E>> void accept(Field field, E min, E max, BiPredicate<E, E> ignoreStrategy) {
        accept(field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param field the field
     * @param min the min
     * @param max the max
     */
    default void accept(Field field, LocalTime min, LocalTime max) {
        accept(field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(Field field, LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        accept(field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param field the field
     * @param min the min
     * @param max the max
     */
    default void accept(Field field, LocalDate min, LocalDate max) {
        accept(field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(Field field, LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        accept(field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param field the field
     * @param min the min
     * @param max the max
     */
    default void accept(Field field, LocalDateTime min, LocalDateTime max) {
        accept(field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(Field field, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        accept(field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param field the field
     * @param min the min
     * @param max the max
     */
    default void accept(Field field, String min, String max) {
        accept(field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(Field field, String min, String max, BiPredicate<String, String> ignoreStrategy) {
        accept(field.name(), min, max, ignoreStrategy);
    }
}
