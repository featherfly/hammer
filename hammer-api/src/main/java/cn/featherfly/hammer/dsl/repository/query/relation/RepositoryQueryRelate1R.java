
package cn.featherfly.hammer.dsl.repository.query.relation;

import java.util.function.BiConsumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.repository.function.RepositoryFunction;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery2;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;

/**
 * The Interface EntityQueryRelate1R.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate1R extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched1F>,
        RepositoryQuery2<RepositoryQuerySortExpression2<QueryLimitExecutor>, QueryLimitExecutor>,
        RepositoryQueryMulitiRelate<RepositoryQueryRelate2RR, RepositoryQueryRelatedFetched2RF,
                Tuple2<RepositoryFunction, RepositoryFunction>, Tuple2<String, String>> {

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    RepositoryQueryRelatedExpression<RepositoryQueryRelate2RR, RepositoryQueryRelatedFetched2RF> join(
            BiConsumer<RepositoryFunction, RepositoryFunction> repositories);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    RepositoryQueryRelatedExpression<RepositoryQueryRelate2RR, RepositoryQueryRelatedFetched2RF> join(
            String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate2RR, RepositoryQueryRelatedFetched2RF> join(
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
    RepositoryQueryRelatedExpression<RepositoryQueryRelate2RR, RepositoryQueryRelatedFetched2RF> join2(
            String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate2RR, RepositoryQueryRelatedFetched2RF> join2(
            Repository repository) {
        return join2(repository.name());
    }
}
