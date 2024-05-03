
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-04 18:25:04
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository.query.relation;

import java.util.List;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusFunction;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression3;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup3FFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic3FFF;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate3FFR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched2FF;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor3;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery3;
import cn.featherfly.hammer.sqldb.dsl.repository.query.RepositorySqlQueryExpression3FFF;

/**
 * RepositorySqlQueryRelatedFetched2FF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched2FF extends
    AbstractRepositorySqlQuery3<RepositoryQueryRelatedFetched2FF, RepositoryQueryConditionsGroup3FFF,
        RepositoryQueryConditionsGroupLogic3FFF, RepositoryQuerySortExpression3<QueryLimitExecutor3>,
        QueryLimitExecutor3>
    implements RepositoryQueryRelatedFetched2FF {

    /**
     * Instantiates a new repository sql query relate 2 RF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched2FF(AbstractRepositorySqlQuery3<?, ?, ?, ?, ?> repositorySqlQueryFetch) {
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
    public RepositoryOnExpression3<RepositoryQueryRelate3FFR> join(
        Repository repository) {
        return new RepositorySqlQueryOn3<>(new RepositorySqlQueryRelate3FFR(queryRelation, sqlPageFactory),
            queryRelation, repository, relate -> ((RepositorySqlQueryRelate3FFR) relate).setIdName());
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
        ThreeArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        return where(new RepositorySqlQueryExpression3FFF(queryRelation, sqlPageFactory), repositoriesCondtionFuntion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression3<QueryLimitExecutor3> sort() {
        return new RepositorySqlQueryExpression3FFF(queryRelation, sqlPageFactory).sort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3> List<Tuple3<E1, E2, E3>> list(Tuple3<String, String, String> prefixes, Class<E1> type1,
        Class<E2> type2, Class<E3> type3) {
        return new RepositorySqlQueryExpression3FFF(queryRelation, sqlPageFactory).list(prefixes, type1, type2, type3);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3> Tuple3<E1, E2, E3> single(Tuple3<String, String, String> prefixes, Class<E1> type1,
        Class<E2> type2, Class<E3> type3) {
        return new RepositorySqlQueryExpression3FFF(queryRelation, sqlPageFactory).single(prefixes, type1, type2,
            type3);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3> Tuple3<E1, E2, E3> unique(Tuple3<String, String, String> prefixes, Class<E1> type1,
        Class<E2> type2, Class<E3> type3) {
        return new RepositorySqlQueryExpression3FFF(queryRelation, sqlPageFactory).unique(prefixes, type1, type2,
            type3);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3> PaginationResults<Tuple3<E1, E2, E3>> pagination(Tuple3<String, String, String> prefixes,
        Class<E1> type1, Class<E2> type2, Class<E3> type3) {
        return new RepositorySqlQueryExpression3FFF(queryRelation, sqlPageFactory).pagination(prefixes, type1, type2,
            type3);
    }
}
