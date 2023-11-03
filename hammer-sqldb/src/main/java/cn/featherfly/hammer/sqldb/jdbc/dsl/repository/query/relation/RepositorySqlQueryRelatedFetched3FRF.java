
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-04 18:25:04
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryOnExpression4;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate4FRFR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched3FRF;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched4FRFF;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery4;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery4FFF;

/**
 * The Class RepositorySqlQueryRelatedFetched3FRF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched3FRF extends
    AbstractRepositorySqlQuery4FFF<RepositoryQueryRelatedFetched3FRF> implements RepositoryQueryRelatedFetched3FRF {

    /**
     * Instantiates a new repository sql query relate 2 RF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched3FRF(AbstractRepositorySqlQuery4<?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched3FRF createFetched() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryOnExpression4<RepositoryQueryRelate4FRFR, RepositoryQueryRelatedFetched4FRFF> join(
        String repository) {
        return new RepositorySqlQueryOn4<>(new RepositorySqlQueryRelate4FRFR(queryRelation, sqlPageFactory),
            queryRelation, repository, relate -> ((RepositorySqlQueryRelate4FRFR) relate).setIdName());
    }
}
