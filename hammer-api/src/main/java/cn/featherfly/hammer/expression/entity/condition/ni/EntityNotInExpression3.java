
package cn.featherfly.hammer.expression.entity.condition.ni;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotInExpression3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotInExpression3<E, E2, E3, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityNotInExpressionBase3<E, E2, E3, C, L> {

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param notInEntityExpressions the not in entity expressions
     * @return the LogicExpression
     */
    L ni(Consumer<Tuple3<NotInEntityExpression<E>, NotInEntityExpression<E2>,
            NotInEntityExpression<E3>>> notInEntityExpressions);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param notInEntityExpressions the not in entity expressions
     * @return the LogicExpression
     */
    L ni(ThreeArgusConsumer<NotInEntityExpression<E>, NotInEntityExpression<E2>,
            NotInEntityExpression<E3>> notInEntityExpressions);
}