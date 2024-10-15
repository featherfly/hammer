
package cn.featherfly.hammer.expression.entity.condition.nba;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotBetweenExpression5.
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
public interface EntityNotBetweenExpression5<E, E2, E3, E4, E5, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityNotBetweenExpressionBase5<E, E2, E3, E4, E5, C, L> {

    /**
     * not between and.
     *
     * @param notBetweenEntityExpressions the not between entity expressions
     * @return the LogicExpression
     */
    L nba(Consumer<Tuple5<NotBetweenEntityExpression<E>, NotBetweenEntityExpression<E2>, NotBetweenEntityExpression<E3>,
            NotBetweenEntityExpression<E4>, NotBetweenEntityExpression<E5>>> notBetweenEntityExpressions);

    /**
     * not between and.
     *
     * @param notBetweenEntityExpressions the not between entity expressions
     * @return the LogicExpression
     */
    L nba(FiveArgusConsumer<NotBetweenEntityExpression<E>, NotBetweenEntityExpression<E2>,
            NotBetweenEntityExpression<E3>, NotBetweenEntityExpression<E4>,
            NotBetweenEntityExpression<E5>> notBetweenEntityExpressions);
}