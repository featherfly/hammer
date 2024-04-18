
package cn.featherfly.hammer.expression.repository;

import java.util.function.Function;

import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.WhereExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupLogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;

/**
 * repository where expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryWhereExpression<C extends RepositoryConditionsGroupExpression<C, L>,
    L extends RepositoryConditionsGroupLogicExpression<C, L>> extends WhereExpression<C> {

    /**
     * gets the filter expression. 获取筛选条件表达式.
     *
     * @param function the condition expression function
     * @return filter expression
     */
    default L filter(Function<RepositoryFieldOnlyExpression, LogicExpression<?, ?>> function) {
        return where(function);
    }

    /**
     * filter alias. More user-friendly for users familiar with sql.
     *
     * @param function the condition expression function
     * @return filter expression
     */
    L where(Function<RepositoryFieldOnlyExpression, LogicExpression<?, ?>> function);
}
