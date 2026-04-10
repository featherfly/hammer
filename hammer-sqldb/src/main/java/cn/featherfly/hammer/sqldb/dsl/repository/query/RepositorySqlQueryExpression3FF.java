
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery2;
import cn.featherfly.data.query.QueryMapperSetter2;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup3FF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic3FF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression3FF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * repository sql query expression 3FF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryExpression3FF extends
    AbstractMulitiRepositorySqlQueryConditionsGroupExpression3<RepositoryQueryConditionsGroup3FF,
        RepositoryQueryConditionsGroupLogic3FF,
        RepositoryQuerySortExpression3<RepositoryQuerySortedExpression3FF, LimitAwareQuery2<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression3FF, LimitAwareQuery2<Map<String, Serializable>>>
    implements RepositoryQueryConditionsGroup3FF, RepositoryQueryConditionsGroupLogic3FF, QueryMapperSetter2 {

    /**
     * Instantiates a new sql query expression.
     *
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryExpression3FF(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        this(null, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query expression.
     *
     * @param parent the parent
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    RepositorySqlQueryExpression3FF(RepositoryQueryConditionsGroupLogic3FF parent,
        RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        // first level
        super(parent, 0, queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryConditionsGroup3FF createGroup(RepositoryQueryConditionsGroupLogic3FF parent) {
        return new RepositorySqlQueryExpression3FF(parent, repositoryRelation, sqlPageFactory);
    }

}
