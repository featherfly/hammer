
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression5;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup5F;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic5F;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;

/**
 * The Interface RepositoryQueryRelate4RRRR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate4RRRR extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched4RRRF>,
    RepositoryQueryExpression5<RepositoryQueryConditionsGroup5F, RepositoryQueryConditionsGroupLogic5F,
        RepositoryQuerySortExpression5<QueryLimitExecutor>, QueryLimitExecutor>,
    RepositoryJoin<RepositoryOnExpression5<RepositoryQueryRelate5RRRRR>,
        RepositoryQueryRelate5RRRRR> {

}
