
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
     * relate to .
     *
     * @param repositoryName with repository name
     * @return QueryWithExpression
     */
    default QWO relate(String repositoryName) {
        return relate(repositoryName);
    }

    /**
     * join on .
     *
     * @param repositoryName with repository name
     * @return QueryWithExpression
     */
    QWO join(String repositoryName);

    /**
     * relate to.
     *
     * @param <T>            the generic type
     * @param repositoryType with repository type
     * @return QueryWithExpression
     */
    default <T> QWO relate(Class<T> repositoryType) {
        return join(repositoryType);
    }

    /**
     * join on.
     *
     * @param <T>            the generic type
     * @param repositoryType with repository type
     * @return QueryWithExpression
     */
    <T> QWO join(Class<T> repositoryType);
}
