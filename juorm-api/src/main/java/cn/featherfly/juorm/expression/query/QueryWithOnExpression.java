
package cn.featherfly.juorm.expression.query;

import cn.featherfly.juorm.expression.RepositoryConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.condition.RepositoryConditionsGroupExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface QueryWithOnExpression<QW extends QueryWithExpression<QW, QWO, QWE, C, L>,
        QWO extends QueryWithOnExpression<QW, QWO, QWE, C, L>,
        QWE extends QueryWithEntityExpression<QW, QWO, QWE, C, L>, C extends RepositoryConditionsGroupExpression<C, L>,
        L extends RepositoryConditionGroupLogicExpression<C, L>> {
    /**
     * on
     *
     * @param propertyName with repository property name (use repository name
     *                     invoke with method argu with(repositoryName))
     * @return QueryWithExpression
     */
    QWE on(String propertyName);

    /**
     * on
     *
     * @param propertyName               with repository property name (use
     *                                   repository name invoke with method argu
     *                                   with(repositoryName))
     * @param findRepositoryPropertyName find repository property name (use
     *                                   repository name invoke find method argu
     *                                   find(repositoryName))
     * @return QueryWithExpression
     */
    QWE on(String propertyName, String findRepositoryPropertyName);

    /**
     * on
     *
     * @param propertyName           with repository property name (use
     *                               repository name invoke with method argu
     *                               with(repositoryName))
     * @param repositoryName         on repository name
     * @param repositoryPropertyName on repository property name
     * @return QueryWithExpression
     */
    QWE on(String propertyName, String repositoryName, String repositoryPropertyName);
}
