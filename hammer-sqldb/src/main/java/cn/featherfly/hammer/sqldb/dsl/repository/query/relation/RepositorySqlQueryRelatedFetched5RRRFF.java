
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-04-04 18:25:04
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched5RRRFF;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery6;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery6FFF;

/**
 * The Class RepositorySqlQueryRelatedFetched5RRRFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched5RRRFF extends
    AbstractRepositorySqlQuery6FFF<RepositoryQueryRelatedFetched5RRRFF> implements RepositoryQueryRelatedFetched5RRRFF {

    /**
     * Instantiates a new repository sql query related fetched 5 RRRFF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched5RRRFF(AbstractRepositorySqlQuery6<?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched5RRRFF createFetched() {
        return this;
    }
}
