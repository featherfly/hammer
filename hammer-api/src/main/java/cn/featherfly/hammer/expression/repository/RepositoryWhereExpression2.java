
package cn.featherfly.hammer.expression.repository;

import java.util.function.BiFunction;

import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.WhereExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupExpression2;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupLogicExpression2;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;

/**
 * repository where expression2.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryWhereExpression2<C extends RepositoryConditionsGroupExpression2<C, L>,
        L extends RepositoryConditionsGroupLogicExpression2<C, L>> extends WhereExpression<C> {

    /**
     * gets the filter expression. 获取筛选条件表达式.
     *
     * @param repositoriesCondtionFuntion the repositories condtion funtion
     * @return filter expression
     */
    default L filter(
            BiFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        return where(repositoriesCondtionFuntion);
    }

    /**
     * filter alias. More user-friendly for users familiar with sql.
     *
     * @param repositoriesCondtionFuntion the repositories condtion funtion
     * @return filter expression
     */
    L where(BiFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoriesCondtionFuntion);
}
