
package cn.featherfly.hammer.expression.entity.condition.nl;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotLikeExpression3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotLikeExpression3<E, E2, E3, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityNotLikeExpressionBase3<E, E2, E3, C, L> {

    /**
     * not like value.
     *
     * @param notLikeEntityExpressions the not like entity expressions
     * @return the LogicExpression
     */
    L nl(Consumer<Tuple3<NotLikeEntityExpression<E>, NotLikeEntityExpression<E2>,
            NotLikeEntityExpression<E3>>> notLikeEntityExpressions);

    /**
     * not like value.
     *
     * @param notLikeEntityExpressions the not like entity expressions
     * @return the LogicExpression
     */
    L nl(ThreeArgusConsumer<NotLikeEntityExpression<E>, NotLikeEntityExpression<E2>,
            NotLikeEntityExpression<E3>> notLikeEntityExpressions);
}