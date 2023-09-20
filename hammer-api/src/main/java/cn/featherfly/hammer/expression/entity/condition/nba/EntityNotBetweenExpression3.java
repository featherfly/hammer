
package cn.featherfly.hammer.expression.entity.condition.nba;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotBetweenExpression3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotBetweenExpression3<E, E2, E3, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityNotBetweenExpressionBase3<E, E2, E3, C, L> {

    /**
     * not between and.
     *
     * @param notBetweenEntityExpressions the not between entity expressions
     * @return the LogicExpression
     */
    L nba(Consumer<Tuple3<NotBetweenEntityExpression<E>, NotBetweenEntityExpression<E2>,
            NotBetweenEntityExpression<E3>>> notBetweenEntityExpressions);

    /**
     * not between and.
     *
     * @param notBetweenEntityExpressions the not between entity expressions
     * @return the LogicExpression
     */
    L nba(ThreeArgusConsumer<NotBetweenEntityExpression<E>, NotBetweenEntityExpression<E2>,
            NotBetweenEntityExpression<E3>> notBetweenEntityExpressions);
}