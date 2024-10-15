
package cn.featherfly.hammer.expression.entity.condition.ew;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityEndWithExpression6.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityEndWithExpression6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends EntityEndWithExpressionBase6<E, E2, E3, E4, E5, E6, C, L> {

    /**
     * end with value. 以value结尾.
     *
     * @param endWithEntityExpressions the end with entity expressions
     * @return the LogicExpression
     */
    L ew(Consumer<Tuple6<EndWithEntityExpression<E>, EndWithEntityExpression<E2>, EndWithEntityExpression<E3>,
        EndWithEntityExpression<E4>, EndWithEntityExpression<E5>,
        EndWithEntityExpression<E6>>> endWithEntityExpressions);

    /**
     * end with value. 以value结尾.
     *
     * @param endWithEntityExpressions the end with entity expressions
     * @return the LogicExpression
     */
    L ew(SixArgusConsumer<EndWithEntityExpression<E>, EndWithEntityExpression<E2>, EndWithEntityExpression<E3>,
        EndWithEntityExpression<E4>, EndWithEntityExpression<E5>,
        EndWithEntityExpression<E6>> endWithEntityExpressions);
}