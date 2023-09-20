
package cn.featherfly.hammer.expression.entity.condition.nba;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotBetweenExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotBetweenExpression2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityNotBetweenExpressionBase2<E, E2, C, L> {

    /**
     * not between and.
     *
     * @param notBetweenEntityExpressions the not between entity expressions
     * @return the LogicExpression
     */
    L nba(Consumer<Tuple2<NotBetweenEntityExpression<E>, NotBetweenEntityExpression<E2>>> notBetweenEntityExpressions);

    /**
     * not between and.
     *
     * @param notBetweenEntityExpressions the not between entity expressions
     * @return the LogicExpression
     */
    L nba(BiConsumer<NotBetweenEntityExpression<E>, NotBetweenEntityExpression<E2>> notBetweenEntityExpressions);
}