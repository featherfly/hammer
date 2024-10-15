
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.util.List;

import cn.featherfly.common.tuple.Tuple5;

import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup5FFFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic5FFFFF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * repository sql query expression 5FFFFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryExpression5FFFFF extends
    AbstractMulitiRepositorySqlQueryConditionsGroupExpression5<RepositoryQueryConditionsGroup5FFFFF,
        RepositoryQueryConditionsGroupLogic5FFFFF, RepositoryQuerySortExpression5<QueryLimitExecutor5>,
        QueryLimitExecutor5>
    implements RepositoryQueryConditionsGroup5FFFFF, RepositoryQueryConditionsGroupLogic5FFFFF {

    /**
     * Instantiates a new sql query expression.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryExpression5FFFFF(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        this(null, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query expression.
     *
     * @param parent         the parent
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    RepositorySqlQueryExpression5FFFFF(RepositoryQueryConditionsGroupLogic5FFFFF parent,
        RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        // first level
        super(parent, 0, queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryConditionsGroup5FFFFF createGroup(RepositoryQueryConditionsGroupLogic5FFFFF parent) {
        return new RepositorySqlQueryExpression5FFFFF(parent, repositoryRelation, sqlPageFactory);
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
