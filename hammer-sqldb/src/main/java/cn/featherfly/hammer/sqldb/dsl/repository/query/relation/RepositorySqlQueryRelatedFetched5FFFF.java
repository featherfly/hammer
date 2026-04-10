
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-04-04 18:25:04
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched5FFFF;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery6;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery6FFFFF;

/**
 * The Class RepositorySqlQueryRelatedFetched5FFFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched5FFFF extends
    AbstractRepositorySqlQuery6FFFFF<RepositoryQueryRelatedFetched5FFFF> implements RepositoryQueryRelatedFetched5FFFF {

    /**
     * Instantiates a new repository sql query related fetched 5 FFFRF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched5FFFF(
        AbstractRepositorySqlQuery6<?, ?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched5FFFF createFetched() {
        return this;
    }
}
