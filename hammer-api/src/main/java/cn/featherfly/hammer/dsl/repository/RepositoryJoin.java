
package cn.featherfly.hammer.dsl.repository;

import java.util.function.Function;

import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.repository.SimpleAliasRepository;
import cn.featherfly.common.repository.SimpleRepository;
import cn.featherfly.hammer.expression.query.NamedRepository;
import cn.featherfly.hammer.expression.query.RepositoryFetcher;

/**
 * repository query relate base.
 *
 * @author zhongj
 * @param <R> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryJoin<R extends RepositoryOnExpression<Q>, Q> {

    /**
     * Join.
     *
     * @param repository the repository
     * @return the entity query related expression
     */
    default R join(String repository) {
        return join(new SimpleRepository(repository));
    }

    /**
     * Join.
     *
     * @param function the function
     * @return the entity query related expression
     */
    default R join(Function<RepositoryFetcher, Repository> function) {
        RepositoryFetcher fetchRepository = name -> new NamedRepository() {
            @Override
            public AliasRepository alias(String alias) {
                return new SimpleAliasRepository(name, alias);
            }

            @Override
            public String name() {
                return name;
            }
        };
        return join(function.apply(fetchRepository));
    }

    /**
     * Join.
     *
     * @param repository the repository
     * @return the entity query related expression
     */
    R join(Repository repository);
}
