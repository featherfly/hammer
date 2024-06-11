
package cn.featherfly.hammer.expression.entity.condition.co;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityContainsExpression2.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityContainsExpression2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityContainsExpressionBase2<E, E2, C, L> {

    /**
     * contains value. 包含value.
     *
     * @param containsEntityExpressions the contains entity expressions
     * @return the LogicExpression
     */
    L co(Consumer<Tuple2<ContainsEntityExpression<E>, ContainsEntityExpression<E2>>> containsEntityExpressions);

    /**
     * contains value. 包含value.
     *
     * @param containsEntityExpressions the contains entity expressions
     * @return the LogicExpression
     */
    L co(BiConsumer<ContainsEntityExpression<E>, ContainsEntityExpression<E2>> containsEntityExpressions);
}