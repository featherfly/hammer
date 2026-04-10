
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-04 18:25:04
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository.query.relation;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression3;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate3F;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched2F;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery3;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery3FF;

/**
 * RepositorySqlQueryRelatedFetched2F.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched2F extends AbstractRepositorySqlQuery3FF<RepositoryQueryRelatedFetched2F>
    implements RepositoryQueryRelatedFetched2F {

    /**
     * Instantiates a new repository sql query relate 2 RF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched2F(AbstractRepositorySqlQuery3<?, ?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched2F createFetched() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression3<RepositoryQueryRelate3F> join(Repository repository) {
        return new RepositorySqlQueryOn3<>(new RepositorySqlQueryRelate3F(queryRelation, sqlPageFactory), queryRelation,
            repository, relate -> ((RepositorySqlQueryRelate3F) relate).setIdName());
    }

}
