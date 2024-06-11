
package cn.featherfly.hammer.expression.entity.condition.ne;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotEqualsExpression5.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityNotEqualsExpression5<E, E2, E3, E4, E5, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends EntityNotEqualsExpressionBase5<E, E2, E3, E4, E5, C, L> {

    /**
     * equals. 等于.
     *
     * @param notEqualsEntityExpressions the not equals entity expressions
     * @return the LogicExpression
     */
    L ne(Consumer<Tuple5<NotEqualsEntityExpression<E>, NotEqualsEntityExpression<E2>, NotEqualsEntityExpression<E3>,
        NotEqualsEntityExpression<E4>, NotEqualsEntityExpression<E5>>> notEqualsEntityExpressions);

    /**
     * equals. 等于.
     *
     * @param notEqualsEntityExpressions the not equals entity expressions
     * @return the LogicExpression
     */
    L ne(FiveArgusConsumer<NotEqualsEntityExpression<E>, NotEqualsEntityExpression<E2>, NotEqualsEntityExpression<E3>,
        NotEqualsEntityExpression<E4>, NotEqualsEntityExpression<E5>> notEqualsEntityExpressions);

}