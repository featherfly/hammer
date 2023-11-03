
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-04-04 18:25:04
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched5FRFRF;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery6;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery6FFFF;

/**
 * The Class RepositorySqlQueryRelatedFetched5FRFRF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched5FRFRF
    extends AbstractRepositorySqlQuery6FFFF<RepositoryQueryRelatedFetched5FRFRF>
    implements RepositoryQueryRelatedFetched5FRFRF {

    /**
     * Instantiates a new repository sql query related fetched 5 FRFRF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched5FRFRF(AbstractRepositorySqlQuery6<?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched5FRFRF createFetched() {
        return this;
    }
}
