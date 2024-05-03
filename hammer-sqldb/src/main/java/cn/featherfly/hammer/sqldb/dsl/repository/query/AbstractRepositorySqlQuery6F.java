
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import cn.featherfly.common.function.SixArgusFunction;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery6;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6F;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;
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
        RepositoryQuerySortExpression6<QueryLimitExecutor>, QueryLimitExecutor>
    implements RepositoryQuery6<RepositoryQueryConditionsGroup6F, RepositoryQueryConditionsGroupLogic6F,
        RepositoryQuerySortExpression6<QueryLimitExecutor>, QueryLimitExecutor> {

    /**
     * Instantiates a new abstract repository sql query 6 FF.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    public AbstractRepositorySqlQuery6F(AbstractRepositorySqlQuery6<?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * Instantiates a new abstract repository sql query 6 FF.
     *
     * @param queryRelation  the query relation
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
    public RepositoryQuerySortExpression6<QueryLimitExecutor> sort() {
        return new RepositorySqlQueryExpression6F(queryRelation, sqlPageFactory).sort();
    }
}
