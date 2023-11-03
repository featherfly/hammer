
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-15 18:02:15
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import java.util.List;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6FFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6FFFF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;

/**
 * AbstractMulitiRepositorySqlQueryConditionsGroupExpression6FFFF.
 *
 * @author zhongj
 */
public abstract class AbstractMulitiRepositorySqlQueryConditionsGroupExpression6FFFF extends
        AbstractMulitiRepositorySqlQueryConditionsGroupExpression6<RepositoryQueryConditionsGroup6FFFF,
                RepositoryQueryConditionsGroupLogic6FFFF, RepositoryQuerySortExpression6<QueryLimitExecutor4>,
                QueryLimitExecutor4>
        implements RepositoryQueryConditionsGroup6FFFF, RepositoryQueryConditionsGroupLogic6FFFF {

    /**
     * Instantiates a new abstract muliti repository sql query conditions group
     * expression 6 FFFF.
     *
     * @param parent         the parent
     * @param index          the index
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractMulitiRepositorySqlQueryConditionsGroupExpression6FFFF(
            RepositoryQueryConditionsGroupLogic6FFFF parent, int index, RepositorySqlQueryRelation queryRelation,
            SqlPageFactory sqlPageFactory) {
        super(parent, index, queryRelation, sqlPageFactory);
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
