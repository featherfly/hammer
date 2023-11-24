//
//package cn.featherfly.hammer.expression.repository.condition;
//
//import cn.featherfly.hammer.expression.condition.ConditionExpression;
//import cn.featherfly.hammer.expression.condition.LogicExpression;
//
///**
// * <p>
// * RepositoryNotInExpression
// * </p>
// * .
// *
// * @author zhongj
// * @param <C> the generic type
// * @param <L> the generic type
// */
//public interface RepositoryNotInExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
//        extends NotInExpression<C, L> {
//
//    /**
//     * values not in. 不包含指定，sql中的not in.
//     *
//     * @param repository 存储库
//     * @param name the name
//     * @param value the value
//     * @return LogicExpression
//     */
//    L nin(String repository, String name, Object value);
//
//    /**
//     * values not in. 不包含指定，sql中的not in.
//     *
//     * @param <T>        the generic type
//     * @param repository 存储库
//     * @param name the name
//     * @param value the value
//     * @return LogicExpression
//     */
//    //    <T> L nin(Class<T> repository, String name, Object value);
//
//    /**
//     * values not in. 不包含指定，sql中的not in.
//     *
//     * @param repositoryIndex repository index
//     * @param name the name
//     * @param value the value
//     * @return LogicExpression
//     */
//    L nin(int repositoryIndex, String name, Object value);
//
//}