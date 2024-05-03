
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup3F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic3F;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * repository sql query expression 3F.
 *
 * @author zhongj
 */
public class RepositorySqlQueryExpression3F extends
    AbstractMulitiRepositorySqlQueryConditionsGroupExpression3<RepositoryQueryConditionsGroup3F,
        RepositoryQueryConditionsGroupLogic3F, RepositoryQuerySortExpression3<QueryLimitExecutor>, QueryLimitExecutor>
    implements RepositoryQueryConditionsGroup3F, RepositoryQueryConditionsGroupLogic3F {

    /**
     * Instantiates a new sql query expression.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryExpression3F(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        this(null, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query expression.
     *
     * @param parent         the parent
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    RepositorySqlQueryExpression3F(RepositoryQueryConditionsGroupLogic3F parent,
        RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        // first level
        super(parent, 0, queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryConditionsGroup3F createGroup(RepositoryQueryConditionsGroupLogic3F parent) {
        return new RepositorySqlQueryExpression3F(parent, repositoryRelation, sqlPageFactory);
    }
}
