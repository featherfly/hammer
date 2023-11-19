
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryFetch;

/**
 * SqlQueryFetch.
 *
 * @author zhongj
 */
public interface RepositorySqlQueryFetch extends RepositoryQueryFetch {

    //    /**
    //     * Join.
    //     *
    //     * @param join           the join
    //     * @param repositoryName the repository name
    //     * @return the sql query with on
    //     */
    //    SqlQueryWithOn join(Join join, String repositoryName);

    //    /**
    //     * Join.
    //     *
    //     * @param <T>            the generic type
    //     * @param repositoryType the repository type
    //     * @return the sql query with on
    //     */
    //    @Override
    //    default <T> SqlQueryWithOn join(Class<T> repositoryType) {
    //        return join(Join.INNER_JOIN, repositoryType);
    //    }

    //    /**
    //     * Join.
    //     *
    //     * @param <T>            the generic type
    //     * @param join           the join
    //     * @param repositoryType the repository type
    //     * @return the sql query with on
    //     */
    //    <T> SqlQueryWithOn join(Join join, Class<T> repositoryType);

}
