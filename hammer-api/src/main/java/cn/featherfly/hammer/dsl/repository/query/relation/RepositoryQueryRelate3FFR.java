
package cn.featherfly.hammer.dsl.repository.query.relation;

import java.util.function.Function;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery4;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;

/**
 * The Interface RepositoryQueryRelate3FFR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate3FFR extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched3FFF>,
        RepositoryQuery4<RepositoryQuerySortExpression4<QueryLimitExecutor2>, QueryLimitExecutor2>,
        QueryLimitExecutor2 {

    /**
     * Join.
     *
     * @param repositories the repositories
     * @param repository   the repository
     * @return EntityQueryRelatedExpression
     */
    RepositoryQueryRelatedExpression<RepositoryQueryRelate4FFRR, RepositoryQueryRelatedFetched4FFRF> join(
            Function<Tuple4<String, String, String, String>, String> repositories, String repository);

    /**
     * Join.
     *
     * @param repositories the repositories
     * @param repository   the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate4FFRR, RepositoryQueryRelatedFetched4FFRF> join(
            Function<Tuple4<String, String, String, String>, String> repositories, Repository repository) {
        return join(repositories, repository.name());
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    RepositoryQueryRelatedExpression<RepositoryQueryRelate4FFRR, RepositoryQueryRelatedFetched4FFRF> join(
            String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate4FFRR, RepositoryQueryRelatedFetched4FFRF> join(
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
    RepositoryQueryRelatedExpression<RepositoryQueryRelate4FFRR, RepositoryQueryRelatedFetched4FFRF> join2(
            String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate4FFRR, RepositoryQueryRelatedFetched4FFRF> join2(
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
    RepositoryQueryRelatedExpression<RepositoryQueryRelate4FFRR, RepositoryQueryRelatedFetched4FFRF> join3(
            String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate4FFRR, RepositoryQueryRelatedFetched4FFRF> join3(
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
    RepositoryQueryRelatedExpression<RepositoryQueryRelate4FFRR, RepositoryQueryRelatedFetched4FFRF> join4(
            String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate4FFRR, RepositoryQueryRelatedFetched4FFRF> join4(
            Repository repository) {
        return join(repository.name());
    }
}
