
package cn.featherfly.hammer.expression.entity.compatible.condition.co;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * entity contains compatible expression4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityContainsCompatibleExpression4<E, E2, E3, E4, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityContainsCompatibleExpressionBase4<E, E2, E3, E4, C, L> {

    /**
     * contains value. 包含value.
     *
     * @param containsEntityExpressions the contains entity expressions
     * @return the LogicExpression
     */
    L co(Consumer<Tuple4<ContainsEntityCompatibleExpression<E>, ContainsEntityCompatibleExpression<E2>,
            ContainsEntityCompatibleExpression<E3>, ContainsEntityCompatibleExpression<E4>>> containsEntityExpressions);

    /**
     * contains value. 包含value.
     *
     * @param containsEntityExpressions the contains entity expressions
     * @return the LogicExpression
     */
    L co(FourArgusConsumer<ContainsEntityCompatibleExpression<E>, ContainsEntityCompatibleExpression<E2>,
            ContainsEntityCompatibleExpression<E3>, ContainsEntityCompatibleExpression<E4>> containsEntityExpressions);
}