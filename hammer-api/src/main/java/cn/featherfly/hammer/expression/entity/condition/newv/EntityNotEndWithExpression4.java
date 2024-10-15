
package cn.featherfly.hammer.expression.entity.condition.newv;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotEndWithExpression4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotEndWithExpression4<E, E2, E3, E4, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityNotEndWithExpressionBase4<E, E2, E3, E4, C, L> {

    /**
     * not end with value. 不以value结尾.
     *
     * @param notEndWithEntityExpressions the not end with entity expressions
     * @return the LogicExpression
     */
    L newv(Consumer<Tuple4<NotEndWithEntityExpression<E>, NotEndWithEntityExpression<E2>,
            NotEndWithEntityExpression<E3>, NotEndWithEntityExpression<E4>>> notEndWithEntityExpressions);

    /**
     * not end with value. 不以value结尾.
     *
     * @param notEndWithEntityExpressions the not end with entity expressions
     * @return the LogicExpression
     */
    L newv(FourArgusConsumer<NotEndWithEntityExpression<E>, NotEndWithEntityExpression<E2>,
            NotEndWithEntityExpression<E3>, NotEndWithEntityExpression<E4>> notEndWithEntityExpressions);
}