
package cn.featherfly.hammer.expression.entity.condition.inn;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityIsNotNullExpression4.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityIsNotNullExpression4<E, E2, E3, E4, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends EntityIsNotNullExpressionBase4<E, E2, E3, E4, C, L> {

    /**
     * is not null.
     *
     * @param isNotNullEntityExpressions the is not null entity expressions
     * @return the LogicExpression
     */
    L inn(Consumer<Tuple4<IsNotNullEntityExpression<E>, IsNotNullEntityExpression<E2>, IsNotNullEntityExpression<E3>,
        IsNotNullEntityExpression<E4>>> isNotNullEntityExpressions);

    /**
     * is not null.
     *
     * @param isNotNullEntityExpressions the is not null entity expressions
     * @return the LogicExpression
     */
    L inn(FourArgusConsumer<IsNotNullEntityExpression<E>, IsNotNullEntityExpression<E2>, IsNotNullEntityExpression<E3>,
        IsNotNullEntityExpression<E4>> isNotNullEntityExpressions);

}