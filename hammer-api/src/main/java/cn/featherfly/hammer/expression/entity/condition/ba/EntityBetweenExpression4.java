
package cn.featherfly.hammer.expression.entity.condition.ba;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityBetweenExpression4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityBetweenExpression4<E, E2, E3, E4, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityBetweenExpressionBase4<E, E2, E3, E4, C, L> {

    /**
     * between and.
     *
     * @param betweenEntityExpressions the between entity expressions
     * @return the LogicExpression
     */
    L ba(Consumer<Tuple4<BetweenEntityExpression<E>, BetweenEntityExpression<E2>, BetweenEntityExpression<E3>,
            BetweenEntityExpression<E4>>> betweenEntityExpressions);

    /**
     * between and.
     *
     * @param betweenEntityExpressions the between entity expressions
     * @return the LogicExpression
     */
    L ba(FourArgusConsumer<BetweenEntityExpression<E>, BetweenEntityExpression<E2>, BetweenEntityExpression<E3>,
            BetweenEntityExpression<E4>> betweenEntityExpressions);
}