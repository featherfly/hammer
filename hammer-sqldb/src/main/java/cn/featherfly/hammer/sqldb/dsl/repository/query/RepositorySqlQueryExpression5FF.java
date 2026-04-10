
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery2;
import cn.featherfly.data.query.QueryMapperSetter2;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup5FF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic5FF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression5FF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * repository sql query expression 5FF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryExpression5FF extends
    AbstractMulitiRepositorySqlQueryConditionsGroupExpression5<RepositoryQueryConditionsGroup5FF,
        RepositoryQueryConditionsGroupLogic5FF,
        RepositoryQuerySortExpression5<RepositoryQuerySortedExpression5FF, LimitAwareQuery2<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression5FF, LimitAwareQuery2<Map<String, Serializable>>>
    implements RepositoryQueryConditionsGroup5FF, RepositoryQueryConditionsGroupLogic5FF, QueryMapperSetter2 {

    /**
     * Instantiates a new sql query expression.
     *
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryExpression5FF(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        this(null, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query expression.
     *
     * @param parent the parent
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    RepositorySqlQueryExpression5FF(RepositoryQueryConditionsGroupLogic5FF parent,
        RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        // first level
        super(parent, 0, queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryConditionsGroup5FF createGroup(RepositoryQueryConditionsGroupLogic5FF parent) {
        return new RepositorySqlQueryExpression5FF(parent, repositoryRelation, sqlPageFactory);
    }
}
