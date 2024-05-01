
package cn.featherfly.hammer.expression.entity.condition.ge;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityGreatEqualsExpression3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityGreatEqualsExpression3<E, E2, E3, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityGreatEqualsExpressionBase3<E, E2, E3, C, L> {

    /**
     * great and equals. 大于等于.
     *
     * @param greatEqualsEntityExpressions the great equals entity expressions
     * @return the LogicExpression
     */
    L ge(Consumer<Tuple3<GreatEqualsEntityExpression<E>, GreatEqualsEntityExpression<E2>, GreatEqualsEntityExpression<E3>>> greatEqualsEntityExpressions);

    /**
     * great and equals. 大于等于.
     *
     * @param greatEqualsEntityExpressions the great equals entity expressions
     * @return the LogicExpression
     */
    L ge(ThreeArgusConsumer<GreatEqualsEntityExpression<E>, GreatEqualsEntityExpression<E2>, GreatEqualsEntityExpression<E3>> greatEqualsEntityExpressions);
}