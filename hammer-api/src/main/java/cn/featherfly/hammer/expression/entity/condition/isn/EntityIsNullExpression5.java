
package cn.featherfly.hammer.expression.entity.condition.isn;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityIsNullExpression5.
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
public interface EntityIsNullExpression5<E, E2, E3, E4, E5, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityIsNullExpressionBase5<E, E2, E3, E4, E5, C, L> {

    /**
     * is null.
     *
     * @param isNullEntityExpressions the is null entity expressions
     * @return the LogicExpression
     */
    L isn(Consumer<Tuple5<IsNullEntityExpression<E>, IsNullEntityExpression<E2>, IsNullEntityExpression<E3>, IsNullEntityExpression<E4>, IsNullEntityExpression<E5>>> isNullEntityExpressions);

    /**
     * is null.
     *
     * @param isNullEntityExpressions the is null entity expressions
     * @return the LogicExpression
     */
    L isn(FiveArgusConsumer<IsNullEntityExpression<E>, IsNullEntityExpression<E2>, IsNullEntityExpression<E3>, IsNullEntityExpression<E4>, IsNullEntityExpression<E5>> isNullEntityExpressions);
}