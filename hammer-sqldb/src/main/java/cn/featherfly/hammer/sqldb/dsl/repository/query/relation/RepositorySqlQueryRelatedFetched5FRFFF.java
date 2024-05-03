
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-04-04 18:25:04
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched5FRFFF;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery6;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery6FFFFF;

/**
 * The Class RepositorySqlQueryRelatedFetched5FRFFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched5FRFFF
    extends AbstractRepositorySqlQuery6FFFFF<RepositoryQueryRelatedFetched5FRFFF>
    implements RepositoryQueryRelatedFetched5FRFFF {

    /**
     * Instantiates a new repository sql query related fetched 5 FRFFF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched5FRFFF(AbstractRepositorySqlQuery6<?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched5FRFFF createFetched() {
        return this;
    }
}
