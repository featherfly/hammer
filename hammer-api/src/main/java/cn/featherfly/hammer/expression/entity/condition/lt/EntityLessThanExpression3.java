
package cn.featherfly.hammer.expression.entity.condition.lt;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLessThanExpression3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityLessThanExpression3<E, E2, E3, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityLessThanExpressionBase3<E, E2, E3, C, L> {

    /**
     * less than. 小于.
     *
     * @param lessThanEntityExpressions the less than entity expressions
     * @return the LogicExpression
     */
    L lt(Consumer<Tuple3<LessThanEntityExpression<E>, LessThanEntityExpression<E2>,
            LessThanEntityExpression<E3>>> lessThanEntityExpressions);

    /**
     * less than. 小于.
     *
     * @param lessThanEntityExpressions the less than entity expressions
     * @return the LogicExpression
     */
    L lt(ThreeArgusConsumer<LessThanEntityExpression<E>, LessThanEntityExpression<E2>,
            LessThanEntityExpression<E3>> lessThanEntityExpressions);
}