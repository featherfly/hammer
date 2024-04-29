
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression5;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup5FF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic5FF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;

/**
 * The Interface RepositoryQueryRelate4FRRR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate4FRRR extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched4FRRF>,
    RepositoryQueryExpression5<RepositoryQueryConditionsGroup5FF, RepositoryQueryConditionsGroupLogic5FF,
        RepositoryQuerySortExpression5<QueryLimitExecutor2>, QueryLimitExecutor2>,
    QueryLimitExecutor2,
    RepositoryJoin<RepositoryOnExpression5<RepositoryQueryRelate5FRRRR>,
        RepositoryQueryRelate5FRRRR> {

}
