
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.util.function.BiFunction;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.hammer.config.dsl.DslQueryConfig;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery2;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;
import cn.featherfly.hammer.sqldb.dsl.condition.AbstractSqlConditionExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.condition.field.RepositoryFieldOnlyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * AbstractRepositorySqlQuery2.
 *
 * @author zhongj
 * @param <R> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public abstract class AbstractRepositorySqlQuery2<R extends RepositoryQueryRelateExpression<R>,
    C extends RepositoryQueryConditionsGroupExpression2<C, L, S, Q>,
    L extends RepositoryQueryConditionsGroupLogicExpression2<C, L, S, Q>, S extends RepositoryQuerySortExpression2<Q>,
    Q extends QueryLimitExecutor> extends AbstractRepositorySqlQueryJoin<R, C, Q>
    implements RepositoryQuery2<C, L, S, Q> {

    protected static final Tuple2<Integer, Integer> RELATIONS_TUPLE = Tuples.of(0, 1);

    /**
     * Instantiates a new abstract repository sql query 2.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    protected AbstractRepositorySqlQuery2(AbstractRepositorySqlQuery2<?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * Instantiates a new abstract repository sql query 2.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractRepositorySqlQuery2(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(1, queryRelation, sqlPageFactory);
    }

    protected <E extends AbstractSqlConditionExpression<?, ?, ?>> E where(E conditions,
        BiFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        if (repositoriesCondtionFuntion != null) {
            conditions.addCondition(
                repositoriesCondtionFuntion.apply(new RepositoryFieldOnlyExpressionImpl<>(0, queryRelation),
                    new RepositoryFieldOnlyExpressionImpl<>(1, queryRelation)));
        }
        return conditions;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryExpression2<C, L, S, Q> configure(Consumer<DslQueryConfig> configure) {
        configure.accept(queryRelation.getConfig());
        return this;
    }
}
