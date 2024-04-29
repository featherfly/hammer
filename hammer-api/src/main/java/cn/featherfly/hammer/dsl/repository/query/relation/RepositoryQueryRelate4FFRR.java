
package cn.featherfly.hammer.dsl.repository.query.relation;

import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression5;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup5FFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic5FFF;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;

/**
 * The Interface RepositoryQueryRelate4FFRR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate4FFRR extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched4FFRF>,
    RepositoryQueryExpression5<RepositoryQueryConditionsGroup5FFF, RepositoryQueryConditionsGroupLogic5FFF,
        RepositoryQuerySortExpression5<QueryLimitExecutor3>, QueryLimitExecutor3>,
    QueryLimitExecutor3,
    RepositoryJoin<RepositoryOnExpression5<RepositoryQueryRelate5FFRRR>,
        RepositoryQueryRelate5FFRRR> {

}
