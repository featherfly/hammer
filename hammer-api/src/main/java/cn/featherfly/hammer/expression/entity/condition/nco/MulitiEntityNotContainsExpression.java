//
//package cn.featherfly.hammer.expression.entity.condition.nco;
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
// * The Interface MulitiEntityNotContainsExpression.
// *
// * @author zhongj
// * @param <C> the generic type
// * @param <L> the generic type
// */
//public interface MulitiNotContainsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
//        extends MulitiEntityConditionExpression {
//
//    /**
//     * not contains value. 不包含value.
//     *
//     * @param <E>   the element type
//     * @param index the index
//     * @param name the name
//     * @param value the value
//     * @return LogicExpression
//     */
//    default <E> L nco(int index, SerializableFunction<E, String> name, String value) {
//        return nco(index, name, value, MatchStrategy.AUTO);
//    }
//
//    /**
//     * not contains value. 不包含value.
//     *
//     * @param <E>            the element type
//     * @param index          the index
//     * @param name the name
//     * @param value the value
//     * @param ignoreStrategy the ignore strategy
//     * @return LogicExpression
//     */
//    default <E> L nco(int index, SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
//        return nco(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
//    }
//
//    /**
//     * not contains value. 不包含value.
//     *
//     * @param <E>         the element type
//     * @param index       the index
//     * @param name        the name
//     * @param value       the value
//     * @param queryPolicy the query policy
//     * @return LogicExpression
//     */
//    <E> L nco(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy);
//
//    /**
//     * not contains value. 不包含value.
//     *
//     * @param <E>            the element type
//     * @param index          the index
//     * @param name           the name
//     * @param value          the value
//     * @param queryPolicy    the query policy
//     * @param ignoreStrategy the ignore strategy
//     * @return LogicExpression
//     */
//    <E> L nco(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
//            Predicate<String> ignoreStrategy);
//
//    /**
//     * not contains value. 不包含value.
//     *
//     * @param index    the index
//     * @param property  bean property
//     * @return LogicExpression
//     */
//    default L nco(int index, SerializableSupplier<String> property) {
//        return nco(index, property, MatchStrategy.AUTO);
//    }
//
//    /**
//     * not contains value. 不包含value.
//     *
//     * @param index          the index
//     * @param property       bean property
//     * @param ignoreStrategy the ignore strategy
//     * @return LogicExpression
//     */
//    default L nco(int index, SerializableSupplier<String> property, Predicate<String> ignoreStrategy) {
//        return nco(index, property, MatchStrategy.AUTO, ignoreStrategy);
//    }
//
//    /**
//     * not contains value. 不包含value.
//     *
//     * @param index       the index
//     * @param property    the property
//     * @param queryPolicy the query policy
//     * @return LogicExpression
//     */
//    L nco(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy);
//
//    /**
//     * not contains value. 不包含value.
//     *
//     * @param index          the index
//     * @param property       the property
//     * @param queryPolicy    the query policy
//     * @param ignoreStrategy the ignore strategy
//     * @return LogicExpression
//     */
//    L nco(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
//            Predicate<String> ignoreStrategy);
//
//}