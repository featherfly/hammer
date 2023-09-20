
package cn.featherfly.hammer.expression.entity.condition.nsw;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotStartWithExpression3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotStartWithExpression3<E, E2, E3, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityNotStartWithExpressionBase3<E, E2, E3, C, L> {

    /**
     * not start with value. 不以value开始.
     *
     * @param notStartWithEntityExpressions the not start with entity
     *                                      expressions
     * @return the LogicExpression
     */
    L nsw(Consumer<Tuple3<NotStartWithEntityExpression<E>, NotStartWithEntityExpression<E2>,
            NotStartWithEntityExpression<E3>>> notStartWithEntityExpressions);

    /**
     * not start with value. 不以value开始.
     *
     * @param notStartWithEntityExpressions the not start with entity
     *                                      expressions
     * @return the LogicExpression
     */
    L nsw(ThreeArgusConsumer<NotStartWithEntityExpression<E>, NotStartWithEntityExpression<E2>,
            NotStartWithEntityExpression<E3>> notStartWithEntityExpressions);
}