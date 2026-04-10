
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.data.query.LimitAwareQueryValue;
import cn.featherfly.data.query.QueryCountExecutor;
import cn.featherfly.data.query.QueryLimitSetter;
import cn.featherfly.data.query.QueryMapperSetter1;
import cn.featherfly.data.query.QueryValueLimitExecutor;
import cn.featherfly.data.query.QueryValueOneExecutor;
import cn.featherfly.hammer.expression.condition.ValueLogicExpression;
import cn.featherfly.hammer.expression.query.Queryable;
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
    L extends RepositoryQueryValueConditionsGroupLogicExpression<C, L, S>, S extends RepositoryQueryValueSortExpression>
    extends ValueLogicExpression<C, L>, RepositoryConditionsGroupLogicExpression<C, L>, Queryable<S>,
    QueryLimitSetter<LimitAwareQueryValue>, QueryValueLimitExecutor, QueryCountExecutor, QueryValueOneExecutor,
    QueryMapperSetter1 {

}
