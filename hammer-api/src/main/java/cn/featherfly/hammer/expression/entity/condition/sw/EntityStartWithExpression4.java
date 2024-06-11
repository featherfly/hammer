
package cn.featherfly.hammer.expression.entity.condition.sw;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityStartWithExpression4.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityStartWithExpression4<E, E2, E3, E4, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends EntityStartWithExpressionBase4<E, E2, E3, E4, C, L> {

    /**
     * start with value. 以value开始.
     *
     * @param startWithEntityExpressions the start with entity expressions
     * @return the LogicExpression
     */
    L sw(Consumer<Tuple4<StartWithEntityExpression<E>, StartWithEntityExpression<E2>, StartWithEntityExpression<E3>,
        StartWithEntityExpression<E4>>> startWithEntityExpressions);

    /**
     * start with value. 以value开始.
     *
     * @param startWithEntityExpressions the start with entity expressions
     * @return the LogicExpression
     */
    L sw(FourArgusConsumer<StartWithEntityExpression<E>, StartWithEntityExpression<E2>, StartWithEntityExpression<E3>,
        StartWithEntityExpression<E4>> startWithEntityExpressions);

}