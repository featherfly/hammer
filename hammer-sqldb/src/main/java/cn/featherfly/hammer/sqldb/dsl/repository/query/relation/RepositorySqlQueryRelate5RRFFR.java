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

import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate5RRFFR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched5RRFFF;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery6;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery6FFF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * The Class RepositorySqlQueryRelate5RRFFR.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelate5RRFFR extends AbstractRepositorySqlQuery6FFF<RepositoryQueryRelatedFetched5RRFFF>
    implements RepositoryQueryRelate5RRFFR {

    /**
     * Instantiates a new repository sql query relate 5 RRFFR.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryRelate5RRFFR(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query relate 5 RRFFR.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    protected RepositorySqlQueryRelate5RRFFR(AbstractRepositorySqlQuery6<?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched5RRFFF createFetched() {
        return new RepositorySqlQueryRelatedFetched5RRFFF(this);
    }
}
