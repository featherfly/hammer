
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.common.repository.Repository;

/**
 * repository query relate base.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface RepositoryQueryRelate {
    /**
     * Join.
     *
     * @param <R>      the generic type
     * @param joinType the join type
     * @return the entity query related expression
     */
    RepositoryQueryRelatedExpression<RepositoryQueryRelate1R, RepositoryQueryRelatedFetched1F> join(String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return the entity query related expression
     */
    default RepositoryQueryRelatedExpression<RepositoryQueryRelate1R, RepositoryQueryRelatedFetched1F> join(
            Repository repository) {
        return join(repository.name());
    }

    //    /**
    //     * Join.
    //     *
    //     * @param <R>      the generic type
    //     * @param joinType the join type
    //     * @return the entity query related expression
    //     */
    //    <R> RepositoryQueryRelatedExpression<?, ?> join(Consumer<FetchRepository> repository); // FIXME 后续来处理泛型
}
