
package cn.featherfly.hammer.expression.entity.condition.nsw;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityStartWithExpression6.
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
public interface EntityNotStartWithExpression6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityNotStartWithExpressionBase6<E, E2, E3, E4, E5, E6, C, L> {

    /**
     * not start with value. 不以value开始.
     *
     * @param notStartWithEntityExpressions the not start with entity
     *                                      expressions
     * @return the LogicExpression
     */
    L nsw(Consumer<Tuple6<NotStartWithEntityExpression<E>, NotStartWithEntityExpression<E2>,
            NotStartWithEntityExpression<E3>, NotStartWithEntityExpression<E4>, NotStartWithEntityExpression<E5>,
            NotStartWithEntityExpression<E6>>> notStartWithEntityExpressions);

    /**
     * not start with value. 不以value开始.
     *
     * @param notStartWithEntityExpressions the not start with entity
     *                                      expressions
     * @return the LogicExpression
     */
    L nsw(SixArgusConsumer<NotStartWithEntityExpression<E>, NotStartWithEntityExpression<E2>,
            NotStartWithEntityExpression<E3>, NotStartWithEntityExpression<E4>, NotStartWithEntityExpression<E5>,
            NotStartWithEntityExpression<E6>> notStartWithEntityExpressions);
}