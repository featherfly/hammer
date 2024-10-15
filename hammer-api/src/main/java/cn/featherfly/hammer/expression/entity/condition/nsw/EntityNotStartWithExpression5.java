
package cn.featherfly.hammer.expression.entity.condition.nsw;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityStartWithExpression5.
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
public interface EntityNotStartWithExpression5<E, E2, E3, E4, E5, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityNotStartWithExpressionBase5<E, E2, E3, E4, E5, C, L> {

    /**
     * not start with value. 不以value开始.
     *
     * @param notStartWithEntityExpressions the not start with entity
     *                                      expressions
     * @return the LogicExpression
     */
    L nsw(Consumer<
            Tuple5<NotStartWithEntityExpression<E>, NotStartWithEntityExpression<E2>, NotStartWithEntityExpression<E3>,
                    NotStartWithEntityExpression<E4>, NotStartWithEntityExpression<E5>>> notStartWithEntityExpressions);

    /**
     * not start with value. 不以value开始.
     *
     * @param notStartWithEntityExpressions the not start with entity
     *                                      expressions
     * @return the LogicExpression
     */
    L nsw(FiveArgusConsumer<NotStartWithEntityExpression<E>, NotStartWithEntityExpression<E2>,
            NotStartWithEntityExpression<E3>, NotStartWithEntityExpression<E4>,
            NotStartWithEntityExpression<E5>> notStartWithEntityExpressions);
}