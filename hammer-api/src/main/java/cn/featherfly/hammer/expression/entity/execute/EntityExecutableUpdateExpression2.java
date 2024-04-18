
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;

/**
 * EntityExecutableUpdateExpression2.
 *
 * @author zhongj
 * @param <E>  the update type
 * @param <J1> the join type 1
 * @param <U>  the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityExecutableUpdateExpression2<E, J1, U extends EntityExecutableUpdateExpression2<E, J1, U, C, L>,
    C extends EntityExecutableConditionGroupExpression2<E, J1, C, L, UpdateConditionConfig>,
    L extends EntityExecutableConditionGroupLogicExpression2<E, J1, C, L, UpdateConditionConfig>>
    extends EntityUpdateExpression<E, U, C, L>, EntityPropertyExecutableUpdateExpression2<E, J1, U, C, L>,
    EntityUpdateSetExecutableExpression2<E, J1, U, C, L> {

}
