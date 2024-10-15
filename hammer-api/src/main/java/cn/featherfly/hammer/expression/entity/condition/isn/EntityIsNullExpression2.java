
package cn.featherfly.hammer.expression.entity.condition.isn;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityIsNullExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityIsNullExpression2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityIsNullExpressionBase2<E, E2, C, L> {

    /**
     * is null.
     *
     * @param isNullEntityExpressions the is null entity expressions
     * @return the LogicExpression
     */
    L isn(Consumer<Tuple2<IsNullEntityExpression<E>, IsNullEntityExpression<E2>>> isNullEntityExpressions);

    /**
     * is null.
     *
     * @param isNullEntityExpressions the is null entity expressions
     * @return the LogicExpression
     */
    L isn(BiConsumer<IsNullEntityExpression<E>, IsNullEntityExpression<E2>> isNullEntityExpressions);
}