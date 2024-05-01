
package cn.featherfly.hammer.expression.entity.condition.isn;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityIsNullExpression4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityIsNullExpression4<E, E2, E3, E4, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityIsNullExpressionBase4<E, E2, E3, E4, C, L> {

    /**
     * is null.
     *
     * @param isNullEntityExpressions the is null entity expressions
     * @return the LogicExpression
     */
    L isn(Consumer<Tuple4<IsNullEntityExpression<E>, IsNullEntityExpression<E2>, IsNullEntityExpression<E3>, IsNullEntityExpression<E4>>> isNullEntityExpressions);

    /**
     * is null.
     *
     * @param isNullEntityExpressions the is null entity expressions
     * @return the LogicExpression
     */
    L isn(FourArgusConsumer<IsNullEntityExpression<E>, IsNullEntityExpression<E2>, IsNullEntityExpression<E3>, IsNullEntityExpression<E4>> isNullEntityExpressions);
}