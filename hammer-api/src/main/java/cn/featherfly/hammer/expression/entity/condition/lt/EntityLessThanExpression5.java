
package cn.featherfly.hammer.expression.entity.condition.lt;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLessThanExpression5.
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
public interface EntityLessThanExpression5<E, E2, E3, E4, E5, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityLessThanExpressionBase5<E, E2, E3, E4, E5, C, L> {

    /**
     * less than. 小于.
     *
     * @param lessThanEntityExpressions the less than entity expressions
     * @return the LogicExpression
     */
    L lt(Consumer<Tuple5<LessThanEntityExpression<E>, LessThanEntityExpression<E2>, LessThanEntityExpression<E3>,
            LessThanEntityExpression<E4>, LessThanEntityExpression<E5>>> lessThanEntityExpressions);

    /**
     * less than. 小于.
     *
     * @param lessThanEntityExpressions the less than entity expressions
     * @return the LogicExpression
     */
    L lt(FiveArgusConsumer<LessThanEntityExpression<E>, LessThanEntityExpression<E2>, LessThanEntityExpression<E3>,
            LessThanEntityExpression<E4>, LessThanEntityExpression<E5>> lessThanEntityExpressions);
}