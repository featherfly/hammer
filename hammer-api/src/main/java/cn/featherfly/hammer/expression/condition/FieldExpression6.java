//
//package cn.featherfly.hammer.expression.condition;
//
//import com.speedment.common.tuple.Tuple6;
//
//import cn.featherfly.common.function.SixArgusFunction;
//import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
//
///**
// * field expression6.
// *
// * @author zhongj
// * @param <C> the generic type
// * @param <L> the generic type
// */
//public interface FieldExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
//        extends FieldExpression<C, L>,
//        MulitiRepositoryFieldExpression<Tuple6<Integer, Integer, Integer, Integer, Integer, Integer>, C, L> {
//
//    /**
//     * field.
//     *
//     * @param repositoiesFieldFunction the repositoies field function
//     * @return the LogicExpression
//     */
//    L field(SixArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
//            RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
//            RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoiesFieldFunction);
//}
