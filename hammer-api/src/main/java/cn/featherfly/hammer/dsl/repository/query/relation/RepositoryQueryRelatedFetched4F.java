
package cn.featherfly.hammer.dsl.repository.query.relation;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery2;
import cn.featherfly.data.query.QueryMapperSetter2;
import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression5;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup5FF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic5FF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression5FF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;

/**
 * The Interface RepositoryQueryRelatedFetched4RRRF.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelatedFetched4F
    extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched4F>,
    RepositoryQueryExpression5<RepositoryQueryConditionsGroup5FF, RepositoryQueryConditionsGroupLogic5FF,
        RepositoryQuerySortExpression5<RepositoryQuerySortedExpression5FF, LimitAwareQuery2<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression5FF, LimitAwareQuery2<Map<String, Serializable>>>,
    //    QueryLimitExecutor2,
    RepositoryJoin<RepositoryOnExpression5<RepositoryQueryRelate5F>, RepositoryQueryRelate5F>, QueryMapperSetter2 {

}
