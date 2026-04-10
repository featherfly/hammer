
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-04 18:25:04
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository.query.relation;

import java.io.Serializable;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.data.query.LimitAwareQuery2;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression2;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup2FF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic2FF;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate2F;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched1F;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression2FF;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery2;
import cn.featherfly.hammer.sqldb.dsl.repository.query.RepositorySqlQueryExpression2FF;

/**
 * RepositorySqlQueryRelatedFetched1F.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched1F extends
    AbstractRepositorySqlQuery2<RepositoryQueryRelatedFetched1F, RepositoryQueryConditionsGroup2FF,
        RepositoryQueryConditionsGroupLogic2FF,
        RepositoryQuerySortExpression2<RepositoryQuerySortedExpression2FF, LimitAwareQuery2<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression2FF, LimitAwareQuery2<Map<String, Serializable>>>
    implements RepositoryQueryRelatedFetched1F {

    /**
     * Instantiates a new repository sql query relate 1 F.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched1F(AbstractRepositorySqlQuery2<?, ?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched1F createFetched() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression2<RepositoryQueryRelate2F> join(Repository repository) {
        return new RepositorySqlQueryOn2<>(new RepositorySqlQueryRelate2F(queryRelation, sqlPageFactory), queryRelation,
            repository, relate -> ((RepositorySqlQueryRelate2F) relate).setIdName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup2FF where() {
        return new RepositorySqlQueryExpression2FF(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroupLogic2FF where(BiFunction<RepositoryFieldOnlyExpression,
        RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        return where(new RepositorySqlQueryExpression2FF(queryRelation, sqlPageFactory), repositoriesCondtionFuntion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression2<RepositoryQuerySortedExpression2FF,
        LimitAwareQuery2<Map<String, Serializable>>> sort() {
        return new RepositorySqlQueryExpression2FF(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S1 extends RepositorySortedExpression<S1>,
        S2 extends RepositorySortedExpression<S2>> RepositoryQuerySortedExpression2FF sort(
            BiConsumer<RepositorySortExpression<S1>, RepositorySortExpression<S2>> repositorySortExpresions) {
        return new RepositorySqlQueryExpression2FF(queryRelation, sqlPageFactory).sort(repositorySortExpresions);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimitAwareQuery2<Map<String, Serializable>> limit(Limit limit) {
        return new RepositorySqlQueryExpression2FF(queryRelation, sqlPageFactory).limit(limit);
    }
}
