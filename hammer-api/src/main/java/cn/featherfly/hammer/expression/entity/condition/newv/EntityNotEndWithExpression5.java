
package cn.featherfly.hammer.expression.entity.condition.newv;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotEndWithExpression5.
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
public interface EntityNotEndWithExpression5<E, E2, E3, E4, E5, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityNotEndWithExpressionBase5<E, E2, E3, E4, E5, C, L> {

    /**
     * not end with value. 不以value结尾.
     *
     * @param notEndWithEntityExpressions the not end with entity expressions
     * @return the LogicExpression
     */
    L newv(Consumer<
            Tuple5<NotEndWithEntityExpression<E>, NotEndWithEntityExpression<E2>, NotEndWithEntityExpression<E3>,
                    NotEndWithEntityExpression<E4>, NotEndWithEntityExpression<E5>>> notEndWithEntityExpressions);

    /**
     * not end with value. 不以value结尾.
     *
     * @param notEndWithEntityExpressions the not end with entity expressions
     * @return the LogicExpression
     */
    L newv(FiveArgusConsumer<NotEndWithEntityExpression<E>, NotEndWithEntityExpression<E2>,
            NotEndWithEntityExpression<E3>, NotEndWithEntityExpression<E4>,
            NotEndWithEntityExpression<E5>> notEndWithEntityExpressions);
}