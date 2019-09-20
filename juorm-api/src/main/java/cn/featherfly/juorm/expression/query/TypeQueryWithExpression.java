
package cn.featherfly.juorm.expression.query;

import cn.featherfly.juorm.expression.ConditionGroupExpression;
import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.WhereExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface TypeQueryWithExpression<QW extends TypeQueryWithExpression<QW, QWO, QWE, C, L>,
        QWO extends TypeQueryWithOnExpression<QW, QWO, QWE, C, L>,
        QWE extends TypeQueryWithEntityExpression<QW, QWO, QWE, C, L>, C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>>
        extends WhereExpression<C, L>, TypeQueryListExecutor, TypeQueryConditionLimit {
    /**
     * with
     *
     * @param repositoryName with repository name
     * @return QueryWithExpression
     */
    QWO with(String repositoryName);

    /**
     * with
     *
     * @param repositoryType with repository type
     * @return QueryWithExpression
     */
    <T> QWO with(Class<T> repositoryType);
}
