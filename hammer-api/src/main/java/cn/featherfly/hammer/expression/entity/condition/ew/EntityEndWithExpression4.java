
package cn.featherfly.hammer.expression.entity.condition.ew;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityEndWithExpression4.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityEndWithExpression4<E, E2, E3, E4, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityEndWithExpressionBase4<E, E2, E3, E4, C, L> {

    /**
     * end with value. 以value结尾.
     *
     * @param endWithEntityExpressions the end with entity expressions
     * @return the LogicExpression
     */
    L ew(Consumer<Tuple4<EndWithEntityExpression<E>, EndWithEntityExpression<E2>, EndWithEntityExpression<E3>,
        EndWithEntityExpression<E4>>> endWithEntityExpressions);

    /**
     * end with value. 以value结尾.
     *
     * @param endWithEntityExpressions the end with entity expressions
     * @return the LogicExpression
     */
    L ew(FourArgusConsumer<EndWithEntityExpression<E>, EndWithEntityExpression<E2>, EndWithEntityExpression<E3>,
        EndWithEntityExpression<E4>> endWithEntityExpressions);
}