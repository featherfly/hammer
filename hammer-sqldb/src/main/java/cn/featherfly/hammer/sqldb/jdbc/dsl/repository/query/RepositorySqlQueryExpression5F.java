
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup5F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic5F;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;

/**
 * repository sql query expression 5F.
 *
 * @author zhongj
 */
public class RepositorySqlQueryExpression5F extends
    AbstractMulitiRepositorySqlQueryConditionsGroupExpression5<RepositoryQueryConditionsGroup5F,
        RepositoryQueryConditionsGroupLogic5F, RepositoryQuerySortExpression5<QueryLimitExecutor>, QueryLimitExecutor>
    implements RepositoryQueryConditionsGroup5F, RepositoryQueryConditionsGroupLogic5F {

    /**
     * Instantiates a new sql query expression.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryExpression5F(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        this(null, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query expression.
     *
     * @param parent         the parent
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    RepositorySqlQueryExpression5F(RepositoryQueryConditionsGroupLogic5F parent,
        RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        // first level
        super(parent, 0, queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryConditionsGroup5F createGroup(RepositoryQueryConditionsGroupLogic5F parent) {
        return new RepositorySqlQueryExpression5F(parent, repositoryRelation, sqlPageFactory);
    }
}
