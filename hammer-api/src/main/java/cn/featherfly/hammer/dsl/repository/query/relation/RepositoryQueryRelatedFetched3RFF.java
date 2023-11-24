
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

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery4;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;

/**
 * The Interface RepositoryQueryRelatedFetched3RFF.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelatedFetched3RFF
        extends RepositoryQuery4<RepositoryQuerySortExpression4<QueryLimitExecutor3>, QueryLimitExecutor3>,
        QueryLimitExecutor3 {

    /**
     * Join.
     *
     * @param repositories the repositories
     * @param repository   the repository
     * @return EntityQueryRelatedExpression
     */
    RepositoryQueryRelatedExpression<RepositoryQueryRelate4RFFR, RepositoryQueryRelatedFetched4RFFF> join(
            Function<Tuple4<String, String, String, String>, String> repositories, String repository);

    /**
     * Join.
     *
     * @param repositories the repositories
     * @param repository   the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate4RFFR, RepositoryQueryRelatedFetched4RFFF> join(
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
    RepositoryQueryRelatedExpression<RepositoryQueryRelate4RFFR, RepositoryQueryRelatedFetched4RFFF> join(
            String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate4RFFR, RepositoryQueryRelatedFetched4RFFF> join(
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
    RepositoryQueryRelatedExpression<RepositoryQueryRelate4RFFR, RepositoryQueryRelatedFetched4RFFF> join2(
            String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate4RFFR, RepositoryQueryRelatedFetched4RFFF> join2(
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
    RepositoryQueryRelatedExpression<RepositoryQueryRelate4RFFR, RepositoryQueryRelatedFetched4RFFF> join3(
            String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate4RFFR, RepositoryQueryRelatedFetched4RFFF> join3(
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
    RepositoryQueryRelatedExpression<RepositoryQueryRelate4RFFR, RepositoryQueryRelatedFetched4RFFF> join4(
            String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate4RFFR, RepositoryQueryRelatedFetched4RFFF> join4(
            Repository repository) {
        return join(repository.name());
    }
}
