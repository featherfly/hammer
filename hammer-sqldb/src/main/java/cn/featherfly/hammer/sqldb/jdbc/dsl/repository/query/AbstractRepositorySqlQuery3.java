
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.function.ThreeArgusFunction;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery3;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.AbstractSqlConditionExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.RepositoryFieldOnlyExpressionImpl;

/**
 * AbstractRepositorySqlQuery3.
 *
 * @author zhongj
 * @param <R> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public abstract class AbstractRepositorySqlQuery3<R extends RepositoryQueryRelateExpression<R>,
    C extends RepositoryQueryConditionsGroupExpression3<C, L, S, Q>,
    L extends RepositoryQueryConditionsGroupLogicExpression3<C, L, S, Q>, S extends RepositoryQuerySortExpression3<Q>,
    Q extends QueryLimitExecutor> extends AbstractRepositorySqlQueryJoin<R, C, Q>
    implements RepositoryQuery3<C, L, S, Q> {

    protected static final Tuple3<Integer, Integer, Integer> RELATIONS_TUPLE = Tuples.of(0, 1, 2);

    /**
     * Instantiates a new abstract repository sql query 3.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    protected AbstractRepositorySqlQuery3(AbstractRepositorySqlQuery3<?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * Instantiates a new abstract repository sql query 3.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractRepositorySqlQuery3(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(2, queryRelation, sqlPageFactory);
    }

    protected <E extends AbstractSqlConditionExpression<?, ?, ?>> E where(E conditions,
        ThreeArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        if (repositoriesCondtionFuntion != null) {
            conditions.addCondition(
                repositoriesCondtionFuntion.apply(new RepositoryFieldOnlyExpressionImpl<>(0, queryRelation),
                    new RepositoryFieldOnlyExpressionImpl<>(1, queryRelation),
                    new RepositoryFieldOnlyExpressionImpl<>(2, queryRelation)));
        }
        return conditions;
    }
}
