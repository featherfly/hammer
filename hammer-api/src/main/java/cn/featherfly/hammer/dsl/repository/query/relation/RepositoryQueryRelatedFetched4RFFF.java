
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression5;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup5FFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic5FFFF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;

/**
 * The Interface RepositoryQueryRelatedFetched4RFFF.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelatedFetched4RFFF
    extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched4RFFF>,
    RepositoryQueryExpression5<RepositoryQueryConditionsGroup5FFFF, RepositoryQueryConditionsGroupLogic5FFFF,
        RepositoryQuerySortExpression5<QueryLimitExecutor4>, QueryLimitExecutor4>,
    QueryLimitExecutor4,
    RepositoryJoin<RepositoryOnExpression5<RepositoryQueryRelate5RFFFR>,
        RepositoryQueryRelate5RFFFR> {

}
