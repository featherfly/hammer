
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-04-04 18:25:04
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched5FFRFF;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery6;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery6FFFFF;

/**
 * The Class RepositorySqlQueryRelatedFetched5FFRFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched5FFRFF
    extends AbstractRepositorySqlQuery6FFFFF<RepositoryQueryRelatedFetched5FFRFF>
    implements RepositoryQueryRelatedFetched5FFRFF {

    /**
     * Instantiates a new repository sql query related fetched 5 FFRFF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched5FFRFF(AbstractRepositorySqlQuery6<?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched5FFRFF createFetched() {
        return this;
    }
}
