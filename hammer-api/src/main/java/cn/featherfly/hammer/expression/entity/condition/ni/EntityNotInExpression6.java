
package cn.featherfly.hammer.expression.entity.condition.ni;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotInExpression6.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotInExpression6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityNotInExpressionBase6<E, E2, E3, E4, E5, E6, C, L> {

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param notInEntityExpressions the not in entity expressions
     * @return the LogicExpression
     */
    L ni(Consumer<Tuple6<NotInEntityExpression<E>, NotInEntityExpression<E2>, NotInEntityExpression<E3>,
            NotInEntityExpression<E4>, NotInEntityExpression<E5>, NotInEntityExpression<E6>>> notInEntityExpressions);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param notInEntityExpressions the not in entity expressions
     * @return the LogicExpression
     */
    L ni(SixArgusConsumer<NotInEntityExpression<E>, NotInEntityExpression<E2>, NotInEntityExpression<E3>,
            NotInEntityExpression<E4>, NotInEntityExpression<E5>, NotInEntityExpression<E6>> notInEntityExpressions);
}