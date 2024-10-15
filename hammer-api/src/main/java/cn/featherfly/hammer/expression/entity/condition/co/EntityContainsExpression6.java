
package cn.featherfly.hammer.expression.entity.condition.co;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityContainsExpression5.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityContainsExpression6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends EntityContainsExpressionBase6<E, E2, E3, E4, E5, E6, C, L> {

    /**
     * contains value. 包含value.
     *
     * @param containsEntityExpressions the contains entity expressions
     * @return the LogicExpression
     */
    L co(Consumer<Tuple6<ContainsEntityExpression<E>, ContainsEntityExpression<E2>, ContainsEntityExpression<E3>,
        ContainsEntityExpression<E4>, ContainsEntityExpression<E5>,
        ContainsEntityExpression<E6>>> containsEntityExpressions);

    /**
     * contains value. 包含value.
     *
     * @param containsEntityExpressions the contains entity expressions
     * @return the LogicExpression
     */
    L co(SixArgusConsumer<ContainsEntityExpression<E>, ContainsEntityExpression<E2>, ContainsEntityExpression<E3>,
        ContainsEntityExpression<E4>, ContainsEntityExpression<E5>,
        ContainsEntityExpression<E6>> containsEntityExpressions);
}