
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.common.function.SixArgusFunction;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery6;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6F;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression6F;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * AbstractRepositorySqlQuery6F.
 *
 * @author zhongj
 * @param <R> the element type
 */
public abstract class AbstractRepositorySqlQuery6F<R extends RepositoryQueryRelateExpression<R>> extends
    AbstractRepositorySqlQuery6<R, RepositoryQueryConditionsGroup6F, RepositoryQueryConditionsGroupLogic6F,
        RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6F, QueryLimitExecutor>,
        RepositoryQuerySortedExpression6F, QueryLimitExecutor>
    implements
    RepositoryQuery6<RepositoryQueryConditionsGroup6F, RepositoryQueryConditionsGroupLogic6F,
        RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6F, QueryLimitExecutor>,
        RepositoryQuerySortedExpression6F, QueryLimitExecutor> {

    /**
     * Instantiates a new abstract repository sql query 6 FF.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    public AbstractRepositorySqlQuery6F(AbstractRepositorySqlQuery6<?, ?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * Instantiates a new abstract repository sql query 6 FF.
     *
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractRepositorySqlQuery6F(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroup6F where() {
        return new RepositorySqlQueryExpression6F(queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionsGroupLogic6F where(
        SixArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        return where(new RepositorySqlQueryExpression6F(queryRelation, sqlPageFactory), repositoriesCondtionFuntion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6F, QueryLimitExecutor> sort() {
        return new RepositorySqlQueryExpression6F(queryRelation, sqlPageFactory).sort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S1 extends RepositorySortedExpression<S1>, S2 extends RepositorySortedExpression<S2>,
        S3 extends RepositorySortedExpression<S3>, S4 extends RepositorySortedExpression<S4>,
        S5 extends RepositorySortedExpression<S5>,
        S6 extends RepositorySortedExpression<S6>> RepositoryQuerySortedExpression6F sort(
            SixArgusConsumer<RepositorySortExpression<S1>, RepositorySortExpression<S2>, RepositorySortExpression<S3>,
                RepositorySortExpression<S4>, RepositorySortExpression<S5>,
                RepositorySortExpression<S6>> repositorySortExpresions) {
        return new RepositorySqlQueryExpression6F(queryRelation, sqlPageFactory).sort(repositorySortExpresions);
    }
}
