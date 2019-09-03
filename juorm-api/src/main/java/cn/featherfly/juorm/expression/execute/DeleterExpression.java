
package cn.featherfly.juorm.expression.execute;

import cn.featherfly.juorm.expression.ConditionGroupExpression;
import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.Repository;

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
