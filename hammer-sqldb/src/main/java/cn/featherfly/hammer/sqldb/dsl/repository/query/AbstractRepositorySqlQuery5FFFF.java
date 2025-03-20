
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.util.List;

import cn.featherfly.common.function.FiConsumer;
import cn.featherfly.common.function.FiFunction;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.tuple.Tuple4;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery5;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup5FFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic5FFFF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression5FFFF;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor4;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * AbstractRepositorySqlQuery5FFFF.
 *
 * @author zhongj
 * @param <R> the element type
 */
public abstract class AbstractRepositorySqlQuery5FFFF<R extends RepositoryQueryRelateExpression<R>> extends
    AbstractRepositorySqlQuery5<R, RepositoryQueryConditionsGroup5FFFF, RepositoryQueryConditionsGroupLogic5FFFF,
        RepositoryQuerySortExpression5<RepositoryQuerySortedExpression5FFFF, QueryLimitExecutor4>,
        RepositoryQuerySortedExpression5FFFF, QueryLimitExecutor4>
    implements
    RepositoryQuery5<RepositoryQueryConditionsGroup5FFFF, RepositoryQueryConditionsGroupLogic5FFFF,
        RepositoryQuerySortExpression5<RepositoryQuerySortedExpression5FFFF, QueryLimitExecutor4>,
        RepositoryQuerySortedExpression5FFFF, QueryLimitExecutor4>,
    QueryLimitExecutor4 {

    /**
     * Instantiates a new abstract repository sql query 5 FFFF.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    public AbstractRepositorySqlQuery5FFFF(AbstractRepositorySqlQuery5<?, ?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * Instantiates a new abstract repository sql query 5 FFFF.
     *
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractRepositorySqlQuery5FFFF(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup5FFFF where() {
        return new RepositorySqlQueryExpression5FFFF(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroupLogic5FFFF where(FiFunction<RepositoryFieldOnlyExpression,
        RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
        RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        return where(new RepositorySqlQueryExpression5FFFF(queryRelation, sqlPageFactory), repositoriesCondtionFuntion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression5<RepositoryQuerySortedExpression5FFFF, QueryLimitExecutor4> sort() {
        return new RepositorySqlQueryExpression5FFFF(queryRelation, sqlPageFactory).sort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S1 extends RepositorySortedExpression<S1>, S2 extends RepositorySortedExpression<S2>,
        S3 extends RepositorySortedExpression<S3>, S4 extends RepositorySortedExpression<S4>,
        S5 extends RepositorySortedExpression<S5>> RepositoryQuerySortedExpression5FFFF sort(
            FiConsumer<RepositorySortExpression<S1>, RepositorySortExpression<S2>, RepositorySortExpression<S3>,
                RepositorySortExpression<S4>, RepositorySortExpression<S5>> repositorySortExpresions) {
        return new RepositorySqlQueryExpression5FFFF(queryRelation, sqlPageFactory).sort(repositorySortExpresions);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4> List<Tuple4<E1, E2, E3, E4>> list(Tuple4<String, String, String, String> prefixes,
        Class<E1> type1, Class<E2> type2, Class<E3> type3, Class<E4> type4) {
        return new RepositorySqlQueryExpression5FFFF(queryRelation, sqlPageFactory).list(prefixes, type1, type2, type3,
            type4);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4> Tuple4<E1, E2, E3, E4> single(Tuple4<String, String, String, String> prefixes,
        Class<E1> type1, Class<E2> type2, Class<E3> type3, Class<E4> type4) {
        return new RepositorySqlQueryExpression5FFFF(queryRelation, sqlPageFactory).single(prefixes, type1, type2,
            type3, type4);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4> Tuple4<E1, E2, E3, E4> unique(Tuple4<String, String, String, String> prefixes,
        Class<E1> type1, Class<E2> type2, Class<E3> type3, Class<E4> type4) {
        return new RepositorySqlQueryExpression5FFFF(queryRelation, sqlPageFactory).unique(prefixes, type1, type2,
            type3, type4);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4> PaginationResults<Tuple4<E1, E2, E3, E4>> pagination(
        Tuple4<String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2, Class<E3> type3,
        Class<E4> type4) {
        return new RepositorySqlQueryExpression5FFFF(queryRelation, sqlPageFactory).pagination(prefixes, type1, type2,
            type3, type4);
    }
}
