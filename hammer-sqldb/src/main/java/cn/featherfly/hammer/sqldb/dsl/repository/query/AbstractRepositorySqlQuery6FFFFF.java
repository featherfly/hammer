
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.common.function.SiConsumer;
import cn.featherfly.common.function.SiFunction;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.data.query.LimitAwareQuery5;
import cn.featherfly.data.query.QueryMapperSetter5;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery6;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6FFFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6FFFFF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression6FFFFF;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * AbstractRepositorySqlQuery6FFFFF.
 *
 * @author zhongj
 * @param <R> the element type
 */
public abstract class AbstractRepositorySqlQuery6FFFFF<R extends RepositoryQueryRelateExpression<R>> extends
    AbstractRepositorySqlQuery6<R, RepositoryQueryConditionsGroup6FFFFF, RepositoryQueryConditionsGroupLogic6FFFFF,
        RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6FFFFF,
            LimitAwareQuery5<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression6FFFFF, LimitAwareQuery5<Map<String, Serializable>>>
    implements
    RepositoryQuery6<RepositoryQueryConditionsGroup6FFFFF, RepositoryQueryConditionsGroupLogic6FFFFF,
        RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6FFFFF,
            LimitAwareQuery5<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression6FFFFF, LimitAwareQuery5<Map<String, Serializable>>>,
    QueryMapperSetter5 {

    /**
     * Instantiates a new abstract repository sql query 6 FFFFF.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    public AbstractRepositorySqlQuery6FFFFF(AbstractRepositorySqlQuery6<?, ?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * Instantiates a new abstract repository sql query 6 FFFFF.
     *
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractRepositorySqlQuery6FFFFF(RepositorySqlQueryRelation queryRelation,
        SqlPageFactory sqlPageFactory) {
        super(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup6FFFFF where() {
        return new RepositorySqlQueryExpression6FFFFF(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroupLogic6FFFFF where(
        SiFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        return where(new RepositorySqlQueryExpression6FFFFF(queryRelation, sqlPageFactory),
            repositoriesCondtionFuntion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6FFFFF,
        LimitAwareQuery5<Map<String, Serializable>>> sort() {
        return new RepositorySqlQueryExpression6FFFFF(queryRelation, sqlPageFactory).sort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S1 extends RepositorySortedExpression<S1>, S2 extends RepositorySortedExpression<S2>,
        S3 extends RepositorySortedExpression<S3>, S4 extends RepositorySortedExpression<S4>,
        S5 extends RepositorySortedExpression<S5>,
        S6 extends RepositorySortedExpression<S6>> RepositoryQuerySortedExpression6FFFFF sort(
            SiConsumer<RepositorySortExpression<S1>, RepositorySortExpression<S2>, RepositorySortExpression<S3>,
                RepositorySortExpression<S4>, RepositorySortExpression<S5>,
                RepositorySortExpression<S6>> repositorySortExpresions) {
        return new RepositorySqlQueryExpression6FFFFF(queryRelation, sqlPageFactory).sort(repositorySortExpresions);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimitAwareQuery5<Map<String, Serializable>> limit(Limit limit) {
        return new RepositorySqlQueryExpression6FFFFF(queryRelation, sqlPageFactory).limit(limit);
    }
}
