
package cn.featherfly.hammer.expression.repository;

import cn.featherfly.hammer.expression.query.WhereExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupExpression6;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupLogicExpression6;

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
    // IMPLSOON join查询实现了再来实现这个
    //    L where(BiFunction<RepositoryFieldExpression<?, ?>, RepositoryFieldExpression<?, ?>,
    //            LogicExpression<?, ?>> entityPropertyFuntion);
}
