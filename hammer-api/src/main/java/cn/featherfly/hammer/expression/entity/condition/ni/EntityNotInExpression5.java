
package cn.featherfly.hammer.expression.entity.condition.ni;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotInExpression5.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotInExpression5<E, E2, E3, E4, E5, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityNotInExpressionBase5<E, E2, E3, E4, E5, C, L> {

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param notInEntityExpressions the not in entity expressions
     * @return the LogicExpression
     */
    L ni(Consumer<Tuple5<NotInEntityExpression<E>, NotInEntityExpression<E2>, NotInEntityExpression<E3>,
            NotInEntityExpression<E4>, NotInEntityExpression<E5>>> notInEntityExpressions);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param notInEntityExpressions the not in entity expressions
     * @return the LogicExpression
     */
    L ni(FiveArgusConsumer<NotInEntityExpression<E>, NotInEntityExpression<E2>, NotInEntityExpression<E3>,
            NotInEntityExpression<E4>, NotInEntityExpression<E5>> notInEntityExpressions);
}