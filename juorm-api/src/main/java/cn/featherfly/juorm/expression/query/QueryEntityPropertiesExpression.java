
package cn.featherfly.juorm.expression.query;

import cn.featherfly.juorm.expression.ConditionGroupExpression;
import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface QueryEntityPropertiesExpression<Q extends QueryEntityPropertiesExpression<Q, QW, QWO, QWE, C, L>,
        QW extends QueryWithExpression<QW, QWO, QWE, C, L>, QWO extends QueryWithOnExpression<QW, QWO, QWE, C, L>,
        QWE extends QueryWithEntityExpression<QW, QWO, QWE, C, L>, C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>>
        extends QueryEntityExpression<Q, QW, QWO, QWE, C, L>, QueryValueExecutor {
}
