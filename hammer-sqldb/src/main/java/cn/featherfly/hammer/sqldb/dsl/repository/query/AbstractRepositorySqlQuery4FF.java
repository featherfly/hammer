
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.util.List;

import cn.featherfly.common.tuple.Tuple2;

import cn.featherfly.common.function.FourArgusFunction;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery4;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup4FF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic4FF;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor2;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * AbstractRepositorySqlQuery4.
 *
 * @author zhongj
 * @param <R> the element type
 */
public abstract class AbstractRepositorySqlQuery4FF<R extends RepositoryQueryRelateExpression<R>> extends
    AbstractRepositorySqlQuery4<R, RepositoryQueryConditionsGroup4FF, RepositoryQueryConditionsGroupLogic4FF,
        RepositoryQuerySortExpression4<QueryLimitExecutor2>, QueryLimitExecutor2>
    implements RepositoryQuery4<RepositoryQueryConditionsGroup4FF, RepositoryQueryConditionsGroupLogic4FF,
        RepositoryQuerySortExpression4<QueryLimitExecutor2>, QueryLimitExecutor2>,
    QueryLimitExecutor2 {

    /**
     * Instantiates a new abstract repository sql query 4 FF.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    public AbstractRepositorySqlQuery4FF(AbstractRepositorySqlQuery4<?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * Instantiates a new abstract repository sql query 4 FF.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractRepositorySqlQuery4FF(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup4FF where() {
        return new RepositorySqlQueryExpression4FF(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroupLogic4FF where(
        FourArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        return where(new RepositorySqlQueryExpression4FF(queryRelation, sqlPageFactory), repositoriesCondtionFuntion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression4<QueryLimitExecutor2> sort() {
        return new RepositorySqlQueryExpression4FF(queryRelation, sqlPageFactory).sort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2> List<Tuple2<E1, E2>> list(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2) {
        return new RepositorySqlQueryExpression4FF(queryRelation, sqlPageFactory).list(prefixes, type1, type2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2> Tuple2<E1, E2> single(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2) {
        return new RepositorySqlQueryExpression4FF(queryRelation, sqlPageFactory).single(prefixes, type1, type2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2> Tuple2<E1, E2> unique(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2) {
        return new RepositorySqlQueryExpression4FF(queryRelation, sqlPageFactory).unique(prefixes, type1, type2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2> PaginationResults<Tuple2<E1, E2>> pagination(Tuple2<String, String> prefixes, Class<E1> type1,
        Class<E2> type2) {
        return new RepositorySqlQueryExpression4FF(queryRelation, sqlPageFactory).pagination(prefixes, type1, type2);
    }
}
