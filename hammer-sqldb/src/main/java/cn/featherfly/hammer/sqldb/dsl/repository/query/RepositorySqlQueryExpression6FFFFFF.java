
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.common.lang.Console;
import cn.featherfly.data.query.LimitAwareQuery6;
import cn.featherfly.data.query.QueryMapperSetter6;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6FFFFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6FFFFFF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression6FFFFFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;
import cn.featherfly.hammer.sqldb.Constants;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * repository sql query expression 6FFFFFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryExpression6FFFFFF extends
    AbstractMulitiRepositorySqlQueryConditionsGroupExpression6<RepositoryQueryConditionsGroup6FFFFFF,
        RepositoryQueryConditionsGroupLogic6FFFFFF,
        RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6FFFFFF,
            LimitAwareQuery6<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression6FFFFFF, LimitAwareQuery6<Map<String, Serializable>>>
    implements RepositoryQueryConditionsGroup6FFFFFF, RepositoryQueryConditionsGroupLogic6FFFFFF, QueryMapperSetter6 {

    /**
     * Instantiates a new sql query expression.
     *
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryExpression6FFFFFF(RepositorySqlQueryRelation queryRelation,
        SqlPageFactory sqlPageFactory) {
        this(null, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query expression.
     *
     * @param parent the parent
     * @param queryRelation the query relation
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
