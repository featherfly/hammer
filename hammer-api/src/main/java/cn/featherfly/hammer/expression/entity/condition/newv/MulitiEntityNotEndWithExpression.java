//
//package cn.featherfly.hammer.expression.entity.condition.newv;
//
//import java.util.function.Predicate;
//
//import cn.featherfly.common.function.serializable.SerializableFunction;
//import cn.featherfly.common.function.serializable.SerializableSupplier;
//import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
//import cn.featherfly.hammer.expression.condition.ConditionExpression;
//import cn.featherfly.hammer.expression.condition.LogicExpression;
//import cn.featherfly.hammer.expression.entity.condition.MulitiEntityConditionExpression;
//
///**
// * The Interface MulitiEntityNotEndWithExpression.
// *
// * @author zhongj
// * @param <C> the generic type
// * @param <L> the generic type
// */
//public interface MulitiNotEndWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
//        extends MulitiEntityConditionExpression {
//
//    /**
//     * end with value. 以value结尾.
//     *
//     * @param <E>   the element type
//     * @param index the index
//     * @param name the name
//     * @param value the value
//     * @return LogicExpression
//     */
//    default <E> L newv(int index, SerializableFunction<E, String> name, String value) {
//        return newv(index, name, value, MatchStrategy.AUTO);
//    }
//
//    /**
//     * end with value. 以value结尾.
//     *
//     * @param <E>            the element type
//     * @param index          the index
//     * @param name the name
//     * @param value the value
//     * @param ignoreStrategy the ignore strategy
//     * @return LogicExpression
//     */
//    default <E> L newv(int index, SerializableFunction<E, String> name, String value,
//            Predicate<String> ignoreStrategy) {
//        return newv(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
//    }
//
//    /**
//     * end with value. 以value结尾.
//     *
//     * @param <E>         the element type
//     * @param index       the index
//     * @param name        the name
//     * @param value       the value
//     * @param queryPolicy the query policy
//     * @return LogicExpression
//     */
//    <E> L newv(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy);
//
//    /**
//     * end with value. 以value结尾.
//     *
//     * @param <E>            the element type
//     * @param index          the index
//     * @param name           the name
//     * @param value          the value
//     * @param queryPolicy    the query policy
//     * @param ignoreStrategy the ignore strategy
//     * @return LogicExpression
//     */
//    <E> L newv(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
//            Predicate<String> ignoreStrategy);
//
//    /**
//     * end with value. 以value结尾.
//     *
//     * @param index    the index
//     * @param property  bean property
//     * @return LogicExpression
//     */
//    default L newv(int index, SerializableSupplier<String> property) {
//        return newv(index, property, MatchStrategy.AUTO);
//    }
//
//    /**
//     * end with value. 以value结尾.
//     *
//     * @param index          the index
//     * @param property       bean property
//     * @param ignoreStrategy the ignore strategy
//     * @return LogicExpression
//     */
//    default L newv(int index, SerializableSupplier<String> property, Predicate<String> ignoreStrategy) {
//        return newv(index, property, MatchStrategy.AUTO, ignoreStrategy);
//    }
//
//    /**
//     * end with value. 以value结尾.
//     *
//     * @param index       the index
//     * @param property    the property
//     * @param queryPolicy the query policy
//     * @return LogicExpression
//     */
//    L newv(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy);
//
//    /**
//     * end with value. 以value结尾.
//     *
//     * @param index          the index
//     * @param property       the property
//     * @param queryPolicy    the query policy
//     * @param ignoreStrategy the ignore strategy
//     * @return LogicExpression
//     */
//    L newv(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
//            Predicate<String> ignoreStrategy);
//
//}