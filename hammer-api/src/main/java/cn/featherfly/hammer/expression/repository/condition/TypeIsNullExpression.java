//
//package cn.featherfly.hammer.expression.repository.condition;
//
//import cn.featherfly.common.function.serializable.SerializableFunction;
//import cn.featherfly.hammer.expression.condition.ConditionExpression;
//import cn.featherfly.hammer.expression.condition.LogicExpression;
//import cn.featherfly.hammer.expression.repository.condition.isn.RepositoryIsNullExpression;
//
///**
// * TypeIsNullExpression. .
// *
// * @author zhongj
// * @param <C> the generic type
// * @param <L> the generic type
// */
//public interface TypeIsNullExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
//        extends RepositoryIsNullExpression<C, L> {
//
//    /**
//     * is null.
//     *
//     * @param <O>        the generic type
//     * @param <T>        the generic type
//     * @param <R>        the generic type
//     * @param repository the repository
//     * @param property   the property
//     * @return LogicExpression
//     */
//    <O, T, R> L isn(SerializableFunction<O, T> repository, SerializableFunction<T, R> property);
//
//    /**
//     * is null.
//     *
//     * @param <O>        the generic type
//     * @param <T>        the generic type
//     * @param <R>        the generic type
//     * @param repository the repository
//     * @param property   the property
//     * @param value      if true, is null; if false, is not null; if null,
//     *                   ignore this operate
//     * @return LogicExpression
//     */
//    <O, T, R> L isn(SerializableFunction<O, T> repository, SerializableFunction<T, R> property, Boolean value);
//}