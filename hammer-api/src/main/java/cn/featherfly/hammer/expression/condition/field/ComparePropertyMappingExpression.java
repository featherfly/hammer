//
///*
// * All rights Reserved, Designed By zhongj
// * @Title: ConpareEntityExpression.java
// * @Package cn.featherfly.hammer.expression.entity.condition
// * @Description: ConpareEntityExpression
// * @author: zhongj
// * @date: 2023-07-19 18:01:19
// * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
// */
//package cn.featherfly.hammer.expression.condition;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.Date;
//import java.util.function.DoublePredicate;
//import java.util.function.IntPredicate;
//import java.util.function.LongPredicate;
//import java.util.function.Predicate;
//
//import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
//import cn.featherfly.common.repository.IgnoreStrategy;
//import cn.featherfly.common.repository.mapping.PropertyMapping;
//import cn.featherfly.hammer.expression.repository.condition.CompareRepositoryGetterExpression;
//
///**
// * compare expression.
// *
// * @author zhongj
// */
//public interface ComparePropertyMappingExpression extends CompareRepositoryGetterExpression {
//
//    /**
//     * compare. 比较
//     *
//     * @param name  the name
//     * @param value the value
//     */
//    default void accept(PropertyMapping<?> name, int value) {
//        accept(name, value, (IntPredicate) getIgnoreStrategy()::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param name           the name
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    void accept(PropertyMapping<?> name, int value, IntPredicate ignoreStrategy);
//
//    /**
//     * compare. 比较
//     *
//     * @param name           the name
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    default void accept(PropertyMapping<?> name, int value, IgnoreStrategy ignoreStrategy) {
//        accept(name, value, (IntPredicate) ignoreStrategy::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param name  the name
//     * @param value the value
//     */
//    default void accept(PropertyMapping<?> name, long value) {
//        accept(name, value, (LongPredicate) getIgnoreStrategy()::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param name           the name
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    void accept(PropertyMapping<?> name, long value, LongPredicate ignoreStrategy);
//
//    /**
//     * compare. 比较
//     *
//     * @param name           the name
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    default void accept(PropertyMapping<?> name, long value, IgnoreStrategy ignoreStrategy) {
//        accept(name, value, (LongPredicate) ignoreStrategy::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param name  the name
//     * @param value the value
//     */
//    default void accept(PropertyMapping<?> name, double value) {
//        accept(name, value, (DoublePredicate) getIgnoreStrategy()::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param name           the name
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    void accept(PropertyMapping<?> name, double value, DoublePredicate ignoreStrategy);
//
//    /**
//     * compare. 比较
//     *
//     * @param name           the name
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    default void accept(PropertyMapping<?> name, double value, IgnoreStrategy ignoreStrategy) {
//        accept(name, value, (DoublePredicate) ignoreStrategy::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param <N>   number type
//     * @param name  the name
//     * @param value the value
//     */
//    default <N extends Number> void accept(PropertyMapping<?> name, N value) {
//        accept(name, value, getIgnoreStrategy()::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param <N>            number type
//     * @param name           the name
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    <N extends Number> void accept(PropertyMapping<?> name, N value, Predicate<N> ignoreStrategy);
//
//    /**
//     * compare. 比较
//     *
//     * @param <N>            number type
//     * @param name           the name
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    default <N extends Number> void accept(PropertyMapping<?> name, N value, IgnoreStrategy ignoreStrategy) {
//        accept(name, value, ignoreStrategy::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param <D>   date type
//     * @param name  the name
//     * @param value the value
//     */
//    default <D extends Date> void accept(PropertyMapping<?> name, D value) {
//        accept(name, value, getIgnoreStrategy()::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param <D>            date type
//     * @param name           the name
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    <D extends Date> void accept(PropertyMapping<?> name, D value, Predicate<D> ignoreStrategy);
//
//    /**
//     * compare. 比较
//     *
//     * @param <D>            date type
//     * @param name           the name
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    default <D extends Date> void accept(PropertyMapping<?> name, D value, IgnoreStrategy ignoreStrategy) {
//        accept(name, value, ignoreStrategy::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param <D>   date type
//     * @param name  the name
//     * @param value the value
//     */
//    default <E extends Enum<E>> void accept(PropertyMapping<?> name, E value) {
//        accept(name, value, getIgnoreStrategy()::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param <D>            date type
//     * @param name           the name
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    <E extends Enum<E>> void accept(PropertyMapping<?> name, E value, Predicate<E> ignoreStrategy);
//
//    /**
//     * compare. 比较
//     *
//     * @param <D>            date type
//     * @param name           the name
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    default <E extends Enum<E>> void accept(PropertyMapping<?> name, E value, IgnoreStrategy ignoreStrategy) {
//        accept(name, value, ignoreStrategy::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param name  the name
//     * @param value the value
//     */
//    default void accept(PropertyMapping<?> name, LocalTime value) {
//        accept(name, value, getIgnoreStrategy()::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param name           the name
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    void accept(PropertyMapping<?> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);
//
//    /**
//     * compare. 比较
//     *
//     * @param name           the name
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    default void accept(PropertyMapping<?> name, LocalTime value, IgnoreStrategy ignoreStrategy) {
//        accept(name, value, ignoreStrategy::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param name  the name
//     * @param value the value
//     */
//    default void accept(PropertyMapping<?> name, LocalDate value) {
//        accept(name, value, getIgnoreStrategy()::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param name           the name
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    void accept(PropertyMapping<?> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);
//
//    /**
//     * compare. 比较
//     *
//     * @param name           the name
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    default void accept(PropertyMapping<?> name, LocalDate value, IgnoreStrategy ignoreStrategy) {
//        accept(name, value, ignoreStrategy::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param name  the name
//     * @param value the value
//     */
//    default void accept(PropertyMapping<?> name, LocalDateTime value) {
//        accept(name, value, getIgnoreStrategy()::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param name           the name
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    void accept(PropertyMapping<?> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);
//
//    /**
//     * compare. 比较
//     *
//     * @param name           the name
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    default void accept(PropertyMapping<?> name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
//        accept(name, value, ignoreStrategy::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param name  the name
//     * @param value the value
//     */
//    default void accept(PropertyMapping<?> name, String value) {
//        accept(name, value, MatchStrategy.AUTO);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param name          the name
//     * @param value         the value
//     * @param matchStrategy the match strategy
//     */
//    default void accept(PropertyMapping<?> name, String value, MatchStrategy matchStrategy) {
//        accept(name, value, matchStrategy, getIgnoreStrategy()::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param name           the name
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    default void accept(PropertyMapping<?> name, String value, Predicate<String> ignoreStrategy) {
//        accept(name, value, MatchStrategy.AUTO, ignoreStrategy);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param name           the name
//     * @param value          the value
//     * @param matchStrategy  the match strategy
//     * @param ignoreStrategy the ignore strategy
//     */
//    void accept(PropertyMapping<?> name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
//
//    /**
//     * compare. 比较
//     *
//     * @param name           the name
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    default void accept(PropertyMapping<?> name, String value, IgnoreStrategy ignoreStrategy) {
//        accept(name, value, (Predicate<String>) ignoreStrategy::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param name           the name
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    default void accept(PropertyMapping<?> name, String value, MatchStrategy matchStrategy,
//            IgnoreStrategy ignoreStrategy) {
//        accept(name, value, matchStrategy, ignoreStrategy::test);
//    }
//}