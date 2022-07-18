
package cn.featherfly.hammer.expression.query;

import cn.featherfly.hammer.expression.RepositoryConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.TypeConditionGroupExpression;
import cn.featherfly.hammer.expression.TypeConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.condition.RepositoryConditionsGroupExpression;

/**
 * dsl for query data.
 *
 * @author zhongj
 */
public interface TypeQueryEntityPropertiesExpression<
        Q extends TypeQueryEntityPropertiesExpression<Q, QW, QWE, C, L, RC, RL>,
        QW extends TypeQueryWithExpression<QW, QWE, RC, RL>, QWE extends TypeQueryWithEntityExpression<QW, QWE, RC, RL>,
        C extends TypeConditionGroupExpression<C, L>, L extends TypeConditionGroupLogicExpression<C, L>,
        RC extends RepositoryConditionsGroupExpression<RC, RL>,
        RL extends RepositoryConditionGroupLogicExpression<RC, RL>>
        extends TypeQueryEntityExpression<Q, QW, QWE, C, L, RC, RL> {
}
