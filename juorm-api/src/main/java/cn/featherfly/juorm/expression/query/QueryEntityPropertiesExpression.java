
package cn.featherfly.juorm.expression.query;

import cn.featherfly.juorm.expression.ConditionGroupExpression;
import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.RepositoryConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.condition.RepositoryConditionsGroupExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface QueryEntityPropertiesExpression<
        Q extends QueryEntityPropertiesExpression<Q, QW, QWO, QWE, C, L, RC, RL>,
        QW extends QueryWithExpression<QW, QWO, QWE, RC, RL>, QWO extends QueryWithOnExpression<QW, QWO, QWE, RC, RL>,
        QWE extends QueryWithEntityExpression<QW, QWO, QWE, RC, RL>, C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>, RC extends RepositoryConditionsGroupExpression<RC, RL>,
        RL extends RepositoryConditionGroupLogicExpression<RC, RL>>
        extends QueryEntityExpression<Q, QW, QWO, QWE, C, L, RC, RL>, QueryValueExecutor {
}
