
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.util.List;

import cn.featherfly.common.tuple.Tuple6;

import cn.featherfly.common.lang.Console;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6FFFFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6FFFFFF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;
import cn.featherfly.hammer.sqldb.Constants;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * repository sql query expression 6FFFFFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryExpression6FFFFFF extends
    AbstractMulitiRepositorySqlQueryConditionsGroupExpression6<RepositoryQueryConditionsGroup6FFFFFF,
        RepositoryQueryConditionsGroupLogic6FFFFFF, RepositoryQuerySortExpression6<QueryLimitExecutor6>,
        QueryLimitExecutor6>
    implements RepositoryQueryConditionsGroup6FFFFFF, RepositoryQueryConditionsGroupLogic6FFFFFF {

    /**
     * Instantiates a new sql query expression.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryExpression6FFFFFF(RepositorySqlQueryRelation queryRelation,
        SqlPageFactory sqlPageFactory) {
        this(null, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query expression.
     *
     * @param parent         the parent
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    RepositorySqlQueryExpression6FFFFFF(RepositoryQueryConditionsGroupLogic6FFFFFF parent,
        RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        // first level
        super(parent, 0, queryRelation, sqlPageFactory);
        if (Constants.DEBUG) {
            Console.log("{} end at time {}", this.getClass().getName(), System.currentTimeMillis());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryConditionsGroup6FFFFFF createGroup(RepositoryQueryConditionsGroupLogic6FFFFFF parent) {
        return new RepositorySqlQueryExpression6FFFFFF(parent, repositoryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4, E5, E6> List<Tuple6<E1, E2, E3, E4, E5, E6>> list(
        Tuple6<String, String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2,
        Class<E3> type3, Class<E4> type4, Class<E5> type5, Class<E6> type6) {
        return repositorySqlQueryConditionGroupQuery.list(prefixes, type1, type2, type3, type4, type5, type6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4, E5, E6> PaginationResults<Tuple6<E1, E2, E3, E4, E5, E6>> pagination(
        Tuple6<String, String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2,
        Class<E3> type3, Class<E4> type4, Class<E5> type5, Class<E6> type6) {
        return repositorySqlQueryConditionGroupQuery.pagination(prefixes, type1, type2, type3, type4, type5, type6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4, E5, E6> Tuple6<E1, E2, E3, E4, E5, E6> single(
        Tuple6<String, String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2,
        Class<E3> type3, Class<E4> type4, Class<E5> type5, Class<E6> type6) {
        return repositorySqlQueryConditionGroupQuery.single(prefixes, type1, type2, type3, type4, type5, type6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4, E5, E6> Tuple6<E1, E2, E3, E4, E5, E6> unique(
        Tuple6<String, String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2,
        Class<E3> type3, Class<E4> type4, Class<E5> type5, Class<E6> type6) {
        return repositorySqlQueryConditionGroupQuery.unique(prefixes, type1, type2, type3, type4, type5, type6);
    }
}
