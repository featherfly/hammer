//
//package cn.featherfly.hammer.expression.repository.condition;
//
//import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
//import cn.featherfly.hammer.expression.condition.ConditionExpression;
//import cn.featherfly.hammer.expression.condition.LogicExpression;
//
///**
// * The Interface RepositoryStartWithExpression.
// *
// * @author zhongj
// * @param <C> the generic type
// * @param <L> the generic type
// */
//public interface RepositoryStartWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
//        extends StartWithExpression<C, L> {
//
//    /**
//     * start with value. 以value开始.
//     *
//     * @param repository repository
//     * @param name the name
//     * @param value the value
//     * @return LogicExpression
//     */
//    default L sw(String repository, String name, String value) {
//        return sw(repository, name, value, MatchStrategy.AUTO);
//    }
//
//    /**
//     * start with value. 以value开始.
//     *
//     * @param repository  repository
//     * @param name the name
//     * @param value the value
//     * @param queryPolicy the query policy
//     * @return LogicExpression
//     */
//    L sw(String repository, String name, String value, MatchStrategy matchStrategy);
//
//    /**
//     * start with value. 以value开始.
//     *
//     * @param <T>        the generic type
//     * @param repository repository
//     * @param name the name
//     * @param value the value
//     * @return LogicExpression
//     */
//    //    default <T> L sw(Class<T> repository, String name, String value) {
//    //        return sw(repository, name, value, MatchStrategy.AUTO);
//    //    }
//
//    /**
//     * start with value. 以value开始.
//     *
//     * @param <T>         the generic type
//     * @param repository  repository
//     * @param name the name
//     * @param value the value
//     * @param queryPolicy the query policy
//     * @return LogicExpression
//     */
//    //    <T> L sw(Class<T> repository, String name, String value, MatchStrategy matchStrategy);
//
//    /**
//     * start with value. 以value开始.
//     *
//     * @param repositoryIndex repository index
//     * @param name the name
//     * @param value the value
//     * @return LogicExpression
//     */
//    default L sw(int repositoryIndex, String name, String value) {
//        return sw(repositoryIndex, name, value, MatchStrategy.AUTO);
//    }
//
//    /**
//     * start with value. 以value开始.
//     *
//     * @param repositoryIndex repository index
//     * @param name the name
//     * @param value the value
//     * @param queryPolicy     the query policy
//     * @return LogicExpression
//     */
//    L sw(int repositoryIndex, String name, String value, MatchStrategy matchStrategy);
//
//}