
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-15 18:02:15
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import java.util.List;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup2FF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic2FF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;

/**
 * AbstractMulitiRepositorySqlQueryConditionsGroupExpression2FF.
 *
 * @author zhongj
 */
public abstract class AbstractMulitiRepositorySqlQueryConditionsGroupExpression2FF extends
        AbstractMulitiRepositorySqlQueryConditionsGroupExpression2<RepositoryQueryConditionsGroup2FF,
                RepositoryQueryConditionsGroupLogic2FF, RepositoryQuerySortExpression2<QueryLimitExecutor2>,
                QueryLimitExecutor2>
        implements RepositoryQueryConditionsGroup2FF, RepositoryQueryConditionsGroupLogic2FF {

    /**
     * Instantiates a new abstract muliti repository sql query conditions group
     * expression 2 FF.
     *
     * @param parent         the parent
     * @param index          the index
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractMulitiRepositorySqlQueryConditionsGroupExpression2FF(
            RepositoryQueryConditionsGroupLogic2FF parent, int index, RepositorySqlQueryRelation queryRelation,
            SqlPageFactory sqlPageFactory) {
        super(parent, index, queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2> List<Tuple2<E1, E2>> list(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2) {
        return repositorySqlQueryConditionGroupQuery.list(prefixes, type1, type2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2> PaginationResults<Tuple2<E1, E2>> pagination(Tuple2<String, String> prefixes, Class<E1> type1,
            Class<E2> type2) {
        return repositorySqlQueryConditionGroupQuery.pagination(prefixes, type1, type2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2> Tuple2<E1, E2> single(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2) {
        return repositorySqlQueryConditionGroupQuery.single(prefixes, type1, type2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E1, E2> Tuple2<E1, E2> unique(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2) {
        return repositorySqlQueryConditionGroupQuery.unique(prefixes, type1, type2);
    }
}
