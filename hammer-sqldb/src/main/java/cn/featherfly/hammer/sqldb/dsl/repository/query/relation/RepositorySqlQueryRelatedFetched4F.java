
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-04-04 18:25:04
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository.query.relation;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression5;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate5F;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched4F;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery5;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery5FF;

/**
 * The Class RepositorySqlQueryRelatedFetched4F.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched4F
    extends AbstractRepositorySqlQuery5FF<RepositoryQueryRelatedFetched4F> implements RepositoryQueryRelatedFetched4F {

    /**
     * Instantiates a new repository sql query related fetched 4 RRRF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched4F(
        AbstractRepositorySqlQuery5<?, ?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched4F createFetched() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression5<RepositoryQueryRelate5F> join(Repository repository) {
        return new RepositorySqlQueryOn5<>(new RepositorySqlQueryRelate5F(queryRelation, sqlPageFactory), queryRelation,
            repository, relate -> ((RepositorySqlQueryRelate5F) relate).setIdName());
    }

}
