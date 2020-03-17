
package cn.featherfly.juorm.sqldb.jdbc.dsl.query;

import cn.featherfly.juorm.dsl.query.QueryWithOn;

/**
 * <p>
 * SqlQueryWithOn
 * </p>
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
