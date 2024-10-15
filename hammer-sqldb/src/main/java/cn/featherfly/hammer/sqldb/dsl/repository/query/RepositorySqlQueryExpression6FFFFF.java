
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.util.List;

import cn.featherfly.common.tuple.Tuple5;

import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6FFFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6FFFFF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * repository sql query expression 6FFFFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryExpression6FFFFF extends
    AbstractMulitiRepositorySqlQueryConditionsGroupExpression6<RepositoryQueryConditionsGroup6FFFFF,
        RepositoryQueryConditionsGroupLogic6FFFFF, RepositoryQuerySortExpression6<QueryLimitExecutor5>,
        QueryLimitExecutor5>
    implements RepositoryQueryConditionsGroup6FFFFF, RepositoryQueryConditionsGroupLogic6FFFFF {

    /**
     * Instantiates a new sql query expression.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryExpression6FFFFF(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        this(null, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query expression.
     *
     * @param parent         the parent
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    RepositorySqlQueryExpression6FFFFF(RepositoryQueryConditionsGroupLogic6FFFFF parent,
        RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        // first level
        super(parent, 0, queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryConditionsGroup6FFFFF createGroup(RepositoryQueryConditionsGroupLogic6FFFFF parent) {
        return new RepositorySqlQueryExpression6FFFFF(parent, repositoryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4, E5> List<Tuple5<E1, E2, E3, E4, E5>> list(
        Tuple5<String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2, Class<E3> type3,
        Class<E4> type4, Class<E5> type5) {
        return repositorySqlQueryConditionGroupQuery.list(prefixes, type1, type2, type3, type4, type5);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4, E5> PaginationResults<Tuple5<E1, E2, E3, E4, E5>> pagination(
        Tuple5<String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2, Class<E3> type3,
        Class<E4> type4, Class<E5> type5) {
        return repositorySqlQueryConditionGroupQuery.pagination(prefixes, type1, type2, type3, type4, type5);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4, E5> Tuple5<E1, E2, E3, E4, E5> single(
        Tuple5<String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2, Class<E3> type3,
        Class<E4> type4, Class<E5> type5) {
        return repositorySqlQueryConditionGroupQuery.single(prefixes, type1, type2, type3, type4, type5);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4, E5> Tuple5<E1, E2, E3, E4, E5> unique(
        Tuple5<String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2, Class<E3> type3,
        Class<E4> type4, Class<E5> type5) {
        return repositorySqlQueryConditionGroupQuery.unique(prefixes, type1, type2, type3, type4, type5);
    }
}
