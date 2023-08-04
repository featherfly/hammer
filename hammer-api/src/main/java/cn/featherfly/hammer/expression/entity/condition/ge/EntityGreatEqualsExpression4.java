
package cn.featherfly.hammer.expression.entity.condition.ge;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityGreatEqualsExpression4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityGreatEqualsExpression4<E, E2, E3, E4, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityGreatEqualsExpressionBase4<E, E2, E3, E4, C, L> {

    /**
     * great and equals. 大于等于.
     *
     * @param greatEqualsEntityExpressions the great equals entity expressions
     * @return the LogicExpression
     */
    L ge(Consumer<Tuple4<GreatEqualsEntityExpression<E>, GreatEqualsEntityExpression<E2>,
            GreatEqualsEntityExpression<E3>, GreatEqualsEntityExpression<E4>>> greatEqualsEntityExpressions);

    /**
     * great and equals. 大于等于.
     *
     * @param greatEqualsEntityExpressions the great equals entity expressions
     * @return the LogicExpression
     */
    L ge(FourArgusConsumer<GreatEqualsEntityExpression<E>, GreatEqualsEntityExpression<E2>,
            GreatEqualsEntityExpression<E3>, GreatEqualsEntityExpression<E4>> greatEqualsEntityExpressions);
}