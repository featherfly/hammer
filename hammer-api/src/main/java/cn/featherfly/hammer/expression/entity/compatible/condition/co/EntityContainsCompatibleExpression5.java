
package cn.featherfly.hammer.expression.entity.compatible.condition.co;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * entity contains compatible expression5.
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
public interface EntityContainsCompatibleExpression5<E, E2, E3, E4, E5, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityContainsCompatibleExpressionBase5<E, E2, E3, E4, E5, C, L> {

    /**
     * contains value. 包含value.
     *
     * @param containsEntityExpressions the contains entity expressions
     * @return the LogicExpression
     */
    L co(Consumer<Tuple5<ContainsEntityCompatibleExpression<E>, ContainsEntityCompatibleExpression<E2>,
            ContainsEntityCompatibleExpression<E3>, ContainsEntityCompatibleExpression<E4>,
            ContainsEntityCompatibleExpression<E5>>> containsEntityExpressions);

    /**
     * contains value. 包含value.
     *
     * @param containsEntityExpressions the contains entity expressions
     * @return the LogicExpression
     */
    L co(FiveArgusConsumer<ContainsEntityCompatibleExpression<E>, ContainsEntityCompatibleExpression<E2>,
            ContainsEntityCompatibleExpression<E3>, ContainsEntityCompatibleExpression<E4>,
            ContainsEntityCompatibleExpression<E5>> containsEntityExpressions);
}