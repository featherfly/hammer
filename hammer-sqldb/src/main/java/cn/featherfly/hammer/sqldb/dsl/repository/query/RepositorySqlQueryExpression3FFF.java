
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery3;
import cn.featherfly.data.query.QueryMapperSetter3;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup3FFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic3FFF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression3FFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * repository sql query expression 3FFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryExpression3FFF extends
    AbstractMulitiRepositorySqlQueryConditionsGroupExpression3<RepositoryQueryConditionsGroup3FFF,
        RepositoryQueryConditionsGroupLogic3FFF,
        RepositoryQuerySortExpression3<RepositoryQuerySortedExpression3FFF,
            LimitAwareQuery3<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression3FFF, LimitAwareQuery3<Map<String, Serializable>>>
    implements RepositoryQueryConditionsGroup3FFF, RepositoryQueryConditionsGroupLogic3FFF, QueryMapperSetter3 {

    /**
     * Instantiates a new sql query expression.
     *
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryExpression3FFF(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        this(null, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query expression.
     *
     * @param parent the parent
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    RepositorySqlQueryExpression3FFF(RepositoryQueryConditionsGroupLogic3FFF parent,
        RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        // first level
        super(parent, 0, queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryConditionsGroup3FFF createGroup(RepositoryQueryConditionsGroupLogic3FFF parent) {
        return new RepositorySqlQueryExpression3FFF(parent, repositoryRelation, sqlPageFactory);
    }
}
