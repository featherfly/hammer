
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import java.util.List;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup4FFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic4FFFF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;

/**
 * repository sql query expression 4FFFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryExpression4FFFF extends
    AbstractMulitiRepositorySqlQueryConditionsGroupExpression4<RepositoryQueryConditionsGroup4FFFF,
        RepositoryQueryConditionsGroupLogic4FFFF, RepositoryQuerySortExpression4<QueryLimitExecutor4>,
        QueryLimitExecutor4>
    implements RepositoryQueryConditionsGroup4FFFF, RepositoryQueryConditionsGroupLogic4FFFF {

    /**
     * Instantiates a new sql query expression.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryExpression4FFFF(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        this(null, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query expression.
     *
     * @param parent         the parent
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    RepositorySqlQueryExpression4FFFF(RepositoryQueryConditionsGroupLogic4FFFF parent,
        RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        // first level
        super(parent, 0, queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryConditionsGroup4FFFF createGroup(RepositoryQueryConditionsGroupLogic4FFFF parent) {
        return new RepositorySqlQueryExpression4FFFF(parent, repositoryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4> List<Tuple4<E1, E2, E3, E4>> list(Tuple4<String, String, String, String> prefixes,
        Class<E1> type1, Class<E2> type2, Class<E3> type3, Class<E4> type4) {
        return repositorySqlQueryConditionGroupQuery.list(prefixes, type1, type2, type3, type4);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4> PaginationResults<Tuple4<E1, E2, E3, E4>> pagination(
        Tuple4<String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2, Class<E3> type3,
        Class<E4> type4) {
        return repositorySqlQueryConditionGroupQuery.pagination(prefixes, type1, type2, type3, type4);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4> Tuple4<E1, E2, E3, E4> single(Tuple4<String, String, String, String> prefixes,
        Class<E1> type1, Class<E2> type2, Class<E3> type3, Class<E4> type4) {
        return repositorySqlQueryConditionGroupQuery.single(prefixes, type1, type2, type3, type4);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2, E3, E4> Tuple4<E1, E2, E3, E4> unique(Tuple4<String, String, String, String> prefixes,
        Class<E1> type1, Class<E2> type2, Class<E3> type3, Class<E4> type4) {
        return repositorySqlQueryConditionGroupQuery.unique(prefixes, type1, type2, type3, type4);
    }
}
