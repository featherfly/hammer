
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-15 18:02:15
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup2F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic2F;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;

/**
 * AbstractMulitiRepositorySqlQueryConditionsGroupExpression2F.
 *
 * @author zhongj
 */
public abstract class AbstractMulitiRepositorySqlQueryConditionsGroupExpression2F extends
        AbstractMulitiRepositorySqlQueryConditionsGroupExpression2<RepositoryQueryConditionsGroup2F,
                RepositoryQueryConditionsGroupLogic2F, RepositoryQuerySortExpression2<QueryLimitExecutor>,
                QueryLimitExecutor>
        implements RepositoryQueryConditionsGroup2F, RepositoryQueryConditionsGroupLogic2F {

    /**
     * Instantiates a new abstract muliti repository sql query conditions group
     * expression 2 F.
     *
     * @param parent         the parent
     * @param index          the index
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractMulitiRepositorySqlQueryConditionsGroupExpression2F(RepositoryQueryConditionsGroupLogic2F parent,
            int index, RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(parent, index, queryRelation, sqlPageFactory);
    }
}
