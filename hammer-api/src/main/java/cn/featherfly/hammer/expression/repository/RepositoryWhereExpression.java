
package cn.featherfly.hammer.expression.repository;

import java.util.function.Function;

import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.query.WhereExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupLogicExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryFieldExpression;

/**
 * repository where expression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryWhereExpression<C extends RepositoryConditionsGroupExpression<C, L>,
        L extends RepositoryConditionsGroupLogicExpression<C, L>> extends WhereExpression<C> {

    //    /**
    //     * gets the filter expression. 获取筛选条件表达式.
    //     *
    //     * @param consumer the consumer
    //     * @return filter expression
    //     */
    //    C where(Consumer<C> consumer);

    L where(Function<RepositoryFieldExpression<?, ?>, LogicExpression<?, ?>> filterable);
}
