
package cn.featherfly.juorm.expression.execute;

import cn.featherfly.juorm.expression.ConditionGroupExpression;
import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.Repository;

/**
 * <p>
 * Updater
 * </p>
 *
 * @author zhongj
 */
public interface UpdaterExpression<U extends UpdateExpression<EU, C, L, V, VN>,
        EU extends ExecutableUpdateExpression<EU, C, L, V, VN>, C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>, V extends UpdateValueExpression<EU, C, L, Object, V, VN>,
        VN extends UpdateNumberValueExpression<EU, C, L, Number, V, VN>> {
    /**
     * start update dsl for the repository
     *
     * @param repository repository
     * @return Delete
     */
    U update(Repository repository);

    /**
     * start update dsl for the repository
     *
     * @param repository repository
     * @return Delete
     */
    U update(String repository);

    /**
     * start update dsl for the reposited type
     *
     * @param repositType repositType
     * @return Delete
     */
    U update(Class<?> repositType);
}
