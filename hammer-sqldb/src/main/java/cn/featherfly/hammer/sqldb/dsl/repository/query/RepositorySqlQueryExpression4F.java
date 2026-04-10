
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery1;
import cn.featherfly.data.query.QueryMapperSetter1;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup4F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic4F;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression4F;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * repository sql query expression 4F.
 *
 * @author zhongj
 */
public class RepositorySqlQueryExpression4F extends
    AbstractMulitiRepositorySqlQueryConditionsGroupExpression4<RepositoryQueryConditionsGroup4F,
        RepositoryQueryConditionsGroupLogic4F,
        RepositoryQuerySortExpression4<RepositoryQuerySortedExpression4F, LimitAwareQuery1<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression4F, LimitAwareQuery1<Map<String, Serializable>>>
    implements RepositoryQueryConditionsGroup4F, RepositoryQueryConditionsGroupLogic4F, QueryMapperSetter1 {

    /**
     * Instantiates a new sql query expression.
     *
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryExpression4F(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        this(null, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query expression.
     *
     * @param parent the parent
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    RepositorySqlQueryExpression4F(RepositoryQueryConditionsGroupLogic4F parent,
        RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        // first level
        super(parent, 0, queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryConditionsGroup4F createGroup(RepositoryQueryConditionsGroupLogic4F parent) {
        return new RepositorySqlQueryExpression4F(parent, repositoryRelation, sqlPageFactory);
    }

}
