
package cn.featherfly.hammer.dsl.query;

import java.util.function.Function;

import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.repository.SimpleAliasRepository;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetch;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryFetch;
import cn.featherfly.hammer.expression.query.NamedRepository;
import cn.featherfly.hammer.expression.query.RepositoryFetcher;

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
     * @param fetchRepositoryFunction the fetch repository function
     * @return generic type of QueryEntityExpression
     */
    default RepositoryQueryFetch find(Function<RepositoryFetcher, Repository> fetchRepositoryFunction) {
        return find(fetchRepositoryFunction.apply(name -> new NamedRepository() {
            @Override
            public AliasRepository alias(String alias) {
                return new SimpleAliasRepository(name, alias);
            }

            @Override
            public String name() {
                return name;
            }
        }));
    }

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
