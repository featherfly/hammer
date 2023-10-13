
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;

/**
 * EntityUpdateNumberValueExpression.
 *
 * @author zhongj
 */
public interface EntityUpdateNumberValueExpression<E, T extends Number,
        U extends EntityPropertyExecutableUpdateExpression<E, U, C, L>,
        C extends EntityExecutableConditionGroupExpression<E, C, L, UpdateConditionConfig>,
        L extends EntityExecutableConditionGroupLogicExpression<E, C, L, UpdateConditionConfig>>
        extends EntityUpdateValueExpression<E, T, U, C, L> {

    U increase(T value);
}
