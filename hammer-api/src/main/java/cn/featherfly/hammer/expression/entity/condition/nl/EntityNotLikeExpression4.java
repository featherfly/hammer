
package cn.featherfly.hammer.expression.entity.condition.nl;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotLikeExpression4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotLikeExpression4<E, E2, E3, E4, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityNotLikeExpressionBase4<E, E2, E3, E4, C, L> {

    /**
     * not like value.
     *
     * @param notLikeEntityExpressions the not like entity expressions
     * @return the LogicExpression
     */
    L nl(Consumer<Tuple4<NotLikeEntityExpression<E>, NotLikeEntityExpression<E2>, NotLikeEntityExpression<E3>,
            NotLikeEntityExpression<E4>>> notLikeEntityExpressions);

    /**
     * not like value.
     *
     * @param notLikeEntityExpressions the not like entity expressions
     * @return the LogicExpression
     */
    L nl(FourArgusConsumer<NotLikeEntityExpression<E>, NotLikeEntityExpression<E2>, NotLikeEntityExpression<E3>,
            NotLikeEntityExpression<E4>> notLikeEntityExpressions);
}