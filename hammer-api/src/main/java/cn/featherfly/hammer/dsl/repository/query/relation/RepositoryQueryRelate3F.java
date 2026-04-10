
package cn.featherfly.hammer.dsl.repository.query.relation;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery2;
import cn.featherfly.data.query.QueryMapperSetter2;
import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression4;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup4FF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic4FF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression4FF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression4;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression4;

/**
 * The Interface RepositoryQueryRelate3FRR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate3F extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched3FF>,
    RepositoryQueryExpression4<RepositoryQueryConditionsGroup4FF, RepositoryQueryConditionsGroupLogic4FF,
        RepositoryQuerySortExpression4<RepositoryQuerySortedExpression4FF, LimitAwareQuery2<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression4FF, LimitAwareQuery2<Map<String, Serializable>>>,
    //    QueryLimitExecutor2,
    RepositoryJoin<RepositoryOnExpression4<RepositoryQueryRelate4F>, RepositoryQueryRelate4F>, QueryMapperSetter2 {
}
