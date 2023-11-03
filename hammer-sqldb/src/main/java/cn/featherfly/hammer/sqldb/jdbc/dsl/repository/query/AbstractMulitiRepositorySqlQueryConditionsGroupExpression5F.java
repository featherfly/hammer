
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-15 18:02:15
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup5F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic5F;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;

/**
 * AbstractMulitiRepositorySqlQueryConditionsGroupExpression5F.
 *
 * @author zhongj
 */
public abstract class AbstractMulitiRepositorySqlQueryConditionsGroupExpression5F extends
        AbstractMulitiRepositorySqlQueryConditionsGroupExpression5<RepositoryQueryConditionsGroup5F,
                RepositoryQueryConditionsGroupLogic5F, RepositoryQuerySortExpression5<QueryLimitExecutor>,
                QueryLimitExecutor>
        implements RepositoryQueryConditionsGroup5F, RepositoryQueryConditionsGroupLogic5F {

    /**
     * Instantiates a new abstract muliti repository sql query conditions group
     * expression 5 F.
     *
     * @param parent         the parent
     * @param index          the index
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractMulitiRepositorySqlQueryConditionsGroupExpression5F(RepositoryQueryConditionsGroupLogic5F parent,
            int index, RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(parent, index, queryRelation, sqlPageFactory);
    }
}
