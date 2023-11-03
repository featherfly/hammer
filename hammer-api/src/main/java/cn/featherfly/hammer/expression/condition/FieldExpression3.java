//
//package cn.featherfly.hammer.expression.condition;
//
//import com.speedment.common.tuple.Tuple3;
//
//import cn.featherfly.common.function.ThreeArgusFunction;
//import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
//
///**
// * field expression3.
// *
// * @author zhongj
// * @param <C> the generic type
// * @param <L> the generic type
// */
//public interface FieldExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
//        extends FieldExpression<C, L>, MulitiRepositoryFieldExpression<Tuple3<Integer, Integer, Integer>, C, L> {
//
//    /**
//     * field.
//     *
//     * @param repositoiesFieldFunction the repositoies field function
//     * @return the LogicExpression
//     */
//    L field(ThreeArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
//            RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoiesFieldFunction);
//}
