
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-15 18:02:15
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import java.util.List;

import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.lang.Console;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6FFFFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6FFFFFF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor6;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;
import cn.featherfly.hammer.sqldb.Constants;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;

/**
 * AbstractMulitiRepositorySqlQueryConditionsGroupExpression6FFFFFF.
 *
 * @author zhongj
 */
public abstract class AbstractMulitiRepositorySqlQueryConditionsGroupExpression6FFFFFF extends
    AbstractMulitiRepositorySqlQueryConditionsGroupExpression6<RepositoryQueryConditionsGroup6FFFFFF,
        RepositoryQueryConditionsGroupLogic6FFFFFF, RepositoryQuerySortExpression6<QueryLimitExecutor6>,
        QueryLimitExecutor6>
    implements RepositoryQueryConditionsGroup6FFFFFF, RepositoryQueryConditionsGroupLogic6FFFFFF {

    /**
     * Instantiates a new abstract muliti repository sql query conditions group
     * expression 6 FFFFFF.
     *
     * @param parent         the parent
     * @param index          the index
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractMulitiRepositorySqlQueryConditionsGroupExpression6FFFFFF(
        RepositoryQueryConditionsGroupLogic6FFFFFF parent, int index, RepositorySqlQueryRelation queryRelation,
        SqlPageFactory sqlPageFactory) {
        super(parent, index, queryRelation, sqlPageFactory);
        if (Constants.DEBUG) {
            Console.log("{} end at time {}", this.getClass().getName(), System.currentTimeMillis());
        }
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
