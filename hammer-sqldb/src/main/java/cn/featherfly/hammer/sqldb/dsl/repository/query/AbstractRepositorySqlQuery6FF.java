
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.util.List;

import cn.featherfly.common.tuple.Tuple2;

import cn.featherfly.common.function.SixArgusFunction;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery6;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6FF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6FF;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor2;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * AbstractRepositorySqlQuery6FF.
 *
 * @author zhongj
 * @param <R> the element type
 */
public abstract class AbstractRepositorySqlQuery6FF<R extends RepositoryQueryRelateExpression<R>> extends
    AbstractRepositorySqlQuery6<R, RepositoryQueryConditionsGroup6FF, RepositoryQueryConditionsGroupLogic6FF,
        RepositoryQuerySortExpression6<QueryLimitExecutor2>, QueryLimitExecutor2>
    implements RepositoryQuery6<RepositoryQueryConditionsGroup6FF, RepositoryQueryConditionsGroupLogic6FF,
        RepositoryQuerySortExpression6<QueryLimitExecutor2>, QueryLimitExecutor2>,
    QueryLimitExecutor2 {

    /**
     * Instantiates a new abstract repository sql query 6 FF.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    public AbstractRepositorySqlQuery6FF(AbstractRepositorySqlQuery6<?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * Instantiates a new abstract repository sql query 6 FF.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractRepositorySqlQuery6FF(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup6FF where() {
        return new RepositorySqlQueryExpression6FF(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroupLogic6FF where(
        SixArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        return where(new RepositorySqlQueryExpression6FF(queryRelation, sqlPageFactory), repositoriesCondtionFuntion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression6<QueryLimitExecutor2> sort() {
        return new RepositorySqlQueryExpression6FF(queryRelation, sqlPageFactory).sort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2> List<Tuple2<E1, E2>> list(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2) {
        return new RepositorySqlQueryExpression6FF(queryRelation, sqlPageFactory).list(prefixes, type1, type2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2> Tuple2<E1, E2> single(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2) {
        return new RepositorySqlQueryExpression6FF(queryRelation, sqlPageFactory).single(prefixes, type1, type2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2> Tuple2<E1, E2> unique(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2) {
        return new RepositorySqlQueryExpression6FF(queryRelation, sqlPageFactory).unique(prefixes, type1, type2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2> PaginationResults<Tuple2<E1, E2>> pagination(Tuple2<String, String> prefixes, Class<E1> type1,
        Class<E2> type2) {
        return new RepositorySqlQueryExpression6FF(queryRelation, sqlPageFactory).pagination(prefixes, type1, type2);
    }
}
