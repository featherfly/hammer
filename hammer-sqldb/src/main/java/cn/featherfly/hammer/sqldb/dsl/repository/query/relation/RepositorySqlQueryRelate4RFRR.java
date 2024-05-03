/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntitySqlQueryRelate1R.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation
 * @Description: todo (用一句话描述该文件做什么)
 * @author: zhongj
 * @date: 2024年9月26日 下午5:51:29
 * @version V1.0
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */

package cn.featherfly.hammer.sqldb.dsl.repository.query.relation;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression5;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate4RFRR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate5RFRRR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched4RFRF;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery5;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery5FF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * The Class RepositorySqlQueryRelate4RFRR.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelate4RFRR extends AbstractRepositorySqlQuery5FF<RepositoryQueryRelatedFetched4RFRF>
    implements RepositoryQueryRelate4RFRR {

    /**
     * Instantiates a new repository sql query relate 4 RFRR.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryRelate4RFRR(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query relate 4 RFRR.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    protected RepositorySqlQueryRelate4RFRR(AbstractRepositorySqlQuery5<?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched4RFRF createFetched() {
        return new RepositorySqlQueryRelatedFetched4RFRF(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression5<RepositoryQueryRelate5RFRRR> join(
        Repository repository) {
        return new RepositorySqlQueryOn5<>(new RepositorySqlQueryRelate5RFRRR(queryRelation, sqlPageFactory),
            queryRelation, repository, relate -> ((RepositorySqlQueryRelate5RFRRR) relate).setIdName());
    }
}
