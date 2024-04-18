
package cn.featherfly.hammer.expression.repository;

import cn.featherfly.common.function.SixArgusFunction;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.WhereExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupExpression6;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupLogicExpression6;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;

/**
 * repository where expression6.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryWhereExpression6<C extends RepositoryConditionsGroupExpression6<C, L>,
    L extends RepositoryConditionsGroupLogicExpression6<C, L>> extends WhereExpression<C> {
    /**
     * gets the filter expression. 获取筛选条件表达式.
     *
     * @param function the condition expression function
     * @return filter expression
     */
    default L filter(SixArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
        RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
        RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        return where(repositoriesCondtionFuntion);
    }

    /**
     * filter alias. More user-friendly for users familiar with sql.
     *
     * @param repositoriesCondtionFuntion the repositories condtion funtion
     * @return filter expression
     */
    L where(SixArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
        RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
        RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoriesCondtionFuntion);
}
