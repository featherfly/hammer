
package cn.featherfly.hammer.expression.entity.condition.nco;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotContainsExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotContainsExpression2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityNotContainsExpressionBase2<E, E2, C, L> {

    /**
     * not contains value. 不包含value.
     *
     * @param notContainsEntityExpressions the not contains entity expressions
     * @return the LogicExpression
     */
    L nco(Consumer<
            Tuple2<NotContainsEntityExpression<E>, NotContainsEntityExpression<E2>>> notContainsEntityExpressions);

    /**
     * not contains value. 不包含value.
     *
     * @param notContainsEntityExpressions the not contains entity expressions
     * @return the LogicExpression
     */
    L nco(BiConsumer<NotContainsEntityExpression<E>, NotContainsEntityExpression<E2>> notContainsEntityExpressions);
}