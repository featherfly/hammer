
package cn.featherfly.hammer.expression.query;

import cn.featherfly.hammer.expression.RepositoryConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.RepositoryWhereExpression;
import cn.featherfly.hammer.expression.condition.RepositoryConditionsGroupExpression;

/**
 * <p>
 * QueryWithExpression
 * </p>
 * .
 *
 * @author zhongj
 * @param <QW>  the generic type
 * @param <QWO> the generic type
 * @param <QWE> the generic type
 * @param <C>   the generic type
 * @param <L>   the generic type
 */
public interface QueryWithExpression<QW extends QueryWithExpression<QW, QWO, QWE, C, L>,
        QWO extends QueryWithOnExpression<QW, QWO, QWE, C, L>,
        QWE extends QueryWithEntityExpression<QW, QWO, QWE, C, L>, C extends RepositoryConditionsGroupExpression<C, L>,
        L extends RepositoryConditionGroupLogicExpression<C, L>>
        extends RepositoryWhereExpression<C, L>, QueryListExecutor, QueryConditionLimit {

    /**
     * with.
     *
     * @param repositoryName with repository name
     * @return QueryWithExpression
     */
    QWO with(String repositoryName);

    /**
     * with.
     *
     * @param <T>            the generic type
     * @param repositoryType with repository type
     * @return QueryWithExpression
     */
    <T> QWO with(Class<T> repositoryType);
}
