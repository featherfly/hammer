
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;

/**
 * repository query relate base.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface RepositoryQueryRelate<R extends RepositoryQueryOnExpression<Q, F>,
        Q extends RepositoryQueryRelateExpression<F>, F> {
    /**
     * Join.
     *
     * @param <R>      the generic type
     * @param joinType the join type
     * @return the entity query related expression
     */
    R join(String repository);

    /**
     * Join.
     *
     * @param repository the repository
     * @return the entity query related expression
     */
    default R join(Repository repository) {
        return join(repository.name());
    }
}
