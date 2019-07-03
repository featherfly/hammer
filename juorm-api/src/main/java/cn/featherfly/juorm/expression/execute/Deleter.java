
package cn.featherfly.juorm.expression.execute;

import cn.featherfly.juorm.expression.condition.ConditionGroupExpression;
import cn.featherfly.juorm.expression.condition.LogicGroupExpression;

/**
 * <p>
 * Deleter
 * </p>
 *
 * @author zhongj
 */
public interface Deleter<D extends Delete<C, L>,
        C extends ConditionGroupExpression<C, L>,
        L extends LogicGroupExpression<C, L>> {

    /**
     * start delete dsl for repository
     * 
     * @param repository
     *            repository
     * @return Delete
     */
    D delete(String repository);
}
