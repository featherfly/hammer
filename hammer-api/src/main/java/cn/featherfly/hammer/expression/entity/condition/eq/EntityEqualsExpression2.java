
package cn.featherfly.hammer.expression.entity.condition.eq;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityEqualsExpression2.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityEqualsExpression2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityEqualsExpressionBase2<E, E2, C, L> {

    /**
     * equals. 等于.
     *
     * @param equalsEntityExpressions the equals entity expressions
     * @return the LogicExpression
     */
    L eq(Consumer<Tuple2<EqualsEntityExpression<E>, EqualsEntityExpression<E2>>> equalsEntityExpressions);

    /**
     * equals. 等于.
     *
     * @param equalsEntityExpressions the equals entity expressions
     * @return the LogicExpression
     */
    L eq(BiConsumer<EqualsEntityExpression<E>, EqualsEntityExpression<E2>> equalsEntityExpressions);
}