
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.api.Queryable;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.QueryValueConditionLimit;
import cn.featherfly.hammer.expression.query.QueryValueLimitExecutor;
import cn.featherfly.hammer.expression.query.QueryValueOneExecutor;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupLogicExpression;

/**
 * repository query value conditions group logic expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 */
public interface RepositoryQueryValueConditionsGroupLogicExpression<
        C extends RepositoryQueryValueConditionsGroupExpression<C, L, S>,
        L extends RepositoryQueryValueConditionsGroupLogicExpression<C, L, S>,
        S extends RepositoryQueryValueSortExpression> extends RepositoryConditionsGroupLogicExpression<C, L>,
        Queryable<S>, QueryValueConditionLimit, QueryValueLimitExecutor, QueryCountExecutor, QueryValueOneExecutor {

}
