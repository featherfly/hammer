
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-04-04 18:25:04
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched5FFFFF;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery6;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery6FFFFFF;

/**
 * The Class RepositorySqlQueryRelatedFetched5FFFFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched5FFFFF
    extends AbstractRepositorySqlQuery6FFFFFF<RepositoryQueryRelatedFetched5FFFFF>
    implements RepositoryQueryRelatedFetched5FFFFF {

    /**
     * Instantiates a new repository sql query related fetched 5 FFFFF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched5FFFFF(AbstractRepositorySqlQuery6<?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched5FFFFF createFetched() {
        return this;
    }
}
