
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-04-04 18:25:04
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched5FF;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery6;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery6FFF;

/**
 * The Class RepositorySqlQueryRelatedFetched5FF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched5FF extends
    AbstractRepositorySqlQuery6FFF<RepositoryQueryRelatedFetched5FF> implements RepositoryQueryRelatedFetched5FF {

    /**
     * Instantiates a new repository sql query related fetched 5 RRRFF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched5FF(AbstractRepositorySqlQuery6<?, ?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched5FF createFetched() {
        return this;
    }
}
