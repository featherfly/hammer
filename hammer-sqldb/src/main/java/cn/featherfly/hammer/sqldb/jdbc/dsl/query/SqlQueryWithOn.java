
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import cn.featherfly.hammer.dsl.query.QueryWithOn;

/**
 * SqlQueryWithOn.
 *
 * @author zhongj
 */
public interface SqlQueryWithOn extends QueryWithOn {
    /**
     * {@inheritDoc}
     */
    @Override
    SqlQueryWithEntity on(String propertyName);

    /**
     * {@inheritDoc}
     */
    @Override
    SqlQueryWithEntity on(String propertyName, String findRepositoryPropertyName);

    /**
     * {@inheritDoc}
     */
    @Override
    SqlQueryWithEntity on(String propertyName, String repositoryName, String repositoryPropertyName);
}
