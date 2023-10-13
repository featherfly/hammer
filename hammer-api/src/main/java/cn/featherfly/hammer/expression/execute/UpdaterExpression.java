
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableUpdateExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityUpdateExpression;

/**
 * updater expression.
 *
 * @author zhongj
 */
public interface UpdaterExpression<U extends UpdateExpression<EU, C, L, V, VN>,
        EU extends ExecutableUpdateExpression<EU, C, L, V, VN>,
        C extends ExecutableConditionGroupExpression<C, L, UpdateConditionConfig>,
        L extends ExecutableConditionGroupLogicExpression<C, L, UpdateConditionConfig>,
        V extends UpdateValueExpression<EU, C, L, Object, V, VN>,
        VN extends UpdateNumberValueExpression<EU, C, L, Number, V, VN>> {
    /**
     * start update dsl for the repository
     *
     * @param repository repository
     * @return the generic type of UpdateExpression
     */
    U update(Repository repository);

    /**
     * start update dsl for the repository
     *
     * @param repository repository
     * @return the generic type of UpdateExpression
     */
    U update(String repository);

    /**
     * start update dsl for the entity type.
     *
     * @param <EUR>      the generic type
     * @param <UU>       the generic type
     * @param <UC>       the generic type
     * @param <UL>       the generic type
     * @param <E>        the element type
     * @param entityType the entity type
     * @return the generic type of EntityUpdateExpression
     */
    <EUR extends EntityUpdateExpression<E, UU, UC, UL>, UU extends EntityExecutableUpdateExpression<E, UU, UC, UL>,
            UC extends EntityExecutableConditionGroupExpression<E, UC, UL, UpdateConditionConfig>,
            UL extends EntityExecutableConditionGroupLogicExpression<E, UC, UL, UpdateConditionConfig>,
            E> EUR update(Class<E> entityType);
}
