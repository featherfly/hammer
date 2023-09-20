
package cn.featherfly.hammer.expression.entity.condition.newv;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotEndWithExpression6.
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
public interface EntityNotEndWithExpression6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityNotEndWithExpressionBase6<E, E2, E3, E4, E5, E6, C, L> {

    /**
     * not end with value. 不以value结尾.
     *
     * @param notEndWithEntityExpressions the not end with entity expressions
     * @return the LogicExpression
     */
    L newv(Consumer<Tuple6<NotEndWithEntityExpression<E>, NotEndWithEntityExpression<E2>,
            NotEndWithEntityExpression<E3>, NotEndWithEntityExpression<E4>, NotEndWithEntityExpression<E5>,
            NotEndWithEntityExpression<E6>>> notEndWithEntityExpressions);

    /**
     * not end with value. 不以value结尾.
     *
     * @param notEndWithEntityExpressions the not end with entity expressions
     * @return the LogicExpression
     */
    L newv(SixArgusConsumer<NotEndWithEntityExpression<E>, NotEndWithEntityExpression<E2>,
            NotEndWithEntityExpression<E3>, NotEndWithEntityExpression<E4>, NotEndWithEntityExpression<E5>,
            NotEndWithEntityExpression<E6>> notEndWithEntityExpressions);
}