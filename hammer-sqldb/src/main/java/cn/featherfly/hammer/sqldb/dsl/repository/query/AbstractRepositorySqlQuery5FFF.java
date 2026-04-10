
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.common.function.FiConsumer;
import cn.featherfly.common.function.FiFunction;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.data.query.LimitAwareQuery3;
import cn.featherfly.data.query.QueryMapperSetter3;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery5;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup5FFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic5FFF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression5FFF;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * AbstractRepositorySqlQuery5FFF.
 *
 * @author zhongj
 * @param <R> the element type
 */
public abstract class AbstractRepositorySqlQuery5FFF<R extends RepositoryQueryRelateExpression<R>> extends
    AbstractRepositorySqlQuery5<R, RepositoryQueryConditionsGroup5FFF, RepositoryQueryConditionsGroupLogic5FFF,
        RepositoryQuerySortExpression5<RepositoryQuerySortedExpression5FFF,
            LimitAwareQuery3<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression5FFF, LimitAwareQuery3<Map<String, Serializable>>>
    implements
    RepositoryQuery5<RepositoryQueryConditionsGroup5FFF, RepositoryQueryConditionsGroupLogic5FFF,
        RepositoryQuerySortExpression5<RepositoryQuerySortedExpression5FFF,
            LimitAwareQuery3<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression5FFF, LimitAwareQuery3<Map<String, Serializable>>>,
    QueryMapperSetter3 {

    /**
     * Instantiates a new abstract repository sql query 5 FFF.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    public AbstractRepositorySqlQuery5FFF(AbstractRepositorySqlQuery5<?, ?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * Instantiates a new abstract repository sql query 5 FFF.
     *
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractRepositorySqlQuery5FFF(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup5FFF where() {
        return new RepositorySqlQueryExpression5FFF(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroupLogic5FFF where(FiFunction<RepositoryFieldOnlyExpression,
        RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
        RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        return where(new RepositorySqlQueryExpression5FFF(queryRelation, sqlPageFactory), repositoriesCondtionFuntion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression5<RepositoryQuerySortedExpression5FFF,
        LimitAwareQuery3<Map<String, Serializable>>> sort() {
        return new RepositorySqlQueryExpression5FFF(queryRelation, sqlPageFactory).sort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S1 extends RepositorySortedExpression<S1>, S2 extends RepositorySortedExpression<S2>,
        S3 extends RepositorySortedExpression<S3>, S4 extends RepositorySortedExpression<S4>,
        S5 extends RepositorySortedExpression<S5>> RepositoryQuerySortedExpression5FFF sort(
            FiConsumer<RepositorySortExpression<S1>, RepositorySortExpression<S2>, RepositorySortExpression<S3>,
                RepositorySortExpression<S4>, RepositorySortExpression<S5>> repositorySortExpresions) {
        return new RepositorySqlQueryExpression5FFF(queryRelation, sqlPageFactory).sort(repositorySortExpresions);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimitAwareQuery3<Map<String, Serializable>> limit(Limit limit) {
        return new RepositorySqlQueryExpression5FFF(queryRelation, sqlPageFactory).limit(limit);
    }
}
