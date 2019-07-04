
package cn.featherfly.juorm.expression.query;

import cn.featherfly.juorm.expression.ConditionGroupExpression;
import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.Repository;

/**
 * <p>
 * dsl for query
 * </p>
 *
 * @author zhongj
 */
public interface QueryExpression<Q extends QueryEntityExpression<QP, C, L>,
        QP extends QueryEntityPropertiesExpression<QP, C, L>, C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>> {
    /**
     * find repository
     *
     * @param repository repository
     * @return QueryEntity
     */
    Q find(Repository repository);

    /**
     * find repository
     *
     * @param repository repository
     * @return QueryEntity
     */
    Q find(String repository);
}
