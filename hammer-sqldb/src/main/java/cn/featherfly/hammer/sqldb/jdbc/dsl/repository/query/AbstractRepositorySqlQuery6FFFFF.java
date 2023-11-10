
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import java.util.List;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQuery6;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6FFFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6FFFFF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;

/**
 * AbstractRepositorySqlQuery6FFFFF.
 *
 * @author zhongj
 * @param <R> the element type
 */
public abstract class AbstractRepositorySqlQuery6FFFFF<R extends RepositoryQueryRelateExpression<R>> extends
    AbstractRepositorySqlQuery6<R, RepositoryQueryConditionsGroup6FFFFF, RepositoryQueryConditionsGroupLogic6FFFFF,
        RepositoryQuerySortExpression6<QueryLimitExecutor5>, QueryLimitExecutor5>
    implements RepositoryQuery6<RepositoryQueryConditionsGroup6FFFFF, RepositoryQueryConditionsGroupLogic6FFFFF,
        RepositoryQuerySortExpression6<QueryLimitExecutor5>, QueryLimitExecutor5>,
    QueryLimitExecutor5 {

    /**
     * Instantiates a new abstract repository sql query 6 FFFFF.
     *
     * @param abstractRepositorySqlQuery the abstract repository sql query
     */
    public AbstractRepositorySqlQuery6FFFFF(AbstractRepositorySqlQuery6<?, ?, ?, ?, ?> abstractRepositorySqlQuery) {
        super(abstractRepositorySqlQuery);
    }

    /**
     * Instantiates a new abstract repository sql query 6 FFFFF.
     *
     * @param queryRelation  the query relation
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
    public RepositoryQuerySortExpression6<QueryLimitExecutor5> sort() {
        return new RepositorySqlQueryExpression6FFFFF(queryRelation, sqlPageFactory).sort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4, E5> List<Tuple5<E1, E2, E3, E4, E5>> list(
        Tuple5<String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2, Class<E3> type3,
        Class<E4> type4, Class<E5> type5) {
        return new RepositorySqlQueryExpression6FFFFF(queryRelation, sqlPageFactory).list(prefixes, type1, type2, type3,
            type4, type5);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4, E5> Tuple5<E1, E2, E3, E4, E5> single(
        Tuple5<String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2, Class<E3> type3,
        Class<E4> type4, Class<E5> type5) {
        return new RepositorySqlQueryExpression6FFFFF(queryRelation, sqlPageFactory).single(prefixes, type1, type2,
            type3, type4, type5);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4, E5> Tuple5<E1, E2, E3, E4, E5> unique(
        Tuple5<String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2, Class<E3> type3,
        Class<E4> type4, Class<E5> type5) {
        return new RepositorySqlQueryExpression6FFFFF(queryRelation, sqlPageFactory).unique(prefixes, type1, type2,
            type3, type4, type5);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4, E5> PaginationResults<Tuple5<E1, E2, E3, E4, E5>> pagination(
        Tuple5<String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2, Class<E3> type3,
        Class<E4> type4, Class<E5> type5) {
        return new RepositorySqlQueryExpression6FFFFF(queryRelation, sqlPageFactory).pagination(prefixes, type1, type2,
            type3, type4, type5);
    }
}
