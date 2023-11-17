//
//package cn.featherfly.hammer.expression.entity.condition.nsw;
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
// * The Interface MulitiEntityNotStartWithExpression.
// *
// * @author zhongj
// * @param <C> the generic type
// * @param <L> the generic type
// */
//public interface MulitiNotStartWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
//        extends MulitiEntityConditionExpression {
//
//    /**
//     * not start with value. 不以value开始.
//     *
//     * @param <E>   the element type
//     * @param index the index
//     * @param name the name
//     * @param value the value
//     * @return LogicExpression
//     */
//    default <E> L nsw(int index, SerializableFunction<E, String> name, String value) {
//        return nsw(index, name, value, MatchStrategy.AUTO);
//    }
//
//    /**
//     * not start with value. 不以value开始.
//     *
//     * @param <E>            the element type
//     * @param index          the index
//     * @param name           参数名称
//     * @param value          参数值
//     * @param ignoreStrategy the ignore strategy
//     * @return LogicExpression
//     */
//    default <E> L nsw(int index, SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
//        return nsw(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
//    }
//
//    /**
//     * not start with value. 不以value开始.
//     *
//     * @param <E>         the element type
//     * @param index       the index
//     * @param name        the name
//     * @param value       the value
//     * @param queryPolicy the query policy
//     * @return LogicExpression
//     */
//    <E> L nsw(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy);
//
//    /**
//     * not start with value. 不以value开始.
//     *
//     * @param <E>            the element type
//     * @param index          the index
//     * @param name           the name
//     * @param value          the value
//     * @param queryPolicy    the query policy
//     * @param ignoreStrategy the ignore strategy
//     * @return LogicExpression
//     */
//    <E> L nsw(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
//            Predicate<String> ignoreStrategy);
//
//    /**
//     * not start with value. 不以value开始.
//     *
//     * @param index    the index
//     * @param property  bean property
//     * @return LogicExpression
//     */
//    default L nsw(int index, SerializableSupplier<String> property) {
//        return nsw(index, property, MatchStrategy.AUTO);
//    }
//
//    /**
//     * not start with value. 不以value开始.
//     *
//     * @param index          the index
//     * @param property       bean property
//     * @param ignoreStrategy the ignore strategy
//     * @return LogicExpression
//     */
//    default L nsw(int index, SerializableSupplier<String> property, Predicate<String> ignoreStrategy) {
//        return nsw(index, property, MatchStrategy.AUTO, ignoreStrategy);
//    }
//
//    /**
//     * not start with value. 不以value开始.
//     *
//     * @param index       the index
//     * @param property    the property
//     * @param queryPolicy the query policy
//     * @return LogicExpression
//     */
//    L nsw(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy);
//
//    /**
//     * not start with value. 不以value开始.
//     *
//     * @param index          the index
//     * @param property       the property
//     * @param queryPolicy    the query policy
//     * @param ignoreStrategy the ignore strategy
//     * @return LogicExpression
//     */
//    L nsw(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
//            Predicate<String> ignoreStrategy);
//}