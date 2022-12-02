
package cn.featherfly.hammer.expression.query;

import cn.featherfly.hammer.expression.RepositoryConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.condition.RepositoryConditionsGroupExpression;

/**
 * query with on expression.
 *
 * @author zhongj
 * @param <QW>  the generic type
 * @param <QWO> the generic type
 * @param <QWE> the generic type
 * @param <C>   the generic type
 * @param <L>   the generic type
 */
public interface QueryRelateOnExpression<QW extends QueryRelateExpression<QW, QWO, QWE, C, L>,
        QWO extends QueryRelateOnExpression<QW, QWO, QWE, C, L>,
        QWE extends QueryRelateEntityExpression<QW, QWO, QWE, C, L>, C extends RepositoryConditionsGroupExpression<C, L>,
        L extends RepositoryConditionGroupLogicExpression<C, L>> {

    /**
     * on.
     *
     * @param propertyName with repository property name (use repository name
     *                     invoke with method argu with(repositoryName))
     * @return QueryWithExpression
     */
    QWE on(String propertyName);

    /**
     * on.
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
     * on.
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
