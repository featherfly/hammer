
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-04 18:25:04
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository.query.relation;

import java.util.List;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.common.function.FourArgusFunction;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.tuple.Tuple4;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression4;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup4FFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic4FFFF;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelate4FFFR;
import cn.featherfly.hammer.dsl.repository.query.relation.RepositoryQueryRelatedFetched3FFF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression4FFFF;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor4;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractRepositorySqlQuery4;
import cn.featherfly.hammer.sqldb.dsl.repository.query.RepositorySqlQueryExpression4FFFF;

/**
 * The Class RepositorySqlQueryRelatedFetched3FFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryRelatedFetched3FFF extends
    AbstractRepositorySqlQuery4<RepositoryQueryRelatedFetched3FFF, RepositoryQueryConditionsGroup4FFFF,
        RepositoryQueryConditionsGroupLogic4FFFF,
        RepositoryQuerySortExpression4<RepositoryQuerySortedExpression4FFFF, QueryLimitExecutor4>,
        RepositoryQuerySortedExpression4FFFF, QueryLimitExecutor4>
    implements RepositoryQueryRelatedFetched3FFF {

    /**
     * Instantiates a new repository sql query relate 2 RF.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    public RepositorySqlQueryRelatedFetched3FFF(AbstractRepositorySqlQuery4<?, ?, ?, ?, ?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression4<RepositoryQueryRelate4FFFR> join(Repository repository) {
        return new RepositorySqlQueryOn4<>(new RepositorySqlQueryRelate4FFFR(queryRelation, sqlPageFactory),
            queryRelation, repository, relate -> ((RepositorySqlQueryRelate4FFFR) relate).setIdName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryRelatedFetched3FFF createFetched() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup4FFFF where() {
        return new RepositorySqlQueryExpression4FFFF(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroupLogic4FFFF where(
        FourArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        return where(new RepositorySqlQueryExpression4FFFF(queryRelation, sqlPageFactory), repositoriesCondtionFuntion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression4<RepositoryQuerySortedExpression4FFFF, QueryLimitExecutor4> sort() {
        return new RepositorySqlQueryExpression4FFFF(queryRelation, sqlPageFactory).sort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S1 extends RepositorySortedExpression<S1>, S2 extends RepositorySortedExpression<S2>,
        S3 extends RepositorySortedExpression<S3>,
        S4 extends RepositorySortedExpression<S4>> RepositoryQuerySortedExpression4FFFF sort(
            FourArgusConsumer<RepositorySortExpression<S1>, RepositorySortExpression<S2>, RepositorySortExpression<S3>,
                RepositorySortExpression<S4>> repositorySortExpresions) {
        return new RepositorySqlQueryExpression4FFFF(queryRelation, sqlPageFactory).sort(repositorySortExpresions);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4> List<Tuple4<E1, E2, E3, E4>> list(Tuple4<String, String, String, String> prefixes,
        Class<E1> type1, Class<E2> type2, Class<E3> type3, Class<E4> type4) {
        return new RepositorySqlQueryExpression4FFFF(queryRelation, sqlPageFactory).list(prefixes, type1, type2, type3,
            type4);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4> Tuple4<E1, E2, E3, E4> single(Tuple4<String, String, String, String> prefixes,
        Class<E1> type1, Class<E2> type2, Class<E3> type3, Class<E4> type4) {
        return new RepositorySqlQueryExpression4FFFF(queryRelation, sqlPageFactory).single(prefixes, type1, type2,
            type3, type4);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4> Tuple4<E1, E2, E3, E4> unique(Tuple4<String, String, String, String> prefixes,
        Class<E1> type1, Class<E2> type2, Class<E3> type3, Class<E4> type4) {
        return new RepositorySqlQueryExpression4FFFF(queryRelation, sqlPageFactory).unique(prefixes, type1, type2,
            type3, type4);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4> PaginationResults<Tuple4<E1, E2, E3, E4>> pagination(
        Tuple4<String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2, Class<E3> type3,
        Class<E4> type4) {
        return new RepositorySqlQueryExpression4FFFF(queryRelation, sqlPageFactory).pagination(prefixes, type1, type2,
            type3, type4);
    }

}
