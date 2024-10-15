
package cn.featherfly.hammer.expression.entity.condition.nco;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotContainsExpression5.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotContainsExpression5<E, E2, E3, E4, E5, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityNotContainsExpressionBase5<E, E2, E3, E4, E5, C, L> {

    /**
     * not contains value. 不包含value.
     *
     * @param notContainsEntityExpressions the not contains entity expressions
     * @return the LogicExpression
     */
    L nco(Consumer<
            Tuple5<NotContainsEntityExpression<E>, NotContainsEntityExpression<E2>, NotContainsEntityExpression<E3>,
                    NotContainsEntityExpression<E4>, NotContainsEntityExpression<E5>>> notContainsEntityExpressions);

    /**
     * not contains value. 不包含value.
     *
     * @param notContainsEntityExpressions the not contains entity expressions
     * @return the LogicExpression
     */
    L nco(FiveArgusConsumer<NotContainsEntityExpression<E>, NotContainsEntityExpression<E2>,
            NotContainsEntityExpression<E3>, NotContainsEntityExpression<E4>,
            NotContainsEntityExpression<E5>> notContainsEntityExpressions);
}