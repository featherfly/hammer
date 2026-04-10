
package cn.featherfly.hammer.dsl.repository.query.relation;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery2;
import cn.featherfly.data.query.QueryMapperSetter2;
import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression3;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup3FF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic3FF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression3FF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression3;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression3;

/**
 * The Interface RepositoryQueryRelate2RR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate2F extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched2FF>,
    RepositoryQueryExpression3<RepositoryQueryConditionsGroup3FF, RepositoryQueryConditionsGroupLogic3FF,
        RepositoryQuerySortExpression3<RepositoryQuerySortedExpression3FF, LimitAwareQuery2<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression3FF, LimitAwareQuery2<Map<String, Serializable>>>,
    //    QueryLimitExecutor2,
    RepositoryJoin<RepositoryOnExpression3<RepositoryQueryRelate3F>, RepositoryQueryRelate3F>, QueryMapperSetter2 {

}
