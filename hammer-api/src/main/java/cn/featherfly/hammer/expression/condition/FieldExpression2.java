//
//package cn.featherfly.hammer.expression.condition;
//
//import java.util.function.BiFunction;
//
//import com.speedment.common.tuple.Tuple2;
//
//import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
//
///**
// * field expression2.
// *
// * @author zhongj
// * @param <C> the generic type
// * @param <L> the generic type
// */
//public interface FieldExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
//        extends FieldExpression<C, L>, MulitiRepositoryFieldExpression<Tuple2<Integer, Integer>, C, L> {
//
//    /**
//     * field.
//     *
//     * @param repositoiesFieldFunction the repositoies field function
//     * @return the LogicExpression
//     */
//    L field(BiFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
//            LogicExpression<?, ?>> repositoiesFieldFunction);
//}
