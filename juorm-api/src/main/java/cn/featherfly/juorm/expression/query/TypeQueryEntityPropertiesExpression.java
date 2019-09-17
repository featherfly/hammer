
package cn.featherfly.juorm.expression.query;

import cn.featherfly.juorm.expression.ConditionGroupExpression;
import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface TypeQueryEntityPropertiesExpression<Q extends TypeQueryEntityPropertiesExpression<Q, C, L>,
        C extends ConditionGroupExpression<C, L>, L extends ConditionGroupLogicExpression<C, L>>
        extends TypeQueryEntityExpression<Q, C, L> {
}
