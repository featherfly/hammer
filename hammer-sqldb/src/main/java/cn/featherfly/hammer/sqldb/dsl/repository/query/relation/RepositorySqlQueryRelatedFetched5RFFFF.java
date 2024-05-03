
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-04-04 18:25:04
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched5RFFFF;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery6;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery6FFFFF;

/**
 * The Class RepositorySqlQueryRelatedFetched5RFFFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched5RFFFF
    extends AbstractRepositorySqlQuery6FFFFF<RepositoryQueryRelatedFetched5RFFFF>
    implements RepositoryQueryRelatedFetched5RFFFF {

    /**
     * Instantiates a new repository sql query related fetched 5 RFFFF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched5RFFFF(AbstractRepositorySqlQuery6<?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched5RFFFF createFetched() {
        return this;
    }
}
