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

import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryOnExpression5;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate4FRRR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate5FRRRR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched4FRRF;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched5FRRRF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery5;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery5FF;

/**
 * The Class RepositorySqlQueryRelate4FRRR.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelate4FRRR extends AbstractRepositorySqlQuery5FF<RepositoryQueryRelatedFetched4FRRF>
    implements RepositoryQueryRelate4FRRR {

    /**
     * Instantiates a new repository sql query relate 4 FRRR.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryRelate4FRRR(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query relate 4 FRRR.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    protected RepositorySqlQueryRelate4FRRR(AbstractRepositorySqlQuery5<?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched4FRRF createFetched() {
        return new RepositorySqlQueryRelatedFetched4FRRF(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryOnExpression5<RepositoryQueryRelate5FRRRR, RepositoryQueryRelatedFetched5FRRRF> join(
        Repository repository) {
        return new RepositorySqlQueryOn5<>(new RepositorySqlQueryRelate5FRRRR(queryRelation, sqlPageFactory),
            queryRelation, repository, relate -> ((RepositorySqlQueryRelate5FRRRR) relate).setIdName());
    }
}
