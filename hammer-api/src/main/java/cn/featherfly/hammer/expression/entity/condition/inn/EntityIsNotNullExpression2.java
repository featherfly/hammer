
package cn.featherfly.hammer.expression.entity.condition.inn;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityIsNotNullExpression2.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityIsNotNullExpression2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityIsNotNullExpressionBase2<E, E2, C, L> {

    /**
     * is not null.
     *
     * @param isNotNullEntityExpressions the is not null entity expressions
     * @return the LogicExpression
     */
    L inn(Consumer<Tuple2<IsNotNullEntityExpression<E>, IsNotNullEntityExpression<E2>>> isNotNullEntityExpressions);

    /**
     * is not null.
     *
     * @param isNotNullEntityExpressions the is not null entity expressions
     * @return the LogicExpression
     */
    L inn(BiConsumer<IsNotNullEntityExpression<E>, IsNotNullEntityExpression<E2>> isNotNullEntityExpressions);

}