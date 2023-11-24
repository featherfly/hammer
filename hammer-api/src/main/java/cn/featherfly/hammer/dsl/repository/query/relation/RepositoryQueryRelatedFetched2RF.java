
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityQueryRelatedFetched.java
 * @Package cn.featherfly.hammer.dsl.query.type
 * @Description: EntityQueryRelatedFetched
 * @author: zhongj
 * @date: 2023-06-01 16:30:01
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.repository.query.relation;

import java.util.function.Function;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery3;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;

/**
 * The Interface RepositoryQueryRelatedFetched2RF.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelatedFetched2RF
        extends RepositoryQuery3<RepositoryQuerySortExpression3<QueryLimitExecutor2>, QueryLimitExecutor2>,
        QueryLimitExecutor2 {

    /**
     * Join.
     *
     * @param repositories the repositories
     * @param repository   the repository
     * @return EntityQueryRelatedExpression
     */
    RepositoryQueryRelatedExpression<RepositoryQueryRelate3RFR, RepositoryQueryRelatedFetched3RFF> join(
            Function<Tuple3<String, String, String>, String> repositories, String repository);

    /**
     * Join.
     *
     * @param repositories the repositories
     * @param repository   the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate3RFR, RepositoryQueryRelatedFetched3RFF> join(
            Function<Tuple3<String, String, String>, String> repositories, Repository repository) {
        return join(repositories, repository.name());
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    RepositoryQueryRelatedExpression<RepositoryQueryRelate3RFR, RepositoryQueryRelatedFetched3RFF> join(
            String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate3RFR, RepositoryQueryRelatedFetched3RFF> join(
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
    RepositoryQueryRelatedExpression<RepositoryQueryRelate3RFR, RepositoryQueryRelatedFetched3RFF> join2(
            String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate3RFR, RepositoryQueryRelatedFetched3RFF> join2(
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
    RepositoryQueryRelatedExpression<RepositoryQueryRelate3RFR, RepositoryQueryRelatedFetched3RFF> join3(
            String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate3RFR, RepositoryQueryRelatedFetched3RFF> join3(
            Repository repository) {
        return join(repository.name());
    }
}
