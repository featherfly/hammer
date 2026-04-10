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
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate3F;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate4F;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched3FF;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery4;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery4FF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * The Class RepositorySqlQueryRelate3F.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelate3F extends AbstractRepositorySqlQuery4FF<RepositoryQueryRelatedFetched3FF>
    implements RepositoryQueryRelate3F {

    /**
     * Instantiates a new repository sql query relate 3 FRR.
     *
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryRelate3F(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query relate 3 FRR.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    protected RepositorySqlQueryRelate3F(AbstractRepositorySqlQuery4<?, ?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched3FF createFetched() {
        return new RepositorySqlQueryRelatedFetched3FF(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression4<RepositoryQueryRelate4F> join(Repository repository) {
        return new RepositorySqlQueryOn4<>(new RepositorySqlQueryRelate4F(queryRelation, sqlPageFactory), queryRelation,
            repository, relate -> ((RepositorySqlQueryRelate4F) relate).setIdName());
    }

}
