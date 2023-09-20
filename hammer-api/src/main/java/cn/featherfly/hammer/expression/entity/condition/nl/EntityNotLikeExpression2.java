
package cn.featherfly.hammer.expression.entity.condition.nl;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotLikeExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotLikeExpression2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityNotLikeExpressionBase2<E, E2, C, L> {

    /**
     * not like value.
     *
     * @param notLikeEntityExpressions the not like entity expressions
     * @return the LogicExpression
     */
    L nl(Consumer<Tuple2<NotLikeEntityExpression<E>, NotLikeEntityExpression<E2>>> notLikeEntityExpressions);

    /**
     * not like value.
     *
     * @param notLikeEntityExpressions the not like entity expressions
     * @return the LogicExpression
     */
    L nl(BiConsumer<NotLikeEntityExpression<E>, NotLikeEntityExpression<E2>> notLikeEntityExpressions);
}