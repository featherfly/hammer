
package cn.featherfly.hammer.expression.entity.condition.ne;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotEqualsExpression3.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityNotEqualsExpression3<E, E2, E3, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityNotEqualsExpressionBase3<E, E2, E3, C, L> {

    /**
     * equals. 等于.
     *
     * @param notEqualsEntityExpressions the not equals entity expressions
     * @return the LogicExpression
     */
    L ne(Consumer<Tuple3<NotEqualsEntityExpression<E>, NotEqualsEntityExpression<E2>,
        NotEqualsEntityExpression<E3>>> notEqualsEntityExpressions);

    /**
     * equals. 等于.
     *
     * @param notEqualsEntityExpressions the not equals entity expressions
     * @return the LogicExpression
     */
    L ne(ThreeArgusConsumer<NotEqualsEntityExpression<E>, NotEqualsEntityExpression<E2>,
        NotEqualsEntityExpression<E3>> notEqualsEntityExpressions);

}