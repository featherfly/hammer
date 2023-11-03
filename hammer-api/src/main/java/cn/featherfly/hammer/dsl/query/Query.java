
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetch;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryFetch;

/**
 * query.
 *
 * @author zhongj
 */
public interface Query {

    /**
     * start query dsl for repository.
     *
     * @param repository repository
     * @return generic type of QueryEntityExpression
     */
    RepositoryQueryFetch find(Repository repository);

    /**
     * start query dsl for repository.
     *
     * @param repository repository
     * @return generic type of QueryEntityExpression
     */
    RepositoryQueryFetch find(String repository);

    /**
     * start query dsl for entity.
     *
     * @param <E>    the element type
     * @param entity the entity
     * @return the entity query fetch
     */
    <E> EntityQueryFetch<E> find(Class<E> entity);
}
