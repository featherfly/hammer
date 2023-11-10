
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import com.speedment.common.tuple.Tuple6;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery6;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupLogicExpression6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;

/**
 * AbstractRepositorySqlQuery6.
 *
 * @author zhongj
 * @param <R> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public abstract class AbstractRepositorySqlQuery6<R extends RepositoryQueryRelateExpression<R>,
        C extends RepositoryQueryConditionsGroupExpression6<C, L, S, Q>,
        L extends RepositoryQueryConditionsGroupLogicExpression6<C, L, S, Q>,
        S extends RepositoryQuerySortExpression6<Q>, Q extends QueryLimitExecutor>
        extends AbstractRepositorySqlQueryJoin<R, C, Q> implements RepositoryQuery6<C, L, S, Q> {

    protected static final Tuple6<Integer, Integer, Integer, Integer, Integer,
            Integer> RELATIONS_TUPLE = Tuples.of(0, 1, 2, 3, 4, 5);

    /**
     * Instantiates a new abstract repository sql query 6.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    protected AbstractRepositorySqlQuery6(AbstractRepositorySqlQuery6<?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * Instantiates a new abstract repository sql query 6.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractRepositorySqlQuery6(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(5, queryRelation, sqlPageFactory);
    }
}
