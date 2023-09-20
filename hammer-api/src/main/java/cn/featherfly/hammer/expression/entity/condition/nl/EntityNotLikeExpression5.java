
package cn.featherfly.hammer.expression.entity.condition.nl;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotLikeExpression5.
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
public interface EntityNotLikeExpression5<E, E2, E3, E4, E5, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityNotLikeExpressionBase5<E, E2, E3, E4, E5, C, L> {

    /**
     * not like value.
     *
     * @param notLikeEntityExpressions the not like entity expressions
     * @return the LogicExpression
     */
    L nl(Consumer<Tuple5<NotLikeEntityExpression<E>, NotLikeEntityExpression<E2>, NotLikeEntityExpression<E3>,
            NotLikeEntityExpression<E4>, NotLikeEntityExpression<E5>>> notLikeEntityExpressions);

    /**
     * not like value.
     *
     * @param notLikeEntityExpressions the not like entity expressions
     * @return the LogicExpression
     */
    L nl(FiveArgusConsumer<NotLikeEntityExpression<E>, NotLikeEntityExpression<E2>, NotLikeEntityExpression<E3>,
            NotLikeEntityExpression<E4>, NotLikeEntityExpression<E5>> notLikeEntityExpressions);

}