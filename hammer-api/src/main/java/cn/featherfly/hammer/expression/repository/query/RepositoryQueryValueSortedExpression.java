
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.data.query.LimitAwareQueryValue;
import cn.featherfly.data.query.QueryLimitSetter;
import cn.featherfly.data.query.QueryMapperSetter1;
import cn.featherfly.data.query.QueryValueExecutor;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression;

/**
 * repository query value sorted expression.
 *
 * @author zhongj
 */
public interface RepositoryQueryValueSortedExpression
    extends RepositorySortedExpression<RepositoryQueryValueSortedExpression>, QueryLimitSetter<LimitAwareQueryValue>,
    QueryValueExecutor, QueryMapperSetter1 {

}
