
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
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate5FFF;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched4FFF;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery5;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery5FFFF;

/**
 * The Class RepositorySqlQueryRelatedFetched4FFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched4FFF extends
    AbstractRepositorySqlQuery5FFFF<RepositoryQueryRelatedFetched4FFF> implements RepositoryQueryRelatedFetched4FFF {

    /**
     * Instantiates a new repository sql query related fetched 4 FFRF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched4FFF(AbstractRepositorySqlQuery5<?, ?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched4FFF createFetched() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression5<RepositoryQueryRelate5FFF> join(Repository repository) {
        return new RepositorySqlQueryOn5<>(new RepositorySqlQueryRelate5FFF(queryRelation, sqlPageFactory),
            queryRelation, repository, relate -> ((RepositorySqlQueryRelate5FFF) relate).setIdName());
    }

}
