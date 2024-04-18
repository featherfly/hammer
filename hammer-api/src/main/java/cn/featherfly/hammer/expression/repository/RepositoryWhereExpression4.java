
package cn.featherfly.hammer.expression.repository;

import cn.featherfly.common.function.FourArgusFunction;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.WhereExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupExpression4;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupLogicExpression4;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;

/**
 * repository where expression4.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryWhereExpression4<C extends RepositoryConditionsGroupExpression4<C, L>,
    L extends RepositoryConditionsGroupLogicExpression4<C, L>> extends WhereExpression<C> {
    /**
     * gets the filter expression. 获取筛选条件表达式.
     *
     * @param function the condition expression function
     * @return filter expression
     */
    default L filter(
        FourArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        return where(repositoriesCondtionFuntion);
    }

    /**
     * filter alias. More user-friendly for users familiar with sql.
     *
     * @param repositoriesCondtionFuntion the repositories condtion funtion
     * @return filter expression
     */
    L where(
        FourArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoriesCondtionFuntion);
}
