
package cn.featherfly.juorm.dsl.execute;

import cn.featherfly.juorm.dsl.Repository;

/**
 * <p>
 * Updater
 * </p>
 *
 * @author zhongj
 */
public interface Updater<U extends Update<?>> {
    /**
     * start update dsl for repository
     *
     * @param repository repository
     * @return Delete
     */
    U update(Repository repository);
}
