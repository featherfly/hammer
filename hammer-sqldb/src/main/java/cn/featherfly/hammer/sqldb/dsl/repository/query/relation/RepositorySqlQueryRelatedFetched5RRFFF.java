
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-04-04 18:25:04
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched5RRFFF;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery6;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery6FFFF;

/**
 * The Class RepositorySqlQueryRelatedFetched5RRFFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched5RRFFF
    extends AbstractRepositorySqlQuery6FFFF<RepositoryQueryRelatedFetched5RRFFF>
    implements RepositoryQueryRelatedFetched5RRFFF {

    /**
     * Instantiates a new repository sql query related fetched 5 RRFFF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched5RRFFF(AbstractRepositorySqlQuery6<?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched5RRFFF createFetched() {
        return this;
    }
}
