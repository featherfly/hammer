
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.condition.SortExpression;
import cn.featherfly.hammer.expression.query.TypeQueryConditionLimit;
import cn.featherfly.hammer.expression.query.TypeQueryLimitExecutor;

/**
 * <p>
 * SortExpression
 * </p>
 *
 * @author zhongj
 */
public interface TypeQuerySortExpression
        extends SortExpression<TypeQuerySortExpression>, TypeQueryConditionLimit, TypeQueryLimitExecutor {

}
