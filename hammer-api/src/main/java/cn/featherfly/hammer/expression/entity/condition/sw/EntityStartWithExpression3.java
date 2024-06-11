
package cn.featherfly.hammer.expression.entity.condition.sw;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityStartWithExpression3.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityStartWithExpression3<E, E2, E3, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityStartWithExpressionBase3<E, E2, E3, C, L> {

    /**
     * start with value. 以value开始.
     *
     * @param startWithEntityExpressions the start with entity expressions
     * @return the LogicExpression
     */
    L sw(Consumer<Tuple3<StartWithEntityExpression<E>, StartWithEntityExpression<E2>,
        StartWithEntityExpression<E3>>> startWithEntityExpressions);

    /**
     * start with value. 以value开始.
     *
     * @param startWithEntityExpressions the start with entity expressions
     * @return the LogicExpression
     */
    L sw(ThreeArgusConsumer<StartWithEntityExpression<E>, StartWithEntityExpression<E2>,
        StartWithEntityExpression<E3>> startWithEntityExpressions);
}