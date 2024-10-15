
package cn.featherfly.hammer.expression.entity.condition.ne;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotEqualsExpression4.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityNotEqualsExpression4<E, E2, E3, E4, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends EntityNotEqualsExpressionBase4<E, E2, E3, E4, C, L> {

    /**
     * equals. 等于.
     *
     * @param notEqualsEntityExpressions the not equals entity expressions
     * @return the LogicExpression
     */
    L ne(Consumer<Tuple4<NotEqualsEntityExpression<E>, NotEqualsEntityExpression<E2>, NotEqualsEntityExpression<E3>,
        NotEqualsEntityExpression<E4>>> notEqualsEntityExpressions);

    /**
     * equals. 等于.
     *
     * @param notEqualsEntityExpressions the not equals entity expressions
     * @return the LogicExpression
     */
    L ne(FourArgusConsumer<NotEqualsEntityExpression<E>, NotEqualsEntityExpression<E2>, NotEqualsEntityExpression<E3>,
        NotEqualsEntityExpression<E4>> notEqualsEntityExpressions);
}