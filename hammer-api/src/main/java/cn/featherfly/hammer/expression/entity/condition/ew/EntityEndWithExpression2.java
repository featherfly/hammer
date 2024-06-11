
package cn.featherfly.hammer.expression.entity.condition.ew;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityEndWithExpression2.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityEndWithExpression2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityEndWithExpressionBase2<E, E2, C, L> {

    /**
     * end with value. 以value结尾.
     *
     * @param endWithEntityExpressions the end with entity expressions
     * @return the LogicExpression
     */
    L ew(Consumer<Tuple2<EndWithEntityExpression<E>, EndWithEntityExpression<E2>>> endWithEntityExpressions);

    /**
     * end with value. 以value结尾.
     *
     * @param endWithEntityExpressions the end with entity expressions
     * @return the LogicExpression
     */
    L ew(BiConsumer<EndWithEntityExpression<E>, EndWithEntityExpression<E2>> endWithEntityExpressions);
}