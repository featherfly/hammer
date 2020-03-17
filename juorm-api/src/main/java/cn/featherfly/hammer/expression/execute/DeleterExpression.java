
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.hammer.expression.ConditionGroupExpression;
import cn.featherfly.hammer.expression.ConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.Repository;

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
     * @return Delete
     */
    D delete(String repository);

    /**
     * start delete dsl for repository
     *
     * @param repository repository
     * @return Delete
     */
    D delete(Repository repository);

    /**
     * start delete dsl for the reposited type
     *
     * @param repositType repositType
     * @return Delete
     */
    D delete(Class<?> repositType);
}
