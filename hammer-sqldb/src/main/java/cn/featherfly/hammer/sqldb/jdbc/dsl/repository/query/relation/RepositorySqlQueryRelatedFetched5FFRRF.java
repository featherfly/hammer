
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-04-04 18:25:04
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched5FFRRF;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery6;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery6FFFF;

/**
 * The Class RepositorySqlQueryRelatedFetched5FFRRF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched5FFRRF
    extends AbstractRepositorySqlQuery6FFFF<RepositoryQueryRelatedFetched5FFRRF>
    implements RepositoryQueryRelatedFetched5FFRRF {

    /**
     * Instantiates a new repository sql query related fetched 5 FFRRF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched5FFRRF(AbstractRepositorySqlQuery6<?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched5FFRRF createFetched() {
        return this;
    }
}
