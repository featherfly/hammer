
package cn.featherfly.hammer.expression.entity.condition.inn;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityIsNotNullExpression3.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityIsNotNullExpression3<E, E2, E3, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityIsNotNullExpressionBase3<E, E2, E3, C, L> {

    /**
     * is not null.
     *
     * @param isNotNullEntityExpressions the is not null entity expressions
     * @return the LogicExpression
     */
    L inn(Consumer<Tuple3<IsNotNullEntityExpression<E>, IsNotNullEntityExpression<E2>,
        IsNotNullEntityExpression<E3>>> isNotNullEntityExpressions);

    /**
     * is not null.
     *
     * @param isNotNullEntityExpressions the is not null entity expressions
     * @return the LogicExpression
     */
    L inn(ThreeArgusConsumer<IsNotNullEntityExpression<E>, IsNotNullEntityExpression<E2>,
        IsNotNullEntityExpression<E3>> isNotNullEntityExpressions);

}