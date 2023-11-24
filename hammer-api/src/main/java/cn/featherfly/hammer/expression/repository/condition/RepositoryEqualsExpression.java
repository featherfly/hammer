//
//package cn.featherfly.hammer.expression.repository.condition;
//
//import cn.featherfly.common.function.serializable.SerializableFunction;
//import cn.featherfly.common.function.serializable.SerializableSupplier;
//import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
//import cn.featherfly.hammer.expression.condition.ConditionExpression;
//import cn.featherfly.hammer.expression.condition.LogicExpression;
//
///**
// * The Interface RepositoryEqualsExpression.
// *
// * @author zhongj
// * @param <C> the generic type
// * @param <L> the generic type
// */
//public interface RepositoryEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
//        extends EqualsExpression<C, L> {
//
//    /**
//     * equals. 等于.
//     *
//     * @param repository 存储库
//     * @param name the name
//     * @param value the value
//     * @return LogicExpression
//     */
//    default L eq(String repository, String name, Object value) {
//        return eq(repository, name, value, MatchStrategy.AUTO);
//    }
//
//    /**
//     * equals. 等于.
//     *
//     * @param repository  存储库
//     * @param name the name
//     * @param value the value
//     * @param queryPolicy the query policy
//     * @return LogicExpression
//     */
//    L eq(String repository, String name, Object value, MatchStrategy matchStrategy);
//
//    /**
//     * equals. 等于.
//     *
//     * @param <T>        the generic type
//     * @param repository 存储库
//     * @param name the name
//     * @param value the value
//     * @return LogicExpression
//     */
//    //    default <T> L eq(Class<T> repository, String name, Object value) {
//    //        return eq(repository, name, value, MatchStrategy.AUTO);
//    //    }
//
//    /**
//     * equals. 等于.
//     *
//     * @param <T>         the generic type
//     * @param repository  存储库
//     * @param name the name
//     * @param value the value
//     * @param queryPolicy the query policy
//     * @return LogicExpression
//     */
//    //    <T> L eq(Class<T> repository, String name, Object value, MatchStrategy matchStrategy);
//
//    /**
//     * equals. 等于.
//     *
//     * @param repositoryIndex repository index
//     * @param name the name
//     * @param value the value
//     * @return LogicExpression
//     */
//    default L eq(int repositoryIndex, String name, Object value) {
//        return eq(repositoryIndex, name, value, MatchStrategy.AUTO);
//    }
//
//    /**
//     * equals. 等于.
//     *
//     * @param repositoryIndex repository index
//     * @param name the name
//     * @param value the value
//     * @param queryPolicy     the query policy
//     * @return LogicExpression
//     */
//    L eq(int repositoryIndex, String name, Object value, MatchStrategy matchStrategy);
//
//    /**
//     * equals. 等于.
//     *
//     * @param <T>        the generic type
//     * @param <R>        the generic type
//     * @param repository the repository
//     * @param property   the property
//     * @param value the value
//     * @return LogicExpression
//     */
//    default <T, R> L eq(SerializableFunction<T, R> repository, SerializableFunction<T, R> property, R value) {
//        return eq(repository, property, value, MatchStrategy.AUTO);
//    }
//
//    /**
//     * equals. 等于.
//     *
//     * @param <T>         the generic type
//     * @param <R>         the generic type
//     * @param repository  the repository
//     * @param property    the property
//     * @param value the value
//     * @param queryPolicy the query policy
//     * @return LogicExpression
//     */
//    <T, R> L eq(SerializableFunction<T, R> repository, SerializableFunction<T, R> property, R value,
//            MatchStrategy matchStrategy);
//
//    /**
//     * equals. 等于.
//     *
//     * @param <T>        the generic type
//     * @param <R>        the generic type
//     * @param repository the repository
//     * @param property  bean property
//     * @return LogicExpression
//     */
//    default <T, R> L eq(SerializableSupplier<T> repository, SerializableFunction<T, R> property) {
//        return eq(repository, property, MatchStrategy.AUTO);
//    }
//
//    /**
//     * equals. 等于.
//     *
//     * @param <T>         the generic type
//     * @param <R>         the generic type
//     * @param repository  the repository
//     * @param property  bean property
//     * @param queryPolicy the query policy
//     * @return LogicExpression
//     */
//    <T, R> L eq(SerializableSupplier<T> repository, SerializableFunction<T, R> property, MatchStrategy matchStrategy);
//
//}