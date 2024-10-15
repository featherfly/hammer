
package cn.featherfly.hammer.expression.repository.condition;

import java.util.function.BiFunction;

import cn.featherfly.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.MulitiRepositoryFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;

/**
 * repository field expression 2.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryFieldExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryFieldExpression<C, L>,
        MulitiRepositoryFieldExpression<Tuple2<Integer, Integer>, C, L>/*, FieldExpression2<C, L>*/ {

    /**
     * field.
     *
     * @param repositoiesFieldFunction the repositoies field function
     * @return the LogicExpression
     */
    L field(BiFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            LogicExpression<?, ?>> repositoiesFieldFunction);
}
