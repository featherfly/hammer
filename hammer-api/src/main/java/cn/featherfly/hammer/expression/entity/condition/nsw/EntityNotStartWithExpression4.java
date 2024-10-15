
package cn.featherfly.hammer.expression.entity.condition.nsw;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotStartWithExpression4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotStartWithExpression4<E, E2, E3, E4, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityNotStartWithExpressionBase4<E, E2, E3, E4, C, L> {

    /**
     * not start with value. 不以value开始.
     *
     * @param notStartWithEntityExpressions the not start with entity
     *                                      expressions
     * @return the LogicExpression
     */
    L nsw(Consumer<Tuple4<NotStartWithEntityExpression<E>, NotStartWithEntityExpression<E2>,
            NotStartWithEntityExpression<E3>, NotStartWithEntityExpression<E4>>> notStartWithEntityExpressions);

    /**
     * not start with value. 不以value开始.
     *
     * @param notStartWithEntityExpressions the not start with entity
     *                                      expressions
     * @return the LogicExpression
     */
    L nsw(FourArgusConsumer<NotStartWithEntityExpression<E>, NotStartWithEntityExpression<E2>,
            NotStartWithEntityExpression<E3>, NotStartWithEntityExpression<E4>> notStartWithEntityExpressions);
}