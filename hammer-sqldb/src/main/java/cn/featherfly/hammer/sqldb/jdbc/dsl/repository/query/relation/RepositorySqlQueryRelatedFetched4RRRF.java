
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-04-04 18:25:04
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryOnExpression5;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate5RRRFR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched4RRRF;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched5RRRFF;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery5;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery5FF;

/**
 * The Class RepositorySqlQueryRelatedFetched4RRRF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched4RRRF extends
    AbstractRepositorySqlQuery5FF<RepositoryQueryRelatedFetched4RRRF> implements RepositoryQueryRelatedFetched4RRRF {

    /**
     * Instantiates a new repository sql query related fetched 4 RRRF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched4RRRF(AbstractRepositorySqlQuery5<?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched4RRRF createFetched() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryOnExpression5<RepositoryQueryRelate5RRRFR, RepositoryQueryRelatedFetched5RRRFF> join(
        String repository) {
        return new RepositorySqlQueryOn5<>(new RepositorySqlQueryRelate5RRRFR(queryRelation, sqlPageFactory),
            queryRelation, repository, relate -> ((RepositorySqlQueryRelate5RRRFR) relate).setIdName());
    }

}
