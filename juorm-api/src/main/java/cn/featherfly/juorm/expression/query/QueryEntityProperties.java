
package cn.featherfly.juorm.expression.query;

import cn.featherfly.juorm.expression.condition.ConditionGroupExpression;
import cn.featherfly.juorm.expression.condition.LogicGroupExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface QueryEntityProperties<Q extends QueryEntityProperties<Q, C, L>,
        C extends ConditionGroupExpression<C, L>,
        L extends LogicGroupExpression<C, L>>
        extends QueryEntity<Q, C, L>, QueryValueExecutor {
}
