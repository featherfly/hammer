
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * entity executable condition group logic expression,.
 *
 * @author zhongj
 */
public interface EntityExecutableConditionGroupLogicExpression<E,
        C extends EntityExecutableConditionGroupExpression<E, C, L>,
        L extends EntityExecutableConditionGroupLogicExpression<E, C, L>>
        extends Executor, EntityConditionGroupLogicExpression<E, C, L> {

}
