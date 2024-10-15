
package cn.featherfly.hammer.expression.entity.condition.lt;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLessThanExpression6.
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
public interface EntityLessThanExpression6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityLessThanExpressionBase6<E, E2, E3, E4, E5, E6, C, L> {

    /**
     * less than. 小于.
     *
     * @param lessThanEntityExpressions the less than entity expressions
     * @return the LogicExpression
     */
    L lt(Consumer<Tuple6<LessThanEntityExpression<E>, LessThanEntityExpression<E2>, LessThanEntityExpression<E3>,
            LessThanEntityExpression<E4>, LessThanEntityExpression<E5>,
            LessThanEntityExpression<E6>>> lessThanEntityExpressions);

    /**
     * less than. 小于.
     *
     * @param lessThanEntityExpressions the less than entity expressions
     * @return the LogicExpression
     */
    L lt(SixArgusConsumer<LessThanEntityExpression<E>, LessThanEntityExpression<E2>, LessThanEntityExpression<E3>,
            LessThanEntityExpression<E4>, LessThanEntityExpression<E5>,
            LessThanEntityExpression<E6>> lessThanEntityExpressions);
}