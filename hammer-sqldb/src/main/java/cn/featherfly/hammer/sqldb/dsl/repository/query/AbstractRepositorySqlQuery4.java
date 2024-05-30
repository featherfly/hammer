
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple4;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.function.FourArgusFunction;
import cn.featherfly.hammer.config.dsl.DslQueryConfig;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery4;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;
import cn.featherfly.hammer.sqldb.dsl.condition.AbstractSqlConditionExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.condition.field.RepositoryFieldOnlyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * AbstractRepositorySqlQuery4.
 *
 * @author zhongj
 * @param <R> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public abstract class AbstractRepositorySqlQuery4<R extends RepositoryQueryRelateExpression<R>,
    C extends RepositoryQueryConditionsGroupExpression4<C, L, S, Q>,
    L extends RepositoryQueryConditionsGroupLogicExpression4<C, L, S, Q>, S extends RepositoryQuerySortExpression4<Q>,
    Q extends QueryLimitExecutor> extends AbstractRepositorySqlQueryJoin<R, C, Q>
    implements RepositoryQuery4<C, L, S, Q> {

    protected static final Tuple4<Integer, Integer, Integer, Integer> RELATIONS_TUPLE = Tuples.of(0, 1, 2, 3);

    /**
     * Instantiates a new abstract repository sql query 4.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    protected AbstractRepositorySqlQuery4(AbstractRepositorySqlQuery4<?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * Instantiates a new abstract repository sql query 4.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractRepositorySqlQuery4(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(3, queryRelation, sqlPageFactory);
    }

    protected <E extends AbstractSqlConditionExpression<?, ?, ?>> E where(E conditions,
        FourArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        if (repositoriesCondtionFuntion != null) {
            conditions.addCondition(
                repositoriesCondtionFuntion.apply(new RepositoryFieldOnlyExpressionImpl<>(0, queryRelation),
                    new RepositoryFieldOnlyExpressionImpl<>(1, queryRelation),
                    new RepositoryFieldOnlyExpressionImpl<>(2, queryRelation),
                    new RepositoryFieldOnlyExpressionImpl<>(3, queryRelation)));
        }
        return conditions;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryExpression4<C, L, S, Q> configure(Consumer<DslQueryConfig> configure) {
        configure.accept(queryRelation.getConfig());
        return this;
    }
}
