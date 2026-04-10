
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery2;
import cn.featherfly.data.query.QueryMapperSetter2;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup2FF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic2FF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression2FF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression2;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * repository sql query expression2FF .
 *
 * @author zhongj
 */
public class RepositorySqlQueryExpression2FF extends
    AbstractMulitiRepositorySqlQueryConditionsGroupExpression2<RepositoryQueryConditionsGroup2FF,
        RepositoryQueryConditionsGroupLogic2FF,
        RepositoryQuerySortExpression2<RepositoryQuerySortedExpression2FF, LimitAwareQuery2<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression2FF, LimitAwareQuery2<Map<String, Serializable>>>
    implements RepositoryQueryConditionsGroup2FF, RepositoryQueryConditionsGroupLogic2FF, QueryMapperSetter2 {
    // FIXME 编译慢，调整层次， 去除 RepositoryQueryConditionsGroup2FF 这个接口层次，
    // 因为用泛型就能搞定 AbstractMulitiRepositorySqlQueryConditionsGroupExpression2
    /**
     * Instantiates a new sql query expression.
     *
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    public RepositorySqlQueryExpression2FF(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        this(null, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new repository sql query expression.
     *
     * @param parent the parent
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    RepositorySqlQueryExpression2FF(RepositoryQueryConditionsGroupLogic2FF parent,
        RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        // first level
        super(parent, 0, queryRelation, sqlPageFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryQueryConditionsGroup2FF createGroup(RepositoryQueryConditionsGroupLogic2FF parent) {
        return new RepositorySqlQueryExpression2FF(parent, repositoryRelation, sqlPageFactory);
    }

}
