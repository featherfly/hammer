
package cn.featherfly.hammer.expression.entity.compatible.condition.co;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * entity contains compatible expression6.
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
public interface EntityContainsCompatibleExpression6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityContainsCompatibleExpressionBase6<E, E2, E3, E4, E5, E6, C, L> {

    /**
     * contains value. 包含value.
     *
     * @param containsEntityExpressions the contains entity expressions
     * @return the LogicExpression
     */
    L co(Consumer<Tuple6<ContainsEntityCompatibleExpression<E>, ContainsEntityCompatibleExpression<E2>,
            ContainsEntityCompatibleExpression<E3>, ContainsEntityCompatibleExpression<E4>,
            ContainsEntityCompatibleExpression<E5>, ContainsEntityCompatibleExpression<E6>>> containsEntityExpressions);

    /**
     * contains value. 包含value.
     *
     * @param containsEntityExpressions the contains entity expressions
     * @return the LogicExpression
     */
    L co(SixArgusConsumer<ContainsEntityCompatibleExpression<E>, ContainsEntityCompatibleExpression<E2>,
            ContainsEntityCompatibleExpression<E3>, ContainsEntityCompatibleExpression<E4>,
            ContainsEntityCompatibleExpression<E5>, ContainsEntityCompatibleExpression<E6>> containsEntityExpressions);
}