
package cn.featherfly.hammer.expression.entity.condition.nco;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotContainsExpression6.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotContainsExpression6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityNotContainsExpressionBase6<E, E2, E3, E4, E5, E6, C, L> {

    /**
     * not contains value. 不包含value.
     *
     * @param notContainsEntityExpressions the not contains entity expressions
     * @return the LogicExpression
     */
    L nco(Consumer<Tuple6<NotContainsEntityExpression<E>, NotContainsEntityExpression<E2>,
            NotContainsEntityExpression<E3>, NotContainsEntityExpression<E4>, NotContainsEntityExpression<E5>,
            NotContainsEntityExpression<E6>>> notContainsEntityExpressions);

    /**
     * not contains value. 不包含value.
     *
     * @param notContainsEntityExpressions the not contains entity expressions
     * @return the LogicExpression
     */
    L nco(SixArgusConsumer<NotContainsEntityExpression<E>, NotContainsEntityExpression<E2>,
            NotContainsEntityExpression<E3>, NotContainsEntityExpression<E4>, NotContainsEntityExpression<E5>,
            NotContainsEntityExpression<E6>> notContainsEntityExpressions);
}