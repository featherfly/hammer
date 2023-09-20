
package cn.featherfly.hammer.expression.entity.condition.ba;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityBetweenExpression5.
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
public interface EntityBetweenExpression5<E, E2, E3, E4, E5, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityBetweenExpressionBase5<E, E2, E3, E4, E5, C, L> {

    /**
     * between and.
     *
     * @param betweenEntityExpressions the between entity expressions
     * @return the LogicExpression
     */
    L ba(Consumer<Tuple5<BetweenEntityExpression<E>, BetweenEntityExpression<E2>, BetweenEntityExpression<E3>,
            BetweenEntityExpression<E4>, BetweenEntityExpression<E5>>> betweenEntityExpressions);

    /**
     * between and.
     *
     * @param betweenEntityExpressions the between entity expressions
     * @return the LogicExpression
     */
    L ba(FiveArgusConsumer<BetweenEntityExpression<E>, BetweenEntityExpression<E2>, BetweenEntityExpression<E3>,
            BetweenEntityExpression<E4>, BetweenEntityExpression<E5>> betweenEntityExpressions);
}