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
// * The Interface RepositoryNotEqualsExpression.
// *
// * @author zhongj
// * @param <C> the generic type
// * @param <L> the generic type
// */
//public interface RepositoryNotEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
//        extends NotEqualsExpression<C, L> {
//
//    /**
//     * not equals.不等于
//     *
//     * @param repository 存储库
//     * @param name the name
//     * @param value the value
//     * @return LogicExpression
//     */
//    default L ne(String repository, String name, Object value) {
//        return ne(repository, name, value, MatchStrategy.AUTO);
//    }
//
//    /**
//     * not equals.不等于
//     *
//     * @param repository  存储库
//     * @param name the name
//     * @param value the value
//     * @param queryPolicy the query policy
//     * @return LogicExpression
//     */
//    L ne(String repository, String name, Object value, MatchStrategy matchStrategy);
//
//    /**
//     * not equals.不等于
//     *
//     * @param <T>        the generic type
//     * @param repository 存储库
//     * @param name the name
//     * @param value the value
//     * @return LogicExpression
//     */
//    //    default <T> L ne(Class<T> repository, String name, Object value) {
//    //        return ne(repository, name, value, MatchStrategy.AUTO);
//    //    }
//
//    /**
//     * not equals.不等于
//     *
//     * @param <T>         the generic type
//     * @param repository  存储库
//     * @param name the name
//     * @param value the value
//     * @param queryPolicy the query policy
//     * @return LogicExpression
//     */
//    //    <T> L ne(Class<T> repository, String name, Object value, MatchStrategy matchStrategy);
//
//    /**
//     * not equals.不等于
//     *
//     * @param repositoryIndex repository index
//     * @param name the name
//     * @param value the value
//     * @return LogicExpression
//     */
//    default L ne(int repositoryIndex, String name, Object value) {
//        return ne(repositoryIndex, name, value, MatchStrategy.AUTO);
//    }
//
//    /**
//     * not equals.不等于
//     *
//     * @param repositoryIndex repository index
//     * @param name the name
//     * @param value the value
//     * @param queryPolicy     the query policy
//     * @return LogicExpression
//     */
//    L ne(int repositoryIndex, String name, Object value, MatchStrategy matchStrategy);
//
//    /**
//     * not equals.不等于.
//     *
//     * @param <T>        the generic type
//     * @param <R>        the generic type
//     * @param repository the repository
//     * @param property   the property
//     * @param value the value
//     * @return LogicExpression
//     */
//    default <T, R> L ne(SerializableFunction<T, R> repository, SerializableFunction<T, R> property, R value) {
//        return ne(repository, property, value, MatchStrategy.AUTO);
//    }
//
//    /**
//     * not equals.不等于.
//     *
//     * @param <T>         the generic type
//     * @param <R>         the generic type
//     * @param repository  the repository
//     * @param property    the property
//     * @param value the value
//     * @param queryPolicy the query policy
//     * @return LogicExpression
//     */
//    <T, R> L ne(SerializableFunction<T, R> repository, SerializableFunction<T, R> property, R value,
//            MatchStrategy matchStrategy);
//
//    /**
//     * not equals.不等于.
//     *
//     * @param <T>        the generic type
//     * @param <R>        the generic type
//     * @param repository the repository
//     * @param property  bean property
//     * @return LogicExpression
//     */
//    default <T, R> L ne(SerializableSupplier<T> repository, SerializableFunction<T, R> property) {
//        return ne(repository, property, MatchStrategy.AUTO);
//    }
//
//    /**
//     * not equals.不等于.
//     *
//     * @param <T>         the generic type
//     * @param <R>         the generic type
//     * @param repository  the repository
//     * @param property  bean property
//     * @param queryPolicy the query policy
//     * @return LogicExpression
//     */
//    <T, R> L ne(SerializableSupplier<T> repository, SerializableFunction<T, R> property, MatchStrategy matchStrategy);
//
//}