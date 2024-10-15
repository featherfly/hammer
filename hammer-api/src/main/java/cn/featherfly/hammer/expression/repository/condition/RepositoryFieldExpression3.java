
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.MulitiRepositoryFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;

/**
 * repository field expression 3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryFieldExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryFieldExpression<C, L>,
        MulitiRepositoryFieldExpression<Tuple3<Integer, Integer, Integer>, C, L>/*, FieldExpression3<C, L>*/ {
    /**
     * field.
     *
     * @param repositoiesFieldFunction the repositoies field function
     * @return the LogicExpression
     */
    L field(ThreeArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoiesFieldFunction);
}
