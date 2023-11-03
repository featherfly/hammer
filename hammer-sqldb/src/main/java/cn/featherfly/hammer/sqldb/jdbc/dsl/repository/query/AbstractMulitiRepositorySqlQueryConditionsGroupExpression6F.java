
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-16 18:02:16
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6F;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;

/**
 * AbstractMulitiRepositorySqlQueryConditionsGroupExpression6F.
 *
 * @author zhongj
 */
public abstract class AbstractMulitiRepositorySqlQueryConditionsGroupExpression6F extends
        AbstractMulitiRepositorySqlQueryConditionsGroupExpression6<RepositoryQueryConditionsGroup6F,
                RepositoryQueryConditionsGroupLogic6F, RepositoryQuerySortExpression6<QueryLimitExecutor>,
                QueryLimitExecutor>
        implements RepositoryQueryConditionsGroup6F, RepositoryQueryConditionsGroupLogic6F {

    /**
     * Instantiates a new abstract muliti repository sql query conditions group
     * expression 6 F.
     *
     * @param parent         the parent
     * @param index          the index
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractMulitiRepositorySqlQueryConditionsGroupExpression6F(RepositoryQueryConditionsGroupLogic6F parent,
            int index, RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(parent, index, queryRelation, sqlPageFactory);
    }
}
