
package cn.featherfly.hammer.expression.entity.condition.nba;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotBetweenExpression4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotBetweenExpression4<E, E2, E3, E4, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityNotBetweenExpressionBase4<E, E2, E3, E4, C, L> {

    /**
     * not between and.
     *
     * @param notBetweenEntityExpressions the not between entity expressions
     * @return the LogicExpression
     */
    L nba(Consumer<Tuple4<NotBetweenEntityExpression<E>, NotBetweenEntityExpression<E2>, NotBetweenEntityExpression<E3>,
            NotBetweenEntityExpression<E4>>> notBetweenEntityExpressions);

    /**
     * not between and.
     *
     * @param notBetweenEntityExpressions the not between entity expressions
     * @return the LogicExpression
     */
    L nba(FourArgusConsumer<NotBetweenEntityExpression<E>, NotBetweenEntityExpression<E2>,
            NotBetweenEntityExpression<E3>, NotBetweenEntityExpression<E4>> notBetweenEntityExpressions);
}