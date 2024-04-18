
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.config.dsl.UpdateConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * EntityUpdateExpression.
 *
 * @author zhongj
 */
public interface EntityUpdateExpression<E, U, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityPropertyUpdateExpression<E, U, C, L>, EntityUpdateSetExpression<E, U, C, L>,
    ConfigureExpression<EntityUpdateExpression<E, U, C, L>, UpdateConfig, UpdateConditionConfig> {

}
