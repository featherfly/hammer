
package cn.featherfly.hammer.expression.repository.condition;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.MulitiRepositoryFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;

/**
 * repository field expression 5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryFieldExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryFieldExpression<C, L>, MulitiRepositoryFieldExpression<
                Tuple5<Integer, Integer, Integer, Integer, Integer>, C, L>/*, FieldExpression5<C, L>*/ {
    /**
     * field.
     *
     * @param repositoiesFieldFunction the repositoies field function
     * @return the LogicExpression
     */
    L field(FiveArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            LogicExpression<?, ?>> repositoiesFieldFunction);
}
