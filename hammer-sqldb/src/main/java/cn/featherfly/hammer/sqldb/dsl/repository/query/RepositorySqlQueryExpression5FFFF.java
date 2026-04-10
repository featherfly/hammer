
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery4;
import cn.featherfly.data.query.QueryMapperSetter4;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup5FFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic5FFFF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression5FFFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * repository sql query expression 5FFFF.
 *
 * @author zhongj
 */
public class RepositorySqlQueryExpression5FFFF extends
    AbstractMulitiRepositorySqlQueryConditionsGroupExpression5<RepositoryQueryConditionsGroup5FFFF,
        RepositoryQueryConditionsGroupLogic5FFFF,
        RepositoryQuerySortExpression5<RepositoryQuerySortedExpression5FFFF,
            LimitAwareQuery4<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression5FFFF, LimitAwareQuery4<Map<String, Serializable>>>
    implements RepositoryQueryConditionsGroup5FFFF, RepositoryQueryConditionsGroupLogic5FFFF, QueryMapperSetter4 {

    /**
     * Instantiates a new sql query expression.
     *
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryExpression5FFFF(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        this(null, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query expression.
     *
     * @param parent the parent
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    RepositorySqlQueryExpression5FFFF(RepositoryQueryConditionsGroupLogic5FFFF parent,
        RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        // first level
        super(parent, 0, queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryConditionsGroup5FFFF createGroup(RepositoryQueryConditionsGroupLogic5FFFF parent) {
        return new RepositorySqlQueryExpression5FFFF(parent, repositoryRelation, sqlPageFactory);
    }
}
