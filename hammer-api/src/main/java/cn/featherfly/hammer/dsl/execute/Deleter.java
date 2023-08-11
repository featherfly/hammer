
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.expression.execute.DeleterExpression;

/**
 * Deleter.
 *
 * @author zhongj
 */
public interface Deleter
        extends DeleterExpression<Delete, ExecutableConditionGroup, ExecutableConditionGroupLogic> {

    //    /**
    //     * start delete dsl for the entity type.
    //     *
    //     * @param <E>        the entity type
    //     * @param entityType the entity type
    //     * @return EntityDeleteExpression
    //     */
    //    <E> EntityDelete<E> delete(Class<E> entityType);
}
