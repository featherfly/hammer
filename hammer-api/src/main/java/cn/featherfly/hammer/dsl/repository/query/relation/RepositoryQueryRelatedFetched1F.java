
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-27 18:36:27
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.repository.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.repository.function.RepositoryFunction;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery2;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;

/**
 * The Interface RepositoryQueryRelatedFetched1F.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelatedFetched1F
        extends RepositoryQuery2<RepositoryQuerySortExpression2<QueryLimitExecutor2>, QueryLimitExecutor2>,
        RepositoryQueryMulitiRelate<RepositoryQueryRelate2FR, RepositoryQueryRelatedFetched2FF,
                Tuple2<RepositoryFunction, RepositoryFunction>, Tuple2<String, String>>,
        QueryLimitExecutor2 {

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    RepositoryQueryRelatedExpression<RepositoryQueryRelate2FR, RepositoryQueryRelatedFetched2FF> join(
            String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate2FR, RepositoryQueryRelatedFetched2FF> join(
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
    RepositoryQueryRelatedExpression<RepositoryQueryRelate2FR, RepositoryQueryRelatedFetched2FF> join2(
            String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return EntityQueryRelatedExpression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate2FR, RepositoryQueryRelatedFetched2FF> join2(
            Repository repository) {
        return join(repository.name());
    }
}
