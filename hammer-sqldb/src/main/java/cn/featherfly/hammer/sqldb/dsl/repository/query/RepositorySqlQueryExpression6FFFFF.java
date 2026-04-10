
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery5;
import cn.featherfly.data.query.QueryMapperSetter5;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup6FFFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic6FFFFF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression6FFFFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression6;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * repository sql query expression 6FFFFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryExpression6FFFFF extends
    AbstractMulitiRepositorySqlQueryConditionsGroupExpression6<RepositoryQueryConditionsGroup6FFFFF,
        RepositoryQueryConditionsGroupLogic6FFFFF,
        RepositoryQuerySortExpression6<RepositoryQuerySortedExpression6FFFFF,
            LimitAwareQuery5<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression6FFFFF, LimitAwareQuery5<Map<String, Serializable>>>
    implements RepositoryQueryConditionsGroup6FFFFF, RepositoryQueryConditionsGroupLogic6FFFFF, QueryMapperSetter5 {

    /**
     * Instantiates a new sql query expression.
     *
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryExpression6FFFFF(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        this(null, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query expression.
     *
     * @param parent the parent
     * @param queryRelation the query relation
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
