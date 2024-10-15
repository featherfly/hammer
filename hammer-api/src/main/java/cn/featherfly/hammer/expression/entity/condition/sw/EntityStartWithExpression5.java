
package cn.featherfly.hammer.expression.entity.condition.sw;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityStartWithExpression5.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityStartWithExpression5<E, E2, E3, E4, E5, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends EntityStartWithExpressionBase5<E, E2, E3, E4, E5, C, L> {

    /**
     * start with value. 以value开始.
     *
     * @param startWithEntityExpressions the start with entity expressions
     * @return the LogicExpression
     */
    L sw(Consumer<Tuple5<StartWithEntityExpression<E>, StartWithEntityExpression<E2>, StartWithEntityExpression<E3>,
        StartWithEntityExpression<E4>, StartWithEntityExpression<E5>>> startWithEntityExpressions);

    /**
     * start with value. 以value开始.
     *
     * @param startWithEntityExpressions the start with entity expressions
     * @return the LogicExpression
     */
    L sw(FiveArgusConsumer<StartWithEntityExpression<E>, StartWithEntityExpression<E2>, StartWithEntityExpression<E3>,
        StartWithEntityExpression<E4>, StartWithEntityExpression<E5>> startWithEntityExpressions);
}