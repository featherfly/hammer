
package cn.featherfly.hammer.expression.entity.compatible.condition.co;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * entity contains compatible expression3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityContainsCompatibleExpression3<E, E2, E3, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityContainsCompatibleExpressionBase3<E, E2, E3, C, L> {

    /**
     * contains value. 包含value.
     *
     * @param containsEntityExpressions the contains entity expressions
     * @return the LogicExpression
     */
    L co(Consumer<Tuple3<ContainsEntityCompatibleExpression<E>, ContainsEntityCompatibleExpression<E2>,
            ContainsEntityCompatibleExpression<E3>>> containsEntityExpressions);

    /**
     * contains value. 包含value.
     *
     * @param containsEntityExpressions the contains entity expressions
     * @return the LogicExpression
     */
    L co(ThreeArgusConsumer<ContainsEntityCompatibleExpression<E>, ContainsEntityCompatibleExpression<E2>,
            ContainsEntityCompatibleExpression<E3>> containsEntityExpressions);
}