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

import cn.featherfly.common.function.ThreeArgusFunction;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup3F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic3F;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryOnExpression3;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate2RR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate3RRR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched2RF;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched3RRF;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery3;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.RepositorySqlQueryExpression3F;

/**
 * The Class RepositorySqlQueryRelate2RR.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelate2RR extends
    AbstractRepositorySqlQuery3<RepositoryQueryRelatedFetched2RF, RepositoryQueryConditionsGroup3F,
        RepositoryQueryConditionsGroupLogic3F, RepositoryQuerySortExpression3<QueryLimitExecutor>, QueryLimitExecutor>
    implements RepositoryQueryRelate2RR {

    /**
     * Instantiates a new repository sql query relate 2 RR.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryRelate2RR(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query relate 2 RR.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    protected RepositorySqlQueryRelate2RR(AbstractRepositorySqlQuery3<?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched2RF createFetched() {
        return new RepositorySqlQueryRelatedFetched2RF(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup3F where() {
        return new RepositorySqlQueryExpression3F(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroupLogic3F where(
        ThreeArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        return where(new RepositorySqlQueryExpression3F(queryRelation, sqlPageFactory), repositoriesCondtionFuntion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression3<QueryLimitExecutor> sort() {
        return new RepositorySqlQueryExpression3F(queryRelation, sqlPageFactory).sort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryOnExpression3<RepositoryQueryRelate3RRR, RepositoryQueryRelatedFetched3RRF> join(
        Repository repository) {
        return new RepositorySqlQueryOn3<>(new RepositorySqlQueryRelate3RRR(queryRelation, sqlPageFactory),
            queryRelation, repository, relate -> ((RepositorySqlQueryRelate3RRR) relate).setIdName());
    }
}
