
package cn.featherfly.juorm.expression.query;

import cn.featherfly.juorm.expression.condition.ConditionGroupExpression;
import cn.featherfly.juorm.expression.condition.LogicGroupExpression;

/**
 * <p>
 * dsl for query
 * </p>
 *
 * @author zhongj
 */
public interface Query<Q extends QueryEntity<QP, C, L>,
        QP extends QueryEntityProperties<QP, C, L>,
        C extends ConditionGroupExpression<C, L>,
        L extends LogicGroupExpression<C, L>> {
    Q find(String repository);
}
