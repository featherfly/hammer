
package cn.featherfly.hammer.expression.entity.condition.newv;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotEndWithExpression3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotEndWithExpression3<E, E2, E3, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityNotEndWithExpressionBase3<E, E2, E3, C, L> {

    /**
     * not end with value. 不以value结尾.
     *
     * @param notEndWithEntityExpressions the not end with entity expressions
     * @return the LogicExpression
     */
    L newv(Consumer<Tuple3<NotEndWithEntityExpression<E>, NotEndWithEntityExpression<E2>,
            NotEndWithEntityExpression<E3>>> notEndWithEntityExpressions);

    /**
     * not end with value. 不以value结尾.
     *
     * @param notEndWithEntityExpressions the not end with entity expressions
     * @return the LogicExpression
     */
    L newv(ThreeArgusConsumer<NotEndWithEntityExpression<E>, NotEndWithEntityExpression<E2>,
            NotEndWithEntityExpression<E3>> notEndWithEntityExpressions);
}