
package cn.featherfly.hammer.expression.entity.condition.newv;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotEndWithExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotEndWithExpression2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityNotEndWithExpressionBase2<E, E2, C, L> {

    /**
     * not end with value. 不以value结尾.
     *
     * @param notEndWithEntityExpressions the not end with entity expressions
     * @return the LogicExpression
     */
    L newv(Consumer<Tuple2<NotEndWithEntityExpression<E>, NotEndWithEntityExpression<E2>>> notEndWithEntityExpressions);

    /**
     * not end with value. 不以value结尾.
     *
     * @param notEndWithEntityExpressions the not end with entity expressions
     * @return the LogicExpression
     */
    L newv(BiConsumer<NotEndWithEntityExpression<E>, NotEndWithEntityExpression<E2>> notEndWithEntityExpressions);
}