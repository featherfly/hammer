
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple5;
import cn.featherfly.common.tuple.Tuples;

import cn.featherfly.common.function.FiveArgusFunction;
import cn.featherfly.hammer.config.dsl.DslQueryConfig;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery5;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;
import cn.featherfly.hammer.sqldb.dsl.condition.AbstractSqlConditionExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.condition.field.RepositoryFieldOnlyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * AbstractRepositorySqlQuery5.
 *
 * @author zhongj
 * @param <R> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public abstract class AbstractRepositorySqlQuery5<R extends RepositoryQueryRelateExpression<R>,
    C extends RepositoryQueryConditionsGroupExpression5<C, L, S, Q>,
    L extends RepositoryQueryConditionsGroupLogicExpression5<C, L, S, Q>, S extends RepositoryQuerySortExpression5<Q>,
    Q extends QueryLimitExecutor> extends AbstractRepositorySqlQueryJoin<R, C, Q>
    implements RepositoryQuery5<C, L, S, Q> {

    protected static final Tuple5<Integer, Integer, Integer, Integer,
        Integer> RELATIONS_TUPLE = Tuples.of(0, 1, 2, 3, 4);

    /**
     * Instantiates a new abstract repository sql query 5.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    protected AbstractRepositorySqlQuery5(AbstractRepositorySqlQuery5<?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * Instantiates a new abstract repository sql query 5.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractRepositorySqlQuery5(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(4, queryRelation, sqlPageFactory);
    }

    protected <E extends AbstractSqlConditionExpression<?, ?, ?>> E where(E conditions,
        FiveArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        if (repositoriesCondtionFuntion != null) {
            conditions.addCondition(
                repositoriesCondtionFuntion.apply(new RepositoryFieldOnlyExpressionImpl<>(0, queryRelation),
                    new RepositoryFieldOnlyExpressionImpl<>(1, queryRelation),
                    new RepositoryFieldOnlyExpressionImpl<>(2, queryRelation),
                    new RepositoryFieldOnlyExpressionImpl<>(3, queryRelation),
                    new RepositoryFieldOnlyExpressionImpl<>(4, queryRelation)));
        }
        return conditions;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryExpression5<C, L, S, Q> configure(Consumer<DslQueryConfig> configure) {
        configure.accept(queryRelation.getConfig());
        return this;
    }
}
