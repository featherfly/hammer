
package cn.featherfly.hammer.expression.entity.condition.nco;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotContainsExpression4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotContainsExpression4<E, E2, E3, E4, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityNotContainsExpressionBase4<E, E2, E3, E4, C, L> {

    /**
     * not contains value. 不包含value.
     *
     * @param notContainsEntityExpressions the not contains entity expressions
     * @return the LogicExpression
     */
    L nco(Consumer<Tuple4<NotContainsEntityExpression<E>, NotContainsEntityExpression<E2>,
            NotContainsEntityExpression<E3>, NotContainsEntityExpression<E4>>> notContainsEntityExpressions);

    /**
     * not contains value. 不包含value.
     *
     * @param notContainsEntityExpressions the not contains entity expressions
     * @return the LogicExpression
     */
    L nco(FourArgusConsumer<NotContainsEntityExpression<E>, NotContainsEntityExpression<E2>,
            NotContainsEntityExpression<E3>, NotContainsEntityExpression<E4>> notContainsEntityExpressions);
}