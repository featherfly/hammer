
package cn.featherfly.hammer.expression.entity.condition.ba;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityBetweenExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityBetweenExpression2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityBetweenExpressionBase2<E, E2, C, L> {

    /**
     * between and.
     *
     * @param betweenEntityExpressions the between entity expressions
     * @return the LogicExpression
     */
    L ba(Consumer<Tuple2<BetweenEntityExpression<E>, BetweenEntityExpression<E2>>> betweenEntityExpressions);

    /**
     * between and.
     *
     * @param betweenEntityExpressions the between entity expressions
     * @return the LogicExpression
     */
    L ba(BiConsumer<BetweenEntityExpression<E>, BetweenEntityExpression<E2>> betweenEntityExpressions);
}