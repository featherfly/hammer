
package cn.featherfly.juorm.expression.query;

import cn.featherfly.juorm.expression.RepositoryConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.RepositoryWhereExpression;
import cn.featherfly.juorm.expression.condition.RepositoryConditionsGroupExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface QueryWithExpression<QW extends QueryWithExpression<QW, QWO, QWE, C, L>,
        QWO extends QueryWithOnExpression<QW, QWO, QWE, C, L>,
        QWE extends QueryWithEntityExpression<QW, QWO, QWE, C, L>, C extends RepositoryConditionsGroupExpression<C, L>,
        L extends RepositoryConditionGroupLogicExpression<C, L>>
        extends RepositoryWhereExpression<C, L>, QueryListExecutor, QueryConditionLimit {
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
