
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.config.dsl.UpdateConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;

/**
 * EntityUpdateExpression.
 *
 * @author zhongj
 */
public interface EntityUpdateExpression<E, U extends EntityExecutableUpdateExpression<E, U, C, L>,
        C extends EntityExecutableConditionGroupExpression<E, C, L, UpdateConditionConfig>,
        L extends EntityExecutableConditionGroupLogicExpression<E, C, L, UpdateConditionConfig>>
        extends EntityPropertyUpdateExpression<E, U, C, L>, EntityUpdateSetExpression<E, U, C, L>,
        ConfigureExpression<EntityUpdateExpression<E, U, C, L>, UpdateConfig, UpdateConditionConfig> {

}
