
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdate;
import cn.featherfly.hammer.dsl.repository.execute.Update;

/**
 * Updater.
 *
 * @author zhongj
 */
public interface Updater
//        extends UpdaterExpression<Update, ExecutableUpdate, ExecutableConditionGroup<UpdateConditionConfig>,
//                ExecutableConditionGroupLogic<UpdateConditionConfig>, UpdateValue, UpdateNumberValue>
{

    /**
     * start update dsl for the repository
     *
     * @param repository repository
     * @return the generic type of UpdateExpression
     */
    Update update(Repository repository);

    /**
     * start update dsl for the repository
     *
     * @param repository repository
     * @return the generic type of UpdateExpression
     */
    Update update(String repository);

    /**
     * start update dsl for the entity type.
     *
     * @param <E>        the element type
     * @param entityType repositType
     * @return EntityUpdate
     */
    <E> EntityUpdate<E> update(Class<E> entityType);
}
