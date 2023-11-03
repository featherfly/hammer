//
//package cn.featherfly.hammer.dsl.repository.query.relation;
//
//import java.util.function.Consumer;
//import java.util.function.ToIntFunction;
//
//import com.speedment.common.tuple.Tuple;
//
//import cn.featherfly.common.repository.Repository;
//import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
// TODO 后续删除
///**
// * repository query relate base.
// *
// * @author zhongj
// * @param <Q>  the generic type
// * @param <F>  the generic type
// * @param <T>  the generic type
// * @param <T2> the generic type
// */
//public interface RepositoryQueryMulitiRelate<Q extends RepositoryQueryRelateExpression<F>, F, T extends Tuple,
//        T2 extends Tuple> {
//
//    /**
//     * Join.
//     *
//     * @param repositories the repositories
//     * @return EntityQueryRelatedExpression
//     */
//    RepositoryQueryRelatedExpression<Q, F> join(Consumer<T> repositories);
//
//    /**
//     * Join.
//     *
//     * @param repositories the repositories
//     * @param repository   the repository
//     * @return EntityQueryRelatedExpression
//     */
//    RepositoryQueryRelatedExpression<Q, F> join(ToIntFunction<T2> repositories, String repository);
//
//    /**
//     * Join.
//     *
//     * @param repositories the repositories
//     * @param repository   the repository
//     * @return EntityQueryRelatedExpression
//     */
//    default RepositoryQueryRelatedExpression<Q, F> join(ToIntFunction<T2> repositories, Repository repository) {
//        return join(repositories, repository.name());
//    }
//}
