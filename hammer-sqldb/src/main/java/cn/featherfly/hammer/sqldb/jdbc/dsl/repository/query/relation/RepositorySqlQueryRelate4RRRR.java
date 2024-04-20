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

import cn.featherfly.common.function.FiveArgusFunction;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup5F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic5F;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryOnExpression5;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate4RRRR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate5RRRRR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched4RRRF;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched5RRRRF;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery5;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.RepositorySqlQueryExpression5F;

/**
 * The Class RepositorySqlQueryRelate4RRRR.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelate4RRRR extends
    AbstractRepositorySqlQuery5<RepositoryQueryRelatedFetched4RRRF, RepositoryQueryConditionsGroup5F,
        RepositoryQueryConditionsGroupLogic5F, RepositoryQuerySortExpression5<QueryLimitExecutor>, QueryLimitExecutor>
    implements RepositoryQueryRelate4RRRR {

    /**
     * Instantiates a new repository sql query relate 4 RRRR.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryRelate4RRRR(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query relate 4 RRRR.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    protected RepositorySqlQueryRelate4RRRR(AbstractRepositorySqlQuery5<?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched4RRRF createFetched() {
        return new RepositorySqlQueryRelatedFetched4RRRF(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup5F where() {
        return new RepositorySqlQueryExpression5F(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroupLogic5F where(FiveArgusFunction<RepositoryFieldOnlyExpression,
        RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
        RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        return where(new RepositorySqlQueryExpression5F(queryRelation, sqlPageFactory), repositoriesCondtionFuntion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression5<QueryLimitExecutor> sort() {
        return new RepositorySqlQueryExpression5F(queryRelation, sqlPageFactory).sort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryOnExpression5<RepositoryQueryRelate5RRRRR, RepositoryQueryRelatedFetched5RRRRF> join(
        Repository repository) {
        return new RepositorySqlQueryOn5<>(new RepositorySqlQueryRelate5RRRRR(queryRelation, sqlPageFactory),
            queryRelation, repository, relate -> ((RepositorySqlQueryRelate5RRRRR) relate).setIdName());
    }

}
