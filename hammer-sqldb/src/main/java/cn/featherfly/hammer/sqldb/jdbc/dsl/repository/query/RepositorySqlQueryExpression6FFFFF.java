
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6FFFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6FFFFF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;

/**
 * repository sql query expression 6FFFFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryExpression6FFFFF
        extends AbstractMulitiRepositorySqlQueryConditionsGroupExpression6FFFFF {

    /**
     * Instantiates a new sql query expression.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryExpression6FFFFF(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        this(null, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query expression.
     *
     * @param parent         the parent
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    RepositorySqlQueryExpression6FFFFF(RepositoryQueryConditionsGroupLogic6FFFFF parent,
            RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        // first level
        super(parent, 0, queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryConditionsGroup6FFFFF createGroup(RepositoryQueryConditionsGroupLogic6FFFFF parent) {
        return new RepositorySqlQueryExpression6FFFFF(parent, repositoryRelation, sqlPageFactory);
    }
}
