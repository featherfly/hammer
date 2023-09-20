
package cn.featherfly.hammer.expression.entity.condition.nsw;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotStartWithExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotStartWithExpression2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityNotStartWithExpressionBase2<E, E2, C, L> {

    /**
     * not start with value. 不以value开始.
     *
     * @param notStartWithEntityExpressions the not start with entity
     *                                      expressions
     * @return the LogicExpression
     */
    L nsw(Consumer<
            Tuple2<NotStartWithEntityExpression<E>, NotStartWithEntityExpression<E2>>> notStartWithEntityExpressions);

    /**
     * not start with value. 不以value开始.
     *
     * @param notStartWithEntityExpressions the not start with entity
     *                                      expressions
     * @return the LogicExpression
     */
    L nsw(BiConsumer<NotStartWithEntityExpression<E>, NotStartWithEntityExpression<E2>> notStartWithEntityExpressions);
}