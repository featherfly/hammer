
package cn.featherfly.hammer.expression.repository;

import cn.featherfly.hammer.expression.query.WhereExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupExpression3;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupLogicExpression3;

/**
 * repository where expression3.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryWhereExpression3<C extends RepositoryConditionsGroupExpression3<C, L>,
        L extends RepositoryConditionsGroupLogicExpression3<C, L>> extends WhereExpression<C> {
    // IMPLSOON join查询实现了再来实现这个
    //    L where(BiFunction<RepositoryFieldExpression<?, ?>, RepositoryFieldExpression<?, ?>,
    //            LogicExpression<?, ?>> entityPropertyFuntion);
}
