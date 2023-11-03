//
///*
// * All rights Reserved, Designed By zhongj
// * @Description:
// * @author: zhongj
// * @date: 2023-11-14 15:01:14
// * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
// */
//package cn.featherfly.hammer.expression.repository.condition;
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
//import cn.featherfly.common.bean.function.BeanPropertyGetterDate;
//import cn.featherfly.common.bean.function.BeanPropertyGetterDouble;
//import cn.featherfly.common.bean.function.BeanPropertyGetterInt;
//import cn.featherfly.common.bean.function.BeanPropertyGetterLocalDate;
//import cn.featherfly.common.bean.function.BeanPropertyGetterLocalDateTime;
//import cn.featherfly.common.bean.function.BeanPropertyGetterLocalTime;
//import cn.featherfly.common.bean.function.BeanPropertyGetterLong;
//import cn.featherfly.common.bean.function.BeanPropertyGetterNumber;
//import cn.featherfly.common.bean.function.BeanPropertyGetterString;
//import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
//import cn.featherfly.hammer.expression.condition.IgnorableExpression;
//
///**
// * compare property expression.
// *
// * @author zhongj
// */
//public interface CompareRepositoryGetterExpression extends IgnorableExpression {
//
//    /**
//     * compare. 比较
//     *
//     * @param <T>      the generic type
//     * @param property bean property
//     * @param value    the value
//     */
//    default <T> void accept(BeanPropertyGetterInt<T> property, int value) {
//        accept(property, value, (IntPredicate) getIgnoreStrategy()::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param <T>            the generic type
//     * @param property       bean property
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    <T> void accept(BeanPropertyGetterInt<T> property, int value, IntPredicate ignoreStrategy);
//
//    /**
//     * compare. 比较
//     *
//     * @param <T>      the generic type
//     * @param property bean property
//     * @param value    the value
//     */
//    default <T> void accept(BeanPropertyGetterLong<T> property, long value) {
//        accept(property, value, (LongPredicate) getIgnoreStrategy()::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param <T>            the generic type
//     * @param property       bean property
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    <T> void accept(BeanPropertyGetterLong<T> property, long value, LongPredicate ignoreStrategy);
//
//    /**
//     * compare. 比较
//     *
//     * @param <T>      the generic type
//     * @param property bean property
//     * @param value    the value
//     */
//    default <T> void accept(BeanPropertyGetterDouble<T> property, double value) {
//        accept(property, value, (DoublePredicate) getIgnoreStrategy()::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param <T>            the generic type
//     * @param property       bean property
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    <T> void accept(BeanPropertyGetterDouble<T> property, double value, DoublePredicate ignoreStrategy);
//
//    /**
//     * compare. 比较
//     *
//     * @param <T>      the generic type
//     * @param <D>      the generic type
//     * @param property bean property
//     * @param value    the value
//     */
//    default <T, D extends Date> void accept(BeanPropertyGetterDate<T, D> property, D value) {
//        accept(property, value, getIgnoreStrategy()::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param <T>            the generic type
//     * @param <D>            the generic type
//     * @param property       bean property
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    <T, D extends Date> void accept(BeanPropertyGetterDate<T, D> property, D value, Predicate<D> ignoreStrategy);
//
//    /**
//     * compare. 比较
//     *
//     * @param <T>      the generic type
//     * @param <N>      the number type
//     * @param property bean property
//     * @param value    the value
//     */
//    default <T, N extends Number> void accept(BeanPropertyGetterNumber<T, N> property, N value) {
//        accept(property, value, getIgnoreStrategy()::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param <T>            the generic type
//     * @param <N>            the number type
//     * @param property       bean property
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    <T, N extends Number> void accept(BeanPropertyGetterNumber<T, N> property, N value, Predicate<N> ignoreStrategy);
//
//    /**
//     * compare. 比较
//     *
//     * @param <T>      the generic type
//     * @param property bean property
//     * @param value    the value
//     */
//    default <T> void accept(BeanPropertyGetterLocalDate<T> property, LocalDate value) {
//        accept(property, value, getIgnoreStrategy()::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param <T>            the generic type
//     * @param property       bean property
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    <T> void accept(BeanPropertyGetterLocalDate<T> property, LocalDate value, Predicate<LocalDate> ignoreStrategy);
//
//    /**
//     * compare. 比较
//     *
//     * @param <T>      the generic type
//     * @param property bean property
//     * @param value    the value
//     */
//    default <T> void accept(BeanPropertyGetterLocalTime<T> property, LocalTime value) {
//        accept(property, value, getIgnoreStrategy()::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param <T>            the generic type
//     * @param property       bean property
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    <T> void accept(BeanPropertyGetterLocalTime<T> property, LocalTime value, Predicate<LocalTime> ignoreStrategy);
//
//    /**
//     * compare. 比较
//     *
//     * @param <T>      the generic type
//     * @param property bean property
//     * @param value    the value
//     */
//    default <T> void accept(BeanPropertyGetterLocalDateTime<T> property, LocalDateTime value) {
//        accept(property, value, getIgnoreStrategy()::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param <T>            the generic type
//     * @param property       bean property
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    <T> void accept(BeanPropertyGetterLocalDateTime<T> property, LocalDateTime value,
//            Predicate<LocalDateTime> ignoreStrategy);
//
//    /**
//     * compare. 比较
//     *
//     * @param <T>      the generic type
//     * @param property bean property
//     * @param value    the value
//     */
//    default <T> void accept(BeanPropertyGetterString<T> property, String value) {
//        accept(property, value, getIgnoreStrategy()::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param <T>            the generic type
//     * @param property       bean property
//     * @param value          the value
//     * @param ignoreStrategy the ignore strategy
//     */
//    default <T> void accept(BeanPropertyGetterString<T> property, String value, Predicate<String> ignoreStrategy) {
//        accept(property, value, MatchStrategy.AUTO, ignoreStrategy);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param <T>           the generic type
//     * @param property      bean property
//     * @param value         the value
//     * @param matchStrategy the match strategy
//     */
//    default <T> void accept(BeanPropertyGetterString<T> property, String value, MatchStrategy matchStrategy) {
//        accept(property, value, matchStrategy, getIgnoreStrategy()::test);
//    }
//
//    /**
//     * compare. 比较
//     *
//     * @param <T>            the generic type
//     * @param property       bean property
//     * @param value          the value
//     * @param matchStrategy  the match strategy
//     * @param ignoreStrategy the ignore strategy
//     */
//    <T> void accept(BeanPropertyGetterString<T> property, String value, MatchStrategy matchStrategy,
//            Predicate<String> ignoreStrategy);
//
//}
