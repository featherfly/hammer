
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.expression.ConditionGroupExpression;
import cn.featherfly.hammer.expression.ConditionGroupLogicExpression;

/**
 * <p>
 * Deleter
 * </p>
 *
 * @author zhongj
 */
public interface DeleterExpression<D extends DeleteExpression<C, L>, C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>> {

    /**
     * start delete dsl for repository
     *
     * @param repository repository
     * @return DeleteExpression
     */
    D delete(String repository);

    /**
     * start delete dsl for repository
     *
     * @param repository repository
     * @return DeleteExpression
     */
    D delete(Repository repository);
}
