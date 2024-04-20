
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6F;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;

/**
 * repository sql query expression 6F.
 *
 * @author zhongj
 */
public class RepositorySqlQueryExpression6F extends
    AbstractMulitiRepositorySqlQueryConditionsGroupExpression6<RepositoryQueryConditionsGroup6F,
        RepositoryQueryConditionsGroupLogic6F, RepositoryQuerySortExpression6<QueryLimitExecutor>, QueryLimitExecutor>
    implements RepositoryQueryConditionsGroup6F, RepositoryQueryConditionsGroupLogic6F {

    /**
     * Instantiates a new sql query expression.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryExpression6F(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        this(null, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query expression.
     *
     * @param parent         the parent
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    RepositorySqlQueryExpression6F(RepositoryQueryConditionsGroupLogic6F parent,
        RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        // first level
        super(parent, 0, queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryConditionsGroup6F createGroup(RepositoryQueryConditionsGroupLogic6F parent) {
        return new RepositorySqlQueryExpression6F(parent, repositoryRelation, sqlPageFactory);
    }
}
