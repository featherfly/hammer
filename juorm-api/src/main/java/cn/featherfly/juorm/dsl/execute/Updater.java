
package cn.featherfly.juorm.dsl.execute;

import cn.featherfly.juorm.dsl.Repository;
import cn.featherfly.juorm.expression.execute.IUpdate;

/**
 * <p>
 * Updater
 * </p>
 *
 * @author zhongj
 */
public interface Updater<U extends IUpdate> {
    /**
     * start update dsl for repository
     *
     * @param repository
     *            repository
     * @return Delete
     */
    U update(Repository repository);

    /**
     * start update dsl for repository
     *
     * @param repository
     *            repository
     * @return Delete
     */
    U update(String repository);
}
