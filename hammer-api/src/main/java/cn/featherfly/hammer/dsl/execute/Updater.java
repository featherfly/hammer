
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.expression.execute.UpdaterExpression;

/**
 * Updater.
 *
 * @author zhongj
 */
public interface Updater extends UpdaterExpression<Update, ExecutableUpdate, ExecutableConditionGroup,
        ExecutableConditionGroupLogic, UpdateValue, UpdateNumberValue> {

    //    /**
    //     * start update dsl for the entity type.
    //     *
    //     * @param <E>        the element type
    //     * @param entityType repositType
    //     * @return EntityUpdate
    //     */
    //    <E> EntityUpdate<E> update(Class<E> entityType);
}
