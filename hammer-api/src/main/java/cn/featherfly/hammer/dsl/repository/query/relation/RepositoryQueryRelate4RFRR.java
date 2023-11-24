
package cn.featherfly.hammer.dsl.repository.query.relation;

import java.util.function.Function;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery5;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;

/**
 * The Interface RepositoryQueryRelate4RFRR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate4RFRR extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched4RFRF>,
        RepositoryQuery5<RepositoryQuerySortExpression5<QueryLimitExecutor2>, QueryLimitExecutor2>,
        QueryLimitExecutor2 {

    /**
     * Join.
     *
     * @param repositories the repositories
     * @param repository   the repository
     * @return EntityQueryRelatedExpression
     */
    RepositoryQueryRelatedExpression<RepositoryQueryRelate5RFRRR, RepositoryQueryRelatedFetched5RFRRF> join(
            Function<Tuple5<String, String, String, String, String>, String> repositories, String repository);

    /**
     * Join.
     *
     * @param repositories the repositories
     * @param repository   the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate5RFRRR, RepositoryQueryRelatedFetched5RFRRF> join(
            Function<Tuple5<String, String, String, String, String>, String> repositories, Repository repository) {
        return join(repositories, repository.name());
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    RepositoryQueryRelatedExpression<RepositoryQueryRelate5RFRRR, RepositoryQueryRelatedFetched5RFRRF> join(
            String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate5RFRRR, RepositoryQueryRelatedFetched5RFRRF> join(
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
    RepositoryQueryRelatedExpression<RepositoryQueryRelate5RFRRR, RepositoryQueryRelatedFetched5RFRRF> join2(
            String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate5RFRRR, RepositoryQueryRelatedFetched5RFRRF> join2(
            Repository repository) {
        return join(repository.name());
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
    RepositoryQueryRelatedExpression<RepositoryQueryRelate5RFRRR, RepositoryQueryRelatedFetched5RFRRF> join3(
            String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate5RFRRR, RepositoryQueryRelatedFetched5RFRRF> join3(
            Repository repository) {
        return join(repository.name());
    }

    // ****************************************************************************************************************
    // join 4
    // ****************************************************************************************************************

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    RepositoryQueryRelatedExpression<RepositoryQueryRelate5RFRRR, RepositoryQueryRelatedFetched5RFRRF> join4(
            String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate5RFRRR, RepositoryQueryRelatedFetched5RFRRF> join4(
            Repository repository) {
        return join(repository.name());
    }

    // ****************************************************************************************************************
    // join 4
    // ****************************************************************************************************************

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    RepositoryQueryRelatedExpression<RepositoryQueryRelate5RFRRR, RepositoryQueryRelatedFetched5RFRRF> join5(
            String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate5RFRRR, RepositoryQueryRelatedFetched5RFRRF> join5(
            Repository repository) {
        return join(repository.name());
    }
}
