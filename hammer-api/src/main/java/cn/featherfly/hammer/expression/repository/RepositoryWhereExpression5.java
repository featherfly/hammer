
package cn.featherfly.hammer.expression.repository;

import cn.featherfly.common.function.FiveArgusFunction;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.WhereExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupExpression5;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupLogicExpression5;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;

/**
 * repository where expression5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryWhereExpression5<C extends RepositoryConditionsGroupExpression5<C, L>,
        L extends RepositoryConditionsGroupLogicExpression5<C, L>> extends WhereExpression<C> {

    /**
     * gets the filter expression. 获取筛选条件表达式.
     *
     * @param repositoriesCondtionFuntion the repositories condtion funtion
     * @return filter expression
     */
    default L filter(
            FiveArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        return where(repositoriesCondtionFuntion);
    }

    /**
     * filter alias. More user-friendly for users familiar with sql.
     *
     * @param repositoriesCondtionFuntion the repositories condtion funtion
     * @return filter expression
     */
    L where(FiveArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoriesCondtionFuntion);
}
