
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import java.util.List;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup4FFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic4FFF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;

/**
 * repository sql query expression 4FFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryExpression4FFF extends
    AbstractMulitiRepositorySqlQueryConditionsGroupExpression4<RepositoryQueryConditionsGroup4FFF,
        RepositoryQueryConditionsGroupLogic4FFF, RepositoryQuerySortExpression4<QueryLimitExecutor3>,
        QueryLimitExecutor3>
    implements RepositoryQueryConditionsGroup4FFF, RepositoryQueryConditionsGroupLogic4FFF {

    /**
     * Instantiates a new sql query expression.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryExpression4FFF(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        this(null, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query expression.
     *
     * @param parent         the parent
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    RepositorySqlQueryExpression4FFF(RepositoryQueryConditionsGroupLogic4FFF parent,
        RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        // first level
        super(parent, 0, queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryConditionsGroup4FFF createGroup(RepositoryQueryConditionsGroupLogic4FFF parent) {
        return new RepositorySqlQueryExpression4FFF(parent, repositoryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3> List<Tuple3<E1, E2, E3>> list(Tuple3<String, String, String> prefixes, Class<E1> type1,
        Class<E2> type2, Class<E3> type3) {
        return repositorySqlQueryConditionGroupQuery.list(prefixes, type1, type2, type3);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3> PaginationResults<Tuple3<E1, E2, E3>> pagination(Tuple3<String, String, String> prefixes,
        Class<E1> type1, Class<E2> type2, Class<E3> type3) {
        return repositorySqlQueryConditionGroupQuery.pagination(prefixes, type1, type2, type3);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3> Tuple3<E1, E2, E3> single(Tuple3<String, String, String> prefixes, Class<E1> type1,
        Class<E2> type2, Class<E3> type3) {
        return repositorySqlQueryConditionGroupQuery.single(prefixes, type1, type2, type3);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3> Tuple3<E1, E2, E3> unique(Tuple3<String, String, String> prefixes, Class<E1> type1,
        Class<E2> type2, Class<E3> type3) {
        return repositorySqlQueryConditionGroupQuery.unique(prefixes, type1, type2, type3);
    }
}
