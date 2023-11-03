
package cn.featherfly.hammer.expression.repository;

import cn.featherfly.hammer.expression.query.WhereExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupExpression4;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupLogicExpression4;

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
    // IMPLSOON join查询实现了再来实现这个
    //    L where(BiFunction<RepositoryFieldExpression<?, ?>, RepositoryFieldExpression<?, ?>,
    //            LogicExpression<?, ?>> entityPropertyFuntion);
}
