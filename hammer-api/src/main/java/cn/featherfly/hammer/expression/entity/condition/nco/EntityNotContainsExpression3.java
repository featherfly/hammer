
package cn.featherfly.hammer.expression.entity.condition.nco;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotContainsExpression3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotContainsExpression3<E, E2, E3, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityNotContainsExpressionBase3<E, E2, E3, C, L> {

    /**
     * not contains value. 不包含value.
     *
     * @param notContainsEntityExpressions the not contains entity expressions
     * @return the LogicExpression
     */
    L nco(Consumer<Tuple3<NotContainsEntityExpression<E>, NotContainsEntityExpression<E2>,
            NotContainsEntityExpression<E3>>> notContainsEntityExpressions);

    /**
     * not contains value. 不包含value.
     *
     * @param notContainsEntityExpressions the not contains entity expressions
     * @return the LogicExpression
     */
    L nco(ThreeArgusConsumer<NotContainsEntityExpression<E>, NotContainsEntityExpression<E2>,
            NotContainsEntityExpression<E3>> notContainsEntityExpressions);
}