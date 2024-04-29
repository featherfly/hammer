/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntitySqlQueryRelate1R.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation
 * @Description: todo (用一句话描述该文件做什么)
 * @author: zhongj
 * @date: 2023年9月26日 下午5:51:29
 * @version V1.0
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */

package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.relation;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression3;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate2FR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate3FRR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched2FF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery3FF;

/**
 * The Class RepositorySqlQueryRelate2FR.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelate2FR extends AbstractRepositorySqlQuery3FF<RepositoryQueryRelatedFetched2FF>
    implements RepositoryQueryRelate2FR {

    /**
     * Instantiates a new repository sql query relate 2 FR.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    public RepositorySqlQueryRelate2FR(AbstractRepositorySqlQuery3FF<?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * Instantiates a new repository sql query relate 2 FR.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryRelate2FR(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched2FF createFetched() {
        return new RepositorySqlQueryRelatedFetched2FF(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression3<RepositoryQueryRelate3FRR> join(Repository repository) {
        return new RepositorySqlQueryOn3<>(new RepositorySqlQueryRelate3FRR(queryRelation, sqlPageFactory),
            queryRelation, repository, relate -> ((RepositorySqlQueryRelate3FRR) relate).setIdName());
    }

}
