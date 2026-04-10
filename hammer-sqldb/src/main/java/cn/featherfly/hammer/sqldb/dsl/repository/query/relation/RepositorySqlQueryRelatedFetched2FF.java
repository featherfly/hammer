
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

import cn.featherfly.common.function.ThConsumer;
import cn.featherfly.common.function.ThFunction;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.data.query.LimitAwareQuery3;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression3;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup3FFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic3FFF;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate3FF;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched2FF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression3FFF;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery3;
import cn.featherfly.hammer.sqldb.dsl.repository.query.RepositorySqlQueryExpression3FFF;

/**
 * RepositorySqlQueryRelatedFetched2FF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched2FF extends
    AbstractRepositorySqlQuery3<RepositoryQueryRelatedFetched2FF, RepositoryQueryConditionsGroup3FFF,
        RepositoryQueryConditionsGroupLogic3FFF,
        RepositoryQuerySortExpression3<RepositoryQuerySortedExpression3FFF,
            LimitAwareQuery3<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression3FFF, LimitAwareQuery3<Map<String, Serializable>>>
    implements RepositoryQueryRelatedFetched2FF {

    /**
     * Instantiates a new repository sql query relate 2 RF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched2FF(AbstractRepositorySqlQuery3<?, ?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched2FF createFetched() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression3<RepositoryQueryRelate3FF> join(Repository repository) {
        return new RepositorySqlQueryOn3<>(new RepositorySqlQueryRelate3FF(queryRelation, sqlPageFactory),
            queryRelation, repository, relate -> ((RepositorySqlQueryRelate3FF) relate).setIdName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup3FFF where() {
        return new RepositorySqlQueryExpression3FFF(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroupLogic3FFF where(
        ThFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        return where(new RepositorySqlQueryExpression3FFF(queryRelation, sqlPageFactory), repositoriesCondtionFuntion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression3<RepositoryQuerySortedExpression3FFF,
        LimitAwareQuery3<Map<String, Serializable>>> sort() {
        return new RepositorySqlQueryExpression3FFF(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S1 extends RepositorySortedExpression<S1>, S2 extends RepositorySortedExpression<S2>,
        S3 extends RepositorySortedExpression<S3>> RepositoryQuerySortedExpression3FFF sort(
            ThConsumer<RepositorySortExpression<S1>, RepositorySortExpression<S2>,
                RepositorySortExpression<S3>> repositorySortExpresions) {
        return new RepositorySqlQueryExpression3FFF(queryRelation, sqlPageFactory).sort(repositorySortExpresions);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimitAwareQuery3<Map<String, Serializable>> limit(Limit limit) {
        return new RepositorySqlQueryExpression3FFF(queryRelation, sqlPageFactory).limit(limit);
    }
}
