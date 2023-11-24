//
//package cn.featherfly.hammer.expression.entity.condition.lk;
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
// * The Interface MulitiEntityStartWithExpression.
// *
// * @author zhongj
// * @param <C> the generic type
// * @param <L> the generic type
// */
//public interface MulitiLikeExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
//        extends MulitiEntityConditionExpression {
//
//    //    /**
//    //     * like value.
//    //     *
//    //     * @param consumer the consumer
//    //     * @return LogicExpression
//    //     */
//    //    L lk(Consumer<EntityStartWithExpression<E, C, L>> consumer);
//
//    /**
//     * like value.
//     *
//     * @param <E>   the element type
//     * @param index the index
//     * @param name the name
//     * @param value the value
//     * @return LogicExpression
//     */
//    default <E> L lk(int index, SerializableFunction<E, String> name, String value) {
//        return lk(index, name, value, MatchStrategy.AUTO);
//    }
//
//    /**
//     * like value.
//     *
//     * @param <E>            the element type
//     * @param index          the index
//     * @param name the name
//     * @param value the value
//     * @param ignoreStrategy the ignore strategy
//     * @return LogicExpression
//     */
//    default <E> L lk(int index, SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
//        return lk(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
//    }
//
//    /**
//     * like value.
//     *
//     * @param <E>         the element type
//     * @param index       the index
//     * @param name        the name
//     * @param value       the value
//     * @param queryPolicy the query policy
//     * @return LogicExpression
//     */
//    <E> L lk(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy);
//
//    /**
//     * like value.
//     *
//     * @param <E>            the element type
//     * @param index          the index
//     * @param name           the name
//     * @param value          the value
//     * @param queryPolicy    the query policy
//     * @param ignoreStrategy the ignore strategy
//     * @return LogicExpression
//     */
//    <E> L lk(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
//            Predicate<String> ignoreStrategy);
//
//    /**
//     * like value.
//     *
//     * @param index    the index
//     * @param property  bean property
//     * @return LogicExpression
//     */
//    default L lk(int index, SerializableSupplier<String> property) {
//        return lk(index, property, MatchStrategy.AUTO);
//    }
//
//    /**
//     * like value.
//     *
//     * @param index          the index
//     * @param property       bean property
//     * @param ignoreStrategy the ignore strategy
//     * @return LogicExpression
//     */
//    default L lk(int index, SerializableSupplier<String> property, Predicate<String> ignoreStrategy) {
//        return lk(index, property, MatchStrategy.AUTO, ignoreStrategy);
//    }
//
//    /**
//     * like value.
//     *
//     * @param index       the index
//     * @param property    the property
//     * @param queryPolicy the query policy
//     * @return LogicExpression
//     */
//    L lk(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy);
//
//    /**
//     * like value.
//     *
//     * @param index          the index
//     * @param property       the property
//     * @param queryPolicy    the query policy
//     * @param ignoreStrategy the ignore strategy
//     * @return LogicExpression
//     */
//    L lk(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
//            Predicate<String> ignoreStrategy);
//
//    //  嵌套属性使用property(U1::getU2).property(U2:getV).lk(v)来设置
//    //    /**
//    //     * 以value开始.
//    //     *
//    //     * @param <R>        the generic type
//    //     * @param repository the repository
//    //     * @param property   the property
//    //     * @param value the value
//    //     * @return LogicExpression
//    //     */
//    //    <R> L lk(int index, SerializableFunction<E, R> repository, SerializableFunction<R, String> property, String value);
//    //
//    //    /**
//    //     * 以value开始.
//    //     *
//    //     * @param <R>        the generic type
//    //     * @param repository the repository
//    //     * @param property  bean property
//    //     * @return LogicExpression
//    //     */
//    //    <R> L lk(int index, SerializableSupplier<R> repository, SerializableFunction<R, String> property);
//}