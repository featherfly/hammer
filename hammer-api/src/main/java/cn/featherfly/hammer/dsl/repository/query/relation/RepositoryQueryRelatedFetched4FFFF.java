
package cn.featherfly.hammer.dsl.repository.query.relation;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery5;
import cn.featherfly.data.query.QueryMapperSetter5;
import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression5;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup5FFFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic5FFFFF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression5FFFFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;

/**
 * The Interface RepositoryQueryRelatedFetched4FFFF.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelatedFetched4FFFF
    extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched4FFFF>,
    RepositoryQueryExpression5<RepositoryQueryConditionsGroup5FFFFF, RepositoryQueryConditionsGroupLogic5FFFFF,
        RepositoryQuerySortExpression5<RepositoryQuerySortedExpression5FFFFF,
            LimitAwareQuery5<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression5FFFFF, LimitAwareQuery5<Map<String, Serializable>>>,
    //    QueryLimitExecutor5,
    RepositoryJoin<RepositoryOnExpression5<RepositoryQueryRelate5FFFF>, RepositoryQueryRelate5FFFF>,
    QueryMapperSetter5 {

}
