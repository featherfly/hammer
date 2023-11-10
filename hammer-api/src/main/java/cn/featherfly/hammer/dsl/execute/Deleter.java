
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryDelete;

/**
 * Deleter.
 *
 * @author zhongj
 */
public interface Deleter
//    extends DeleterExpression<Delete, ExecutableConditionGroup<DeleteConditionConfig>,
//        ExecutableConditionGroupLogic<DeleteConditionConfig>>
{
    /**
     * start delete dsl for repository
     *
     * @param repository repository
     * @return generic type of DeleteExpression
     */
    RepositoryDelete delete(String repository);

    /**
     * start delete dsl for repository
     *
     * @param repository repository
     * @return generic type of DeleteExpression
     */
    RepositoryDelete delete(Repository repository);

    /**
     * start delete dsl for the entity type.
     *
     * @param <E>        the entity type
     * @param entityType the entity type
     * @return EntityDeleteExpression
     */
    <E> EntityDelete<E> delete(Class<E> entityType);
}
