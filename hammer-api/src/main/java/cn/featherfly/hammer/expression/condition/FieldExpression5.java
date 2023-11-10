//
//package cn.featherfly.hammer.expression.condition;
//
//import com.speedment.common.tuple.Tuple5;
//
//import cn.featherfly.common.function.FiveArgusFunction;
//import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
//
///**
// * field expression5.
// *
// * @author zhongj
// * @param <C> the generic type
// * @param <L> the generic type
// */
//public interface FieldExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>> extends
//        FieldExpression<C, L>, MulitiRepositoryFieldExpression<Tuple5<Integer, Integer, Integer, Integer, Integer>, C, L> {
//
//    /**
//     * field.
//     *
//     * @param repositoiesFieldFunction the repositoies field function
//     * @return the LogicExpression
//     */
//    L field(FiveArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
//            RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
//            LogicExpression<?, ?>> repositoiesFieldFunction);
//}
