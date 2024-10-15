
package cn.featherfly.hammer.expression.entity.condition.ba;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityBetweenExpression3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityBetweenExpression3<E, E2, E3, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityBetweenExpressionBase3<E, E2, E3, C, L> {

    /**
     * between and.
     *
     * @param betweenEntityExpressions the between entity expressions
     * @return the LogicExpression
     */
    L ba(Consumer<Tuple3<BetweenEntityExpression<E>, BetweenEntityExpression<E2>,
            BetweenEntityExpression<E3>>> betweenEntityExpressions);

    /**
     * between and.
     *
     * @param betweenEntityExpressions the between entity expressions
     * @return the LogicExpression
     */
    L ba(ThreeArgusConsumer<BetweenEntityExpression<E>, BetweenEntityExpression<E2>,
            BetweenEntityExpression<E3>> betweenEntityExpressions);
}