
package cn.featherfly.hammer.expression.repository;

import cn.featherfly.hammer.expression.query.WhereExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupExpression5;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupLogicExpression5;

/**
 * repository where expression5.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryWhereExpression5<C extends RepositoryConditionsGroupExpression5<C, L>,
        L extends RepositoryConditionsGroupLogicExpression5<C, L>> extends WhereExpression<C> {
    // IMPLSOON join查询实现了再来实现这个
    //    L where(BiFunction<RepositoryFieldExpression<?, ?>, RepositoryFieldExpression<?, ?>,
    //            LogicExpression<?, ?>> entityPropertyFuntion);
}
