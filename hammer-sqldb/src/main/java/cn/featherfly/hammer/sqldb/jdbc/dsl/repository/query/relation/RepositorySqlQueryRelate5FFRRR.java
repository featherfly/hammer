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

import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate5FFRRR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched5FFRRF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery6;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery6FFF;

/**
 * The Class RepositorySqlQueryRelate5FFRRR.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelate5FFRRR extends AbstractRepositorySqlQuery6FFF<RepositoryQueryRelatedFetched5FFRRF>
    implements RepositoryQueryRelate5FFRRR {

    /**
     * Instantiates a new repository sql query relate 5 FFRRR.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryRelate5FFRRR(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query relate 5 FFRRR.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    protected RepositorySqlQueryRelate5FFRRR(AbstractRepositorySqlQuery6<?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched5FFRRF createFetched() {
        return new RepositorySqlQueryRelatedFetched5FFRRF(this);
    }
}
