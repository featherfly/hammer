
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-04-04 18:25:04
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched5RFRFF;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery6;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery6FFFF;

/**
 * The Class RepositorySqlQueryRelatedFetched5RFRFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched5RFRFF
    extends AbstractRepositorySqlQuery6FFFF<RepositoryQueryRelatedFetched5RFRFF>
    implements RepositoryQueryRelatedFetched5RFRFF {

    /**
     * Instantiates a new repository sql query related fetched 5 RFRFF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched5RFRFF(AbstractRepositorySqlQuery6<?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched5RFRFF createFetched() {
        return this;
    }
}
