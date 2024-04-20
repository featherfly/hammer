
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-04-04 18:25:04
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.relation;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryOnExpression5;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate5RFFFR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched4RFFF;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched5RFFFF;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery5;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery5FFFF;

/**
 * The Class RepositorySqlQueryRelatedFetched4RFFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched4RFFF extends
    AbstractRepositorySqlQuery5FFFF<RepositoryQueryRelatedFetched4RFFF> implements RepositoryQueryRelatedFetched4RFFF {

    /**
     * Instantiates a new repository sql query related fetched 4 RFFF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched4RFFF(AbstractRepositorySqlQuery5<?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched4RFFF createFetched() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryOnExpression5<RepositoryQueryRelate5RFFFR, RepositoryQueryRelatedFetched5RFFFF> join(
        Repository repository) {
        return new RepositorySqlQueryOn5<>(new RepositorySqlQueryRelate5RFFFR(queryRelation, sqlPageFactory),
            queryRelation, repository, relate -> ((RepositorySqlQueryRelate5RFFFR) relate).setIdName());
    }

}
