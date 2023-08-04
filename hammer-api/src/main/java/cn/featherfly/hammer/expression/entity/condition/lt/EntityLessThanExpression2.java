
package cn.featherfly.hammer.expression.entity.condition.lt;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLessThanExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityLessThanExpression2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityLessThanExpressionBase2<E, E2, C, L> {

    /**
     * less than. 小于.
     *
     * @param lessThanEntityExpressions the less than entity expressions
     * @return the LogicExpression
     */
    L lt(Consumer<Tuple2<LessThanEntityExpression<E>, LessThanEntityExpression<E2>>> lessThanEntityExpressions);

    /**
     * less than. 小于.
     *
     * @param lessThanEntityExpressions the less than entity expressions
     * @return the LogicExpression
     */
    L lt(BiConsumer<LessThanEntityExpression<E>, LessThanEntityExpression<E2>> lessThanEntityExpressions);
}