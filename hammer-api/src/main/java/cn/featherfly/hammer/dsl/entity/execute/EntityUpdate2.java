
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression2;
import cn.featherfly.hammer.expression.entity.execute.EntityUpdateExpression;

/**
 * EntityUpdate.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <J1> the join type 1
 */
public interface EntityUpdate2<E, J1> extends
    EntityUpdateExpression<E, EntityExecutableUpdate2<E, J1>,
        EntityExecutableConditionGroup2<E, J1, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic2<E, J1, UpdateConditionConfig>> {

    /**
     * Join.
     *
     * @param <J>      the generic type
     * @param joinType the join type
     * @return the entity on expression1
     */
    <J> EntityOnExpression2<E, J1, J, EntityUpdate3<E, J1, J>> join(Class<J> joinType);
}
