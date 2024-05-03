
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
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate3RFR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched2RF;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery3;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery3FF;

/**
 * RepositorySqlQueryRelatedFetched2RF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched2RF extends AbstractRepositorySqlQuery3FF<RepositoryQueryRelatedFetched2RF>
    implements RepositoryQueryRelatedFetched2RF {

    /**
     * Instantiates a new repository sql query relate 2 RF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched2RF(AbstractRepositorySqlQuery3<?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched2RF createFetched() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression3<RepositoryQueryRelate3RFR> join(
        Repository repository) {
        return new RepositorySqlQueryOn3<>(new RepositorySqlQueryRelate3RFR(queryRelation, sqlPageFactory),
            queryRelation, repository, relate -> ((RepositorySqlQueryRelate3RFR) relate).setIdName());
    }

}
