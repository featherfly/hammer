
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.MulitiRepositoryFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;

/**
 * repository field expression 4.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryFieldExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryFieldExpression<C, L>,
        MulitiRepositoryFieldExpression<Tuple4<Integer, Integer, Integer, Integer>, C, L>/*, FieldExpression4<C, L>*/ {
    /**
     * field.
     *
     * @param repositoiesFieldFunction the repositoies field function
     * @return the LogicExpression
     */
    L field(FourArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            LogicExpression<?, ?>> repositoiesFieldFunction);
}
