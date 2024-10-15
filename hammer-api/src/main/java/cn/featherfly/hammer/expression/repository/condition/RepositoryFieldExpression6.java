
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.MulitiRepositoryFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;

/**
 * repository field expression 6.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryFieldExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryFieldExpression<C, L>, MulitiRepositoryFieldExpression<
                Tuple6<Integer, Integer, Integer, Integer, Integer, Integer>, C, L>/*, FieldExpression6<C, L>*/ {
    /**
     * field.
     *
     * @param repositoiesFieldFunction the repositoies field function
     * @return the LogicExpression
     */
    L field(SixArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoiesFieldFunction);
}
