
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression2;

/**
 * The Interface EntityDeleteExpression2.
 *
 * @author zhongj
 * @param <E1> the generic type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityDeleteExpression2<E1, E2,
    C extends EntityExecutableConditionGroupExpression2<E1, E2, C, L, DeleteConditionConfig>,
    L extends EntityExecutableConditionGroupLogicExpression2<E1, E2, C, L, DeleteConditionConfig>>
    extends EntityWhereExpression2<E1, E2, C, L>,
    ConfigureExpression<EntityDeleteExpression2<E1, E2, C, L>, DeleteConfig, DeleteConditionConfig> {
}
