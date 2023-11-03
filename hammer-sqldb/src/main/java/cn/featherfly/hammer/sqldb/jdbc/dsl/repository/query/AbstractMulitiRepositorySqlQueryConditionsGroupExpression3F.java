
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-15 18:02:15
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup3F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic3F;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;

/**
 * AbstractMulitiRepositorySqlQueryConditionsGroupExpression3F.
 *
 * @author zhongj
 */
public abstract class AbstractMulitiRepositorySqlQueryConditionsGroupExpression3F extends
        AbstractMulitiRepositorySqlQueryConditionsGroupExpression3<RepositoryQueryConditionsGroup3F,
                RepositoryQueryConditionsGroupLogic3F, RepositoryQuerySortExpression3<QueryLimitExecutor>,
                QueryLimitExecutor>
        implements RepositoryQueryConditionsGroup3F, RepositoryQueryConditionsGroupLogic3F {

    /**
     * Instantiates a new abstract muliti repository sql query conditions group
     * expression 3 F.
     *
     * @param parent         the parent
     * @param index          the index
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractMulitiRepositorySqlQueryConditionsGroupExpression3F(RepositoryQueryConditionsGroupLogic3F parent,
            int index, RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        super(parent, index, queryRelation, sqlPageFactory);
    }
}
