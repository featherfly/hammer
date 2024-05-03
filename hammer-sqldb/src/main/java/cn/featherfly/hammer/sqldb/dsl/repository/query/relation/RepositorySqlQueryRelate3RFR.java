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
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression4;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate3RFR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate4RFRR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched3RFF;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery4;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery4FF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * The Class RepositorySqlQueryRelate3RFR.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelate3RFR extends AbstractRepositorySqlQuery4FF<RepositoryQueryRelatedFetched3RFF>
    implements RepositoryQueryRelate3RFR {

    /**
     * Instantiates a new repository sql query relate 3 RFR.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryRelate3RFR(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query relate 3 RFR.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    protected RepositorySqlQueryRelate3RFR(AbstractRepositorySqlQuery4<?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched3RFF createFetched() {
        return new RepositorySqlQueryRelatedFetched3RFF(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression4<RepositoryQueryRelate4RFRR> join(
        Repository repository) {
        return new RepositorySqlQueryOn4<>(new RepositorySqlQueryRelate4RFRR(queryRelation, sqlPageFactory),
            queryRelation, repository, relate -> ((RepositorySqlQueryRelate4RFRR) relate).setIdName());
    }

}
