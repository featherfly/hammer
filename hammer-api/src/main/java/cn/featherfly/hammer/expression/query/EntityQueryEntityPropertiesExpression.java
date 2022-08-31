
package cn.featherfly.hammer.expression.query;

import cn.featherfly.hammer.expression.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.EntityConditionGroupLogicExpression;

/**
 * dsl for query data.
 *
 * @author zhongj
 */
public interface EntityQueryEntityPropertiesExpression<E,
        Q extends EntityQueryEntityPropertiesExpression<E, Q, QW, QWE, C, L>,
        QW extends EntityQueryWithExpression<E, QW, QWE, C, L>,
        QWE extends EntityQueryWithEntityExpression<E, QW, QWE, C, L>,
        C extends EntityConditionGroupExpression<E, C, L>, L extends EntityConditionGroupLogicExpression<E, C, L>>
        extends EntityQueryEntityExpression<E, Q, QW, QWE, C, L> {
}
