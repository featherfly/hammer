
package cn.featherfly.hammer.expression.entity.compatible.condition.co;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * entity contains compatible expression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityContainsCompatibleExpression2<E, E2, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityContainsCompatibleExpressionBase2<E, E2, C, L> {

    /**
     * contains value. 包含value.
     *
     * @param containsEntityExpressions the contains entity expressions
     * @return the LogicExpression
     */
    L co(Consumer<Tuple2<ContainsEntityCompatibleExpression<E>,
            ContainsEntityCompatibleExpression<E2>>> containsEntityExpressions);

    /**
     * contains value. 包含value.
     *
     * @param containsEntityExpressions the contains entity expressions
     * @return the LogicExpression
     */
    L co(BiConsumer<ContainsEntityCompatibleExpression<E>,
            ContainsEntityCompatibleExpression<E2>> containsEntityExpressions);
}