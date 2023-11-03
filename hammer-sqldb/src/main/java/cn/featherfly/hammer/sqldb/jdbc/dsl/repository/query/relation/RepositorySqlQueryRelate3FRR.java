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

package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryOnExpression4;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate3FRR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate4FRRR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched3FRF;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched4FRRF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery4;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery4FF;

/**
 * The Class RepositorySqlQueryRelate3FRR.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelate3FRR extends AbstractRepositorySqlQuery4FF<RepositoryQueryRelatedFetched3FRF>
    implements RepositoryQueryRelate3FRR {

    /**
     * Instantiates a new repository sql query relate 3 FRR.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryRelate3FRR(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query relate 3 FRR.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    protected RepositorySqlQueryRelate3FRR(AbstractRepositorySqlQuery4<?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched3FRF createFetched() {
        return new RepositorySqlQueryRelatedFetched3FRF(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryOnExpression4<RepositoryQueryRelate4FRRR, RepositoryQueryRelatedFetched4FRRF> join(
        String repository) {
        return new RepositorySqlQueryOn4<>(new RepositorySqlQueryRelate4FRRR(queryRelation, sqlPageFactory),
            queryRelation, repository, relate -> ((RepositorySqlQueryRelate4FRRR) relate).setIdName());
    }

}
