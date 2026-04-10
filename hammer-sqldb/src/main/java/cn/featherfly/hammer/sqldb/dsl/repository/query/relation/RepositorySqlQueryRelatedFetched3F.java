
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-04 18:25:04
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository.query.relation;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression4;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate4F;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched3F;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery4;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery4FF;

/**
 * The Class RepositorySqlQueryRelatedFetched3F.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched3F extends AbstractRepositorySqlQuery4FF<RepositoryQueryRelatedFetched3F>
    implements RepositoryQueryRelatedFetched3F {

    /**
     * Instantiates a new repository sql query related fetched 3 RRF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched3F(AbstractRepositorySqlQuery4<?, ?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched3F createFetched() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression4<RepositoryQueryRelate4F> join(Repository repository) {
        return new RepositorySqlQueryOn4<>(new RepositorySqlQueryRelate4F(queryRelation, sqlPageFactory), queryRelation,
            repository, relate -> ((RepositorySqlQueryRelate4F) relate).setIdName());
    }
}
