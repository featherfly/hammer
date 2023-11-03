
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-04-04 18:25:04
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched5RRFRF;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery6;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery6FFF;

/**
 * The Class RepositorySqlQueryRelatedFetched5RRFRF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched5RRFRF extends
    AbstractRepositorySqlQuery6FFF<RepositoryQueryRelatedFetched5RRFRF> implements RepositoryQueryRelatedFetched5RRFRF {

    /**
     * Instantiates a new repository sql query related fetched 5 RRFRF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched5RRFRF(AbstractRepositorySqlQuery6<?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched5RRFRF createFetched() {
        return this;
    }
}
