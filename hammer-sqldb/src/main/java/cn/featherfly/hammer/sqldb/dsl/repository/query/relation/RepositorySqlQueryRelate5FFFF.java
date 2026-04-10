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

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.data.query.LimitAwareQuery5;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate5FFFF;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched5FFFFF;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery6;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery6FFFFF;
import cn.featherfly.hammer.sqldb.dsl.repository.query.RepositorySqlQueryExpression5FFFFF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * The Class RepositorySqlQueryRelate5FFFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelate5FFFF extends AbstractRepositorySqlQuery6FFFFF<RepositoryQueryRelatedFetched5FFFFF>
    implements RepositoryQueryRelate5FFFF {

    /**
     * Instantiates a new repository sql query relate 5 FFFFR.
     *
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryRelate5FFFF(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query relate 5 FFFFR.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    protected RepositorySqlQueryRelate5FFFF(AbstractRepositorySqlQuery6<?, ?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched5FFFFF createFetched() {
        return new RepositorySqlQueryRelatedFetched5FFFFF(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimitAwareQuery5<Map<String, Serializable>> limit(Limit limit) {
        return new RepositorySqlQueryExpression5FFFFF(queryRelation, sqlPageFactory).limit(limit);
    }
}
