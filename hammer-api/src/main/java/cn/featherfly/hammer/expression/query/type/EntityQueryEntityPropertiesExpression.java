
package cn.featherfly.hammer.expression.query.type;

import cn.featherfly.hammer.expression.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.EntityConditionGroupLogicExpression;

/**
 * dsl for query data.
 *
 * @author zhongj
 */
public interface EntityQueryEntityPropertiesExpression<E, Q extends EntityQueryEntityPropertiesExpression<E, Q, C, L>,
        C extends EntityConditionGroupExpression<E, C, L>, L extends EntityConditionGroupLogicExpression<E, C, L>>
        extends EntityQueryEntityExpression<E, Q, C, L> {
}
