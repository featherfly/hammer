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
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate4FRFR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate5FRFRR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched4FRFF;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched5FRFRF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery5;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery5FFF;

/**
 * The Class RepositorySqlQueryRelate4FRFR.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelate4FRFR extends AbstractRepositorySqlQuery5FFF<RepositoryQueryRelatedFetched4FRFF>
    implements RepositoryQueryRelate4FRFR {

    /**
     * Instantiates a new repository sql query relate 4 FRFR.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryRelate4FRFR(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query relate 4 FRFR.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    protected RepositorySqlQueryRelate4FRFR(AbstractRepositorySqlQuery5<?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched4FRFF createFetched() {
        return new RepositorySqlQueryRelatedFetched4FRFF(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryOnExpression5<RepositoryQueryRelate5FRFRR, RepositoryQueryRelatedFetched5FRFRF> join(
        Repository repository) {
        return new RepositorySqlQueryOn5<>(new RepositorySqlQueryRelate5FRFRR(queryRelation, sqlPageFactory),
            queryRelation, repository, relate -> ((RepositorySqlQueryRelate5FRFRR) relate).setIdName());
    }
}
