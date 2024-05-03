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

import cn.featherfly.common.function.FourArgusFunction;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression4;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup4F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic4F;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate3RRR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate4RRRR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched3RRF;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery4;
import cn.featherfly.hammer.sqldb.dsl.repository.query.RepositorySqlQueryExpression4F;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * The Class RepositorySqlQueryRelate3RRR.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelate3RRR extends
    AbstractRepositorySqlQuery4<RepositoryQueryRelatedFetched3RRF, RepositoryQueryConditionsGroup4F,
        RepositoryQueryConditionsGroupLogic4F, RepositoryQuerySortExpression4<QueryLimitExecutor>, QueryLimitExecutor>
    implements RepositoryQueryRelate3RRR {

    /**
     * Instantiates a new repository sql query relate 3 RRR.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryRelate3RRR(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query relate 3 RRR.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    protected RepositorySqlQueryRelate3RRR(AbstractRepositorySqlQuery4<?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched3RRF createFetched() {
        return new RepositorySqlQueryRelatedFetched3RRF(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup4F where() {
        return new RepositorySqlQueryExpression4F(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroupLogic4F where(
        FourArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        return where(new RepositorySqlQueryExpression4F(queryRelation, sqlPageFactory), repositoriesCondtionFuntion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression4<QueryLimitExecutor> sort() {
        return new RepositorySqlQueryExpression4F(queryRelation, sqlPageFactory).sort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression4<RepositoryQueryRelate4RRRR> join(
        Repository repository) {
        return new RepositorySqlQueryOn4<>(new RepositorySqlQueryRelate4RRRR(queryRelation, sqlPageFactory),
            queryRelation, repository, relate -> ((RepositorySqlQueryRelate4RRRR) relate).setIdName());
    }

}
