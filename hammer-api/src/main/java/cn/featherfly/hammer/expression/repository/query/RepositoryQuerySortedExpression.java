
package cn.featherfly.hammer.expression.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery1;
import cn.featherfly.data.query.QueryExecutor;
import cn.featherfly.data.query.QueryLimitSetter;
import cn.featherfly.data.query.QueryMapperSetter1;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression;

/**
 * repository query sorted expression.
 *
 * @author zhongj
 */
public interface RepositoryQuerySortedExpression extends RepositorySortedExpression<RepositoryQuerySortedExpression>,
    QueryLimitSetter<LimitAwareQuery1<Map<String, Serializable>>>, QueryExecutor<Map<String, Serializable>>,
    QueryMapperSetter1 {

}
