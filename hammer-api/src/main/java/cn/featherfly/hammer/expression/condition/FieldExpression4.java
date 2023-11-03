//
//package cn.featherfly.hammer.expression.condition;
//
//import com.speedment.common.tuple.Tuple4;
//
//import cn.featherfly.common.function.FourArgusFunction;
//import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
//
///**
// * field expression4.
// *
// * @author zhongj
// * @param <C> the generic type
// * @param <L> the generic type
// */
//public interface FieldExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
//        extends FieldExpression<C, L>, MulitiRepositoryFieldExpression<Tuple4<Integer, Integer, Integer, Integer>, C, L> {
//
//    /**
//     * field.
//     *
//     * @param repositoiesFieldFunction the repositoies field function
//     * @return the LogicExpression
//     */
//    L field(FourArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
//            RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
//            LogicExpression<?, ?>> repositoiesFieldFunction);
//}
