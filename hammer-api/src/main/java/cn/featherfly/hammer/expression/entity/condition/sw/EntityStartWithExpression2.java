
package cn.featherfly.hammer.expression.entity.condition.sw;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityStartWithExpression2.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityStartWithExpression2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityStartWithExpressionBase2<E, E2, C, L> {

    /**
     * start with value. 以value开始.
     *
     * @param startWithEntityExpressions the start with entity expressions
     * @return the LogicExpression
     */
    L sw(Consumer<Tuple2<StartWithEntityExpression<E>, StartWithEntityExpression<E2>>> startWithEntityExpressions);

    /**
     * start with value. 以value开始.
     *
     * @param startWithEntityExpressions the start with entity expressions
     * @return the LogicExpression
     */
    L sw(BiConsumer<StartWithEntityExpression<E>, StartWithEntityExpression<E2>> startWithEntityExpressions);
}