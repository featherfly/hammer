
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery4;
import cn.featherfly.data.query.QueryMapperSetter4;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup4FFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic4FFFF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression4FFFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * repository sql query expression 4FFFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryExpression4FFFF extends
    AbstractMulitiRepositorySqlQueryConditionsGroupExpression4<RepositoryQueryConditionsGroup4FFFF,
        RepositoryQueryConditionsGroupLogic4FFFF,
        RepositoryQuerySortExpression4<RepositoryQuerySortedExpression4FFFF,
            LimitAwareQuery4<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression4FFFF, LimitAwareQuery4<Map<String, Serializable>>>
    implements RepositoryQueryConditionsGroup4FFFF, RepositoryQueryConditionsGroupLogic4FFFF, QueryMapperSetter4 {

    /**
     * Instantiates a new sql query expression.
     *
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryExpression4FFFF(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        this(null, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query expression.
     *
     * @param parent the parent
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    RepositorySqlQueryExpression4FFFF(RepositoryQueryConditionsGroupLogic4FFFF parent,
        RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        // first level
        super(parent, 0, queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryConditionsGroup4FFFF createGroup(RepositoryQueryConditionsGroupLogic4FFFF parent) {
        return new RepositorySqlQueryExpression4FFFF(parent, repositoryRelation, sqlPageFactory);
    }

}
