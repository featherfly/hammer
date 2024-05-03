
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.util.List;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusFunction;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery5;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup5FFFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic5FFFFF;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor5;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * AbstractRepositorySqlQuery5FFFFF.
 *
 * @author zhongj
 * @param <R> the element type
 */
public abstract class AbstractRepositorySqlQuery5FFFFF<R extends RepositoryQueryRelateExpression<R>> extends
    AbstractRepositorySqlQuery5<R, RepositoryQueryConditionsGroup5FFFFF, RepositoryQueryConditionsGroupLogic5FFFFF,
        RepositoryQuerySortExpression5<QueryLimitExecutor5>, QueryLimitExecutor5>
    implements RepositoryQuery5<RepositoryQueryConditionsGroup5FFFFF, RepositoryQueryConditionsGroupLogic5FFFFF,
        RepositoryQuerySortExpression5<QueryLimitExecutor5>, QueryLimitExecutor5>,
    QueryLimitExecutor5 {

    /**
     * Instantiates a new abstract repository sql query 5 FFFFF.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    public AbstractRepositorySqlQuery5FFFFF(AbstractRepositorySqlQuery5<?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * Instantiates a new abstract repository sql query 5 FFFFF.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractRepositorySqlQuery5FFFFF(RepositorySqlQueryRelation queryRelation,
        SqlPageFactory sqlPageFactory) {
        super(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup5FFFFF where() {
        return new RepositorySqlQueryExpression5FFFFF(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroupLogic5FFFFF where(FiveArgusFunction<RepositoryFieldOnlyExpression,
        RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
        RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        return where(new RepositorySqlQueryExpression5FFFFF(queryRelation, sqlPageFactory),
            repositoriesCondtionFuntion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression5<QueryLimitExecutor5> sort() {
        return new RepositorySqlQueryExpression5FFFFF(queryRelation, sqlPageFactory).sort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4, E5> List<Tuple5<E1, E2, E3, E4, E5>> list(
        Tuple5<String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2, Class<E3> type3,
        Class<E4> type4, Class<E5> type5) {
        return new RepositorySqlQueryExpression5FFFFF(queryRelation, sqlPageFactory).list(prefixes, type1, type2, type3,
            type4, type5);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4, E5> Tuple5<E1, E2, E3, E4, E5> single(
        Tuple5<String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2, Class<E3> type3,
        Class<E4> type4, Class<E5> type5) {
        return new RepositorySqlQueryExpression5FFFFF(queryRelation, sqlPageFactory).single(prefixes, type1, type2,
            type3, type4, type5);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4, E5> Tuple5<E1, E2, E3, E4, E5> unique(
        Tuple5<String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2, Class<E3> type3,
        Class<E4> type4, Class<E5> type5) {
        return new RepositorySqlQueryExpression5FFFFF(queryRelation, sqlPageFactory).unique(prefixes, type1, type2,
            type3, type4, type5);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4, E5> PaginationResults<Tuple5<E1, E2, E3, E4, E5>> pagination(
        Tuple5<String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2, Class<E3> type3,
        Class<E4> type4, Class<E5> type5) {
        return new RepositorySqlQueryExpression5FFFFF(queryRelation, sqlPageFactory).pagination(prefixes, type1, type2,
            type3, type4, type5);
    }
}
