
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery3;
import cn.featherfly.data.query.QueryMapperSetter3;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup5FFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic5FFF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression5FFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * repository sql query expression 5FFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryExpression5FFF extends
    AbstractMulitiRepositorySqlQueryConditionsGroupExpression5<RepositoryQueryConditionsGroup5FFF,
        RepositoryQueryConditionsGroupLogic5FFF,
        RepositoryQuerySortExpression5<RepositoryQuerySortedExpression5FFF,
            LimitAwareQuery3<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression5FFF, LimitAwareQuery3<Map<String, Serializable>>>
    implements RepositoryQueryConditionsGroup5FFF, RepositoryQueryConditionsGroupLogic5FFF, QueryMapperSetter3 {

    /**
     * Instantiates a new sql query expression.
     *
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryExpression5FFF(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        this(null, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query expression.
     *
     * @param parent the parent
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    RepositorySqlQueryExpression5FFF(RepositoryQueryConditionsGroupLogic5FFF parent,
        RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        // first level
        super(parent, 0, queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryConditionsGroup5FFF createGroup(RepositoryQueryConditionsGroupLogic5FFF parent) {
        return new RepositorySqlQueryExpression5FFF(parent, repositoryRelation, sqlPageFactory);
    }
}
