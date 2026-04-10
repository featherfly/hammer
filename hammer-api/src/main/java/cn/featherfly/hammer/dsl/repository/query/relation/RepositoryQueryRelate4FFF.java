
package cn.featherfly.hammer.dsl.repository.query.relation;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery4;
import cn.featherfly.data.query.QueryMapperSetter4;
import cn.featherfly.hammer.dsl.repository.RepositoryJoin;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression5;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup5FFFF;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic5FFFF;
import cn.featherfly.hammer.dsl.repository.query.sort.RepositoryQuerySortedExpression5FFFF;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression5;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression5;

/**
 * The Interface RepositoryQueryRelate4FFFR.
 *
 * @author zhongj
 */
public interface RepositoryQueryRelate4FFF extends RepositoryQueryRelateExpression<RepositoryQueryRelatedFetched4FFFF>,
    RepositoryQueryExpression5<RepositoryQueryConditionsGroup5FFFF, RepositoryQueryConditionsGroupLogic5FFFF,
        RepositoryQuerySortExpression5<RepositoryQuerySortedExpression5FFFF,
            LimitAwareQuery4<Map<String, Serializable>>>,
        RepositoryQuerySortedExpression5FFFF, LimitAwareQuery4<Map<String, Serializable>>>,
    //    QueryLimitExecutor4,
    RepositoryJoin<RepositoryOnExpression5<RepositoryQueryRelate5FFF>, RepositoryQueryRelate5FFF>, QueryMapperSetter4 {
}
