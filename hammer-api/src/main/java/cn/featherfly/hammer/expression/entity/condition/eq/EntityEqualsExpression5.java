
package cn.featherfly.hammer.expression.entity.condition.eq;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityEqualsExpression2.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityEqualsExpression5<E, E2, E3, E4, E5, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends EntityEqualsExpressionBase5<E, E2, E3, E4, E5, C, L> {

    /**
     * equals. 等于.
     *
     * @param equalsEntityExpressions the equals entity expressions
     * @return the LogicExpression
     */
    L eq(Consumer<Tuple5<EqualsEntityExpression<E>, EqualsEntityExpression<E2>, EqualsEntityExpression<E3>,
        EqualsEntityExpression<E4>, EqualsEntityExpression<E5>>> equalsEntityExpressions);

    /**
     * equals. 等于.
     *
     * @param equalsEntityExpressions the equals entity expressions
     * @return the LogicExpression
     */
    L eq(FiveArgusConsumer<EqualsEntityExpression<E>, EqualsEntityExpression<E2>, EqualsEntityExpression<E3>,
        EqualsEntityExpression<E4>, EqualsEntityExpression<E5>> equalsEntityExpressions);

}