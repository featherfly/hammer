
package cn.featherfly.hammer.expression.entity.condition.isn;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityIsNullExpression3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityIsNullExpression3<E, E2, E3, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityIsNullExpressionBase3<E, E2, E3, C, L> {

    /**
     * is null.
     *
     * @param isNullEntityExpressions the is null entity expressions
     * @return the LogicExpression
     */
    L isn(Consumer<Tuple3<IsNullEntityExpression<E>, IsNullEntityExpression<E2>, IsNullEntityExpression<E3>>> isNullEntityExpressions);

    /**
     * is null.
     *
     * @param isNullEntityExpressions the is null entity expressions
     * @return the LogicExpression
     */
    L isn(ThreeArgusConsumer<IsNullEntityExpression<E>, IsNullEntityExpression<E2>, IsNullEntityExpression<E3>> isNullEntityExpressions);
}