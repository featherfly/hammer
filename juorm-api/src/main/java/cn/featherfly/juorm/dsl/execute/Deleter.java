
package cn.featherfly.juorm.dsl.execute;

import cn.featherfly.juorm.dsl.Repository;

/**
 * <p>
 * Updator
 * </p>
 *
 * @author zhongj
 */
public interface Deleter<D extends Delete> {
    /**
     * start delete dsl for repository
     * 
     * @param repository repository
     * @return Delete
     */
    D delete(Repository repository);
}
