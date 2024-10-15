
package cn.featherfly.hammer.expression.entity.condition.ge;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityGreatEqualsExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityGreatEqualsExpression2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityGreatEqualsExpressionBase2<E, E2, C, L> {

    /**
     * great and equals. 大于等于.
     *
     * @param greatEqualsEntityExpressions the great equals entity expressions
     * @return the LogicExpression
     */
    L ge(Consumer<
            Tuple2<GreatEqualsEntityExpression<E>, GreatEqualsEntityExpression<E2>>> greatEqualsEntityExpressions);

    /**
     * great and equals. 大于等于.
     *
     * @param greatEqualsEntityExpressions the great equals entity expressions
     * @return the LogicExpression
     */
    L ge(BiConsumer<GreatEqualsEntityExpression<E>, GreatEqualsEntityExpression<E2>> greatEqualsEntityExpressions);
}