
package cn.featherfly.hammer.dsl.repository.query.relation;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.repository.function.RepositoryFunction;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery3;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;

/**
 * The Interface RepositoryQueryRelate2RR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate2FR extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched2FF>,
        RepositoryQuery3<RepositoryQuerySortExpression3<QueryLimitExecutor2>, QueryLimitExecutor2>, QueryLimitExecutor2,
        RepositoryQueryMulitiRelate<RepositoryQueryRelate3FRR, RepositoryQueryRelatedFetched3FRF,
                Tuple3<RepositoryFunction, RepositoryFunction, RepositoryFunction>, Tuple3<String, String, String>> {

    /**
     * Join.
     *
     * @param repositories the repositories
     * @param repository   the repository
     * @return EntityQueryRelatedExpression
     */
    RepositoryQueryRelatedExpression<RepositoryQueryRelate3FRR, RepositoryQueryRelatedFetched3FRF> join(
            ThreeArgusConsumer<RepositoryFunction, RepositoryFunction, RepositoryFunction> repositories);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    RepositoryQueryRelatedExpression<RepositoryQueryRelate3FRR, RepositoryQueryRelatedFetched3FRF> join(
            String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate3FRR, RepositoryQueryRelatedFetched3FRF> join(
            Repository repository) {
        return join(repository.name());
    }

    // ****************************************************************************************************************
    // join 2
    // ****************************************************************************************************************

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    RepositoryQueryRelatedExpression<RepositoryQueryRelate3FRR, RepositoryQueryRelatedFetched3FRF> join2(
            String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate3FRR, RepositoryQueryRelatedFetched3FRF> join2(
            Repository repository) {
        return join2(repository.name());
    }

    // ****************************************************************************************************************
    // join 3
    // ****************************************************************************************************************

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    RepositoryQueryRelatedExpression<RepositoryQueryRelate3FRR, RepositoryQueryRelatedFetched3FRF> join3(
            String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate3FRR, RepositoryQueryRelatedFetched3FRF> join3(
            Repository repository) {
        return join3(repository.name());
    }
}
