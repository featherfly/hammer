
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-04-04 18:25:04
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched5F;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery6;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery6FF;

/**
 * The Class RepositorySqlQueryRelatedFetched5F.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched5F extends AbstractRepositorySqlQuery6FF<RepositoryQueryRelatedFetched5F>
    implements RepositoryQueryRelatedFetched5F {

    /**
     * Instantiates a new repository sql query related fetched 5 RRRRF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched5F(AbstractRepositorySqlQuery6<?, ?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched5F createFetched() {
        return this;
    }
}
