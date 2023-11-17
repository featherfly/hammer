
package cn.featherfly.hammer.expression.query;

import cn.featherfly.hammer.expression.ConditionLogicExpression;
import cn.featherfly.hammer.expression.condition.ConditionExpression;

/**
 * QueryConditionLogicExpression.
 *
 * @author zhongj
 */
public interface QueryConditionLogicExpression<C extends ConditionExpression, L extends ConditionLogicExpression<C, L>>
        extends QueryConditionLimit, QueryExecutor, QueryValueOneExecutor, QueryCountExecutor,
        ConditionsLogicExpression<C, L> {

}
