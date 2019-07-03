
package cn.featherfly.juorm.dsl.execute;

import cn.featherfly.juorm.dsl.Repository;

/**
 * <p>
 * Deleter
 * </p>
 *
 * @author zhongj
 */
public interface Deleter<D extends Delete> extends
        cn.featherfly.juorm.expression.execute.Deleter<D, ExecutableConditionGroupExpression, ExecutableConditionGroupLogicExpression> {
    /**
     * start delete dsl for repository
     * 
     * @param repository
     *            repository
     * @return Delete
     */
    D delete(Repository repository);
}
