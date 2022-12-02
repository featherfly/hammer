
package cn.featherfly.hammer.expression.query;

import cn.featherfly.hammer.expression.ConditionGroupExpression;
import cn.featherfly.hammer.expression.ConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.RepositoryConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.condition.RepositoryConditionsGroupExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface QueryEntityPropertiesExpression<
        Q extends QueryEntityPropertiesExpression<Q, QW, QWO, QWE, C, L, RC, RL>,
        QW extends QueryRelateExpression<QW, QWO, QWE, RC, RL>,
        QWO extends QueryRelateOnExpression<QW, QWO, QWE, RC, RL>,
        QWE extends QueryRelateEntityExpression<QW, QWO, QWE, RC, RL>,
        C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>,
        RC extends RepositoryConditionsGroupExpression<RC, RL>,
        RL extends RepositoryConditionGroupLogicExpression<RC, RL>>
        extends QueryEntityExpression<Q, QW, QWO, QWE, C, L, RC, RL>,
        QueryValueExecutor, QueryCountExecutor {
}
