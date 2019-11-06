
package cn.featherfly.juorm.dsl.query;

import cn.featherfly.juorm.expression.condition.SortExpression;
import cn.featherfly.juorm.expression.query.TypeQueryConditionLimit;
import cn.featherfly.juorm.expression.query.TypeQueryLimitExecutor;

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
