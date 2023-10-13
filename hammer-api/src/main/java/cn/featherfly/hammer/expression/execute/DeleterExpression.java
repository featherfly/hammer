
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityDeleteExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupLogicExpression;

/**
 * Deleter.
 *
 * @author zhongj
 */
public interface DeleterExpression<D extends DeleteExpression<C, L>,
        C extends ExecutableConditionGroupExpression<C, L, DeleteConditionConfig>,
        L extends ExecutableConditionGroupLogicExpression<C, L, DeleteConditionConfig>> {

    /**
     * start delete dsl for repository
     *
     * @param repository repository
     * @return generic type of DeleteExpression
     */
    D delete(String repository);

    /**
     * start delete dsl for repository
     *
     * @param repository repository
     * @return generic type of DeleteExpression
     */
    D delete(Repository repository);

    /**
     * start delete dsl for the entity type.
     *
     * @param <EDR>      the generic type
     * @param <DC>       the generic type
     * @param <DL>       the generic type
     * @param <E>        the entity type
     * @param entityType the entity type
     * @return generic type of EntityDeleteExpression
     */
    <EDR extends EntityDeleteExpression<E, DC, DL>,
            DC extends EntityExecutableConditionGroupExpression<E, DC, DL, DeleteConditionConfig>,
            DL extends EntityExecutableConditionGroupLogicExpression<E, DC, DL, DeleteConditionConfig>,
            E> EDR delete(Class<E> entityType);
}
