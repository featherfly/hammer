
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import cn.featherfly.common.lang.Console;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6FFFFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6FFFFFF;
import cn.featherfly.hammer.sqldb.Constants;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;

/**
 * repository sql query expression 6FFFFFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryExpression6FFFFFF
    extends AbstractMulitiRepositorySqlQueryConditionsGroupExpression6FFFFFF {

    /**
     * Instantiates a new sql query expression.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryExpression6FFFFFF(RepositorySqlQueryRelation queryRelation,
        SqlPageFactory sqlPageFactory) {
        this(null, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query expression.
     *
     * @param parent         the parent
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    RepositorySqlQueryExpression6FFFFFF(RepositoryQueryConditionsGroupLogic6FFFFFF parent,
        RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        // first level
        super(parent, 0, queryRelation, sqlPageFactory);
        if (Constants.DEBUG) {
            Console.log("{} end at time {}", this.getClass().getName(), System.currentTimeMillis());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryConditionsGroup6FFFFFF createGroup(RepositoryQueryConditionsGroupLogic6FFFFFF parent) {
        return new RepositorySqlQueryExpression6FFFFFF(parent, repositoryRelation, sqlPageFactory);
    }
}
