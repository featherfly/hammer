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

import java.util.function.BiFunction;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression2;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup2F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic2F;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate1R;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate2RR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched1F;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.AbstractRepositorySqlQuery2;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.RepositorySqlQueryExpression2;

/**
 * The Class RepositorySqlQueryRelate1R.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelate1R extends
    AbstractRepositorySqlQuery2<RepositoryQueryRelatedFetched1F, RepositoryQueryConditionsGroup2F,
        RepositoryQueryConditionsGroupLogic2F, RepositoryQuerySortExpression2<QueryLimitExecutor>, QueryLimitExecutor>
    implements RepositoryQueryRelate1R {

    /**
     * Instantiates a new repository sql query relate 1 R.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelate1R(AbstractRepositorySqlQuery2<?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * Instantiates a new repository sql query relate 1 R.
     *
     * @param repositoryRelation the repository relation
     * @param databaseMetadata   the database metadata
     * @param sqlPageFactory     the sql page factory
     * @param aliasManager       the alias manager
     * @param tableName          the table name
     */
    public RepositorySqlQueryRelate1R(RepositorySqlQueryRelation repositoryRelation, SqlPageFactory sqlPageFactory) {
        super(repositoryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression2<RepositoryQueryRelate2RR> join(Repository repository) {
        return new RepositorySqlQueryOn2<>(new RepositorySqlQueryRelate2RR(queryRelation, sqlPageFactory),
            queryRelation, repository, relate -> ((RepositorySqlQueryRelate2RR) relate).setIdName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup2F where() {
        return new RepositorySqlQueryExpression2(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroupLogic2F where(BiFunction<RepositoryFieldOnlyExpression,
        RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        return where(new RepositorySqlQueryExpression2(queryRelation, sqlPageFactory), repositoriesCondtionFuntion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression2<QueryLimitExecutor> sort() {
        return new RepositorySqlQueryExpression2(queryRelation, sqlPageFactory).sort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched1F createFetched() {
        return new RepositorySqlQueryRelatedFetched1F(this);
    }
}
