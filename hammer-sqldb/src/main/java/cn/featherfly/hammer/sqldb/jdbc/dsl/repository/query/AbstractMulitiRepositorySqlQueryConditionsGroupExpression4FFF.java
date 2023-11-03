
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-15 18:02:15
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
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
 * AbstractMulitiRepositorySqlQueryConditionsGroupExpression4FFF.
 *
 * @author zhongj
 */
public abstract class AbstractMulitiRepositorySqlQueryConditionsGroupExpression4FFF extends
        AbstractMulitiRepositorySqlQueryConditionsGroupExpression4<RepositoryQueryConditionsGroup4FFF,
                RepositoryQueryConditionsGroupLogic4FFF, RepositoryQuerySortExpression4<QueryLimitExecutor3>,
                QueryLimitExecutor3>
        implements RepositoryQueryConditionsGroup4FFF, RepositoryQueryConditionsGroupLogic4FFF {

    /**
     * Instantiates a new abstract muliti repository sql query conditions group
     * expression 4 FFF.
     *
     * @param parent         the parent
     * @param index          the index
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractMulitiRepositorySqlQueryConditionsGroupExpression4FFF(
            RepositoryQueryConditionsGroupLogic4FFF parent, int index, RepositorySqlQueryRelation queryRelation,
            SqlPageFactory sqlPageFactory) {
        super(parent, index, queryRelation, sqlPageFactory);
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
