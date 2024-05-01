
package cn.featherfly.hammer.expression.repository;

import cn.featherfly.common.function.ThreeArgusFunction;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.WhereExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupExpression3;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupLogicExpression3;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;

/**
 * repository where expression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryWhereExpression3<C extends RepositoryConditionsGroupExpression3<C, L>,
        L extends RepositoryConditionsGroupLogicExpression3<C, L>> extends WhereExpression<C> {

    /**
     * gets the filter expression. 获取筛选条件表达式.
     *
     * @param repositoriesCondtionFuntion the repositories condtion funtion
     * @return filter expression
     */
    default L filter(
            ThreeArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        return where(repositoriesCondtionFuntion);
    }

    /**
     * filter alias. More user-friendly for users familiar with sql.
     *
     * @param repositoriesCondtionFuntion the repositories condtion funtion
     * @return filter expression
     */
    L where(ThreeArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoriesCondtionFuntion);
}
